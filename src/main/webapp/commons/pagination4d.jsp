<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="com.github.moor.paging.Pagination" %>
<%@ page import="com.github.moor.paging.Pager" %>


<%@ taglib uri="jstl-core" prefix="c"%>
<%@ taglib uri="jstl-fmt" prefix="fmt"%>

<c:set var="path" value="${pageContext.request.contextPath}"></c:set>

<%
    Pagination p = Pager.page();


int count = p.getItemCount();

int size = p.getPageSize();

int pageCount = p.getPageCount();

int curPage= p.getCurrentPage();

int prePage=0,nextPage=0;
prePage=curPage-1;
nextPage=curPage+1;
prePage=prePage<=0?-1:prePage;
nextPage=nextPage>pageCount?-1:nextPage;

String formname=request.getParameter("formId");
%>


<div id="paginationBar">
<nobr>

		&nbsp;  <%=count%> 条记录&nbsp;&nbsp;|&nbsp;&nbsp;共&nbsp;<%=pageCount%>&nbsp;页&nbsp;第
		<select id="<%=formname %>PAGINATION_CURRENTPAGE" name="PAGINATION_CURRENTPAGE" style="width:50px;font-size:0.8em" onChange="new Pagination('<%=formname %>').changePage(this.value);">
		  <%for(int i=0;i<pageCount;i++){%>
		  <option value="<%=i+1%>" <%if(i+1==curPage){%> selected<%}%>><%=i+1%></option>
		  <%}%>
		</select>
		页&nbsp;
    <label onclick="<%=prePage>0?"new Pagination('"+formname+"').changePage("+prePage+")":""%>">
        <a <%=prePage>0?"href=''":""%> onclick="return false;">前一页</a>
    </label>
    <label onClick="<%=nextPage>0?"new Pagination('"+formname+"').changePage("+nextPage+")":""%>">
        <a <%=nextPage>0?"href=''":""%> onclick="return false;">后一页</a>
    </label>
    &nbsp;|&nbsp;

			<a href="javascript:new Pagination('<%=formname %>').changePage(1);" title="设定页面显示记录数……">每页显示</a>&nbsp;<input id="<%=formname %>PAGINATION_PAGESIZE" type="text" name="PAGINATION_PAGESIZE" value='<%=size%>' size="3" style="font-size:0.8em"/> 条

</nobr>

</div>


