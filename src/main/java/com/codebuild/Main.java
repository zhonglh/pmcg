package com.codebuild;

import java.util.ArrayList;
import java.util.List;

import com.codebuild.build.BuildAction;
import com.codebuild.build.BuildDao;
import com.codebuild.build.BuildDaoImpl;
import com.codebuild.build.BuildJspEdit;
import com.codebuild.build.BuildJspExcelList;
import com.codebuild.build.BuildJspList;
import com.codebuild.build.BuildJspUpload;
import com.codebuild.build.BuildJspView;
import com.codebuild.build.BuildMybatis;
import com.codebuild.build.BuildService;
import com.codebuild.build.BuildServiceImpl;
import com.codebuild.build.IBuilderService;
import com.pm.domain.business.Insurance;

public class Main {
	
	public static void main(String[] args){
		
		Insurance s = new Insurance();
		
		String folder = "C:\\GeneraterCode";
		Class clz = s.getClass();
		String table = "tb_Insurance";
		String alias = "ti";
		String idName = "id";
		String menuId = "90";
		String module = "insurance";
		String fnName = "员工保险";
		String excelTemplet = "员工保险";
		
		IBuilderService action = new BuildAction(clz,idName,menuId,module,excelTemplet,folder);
		
		IBuilderService service = new BuildService(clz, folder);
		IBuilderService serviceImpl = new BuildServiceImpl(clz, idName, folder);
		
		IBuilderService dao = new BuildDao(clz, folder);
		IBuilderService daoImpl = new BuildDaoImpl(clz,idName, folder);
		
		IBuilderService mybatis = new BuildMybatis(clz,table , alias ,idName, folder);
		 
		IBuilderService listjsp = new BuildJspList(clz,idName, fnName, folder);
		IBuilderService excellistjsp = new BuildJspExcelList(clz, folder);
		IBuilderService uploadjsp = new BuildJspUpload(clz,fnName, folder);
		IBuilderService editjsp = new BuildJspEdit(clz,idName, folder);
		IBuilderService viewjsp = new BuildJspView(clz,idName, folder);
		
		List<IBuilderService> list = new ArrayList<IBuilderService>();
		list.add(action);
		list.add(service);
		list.add(serviceImpl);
		list.add(dao);
		list.add(daoImpl);
		list.add(mybatis);
		list.add(listjsp);
		list.add(excellistjsp);
		list.add(uploadjsp);
		list.add(editjsp);
		list.add(viewjsp);
		
		
		
		
		
		for(IBuilderService builderService : list){
			builderService.execute();
		}
		
		
	}
	
	
	

	
	

}
