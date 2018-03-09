package com.gxc.conversion;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.core.convert.converter.Converter;

/**
 * 转换日期类型的数据
 * S:页面传递过来的类型
 * T:转换后的类型
 * 
 * @author 宫新程
 *
 */
public class DateConveter implements Converter<String, Date>{

	@Override
	public Date convert(String source) {
		try{
			if(source != null){
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date = df.parse(source);
				return date;
			}
		}catch(Exception e){
			System.out.println(e);
		}
		return null;
	}

}
