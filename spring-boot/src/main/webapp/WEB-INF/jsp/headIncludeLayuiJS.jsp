<%@page pageEncoding="UTF-8" import="java.util.Date" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    request.setAttribute("timestamp", new Date().getTime());
%>
<link rel="stylesheet" href="/static/js/layui/css/layui.css?ver=${timestamp}">
<script type="text/javascript" src="/static/js/layui/layui.js?ver=${timestamp}"></script>