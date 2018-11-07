package com.itheima.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.domain.User;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import com.sun.jersey.multipart.FormDataBodyPart;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.file.FileDataBodyPart;
import com.sun.jersey.multipart.impl.MultiPartWriter;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import javax.ws.rs.core.MediaType;
import java.io.*;
import java.util.Date;

public class TestApp {

    private String url ="http://localhost:8086/testRestful";

    @Test
    public void testPost() {

        Client client = Client.create();
        WebResource webResource = client.resource(url);
//        webResource.queryParam("uname", "黑马");
//        webResource.post();

        MultivaluedMapImpl params =new MultivaluedMapImpl();
        params.add("uname", "龙泽");
        String content = webResource.type(MediaType.APPLICATION_FORM_URLENCODED).post(String.class, params);
        System.out.println(content);
    }

    @Test
    public void testPut() {

        Client client = Client.create();
        WebResource webResource = client.resource(url);
//        webResource.queryParam("uname", "黑马");
//        webResource.put();
        MultivaluedMapImpl params =new MultivaluedMapImpl();
        params.add("uname", "龙泽");
        String content = webResource.type(MediaType.APPLICATION_FORM_URLENCODED).put(String.class, params);
        System.out.println(content);
    }


    @Test
    public void testDelete() {

        Client client = Client.create();
        WebResource webResource = client.resource(url+"/100");
        //webResource.delete();
        String content = webResource.type(MediaType.APPLICATION_FORM_URLENCODED).delete(String.class);
        System.out.println(content);
    }


    @Test
    public void testGet() throws JsonProcessingException {

        Client client = Client.create();
        WebResource webResource = client.resource(url+"/100");

        String s = webResource.get(String.class);
        System.out.println(s);

    }

    /*
            returned a response status of 403 Forbidden
            因为tomcat默认禁止上传,在tomcat配置文件web.xml配置一下就好了
            Tomcat web.xml 113 行加上

            <init-param>
               <param-name>readonly</param-name>
               <param-value>false</param-value>
            </init-param>
    */
    @Test
    public void testUpload1() throws Exception {

        File file = new File("C:\\upload\\jdbcConfig.properties\\");

        String path = "http://localhost:8080/uploads/";
        Client client = Client.create();
        WebResource webResource = client.resource(path + file.getName());

//        FileInputStream fileInputStream = new FileInputStream(file);
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        byte[] buf = new byte[1024];
//        int length = -1;
//        while ((length=fileInputStream.read(buf))!=-1) {
//            byteArrayOutputStream.write(buf, 0 , length);
//        }
 //       byte[] bytes = byteArrayOutputStream.toByteArray();

        byte[] bytes = FileUtils.readFileToByteArray(file);

        // 上传文件
        webResource.put(bytes);

    }

    @Test
    public void testUpload() {

        File file = new File("c:/pic/test.jpg");
        System.out.println(file.exists());
        FormDataMultiPart part = new FormDataMultiPart();
        part.bodyPart(new FileDataBodyPart("file", file));
        part.bodyPart(new FormDataBodyPart("myparam", "false"));

        ClientConfig cc = new DefaultClientConfig();
        cc.getClasses().add(MultiPartWriter.class);
        Client writerClient = Client.create(cc);
        // 处理文件将超时设置为10S
        writerClient.setConnectTimeout(new Integer(3000));
        writerClient.setReadTimeout(new Integer(3000));
        try {
            WebResource resource = writerClient.resource("http://127.0.0.1:8080/rest/upload");
            String response = resource.type(MediaType.MULTIPART_FORM_DATA_TYPE).post(String.class, part);
            System.out.println(response);
        } finally {
            writerClient.destroy();
        }

    }

}
