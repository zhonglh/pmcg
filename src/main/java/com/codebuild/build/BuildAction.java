package com.codebuild.build;

import com.codebuild.BuildConstant;
import com.codebuild.build.util.FileUtil;
import com.codebuild.build.util.StringUtil;
public class BuildAction implements IBuilderService{
	
	private Class<?> clz ;
	private String folder;
	private String idName;
	private String menuId;
	private String module;
	private String excelTemplet;
	
	
	private StringBuffer content = new StringBuffer("");
	



	public BuildAction(Class<?> clz,String idName,String menuId,String module,String excelTemplet,String folder) {
		super();
		this.clz = clz;
		this.idName = idName;
		this.menuId = menuId;
		this.module = module;
		this.excelTemplet = excelTemplet;
		this.folder = folder;
	}
	
	public void execute(){
		
		this.hend();
		this.list();
		this.paramprocess();
		this.toEdit();
		this.toView();
		this.add();
		this.update();
		this.verify();
		this.batchVerify();
		this.delete();
		
		this.downloadtemplet();
		this.export();
		this.toExcel();
		this.doExcel();
		this.check();
		this.importResult();				
		this.end();
		FileUtil.setFileContent(folder, clz.getSimpleName()+"Action.java", content.toString());
		
	}
	
	
	
	
	private void hend(){
		
		content.append("package "+BuildConstant.packageName+".action;");

		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
		

		content.append("import java.sql.Timestamp;"+BuildConstant.enterMark);
		content.append("import java.util.Date;"+BuildConstant.enterMark);
		content.append("import java.util.HashMap;"+BuildConstant.enterMark);
		content.append("import java.util.List;"+BuildConstant.enterMark);
		content.append("import java.util.Map;"+BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);

		content.append("import javax.servlet.http.HttpServletRequest;"+BuildConstant.enterMark);
		content.append("import javax.servlet.http.HttpServletResponse;"+BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);

		content.append("import org.springframework.beans.factory.annotation.Autowired;"+BuildConstant.enterMark);
		content.append("import org.springframework.stereotype.Controller;"+BuildConstant.enterMark);
		content.append("import org.springframework.web.bind.annotation.RequestMapping;"+BuildConstant.enterMark);
		content.append("import org.springframework.web.bind.annotation.RequestParam;"+BuildConstant.enterMark);
		content.append("import org.springframework.web.multipart.MultipartFile;"+BuildConstant.enterMark);
		content.append("import org.springframework.web.servlet.ModelAndView;"+BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);

		content.append("import com.common.actions.BaseAction;"+BuildConstant.enterMark);
		content.append("import com.common.beans.Pager;"+BuildConstant.enterMark);
		content.append("import com.common.utils.DateKit;"+BuildConstant.enterMark);
		content.append("import com.common.utils.IDKit;"+BuildConstant.enterMark);
		content.append("import com.common.utils.file.FileKit;"+BuildConstant.enterMark);
		content.append("import com.common.utils.file.download.DownloadBaseUtil;"+BuildConstant.enterMark);
		content.append("import com.pm.domain.business.ApplyApprove;"+BuildConstant.enterMark);
		content.append("import com.pm.domain.business.Project;"+BuildConstant.enterMark);
		content.append("import com.pm.domain.system.User;"+BuildConstant.enterMark);
		content.append("import com.pm.service.IApplyApproveService;"+BuildConstant.enterMark);
		content.append("import com.pm.service.IProjectService;"+BuildConstant.enterMark);
		content.append("import com.pm.service.IRoleService;"+BuildConstant.enterMark);
		content.append("import com.pm.util.Config;"+BuildConstant.enterMark);
		content.append("import com.pm.util.PubMethod;"+BuildConstant.enterMark);
		content.append("import com.pm.util.constant.BusinessUtil;"+BuildConstant.enterMark);
		content.append("import com.pm.util.constant.EnumApplyApproveType;"+BuildConstant.enterMark);
		content.append("import com.pm.util.constant.EnumEntityType;"+BuildConstant.enterMark);
		content.append("import com.pm.util.constant.EnumOperationType;"+BuildConstant.enterMark);
		content.append("import com.pm.util.constant.EnumPermit;"+BuildConstant.enterMark);
		content.append("import com.pm.util.excel.BusinessExcel;"+BuildConstant.enterMark);
		content.append("import com.pm.util.excel.ExcelRead;"+BuildConstant.enterMark);
		content.append("import com.pm.vo.UserPermit;"+BuildConstant.enterMark);

		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
		content.append("import com.pm.domain.business."+clz.getSimpleName()+";"+BuildConstant.enterMark);
		content.append("import com.pm.service.I"+clz.getSimpleName()+"Service;"+BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);

		content.append("@Controller");
		content.append(BuildConstant.enterMark);
		content.append("@RequestMapping(\""+clz.getSimpleName()+"Action.do\")");
		content.append(BuildConstant.enterMark);
		content.append("public class "+clz.getSimpleName()+"Action extends BaseAction {");

		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
		

		content.append("	private static final String sessionAttr = \""+clz.getSimpleName()+"s\";"+BuildConstant.enterMark);

		content.append(BuildConstant.enterMark);

		content.append("	private static final String rel = \"rel"+menuId+"\";"+BuildConstant.enterMark);

		content.append(BuildConstant.enterMark);
		content.append("	@Autowired"+BuildConstant.enterMark);
		content.append("	private IProjectService projectService;"+BuildConstant.enterMark);
		
		content.append("	@Autowired"+BuildConstant.enterMark);
		content.append("	private I"+clz.getSimpleName()+"Service "+StringUtil.firstLowerCase(clz.getSimpleName())+"Service;"+BuildConstant.enterMark);

		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);

