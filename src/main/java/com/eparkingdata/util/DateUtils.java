package com.eparkingdata.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class DateUtils {
	
	/**
	 * 毫秒转时间串
	 */
	public static String getDateStrbyms(long ms) {
		Date date = new Date(ms);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
	
	/**
	 * 根据时间类型来获得开始时间和结束时间这一段时间的范围
	 * 
	 * @param startTime
	 * @param endTime
	 * @param quarterStart
	 * @param quarterEnd
	 * @param dateType
	 * @return
	 */
	public static String getDateRang(String startTime, String endTime, String quarterStart, String quarterEnd, String dateType) {
		String dateRang = "";
		if ("year".equals(dateType)) {// 年份
			int intEndTime = Integer.parseInt(endTime) - 1;
			dateRang = startTime + "年～" + String.valueOf(intEndTime) + "年";
		} else if ("quarter".equals(dateType)) {// 季度
			dateRang = startTime + "-" + quarterStart + "季度～" + endTime + "-" + quarterEnd + "季度";
		} else if ("month".equals(dateType)) {// 月份
			String[] m = new String[2];
			m = endTime.split("-");
			int year = Integer.parseInt(m[0]);
			int month = Integer.parseInt(m[1]);
			if (month <= 1) {
				year--;
				month = 12;
				dateRang = startTime + "～" + year + "-" + month;
			} else if (month >= 11) {
				month--;
				dateRang = startTime + "～" + year + "-" + month;
			} else {
				month--;
				dateRang = startTime + "～" + year + "-0" + month;
			}
		} else {// 日
			dateRang = startTime + "～" + endTime;
		}
		return dateRang;
	}


	/**
	 * 将字符型的时间转为Date型的时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date parse(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 将字符型的时间转为Date型的时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date parse(String date, String dateType) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" + dateType);
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 将Date型时间转换为字符型时间
	 * 
	 * @param date
	 * @return
	 */
	public static String format(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ssss");
		return sdf.format(date);
	}
	

	/**
	 * 格式化时间
	 * 
	 * @param date
	 * @return
	 */
	public static String dateFormat(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (date != null) {
			return sdf.format(date);
		} else
			return "";
	}

	/**
	 * 如果传入时间为空则将其设置为Strings.DEFAULT_DATE
	 * 
	 * @param date
	 * @return
	 */
//	public static Date formatDefault(Date date) {
//		if (date == null || date.toString() == "") {
//			return DateUtils.parse(Strings.DEFAULT_DATE);
//		} else {
//			return date;
//		}
//	}

	/**
	 * 获得现在时间
	 * 
	 * @return
	 */
	public static String nowTime() {
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(today);
	}
	
	/**
	 * 获得现在时间
	 * 
	 * @return
	 */
	public static String nowTimeHHmmss() {
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		return sdf.format(today);
	}

	/**
	 * 获得现在时间
	 * 
	 * @return
	 */
	public static String today() {
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(today);
	}
	
	public static String cToday() {
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		return sdf.format(today);
	}

	/**
	 * 格式化时间格式 例：2012-12-12 12:12:12.0 转成2012-12-12 12:12:12
	 * 
	 * @param date
	 * @return
	 */
	public static String dateFomat(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}

	public static String changeMinute(String atime, Integer minute) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = DateUtils.parse(atime);
		String time_now = format.format(date);
		long time = date.getTime() + (minute * 60 * 1000);
		Date date1 = new Date(time);
		String time_before = format.format(date1);
		return time_before;
	}

	/**
	 * *****************************计算缴费日期**************************************
	 * ***
	 */
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * 自然月
	 * 
	 * @param payType
	 * @param chargeType
	 * @param date1
	 * @param count
	 * @return
	 * @throws ParseException
	 */
	public static String general(int payType, int chargeType, String date1, int count) throws ParseException {
		String date = date1;
		if (payType == 1) {
			int year = Integer.parseInt(date.split("-")[0]);
			int month = Integer.parseInt(date.split("-")[1]);
			int day = Integer.parseInt(date.split("-")[2]);
			if (chargeType == 3) { // 按年
				year += count;
			} else if (chargeType == 1) { // 按月
				if (count + month > 12) {
					year += (count + month) / 12;
					month = (count + month) % 12;
					// if (month == 0) {
					// month = 1;
					// }
				} else {
					month += count;
				}
				if (day > 28) {
					if (getDayByMonth(year + "-" + month) < day) {
						day = getDayByMonth(year + "-" + month);
					}
				}
			} else if (chargeType == 2) { // 按季度
				if (count * 3 + month >= 12) {
					year += (count * 3 + month) / 12;
					month = (count * 3 + month) % 12;
				} else {
					month += count * 3;
				}
				if (day > 28) {
					if (getDayByMonth(year + "-" + month) < day) {
						day = getDayByMonth(year + "-" + month);
					}
				}
			} else if (chargeType == 0) { // 按天
				Calendar c = Calendar.getInstance();
				c.setTime(sdf.parse(date));
				c.add(Calendar.DAY_OF_MONTH, count);
				return sdf.format(c.getTime());
			}
			return sdf.format(sdf.parse(year + "-" + month + "-" + day));
		} else if (payType == 2) {
			return thisMonthEnd(date, count);
		} else if (payType == 3) {
			return nextMonthEnd(date, count);
		}
		return "";
	}

	/**
	 * 本月底
	 * 
	 * @param date
	 * @param count
	 * @return
	 * @throws ParseException
	 */
	public static String thisMonthEnd(String date, int count) throws ParseException {
		Calendar calendar = new GregorianCalendar();  
		
		/*int year = Integer.parseInt(date.split("-")[0]);
		int month = Integer.parseInt(date.split("-")[1]);
		if (count + month >= 12) {
			year += (count + month) / 12;
			month = (count + month) % 12;
		} else {
			month += count;
		}
		return sdf.format(sdf.parse(year + "-" + month + "-01"));*/
		
		calendar.add(Calendar.MONTH, 1);  
        calendar.set(Calendar.DAY_OF_MONTH, 0);  
        return sdf.format(calendar.getTime());
        
	}

	/**
	 * 下个月月底
	 * 
	 * @param date
	 * @param count
	 * @return
	 * @throws ParseException
	 */
	public static String nextMonthEnd(String date, int count) throws ParseException {
		String date1 = thisMonthEnd(date, count);
		int year = Integer.parseInt(date1.split("-")[0]);
		int month = Integer.parseInt(date1.split("-")[1]);
		if (month == 12) {
			year += 1;
			month = 1;
		} else {
			month += 1;
		}
		return sdf.format(sdf.parse(year + "-" + month + "-01"));
	}

	/**
	 * 获取当前月份天数
	 * 
	 * @param date
	 * @return
	 */
	public static int getDayByMonth(String date) {
		int year = Integer.parseInt(date.split("-")[0]);
		int month = Integer.parseInt(date.split("-")[1]);
		int days[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (2 == month && 0 == (year % 4) && (0 != (year % 100) || 0 == (year % 400))) {
			days[1] = 29;
		}
		return Integer.valueOf(days[month - 1]);
	}

	/**
	 * 返回当前月份
	 * @param date
	 * @return
	 */
	public static int getCurMonth(String date){
		int year = Integer.parseInt(date.split("-")[0]);
		int month = Integer.parseInt(date.split("-")[1]);
		return month;
	}

	/**
	 * 字符串的日期格式的计算
	 */
	public static int daysBetween(String smdate, String bdate) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			cal.setTime(sdf.parse(smdate));
			long time1 = cal.getTimeInMillis();
			cal.setTime(sdf.parse(bdate));
			long time2 = cal.getTimeInMillis();
			long between_days = (time2 - time1) / (1000 * 3600 * 24);
			return Integer.parseInt(String.valueOf(between_days));
		} catch (Exception e) {
			return 0;
		}
	}

	/**
	 * 两个时间相差几个小时
	 */
	public static int minutesBetween(String smdate, String bdate) {
		long inT = DateUtils.parse(smdate).getTime();
		long outT = DateUtils.parse(bdate).getTime();
		long ss = (outT - inT) / (1000); // 共计秒数
		int MM = (int) ss / 60; // 共计分钟数
		return MM;
	}

	public static String getHexDate(String date) {
		return date.replace("-", "");
	}

	/** 某个时间的多少天前是什么时候 */
	public static String dateDiff(String date, int day) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			// Date date = new Date();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(sdf.parse(date));
			calendar.add(Calendar.DAY_OF_MONTH, day);
			date = dateFormat(calendar.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	/** 此时的多少天前是什么时候 */
	public static String dateDiff(int day) {
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, day);
		date = calendar.getTime();
		return dateFormat(date);
	}

	/**
	 * 根据某个日期得到前一天日期
	 * 
	 * @param d
	 * @return
	 */
	public static Date getBeforeDate(Date d) {
		Date date = null;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		date = calendar.getTime();
		return date;
	}

	/**
	 * 得到某个日期的后一天日期
	 * 
	 * @param d
	 * @return
	 */
	public static Date getAfterDate(Date d) {
		Date date = null;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		date = calendar.getTime();
		return date;
	}
	
	 /**
	 * 得到某个日期前后几天日期
	 * 
	 * @param d
	 * @return
	 */
	public static Date getAfterDate(Date d, int i) {
		Date date = null;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		calendar.add(Calendar.DAY_OF_MONTH, i);
		date = calendar.getTime();
		return date;
	}
	/**
	  * 分钟差
	  * @param date
	  * @param i
	  * @return
	  */
	public static Date getBeforeDay_minute(Date date, int i){  
	  	Calendar calendar = new GregorianCalendar();
	  	calendar.setTime(date);
	  	calendar.add(calendar.MINUTE, i);
	  	date = calendar.getTime(); 
	      return date;  
	 } 
	 /**
	  * 小时差
	  * @param date
	  * @param i
	  * @return
	  */
	public static String getBeforeDay_hour(Date date, int i)
	{  
		  Calendar calendar = new GregorianCalendar();
		  calendar.setTime(date);
		  calendar.add(calendar.HOUR, i);
		  date = calendar.getTime(); 
		  return dateFormat(date);  
	} 	
	

	public static long dateToLong(String date) {
		try {
			if (date.length() <= 10) {
				date = date + " 23:59:59";
			}
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			return df.parse(date).getTime();
		} catch (Exception e) {
			//LogUtils.error("判断月卡是否过期时转换时间错误", e);
			return 10000000;
		}
	}

	public static String nowTimeMS() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss,SSS");
		String datetime = sdf.format(new Date());
		return datetime;
	}
	
	/**
	 * 到某个时间还有多少毫秒
	 * 
	 * @param
	 * @return
	 * @return
	 * @return
	 * @return
	 * @return
	 * @return
	 * @return
	 */
	public static int getTimeMS(String dstr) {
		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dstr);
			long s1 = date.getTime();// 将时间转为毫秒
			long s2 = System.currentTimeMillis();// 得到当前的毫秒
			int day = (int) (s1 - s2);
			return day;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	  * 是否是周末或周六
	  * 
	  * @param date
	  * @return true 是 else 否
	  */
	 public static boolean isSaturday(Date date)
	 {  
		 Calendar cal = Calendar.getInstance();
		 cal.setTime(date);
		 if(cal.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY||cal.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY)
		   return true;
		 else 
		   return false;
	  } 
	 
	/**
	 * @throws ParseException
	 * 
	 ***************************************************************************/
	public static void main(String[] args) throws ParseException {
		System.out.println(changeMinute("2015-05-14 10:45:25", 0));
	}
}
