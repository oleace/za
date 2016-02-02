<%@ tag import="org.canedata.core.util.StringUtils" %>
<%@ tag display-name="master"
        body-content="scriptless"
        pageEncoding="utf-8"
        language="java"
        %>

<%@ attribute name="id" required="false" type="java.lang.String" %>
<%@ attribute name="icon" required="false"  type="java.lang.String"%>
<%@ attribute name="title" required="false"  type="java.lang.String"%>
<%@ attribute name="toggle" required="false" type="java.lang.Boolean"%>
<%@ attribute name="style" required="false"  type="java.lang.String"%>

<%@ attribute name="dock" required="false"  fragment="true"%>
<%@ attribute name="contentStyle" required="false"  type="java.lang.String"%>
<%@ attribute name="titleBarStyle" required="false"  type="java.lang.String"%>
<%@ attribute name="titleStyle" required="false" type="java.lang.String" %>
<%@ attribute name="dockStyle" required="false" type="java.lang.String" %>

<%----------------------
usage 1:
<layout:block title="title">
    <jsp:attribute name="dock">
        html...
    </jsp:attribute>
    <jsp:body>
        html...
    </jsp:body>
</layout:master>

usage 2:
<layout:block title="title">
    html...
</layout:master>

----------------------%>
<%@ taglib uri="jstl-core" prefix="c"%>

<c:set var="randStr" value="<%=StringUtils.random(4, new char[]{'a','b','c','d','e','f','g'})%>"></c:set>
<c:set var="bid" value="psblockId-${randStr}"></c:set>

<c:if test="${empty toggle}">
    <c:set var="toggle" value="${false}"></c:set>
</c:if>

<section class="${empty style?"ps-block":style}" id="${id}">
    <c:if test="${not empty title or not empty dock}">
    <div class="titleBar" style="${titleBarStyle}">
        <div class="title" style="${titleStyle}"
             onclick="$('.idt${bid}').toggleClass('glyphicon-chevron-up glyphicon-chevron-down');$('#${bid}').toggle(200);">
        <c:if test="${toggle}">
            <a href="javascript:" title="隐藏/显示">${title}
                    <span class="idt${bid} glyphicon glyphicon-chevron-up"></span>
                </a>
            </c:if>
            <c:if test="${not toggle}">${title}</c:if>
        </div>
        <div class="dock" style="${not empty dockStyle?dockStyle:''}"><jsp:invoke fragment="dock"/></div>
    </div>
    </c:if>

    <div id="${bid}" class="body" style="${contentStyle}">
    <jsp:doBody/>
    </div>
</section>