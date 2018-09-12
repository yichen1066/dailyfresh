package cn.itclass.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 	时间日期转换工具类
 * 
 * @author Yi Chen
 *
 */
public class DateUtils {
	public static String DateToString(Date date, String pattern){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat.format(date);
	}
	
	public static Date StringToDate(String date, String pattern) throws ParseException{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat.parse(date);
	}
}
