import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Metodos metodos = new Metodos();

        Queue<ObjTramite> tramite = new LinkedList<>();
        Queue<String> historial = new LinkedList<>();

        int opcion;
        int id; 

        do {
            
            System.out.println("===BIENVENIDO===");
            System.out.println("==========================");
            System.out.println("===OFICINA DE TRÁMITES===");
            System.out.println("==========================");
            System.out.println("=== Menú de Opciones ===");
            System.out.println("1. Registrar Solicitud");
            System.out.println("2. Atender Solicitud");
            System.out.println("3. Modificar Solicitud");
            System.out.println("4. Cancelar Solicitud");
            System.out.println("5. Finalizar Solicitud");
            System.out.println("6. Mostrar Historial");
            System.out.println("7. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    metodos.RegistrarSolicitud(tramite, historial, sc);
                    break;

                case 2:
                    System.out.print("Ingrese el ID de la solicitud: ");
                    id = sc.nextInt();
                    sc.nextLine();

                    ObjTramite solicitud = metodos.AtenderSolicitud(tramite, historial, id);

                   if (solicitud != null) {
                   System.out.println("Solicitud atendida correctamente.");
                   System.out.println("ID: " + solicitud.getId());
                   System.out.println("Nombre: " + solicitud.getNombre());
                   System.out.println("Estado: " + solicitud.getEstado());

                   } else {
                      System.out.println("No se encontró una solicitud con ese ID.");

                   }

                    break;

                case 3:
                    System.out.print("Ingrese el ID de la solicitud a modificar: ");
                    id = sc.nextInt();
                    sc.nextLine();

                    ObjTramite solicitudModificada = metodos.ModificarSolicitud(tramite, historial, id, sc);

                    if(solicitudModificada != null) {
                        System.out.println("Solicitud modificada correctamente.");
                        System.out.println("ID: " + solicitudModificada.getId());
                        System.out.println("Nombre: " + solicitudModificada.getNombre());
                        System.out.println("Documento: " + solicitudModificada.getDocumento());
                        System.out.println("Tipo de Solicitud: " + solicitudModificada.getTipoSolicitud());
                        System.out.println("Estado: " + solicitudModificada.getEstado());
                    } else {
                        System.out.println("No se encontró una solicitud con ese ID.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese el ID de la solicitud a cancelar: ");
                    id = sc.nextInt();
                    sc.nextLine();

                    ObjTramite solicitudCancelada = metodos.CancelarSolicitud(tramite, historial, id);

                    if(solicitudCancelada != null) {
                        System.out.println("Solicitud cancelada correctamente.");
                        System.out.println("ID: " + solicitudCancelada.getId());
                        System.out.println("Nombre: " + solicitudCancelada.getNombre());
                        System.out.println("Estado: " + solicitudCancelada.getEstado());
                    } else {
                        System.out.println("No se encontró una solicitud con ese ID.");
                    }
                    break;

                case 5:
                    System.out.print("Ingrese el ID de la solicitud a finalizar: ");
                    id = sc.nextInt();
                    sc.nextLine();  
                    metodos.FinalizarSolicitud(tramite, historial, id);
                    break;

                case 6:
                    metodos.MostrarHistorial(historial);
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }

            System.out.println();
        } while (opcion != 7);

        sc.close();
    }
    
}

