package com.dentist.utils;

import java.util.List;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class JsonUtils {
	
	public static <T> T stringToObject(String s, Class<T> clazz)
	{
		return JSON.parseObject(s, clazz);
	}
	
	public static <T> List<T> stringToList(String s, Class<T> clazz)
	{
		return JSON.parseArray(s, clazz);
	}
	
	public static String objectToString(Object obj)
	{
//		return JSON.toJSONString(obj);
		//禁止循环引用
		return JSON.toJSONStringWithDateFormat(obj,"yyyy-MM-dd HH:mm:ss",SerializerFeature.DisableCircularReferenceDetect);
	}
	

}
