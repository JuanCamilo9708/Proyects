package hospital.html;

public class PaginacionCajaSeleccion {

    public static String lista(int tl, int rxp, String pagina){
        String op = "";
        int k;

        for(k=0; k<tl/rxp; k++){
            op+="<option value=\""+k+"\" ";
            if(((pagina==null)?0:Integer.valueOf(pagina))==k)
              op+="selected=\"\"";
            op+=" >"+(k*rxp+1)+" - "+(k*rxp+rxp)+" de "+tl+"</option>";
        }
        if(tl%rxp!=0){
            op+="<option value=\""+k+"\" ";
            if(((pagina==null)?0:Integer.valueOf(pagina))==k)
              op+="selected=\"\""; 
            op+=" >"+(k*rxp+1)+" - "+tl+" de "+tl+"</option>";                                      
        }
        return op;
    }
}
