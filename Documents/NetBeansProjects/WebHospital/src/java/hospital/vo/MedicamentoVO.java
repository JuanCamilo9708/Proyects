
package hospital.vo;

public class MedicamentoVO {
    private String med_id;
    private String med_nombre;
    private String med_cantidad;
    private String med_fecha_vencimiento;

    public MedicamentoVO() {
    }

    public String getMed_id() {
        return med_id;
    }

    public void setMed_id(String med_id) {
        this.med_id = med_id;
    }

    public String getMed_nombre() {
        return med_nombre;
    }

    public void setMed_nombre(String med_nombre) {
        this.med_nombre = med_nombre;
    }

    public String getMed_cantidad() {
        return med_cantidad;
    }

    public void setMed_cantidad(String med_cantidad) {
        this.med_cantidad = med_cantidad;
    }

    public String getMed_fecha_vencimiento() {
        return med_fecha_vencimiento;
    }

    public void setMed_fecha_vencimiento(String med_fecha_vencimiento) {
        this.med_fecha_vencimiento = med_fecha_vencimiento;
    }
    
}
