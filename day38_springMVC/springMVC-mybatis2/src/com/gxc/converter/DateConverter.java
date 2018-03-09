package com.gxc.converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.core.convert.converter.Converter;

public class DateConverter implements Converter<String, Date>{

	@Override
	public Date convert(String source) {
		try {
			if(source!=null){
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date = df.parse(source);
				return date;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}


}
