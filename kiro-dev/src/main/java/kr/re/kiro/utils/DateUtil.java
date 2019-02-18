package kr.re.kiro.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * <pre>
 * kr.re.kiro.utils
 * DateUtil.java
 * </pre>
 *
 * @Author : Kim sungkeun
 * @Date   : 2019. 2. 18.
 * @Version: 
 */
public class DateUtil {

	public static Date Str2Date(String dateStr) throws ParseException {
		if (dateStr == null) return null;
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return dt.parse(dateStr);
	}

	public static String Date2Str(Date date) {
		if (date == null) return null;
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return dt.format(date);
	}

	public static Date addMinute(Date date, int minute) {
		Calendar cal = Calendar.getInstance(Locale.KOREAN);
		cal.setTime(date);
		cal.add(Calendar.MINUTE, minute);
		return cal.getTime();
	}
}
