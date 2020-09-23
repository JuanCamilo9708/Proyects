
package hospital.vo;

public class diagnosticoVO {
    private String diag_id;
    private String diag_nombre;
    private String cit_id;
    private String  enfer_id;
    private String  tip_id;
    private CitaVO cit;
    private enfermedadesVO enfer;
    private tipo_enfermedadVO tip;
    private String buscar1,buscar;
    
    private int Diag_rxp;

    public diagnosticoVO() {
        this.cit = new CitaVO();
        this.enfer = new enfermedadesVO();
        this.tip = new tipo_enfermedadVO();
    }

    public String getDiag_id() {
        return diag_id;
    }

    public int getDiag_rxp() {
        return Diag_rxp;
    }

    public String getBuscar1() {
        return buscar1;
    }

    public void setBuscar1(String buscar1) {
        this.buscar1 = buscar1;
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

     public void setDiag_rxp(int Diag_rxp) {
        this.Diag_rxp = Diag_rxp;
    }

    public void setDiag_id(String diag_id) {
        this.diag_id = diag_id;
    }

    public String getDiag_nombre() {
        return diag_nombre;
    }

    public void setDiag_nombre(String diag_nombre) {
        this.diag_nombre = diag_nombre;
    }

    public String getCit_id() {
        return cit_id;
    }

    public void setCit_id(String cit_id) {
        this.cit_id = cit_id;
    }

    public String getEnfer_id() {
        return enfer_id;
    }

    public void setEnfer_id(String enfer_id) {
        this.enfer_id = enfer_id;
    }

    public CitaVO getCit() {
        return cit;
    }

    public void setCit(CitaVO cit) {
        this.cit = cit;
    }

    public String getBuscar() {
        return buscar;
    }

    public void setBuscar(String buscar) {
        this.buscar = buscar;
    }
    
    public enfermedadesVO getEnfer() {
        return enfer;
    }

    public void setEnfer(enfermedadesVO enfer) {
        this.enfer = enfer;
    }
    
}