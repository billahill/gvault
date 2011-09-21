/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.infrastructure.util;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang.time.DateUtils;

/**
 *
 * @author Ferox
 */
public class ConvertDate implements Serializable {

    /**
     * Converts a string variable to date
     * @param dateIn (String)
     * format "dd-MM-yyyy"
     * example "20-12-2010"
     * @return dateOut (type Date)
     */
    private String vistTime;

    public Date String2Date(String dateIn) {
        try {
            DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            Date dateOut = df.parse(dateIn);
            return dateOut;
        } catch (ParseException ex) {

            Logger.getLogger(DateUtils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public Date String2Date2(String str_date) {
        try {
            //str_date = "11-June-07";
            DateFormat formatter;
            Date date;
            formatter = new SimpleDateFormat("EEE MMM d HH:mm:ss zzzz yyyy");
            date = (Date) formatter.parse(str_date);

            System.out.println("Today is " + date);
            return date;

        } catch (ParseException e) {
            System.out.println("Exception :" + e);
            return null;
        }
    }

    /**
     * Converts a date variable to string
     * @param dateIn (date)
     * @return dateOut (String)
     * format "dd-MM-yyyy"  example "20-12-2010"
     */
    public String Date2String(Date dateIn) {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy");
        return sdf.format(dateIn);

    }
    
    public String Time2String(Date dateIn) {
        SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
        return sdf.format(dateIn);

    }

    public String Date2String2(Date dateIn){
            DateFormat formatter;
            formatter = new SimpleDateFormat("EEE MMM d, yyyy");
            
            return formatter.format(dateIn);
//        DateFormat formatter;
//            String date;
//            formatter = new SimpleDateFormat("EEE MMM d, yyyy");
//            date = (String) formatter.format(dateIn);
//
//            return date;

    }
    
    public String dateToString(Date dateIn) {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        int d = c.get(Calendar.DATE);
        int m = c.get(Calendar.MONTH) + 1;
        int y = c.get(Calendar.YEAR);
        String t = (d < 10 ? "0" : "") + d + "-" + (m < 10 ? "0" : "") + m + "-" + (y < 10 ? "0" : "") + y;
        
        return t;
    }
    
    public String timeToString(Date date) {
        Calendar c = Calendar.getInstance();
       // c.setTime(new Date());
        int h = c.get(Calendar.HOUR_OF_DAY);
        int m = c.get(Calendar.MINUTE);
        int s = c.get(Calendar.SECOND);
        String t = (h < 10 ? "0" : "") + h + ":" + (m < 10 ? "0" : "") + m + ":" + (s < 10 ? "0": "")+s;

        return t;
    }
    
    public String Time2String2(Date dateIn){
            DateFormat formatter;
            String date;
            formatter = new SimpleDateFormat("h:mm a");
            date = (String) formatter.format(dateIn);

            return date;
    }

    public String getVisitTime(String time) {
        vistTime = time;
        return vistTime;
    }
    
    public String VisitDate2String(Date dateIn){
            DateFormat formatter;
            formatter = new SimpleDateFormat("EEE, d MMM yyyy - h:mm a");
            
            return formatter.format(dateIn);

    }
    
    
    public String formatDay(Date date) {
     
       String dateStr;
            
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        int day = cal.get(Calendar.DAY_OF_MONTH); 
        String dayOfWeekStr = null;
        String monthStr = null;
        String dayStr = null;
        
        try{
            
            try {
            //    dayOfWeek = Integer.parseInt(dayOfWeekStr);
                
                     if(dayOfWeek == 1){ dayOfWeekStr = "Sun";}                   
                else if(dayOfWeek == 2){ dayOfWeekStr = "Mon";}
                else if(dayOfWeek == 3){ dayOfWeekStr = "Tue";}
                else if(dayOfWeek == 4){ dayOfWeekStr = "Wed";}
                else if(dayOfWeek == 5){ dayOfWeekStr = "Thu";}
                else if(dayOfWeek == 6){ dayOfWeekStr = "Fri";}
                else if(dayOfWeek == 7){ dayOfWeekStr = "Sat";}               
                else{throw new DateParseException();}
                    
                
            } catch (Exception e) {
                throw new DateParseException("Could not parse '" + e + "' as a day of week");
            }

     
            try {
                //month = Integer.parseInt(monthStr) - 1; //Zero Based Months
                         //    dayOfWeek = Integer.parseInt(dayOfWeekStr);
                
                     if(month == 0){ monthStr = "Jan"; }                    
                else if(month == 1){ monthStr = "Feb";}
                else if(month == 2){ monthStr = "Mar";}
                else if(month == 3){ monthStr = "Apr";}
                else if(month == 4){ monthStr = "May";}
                else if(month == 5){ monthStr = "Jun";}
                else if(month == 6){ monthStr = "Jul";}
                else if(month == 7){ monthStr = "Aug";}
                else if(month == 8){ monthStr = "Sep";}
                else if(month == 9){ monthStr = "Oct";}
                else if(month == 10){ monthStr = "Nov";}
                else if(month == 11){ monthStr = "Dec";}
                else{throw new DateParseException();}
            } catch (Exception e) {
                throw new DateParseException("Could not parse '" + e + "' as a valid month");
            }


        } catch (DateParseException ex) {
            System.out.println("Date Conversion Error"+ ex);
        }

        if(day<10){dayStr = "0"+day;}
        else{dayStr = ""+day;}

            dateStr =  dayOfWeekStr + ", " + dayStr + " " +monthStr + " " + year;
                                                                


        return dateStr ;
    }
    
    
      public String formatTime(Date date) {
     
       String dateStr;
            
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        int day = cal.get(Calendar.DAY_OF_MONTH); 
        int hour = cal.get(Calendar.HOUR);
        int minute = cal.get(Calendar.MINUTE);
        int am_pm = cal.get(Calendar.AM_PM);    
        String dayStr = null;
        String hourStr = null;
        String minuteStr = null;
        String am_pm_Str  = null;   
        try{
            

                                       
                     if(hour == 0){ hourStr = "12";}
                else if((hour >= 1) &&(hour < 10)){ hourStr = "0"+hour;}
                else{hourStr = ""+hour;}
                     
                if((minute >= 0) &&(minute < 10)){ minuteStr = "0"+minute;}
                else{minuteStr = ""+minute;}
                     
                     if(am_pm == 0){ am_pm_Str = "AM";}
                else if(am_pm == 1){ am_pm_Str = "PM";}  
                else{throw new DateParseException();}
                    
                
           


        } catch (DateParseException ex) {
            System.out.println("Date Conversion Error"+ ex);
        }


            dateStr = hourStr + ":" + minuteStr + " " + am_pm_Str;


        return dateStr ;
    }
}
