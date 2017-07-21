package com.heu.eam.utils;

import java.util.UUID;

public class UploadUtils {
/*
 * 获取随机名称
 * 
 * */
	
	public static String getUUIDName(String realName){
		int index=realName.lastIndexOf(".");
		if(index==-1){
			return UUID.randomUUID().toString().replace("-", "").toUpperCase();
		}else{
			return UUID.randomUUID().toString().replace("-", "").toUpperCase()+realName.substring(index);
		}
		
	}
/*
 * 
 * 获取真实名称
 * */
	public static String getRealName(String Name){
		int index=Name.lastIndexOf("\\");
		return Name.substring(index+1);
	}


	
	
}
