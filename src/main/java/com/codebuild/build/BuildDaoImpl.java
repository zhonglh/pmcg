package com.codebuild.build;

import com.codebuild.BuildConstant;
import com.codebuild.build.util.FileUtil;
import com.codebuild.build.util.StringUtil;

public class BuildDaoImpl implements IBuilderService{
	
	private Class<?> clz ;
	private String folder;
	private String idName;
	
	private StringBuffer content = new StringBuffer("");
	


	public BuildDaoImpl(Class<?> clz,String idName,String folder) {
		super();
		this.clz = clz;
		this.idName = idName;
		this.folder = folder;
	}
	
	public void execute(){
		
		this.head();
		this.add();
		this.update();
		this.delete();
		this.verify();
		this.unVerify();
		this.get();
		this.query();
		this.end();
		FileUtil.setFileContent(folder, clz.getSimpleName()+"DaoImpl.java", content.toString());
		
	}
	
	
	
	
	private void head(){
		
		content.append("package "+BuildConstant.packageName+".dao.impl;");

		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
		
		content.append("import java.util.HashMap;");
		content.append(BuildConstant.enterMark);
		content.append("import java.util.List;");
		content.append(BuildConstant.enterMark);
		content.append("import java.util.Map;");
		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
		

		content.append("import org.springframework.stereotype.Component;");
		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
		
		

		content.append("import "+BuildConstant.packageName+".dao.I"+clz.getSimpleName()+"Dao;");
		content.append(BuildConstant.enterMark);
		
		content.append("import "+BuildConstant.packageName+".domain.business."+clz.getSimpleName()+";");
		content.append(BuildConstant.enterMark);

		content.append("import com.pm.vo.UserPermit;");
		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);

		content.append("import com.common.daos.BatisDao;");
		content.append(BuildConstant.enterMark);
		content.append("import com.common.beans.Pager;");

		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);


		content.append("@Component");
		content.append(BuildConstant.enterMark);
		content.append("public class "+clz.getSimpleName()+"DaoImpl extends BatisDao implements I"+clz.getSimpleName()+"Dao  {");

		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
	}
	
	
	private void add(){
		content.append("	@Override");
		content.append(BuildConstant.enterMark);
		content.append("	public int add"+clz.getSimpleName()+"("+clz.getSimpleName()+" "+StringUtil.firstLowerCase(clz.getSimpleName())+") {");
		content.append(BuildConstant.enterMark);

		content.append("		String sql = \""+clz.getSimpleName()+"Mapping.add"+clz.getSimpleName()+"\";");
		content.append(BuildConstant.enterMark);
		content.append("		return this.insert(sql, "+StringUtil.firstLowerCase(clz.getSimpleName())+");");
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

		content.append("		String sql = \""+clz.getSimpleName()+"Mapping.update"+clz.getSimpleName()+"\";");
		content.append(BuildConstant.enterMark);
		content.append("		return this.update(sql, "+StringUtil.firstLowerCase(clz.getSimpleName())+");");
		content.append(BuildConstant.enterMark);		
		content.append("	}");	
		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);	
	}

	private void delete(){
		content.append("	@Override");
		content.append(BuildConstant.enterMark);
		content.append("	public void delete"+clz.getSimpleName()+"("+clz.getSimpleName()+" "+StringUtil.firstLowerCase(clz.getSimpleName())+") {");
		content.append(BuildConstant.enterMark);

		content.append("		String sql = \""+clz.getSimpleName()+"Mapping.delete"+clz.getSimpleName()+"\";");
		content.append(BuildConstant.enterMark);
		content.append("		this.delete(sql, "+StringUtil.firstLowerCase(clz.getSimpleName())+");");
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

		content.append("		String sql = \""+clz.getSimpleName()+"Mapping.verify"+clz.getSimpleName()+"\";");
		content.append(BuildConstant.enterMark);
		content.append("		this.update(sql, "+StringUtil.firstLowerCase(clz.getSimpleName())+");");
		content.append(BuildConstant.enterMark);		
		content.append("	}");	
		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);	
	}
	
	private void unVerify(){
		content.append("	@Override");
		content.append(BuildConstant.enterMark);
		content.append("	public void unVerify"+clz.getSimpleName()+"("+clz.getSimpleName()+" "+StringUtil.firstLowerCase(clz.getSimpleName())+") {");
		content.append(BuildConstant.enterMark);

		content.append("		String sql = \""+clz.getSimpleName()+"Mapping.unVerify"+clz.getSimpleName()+"\";");
		content.append(BuildConstant.enterMark);
		content.append("		this.update(sql, "+StringUtil.firstLowerCase(clz.getSimpleName())+");");
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
		content.append(BuildConstant.enterMark);
		content.append("		String sql = \""+clz.getSimpleName()+"Mapping.get"+clz.getSimpleName()+"\"; ");
		content.append(BuildConstant.enterMark);
		content.append("		"+clz.getSimpleName()+" "+StringUtil.firstLowerCase(clz.getSimpleName())+" = new "+clz.getSimpleName()+"(); ");
		content.append(BuildConstant.enterMark);
		content.append("		"+StringUtil.firstLowerCase(clz.getSimpleName())+".set"+StringUtil.firstUpperCase(idName)+"(id); ");
		content.append(BuildConstant.enterMark);
		content.append("		List<"+clz.getSimpleName()+"> list = this.query(sql, "+clz.getSimpleName()+".class, "+StringUtil.firstLowerCase(clz.getSimpleName())+"); ");
		content.append(BuildConstant.enterMark);
		content.append("		if(list == null || list.isEmpty()) return null; ");
		content.append(BuildConstant.enterMark);
		content.append("		else return list.get(0);	");	
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
		content.append("		String sql = \""+clz.getSimpleName()+"Mapping.query"+clz.getSimpleName()+"\"; ");
		content.append(BuildConstant.enterMark);
		
		content.append("		Pager<"+clz.getSimpleName()+"> pager1 =  this.query4Pager(pager.getPageNo(), pager.getPageSize(), sql,"
					+clz.getSimpleName()+".class, "+StringUtil.firstLowerCase(clz.getSimpleName())+",userPermit); ");
		
		content.append(BuildConstant.enterMark);
		
		content.append("		sql = \""+clz.getSimpleName()+"Mapping.query"+clz.getSimpleName()+"TotalAmount\";"+BuildConstant.enterMark);
		content.append("		Map<String,Object> map = new HashMap<String,Object>();"+BuildConstant.enterMark);
		content.append("		if("+StringUtil.firstLowerCase(clz.getSimpleName())+" != null) map.put("+StringUtil.firstLowerCase(clz.getSimpleName())+".getClass().getSimpleName(), "+StringUtil.firstLowerCase(clz.getSimpleName())+");"+BuildConstant.enterMark);
		content.append("		if(userPermit != null) map.put(userPermit.getClass().getSimpleName(), userPermit);"+BuildConstant.enterMark);
		
		content.append("		Double amount = getSqlSession().selectOne(sql,map);"+BuildConstant.enterMark);
		content.append("		if(amount != null) {"+BuildConstant.enterMark);
		content.append("			double total_amount = amount.doubleValue();"+BuildConstant.enterMark);
		content.append("			pager1.setTotal_amount(total_amount);"+BuildConstant.enterMark);
		content.append("		}"+BuildConstant.enterMark);
		content.append("		return pager1;"+BuildConstant.enterMark);

		content.append("	}");	

		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);	
	}
	
	
	

	private void end(){
		content.append(BuildConstant.enterMark);
		content.append("}");
	}
	

}
