import com.mysql.cj.jdbc.ConnectionImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MensajeDAO {

    public static void crearMensajeDB(Mensaje mensaje) {
        Conexion db_connect = new Conexion();
        try (Connection conexion = db_connect.get_Connection();) {
            PreparedStatement statement = null;
            try {
                String query = "INSERT INTO mensajes (mensaje, autor_mensaje) VALUES (?,?);";
                statement = conexion.prepareStatement(query);
                statement.setString(1, mensaje.getMensaje());
                statement.setString(2, mensaje.getAutor_mensaje());
                statement.executeUpdate();
                System.out.println("Mensaje creado");
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } catch (SQLException e) {
            System.out.println(e);

        }
    }

    public static void leerMensajeDB() {
        Conexion db_connect = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;


        try (Connection conexion = db_connect.get_Connection()) {
            String query = "SELECT * from mensajes";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_mensaje"));
                System.out.println("Mensaje: " + rs.getString("mensaje"));
                System.out.println("Autor: " + rs.getString("autor_mensaje"));
                System.out.println("Fecha: " + rs.getString("fecha_mensaje"));
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("No se pudo obtener los mensajes");
            System.out.println(e);
        }
    }

    public static void eliminarMensajeDB(int id_mensaje) {
        Conexion dbConexion = new Conexion();

        try (Connection conexion = dbConexion.get_Connection()) {
            PreparedStatement ps = null;
            try {
                String query = "DELETE FROM mensajes WHERE id_mensaje = ?";
                ps = conexion.prepareStatement(query);
                ps.setInt(1, id_mensaje);
                ps.executeUpdate();
                System.out.println("Mensaje eliminado");
            } catch (SQLException ex) {
                System.out.println("No se pudo borrar el mensaje");
                System.out.println(ex);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void actualizarMensajeDB(Mensaje mensaje) {
        Conexion dbConexion = new Conexion();
        try (Connection conexion = dbConexion.get_Connection()) {
            PreparedStatement ps = null;
            try {
                String query = "UPDATE mensajes SET mensaje = ? WHERE (id_mensaje = ?)";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setInt(2, mensaje.getId_mensaje());
                ps.executeUpdate();
                System.out.println("Mensaje actualizado");
            } catch (SQLException ex) {
                System.out.println(ex);
                System.out.println("No se pudo actualizar el mensaje");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

}
