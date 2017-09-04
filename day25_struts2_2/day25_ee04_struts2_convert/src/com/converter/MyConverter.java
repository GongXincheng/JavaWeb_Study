package com.converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class MyConverter extends StrutsTypeConverter {
	
	private DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
	
	public Object convertFromString(Map arg0, String[] values, Class toClass) {
		//判断values是否为空
		if(values.length==0 || values==null){
			return null;
		}
		//如果不为空 获取数组的第一个元素
		String value = values[0]; 
		//判断目标类型的自己嘛是不是日期类型
		if(toClass == java.util.Date.class){
			try {
				return format.parse(value);
			} catch (ParseException e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	public String convertToString(Map arg0, Object object) {
		//判断object是否是日期类型
		if(object instanceof Date){
			//强转成日期类型
			Date date = (Date)object;
			//转化成字符串
			return format.format(date);
		}
		
		return null;
	}

}
