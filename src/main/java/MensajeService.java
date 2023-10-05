import java.util.Scanner;

public class MensajeService {

    public static void crearMensaje() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu mensaje");
        String mensaje = sc.nextLine();

        System.out.println("Tu nombre");
        String nombre = sc.nextLine();

        Mensaje registro = new Mensaje();
        registro.setMensaje(mensaje);
        registro.setAutor_mensaje(nombre);
        MensajeDAO.crearMensajeDB(registro);

    }

    public static void listarMensajes() {
        MensajeDAO.leerMensajeDB();
    }

    public static void eliminarMensaje() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Indica el id del mensaje que vas a borrar");
        int id_mensaje = sc.nextInt();
        MensajeDAO.eliminarMensajeDB(id_mensaje);
    }

    public static void editarMensaje() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu nuevo mensaje");
        String nuevoMensaje = sc.nextLine();
        System.out.println("Cual es el ID del mensaje que vas a editar");
        int id_mensaje = sc.nextInt();
        Mensaje actualización = new Mensaje();
        actualización.setId_mensaje(id_mensaje);
        actualización.setMensaje(nuevoMensaje);
        MensajeDAO.actualizarMensajeDB(actualización);

    }

}
