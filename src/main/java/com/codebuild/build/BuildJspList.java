package com.codebuild.build;

import java.util.List;

import com.codebuild.BuildConstant;
import com.codebuild.build.util.Colume;
import com.codebuild.build.util.FieldUtil;
import com.codebuild.build.util.FileUtil;
import com.codebuild.build.util.StringUtil;

public class BuildJspList implements IBuilderService{
	
	
	private Class<?> clz ;
	private String folder;
	private String idName;
	private String fnName;
	
	private StringBuffer content = new StringBuffer("");
	

	public BuildJspList(Class<?> clz,String idName,String fnName,String folder) {
		super();
		this.clz = clz;
		this.idName = idName;
		this.fnName = fnName;		
		this.folder = folder;
	}

	
	
	@Override
	public void execute(){

		buildContent();
		FileUtil.setFileContent(folder, clz.getSimpleName().toLowerCase()+"_list.jsp", content.toString());
	}



	public void buildContent(){
		
		
		List<Colume> columes = FieldUtil.getColume(clz);
		
		content.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">"+BuildConstant.enterMark);
		content.append("<%@ page contentType=\"text/html;charset=UTF-8\" pageEncoding=\"UTF-8\"%>"+BuildConstant.enterMark);
		content.append("<%@ include file=\"/include.inc.jsp\"%>"+BuildConstant.enterMark);

		content.append("<form id=\"pagerForm\" method=\"post\" action=\"${webroot }/"+clz.getSimpleName()+"Action.do?method=list\">"+BuildConstant.enterMark);
		content.append("	<input type=\"hidden\" name=\"pageNum\" value=\"${pageNum}\" />"+BuildConstant.enterMark);
		content.append("	<input type=\"hidden\" name=\"numPerPage\" value=\"${pageSize}\" />"+BuildConstant.enterMark);
		content.append("	<input type=\"hidden\" name=\"project_name\" value=\"${param.project_name}\" />"+BuildConstant.enterMark);
		content.append("	<input type=\"hidden\" name=\"verify_flag\" value=\"${param.verify_flag}\" />"+BuildConstant.enterMark);
		content.append("</form>"+BuildConstant.enterMark);

		content.append("<div class=\"pageHeader\">"+BuildConstant.enterMark);
		content.append("	<form rel=\"pagerForm\" onsubmit=\"return navTabSearch(this);\" action=\"${webroot }/"+clz.getSimpleName()+"Action.do?method=list\" method=\"post\">"+BuildConstant.enterMark);
		content.append("	<div class=\"searchBar\">"+BuildConstant.enterMark);

				
		content.append("		<div class=\"subBar\">"+BuildConstant.enterMark);
		content.append("			<ul>"+BuildConstant.enterMark);
		content.append("				<li><div class=\"buttonActive\"><div class=\"buttonContent\"><button type=\"submit\">检索</button></div></div></li>"+BuildConstant.enterMark);
		content.append("			</ul>"+BuildConstant.enterMark);
		content.append("		</div>"+BuildConstant.enterMark);		
			
		content.append("	</div>"+BuildConstant.enterMark);
		content.append("	</form>"+BuildConstant.enterMark);
		content.append("</div>"+BuildConstant.enterMark);
		content.append("<div class=\"pageContent\">"+BuildConstant.enterMark);
		content.append("	<div class=\"panelBar\">"+BuildConstant.enterMark);
		content.append("		<ul class=\"toolBar\">"+BuildConstant.enterMark);
				
		content.append("			<c:if test=\"${operation_insert != null && operation_insert != '' }\">"+BuildConstant.enterMark);
		content.append("				<li><a class=\"add\" href=\"${webroot}/"+clz.getSimpleName()+"Action.do?method=toEdit\" mask=\"true\" width=\"900\" height=\"400\" rel=\"add_"+clz.getSimpleName().toLowerCase()+"\"  target=\"dialog\"><span>添加"+fnName+"</span></a></li>"+BuildConstant.enterMark);
		content.append("			</c:if>"+BuildConstant.enterMark);
					
		content.append("			<c:if test=\"${operation_delete != null && operation_delete != '' }\">"+BuildConstant.enterMark);
		content.append("				<li><a title=\"确实要删除这些记录吗?\" target=\"selectedTodo\" rel=\"ids\" href=\"${webroot}/"+clz.getSimpleName()+"Action.do?method=delete"+clz.getSimpleName()+"\" class=\"delete\"><span>删除</span></a></li> "+BuildConstant.enterMark);
		content.append("		</c:if>"+BuildConstant.enterMark);
					
