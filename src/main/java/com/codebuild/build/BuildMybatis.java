package com.codebuild.build;

import java.lang.reflect.Field;

import com.codebuild.BuildConstant;
import com.codebuild.build.util.FileUtil;
import com.codebuild.build.util.ReflectHelper;
import com.codebuild.build.util.StringUtil;

public class BuildMybatis implements IBuilderService{
	
	private Class<?> clz ;
	private String table;
	private String alias;
	private String idName;
	private String folder;
	
	
	
	
	private StringBuffer content = new StringBuffer("");
	private String namespace = null;
	private String resultMapId = null;
	
	ReflectHelper refect = null;
	
	


	public BuildMybatis(Class<?> clz,String table,String alias,String idName,String folder) {
		super();
		this.clz = clz;
		this.table = table;
		this.alias = alias;
		this.idName = idName;
		this.folder = folder;
		try {
			refect = new ReflectHelper(clz.newInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void execute(){
		
		this.head();
		this.namespace();
		this.map();
		this.get();
		this.add();
		this.update();
		verify();
		this.unVerify();
		this.delete();
		this.queryTotalAmount();
		this.queryByPager_mysql();
		this.queryByCount_mysql();
		this.pagerSql();
		this.end();
		
		FileUtil.setFileContent(folder, clz.getSimpleName()+".xml", content.toString());
		
	}
	
	
	
	
	
	private void head(){
		content.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+BuildConstant.enterMark);
		content.append("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\""+BuildConstant.enterMark);
		content.append("  	\"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">  "+BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
		
		
	}
	
	private void namespace(){
		namespace = clz.getSimpleName()+"Mapping";
		content.append("	<mapper namespace=\""+namespace+"\">"	+BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
	}
	
	private void map(){
		resultMapId = StringUtil.firstLowerCase(clz.getSimpleName()) + "Map";
		content.append("	<resultMap type=\"java.util.Map\" id=\"map\" />" +BuildConstant.enterMark);
		content.append("	<resultMap type=\""+clz.getName()+"\" id=\""+resultMapId+"\" />" +BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
	}
	
	
	private void get(){		
		String get_name = "get"+clz.getSimpleName();
		content.append("	<select id=\""+get_name+"\" parameterType=\""+clz.getName()+"\" resultMap=\""+resultMapId+"\">");
		content.append(BuildConstant.enterMark);
					
		content.append("		select "+alias+".* ,project.project_name,project.project_no" +BuildConstant.enterMark);		
		content.append("		from "+table+" "+alias+BuildConstant.enterMark);	
		content.append("		INNER JOIN vb_project project " +BuildConstant.enterMark);		
		content.append("		on "+alias+".project_id = project.project_id " +BuildConstant.enterMark);		
		content.append("		where "+alias+"."+idName+" = #{"+idName+"}" +BuildConstant.enterMark);
		content.append("	</select>");	
		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);	
	}
	

	private void add(){
		String add_name = "add"+clz.getSimpleName();
		content.append("	<insert id=\""+add_name+"\" parameterType=\""+clz.getName()+"\" >");
		content.append(BuildConstant.enterMark);
					
		content.append("		insert into  "+table+"(" +BuildConstant.enterMark);		
		int index = 0;
		int size = refect.getFieldList().size();
		for(Field field :refect.getFieldList()){
			
			if(index%5==0) content.append("			");
			content.append(field.getName());
			if(index < size-1) content.append(",");
			if(index%5==4) content.append(BuildConstant.enterMark);
			index ++;
		}
		content.append(BuildConstant.enterMark);		
		content.append("		)values  (");
		content.append(BuildConstant.enterMark);
		
		index = 0;
		for(Field field :refect.getFieldList()){			
			if(index%5==0) content.append("			");
			content.append("#{"+field.getName()+"}");
			if(index < size-1) content.append(",");
			if(index%5==4) content.append(BuildConstant.enterMark);
			index ++;
		}
		content.append(BuildConstant.enterMark);
		content.append("		)"+BuildConstant.enterMark);
		content.append("	</insert>");	
		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
	}
	
	
	

	private void update(){
		String update_name = "update"+clz.getSimpleName();
		content.append("	<update id=\""+update_name+"\" parameterType=\""+clz.getName()+"\" >");
		content.append(BuildConstant.enterMark);
					
		content.append("		update  "+table+" set " +BuildConstant.enterMark);		
		
		int index = 0;
		int size = refect.getFieldList().size();
		
		for(Field field :refect.getFieldList()){
			
			String name = field.getName();
			
			if(!name.equals(idName)){
				content.append("		"+field.getName() +"=#{"+name+"}");
				if(index < size-2) content.append(",");
				content.append(BuildConstant.enterMark);
				index ++;
			}
			
			
		}
		content.append("		where "+idName + "=#{" +idName+"} ");
		content.append(BuildConstant.enterMark);
		content.append("		and verify_userid is null ");
		content.append(BuildConstant.enterMark);
		content.append("	</update>");	
		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
	}
	
	
	
	private void verify(){
		
		String verify_name = "verify"+clz.getSimpleName();
		content.append("	<update id=\""+verify_name+"\" parameterType=\""+clz.getName()+"\" >");
		content.append(BuildConstant.enterMark);
					
		content.append("		update  "+table+" set " +BuildConstant.enterMark);		
		
		content.append("		verify_userid = #{verify_userid}, "+BuildConstant.enterMark
				+ "		verify_username =  #{verify_username}, "+BuildConstant.enterMark
				+ "		verify_datetime = #{verify_datetime} " +BuildConstant.enterMark);
		
		content.append("		where "+idName + "=#{" +idName+"}"+BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
		content.append("		and verify_userid is null");
		content.append(BuildConstant.enterMark);
		content.append("	</update>");	
		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
		
	}
	

	private void unVerify(){
		
		String unVerify_name = "unVerify"+clz.getSimpleName();
		content.append("	<update id=\""+unVerify_name+"\" parameterType=\""+clz.getName()+"\" >");
		content.append(BuildConstant.enterMark);
					
		content.append("		update  "+table+" set " +BuildConstant.enterMark);		
		
		content.append("		verify_userid = null, "+BuildConstant.enterMark
				+ "		verify_username = null, "+BuildConstant.enterMark
				+ "		verify_datetime = null" +BuildConstant.enterMark);
		
		content.append("		where "+idName + "=#{" +idName+"}"+BuildConstant.enterMark);
		content.append("	</update>");	
		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
		
	}

	private void delete(){
		
		String delete_name = "delete"+clz.getSimpleName();
		content.append("	<delete id=\""+delete_name+"\" parameterType=\""+clz.getName()+"\" >");
		content.append(BuildConstant.enterMark);
		content.append("		delete from  "+table +BuildConstant.enterMark);			
		content.append("		where "+idName + "=#{" +idName+"}"+BuildConstant.enterMark);
		content.append("		and verify_userid is null");
		content.append(BuildConstant.enterMark);
		content.append("	</delete>");	
		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
		
	}
	
	
	
	
	

	private void queryTotalAmount(){
		String query_name = "query"+clz.getSimpleName()+"TotalAmount";
		content.append("	<select id=\""+query_name+"\" parameterType=\"map\"  resultType=\"double\" >");
		content.append(BuildConstant.enterMark);
		
		content.append("		SELECT sum(amount) FROM ("+BuildConstant.enterMark);
		content.append("			<include refid=\""+StringUtil.firstLowerCase(clz.getSimpleName())+"PagerSql\"/>"+BuildConstant.enterMark);
		content.append("		) c"+BuildConstant.enterMark);
		content.append("	</select>");	
		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
	}



	private void queryByPager_mysql(){
		String query_name = "query"+clz.getSimpleName()+"ByPager_mysql";
		content.append("	<select id=\""+query_name+"\" parameterType=\"map\"  resultMap=\""+resultMapId+"\" >");
		content.append(BuildConstant.enterMark);
		
		content.append("		<include refid=\""+StringUtil.firstLowerCase(clz.getSimpleName())+"PagerSql\"/> LIMIT #{page.startRow},#{page.pageSize}"+BuildConstant.enterMark);
		content.append("	</select>");	
		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
	}
	
	
	private void queryByCount_mysql(){
		String query_name = "query"+clz.getSimpleName()+"ByCount_mysql";
		content.append("	<select id=\""+query_name+"\" parameterType=\"map\"  resultType=\"int\" >");
		content.append(BuildConstant.enterMark);
		
		content.append("		SELECT COUNT(*) FROM (<include refid=\""+StringUtil.firstLowerCase(clz.getSimpleName())+"PagerSql\"/> )c"+BuildConstant.enterMark);
		content.append("	</select>");	
		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
	}
	

	private void pagerSql(){

		String query_name = StringUtil.firstLowerCase(clz.getSimpleName())+"PagerSql";
		content.append("	<sql id=\""+query_name+"\">");
		content.append(BuildConstant.enterMark);
		
		content.append("		select "+alias+".* ,project.project_name,project.project_no "+BuildConstant.enterMark);	
		content.append("		from "+table+" "+alias+"  "+BuildConstant.enterMark);	
		content.append("		INNER JOIN vb_project project  "+BuildConstant.enterMark);	
		content.append("		on "+alias+".project_id = project.project_id "+BuildConstant.enterMark);
		content.append("		WHERE 1=1 ");
		content.append(BuildConstant.enterMark);
		content.append("		<include refid=\"permission\" /> "+BuildConstant.enterMark);		
		//content.append("	order by pe.use_month  desc,pe.project_id "+BuildConstant.enterMark);
		content.append("	</sql>");	
		content.append(BuildConstant.enterMark);
		content.append(BuildConstant.enterMark);
	}
	
	
	
	
	private void end(){

		content.append("</mapper>");
	}
	

}
