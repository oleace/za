<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="jstl-core" prefix="c" %>
<%@ taglib uri="jstl-fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout"%>

<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<fmt:setBundle basename="conf/messages" var="msg"/>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="icon" type="image/x-icon" href="${path }/favicon.ico" />
    <link rel="shortcut icon" type="image/x-icon" href="${path }/favicon.ico" />
    <jsp:include page="commRes.jsp"></jsp:include>
    <title>首页 - <fmt:message key="app.name" bundle="${msg }"/></title>
    <style type="text/css">
        .navboxindex{
            position: relative;
            float: left;
        }

        ul.navindex {
            list-style: none;
            display: block;
            width: 200px;
            position: relative;
            left: 100px;
            padding: 60px 0 60px 0;
            background: url(${path }/static/images/shad2.png) no-repeat;
            -webkit-background-size: 50% 100%;
        }

        li {
            margin: 5px 0 0 0;
        }

        ul.navindex li a {
            -webkit-transition: all 0.3s ease-out;
            background: #cbcbcb url(${path }/static/images/border.png) no-repeat;
            color: #174867;
            padding: 7px 15px 7px 15px;
            -webkit-border-top-right-radius: 10px;
            -webkit-border-bottom-right-radius: 10px;
            width: 110px;
            display: block;
            text-decoration: none;
            -webkit-box-shadow: 2px 2px 4px #888;
        }

        ul.navindex li a:hover {
            background: #ebebeb url(${path }/static/images/border.png) no-repeat;
            color: #67a5cd;
            padding: 7px 15px 7px 30px;
        }

    </style>
</head>
<body >
<jsp:include	page="/mgt/home/header.jsp" />
<div class="navboxindex">
    <ul class="navindex">
        <li><a href="${path}/cms/rotation/index">轮播管理</a></li>
        <li><a href="${path}/cms/user/index">新闻管理</a></li>
        <li><a href="${path}/cms/video/index">视频管理</a></li>
        <li><a href="${path}/cms/tvChannel/index">电视频道</a></li>
        <li><a href="${path}/cms/app/app/index">应用管理</a></li>
        <li><a href="${path}/cms/app/game/index">游戏管理</a></li>
        <li><a href="${path}/cms/app/novel/index">小说管理</a></li>
        <li><a href="${path}/cms/seminar/index">专题管理</a></li>
        <li><a href="${path}/cms/portal/index">门户管理</a></li>
    </ul>
</div>
<div class="navboxindex">
    <ul class="navindex">
        <li><a href="">设备管理</a></li>
    </ul>
</div>
<div class="navboxindex">
    <ul class="navindex">
        <li><a href="">内容分发</a></li>
    </ul>
</div>
<div class="navboxindex">
    <ul class="navindex">
        <li><a href="">广告投放</a></li>
    </ul>
</div>
<div class="navboxindex">
    <ul class="navindex">
        <li><a href="">数据分析</a></li>
    </ul>
</div>
<div class="navboxindex">
    <ul class="navindex">
        <li><a href="${path}/cms/clazz/index">分类管理</a></li>
        <li><a href="${path}/logs/index">日志管理</a></li>
    </ul>
</div>
</body>
</html>
