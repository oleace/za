<%@ tag import="com.boya.commons.TimeUitls" %>
<%@ tag import="com.boya.commons.Constant" %>
<%@ tag display-name="master"
        body-content="scriptless"
        pageEncoding="utf-8"
        language="java"
        %>

<%@ attribute name="where" required="true"  type="java.lang.String"%>

<%----------------------
usage 1:
<util:time time="${time}"></util:time>

----------------------%>
<%=Constant.countyNames.get(where)%>
