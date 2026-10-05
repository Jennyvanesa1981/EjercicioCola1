    import java.util.Queue;
    import java.util.Scanner;

    public class Metodos {

        public ObjTramite RegistrarSolicitud(Queue<ObjTramite> tramite, Queue<String> historial, Scanner sc) {

            System.out.println("Ingrese el Tipo de Solicitud: ");
            String tipoSolicitud = sc.nextLine();

            System.out.print("Ingrese el Id: ");
            int id = sc.nextInt();
            sc.nextLine(); 

            System.out.println("Ingrese el Nombre: ");
            String nombre = sc.nextLine();

            System.out.println("Ingrese el Documento: ");
            String documento = sc.nextLine();

            ObjTramite solicitud = new ObjTramite(id, nombre, documento, tipoSolicitud, "Esperando");

            tramite.offer(solicitud);

            historial.offer("Solicitud con ID: " + id + " ha sido registrada.");

            return solicitud;
        }

        public ObjTramite AtenderSolicitud(Queue<ObjTramite> tramite, Queue<String> historial,int id) {

            for(ObjTramite solicitud : tramite) {

                if (solicitud.getId() == id) {

                    solicitud.setEstado("Llamado");

                    AgregarHistorial(historial, id, "atendida");
                    return solicitud;
                }
            }
            return null;
            
        }

        public ObjTramite ModificarSolicitud(Queue<ObjTramite> tramite, Queue<String> historial, int id, Scanner sc) {

            for(ObjTramite solicitud : tramite) {

                if (solicitud.getId() == id) {

                    System.out.println("Ingrese el nuevo Documento: ");
                    String documento = sc.nextLine();

                    System.out.println("Ingrese el nuevo Tipo de Solicitud: ");
                    String tipoSolicitud = sc.nextLine();

                    solicitud.setDocumento(documento);
                    solicitud.setTipoSolicitud(tipoSolicitud);

                    AgregarHistorial(historial, id, "modificada");

                    return solicitud;

                }
            }
            return null;
        }
        
        public ObjTramite CancelarSolicitud(Queue<ObjTramite> tramite, Queue<String> historial, int id) {

            for(ObjTramite solicitud : tramite) {

                if (solicitud.getId() == id) {

                    solicitud.setEstado("Cancelado");
                    
                    AgregarHistorial(historial, id, "cancelada");
                    return solicitud;
                    
                }
            }
            return null;

            
        }

        public ObjTramite FinalizarSolicitud(Queue<ObjTramite> tramite, Queue<String> historial, int id) {

            for(ObjTramite solicitud : tramite) {

                if (solicitud.getId() == id) {

                    solicitud.setEstado("Finalizado");
                    AgregarHistorial(historial, id, "finalizada");

                    return solicitud;
                    
                }
            }
            return null;
            
        }

        public void AgregarHistorial(Queue<String> historial, int id,  String accion) {
        
            historial.offer("Solicitud con ID: " + id + " ha sido " + accion);
        }

        public void MostrarHistorial(Queue<String> historial) {

            for(String evento : historial) {

                System.out.println(evento);
            }
        }
    }