		content.append("			<c:if test=\"${operation_update != null && operation_update != '' }\">"+BuildConstant.enterMark);
		content.append("				<li><a class=\"edit\" href=\"${webroot}/"+clz.getSimpleName()+"Action.do?method=toEdit&"+idName+"={sid}\" mask=\"true\" width=\"900\"  height=\"400\" rel=\"update_"+clz.getSimpleName().toLowerCase()+"\" target=\"dialog\" warn=\"请选择一条数据\"><span>修改"+fnName+"</span></a></li>"+BuildConstant.enterMark);
		content.append("			</c:if>"+BuildConstant.enterMark);
					
					
		content.append("			<c:if test=\"${operation_read != null && operation_read != '' }\">"+BuildConstant.enterMark);
		content.append("				<li><a class=\"edit\" href=\"${webroot}/"+clz.getSimpleName()+"Action.do?method=toView&"+idName+"={sid}\" mask=\"true\" width=\"900\"  height=\"480\" rel=\"view_"+clz.getSimpleName().toLowerCase()+"\" target=\"dialog\" warn=\"请选择一条数据\"><span>查看明细</span></a></li>"+BuildConstant.enterMark);
		content.append("			</c:if>	"+BuildConstant.enterMark);	
					
					
		content.append("			<c:if test=\"${operation_check != null && operation_check != '' }\">"+BuildConstant.enterMark);
		content.append("				<li><a title=\"确定已经批量核实了这些单据吗?\" target=\"selectedTodo\" rel=\"ids\" href=\"${webroot}/"+clz.getSimpleName()+"Action.do?method=batchVerify"+clz.getSimpleName()+"\" class=\"delete\"><span>批量核单</span></a></li> "+BuildConstant.enterMark);
		content.append("			</c:if>		"+BuildConstant.enterMark);	

		content.append("			<li class=\"line\">line</li>"+BuildConstant.enterMark);
					
						
		content.append("			<c:if test=\"${operation_read != null && operation_read != '' }\">"+BuildConstant.enterMark);
		content.append("				<li><a class=\"icon\" href=\"${webroot}/"+clz.getSimpleName()+"Action.do?method=export\" target=\"dwzExport\" targetType=\"navTab\" title=\"确定要导出这些记录吗?\"><span>导出EXCEL</span></a></li>"+BuildConstant.enterMark);
		content.append("			</c:if>	"+BuildConstant.enterMark);	
					
					
		content.append("			<li class=\"line\">line</li>"+BuildConstant.enterMark);
					
		content.append("			<c:if test=\"${operation_insert != null && operation_insert != '' }\">"+BuildConstant.enterMark);
		content.append("				<li><a class=\"add\" href=\"${webroot }/"+clz.getSimpleName()+"Action.do?method=toExcel\" mask=\"true\" width=\"850\" height=\"480\" rel=\"add_"+clz.getSimpleName().toLowerCase()+"\" target=\"dialog\"><span>导入EXCEL</span></a></li>"+BuildConstant.enterMark);
		content.append("			</c:if>"+BuildConstant.enterMark);
					 
				
					
		content.append("			<c:if test=\"${operation_insert != null && operation_insert != '' }\">	"+BuildConstant.enterMark);			
		content.append("				<li><a class=\"icon\" href=\"${webroot }/"+clz.getSimpleName()+"Action.do?method=downloadtemplet\" target=\"dwzExport\" targetType=\"navTab\" title=\"确定要导出这模板吗?\"><span>下载模板</span></a></li>"+BuildConstant.enterMark);
		content.append("			</c:if>		"+BuildConstant.enterMark);		
			
		content.append("		</ul>"+BuildConstant.enterMark);
		content.append("	</div>"+BuildConstant.enterMark);
		content.append("	<table class=\"table\" width=\"1600\" layoutH=\"135\">"+BuildConstant.enterMark);
		content.append("		<thead>"+BuildConstant.enterMark);
		content.append("			<tr>"+BuildConstant.enterMark);
		content.append("				<th width=\"22\"><input type=\"checkbox\" group=\"ids\" class=\"checkboxCtrl\" /></th>"+BuildConstant.enterMark);
		content.append("				<th width=\"200\">项目名称</th>"+BuildConstant.enterMark);
		content.append("				<th width=\"100\">项目编号</th>	"+BuildConstant.enterMark);	
		
		

		if(columes != null && columes.size() >0){
			for(Colume colume : columes){
				content.append("				<th width=\"100\">"+colume.getName()+"</th>	"+BuildConstant.enterMark);	
			}
		}
					
