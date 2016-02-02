var param = {
    confirmButtonText : '确定',
    cancelButtonText:'取消'
}
//定义的语言种类
var locales =[
    {
        lang:"cn",
        name:"汉语"
    },
    {
        lang:"us",
        name:"英语"
    }
]

function showMsg(title,msg){
    //alert(msg);
    param.title = title;
    param.text = msg;
    sweetAlert(param);
}

function showoMsg(priority,title,message){
    $.toaster({ priority : priority, title : title, message : message });
}

function startLoading(){
    $(document.body) .append("<div id='loadingDiv' style=' position:absolute;top:0; width:100%; height:100%;z-index:10000000000;background-color:black; filter: alpha(opacity=70); opacity: 0.3;'><img src='"
        + path + "/static/images/loading2.gif' style='position:absolute;top:40%;left:40%;'/></div>");
}
function endLoading(){
    $("#loadingDiv").remove();
}