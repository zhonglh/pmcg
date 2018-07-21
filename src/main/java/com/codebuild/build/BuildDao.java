package com.codebuild.build;

import com.codebuild.BuildConstant;
import com.codebuild.build.util.FileUtil;
import com.codebuild.build.util.StringUtil;

public class BuildDao implements IBuilderService{
	
	private Class<?> clz ;
	private String folder;
	
	private StringBuffer content = new StringBuffer("");
	



	public BuildDao(Class<?> clz,String folder) {
		super();
		this.clz = clz;
		this.folder = folder;
	}
	
	public void execute(){
		
		buildContent();
		FileUtil.setFileContent(folder, "I"+clz.getSimpleName()+"Dao.java", content.toString());
		
	}
	
	
	
	
	private void buildContent(){
		
		content.append("package "+BuildConstant.packageName+".dao;");

		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
		
		content.append("import "+BuildConstant.packageName+".domain.business."+clz.getSimpleName()+";");
		content.append(BuildConstant.enterMark);
		content.append("import com.pm.vo.UserPermit;");
		content.append(BuildConstant.enterMark);
		content.append("import com.common.beans.Pager;");

		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);

		
		content.append("public interface I"+clz.getSimpleName()+"Dao {");

		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);



		content.append("	public int add"+clz.getSimpleName()+"("+clz.getSimpleName()+" "+StringUtil.firstLowerCase(clz.getSimpleName())+") ;");

		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);

		content.append("	public int update"+clz.getSimpleName()+"("+clz.getSimpleName()+" "+StringUtil.firstLowerCase(clz.getSimpleName())+") ; ");

		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);

		content.append("	public void delete"+clz.getSimpleName()+"("+clz.getSimpleName()+" "+StringUtil.firstLowerCase(clz.getSimpleName())+") ;");

		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
		
		content.append("	public void verify"+clz.getSimpleName()+"("+clz.getSimpleName()+" "+StringUtil.firstLowerCase(clz.getSimpleName())+") ;	");
			
			

		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
		content.append("	public void unVerify"+clz.getSimpleName()+"("+clz.getSimpleName()+" "+StringUtil.firstLowerCase(clz.getSimpleName())+") ;");
			
			

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
