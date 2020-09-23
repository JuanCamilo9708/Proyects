
package hospital.vo;

public class MedxEspVO {
    private String med_id;
    private String esp_id;
    private MedicoVO med;
    private EspecialidadVO esp;

    public MedxEspVO() {
        this.med = new MedicoVO();
        this.esp= new EspecialidadVO();
    }

    public String getMed_id() {
        return med_id;
    }

    public void setMed_id(String med_id) {
        this.med_id = med_id;
    }

    public String getEsp_id() {
        return esp_id;
    }

    public void setEsp_id(String esp_id) {
        this.esp_id = esp_id;
    }

    public MedicoVO getMed() {
        return med;
    }

    public void setMed(MedicoVO med) {
        this.med = med;
    }

    public EspecialidadVO getEsp() {
        return esp;
    }

    public void setEsp(EspecialidadVO esp) {
        this.esp = esp;
    }

   
    
    
}
