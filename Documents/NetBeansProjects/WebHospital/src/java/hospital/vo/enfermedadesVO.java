
package hospital.vo;

public class enfermedadesVO {
    private String enfer_id;
    private String enfer_nombre;
    private String enfer_sintomas;
    private String tip_id;
    private tipo_enfermedadVO tip;

    public enfermedadesVO() {
        this.tip = new tipo_enfermedadVO();
    }

    public String getEnfer_id() {
        return enfer_id;
    }

    public void setEnfer_id(String enfer_id) {
        this.enfer_id = enfer_id;
    }

    public String getEnfer_nombre() {
        return enfer_nombre;
    }

    public void setEnfer_nombre(String enfer_nombre) {
        this.enfer_nombre = enfer_nombre;
    }

    public String getEnfer_sintomas() {
        return enfer_sintomas;
    }

    public void setEnfer_sintomas(String enfer_sintomas) {
        this.enfer_sintomas = enfer_sintomas;
    }

    public String getTip_id() {
        return tip_id;
    }

    public void setTip_id(String tip_id) {
        this.tip_id = tip_id;
    }

    public tipo_enfermedadVO getTip() {
        return tip;
    }

    public void setTip(tipo_enfermedadVO tip) {
        this.tip = tip;
    }

    
   

   
            
      
}
