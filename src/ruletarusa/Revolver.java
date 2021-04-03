package ruletarusa;

public class Revolver {

    public static boolean disparar(Nodo participante) {
        boolean mata = false;

        if (participante.Posicion_bala == participante.Posicion_bala_actual) {
            mata = true;
        }

        return mata;
    }
}
