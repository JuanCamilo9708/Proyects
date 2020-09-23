package hospital.html;

import java.util.ArrayList;
import hospital.vo.MedicoVO;

public class MedicoCajaSeleccion {

    public static StringBuilder lista(ArrayList lista, String buscar){
        StringBuilder str = new StringBuilder();
        StringBuilder id = new StringBuilder();
	boolean sw=false;
	str.append("");
	if(lista != null){
            for(int reg = 0; reg < lista.size(); reg++ ){
                MedicoVO vo = (MedicoVO)lista.get(reg) ;
		id = new StringBuilder();
                id.append(vo.getMed_id());
                
		str.append("<option value=\"");
		str.append(vo.getMed_id());
		str.append("\"");
                
                if(buscar.equalsIgnoreCase("null")){
                    if(reg==0){ str.append("selected=\"\""); sw=true; }
                }else
                    if(id.toString().equalsIgnoreCase(buscar)){
                        str.append("selected=\"\""); sw=true;
                    }
		str.append(" >");           
		str.append(vo.getMed_nombre());
		str.append("</option>");
            }
	}
	if (!sw) str.append("<option value='' selected=''> &nbsp; </option>");
        str.append("");
        return str;
    }
}
