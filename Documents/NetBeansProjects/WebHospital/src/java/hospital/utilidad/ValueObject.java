
package hospital.utilidad;

import java.lang.Class;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;


public class ValueObject {
    
    private Class Clase;
    private Object ObjectVO;
    private Method metodos[];
       
    public ValueObject(){}
    
    public void setValueObject(HttpServletRequest request,Object ObjectVO){
        this.Clase = ObjectVO.getClass();
    	this.ObjectVO = ObjectVO;
    	this.metodos = this.Clase.getMethods();
    	Enumeration etiquetas = request.getParameterNames();
    	while(etiquetas.hasMoreElements()){
    		String input = (String)etiquetas.nextElement();
    		if(!input.equals("boton"))
    		  this.setParameterMethod(request,input);
    	} 
    }
    
    public void setValueObject(HttpServletRequest request,Object ObjectVO,String [] etiquetas){
       if(etiquetas!=null){
         this.Clase = ObjectVO.getClass();
    	 this.ObjectVO = ObjectVO;
    	 this.metodos = this.Clase.getMethods();	
    	 for(int i=0;i<etiquetas.length;i++)
    	 	setParameterMethod(request,etiquetas[i]);
       }
    }
   
    private void setParameterMethod(HttpServletRequest request,String input){
	  try{
	  	  for(int i=0;i<this.metodos.length;i++){
	  	  	if(this.metodos[i].getName().equalsIgnoreCase("set"+input)){
	  	  		Class parametros[] = this.metodos[i].getParameterTypes();
	  	  		if(parametros!=null){
	  	  		 String type = parametros[0].getName();
	  	  		 
	  	  		 if(type.indexOf("java.lang.String")!=-1)
	  	  		 	this.metodos[i].invoke(this.ObjectVO,Format.String(request.getParameter(input)));
	  	  		 
	  	  		 if(type.indexOf("[Ljava.lang.String")!=-1)
	  	  		 	this.metodos[i].invoke(this.ObjectVO,(Object)request.getParameterValues(input));
	  	  		 	
	  	  		 if(type.indexOf("int")!=-1)
	  	  		 	this.metodos[i].invoke(this.ObjectVO,Format.Integer(request.getParameter(input)));
	  	  		 
	  	  		 if(type.indexOf("java.sql.Date")!=-1)
	  	  		 	this.metodos[i].invoke(this.ObjectVO,Format.Date(request.getParameter(input)));
	  	  		 
	  	  		 if(type.indexOf("java.sql.Time")!=-1)
	  	  		 	this.metodos[i].invoke(this.ObjectVO,Format.Time(request.getParameter(input)));

                                 if(type.indexOf("java.sql.Timestamp")!=-1)
	  	  		 	this.metodos[i].invoke(this.ObjectVO,Format.Timestamp(request.getParameter(input)));
	  	  		 
	  	  		 if(type.indexOf("short")!=-1)
	  	  		 	this.metodos[i].invoke(this.ObjectVO,Format.Short(request.getParameter(input)));
	  	  		 
	  	  		 if(type.indexOf("java.math.BigDecimal")!=-1)
	  	  		 	this.metodos[i].invoke(this.ObjectVO,Format.BigDecimal(request.getParameter(input)));
	  	  		 
	  	  		 if(type.indexOf("double")!=-1)
	  	  		 	this.metodos[i].invoke(this.ObjectVO,Format.Double(request.getParameter(input)));

	  	  		 if(type.indexOf("float")!=-1)
	  	  		 	this.metodos[i].invoke(this.ObjectVO,Format.Float(request.getParameter(input)));
                                 
	  	  		 if(type.indexOf("byte")!=-1)
	  	  		 	this.metodos[i].invoke(this.ObjectVO,Format.Byte(request.getParameter(input)));    
	  	        
	  	  		 if(type.indexOf("boolean")!=-1)
	  	  		 	this.metodos[i].invoke(this.ObjectVO,Format.Boolean(request.getParameter(input)));

                                 if(type.indexOf("long")!=-1)
	  	  		 	this.metodos[i].invoke(this.ObjectVO,Format.Long(request.getParameter(input)));    
	  	         
                                 if(type.indexOf("java.net.URL")!=-1)
                                 try{
	  	         		this.metodos[i].invoke(this.ObjectVO,Format.URL(request.getParameter(input)));
	  	         	 }catch(java.net.MalformedURLException error){}
	  	  		 	    
	  	          
	  	  		 }
	  	  	  break;
	  	  	} 
	      }
	     }catch(IllegalAccessException error){}	
	      catch(InvocationTargetException error){}
	      catch(NullPointerException error){} 
	      catch(NumberFormatException error){}	
	      catch(IllegalArgumentException error){} 		
   }
 
}