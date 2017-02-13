/* Ejercicio 4 - Arrays de objetos
 * Modifica el programa “Colección de monitors” como se indica a continuación:
 * a) Mejora la opción “Nuevo monitor” de tal forma que cuando se llenen todas las
 * posiciones del array, el programa muestre un mensaje de error. No se permitirá
 * introducir los datos de ningún monitor hasta que no se borre alguno de la lista.
 * b) Mejora la opción “Borrar” de tal forma que se verifique que el código
 * introducido por el usuario existe.
 * c) Modifica el programa de tal forma que el código del monitor sea único, es decir
 * que no se pueda repetir.
 * d) Crea un submenú dentro dentro de “Listado” de tal forma que exista un
 * listado completo, un listado por autor (todos los monitors que ha publicado un
 * determinado autor), un listado por género (todos los monitors de un género de-
 * terminado) y un listado de monitors cuya duración esté en un rango determinado
 * por el usuario.
 */

import java.util.Scanner;

public class gestionmonitorledarraylist {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int i = 0;
        int n;
        int m;
        boolean repetido;

        System.out.println("Programa de gestión de monitores");

        //Creamos array
        MonitorLED[] led = new MonitorLED[100];

        //Creamos los monitors de dentro del array
        for (i = 0; i < led.length; i++) {
            led[i] = new MonitorLED();
        }

        int opcion;
        String modeloIntroducido;
        int precioIntroducido;
        String resolucionIntroducida;
        String marcaIntroducido;
        String tipoIntroducido;

        do {

            repetido = false;
            System.out.println();
            System.out.println("¿Qué desea hacer?");
            System.out.println("1. Listar monitores");
            System.out.println("2. Añadir monitor");
            System.out.println("3. Modificar monitor");
            System.out.println("4. Borrar monitor");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(s.nextLine());

            if (opcion == 1) {
                clearScreen();

                System.out.println();
                System.out.println("+----------------+----------------+----------------+----------------+----------------+");
                System.out.println("|     Modelo     |     Precio     |   Resolución   |     Marca      |      Tipo      | ");
                System.out.println("+----------------+----------------+----------------+----------------+----------------+");

                for (MonitorLED l: led) {

                    if (!l.isVacio()) {
                        System.out.print(l);
                    }
                }
                System.out.println("+----------------+----------------+----------------+----------------+----------------+");

                System.out.print("Pulse enter para continuar");
                String e = s.nextLine();
            } else if (opcion == 2) {

                i = 0;

                while (!led[i].isVacio()) {
                    i++;

                    if (i == led.length - 1) {
                        break;
                    }
                }

                if (i == led.length - 1 && !led[i].isVacio()) {
                    System.out.print("Colección de monitores llena, pulse enter para continuar");
                } else {
                    System.out.println("Introduzca los datos del nuevo monitor");
                    System.out.print("Modelo: ");
                    modeloIntroducido = s.nextLine();
                    led[i].setModelo(modeloIntroducido);

                    for (n = 0; n < i; n++) {

                        if (led[n].getModelo().equals(led[i].getModelo()) && !led[n].isVacio()) {
                            repetido = true;
                            break;

                        }
                    }

                    if (!repetido) {
                        System.out.print("Precio: ");
                        precioIntroducido = Integer.parseInt(s.nextLine());
                        led[i].setPrecio(precioIntroducido);

                        System.out.print("Resolución: ");
                        resolucionIntroducida = s.nextLine();
                        led[i].setResolucion(resolucionIntroducida);

                        System.out.print("Género: ");
                        marcaIntroducido = s.nextLine();
                        led[i].setMarca(marcaIntroducido);

                        System.out.print("Tipo: ");
                        tipoIntroducido = s.nextLine();
                        led[i].setTipo(tipoIntroducido);

                        led[i].setVacio(false);

                        System.out.print("Monitor añadido, pulsa enter para continuar");
                    } else {
                        System.out.print("Este monitor ya existe, pulse enter para continuar");
                    }
                }

                String e = s.nextLine();
            } else if (opcion == 3) {

                for (i = 0; i < led.length; i++) {

                    if (!led[i].isVacio()) {
                        System.out.println("----------------------------");
                        System.out.println("monitor " + i);
                        System.out.print(led[i]);
                    }
                }

                System.out.print("¿Qué monitor quiere modificar?: ");
                n = Integer.parseInt(s.nextLine());
                System.out.println("monitor seleccionado: " + n);
                System.out.println(led[n]);
                System.out.println("¿Qué quiere modificar?");
                System.out.println("1 - Modelo");
                System.out.println("2 - Precio");
                System.out.println("3 - Resolución");
                System.out.println("4 - Marca");
                System.out.println("5 - Título");
                System.out.print("Seleccione una opción: ");
                m = Integer.parseInt(s.nextLine());

                switch (m) {
                    case 1:
                        System.out.print("Introduzca nuevo dato: ");
                        modeloIntroducido = s.nextLine();

                        for (n = 0; n < i; n++) {

                            if (led[n].getModelo().equals(modeloIntroducido) && !led[n].isVacio()) {
                                repetido = true;
                                break;

                            }
                        }

                        if (!repetido) {
                            led[n].setModelo(modeloIntroducido);
                        } else {
                            System.out.print("Este código ya existe");
                        }
                        break;
                    case 2:
                        System.out.print("Introduzca nuevo dato: ");
                        precioIntroducido = Integer.parseInt(s.nextLine());
                        led[n].setPrecio(precioIntroducido);
                        break;
                    case 3:
                        System.out.print("Introduzca nuevo dato: ");
                        resolucionIntroducida = s.nextLine();
                        led[n].setResolucion(resolucionIntroducida);
                        break;
                    case 4:
                        System.out.print("Introduzca nuevo dato: ");
                        marcaIntroducido = s.nextLine();
                        led[n].setMarca(marcaIntroducido);
                        break;
                    case 5:
                        System.out.print("Introduzca nuevo dato: ");
                        tipoIntroducido = s.nextLine();
                        led[n].setTipo(tipoIntroducido);
                        break;
                }
                System.out.print("Dato modificado, pulse enter para continuar");
                String e = s.nextLine();

            } else if (opcion == 4) {
                clearScreen();
                System.out.println("Lista de monitors:");
                for (i = 0; i < led.length; i++) {

                    if (!led[i].isVacio()) {
                        System.out.println("----------------------------");
                        System.out.println("monitor " + i);
                        System.out.print(led[i]);
                    }
                }

                System.out.print("¿Qué monitor quiere eliminar?: ");
                n = Integer.parseInt(s.nextLine());
                if (led[n].isVacio()) {
                    System.out.print("Código incorrecto, pulse enter para continuar");
                } else {
                    led[n].setVacio(true);

                    System.out.print("monitor eliminado correctamente, pulse enter para continuar");

                }
                String e = System.console().readLine();
            }
            clearScreen();
        } while (opcion != 5);
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
