package com.codebuild.build.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.pm.util.log.EntityAnnotation;

public class FieldUtil {
	

	
	public static   <T> List<Colume> getColume(Class<T> clz) {
		return getColume(clz, false,false);
	}
	
	public static   <T> List<Colume> getImportColume(Class<T> clz) {	
		return getColume(clz, false,true);
	}
	
	public static   <T> List<Colume> getColume(final Class<T> clz,boolean isAll,boolean isImport) {		
		
		synchronized(clz){
			Field[] fs =  getAllField(clz);

			if(fs == null || fs.length == 0) return null;
			List<Colume> list = new ArrayList<Colume>();
			for(Field f : fs){
				if(f.isAnnotationPresent(EntityAnnotation.class)){
					EntityAnnotation entityAnnotation = f.getAnnotation(EntityAnnotation.class);
					if(!isAll){
						if(entityAnnotation.item_sort() <= 0) continue;
						if(isImport) {
							if(entityAnnotation.length() <= 0) continue;
						}
					}
					Colume colume = new Colume();
					colume.setCode(f.getName());
					colume.setName(entityAnnotation.item_name());
					colume.setNumber(entityAnnotation.item_sort());
					colume.setLength(entityAnnotation.length());
					colume.setField(f);
					list.add(colume);
				}
			}
			if(list != null && list.size()>0){
				Collections.sort(list,new FieldUtil().new ColumeComparator());
			}
			
			return list;
		}
		
		
	}
	
	public static Field[] getAllField(Class<?> clazz) {
		ArrayList<Field> fieldList = new ArrayList<Field>();
		Field[] dFields = clazz.getDeclaredFields();
		if (null != dFields && dFields.length > 0) {
			fieldList.addAll(Arrays.asList(dFields));
		}

		Class<?> superClass = clazz.getSuperclass();
		if (superClass != Object.class) {
			Field[] superFields = superClass.getDeclaredFields();
			if (null != superFields && superFields.length > 0) {
				fieldList.addAll(Arrays.asList(superFields));
			}
		}
		Field[] result=new Field[fieldList.size()];
		fieldList.toArray(result);
		return result;
	}
	
	
	
	
	public class ColumeComparator implements Comparator<Colume> {
		public int compare(Colume colume1,Colume colume2){
			int result = colume1.getNumber() - colume2.getNumber() ;
			if(result == 0){
				return colume1.getName().compareTo(colume2.getName());
			}else {
				return  result;
			}
		}

	}

}
