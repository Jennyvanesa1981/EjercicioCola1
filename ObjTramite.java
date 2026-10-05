public class ObjTramite {

    private int Id; 
    private String Nombre; 
    private String Documento; 
    private String TipoSolicitud; 
    private String Estado;


    public ObjTramite(int id, String nombre, String documento, String tipoSolicitud, String estado) {
        Id = id;
        Nombre = nombre;
        Documento = documento;
        TipoSolicitud = tipoSolicitud;
        Estado = estado;
    }


    public ObjTramite() {
    }


    public int getId() {
        return Id;
    }


    public void setId(int id) {
        Id = id;
    }


    public String getNombre() {
        return Nombre;
    }


    public void setNombre(String nombre) {
        Nombre = nombre;
    }


    public String getDocumento() {
        return Documento;
    }


    public void setDocumento(String documento) {
        Documento = documento;
    }


    public String getTipoSolicitud() {
        return TipoSolicitud;
    }


    public void setTipoSolicitud(String tipoSolicitud) {
        TipoSolicitud = tipoSolicitud;
    }


    public String getEstado() {
        return Estado;
    }


    public void setEstado(String estado) {
        Estado = estado;
    }
    
}
