import java.sql.Connection;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("______________________");
            System.out.println(" Aplicacion de mensajes ");
            System.out.println("1. Crear mensaje");
            System.out.println("2. Listar mensajes");
            System.out.println("3. Editar mensaje");
            System.out.println("4. Eliminar mensaje");
            System.out.println("0. Salir");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    MensajeService.crearMensaje();
                    break;
                case 2:
                    MensajeService.listarMensajes();
                    break;
                case 3:
                    MensajeService.editarMensaje();
                    break;
                case 4:
                    MensajeService.eliminarMensaje();
                    break;
            }

        } while (opcion != 0);

        /*Conexion conexion = new Conexion();
        try (Connection cnx = conexion.get_Connection()){

        }catch (Exception e){
            System.out.println(e);
        }*/

    }


}
