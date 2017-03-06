
import java.util.Scanner;
import java.util.ArrayList;

public class gestionmonitorledarraylist {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int i = 0;
        String n;
        int m;
        boolean repetido;
        boolean salir;

        System.out.println("Programa de gestión de monitores");

        //Creamos array
        ArrayList<MonitorLED> led = new ArrayList<MonitorLED>();

        //Creamos los monitors de dentro del array
        int opcion;
        String modeloIntroducido;
        int precioIntroducido;
        String resolucionIntroducida;
        String marcaIntroducido;
        String tipoIntroducido;

        do {

            System.out.println();
            System.out.println("¿Qué desea hacer?");
            System.out.println("[1] - Listar monitores");
            System.out.println("[2] - Añadir monitor");
            System.out.println("[3] - Modificar monitor");
            System.out.println("[4] - Borrar monitor");
            System.out.println("[5] - Salir");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(s.nextLine());

            if (opcion == 1) {
                clearScreen();

                muestraListado(led);

                System.out.print("Pulse enter para continuar");
                String e = s.nextLine();
            } else if (opcion == 2) {

                System.out.println("Introduzca los datos del nuevo monitor");
                System.out.print("Modelo: ");
                modeloIntroducido = s.nextLine();
                repetido = false;
                for (MonitorLED l: led) {
                  if (l.getModelo().equals(modeloIntroducido)) {
                    repetido = true;
                  }
                }
                
                if (!repetido) {
                  System.out.print("Precio: ");
                  precioIntroducido = Integer.parseInt(s.nextLine());

                  System.out.print("Resolución: ");
                  resolucionIntroducida = s.nextLine();

                  System.out.print("Género: ");
                  marcaIntroducido = s.nextLine();

                  System.out.print("Tipo: ");
                  tipoIntroducido = s.nextLine();

                  led.add(new MonitorLED(modeloIntroducido, precioIntroducido, resolucionIntroducida, marcaIntroducido, tipoIntroducido));
                  System.out.print("Monitor añadido, pulsa enter para continuar");
                } else {
                  System.out.print("Este monitor ya existe, pulsa enter para continuar");
                }
                String e = s.nextLine();
            } else if (opcion == 3) {

                muestraListado(led);

                System.out.print("Introduzca el modelo del monitor que quiere modificar: ");
                n = s.nextLine();

                salir = false;
                String intro = "";
                for (i = 0; i < led.size() && !salir; i++) {
                    if (led.get(i).getModelo().equals(n)) {
                        salir = true;
                        System.out.println("\nIntroduzca los nuevos datos del artículo, o vaya"
                                + " pulsando [INTRO] para no modificarlos.");
                        System.out.println("\nModelo: " + led.get(i).getModelo());
                        System.out.print("Nuevo Modelo: ");
                        String modelo = s.nextLine();
                        if (!modelo.equals(intro)) {
                            led.get(i).setModelo(modelo);
                        }
                        System.out.println("Precio: " + led.get(i).getPrecio());
                        System.out.print("Nuevo precio: ");
                        String precio = s.nextLine();
                        if (!precio.equals(intro)) {
                            led.get(i).setPrecio(Integer.parseInt(precio));
                        }

                        System.out.println("Resolución: " + led.get(i).getResolucion());
                        System.out.print("Nueva resolución: ");
                        String resolucion = s.nextLine();
                        if (!resolucion.equals(intro)) {
                            led.get(i).setResolucion(resolucion);
                        }
                        System.out.println("Marca: " + led.get(i).getMarca());
                        System.out.print("Nueva marca: ");
                        String marca = s.nextLine();
                        if (!marca.equals(intro)) {
                            led.get(i).setMarca(marca);
                        }
                        System.out.println("Tipo: " + led.get(i).getTipo());
                        System.out.print("Nuevo tipo: ");
                        String tipo = s.nextLine();
                        if (!tipo.equals(intro)) {
                            led.get(i).setTipo(tipo);
                        }
                        System.out.println();
                    }
                }

                if ((i == led.size() - 1) && (!salir)) {
                    System.out.println("\nLo siento, el modelo introducido no existe.\n");
                }
                System.out.println("Pulsa enter para continuar");
                String e = s.nextLine();

            } else if (opcion == 4) {
                clearScreen();
                System.out.println("Lista de monitores:");
                i = 0;
                muestraListado(led);

                System.out.print("Introduzca el modelo del monitor que quiere eliminar: ");
                n = s.nextLine();

                salir = false;
                for (i = 0; i < led.size() && !salir; i++) {
                    if (led.get(i).getModelo().equals(n)) {
                        salir = true;
                        led.remove(i);
                        System.out.println("\n¡Artículo eliminado correctamente!.\n");
                    }

                    if ((i == led.size() - 1) && (!salir)) {
                        System.out.println("\nLo siento, el modelo introducido no existe.\n");
                    }
                }

                String e = System.console().readLine();
            }
            clearScreen();
        } while (opcion != 5);
    }
    
    public static void muestraListado(ArrayList<MonitorLED> led) {
      System.out.println();
                System.out.println("+----------------+----------------+----------------+----------------+----------------+");
                System.out.println("|     Modelo     |     Precio     |   Resolución   |     Marca      |      Tipo      | ");
                System.out.println("+----------------+----------------+----------------+----------------+----------------+");

                for (MonitorLED l : led) {
                    System.out.print(l);

                }
                System.out.println("+----------------+----------------+----------------+----------------+----------------+");
    }
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
