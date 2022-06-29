package Model;
public class AlbumVo {
    private int idAlbum;
    private String nombreAlbum;
    private String anoAlbum;
    private boolean estadoAlbum;
    private int idArtista;
    private int idGenero;
    
    public AlbumVo(){    
    }

    public AlbumVo(int idAlbum, String nombreAlbum, String anoAlbum, boolean estadoAlbum){
        this.idAlbum=idAlbum;
        this.nombreAlbum=nombreAlbum;
        this.anoAlbum=anoAlbum;
        this.estadoAlbum=estadoAlbum;
    }

    public int getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(int idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getNombreAlbum() {
        return nombreAlbum;
    }

    public void setNombreAlbum(String nombreAlbum) {
        this.nombreAlbum = nombreAlbum;
    }

    public String getAnoAlbum() {
        return anoAlbum;
    }

    public void setAnoAlbum(String anoAlbum) {
        this.anoAlbum = anoAlbum;
    }

    public boolean getEstadoAlbum() {
        return estadoAlbum;
    }

    public void setEstadoAlbum(boolean estadoAlbum) {
        this.estadoAlbum = estadoAlbum;
    }

    public int getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(int idArtista) {
        this.idArtista = idArtista;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }


}