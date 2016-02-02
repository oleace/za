<%@ tag import="com.boya.commons.TimeUitls" %>
<%@ tag display-name="master"
        body-content="scriptless"
        pageEncoding="utf-8"
        language="java"
        %>

<%@ attribute name="time" required="true"  type="java.lang.Long"%>

<%----------------------
usage 1:
<util:time time="${time}"></util:time>

----------------------%>
<%=TimeUitls.getInterval(time)%>
