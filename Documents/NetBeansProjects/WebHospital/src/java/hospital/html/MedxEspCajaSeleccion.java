package hospital.html;

import java.util.ArrayList;
import hospital.vo.MedxEspVO;

public class MedxEspCajaSeleccion {

    public static StringBuilder lista(ArrayList lista, String buscar){
        StringBuilder str = new StringBuilder();
        StringBuilder id = new StringBuilder();
	boolean sw=false;
	str.append("");
	if(lista != null){
            for(int reg = 0; reg < lista.size(); reg++ ){
                MedxEspVO vo = (MedxEspVO)lista.get(reg) ;
		id = new StringBuilder();
                id.append(vo.getMed().getMed_id());
                
		str.append("<option value=\"");
		str.append(vo.getMed().getMed_id());
		str.append("\"");
                
                if(buscar.equalsIgnoreCase("null")){
                    if(reg==0){ str.append("selected=\"\""); sw=true; }
                }else
                    if(id.toString().equalsIgnoreCase(buscar)){
                        str.append("selected=\"\""); sw=true;
                    }
		str.append(" >");           
		str.append(vo.getMed().getMed_nombre()+" "+vo.getMed().getMed_apellido());
		str.append("</option>");
            }
	}
	if (!sw) str.append("<option value='' selected=''> &nbsp; </option>");
        str.append("");
        return str;
    }
}
