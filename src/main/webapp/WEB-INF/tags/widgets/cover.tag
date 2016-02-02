<%@ tag display-name="master"
        body-content="scriptless"
        pageEncoding="utf-8"
        language="java"
        %>
<%----------------------
usage:
<widget:vover id="title" toggle="true">
    html...
</layout:master>

----------------------%>
<%@ taglib uri="jstl-core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>

<%@ attribute name="name" required="true" type="java.lang.String" %>
<%@ attribute name="style" required="false" type="java.lang.String" %>
<%@ attribute name="cover" required="false" type="java.lang.String" %>
<%@ attribute name="icon" required="false" type="java.lang.String" %>
<%@ attribute name="coverAlt" required="false" type="java.lang.String" %>
<%@ attribute name="iconAlt" required="false" type="java.lang.String" %>

<c:set var="coverId" value="${name}-cover"/>
<c:set var="iconId" value="${name}-icon"/>
<c:set var="coverViewId" value="${name}-cover-view"/>
<c:set var="iconViewId" value="${name}-icon-view"/>

<c:set var="cover1" value="${cover}"/>
<c:set var="icon1" value="${icon}"/>
<c:if test="${empty cover1}">
    <c:set var="cover1" value="${path}/static/images/imagePlaceholder@2x.png"/>
    <c:set var="coverAction" value="设置"/>
</c:if>
<c:if test="${empty icon1}">
    <c:set var="icon1" value="${path}/static/images/imagePlaceholder.png"/>
    <c:set var="iconAction" value="设置"/>
</c:if>

<section class="${empty style?"":style}">
    <div class="">
        <input type="hidden" id="${coverId}" name="${coverId}" value=""/>
        <input type="hidden" id="${iconId}" name="${iconId}" value=""/>

        <div>
            <img alt="${coverAlt}" src="${cover1}"  id="${coverViewId}" class="img-rounded img-container" style="width: 160px;height: 100px;" />
            <img alt="${iconAlt}" src="${icon1}"  id="${iconViewId}" class="img-rounded img-container" style="width: 100px;height: 100px" />
        </div>
        <div>
            <button type="button" class="btn btn-default" id="bt-cover-${name}" style="width: 160px">选择封面</button>
            <button type="button" class="btn btn-default" id="bt-icon-${name}" style="width: 100px">选择图标</button>
        </div>
        <script type="text/javascript">
            $('#bt-cover-${name}').on('click',function(){
                var cuter= new ImgCuter({
                    width:800,
                    height:500,
                    origin: getDefault('#${coverViewId}'),
                    onClose: function(d){
                        $("#${coverId}").val(d);
                        $("#${coverViewId}").attr("src", d);

                        if($("#${iconId}").attr("src") == "" || $("#${iconId}").val() == ""){
                            $("#${iconId}").val(d);
                            $("#${iconViewId}").attr("src", d);
                        }
                    }
                });
            });

            $('#bt-icon-${name}').on('click',function(){
                var cuter= new ImgCuter({
                    width:200,
                    height:200,
                    origin: getDefault('#${iconViewId}'),
                    onClose: function(d){
                        $("#${iconId}").val(d);
                        $("#${iconViewId}").attr("src", d);
                    }
                });
            });

            function getDefault(id){
                var src = $(id).attr('src');
                if(src.indexOf('Placeholder') != -1)
                    return null;
                else
                    return src;
            }
        </script>
    </div>
</section>