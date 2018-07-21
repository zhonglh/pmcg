package com.pm.util.log;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface EntityAnnotation {
	
	public String item_name() ;
	
	public int item_sort() default 0;

	public int length() default 0;
}
