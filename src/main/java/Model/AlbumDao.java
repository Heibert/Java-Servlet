package Model;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

public class AlbumDao {
    Connection con; //objeto de conexión
    PreparedStatement ps; //objeto para sentencias preparadas
    ResultSet rs; //objeto para almacenar los resultados de las consultas
    String sql=null; //variable para guardar sentencias de sql
    int r;
        
public List<AlbumVo> listar() throws SQLException{
    List<AlbumVo> Albums=new ArrayList<>();
    sql= "SELECT*FROM Album";
    try {
        con=Conexion.conectar();//Abrir la conexion
        ps=con.prepareStatement(sql);//Prepara sentencia select
        rs=ps.executeQuery();//Ejecutamos la sentencia y guardamos los resultados
        while(rs.next()){
            AlbumVo r=new AlbumVo();
            r.setIdAlbum(rs.getInt("idAlbum"));
            r.setNombreAlbum(rs.getString("nombreAlbum"));
            r.setAnoAlbum(rs.getString("anoPublicacion"));
            r.setEstadoAlbum(rs.getBoolean("estadoAlbum"));
            r.setIdArtista(rs.getInt("idArtista"));
            r.setIdArtista(rs.getInt("idGenero"));
            Albums.add(r);
        }
        ps.close();
        System.out.println("Consulta exitosa");
    
    } catch (Exception e) {
        System.out.println("No hay albums definidos"+e.getMessage());   
    }
    
        finally{
            con.close();//Cerrando la conexion
        }
    return Albums;
}

public int registrar(AlbumVo Album) throws SQLException{
    sql="INSERT INTO Album(nombreAlbum,idArtista,idGenero,estadoAlbum) values(?,?,?,?)";
    
    try {
    con=Conexion.conectar();
    ps=con.prepareStatement(sql);
    ps.setString(1, Album.getNombreAlbum());
    ps.setInt(2, Album.getIdArtista());
    ps.setInt(3, Album.getIdGenero());
    ps.setBoolean(4, true);
    System.out.println(ps);
    ps.executeUpdate();
    ps.close();
    System.out.println("Album registrado con exito");

    }catch (Exception e) {
        System.out.println("Error en el registro "+e.getMessage().toString());
    }
        
    finally{
    con.close();
    }
        
    return r;
    }
    
public void Aeliminar(int idAlbum) throws SQLException{
    sql="DELETE FROM album WHERE idAlbum="+idAlbum;
    System.out.println(sql);
    try{
        con=Conexion.conectar();
        ps=con.prepareStatement(sql);
        System.out.println(ps);
        ps.executeUpdate(sql);
        ps.close();
        System.out.println("se elimino correctamente");
    }
    catch(Exception e){
        System.out.println("Error al eliminar"+e.getMessage());
    }
    finally{
        con.close();
    }
}

public void Aestado(AlbumVo Album)throws SQLException{
    sql="UPDATE album SET estadoAlbum = ? WHERE album.idAlbum = ?;";
    try {
    con=Conexion.conectar();
    ps=con.prepareStatement(sql);
    ps.setBoolean(1, Album.getEstadoAlbum());
    ps.setInt(2, Album.getIdAlbum());
    System.out.println(ps);
    ps.executeUpdate();
    ps.close();
    System.out.println("Se cambio el estado exitosamente");
        
    }catch (Exception e) {
    System.out.println("No fue posible cambiar el estado del album "+e.getMessage().toString());
    }
        
    finally{
    con.close();
    }
}

public void editar (String nombreAlbum,int idAlbum,Boolean Estado) throws SQLException{
    sql="UPDATE album SET nombreAlbum = ?, estadoAlbum = ? WHERE idAlbum = ?";
    try {
    con=Conexion.conectar();
    ps=con.prepareStatement(sql);
    ps.setString(1, nombreAlbum);
    ps.setBoolean(2, Estado);
    ps.setInt(3, idAlbum);
    System.out.println(ps);
    ps.executeUpdate();
    ps.close();
    System.out.println("Edicion exitosa");
    
    }catch (Exception e) {
    System.out.println("No fue posible editar "+e.getMessage().toString());
    }

    finally{
    con.close();
    }
}
}

