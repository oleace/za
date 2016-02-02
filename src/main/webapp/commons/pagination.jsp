<%@ page import="com.github.moor.paging.Pagination" %>
<%@ page import="com.github.moor.paging.Pager" %>
<%----------------------------------------------------
	Pagination
	
	Sun Yatton
	2008-3-11 11:30
 --%>
<%@ page contentType="text/html; charset=gbk" %>

<%@ taglib uri="jstl-core" prefix="c" %>
<%@ taglib uri="jstl-fmt" prefix="fmt"  %>
<%@ taglib uri="jstl-m" prefix="m"  %>

<fmt:setBundle basename="conf/messages" var="msg"/>
<%
    Pagination pagination = Pager.page();
    request.setAttribute("PAGINATION_PAGER",pagination);
%>
<c:set value="${PAGINATION_PAGER}" var="p"></c:set>

<c:set var="uri" value="${param.uri }"></c:set>
<c:set var="barItems" value="${10}"></c:set>

<c:if test="${p.pageCount <= barItems}">
	<c:set var="s" value="1" ></c:set>
	<c:set var="end" value="${p.pageCount}"></c:set>
</c:if>

<c:if test="${p.pageCount > barItems}">
	<c:set var="nextItems" value="${p.pageCount - p.currentPage}"></c:set>
	<c:set var="mid" value="${m:round(barItems/2)}"></c:set>
	<c:set var="s" value="${(p.currentPage - mid) < 1?1:(p.currentPage - mid)}" ></c:set>
	<c:set var="end" value="${s + barItems - 1}"></c:set>
	<c:set var="end" value="${(end > p.pageCount)?(p.pageCount):end}"></c:set>
	<c:set var="s" value="${end - barItems + 1 }"></c:set>
	<c:set var="s" value="${s < 1?1:s }"></c:set>
</c:if>

<div class="paginationBar">
    <ul class="pagination pull-right">
	<c:if test="${p.currentPage <= 1}">
		<li ><a class="disabled"><fmt:message key="page.previous" bundle="${msg}"></fmt:message></a></li>
	</c:if>
	<c:if test="${p.currentPage > 1}">
        <li><a href="${uri}?PAGINATION_CURRENTPAGE=${p.currentPage - 1 }" class="n"><fmt:message key="page.previous" bundle="${msg}"></fmt:message></a></li>
	</c:if>

	<c:if test="${p.pageCount > barItems && s >= p.pageCount/10}">
        <li><a href="${uri}?PAGINATION_CURRENTPAGE=1" class="n"><c:out value="1"></c:out></a></li>
	</c:if>
	
	<c:forEach var="i" begin="${s}" end="${end}" step="1">
		<c:if test="${p.currentPage == i }">
			<c:set var="curStyle" value="current"></c:set>
		</c:if>
		<c:if test="${p.currentPage != i}">
			<c:set var="curStyle" value=""></c:set>
		</c:if>

        <li><a  href="${uri }?PAGINATION_CURRENTPAGE=${ i }" class="${curStyle}"><c:out value="${i}"></c:out></a></li>
	</c:forEach>
	
	<c:if test="${p.pageCount > barItems && end < p.pageCount}">

        <li><a href="${uri}?PAGINATION_CURRENTPAGE=${p.pageCount }" class="n"><c:out value="${p.pageCount }"></c:out></a></li>
	</c:if>
	
	<c:if test="${p.currentPage >= p.pageCount}">
        <li><a class="disabled"><fmt:message key="page.next" bundle="${msg}"></fmt:message></a></li>
	</c:if>
	<c:if test="${p.currentPage < p.pageCount}">
        <li><a href="${uri}?PAGINATION_CURRENTPAGE=${p.currentPage + 1 }" class="n"><fmt:message key="page.next" bundle="${msg}"></fmt:message></a></li>
	</c:if>

  </ul>

</div>


