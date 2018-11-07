<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/myutils.js"></script>
    <script>

        $(function () {

            $("#addDataBtn").click(function () {

                var formData = $("#formId").serialize();
                console.log(formData);
                $.ajax({
                    url:"account/add",
                    data: formData,
                    type:"post",
                    dataType:"json",
                    success:function(data){
                        // data服务器端响应的json的数据，进行解析
                        if(data.success) {
                            location.href="accountList/findAll";
                        }
                        alert(data.message);
                    }
                });

            });

            $("#addJsonDataBtn").click(function () {

                var jsonStr = $("#formId").serializeJson();
                console.log(jsonStr);
                var jsonObj = JSON.stringify(jsonStr);

                $.ajax({
                    url:"account/addJsonParam",
                    contentType:"application/json;charset=UTF-8",
                    data: jsonObj,
                    dataType:"json",
                    type:"post",
                    success:function(data){
                        // data服务器端响应的json的数据，进行解析
                        if(data.success) {
                            location.href="accountList/findAll";
                        }
                        alert(data.message);
                    }
                });
            });

        });


    </script>
</head>
<body>
<h2>Hello World!</h2>

    <hr/>
    数据测试
    <form id="formId">
        id:<input type="text" name="id" value="1"/>
        姓名：<input type="text" name="name" /><br/>
        金额：<input type="text" name="money" /><br/>
    </form>

    <hr/>
    <button id="addDataBtn">添加k-v数据</button>
    <hr/>
    <button id="addJsonDataBtn">添加JSON数据</button>


    <hr/>
    查看account列表
    <<a href="accountList/findAll"> 查看account列表</a>


    <hr/>





</body>
</html>
