package com.codebuild.build;

import java.util.List;

import com.codebuild.BuildConstant;
import com.codebuild.build.util.Colume;
import com.codebuild.build.util.FieldUtil;
import com.codebuild.build.util.FileUtil;
import com.codebuild.build.util.StringUtil;

public class BuildJspEdit implements IBuilderService{
	
	
	private Class<?> clz ;
	private String folder;
	private String idName;
	
	private StringBuffer content = new StringBuffer("");
	

	public BuildJspEdit(Class<?> clz,String idName,String folder) {
		super();
		this.clz = clz;
		this.idName = idName;
		this.folder = folder;
	}

	
	
	@Override
	public void execute(){
		
		buildContent();
		FileUtil.setFileContent(folder, clz.getSimpleName().toLowerCase()+"_edit.jsp", content.toString());
	}



	public void buildContent(){
		
		content.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">"+BuildConstant.enterMark);
		content.append("<%@ page contentType=\"text/html;charset=UTF-8\" pageEncoding=\"UTF-8\"%>"+BuildConstant.enterMark);
		content.append("<%@ include file=\"/include.inc.jsp\"%>"+BuildConstant.enterMark);

		content.append("<div class=\"pageContent\">"+BuildConstant.enterMark);
		content.append("	<form method=\"post\" action=\"${webroot}/"+clz.getSimpleName()+"Action.do?method=${next_operation}\" class=\"pageForm required-validate\" onsubmit=\"return validateCallback(this, dialogAjaxDone);\">"+BuildConstant.enterMark);
		content.append("		<div class=\"pageFormContent\" layoutH=\"56\">"+BuildConstant.enterMark);
		content.append("			<input type=\"hidden\" name=\""+idName+"\" value=\"${"+StringUtil.firstLowerCase(clz.getSimpleName())+"1."+idName+" }\"/>"+BuildConstant.enterMark);
		content.append("			<p>"+BuildConstant.enterMark);
		content.append("				<label>项目名称：</label>"+BuildConstant.enterMark);
		content.append("				<input name=\"project.project_id\"	type=\"hidden\" value=\"${"+StringUtil.firstLowerCase(clz.getSimpleName())+"1.project_id}\"	 />		"+BuildConstant.enterMark);
		content.append("				<input name=\"project.project_name\" class=\"required\" type=\"text\" size=\"28\" maxlength=\"60\" value=\"${"+StringUtil.firstLowerCase(clz.getSimpleName())+"1.project_name}\" readonly=\"true\" />"+BuildConstant.enterMark);
		content.append("					<a class=\"btnLook\" href=\"${webroot }/ProjectAction.do?method=lookup\" lookupGroup=\"project\" lookupPk=\"project_id\" width=\"950\">选择项目</a>	"+BuildConstant.enterMark);
		content.append("			</p>"+BuildConstant.enterMark);
		content.append("			<p>"+BuildConstant.enterMark);
		content.append("				<label>项目编号：</label>"+BuildConstant.enterMark);
		content.append("				<input name=\"project.project_no\" class=\"text\" type=\"text\" size=\"30\" maxlength=\"30\" value=\"${"+StringUtil.firstLowerCase(clz.getSimpleName())+"1.project_no}\" readonly=\"true\"/>"+BuildConstant.enterMark);
		content.append("			</p>"+BuildConstant.enterMark);
		
		
		List<Colume> columes = FieldUtil.getColume(clz);
		if(columes != null && columes.size() >0){
			for(Colume colume : columes){
				content.append("			<p>"+BuildConstant.enterMark);
				content.append("				<label>"+colume.getName()+"：</label>"+BuildConstant.enterMark);
				if(colume.getField().getType() == Double.class || colume.getField().getType() == double.class){
					content.append("				<input name=\""+colume.getCode()+"\" class=\"number required\" type=\"text\" size=\"30\" value=\"<fmt:formatNumber value=\"${"+StringUtil.firstLowerCase(clz.getSimpleName())+"1."+colume.getCode()+" }\" type=\"number\" pattern=\"####0.00#\"/>\" />"+BuildConstant.enterMark);
				}else if(colume.getField().getType() == Integer.class || colume.getField().getType() == int.class){
					content.append("				<input name=\""+colume.getCode()+"\" class=\"number required\" type=\"text\" size=\"30\" value=\"<fmt:formatNumber value=\"${"+StringUtil.firstLowerCase(clz.getSimpleName())+"1."+colume.getCode()+" }\" type=\"number\" pattern=\"####0\"/>\" />"+BuildConstant.enterMark);
				}else if(colume.getField().getType() == java.util.Date.class || colume.getField().getDeclaringClass() == java.sql.Timestamp.class){
					content.append("				<input name=\""+colume.getCode()+"\" class=\"date required\" type=\"text\" size=\"30\" value=\"<fmt:formatDate value=\"${"+StringUtil.firstLowerCase(clz.getSimpleName())+"1."+colume.getCode()+" }\" pattern=\"yyyy-MM-dd\"/>\" />"+BuildConstant.enterMark);
				}else {
					content.append("				<input name=\""+colume.getCode()+"\" class=\"date required\" type=\"text\" size=\"30\" maxlength=\"30\" value=\"${"+StringUtil.firstLowerCase(clz.getSimpleName())+"1."+colume.getCode()+" }\" />"+BuildConstant.enterMark);
				}
				content.append("			</p>"+BuildConstant.enterMark);
			}
		}
		




		content.append("			<div class=\"divider\"></div>"+BuildConstant.enterMark);
		content.append("			<p>"+BuildConstant.enterMark);
		content.append("				<label>制单人：</label>  ${"+StringUtil.firstLowerCase(clz.getSimpleName())+"1.build_username }"+BuildConstant.enterMark);
		content.append("			</p>"+BuildConstant.enterMark);
		content.append("			<p>"+BuildConstant.enterMark);
		content.append("				<label>制单日期：</label> <fmt:formatDate value=\"${"+StringUtil.firstLowerCase(clz.getSimpleName())+"1.build_datetime }\" pattern=\"yyyy-MM-dd\"/> "+BuildConstant.enterMark);
		content.append("			</p>"+BuildConstant.enterMark);
					
		content.append("		</div>"+BuildConstant.enterMark);
				
		content.append("		<div class=\"formBar\">"+BuildConstant.enterMark);
		content.append("			<ul>"+BuildConstant.enterMark);
		content.append("				<li><div class=\"buttonActive\"><div class=\"buttonContent\"><button type=\"submit\">保存</button></div></div></li>"+BuildConstant.enterMark);
		content.append("				<li>"+BuildConstant.enterMark);
		content.append("					<div class=\"button\"><div class=\"buttonContent\"><button type=\"button\" class=\"close\">取消</button></div></div>"+BuildConstant.enterMark);
		content.append("				</li>"+BuildConstant.enterMark);
		content.append("			</ul>"+BuildConstant.enterMark);
		content.append("		</div>"+BuildConstant.enterMark);
		content.append("	</form>"+BuildConstant.enterMark);
		content.append("</div>"+BuildConstant.enterMark);
		
	}

}
