import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public Connection get_Connection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3305/mensajes_app", "root", "admin");
            if (connection!=null){
                System.out.println("Conexión exitosa");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return connection;
    }
}
