package ruletarusa;

import java.io.IOException;
import java.util.Scanner;

//Ruleta Rusa 2.0
//Bárbara Barreca
//Rodrigo Martinez
//Sebastián Pérez
public class menu {

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        Lista lista = new Lista();
        int opcion = 0;

        do {
            System.out.println("Ruleta Rusa");
            System.out.println("1. Iniciar juego.");
            System.out.println("2. Salir");
            System.out.print("---> ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    lista = Util.leer_archivo("Participantes.in");
                    Resultado result = new Resultado();
                    result = Ruleta.iniciar(lista);
                    Util.crear_nuevo_archivo("Perdedores.out", result.perdedores); // Aquí se agregan los datos al archivo de perdedores.out

                    Util.crear_nuevo_archivo("Ganadores.out", result.ganadores); // El último que quede en la lista, es el ganador 

                    System.out.println("\nEl sádico juego ha ocurrido exitosamente...");
                    System.out.println("Solamente hubo un sobreviviente...");
                    System.out.println("Ingrese a los respectivos archivos para conocer al ganador y a los perdedores.");
                    System.out.println("");
                    break;

                case 2:
                    System.out.println("Hasta pronto...");
                    break;

                default:
                    System.out.println("\nOpción no disponible.");
                    break;
            }

        } while (opcion != 2);

    }

}
