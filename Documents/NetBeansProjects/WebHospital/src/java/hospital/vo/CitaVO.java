package hospital.vo;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.sql.Date;

public class CitaVO {
    private String cit_id;
    private Date cit_fecha_generada;
    private Date cit_fecha_asistencia;
    private int cit_costo;
    private String pac_id;
    private String med_id;
    private String esp_id;
    private PacienteVO pac;
    private MedxEspVO mxe;
    private String buscar;
    private Date buscarDate;

    private int cit_pagina;
    private int cit_rxp;
    
    public CitaVO() {
        this.pac = new PacienteVO();
        this.mxe = new MedxEspVO();
    }

    public int getCit_rxp() {
        return cit_rxp;
    }

    public void setCit_rxp(int cit_rxp) {
        this.cit_rxp = cit_rxp;
    }

    public Date getBuscarDate() {
        return buscarDate;
    }

    public void setBuscarDate(Date buscarDate) {
        this.buscarDate = buscarDate;
    }

    public String getEsp_id() {
        return esp_id;
    }

    public void setEsp_id(String esp_id) {
        this.esp_id = esp_id;
    }

    public String getCit_id() {
        return cit_id;
    }

    public void setCit_id(String cit_id) {
        this.cit_id = cit_id;
    }

    public int getCit_costo() {
        return cit_costo;
    }

    public void setCit_costo(int cit_costo) {
        this.cit_costo = cit_costo;
    }

    public Date getCit_fecha_generada() {
        return cit_fecha_generada;
    }

    public void setCit_fecha_generada(Date cit_fecha_generada) {
        this.cit_fecha_generada = cit_fecha_generada;
    }

    public int getCit_pagina() {
        return cit_pagina;
    }

    public void setCit_pagina(int cit_pagina) {
        this.cit_pagina = cit_pagina;
    }

    

    public Date getCit_fecha_asistencia() {
        return cit_fecha_asistencia;
    }

    public void setCit_fecha_asistencia(Date cit_fecha_asistencia) {
        this.cit_fecha_asistencia = cit_fecha_asistencia;
    }

   
    public String getPac_id() {
        return pac_id;
    }

    public void setPac_id(String pac_id) {
        this.pac_id = pac_id;
    }

    public String getMed_id() {
        return med_id;
    }

    public void setMed_id(String med_id) {
        this.med_id = med_id;
    }

    public PacienteVO getPac() {
        return pac;
    }

    public void setPac(PacienteVO pac) {
        this.pac = pac;
    }

    public MedxEspVO getMxe() {
        return mxe;
    }

    public void setMxe(MedxEspVO mxe) {
        this.mxe = mxe;
    }

    public String getBuscar() {
        return buscar;
    }

    public void setBuscar(String buscar) {
        this.buscar = buscar;
    }

    
}