		content.append("				<th width=\"80\">制表人</th>"+BuildConstant.enterMark);
		content.append("				<th width=\"80\">核单人</th>"+BuildConstant.enterMark);
		content.append("				<th width=\"120\" >申请状态</th>"+BuildConstant.enterMark);
		content.append("			</tr>"+BuildConstant.enterMark);
		content.append("		</thead>"+BuildConstant.enterMark);
		content.append("		<tbody>"+BuildConstant.enterMark);
				
		content.append("			<c:forEach var=\""+StringUtil.firstLowerCase(clz.getSimpleName())+"\"  varStatus=\"status1\" items=\"${list}\">"+BuildConstant.enterMark);
		content.append("			<tr target=\"sid\" rel=\"${"+StringUtil.firstLowerCase(clz.getSimpleName())+"."+idName+" }\">"+BuildConstant.enterMark);
		content.append("				<td>"+BuildConstant.enterMark);
		content.append("					<c:if test=\"${"+StringUtil.firstLowerCase(clz.getSimpleName())+".verify_userid==null || "+StringUtil.firstLowerCase(clz.getSimpleName())+".verify_userid=='' }\">"+BuildConstant.enterMark);
		content.append("						<input name=\"ids\" value=\"${"+StringUtil.firstLowerCase(clz.getSimpleName())+"."+idName+" }\" type=\"checkbox\" />"+BuildConstant.enterMark);
		content.append("					</c:if>"+BuildConstant.enterMark);
		content.append("				</td>"+BuildConstant.enterMark);
		content.append("				<td>${"+StringUtil.firstLowerCase(clz.getSimpleName())+".project_name }</td>"+BuildConstant.enterMark);
		content.append("				<td>${"+StringUtil.firstLowerCase(clz.getSimpleName())+".project_no }</td>"+BuildConstant.enterMark);
		
		
		
		if(columes != null && columes.size() >0){
			for(Colume colume : columes){
				if(colume.getField().getType() == Double.class || colume.getField().getType() == double.class){
					content.append("				<td align=\"right\"><b><fmt:formatNumber value=\"${"+StringUtil.firstLowerCase(clz.getSimpleName())+"."+colume.getCode()+" }\" type=\"currency\" pattern=\"###,###,##0.00\"/></b></td>"+BuildConstant.enterMark);
				}else if(colume.getField().getType() == Integer.class || colume.getField().getType() == int.class){
					content.append("				<td align=\"right\"><b><fmt:formatNumber value=\"${"+StringUtil.firstLowerCase(clz.getSimpleName())+"."+colume.getCode()+" }\" type=\"number\" pattern=\"###,###,##0\"/></b></td>"+BuildConstant.enterMark);
				}else if(colume.getField().getType() == java.util.Date.class || colume.getField().getDeclaringClass() == java.sql.Timestamp.class){
					content.append("				<td><fmt:formatDate value=\"${"+StringUtil.firstLowerCase(clz.getSimpleName())+"."+colume.getCode()+" }\" pattern=\"yyyy-MM-dd\"/></td>"+BuildConstant.enterMark);
				}else {
					content.append("				<td>${"+StringUtil.firstLowerCase(clz.getSimpleName())+"."+colume.getCode()+" }</td>"+BuildConstant.enterMark);
				}
			}
		}
		
		
		content.append("				<td>${"+StringUtil.firstLowerCase(clz.getSimpleName())+".build_username }</td>"+BuildConstant.enterMark);
		content.append("				<td>${"+StringUtil.firstLowerCase(clz.getSimpleName())+".verify_username }</td>"+BuildConstant.enterMark);
		content.append("				<td>"+BuildConstant.enterMark);
		content.append("					<c:if test=\"${"+StringUtil.firstLowerCase(clz.getSimpleName())+".need_approve!=null && "+StringUtil.firstLowerCase(clz.getSimpleName())+".need_approve=='1' }\">"+BuildConstant.enterMark);
		content.append("						<font color=\"red\">已申请取消核单</font>"+BuildConstant.enterMark);
		content.append("					</c:if>"+BuildConstant.enterMark);
		content.append("				</td>	"+BuildConstant.enterMark);					
		content.append("			</tr>"+BuildConstant.enterMark);
		content.append("			</c:forEach>"+BuildConstant.enterMark);
		content.append("		</tbody>"+BuildConstant.enterMark);
		content.append("	</table>	"+BuildConstant.enterMark);

			
		content.append("	<!-- 分页 -->"+BuildConstant.enterMark);
		content.append("	<c:import url=\"../_frag/pager/panelBar_totalAmount.jsp\"></c:import>"+BuildConstant.enterMark);

		content.append("</div>	"+BuildConstant.enterMark);
	}

}
