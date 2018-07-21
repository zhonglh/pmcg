package com.codebuild.build;

import com.codebuild.BuildConstant;
import com.codebuild.build.util.FileUtil;

public class BuildJspUpload implements IBuilderService{
	
	
	private Class<?> clz ;
	private String fnName;
	private String folder;
	
	private StringBuffer content = new StringBuffer("");
	

	public BuildJspUpload(Class<?> clz,String fnName,String folder) {
		super();
		this.clz = clz;
		this.fnName = fnName;
		this.folder = folder;
	}

	
	
	@Override
	public void execute(){

		buildContent();
		FileUtil.setFileContent(folder, clz.getSimpleName().toLowerCase()+"_upload.jsp", content.toString());
	}



	public void buildContent(){		
		

		content.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">"+BuildConstant.enterMark);
				content.append("<%@ page contentType=\"text/html;charset=UTF-8\" pageEncoding=\"UTF-8\"%>"+BuildConstant.enterMark);
				content.append("<%@ include file=\"/include.inc.jsp\"%>"+BuildConstant.enterMark);

				content.append("<h2 class=\"contentTitle\">请选择需要上传的"+fnName+"信息文件</h2>"+BuildConstant.enterMark);

				content.append("<form action=\"${webroot }/"+clz.getSimpleName()+"Action.do?method=doExcel\" method=\"post\" enctype=\"multipart/form-data\" class=\"pageForm required-validate\" onsubmit=\"return iframeCallback(this, dailogDoneProcessError)\">"+BuildConstant.enterMark);

				content.append("<div class=\"pageContent\">"+BuildConstant.enterMark);
				content.append("	<div class=\"pageFormContent\" layoutH=\"97\">"+BuildConstant.enterMark);
				content.append("		<dl>"+BuildConstant.enterMark);
				content.append("			<dt>文件：</dt><dd><input type=\"file\" name=\"image\" class=\"required\" size=\"40\" /></dd>"+BuildConstant.enterMark);
				content.append("		</dl>"+BuildConstant.enterMark);
				content.append("	</div>"+BuildConstant.enterMark);
				content.append("	<div class=\"formBar\">"+BuildConstant.enterMark);
				content.append("		<ul>"+BuildConstant.enterMark);
				content.append("			<li><div class=\"buttonActive\"><div class=\"buttonContent\"><button type=\"submit\">上传</button></div></div></li>"+BuildConstant.enterMark);
				content.append("			<li><div class=\"button\"><div class=\"buttonContent\"><button class=\"close\" type=\"button\">关闭</button></div></div></li>"+BuildConstant.enterMark);
				content.append("		</ul>"+BuildConstant.enterMark);
				content.append("	</div>"+BuildConstant.enterMark);
				content.append("</div>"+BuildConstant.enterMark);
				content.append("</form>"+BuildConstant.enterMark);
	}

}
