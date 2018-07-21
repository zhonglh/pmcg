package com.codebuild.build;

import java.util.List;

import com.codebuild.BuildConstant;
import com.codebuild.build.util.Colume;
import com.codebuild.build.util.FieldUtil;
import com.codebuild.build.util.FileUtil;
import com.codebuild.build.util.StringUtil;

public class BuildJspExcelList implements IBuilderService{
	
	
	private Class<?> clz ;
	private String folder;
	
	private StringBuffer content = new StringBuffer("");
	

	public BuildJspExcelList(Class<?> clz,String folder) {
		super();
		this.clz = clz;
		this.folder = folder;
	}

	
	
	@Override
	public void execute(){

		buildContent();
		FileUtil.setFileContent(folder, clz.getSimpleName().toLowerCase()+"_excel_list.jsp", content.toString());
	}



	public void buildContent(){		
		
		List<Colume> columes = FieldUtil.getImportColume(clz);
		
		content.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">"+BuildConstant.enterMark);
		content.append("<%@ page contentType=\"text/html;charset=UTF-8\" pageEncoding=\"UTF-8\"%>"+BuildConstant.enterMark);
		content.append("<%@ include file=\"/include.inc.jsp\"%>"+BuildConstant.enterMark);

		content.append("<div class=\"pageContent\">"+BuildConstant.enterMark);		
					
		content.append("		<div class=\"pageFormContent\" layoutH=\"56\">	"+BuildConstant.enterMark);
		content.append("			<table class=\"list nowrap\" width=\"1200\" >"+BuildConstant.enterMark);
		content.append("				<thead>"+BuildConstant.enterMark);
		content.append("					<tr>"+BuildConstant.enterMark);
		content.append("						<th width=\"200\">导入说明</th>	"+BuildConstant.enterMark);
		
		if(columes != null && columes.size() > 0){
			for(Colume colume : columes){
				content.append("						<th width=\"100\">"+colume.getName()+"</th>	"+BuildConstant.enterMark);
			}			
			
		}		
		
		
		content.append("					</tr>"+BuildConstant.enterMark);
		content.append("				</thead>"+BuildConstant.enterMark);
		content.append("				<tbody>"+BuildConstant.enterMark);					
		content.append("					<c:forEach var=\""+StringUtil.firstLowerCase(clz.getSimpleName())+"\"  varStatus=\"status1\" items=\"${list}\">"+BuildConstant.enterMark);
		content.append("					<tr>"+BuildConstant.enterMark);
		content.append("						<td>"+BuildConstant.enterMark);
		content.append("							<c:if test=\"${"+StringUtil.firstLowerCase(clz.getSimpleName())+".errorInfo != null && "+StringUtil.firstLowerCase(clz.getSimpleName())+".errorInfo != '' }\">"+BuildConstant.enterMark);
		content.append("								<font color=\"red\">${"+StringUtil.firstLowerCase(clz.getSimpleName())+".errorInfo }</font>"+BuildConstant.enterMark);
		content.append("							</c:if>"+BuildConstant.enterMark);
		content.append("							<c:if test=\"${"+StringUtil.firstLowerCase(clz.getSimpleName())+".errorInfo == null || "+StringUtil.firstLowerCase(clz.getSimpleName())+".errorInfo == '' }\">"+BuildConstant.enterMark);
		content.append("								<font color=\"green\">成功</font>"+BuildConstant.enterMark);
		content.append("							</c:if>"+BuildConstant.enterMark);

		content.append("						</td>"+BuildConstant.enterMark);	
		
		if(columes != null && columes.size() > 0){
			for(Colume colume : columes){
				content.append("						<td>${"+StringUtil.firstLowerCase(clz.getSimpleName())+"."+colume.getCode()+" }</td>	"+BuildConstant.enterMark);
			}			
			
		}
		
					
		content.append("					</tr>"+BuildConstant.enterMark);
		content.append("					</c:forEach>"+BuildConstant.enterMark);
		content.append("				</tbody>"+BuildConstant.enterMark);
		content.append("			</table>"+BuildConstant.enterMark);			
		content.append("		</div>"+BuildConstant.enterMark);

		content.append("		<div class=\"formBar\">"+BuildConstant.enterMark);
		content.append("			<ul>"+BuildConstant.enterMark);
		content.append("				<li>"+BuildConstant.enterMark);
		content.append("					<div class=\"button\"><div class=\"buttonContent\"><button type=\"button\" class=\"close\">取消</button></div></div>"+BuildConstant.enterMark);
		content.append("				</li>"+BuildConstant.enterMark);
		content.append("			</ul>"+BuildConstant.enterMark);
		content.append("		</div>"+BuildConstant.enterMark);
		content.append("</div>"+BuildConstant.enterMark);
	}

}
