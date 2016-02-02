<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="jstl-core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib tagdir="/WEB-INF/tags/widgets" prefix="w" %>
<%@ taglib uri="jstl-fmt" prefix="fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>

<fmt:setBundle basename="conf/messages" var="msg"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="icon" type="image/x-icon" href="${path }/favicon.ico" />
    <link rel="shortcut icon" type="image/x-icon" href="${path }/favicon.ico" />

    <title>出错了。。</title>
    <link href="${path }/static/bootstrap331/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="${path }/static/sweetAlert/sweet-alert.css" rel="stylesheet" type="text/css" />
    <link href="${path }/static/css/comm.css?v=3" rel="stylesheet" type="text/css" />

    <script src="${path }/static/jquery/jquery-1.11.0.min.js" type="text/javascript"></script>
    <script src="${path }/static/bootstrap331/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="${path }/static/jquery/jquery.toaster.js?v=0.2" type="text/javascript"></script>
    <script src="${path }/static/sweetAlert/sweet-alert.min.js" type="text/javascript"></script>
    <script src="${path }/static/js/pagination.js" type="text/javascript"></script>
    <script src="${path }/static/js/reelUtils.js?v=1.8" type="text/javascript"></script>
    <script src="${path }/static/js/bootbox.min.js" type="text/javascript"></script>
    <script src="${path }/static/js/jquery.bpopup.min.js" type="text/javascript"></script>
</head>
<body>
<div class="container">
    <br/>
    <div class="row">
        <div class="panel panel-warning">
            <div class="panel-heading">
                <a href="${path }/das/advice/6/initAdvice"  class="btn btn-success">反馈</a>
            </div>
            <div class="panel-body" style="text-align: center">
                <img src="${path }/static/images/error.jpg">
            </div>
        </div>
    </div>
</div>
</body>
</html>