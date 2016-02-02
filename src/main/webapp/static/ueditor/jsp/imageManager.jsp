<%@ page language="java" pageEncoding="utf-8"%>
<%@ page import="com.github.moor.ActionContext"%>
<%@ page import="com.soteam.commons.utils.Constants"%>
<%@ page import="com.soteam.peanut.team.domain.UserJSON"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="java.io.File" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%
    //仅做示例用，请自行修改
    String path = "images";
	String imgStr ="";
	String realpath = getRealPath(request,path);
	List<File> files = getFiles(realpath,new ArrayList());
	for(File file :files ){
		imgStr+= file.getPath().replace(ActionContext.getContext().getConfiguration().getString(Constants.Storage.PUBLIC),"")+"ue_separate_ue";
	}
	if(imgStr!=""){
        imgStr = imgStr.substring(0,imgStr.lastIndexOf("ue_separate_ue")).replace(File.separator, "/").trim();
    }
	out.print(imgStr);
%>
<%!
public List getFiles(String realpath, List files) {
	File realFile = new File(realpath);
	if (realFile.isDirectory()) {
		File[] subfiles = realFile.listFiles();
		for(File file :subfiles ){
			if(file.isDirectory()){
				getFiles(file.getAbsolutePath(),files);
			}else{
				if(!getFileType(file.getName()).equals("")) {
					files.add(file);
				}
			}
		}
	}
	return files;
}

public String getRealPath(HttpServletRequest request,String path){
    String realPath = ActionContext.getContext().getConfiguration().getString(Constants.Storage.PUBLIC);
    UserJSON uj = (UserJSON)request.getSession().getAttribute(Constants.SESSIONUSER);


    return new File(new File(realPath, uj.getOrgan().getId()), path).getPath();
}

public String getFileType(String fileName){
	String[] fileType = {".gif" , ".png" , ".jpg" , ".jpeg" , ".bmp"};
	Iterator<String> type = Arrays.asList(fileType).iterator();
	while(type.hasNext()){
		String t = type.next();
		if(fileName.toLowerCase().endsWith(t)){
			return t;
		}
	}
	return "";
}
%>