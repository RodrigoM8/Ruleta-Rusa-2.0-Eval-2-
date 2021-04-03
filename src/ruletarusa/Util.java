package ruletarusa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Util {

    public static int numero_al_azar(int minimo, int maximo) {
        int num = (int) Math.floor(Math.random() * (maximo - minimo + 1) + (minimo));
        return num;
    }

    public static Lista leer_archivo(String NombreArchivo) throws IOException {
        FileReader fr = new FileReader(NombreArchivo);
        BufferedReader br = new BufferedReader(fr);
        String participante;
        Lista lista = new Lista();
        int participantes = 0;
        while ((participante = br.readLine()) != null) {
            String[] cadena = participante.split(" ");
            int edad = Integer.parseInt(cadena[2]);
            lista.insertar(cadena[0], cadena[1], edad);
            lista.total = participantes;
            participantes++;
        }
        lista.total = participantes;
        return lista;
    }

    public static void crear_nuevo_archivo(String NombreArchivo, String participantes) throws IOException {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(NombreArchivo);
            pw = new PrintWriter(fichero);

            pw.println(participantes);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (null != fichero) {
                fichero.close();
            }
        }
    }


}
