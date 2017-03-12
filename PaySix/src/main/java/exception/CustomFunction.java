package exception;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class CustomFunction {

	
	


	
	
	
	
	/*
	 * 	어제 총 매출 데이터 ( 00-24 )
	 * 	어제 현재시간까지 매출 데이터 ( 00-hh )
	 * 	어제 현재시간 매출 데이터 ( yester.hh == today.hh )
	 */
	
	
	
	//	어제의 00시
	public String getYester_midNight(){
		
		Calendar cal = new GregorianCalendar();
		cal.add(Calendar.DATE, -1);
				
	    int year = cal.get(Calendar.YEAR);
	    int month = cal.get(Calendar.MONTH) + 1;
	    int day = cal.get(Calendar.DAY_OF_MONTH);	    	    
	    
		return year + "-" + month + "-" + day + " " + "00";
	}
	
	
	//	어제의 현재시간
	public String getYester_currentTime(){
		
		Calendar cal = new GregorianCalendar();
		cal.add(Calendar.DATE, -1);
				
	    int year = cal.get(Calendar.YEAR);
	    int month = cal.get(Calendar.MONTH) + 1;
	    int day = cal.get(Calendar.DAY_OF_MONTH);	    	    
	    int hour = cal.get(Calendar.HOUR_OF_DAY);
	    
		return year + "-" + month + "-" + day + " " + hour;
	}
	
	
	//	오늘의 00시
	public String getToday_midNight(){
		
		Calendar cal = new GregorianCalendar();
		cal.add(Calendar.DATE, 0);
				
	    int year = cal.get(Calendar.YEAR);
	    int month = cal.get(Calendar.MONTH) + 1;
	    int day = cal.get(Calendar.DAY_OF_MONTH);	    	    
	    
		return year + "-" + month + "-" + day + " " + "00:00:00";
	}
	
	
	//	오늘 현재시간
	public String getToday_currentTime(){
		
		Calendar cal = new GregorianCalendar();
		cal.add(Calendar.DATE, 0);
				
	    int year = cal.get(Calendar.YEAR);
	    int month = cal.get(Calendar.MONTH) + 1;
	    int day = cal.get(Calendar.DAY_OF_MONTH);	    	    
	    
	    int hour = cal.get(Calendar.HOUR_OF_DAY);
	    
		return year + "-" + month + "-" + day + " " + hour;
	}	
	

}
