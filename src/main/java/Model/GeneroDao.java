package Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GeneroDao{
    Connection con; //objeto de conexión
    PreparedStatement ps; //objeto para sentencias preparadas
    ResultSet rs; //objeto para almacenar consultas
    String sql=null; //variable para guardar sentencias SQL
    int r;
    public List<GeneroVo> listar() throws SQLException{
        List<GeneroVo> Generos=new ArrayList<>();
        sql="SELECT * FROM Genero";
        try {
            con=Conexion.conectar();//Conexion
            ps=con.prepareStatement(sql);//Preparacion de sentencia
            rs=ps.executeQuery();//Ejecucion de sentencia
            while (rs.next()) {
                GeneroVo r=new GeneroVo();
                r.setIdGenero(rs.getInt("id_Genero"));
                r.setNombreGenero(rs.getString("nombreGenero"));
                r.setEstadoGenero(rs.getBoolean("estadoGenero"));
                Generos.add(r);
            }
            ps.close();
            System.out.println("Consulta exitosa.");
        } catch (Exception e) {
            System.out.println("El error fue "+e.getMessage());
        }
        con.close();
        return Generos;
    }
    public int registrar(GeneroVo Genero) throws SQLException{
        sql="INSERT INTO Genero(nombreGenero,estadoGenero) values(?,?)";
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1, Genero.getNombreGenero());
            ps.setBoolean(2, Genero.getEstadoGenero());
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se registro el genero");
        } catch (Exception e) {
            System.out.println("Error en el registro "+e.getMessage().toString());
        }
        finally{
            con.close();
        }
        return r;//Preguntar por que retorna r si deberia estar vacio, y por que regresa un int
    }
    public void eliminar(int id)throws SQLException{
		sql="DELETE FROM genero WHERE id_Genero="+id;
		System.out.println(sql);
		try {
			con=Conexion.conectar();
			ps=con.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
			System.out.println("El genero ha sido eliminado");
		}catch(Exception e) {
			System.out.println("Eliminacion fallida "+e.getMessage());
		}
		finally {
			con.close();
		}
    }

    public void cEstado(GeneroVo Genero)throws SQLException{
        sql="UPDATE genero SET estadoGenero = ? WHERE genero.id_Genero = ?;";
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            ps.setBoolean(1, Genero.getEstadoGenero());
            ps.setInt(2, Genero.getIdGenero());
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se cambio el estado");
        } catch (Exception e) {
            System.out.println("Error en el cambio de estado "+e.getMessage().toString());
        }
        finally{
            con.close();
        }
}
public void editar (int id, String nombreA, Boolean estadoA) throws SQLException{
    sql="UPDATE genero SET nombreGenero = ?, estadoGenero = ? WHERE id_Genero = ?";
    try {
        con=Conexion.conectar();
        ps=con.prepareStatement(sql);
        ps.setString(1, nombreA);
        ps.setBoolean(2, estadoA);
        ps.setInt(3, id);
        System.out.println(ps);
        ps.executeUpdate();
        ps.close();
        System.out.println("Se cambio el estado");
    } catch (Exception e) {
        System.out.println("Error en la edicion "+e.getMessage().toString());
    }
    finally{
        con.close();
    }
}
}
