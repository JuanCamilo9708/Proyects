
package hospital.utilidad;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.StringTokenizer;

public class Format {

    public Format(){}
    
    public static byte Byte(String text){
    return Byte.parseByte(text.trim());	
    }	
    
    public static byte[] getBytes(String text){
    return text.trim().getBytes();	
    }		
    	
    public static long Long(String text){
    return Long.parseLong(text.trim());	
    }
    
    public static short Short(String text){
    return Short.valueOf(text.trim());	
    }
    
    public static float Float(String text){
    return  Float.parseFloat(text.trim());
    }
 	
    public static int Integer(String text) {
    return Integer.parseInt(text.trim());	
    }
 	
    public static String String(Object text){
    return  String.valueOf(text).trim(); //.toLowerCase()
    }	
 	    
    public static boolean Boolean(String text){
    return  Boolean.valueOf(text.trim());
    }
    
    public static double Double(String text){
    return  Double.parseDouble(text.trim());
    }
    
    public static BigDecimal BigDecimal(String text){
    return BigDecimal.valueOf(Double(text));	
    }
 	
    public static Date Date(String text){
      Date date = Date.valueOf(text.trim());
      if(text.length()==10){
        StringTokenizer fecha = new StringTokenizer(text,"-");
	    int a =Integer(fecha.nextToken())-1900;
	    int m =Integer(fecha.nextToken())-1;
        int d =Integer(fecha.nextToken());
        date = new Date(a,m,d);
      }
      return date;
    } 
    	
    public static Time Time(String text){
  	 return Time.valueOf(text.trim());
    }
    
    public static Timestamp Timestamp(String text){
  	 return Timestamp.valueOf(text.trim());
    }
	
    public static String Minus(String text){
 	return text.toLowerCase().trim();	
    }
    
    public static String Mayus(String text){
  	return text.toUpperCase().trim();
    }
 	
    public static URL URL(String text)throws MalformedURLException{
        return  new URL(text.trim());	
    }
 		
}