		content.append("	@Autowired"+BuildConstant.enterMark);
		content.append("	private IApplyApproveService applyApproveService;	"+BuildConstant.enterMark);

		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
		content.append("	@Autowired"+BuildConstant.enterMark);
		content.append("	private IRoleService roleService;"+BuildConstant.enterMark);
		

		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);


	}
	
	
	
	private void list(){
		
		content.append("	@RequestMapping(params = \"method=list\")"+BuildConstant.enterMark);
		content.append("	public String list("+clz.getSimpleName()+" "+StringUtil.firstLowerCase(clz.getSimpleName())+",HttpServletResponse res,HttpServletRequest request){"+BuildConstant.enterMark);

		content.append(BuildConstant.enterMark);
		content.append("		UserPermit userPermit = this.getUserPermit(request, roleService, EnumPermit."+clz.getSimpleName().toUpperCase()+"VIEW.getId());"+BuildConstant.enterMark);

		content.append(BuildConstant.enterMark);
		content.append("		paramprocess(request,"+StringUtil.firstLowerCase(clz.getSimpleName())+");"+BuildConstant.enterMark);

		content.append(BuildConstant.enterMark);
		content.append("		Pager<"+clz.getSimpleName()+"> pager = "+StringUtil.firstLowerCase(clz.getSimpleName())+"Service.query"+clz.getSimpleName()+"("+StringUtil.firstLowerCase(clz.getSimpleName())+", userPermit, PubMethod.getPager(request, "+clz.getSimpleName()+".class));"+BuildConstant.enterMark);
		content.append("		PubMethod.setRequestPager(request, pager,"+clz.getSimpleName()+".class);	"+BuildConstant.enterMark);

		content.append(BuildConstant.enterMark);
		content.append("		request.setAttribute(\""+StringUtil.firstLowerCase(clz.getSimpleName())+"\", "+StringUtil.firstLowerCase(clz.getSimpleName())+");"+BuildConstant.enterMark);

		content.append("		request.setAttribute(EnumOperationType.READ.getKey(), userPermit.getPermit_id());	"+BuildConstant.enterMark);	

		content.append("		UserPermit userPermit1 = this.getUserPermit(request, roleService, EnumPermit."+clz.getSimpleName().toUpperCase()+"ADD.getId());"+BuildConstant.enterMark);
		content.append("		request.setAttribute(EnumOperationType.INSERT.getKey(), userPermit1.getPermit_id());"+BuildConstant.enterMark);
			
		content.append("		userPermit1 = this.getUserPermit(request, roleService, EnumPermit."+clz.getSimpleName().toUpperCase()+"UPDATE.getId());"+BuildConstant.enterMark);
		content.append("		request.setAttribute(EnumOperationType.UPDATE.getKey(), userPermit1.getPermit_id());"+BuildConstant.enterMark);

		content.append("		userPermit1 = this.getUserPermit(request, roleService, EnumPermit."+clz.getSimpleName().toUpperCase()+"DELETE.getId());"+BuildConstant.enterMark);
		content.append("		request.setAttribute(EnumOperationType.DELETE.getKey(), userPermit1.getPermit_id());"+BuildConstant.enterMark);	
			

		content.append("		userPermit1 = this.getUserPermit(request, roleService, EnumPermit."+clz.getSimpleName().toUpperCase()+"CHECK.getId());"+BuildConstant.enterMark);
		content.append("		request.setAttribute(EnumOperationType.CHECK.getKey(), userPermit1.getPermit_id());"+BuildConstant.enterMark);

		content.append(BuildConstant.enterMark);
		content.append("		return \""+module+"/"+clz.getSimpleName().toLowerCase()+"_list\";"+BuildConstant.enterMark);
		content.append("	}"+BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
	
	}
	
	
	
	private void paramprocess(){
			content.append("	private void paramprocess(HttpServletRequest request,"+clz.getSimpleName()+" "+StringUtil.firstLowerCase(clz.getSimpleName())+"){"+BuildConstant.enterMark);		
			content.append("		"+StringUtil.firstLowerCase(clz.getSimpleName())+".setProject_id(request.getParameter(\"project.project_id\"));"+BuildConstant.enterMark);
				
			content.append("		if("+StringUtil.firstLowerCase(clz.getSimpleName())+".getProject_name() == null || "+StringUtil.firstLowerCase(clz.getSimpleName())+".getProject_name().isEmpty())"+BuildConstant.enterMark);
			content.append("		"+StringUtil.firstLowerCase(clz.getSimpleName())+".setProject_name(request.getParameter(\"project.project_name\"));"+BuildConstant.enterMark);
			content.append("	}"+BuildConstant.enterMark);
			content.append(BuildConstant.enterMark);
			content.append(BuildConstant.enterMark);
	}
	
	
	private void toEdit(){

		content.append("	@RequestMapping(params = \"method=toEdit\")"+BuildConstant.enterMark);
		content.append("	public String toEdit("+clz.getSimpleName()+" search"+clz.getSimpleName()+",HttpServletResponse res,HttpServletRequest request){"+BuildConstant.enterMark);
		content.append("		"+clz.getSimpleName()+" "+StringUtil.firstLowerCase(clz.getSimpleName())+" = null;"+BuildConstant.enterMark);
		content.append("		if(search"+clz.getSimpleName()+" != null && search"+clz.getSimpleName()+".get"+StringUtil.firstUpperCase(idName)+"()!=null){"+BuildConstant.enterMark);
		content.append("			request.setAttribute(\"next_operation\", \"update"+clz.getSimpleName()+"\");"+BuildConstant.enterMark);
		content.append("			"+StringUtil.firstLowerCase(clz.getSimpleName())+" = "+StringUtil.firstLowerCase(clz.getSimpleName())+"Service.get"+clz.getSimpleName()+"(search"+clz.getSimpleName()+".get"+StringUtil.firstUpperCase(idName)+"());	"+BuildConstant.enterMark);
		content.append("			if("+StringUtil.firstLowerCase(clz.getSimpleName())+".getVerify_userid() != null && "+StringUtil.firstLowerCase(clz.getSimpleName())+".getVerify_userid().length() > 0){"+BuildConstant.enterMark);
		content.append("				return this.ajaxForwardError(request, \"单据已经核实， 不能够再更改了！\", true);"+BuildConstant.enterMark);
		content.append("			}"+BuildConstant.enterMark);
				
				
		content.append("		}else {"+BuildConstant.enterMark);
		content.append("			request.setAttribute(\"next_operation\", \"add"+clz.getSimpleName()+"\");		"+BuildConstant.enterMark);

		content.append("			User sessionUser = PubMethod.getUser(request);"+BuildConstant.enterMark);
		content.append("			"+StringUtil.firstLowerCase(clz.getSimpleName())+" = new "+clz.getSimpleName()+"();	"+BuildConstant.enterMark);
		content.append("			"+StringUtil.firstLowerCase(clz.getSimpleName())+".setBuild_userid(sessionUser.getUser_id());"+BuildConstant.enterMark);
		content.append("			"+StringUtil.firstLowerCase(clz.getSimpleName())+".setBuild_username(sessionUser.getUser_name());"+BuildConstant.enterMark);
		content.append("			"+StringUtil.firstLowerCase(clz.getSimpleName())+".setBuild_datetime(PubMethod.getCurrentDate());"+BuildConstant.enterMark);

		content.append("			String month = DateKit.fmtDateToStr(new Date(),\"yyyyMM\");"+BuildConstant.enterMark);
		content.append("			"+StringUtil.firstLowerCase(clz.getSimpleName())+".setUse_month(Integer.parseInt(month));"+BuildConstant.enterMark);
				
		content.append("		}"+BuildConstant.enterMark);

		content.append("		request.setAttribute(\""+StringUtil.firstLowerCase(clz.getSimpleName())+"1\", "+StringUtil.firstLowerCase(clz.getSimpleName())+");"+BuildConstant.enterMark);
		content.append("		return \""+module+"/"+clz.getSimpleName().toLowerCase()+"_edit\";"+BuildConstant.enterMark);
			
		content.append("	}"+BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
	}
	
	
	private void toView(){

		content.append("	@RequestMapping(params = \"method=toView\")"+BuildConstant.enterMark);
		content.append("	public String toView("+clz.getSimpleName()+" search"+clz.getSimpleName()+",HttpServletResponse res,HttpServletRequest request){"+BuildConstant.enterMark);
			
		content.append("		"+clz.getSimpleName()+" "+StringUtil.firstLowerCase(clz.getSimpleName())+" = "+StringUtil.firstLowerCase(clz.getSimpleName())+"Service.get"+clz.getSimpleName()+"(search"+clz.getSimpleName()+".get"+StringUtil.firstUpperCase(idName)+"());"+BuildConstant.enterMark);
		content.append("		request.setAttribute(\""+StringUtil.firstLowerCase(clz.getSimpleName())+"1\", "+StringUtil.firstLowerCase(clz.getSimpleName())+");"+BuildConstant.enterMark);

		content.append("		UserPermit userPermit1 = this.getUserPermit(request, roleService, EnumPermit."+clz.getSimpleName().toUpperCase()+"CHECK.getId());"+BuildConstant.enterMark);
		content.append("		request.setAttribute(EnumOperationType.CHECK.getKey(), userPermit1.getPermit_id());"+BuildConstant.enterMark);
			

		content.append("		userPermit1 = this.getUserPermit(request, roleService, EnumPermit."+clz.getSimpleName().toUpperCase()+"UNCHECK.getId());"+BuildConstant.enterMark);
		content.append("		request.setAttribute(EnumOperationType.UNCHECK.getKey(), userPermit1.getPermit_id());"+BuildConstant.enterMark);		

		content.append("		User sessionUser = PubMethod.getUser(request);"+BuildConstant.enterMark);
		content.append("		Project project = projectService.getProject( "+StringUtil.firstLowerCase(clz.getSimpleName())+".getProject_id());"+BuildConstant.enterMark);
		content.append("		List<ApplyApprove>  infos = applyApproveService.queryByDataId(EnumEntityType."+clz.getSimpleName().toUpperCase()+".name(), "+StringUtil.firstLowerCase(clz.getSimpleName())+".get"+StringUtil.firstUpperCase(idName)+"());"+BuildConstant.enterMark);
		content.append("		ApplyApprove applyApprove = applyApproveService.needHandle(EnumEntityType."+clz.getSimpleName().toUpperCase()+".name(),  "+StringUtil.firstLowerCase(clz.getSimpleName())+".get"+StringUtil.firstUpperCase(idName)+"());"+BuildConstant.enterMark);
			
		content.append("		request.setAttribute(\"infos\", infos);"+BuildConstant.enterMark);
		content.append("		request.setAttribute(\"applyApprove\", applyApprove);"+BuildConstant.enterMark);
		content.append("		request.setAttribute(\"project\", project);"+BuildConstant.enterMark);
		content.append("		request.setAttribute(\"sessionUser\", sessionUser);"+BuildConstant.enterMark);

		content.append("		request.setAttribute(\"verify_userid\", "+StringUtil.firstLowerCase(clz.getSimpleName())+".getVerify_userid());"+BuildConstant.enterMark);
		content.append("		request.setAttribute(\"data_id\", "+StringUtil.firstLowerCase(clz.getSimpleName())+".get"+StringUtil.firstUpperCase(idName)+"());"+BuildConstant.enterMark);
		content.append("		request.setAttribute(\"data_type\", EnumEntityType."+clz.getSimpleName().toUpperCase()+".name());"+BuildConstant.enterMark);		
			
		content.append("		return \""+module+"/"+clz.getSimpleName().toLowerCase()+"_view\";"+BuildConstant.enterMark);
			
		content.append("	}"+BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
	}
	
	
	private void add(){		

		content.append("	@RequestMapping(params = \"method=add"+clz.getSimpleName()+"\")"+BuildConstant.enterMark);
		content.append("	public String add"+clz.getSimpleName()+"("+clz.getSimpleName()+" add"+clz.getSimpleName()+",HttpServletResponse res,HttpServletRequest request){"+BuildConstant.enterMark);
			
		content.append("		"+clz.getSimpleName()+" "+StringUtil.firstLowerCase(clz.getSimpleName())+" = add"+clz.getSimpleName()+";	"+BuildConstant.enterMark);
		content.append("		paramprocess(request,"+StringUtil.firstLowerCase(clz.getSimpleName())+");"+BuildConstant.enterMark);

		content.append("		User sessionUser = PubMethod.getUser(request);"+BuildConstant.enterMark);
		content.append("		"+StringUtil.firstLowerCase(clz.getSimpleName())+".set"+StringUtil.firstUpperCase(idName)+"(IDKit.generateId());"+BuildConstant.enterMark);
		content.append("		"+StringUtil.firstLowerCase(clz.getSimpleName())+".setBuild_datetime(PubMethod.getCurrentDate());"+BuildConstant.enterMark);
		content.append("		"+StringUtil.firstLowerCase(clz.getSimpleName())+".setBuild_userid(sessionUser.getUser_id());"+BuildConstant.enterMark);
		content.append("		"+StringUtil.firstLowerCase(clz.getSimpleName())+".setBuild_username(sessionUser.getUser_name());"+BuildConstant.enterMark);
		content.append("		int count = 0;"+BuildConstant.enterMark);
		content.append("		try{"+BuildConstant.enterMark);
		content.append("			count = "+StringUtil.firstLowerCase(clz.getSimpleName())+"Service.add"+clz.getSimpleName()+"("+StringUtil.firstLowerCase(clz.getSimpleName())+");"+BuildConstant.enterMark);

		content.append("			ApplyApprove applyApprove = applyApproveService.buildApplyApprove(EnumApplyApproveType.BUILD.getKey(), EnumEntityType."+clz.getSimpleName().toUpperCase()+".name(), "+StringUtil.firstLowerCase(clz.getSimpleName())+".get"+StringUtil.firstUpperCase(idName)+"(), sessionUser);"+BuildConstant.enterMark);
		content.append("			applyApproveService.addApplyApprove(applyApprove);"+BuildConstant.enterMark);
		content.append("		}catch(Exception e){"+BuildConstant.enterMark);
				
		content.append("		}"+BuildConstant.enterMark);
		content.append("		if(count == 1) 		return this.ajaxForwardSuccess(request, rel, true);"+BuildConstant.enterMark);
		content.append("		else return this.ajaxForwardError(request, \"该单据已经存在！\", true);"+BuildConstant.enterMark);
			
		content.append("	}"+BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
		
	}
	
	
	private void update(){
		content.append("	@RequestMapping(params = \"method=update"+clz.getSimpleName()+"\")"+BuildConstant.enterMark);
		content.append("	public String update"+clz.getSimpleName()+"("+clz.getSimpleName()+" update"+clz.getSimpleName()+",HttpServletResponse res,HttpServletRequest request){"+BuildConstant.enterMark);
			
		content.append("		"+clz.getSimpleName()+" "+StringUtil.firstLowerCase(clz.getSimpleName())+" = update"+clz.getSimpleName()+";	"+BuildConstant.enterMark);
		content.append("		paramprocess(request,"+StringUtil.firstLowerCase(clz.getSimpleName())+");	"+BuildConstant.enterMark);		
			
		content.append("		int count = 0;"+BuildConstant.enterMark);
		content.append("		try{"+BuildConstant.enterMark);
		content.append("			count = "+StringUtil.firstLowerCase(clz.getSimpleName())+"Service.update"+clz.getSimpleName()+"("+StringUtil.firstLowerCase(clz.getSimpleName())+");	"+BuildConstant.enterMark);	
		content.append("		}catch(Exception e){"+BuildConstant.enterMark);
				
		content.append("		}"+BuildConstant.enterMark);
		content.append("		if(count == 1) 		return this.ajaxForwardSuccess(request, rel, true);"+BuildConstant.enterMark);
		content.append("		else return this.ajaxForwardError(request, \"该单据已经存在！\", true);"+BuildConstant.enterMark);
			
			
		content.append("	}	"+BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
				
	}
	
	
	private void batchVerify(){

		content.append("	@RequestMapping(params = \"method=batchVerify"+clz.getSimpleName()+"\")"+BuildConstant.enterMark);
		content.append("	public String batchVerify"+clz.getSimpleName()+"(HttpServletResponse res,HttpServletRequest request){"+BuildConstant.enterMark);
		content.append("		User sessionUser = PubMethod.getUser(request);"+BuildConstant.enterMark);
				
			
		content.append("		String[] ids = request.getParameterValues(\"ids\");"+BuildConstant.enterMark);
		content.append("		if(ids == null || ids.length == 0){"+BuildConstant.enterMark);
		content.append("			this.ajaxForwardError(request, \"请先选择单据！\", false);"+BuildConstant.enterMark);
		content.append("		}"+BuildConstant.enterMark);
				
		content.append("		for(String id : ids){"+BuildConstant.enterMark);
		content.append("			"+clz.getSimpleName()+" "+StringUtil.firstLowerCase(clz.getSimpleName())+" = new "+clz.getSimpleName()+"();"+BuildConstant.enterMark);
		content.append("			"+StringUtil.firstLowerCase(clz.getSimpleName())+".setVerify_datetime(PubMethod.getCurrentDate());"+BuildConstant.enterMark);
		content.append("			"+StringUtil.firstLowerCase(clz.getSimpleName())+".setVerify_userid(sessionUser.getUser_id());"+BuildConstant.enterMark);
		content.append("			"+StringUtil.firstLowerCase(clz.getSimpleName())+".setVerify_username(sessionUser.getUser_name());"+BuildConstant.enterMark);
		content.append("			"+StringUtil.firstLowerCase(clz.getSimpleName())+".set"+StringUtil.firstUpperCase(idName)+"(id);"+BuildConstant.enterMark);
		content.append("			"+StringUtil.firstLowerCase(clz.getSimpleName())+"Service.verify"+clz.getSimpleName()+"("+StringUtil.firstLowerCase(clz.getSimpleName())+");"+BuildConstant.enterMark);
		content.append("			ApplyApprove applyApprove = applyApproveService.buildApplyApprove(EnumApplyApproveType.CHECK.getKey(), EnumEntityType."+clz.getSimpleName().toUpperCase()+".name(), "+StringUtil.firstLowerCase(clz.getSimpleName())+".get"+StringUtil.firstUpperCase(idName)+"(), sessionUser);"+BuildConstant.enterMark);
		content.append("			applyApproveService.addApplyApprove(applyApprove);"+BuildConstant.enterMark);
		content.append("		}"+BuildConstant.enterMark);
		content.append("		return this.ajaxForwardSuccess(request, rel, false);"+BuildConstant.enterMark);
		content.append("	}"+BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);

	}
	
	
	private void verify(){
		
		content.append("	@RequestMapping(params = \"method=verify"+clz.getSimpleName()+"\")"+BuildConstant.enterMark);
				content.append("	public String verify"+clz.getSimpleName()+"("+clz.getSimpleName()+" "+StringUtil.firstLowerCase(clz.getSimpleName())+",HttpServletResponse res,HttpServletRequest request){"+BuildConstant.enterMark);
				content.append("		User sessionUser = PubMethod.getUser(request);"+BuildConstant.enterMark);
				content.append("		"+StringUtil.firstLowerCase(clz.getSimpleName())+".setVerify_datetime(PubMethod.getCurrentDate());"+BuildConstant.enterMark);
				content.append("		"+StringUtil.firstLowerCase(clz.getSimpleName())+".setVerify_userid(sessionUser.getUser_id());"+BuildConstant.enterMark);
				content.append("		"+StringUtil.firstLowerCase(clz.getSimpleName())+".setVerify_username(sessionUser.getUser_name());"+BuildConstant.enterMark);
				content.append("		"+StringUtil.firstLowerCase(clz.getSimpleName())+"Service.verify"+clz.getSimpleName()+"("+StringUtil.firstLowerCase(clz.getSimpleName())+");"+BuildConstant.enterMark);
				content.append("		ApplyApprove applyApprove = applyApproveService.buildApplyApprove(EnumApplyApproveType.CHECK.getKey(), EnumEntityType."+clz.getSimpleName().toUpperCase()+".name(), "+StringUtil.firstLowerCase(clz.getSimpleName())+".get"+StringUtil.firstUpperCase(idName)+"(), sessionUser);"+BuildConstant.enterMark);
				content.append("		applyApproveService.addApplyApprove(applyApprove);"+BuildConstant.enterMark);
				content.append("		return this.ajaxForwardSuccess(request, rel, true);"+BuildConstant.enterMark);
				content.append("	}"+BuildConstant.enterMark);
				content.append(BuildConstant.enterMark);
				content.append(BuildConstant.enterMark);
					
	}
	

	
	private void delete(){

		content.append("	@RequestMapping(params = \"method=delete"+clz.getSimpleName()+"\")"+BuildConstant.enterMark);
		content.append("	public String delete"+clz.getSimpleName()+"(HttpServletResponse res,HttpServletRequest request){"+BuildConstant.enterMark);
			
		content.append("		User sessionUser = PubMethod.getUser(request);"+BuildConstant.enterMark);
		content.append("		java.sql.Timestamp deleteDate = PubMethod.getCurrentDate();"+BuildConstant.enterMark);		
			
		content.append("		String[] ids = request.getParameterValues(\"ids\");"+BuildConstant.enterMark);
		content.append("		if(ids != null && ids.length > 0){"+BuildConstant.enterMark);
		content.append("			"+clz.getSimpleName()+"[] "+StringUtil.firstLowerCase(clz.getSimpleName())+"s = new "+clz.getSimpleName()+"[ids.length];"+BuildConstant.enterMark);
		content.append("			int index = 0;"+BuildConstant.enterMark);
		content.append("			for(String id : ids){"+BuildConstant.enterMark);
		content.append("				"+clz.getSimpleName()+" "+StringUtil.firstLowerCase(clz.getSimpleName())+" = new "+clz.getSimpleName()+"();"+BuildConstant.enterMark);
		content.append("				"+StringUtil.firstLowerCase(clz.getSimpleName())+".set"+StringUtil.firstUpperCase(idName)+"(id);"+BuildConstant.enterMark);
		content.append("				"+StringUtil.firstLowerCase(clz.getSimpleName())+".setDelete_userid(sessionUser.getUser_id());"+BuildConstant.enterMark);
		content.append("				"+StringUtil.firstLowerCase(clz.getSimpleName())+".setDelete_username(sessionUser.getUser_name());"+BuildConstant.enterMark);
		content.append("				"+StringUtil.firstLowerCase(clz.getSimpleName())+".setDelete_datetime(deleteDate);"+BuildConstant.enterMark);
		content.append("				"+StringUtil.firstLowerCase(clz.getSimpleName())+"s[index] = "+StringUtil.firstLowerCase(clz.getSimpleName())+";"+BuildConstant.enterMark);
		content.append("				index ++ ;"+BuildConstant.enterMark);
		content.append("			}"+BuildConstant.enterMark);
				
		content.append("			if("+StringUtil.firstLowerCase(clz.getSimpleName())+"s != null && "+StringUtil.firstLowerCase(clz.getSimpleName())+"s.length > 0)"+BuildConstant.enterMark);
		content.append("			"+StringUtil.firstLowerCase(clz.getSimpleName())+"Service.delete"+clz.getSimpleName()+"("+StringUtil.firstLowerCase(clz.getSimpleName())+"s);"+BuildConstant.enterMark);
		content.append("		}"+BuildConstant.enterMark);
		content.append("		return this.ajaxForwardSuccess(request,rel,false);"+BuildConstant.enterMark);
		content.append("	}	"+BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);

	}
	
	
	private void downloadtemplet(){
		
		content.append("	@RequestMapping(params = \"method=downloadtemplet\")"+BuildConstant.enterMark);
				content.append("	public ModelAndView downloadtemplet(HttpServletRequest request,  HttpServletResponse response) throws Exception { "+BuildConstant.enterMark);
				content.append("		DownloadBaseUtil downloadBaseUtil = new DownloadBaseUtil();"+BuildConstant.enterMark);
				content.append("		String sourceFile = this.getClass().getClassLoader().getResource(\"/templet/"+clz.getSimpleName().toLowerCase()+".xlsx\").getPath();		"+BuildConstant.enterMark);
				content.append("		downloadBaseUtil.download(  sourceFile,  \""+excelTemplet+".xlsx\" ,response,false); "+BuildConstant.enterMark); 		
				content.append("		return null;  "+BuildConstant.enterMark);
				content.append("	}  	"+BuildConstant.enterMark);
				content.append(BuildConstant.enterMark);
				content.append(BuildConstant.enterMark);

		
	}
	
	
	private void export(){
		content.append("	@RequestMapping(params = \"method=export\")"+BuildConstant.enterMark);
		content.append("	public void export("+clz.getSimpleName()+" "+StringUtil.firstLowerCase(clz.getSimpleName())+",HttpServletResponse res,HttpServletRequest request){"+BuildConstant.enterMark);
		content.append("		UserPermit userPermit = this.getUserPermit(request, roleService, EnumPermit.REIMBURSEVIEW.getId());		"+BuildConstant.enterMark);

		content.append("		Pager<"+clz.getSimpleName()+"> pager = "+StringUtil.firstLowerCase(clz.getSimpleName())+"Service.query"+clz.getSimpleName()+"("+StringUtil.firstLowerCase(clz.getSimpleName())+", userPermit, PubMethod.getPagerByAll(request, "+clz.getSimpleName()+".class));"+BuildConstant.enterMark);
						
			
		content.append("		try{"+BuildConstant.enterMark);
		content.append("			BusinessExcel.export(res, null, pager.getResultList(), "+clz.getSimpleName()+".class,false);"+BuildConstant.enterMark);
		content.append("		}catch(Exception e){"+BuildConstant.enterMark);
		content.append("			e.printStackTrace();"+BuildConstant.enterMark);
		content.append("		}"+BuildConstant.enterMark);
			
		content.append("	}	"+BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);


	}
	
	
	private void toExcel(){
		
		content.append("	@RequestMapping(params = \"method=toExcel\")"+BuildConstant.enterMark);
		content.append("	public String toExcel(HttpServletResponse res,HttpServletRequest request){"+BuildConstant.enterMark);
		content.append("		return \""+module+"/"+clz.getSimpleName().toLowerCase()+"_upload\";		"+BuildConstant.enterMark);
		content.append("	}	"+BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
	}
	
	
	private void doExcel(){
		content.append("	@RequestMapping(params = \"method=doExcel\")"+BuildConstant.enterMark);
				content.append("	public String doExcel(@RequestParam(\"image\") MultipartFile file,HttpServletResponse res,HttpServletRequest request) throws  Exception{"+BuildConstant.enterMark);
					
					
				content.append("		List<String[]> list = getExcel(file,10,res,request);"+BuildConstant.enterMark);
					
				content.append("		List<"+clz.getSimpleName()+"> "+StringUtil.firstLowerCase(clz.getSimpleName())+"s = PubMethod.stringArray2List(list, "+clz.getSimpleName()+".class);"+BuildConstant.enterMark);
					
					
				content.append("		UserPermit userPermit = new UserPermit();"+BuildConstant.enterMark);
				content.append("		userPermit.setRange(BusinessUtil.DATA_RANGE_ALL);	"+BuildConstant.enterMark);	


				content.append("		Project searchProject = new Project();"+BuildConstant.enterMark);
				content.append("		searchProject.setDelete_flag(BusinessUtil.NOT_DELETEED);"+BuildConstant.enterMark);
				content.append("		Pager<Project> projects = projectService.queryProject(searchProject, userPermit, PubMethod.getPagerByAll(request, Project.class));"+BuildConstant.enterMark);

				content.append("		Map<String,Project>  projectMap = new HashMap<String,Project>();"+BuildConstant.enterMark);
				content.append("		if(projects.getResultList() != null) {"+BuildConstant.enterMark);
				content.append("			for(Project project : projects.getResultList()){"+BuildConstant.enterMark);
				content.append("				projectMap.put(project.getProject_name(), project);		"+BuildConstant.enterMark);
				content.append("			}"+BuildConstant.enterMark);
				content.append("		}"+BuildConstant.enterMark);
					

					
				content.append("		for("+clz.getSimpleName()+" "+StringUtil.firstLowerCase(clz.getSimpleName())+" : "+StringUtil.firstLowerCase(clz.getSimpleName())+"s){"+BuildConstant.enterMark);
				content.append("			 check"+clz.getSimpleName()+"("+StringUtil.firstLowerCase(clz.getSimpleName())+",projectMap);"+BuildConstant.enterMark);
				content.append("		}"+BuildConstant.enterMark);
					
					

				content.append("		User sessionUser = PubMethod.getUser(request);"+BuildConstant.enterMark);
					
				content.append("		boolean isAllOK = true;"+BuildConstant.enterMark);
				content.append("		for("+clz.getSimpleName()+" "+StringUtil.firstLowerCase(clz.getSimpleName())+" : "+StringUtil.firstLowerCase(clz.getSimpleName())+"s){"+BuildConstant.enterMark);
				content.append("			if("+StringUtil.firstLowerCase(clz.getSimpleName())+".getErrorInfo()==null || "+StringUtil.firstLowerCase(clz.getSimpleName())+".getErrorInfo().length() <= 0){"+BuildConstant.enterMark);
				content.append("				try{"+BuildConstant.enterMark);
				content.append("					"+StringUtil.firstLowerCase(clz.getSimpleName())+".set"+StringUtil.firstUpperCase(idName)+"(IDKit.generateId());"+BuildConstant.enterMark);

				content.append("					"+StringUtil.firstLowerCase(clz.getSimpleName())+".setBuild_datetime(PubMethod.getCurrentDate());"+BuildConstant.enterMark);
				content.append("					"+StringUtil.firstLowerCase(clz.getSimpleName())+".setBuild_userid(sessionUser.getUser_id());"+BuildConstant.enterMark);
				content.append("					"+StringUtil.firstLowerCase(clz.getSimpleName())+".setBuild_username(sessionUser.getUser_name());"+BuildConstant.enterMark);					
								
				content.append("					int count = "+StringUtil.firstLowerCase(clz.getSimpleName())+"Service.add"+clz.getSimpleName()+"("+StringUtil.firstLowerCase(clz.getSimpleName())+");"+BuildConstant.enterMark);
				content.append("					if(count == 0){"+BuildConstant.enterMark);
				content.append("						"+StringUtil.firstLowerCase(clz.getSimpleName())+".setErrorInfo(\"已经有此记录\");"+BuildConstant.enterMark);
				content.append("						isAllOK = false;"+BuildConstant.enterMark);
				content.append("					}"+BuildConstant.enterMark);
				content.append("				}catch(Exception e){"+BuildConstant.enterMark);
				content.append("					if(e.getMessage() == null || e.getMessage().indexOf(\"Key_2\")!=-1 || e.getMessage().indexOf(\"key 2\")!=-1) "+BuildConstant.enterMark);
				content.append("						"+StringUtil.firstLowerCase(clz.getSimpleName())+".setErrorInfo(\"已经有此记录\");"+BuildConstant.enterMark);
				content.append("					else "+StringUtil.firstLowerCase(clz.getSimpleName())+".setErrorInfo(e.getMessage());"+BuildConstant.enterMark);
				content.append("					isAllOK = false;"+BuildConstant.enterMark);
				content.append("				}"+BuildConstant.enterMark);
				content.append("			}else {"+BuildConstant.enterMark);
				content.append("				isAllOK = false;"+BuildConstant.enterMark);
				content.append("			}"+BuildConstant.enterMark);
				content.append("		}"+BuildConstant.enterMark);
					
				content.append("		if(isAllOK){"+BuildConstant.enterMark);
				content.append("			return this.ajaxForwardSuccess(request, rel, true);"+BuildConstant.enterMark);
				content.append("		}else {		"+BuildConstant.enterMark);
				content.append("			request.getSession().setAttribute(sessionAttr, "+StringUtil.firstLowerCase(clz.getSimpleName())+"s);"+BuildConstant.enterMark);
				content.append("			request.setAttribute(\"forwardUrl\", request.getContextPath()+\"/"+clz.getSimpleName()+"Action.do?method=importResult\");"+BuildConstant.enterMark);
				content.append("			return this.ajaxForwardError(request, \"导入的信息中有些问题！ \");"+BuildConstant.enterMark);
				content.append("		}"+BuildConstant.enterMark);
					
				content.append("	}	"+BuildConstant.enterMark);
				content.append(BuildConstant.enterMark);
				content.append(BuildConstant.enterMark);
	}
	

	private void check(){
		content.append("	private boolean check"+clz.getSimpleName()+"("+clz.getSimpleName()+" "+StringUtil.firstLowerCase(clz.getSimpleName())+",	Map<String,Project>  projectMap){"+BuildConstant.enterMark);
		content.append("		boolean b = true;"+BuildConstant.enterMark);
			
			
			
		content.append("		if("+StringUtil.firstLowerCase(clz.getSimpleName())+".getProject_name() == null ||  "+StringUtil.firstLowerCase(clz.getSimpleName())+".getProject_name().isEmpty()){"+BuildConstant.enterMark);
		content.append("			"+StringUtil.firstLowerCase(clz.getSimpleName())+".setErrorInfo("+StringUtil.firstLowerCase(clz.getSimpleName())+".getErrorInfo() + \"项目名称不能为空;\");"+BuildConstant.enterMark);
		content.append("			b = false;"+BuildConstant.enterMark);
		content.append("		}else {"+BuildConstant.enterMark);
		content.append("			Project project = projectMap.get("+StringUtil.firstLowerCase(clz.getSimpleName())+".getProject_name().trim());"+BuildConstant.enterMark);
		content.append("			if(project == null ){"+BuildConstant.enterMark);
		content.append("				"+StringUtil.firstLowerCase(clz.getSimpleName())+".setErrorInfo("+StringUtil.firstLowerCase(clz.getSimpleName())+".getErrorInfo() + \"项目名称错误;\");"+BuildConstant.enterMark);
		content.append("				b = false;"+BuildConstant.enterMark);
		content.append("			}else {"+BuildConstant.enterMark);
		content.append("				"+StringUtil.firstLowerCase(clz.getSimpleName())+".setProject_id(project.getProject_id());"+BuildConstant.enterMark);
		content.append("				"+StringUtil.firstLowerCase(clz.getSimpleName())+".setProject_name(project.getProject_name());"+BuildConstant.enterMark);
		content.append("				"+StringUtil.firstLowerCase(clz.getSimpleName())+".setProject_no(project.getProject_no());"+BuildConstant.enterMark);
		content.append("			}"+BuildConstant.enterMark);
		content.append("		}"+BuildConstant.enterMark);
			
			
			
			
		content.append("		if("+StringUtil.firstLowerCase(clz.getSimpleName())+".getErrorInfo() != null && !"+StringUtil.firstLowerCase(clz.getSimpleName())+".getErrorInfo().isEmpty())"+BuildConstant.enterMark);
		content.append("			b = false;"+BuildConstant.enterMark);
			
		content.append("		return b;"+BuildConstant.enterMark);
		content.append("	}"+BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
	}
	
	private void importResult(){
		
		content.append("	@RequestMapping(params = \"method=importResult\")"+BuildConstant.enterMark);
		content.append("	public String importResult(HttpServletResponse res,HttpServletRequest request) throws  Exception{"+BuildConstant.enterMark);
		content.append("		List<"+clz.getSimpleName()+"> list = (List<"+clz.getSimpleName()+">)request.getSession().getAttribute(sessionAttr);"+BuildConstant.enterMark);
		content.append("		request.getSession().removeAttribute(sessionAttr);"+BuildConstant.enterMark);
		content.append("		request.setAttribute(\"list\", list);"+BuildConstant.enterMark);
		content.append("		return \""+module+"/"+clz.getSimpleName().toLowerCase()+"_excel_list\";"+BuildConstant.enterMark);
		content.append("	}"+BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);

	}
	

	private void end(){
		content.append(BuildConstant.enterMark);
		content.append("}");
	}
	
	

}
