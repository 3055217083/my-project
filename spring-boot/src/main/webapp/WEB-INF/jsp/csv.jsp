<%--
  User: zhixian.song
  Date: 2021.8.31
  Time: 9:35
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>csv,yse</title>
    <%@include file="headIncludeLayuiJS.jsp" %>
    <script type="text/javascript" src="/static/csv.js?ver=${timestamp}"></script>
</head>
<body>
<div class="layui-container" style="margin-top: 20px">
    <div class="layui-row">
        <div class="layui-col-md12">
            <i id="tips">
                <i class="layui-icon" style=" color: #EC808D;">&#xe60b;</i>
                <span style="text-decoration:underline;color:#EC808D;" id="tip">说明</span>
            </i>

            <button class="layui-btn up" lay-event="upload">上传csv</button>
        </div>

    </div>
</div>

<div id="u123_text" class="text" hidden>
    <p><span style="color:#000000;">1</span></p>
    <p><span style="color:#000000;">2. </span><span style="color:#D9001B;">懂？</span>
</div>
</body>
</html>
