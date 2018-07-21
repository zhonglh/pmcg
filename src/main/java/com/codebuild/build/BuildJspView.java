package com.codebuild.build;

import java.util.List;

import com.codebuild.BuildConstant;
import com.codebuild.build.util.Colume;
import com.codebuild.build.util.FieldUtil;
import com.codebuild.build.util.FileUtil;
import com.codebuild.build.util.StringUtil;

public class BuildJspView implements IBuilderService{
	
	
	private Class<?> clz ;
	private String folder;
	private String idName;
	
	private StringBuffer content = new StringBuffer("");
	

	public BuildJspView(Class<?> clz,String idName,String folder) {
		super();
		this.clz = clz;
		this.folder = folder;
		this.idName = idName;
	}

	
	
	@Override
	public void execute(){

		buildContent();
		FileUtil.setFileContent(folder, clz.getSimpleName().toLowerCase()+"_view.jsp", content.toString());
	}



	public void buildContent(){		
		
		content.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">"+BuildConstant.enterMark);
				content.append("<%@ page contentType=\"text/html;charset=UTF-8\" pageEncoding=\"UTF-8\"%>"+BuildConstant.enterMark);
				content.append("<%@ include file=\"/include.inc.jsp\"%>"+BuildConstant.enterMark);

				content.append("<div class=\"pageContent\">"+BuildConstant.enterMark);
				content.append("	<form method=\"post\" action=\"${webroot}/"+clz.getSimpleName()+"Action.do?method=verify"+clz.getSimpleName()+"\" class=\"pageForm required-validate\" onsubmit=\"return validateCallback(this, dialogAjaxDone);\">"+BuildConstant.enterMark);
				content.append("		<div class=\"pageFormContent\" layoutH=\"56\">"+BuildConstant.enterMark);
				content.append("			<input type=\"hidden\" name=\""+idName+"\" value=\"${"+StringUtil.firstLowerCase(clz.getSimpleName())+"1."+idName+" }\"/>"+BuildConstant.enterMark);
				
				List<Colume> columes = FieldUtil.getColume(clz);
				if(columes != null && columes.size() >0){
					for(Colume colume : columes){				
						
						content.append("			<p>"+BuildConstant.enterMark);
						content.append("				<label>"+colume.getName()+"：</label>"+BuildConstant.enterMark);
						
						
						if(colume.getField().getType() == Double.class || colume.getField().getType() == double.class){
							content.append("				<fmt:formatNumber value=\"${"+StringUtil.firstLowerCase(clz.getSimpleName())+"1."+colume.getCode()+" }\" type=\"currency\" pattern=\"###,###,##0.00\"/>"+BuildConstant.enterMark);
						}else if(colume.getField().getType() == Integer.class || colume.getField().getType() == int.class){
							content.append("				<fmt:formatNumber value=\"${"+StringUtil.firstLowerCase(clz.getSimpleName())+"1."+colume.getCode()+" }\" type=\"number\" pattern=\"###,###,##0\"/>"+BuildConstant.enterMark);
						}else if(colume.getField().getType() == java.util.Date.class || colume.getField().getDeclaringClass() == java.sql.Timestamp.class){
							content.append("				<fmt:formatDate value=\"${"+StringUtil.firstLowerCase(clz.getSimpleName())+"1."+colume.getCode()+" }\" pattern=\"yyyy-MM-dd\"/>"+BuildConstant.enterMark);
						}else {
							content.append("				${"+StringUtil.firstLowerCase(clz.getSimpleName())+"1."+colume.getCode()+" }"+BuildConstant.enterMark);
						}
											
						content.append("			</p>"+BuildConstant.enterMark);
				
					}
				}
		
				content.append(BuildConstant.enterMark);
					
				content.append("			<c:import url=\"../common/applyapproveInfo.jsp\"></c:import>"+BuildConstant.enterMark);
				content.append("		</div>"+BuildConstant.enterMark);			

					
					
				content.append("		<c:import url=\"../common/applyapproveButton.jsp\"></c:import>"+BuildConstant.enterMark);
				content.append("	</form>"+BuildConstant.enterMark);
				content.append("</div>"+BuildConstant.enterMark);

		
	}

}
