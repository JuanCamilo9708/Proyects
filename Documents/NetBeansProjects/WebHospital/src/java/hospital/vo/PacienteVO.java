package hospital.vo;

public class PacienteVO {
    private String pac_id;
    private String pac_nombre;
    private String pac_apellido;
    private String pac_telefono;
    private String pac_email;
    private String pac_direccion;
    //private String pac_buscar;
    private int per_rxp;
    
    public PacienteVO() {
    }

    public String getPac_id() {
        return pac_id;
    }

    public int getPer_rxp() {
        return per_rxp;
    }

    public void setPer_rxp(int per_rxp) {
        this.per_rxp = per_rxp;
    }

    public void setPac_id(String pac_id) {
        this.pac_id = pac_id;
    }

    public String getPac_nombre() {
        return pac_nombre;
    }

    public void setPac_nombre(String pac_nombre) {
        this.pac_nombre = pac_nombre;
    }

    public String getPac_apellido() {
        return pac_apellido;
    }

    public void setPac_apellido(String pac_apellido) {
        this.pac_apellido = pac_apellido;
    }

    public String getPac_telefono() {
        return pac_telefono;
    }

    public void setPac_telefono(String pac_telefono) {
        this.pac_telefono = pac_telefono;
    }

    public String getPac_email() {
        return pac_email;
    }

    public void setPac_email(String pac_email) {
        this.pac_email = pac_email;
    }

    public String getPac_direccion() {
        return pac_direccion;
    }

    public void setPac_direccion(String pac_direccion) {
        this.pac_direccion = pac_direccion;
    }

     
    
}
