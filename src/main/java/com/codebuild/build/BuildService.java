package com.codebuild.build;

import com.codebuild.BuildConstant;
import com.codebuild.build.util.FileUtil;
import com.codebuild.build.util.StringUtil;

public class BuildService implements IBuilderService{
	
	private Class<?> clz ;
	private String folder;
	
	private StringBuffer content = new StringBuffer("");
	


	public BuildService(Class<?> clz,String folder) {
		super();
		this.clz = clz;
		this.folder = folder;
	}
	
	public void execute(){
		
		buildContent();
		FileUtil.setFileContent(folder, "I"+clz.getSimpleName()+"Service.java", content.toString());
		
	}
	
	
	
	
	private void buildContent(){
		
		content.append("package "+BuildConstant.packageName+".service;");

		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
		
		content.append("import "+BuildConstant.packageName+".domain.business."+clz.getSimpleName()+";");
		content.append(BuildConstant.enterMark);
		content.append("import com.pm.vo.UserPermit;");
		content.append(BuildConstant.enterMark);
		content.append("import com.common.beans.Pager;");

		content.append(BuildConstant.enterMark);
		content.append("import com.pm.util.constant.LogConstant;");
		content.append(BuildConstant.enterMark);
		content.append("import com.pm.util.log.LogAnnotation;");

		content.append(BuildConstant.enterMark);
		content.append("import com.pm.service.IGeneralLogService;");

		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);

		
		content.append("public interface I"+clz.getSimpleName()+"Service extends IGeneralLogService {");

		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);


		content.append("	@LogAnnotation(operation_type=LogConstant.OPERATION_INSERT,entity_type=LogConstant.ENTITY_"+clz.getSimpleName().toUpperCase()+")"+BuildConstant.enterMark);
		content.append("	public int add"+clz.getSimpleName()+"("+clz.getSimpleName()+" "+StringUtil.firstLowerCase(clz.getSimpleName())+") ;");

		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);


		content.append("	@LogAnnotation(operation_type=LogConstant.OPERATION_UPDATE,entity_type=LogConstant.ENTITY_"+clz.getSimpleName().toUpperCase()+")"+BuildConstant.enterMark);
		content.append("	public int update"+clz.getSimpleName()+"("+clz.getSimpleName()+" "+StringUtil.firstLowerCase(clz.getSimpleName())+") ; ");

		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
		
		content.append("	@LogAnnotation(operation_type=LogConstant.OPERATION_DELETE,entity_type=LogConstant.ENTITY_"+clz.getSimpleName().toUpperCase()+")"+BuildConstant.enterMark);
		content.append("	public void delete"+clz.getSimpleName()+"("+clz.getSimpleName()+"[] "+StringUtil.firstLowerCase(clz.getSimpleName())+"s) ;");

		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);

		content.append("	@LogAnnotation(operation_type=LogConstant.OPERATION_CHECK,entity_type=LogConstant.ENTITY_"+clz.getSimpleName().toUpperCase()+")"+BuildConstant.enterMark);
		content.append("	public void verify"+clz.getSimpleName()+"("+clz.getSimpleName()+" "+StringUtil.firstLowerCase(clz.getSimpleName())+") ;	");
			

		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
		content.append("	public "+clz.getSimpleName()+" get"+clz.getSimpleName()+"(String id) ;	");
			


		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
		content.append("	public Pager<"+clz.getSimpleName()+"> query"+clz.getSimpleName()+"("+clz.getSimpleName()+" "+StringUtil.firstLowerCase(clz.getSimpleName())+",  UserPermit userPermit,Pager<"+clz.getSimpleName()+"> pager);");


		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
		content.append("}");
	}
	

}
