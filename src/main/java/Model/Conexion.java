package Model;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    //Atributos de conexion
    private static final String BD="jdbc:mysql://localhost:3306/Musica";
    private static final String usuario="root";
    private static final String clave="";
    private static Connection con;
    //Declarar método conexión
    public static Connection conectar() {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con=DriverManager.getConnection(BD,usuario,clave);
        System.out.println("Conexión Exitosa");
    }
    catch(Exception e) {
        System.out.println("Error de conexión a la base de datos "+e.getMessage().toString());
    }
    return con;
}
public static void main(String[] args) {
Conexion.conectar();
}
}