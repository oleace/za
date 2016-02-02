<%@ tag display-name="slave"
        body-content="scriptless"
        pageEncoding="utf-8"
        language="java"
        %>

<%@ attribute name="navIcon" required="false" type="java.lang.String" %>
<%@ attribute name="navTitle" required="true" type="java.lang.String" %>
<%@ attribute name="navBody" required="false" fragment="true" %>

<%@ attribute name="icon" required="false" type="java.lang.String" %>
<%@ attribute name="title" required="true" type="java.lang.String" %>
<%@ attribute name="dock" required="false" fragment="true" %>

<%----------------------
usage:
<layout:slave title="title" navTitle="nav title">
    <jsp:attribute name="navBody">
        html...
    </jsp:attribute>
    <jsp:attribute name="dock">
        html...
    </jsp:attribute>
    <jsp:body>
        html...
    </jsp:body>
</layout:master>

@author sunyitao 2014-03-14
----------------------%>
<%@ taglib uri="jstl-core" prefix="c" %>

<div class="row main-content" style="margin: 2px 4em">
    <div class="col-md-2 panel panel-default" style="padding: 0px;margin: 0px;">
        <div class="panel-heading contentTitle">
            <h3 class="title">${navTitle}</h3>
        </div>
        <div class="panel-body master-body">
            <jsp:invoke fragment="navBody"/>
        </div>
    </div>
    <div class="col-md-10 panel panel-default" style="padding: 0px;margin: 0px;">
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
</div>