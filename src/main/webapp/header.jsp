<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib uri="jstl-core" prefix="c" %>

<c:set var="path" value="${pageContext.request.contextPath}"></c:set>

<header class="row header">
    <div class="navbar-header" style="padding-left: 5px;padding-top: 5px">
        <img src="${path}/static/images/boyaLogo.png">
    </div>
    <ul class="nav navbar-nav">
        <li><a href="${path}/start" class="icon-th" style="font-size: 1.6em"></a></li>
    </ul>
    <ul class="nav navbar-nav">
        <li class="dropdown">
            <a id="drop1" href="#" role="button" class="dropdown-toggle" style="color: #929292" data-toggle="dropdown">内容管理<b class="caret"></b></a>
            <ul class="dropdown-menu" role="menu" aria-labelledby="drop1">
                <li role="presentation"><a role="menuitem" tabindex="-1" href="${path}/cms/portal/index">门户管理</a></li>
                <li role="presentation"><a role="menuitem" tabindex="-1" href="${path}/cms/rotation/index">轮播管理</a></li>
                <li role="presentation"><a role="menuitem" tabindex="-1" href="${path}/cms/seminar/index">专题管理</a></li>
                <li class="divider"></li>
                <li role="presentation"><a role="menuitem" tabindex="-1" href="${path}/cms/user/index">新闻管理</a></li>
                <li role="presentation"><a role="menuitem" tabindex="-1" href="${path}/cms/video/index">视频管理</a></li>
                <li role="presentation"><a role="menuitem" tabindex="-1" href="${path}/cms/tvChannel/index">电视频道</a></li>
                <li role="presentation"><a role="menuitem" tabindex="-1" href="${path}/cms/app/app/index">应用管理</a></li>
                <li role="presentation"><a role="menuitem" tabindex="-1" href="${path}/cms/magazines/index">杂志管理</a></li>
                <li role="presentation"><a role="menuitem" tabindex="-1" href="${path}/cms/app/game/index">游戏管理</a></li>
                <li role="presentation"><a role="menuitem" tabindex="-1" href="${path}/cms/app/novel/index">小说管理</a></li>
                <li role="presentation"><a role="menuitem" tabindex="-1" href="${path}/cms/albums/index">音乐专栏</a></li>
                <li role="presentation"><a role="menuitem" tabindex="-1" href="${path}/cms/music/index">音乐管理</a></li>
                <%--<li class="divider"></li>--%>
                <%--<li role="presentation"><a role="menuitem" tabindex="-1" href="${path}/cms/mall/index">商城管理</a></li>--%>
                <li class="divider"></li>
                <li role="presentation"><a role="menuitem" tabindex="-1" href="${path}/cms/vote/index">投票管理</a></li>
                <li role="presentation"><a role="menuitem" tabindex="-1" href="${path}/cms/questionnaire/index">问卷管理</a></li>
                <%--<li role="presentation"><a role="menuitem" tabindex="-1" href="${path}/das/vaq/index">投票/问卷</a></li>--%>
                <%--<li role="presentation"><a role="menuitem" tabindex="-1" href="${path}/cms/magazineArticle/index">杂志文章管理</a></li>--%>

                <%--<li role="presentation"><a role="menuitem" tabindex="-1" href="${path}/cms/release/index">发布包管理</a></li>--%>
                <%--<li role="presentation"><a role="menuitem" tabindex="-1" href="${path}/cms/cc/index">分类首页管理</a></li>--%>
            </ul>
        </li>
        <li class="dropdown">
            <a href="#" id="drop5" role="button" class="dropdown-toggle" style="color: #929292" data-toggle="dropdown">设备管理<b
                    class="caret"></b></a>
            <%--<ul class="dropdown-menu" role="menu" aria-labelledby="drop5">--%>

                <%--<li role="presentation"><a role="menuitem" tabindex="-1" href="${path}/cms/tvChannel/index">商铺管理</a></li>--%>
            <%--</ul>--%>
        </li>
        <li class="dropdown">
            <a href="#" id="drop5" role="button" class="dropdown-toggle" style="color: #929292" data-toggle="dropdown">内容分发<b
                    class="caret"></b></a>
            <%--<ul class="dropdown-menu" role="menu" aria-labelledby="drop5">--%>

            <%--</ul>--%>
        </li>
        <li class="dropdown">
            <a href="#" id="drop5" role="button" class="dropdown-toggle" style="color: #929292" data-toggle="dropdown">广告投放<b
                    class="caret"></b></a>
            <%--<ul class="dropdown-menu" role="menu" aria-labelledby="drop5">--%>

            <%--</ul>--%>
        </li>
        <li class="dropdown">
            <a href="#" id="drop5" role="button" class="dropdown-toggle" style="color: #929292" data-toggle="dropdown">数据分析<b class="caret"></b></a>
            <ul class="dropdown-menu" role="menu" aria-labelledby="drop5">
                <li role="presentation"><a role="menuitem" tabindex="-1" href="${path}/das/advice/index">用户反馈</a></li>
            </ul>
        </li>
        <%--<li class="dropdown">--%>
            <%--<a href="#" id="drop5" role="button" class="dropdown-toggle" style="color: #929292" data-toggle="dropdown">统计分析<b class="caret"></b></a>--%>
            <%--<ul class="dropdown-menu" role="menu" aria-labelledby="drop5">--%>
                <%--<li role="presentation"><a role="menuitem" tabindex="-1" href="#">统计分析</a></li>--%>
                <%--<li role="presentation"><a role="menuitem" tabindex="-1" href="#">游戏统计</a></li>--%>
                <%--<li role="presentation"><a role="menuitem" tabindex="-1" href="#">小说统计</a></li>--%>
                <%--<li role="presentation"><a role="menuitem" tabindex="-1" href="#">新闻统计</a></li>--%>
                <%--<li role="presentation"><a role="menuitem" tabindex="-1" href="#">访问统计</a></li>--%>
                <%--<li role="presentation"><a role="menuitem" tabindex="-1" href="#">视频统计</a></li>--%>
                <%--<li role="presentation"><a role="menuitem" tabindex="-1" href="#">广告统计</a></li>--%>
            <%--</ul>--%>
        <%--</li>--%>
        <li class="dropdown">
            <a href="#" id="drop5" role="button" class="dropdown-toggle" style="color: #929292" data-toggle="dropdown">设置<b class="caret"></b></a>
            <ul class="dropdown-menu" role="menu" aria-labelledby="drop5">
                <li role="presentation"><a role="menuitem" tabindex="-1"  href="${path}/cms/clazz/index">分类管理</a></li>
                <li class="divider"></li>
                <li role="presentation"><a role="menuitem" tabindex="-1" href="${path}/logs/index">日志管理</a></li>
                <%--<li role="presentation"><a role="menuitem" tabindex="-1" href="#">密码管理</a></li>--%>
            </ul>
        </li>
    </ul>
    <ul class="nav navbar-nav navbar-right" style="padding-right: 10px">
        <li role="presentation"><a role="menuitem" style="color: #929292"  class="icon-user" tabindex="-1" href="#">&nbsp;${user.name}</a></li>
        <li role="presentation"><a role="menuitem" style="color: #929292" tabindex="-1" href="${path}/logout">退出</a></li>
    </ul>
</header>
