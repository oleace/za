<%@ tag display-name="master"
        body-content="scriptless"
        pageEncoding="utf-8"
        language="java"
        %>

<%@ attribute name="icon" required="false" type="java.lang.String" %>
<%@ attribute name="title" required="false" type="java.lang.String" %>
<%@ attribute name="dock" required="false" fragment="true" %>

<%----------------------
usage 1:
<layout:master title="title">
    <jsp:attribute name="dock">
        html...
    </jsp:attribute>
    <jsp:body>
        html...
    </jsp:body>
</layout:master>

usage 2:
<layout:master title="title">
    html...
</layout:master>

----------------------%>
<%@ taglib uri="jstl-core" prefix="c" %>

<div class="panel panel-default main-content" style="margin: 2px 4em">
    <div class="panel-heading contentTitle">
        <h3 class="title">${title}</h3>

        <div class="dock">
            <jsp:invoke fragment="dock"/>
        </div>
    </div>
    <div class="panel-body master-body">
        <jsp:doBody/>
    </div>
</div>