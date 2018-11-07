package com.itheima.test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;

/**
 * Created by crowndint on 2018/11/6.
 */
public class TestUpload {
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

        byte[] bytes = FileUtils.readFileToByteArray(file);

        // 上传文件
        webResource.put(bytes);

    }

}
