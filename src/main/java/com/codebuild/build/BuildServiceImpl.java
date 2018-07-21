package com.codebuild.build;

import com.codebuild.BuildConstant;
import com.codebuild.build.util.FileUtil;
import com.codebuild.build.util.StringUtil;
public class BuildServiceImpl implements IBuilderService{
	
	private Class<?> clz ;
	private String folder;
	private String idName;
	
	private StringBuffer content = new StringBuffer("");
	



	public BuildServiceImpl(Class<?> clz,String idName,String folder) {
		super();
		this.clz = clz;
		this.idName = idName;
		this.folder = folder;
	}
	
	public void execute(){
		
		this.hend();
		this.add();
		this.update();
		this.delete();
		this.verify();
		this.unVerify();
		this.get();
		this.query();
		this.end();
		FileUtil.setFileContent(folder, clz.getSimpleName()+"ServiceImpl.java", content.toString());
		
	}
	
	
	
	
	private void hend(){
		
		content.append("package "+BuildConstant.packageName+".service.impl;");

		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
		
		content.append("import org.springframework.beans.factory.annotation.Autowired;");
		content.append(BuildConstant.enterMark);
		content.append("import org.springframework.stereotype.Component;");
		
		content.append("import "+BuildConstant.packageName+".domain.business."+clz.getSimpleName()+";");
		content.append(BuildConstant.enterMark);
		content.append("import "+BuildConstant.packageName+".dao.I"+clz.getSimpleName()+"Dao;");
		content.append(BuildConstant.enterMark);
		content.append("import "+BuildConstant.packageName+".service.I"+clz.getSimpleName()+"Service;");
		content.append(BuildConstant.enterMark);
		
		content.append("import com.pm.vo.UserPermit;");
		content.append(BuildConstant.enterMark);
		content.append("import com.common.beans.Pager;");

		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);

		content.append("@Component");
		content.append(BuildConstant.enterMark);
		content.append("public class "+clz.getSimpleName()+"ServiceImpl implements  I"+clz.getSimpleName()+"Service {");

		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
		
		content.append("	@Autowired I"+clz.getSimpleName()+"Dao "+StringUtil.firstLowerCase(clz.getSimpleName())+"Dao;");

		content.append(BuildConstant.enterMark);


	}
	
	

	
	private void add(){
		content.append("	@Override");
		content.append(BuildConstant.enterMark);
		content.append("	public int add"+clz.getSimpleName()+"("+clz.getSimpleName()+" "+StringUtil.firstLowerCase(clz.getSimpleName())+") {");
		content.append(BuildConstant.enterMark);

		content.append("		return "+StringUtil.firstLowerCase(clz.getSimpleName())+"Dao.add"+clz.getSimpleName()+"("+StringUtil.firstLowerCase(clz.getSimpleName())+");");
		content.append(BuildConstant.enterMark);
		
		content.append("	}");		
		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
	}
	

	private void update(){
		content.append("	@Override");
		content.append(BuildConstant.enterMark);
		content.append("	public int update"+clz.getSimpleName()+"("+clz.getSimpleName()+" "+StringUtil.firstLowerCase(clz.getSimpleName())+") {");
		content.append(BuildConstant.enterMark);

		content.append("		return "+StringUtil.firstLowerCase(clz.getSimpleName())+"Dao.update"+clz.getSimpleName()+"("+StringUtil.firstLowerCase(clz.getSimpleName())+");");
		content.append(BuildConstant.enterMark);		
		content.append("	}");	
		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);	
	}
	

	private void delete(){
		content.append("	@Override");
		content.append(BuildConstant.enterMark);
		content.append("	public void delete"+clz.getSimpleName()+"("+clz.getSimpleName()+"[] "+StringUtil.firstLowerCase(clz.getSimpleName())+"s) {");
		content.append(BuildConstant.enterMark);

		content.append("		for("+clz.getSimpleName()+" "+StringUtil.firstLowerCase(clz.getSimpleName())+" : "+StringUtil.firstLowerCase(clz.getSimpleName())+"s){");
		content.append(BuildConstant.enterMark);
		content.append("			"+StringUtil.firstLowerCase(clz.getSimpleName())+"Dao.delete"+clz.getSimpleName()+"("+StringUtil.firstLowerCase(clz.getSimpleName())+");");
		content.append(BuildConstant.enterMark);
		content.append("		}");
		
		content.append(BuildConstant.enterMark);		
		content.append("	}");	
		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);	
	}
	
	


	private void verify(){
		content.append("	@Override");
		content.append(BuildConstant.enterMark);
		content.append("	public void verify"+clz.getSimpleName()+"("+clz.getSimpleName()+" "+StringUtil.firstLowerCase(clz.getSimpleName())+") {");
		content.append(BuildConstant.enterMark);
		content.append("		"+StringUtil.firstLowerCase(clz.getSimpleName())+"Dao.verify"+clz.getSimpleName()+"("+StringUtil.firstLowerCase(clz.getSimpleName())+");");
		content.append(BuildConstant.enterMark);		
		content.append("	}");	
		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);	
	}
	
	private void unVerify(){
		content.append("	@Override");
		content.append(BuildConstant.enterMark);
		content.append("	public void unVerify(String id) {");
		content.append(BuildConstant.enterMark);


		content.append("		"+clz.getSimpleName()+" "+StringUtil.firstLowerCase(clz.getSimpleName())+" = new "+clz.getSimpleName()+"();");
		content.append(BuildConstant.enterMark);
		content.append("		"+StringUtil.firstLowerCase(clz.getSimpleName())+".set"+StringUtil.firstUpperCase(idName)+"(id);");
		content.append(BuildConstant.enterMark);
		content.append("		"+StringUtil.firstLowerCase(clz.getSimpleName())+"Dao.unVerify"+clz.getSimpleName()+"("+StringUtil.firstLowerCase(clz.getSimpleName())+");");
		
		content.append(BuildConstant.enterMark);		
		content.append("	}");	
		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);	
	}
	
	
	
	public void get(){
		

		content.append("	@Override");
		content.append(BuildConstant.enterMark);
		content.append("	public "+clz.getSimpleName()+" get"+clz.getSimpleName()+"(String id) {");
		content.append(BuildConstant.enterMark);
		content.append("		return "+StringUtil.firstLowerCase(clz.getSimpleName())+"Dao.get"+clz.getSimpleName()+"(id);");
		content.append(BuildConstant.enterMark);
		content.append("	}");	

		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
		
		
	}
	
	

	
	public void query(){
		

		content.append("	@Override");
		content.append(BuildConstant.enterMark);
		content.append("	public Pager<"+clz.getSimpleName()+"> query"+clz.getSimpleName()+"(" ) ;
		content.append(BuildConstant.enterMark);
		content.append("		"+clz.getSimpleName()+" "+StringUtil.firstLowerCase(clz.getSimpleName())+",");
		content.append(BuildConstant.enterMark);
		content.append("		UserPermit userPermit,");
		content.append(BuildConstant.enterMark);
		content.append("		Pager<"+clz.getSimpleName()+"> pager){");

		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);


		content.append("		return "+StringUtil.firstLowerCase(clz.getSimpleName())+"Dao.query"+clz.getSimpleName()+"("+StringUtil.firstLowerCase(clz.getSimpleName())+", userPermit, pager);");

		content.append(BuildConstant.enterMark);
		content.append("	}");	

		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);	
	}
	
	
	

	private void end(){
		content.append(BuildConstant.enterMark);
		content.append("}");
	}
	
	

}
