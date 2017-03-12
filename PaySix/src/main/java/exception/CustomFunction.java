package exception;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class CustomFunction {

	
	


	
	
	
	
	/*
	 * 	���� �� ���� ������ ( 00-24 )
	 * 	���� ����ð����� ���� ������ ( 00-hh )
	 * 	���� ����ð� ���� ������ ( yester.hh == today.hh )
	 */
	
	
	
	//	������ 00��
	public String getYester_midNight(){
		
		Calendar cal = new GregorianCalendar();
		cal.add(Calendar.DATE, -1);
				
	    int year = cal.get(Calendar.YEAR);
	    int month = cal.get(Calendar.MONTH) + 1;
	    int day = cal.get(Calendar.DAY_OF_MONTH);	    	    
	    
		return year + "-" + month + "-" + day + " " + "00";
	}
	
	
	//	������ ����ð�
	public String getYester_currentTime(){
		
		Calendar cal = new GregorianCalendar();
		cal.add(Calendar.DATE, -1);
				
	    int year = cal.get(Calendar.YEAR);
	    int month = cal.get(Calendar.MONTH) + 1;
	    int day = cal.get(Calendar.DAY_OF_MONTH);	    	    
	    int hour = cal.get(Calendar.HOUR_OF_DAY);
	    
		return year + "-" + month + "-" + day + " " + hour;
	}
	
	
	//	������ 00��
	public String getToday_midNight(){
		
		Calendar cal = new GregorianCalendar();
		cal.add(Calendar.DATE, 0);
				
	    int year = cal.get(Calendar.YEAR);
	    int month = cal.get(Calendar.MONTH) + 1;
	    int day = cal.get(Calendar.DAY_OF_MONTH);	    	    
	    
		return year + "-" + month + "-" + day + " " + "00:00:00";
	}
	
	
	//	���� ����ð�
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
