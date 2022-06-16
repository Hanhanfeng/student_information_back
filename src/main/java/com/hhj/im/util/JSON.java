package com.hhj.im.util;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import flexjson.transformer.DateTransformer;

import java.sql.Timestamp;
import java.util.Date;

public class JSON {
	public static String encode(Object obj) {
		if(obj == null || obj.toString().equals("null")) return null;
		if(obj != null && obj.getClass() == String.class){
			return obj.toString();
		}
		JSONSerializer serializer = new JSONSerializer();
		serializer.transform(new DateTransformer("yyyy-MM-dd'T'HH:mm:ss"), Date.class);
		serializer.transform(new DateTransformer("yyyy-MM-dd'T'HH:mm:ss"), Timestamp.class);
		return serializer.deepSerialize(obj);
	}
	public static Object decode(Object str) {
		String json = str == null ? null : str.toString();
		if (StringUtil.isNullOrEmpty(json)) return "";
		JSONDeserializer deserializer = new JSONDeserializer();
		deserializer.use(String.class, new DateTransformer("yyyy-MM-dd'T'HH:mm:ss"));		
		Object obj = deserializer.deserialize(json);
		if(obj != null && obj.getClass() == String.class){
			return decode(obj.toString());
		}		
		return obj;
	}
	
	public static Object decode(String json) {
		if (StringUtil.isNullOrEmpty(json)) return "";
		JSONDeserializer deserializer = new JSONDeserializer();
		deserializer.use(String.class, new DateTransformer("yyyy-MM-dd'T'HH:mm:ss"));		
		Object obj = deserializer.deserialize(json);
		if(obj != null && obj.getClass() == String.class){
			return decode(obj.toString());
		}		
		return obj;
	}
}

