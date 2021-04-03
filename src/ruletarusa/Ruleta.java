package ruletarusa;

public class Ruleta {

    public static Resultado iniciar(Lista lista) {

        String listaperdedores = "";
        int perdedores = 0; // control de perdedores
        int turno = 0; // "turno" lleva el control de turnos
        int turno_por_participante = 0;// se emplea para contar cuantos turnos van por participantes

        Nodo actual = lista.ultimo.siguiente;
        Nodo referenciaAnt = lista.ultimo;
        do {
            turno_por_participante++;
            boolean resultado = Revolver.disparar(actual);
            if (resultado) {
                listaperdedores = listaperdedores + "*Nombre:  " + actual.Nombre + "  *Apellido:  " + actual.Apellido + "  *Edad:  " + actual.Edad + "\n";
                perdedores++; // esta variable lleva el conteo de cuántos participantes han perdido
                if (referenciaAnt != null) {
                    if (!referenciaAnt.Nombre.equals(actual.Nombre)) {
                        referenciaAnt.siguiente = actual.siguiente;
                        lista.ultimo = referenciaAnt; // estamos pasando la lista anterior por la lista actualizada
                    } else {// Al momento de que quede un elemento en la lista
                        lista.ultimo = referenciaAnt.siguiente; // actualiza la lista final (primero igual al ultimo)
                        lista.ultimo.siguiente = null; // "limpiar" enlace del nodo (actual)

                    }
                }

            } else {
                if (actual.Posicion_bala_actual == actual.Barril) {
                    actual.Posicion_bala_actual = 1;
                } else {
                    actual.Posicion_bala_actual++; // cuando dispara y no está la bala
                }

                referenciaAnt = actual;

            }
            if (turno_por_participante == lista.total) {
                turno++;
                turno_por_participante = 0;
            }
            actual = actual.siguiente;
        } while (lista.total - perdedores != 1);
        String ganador = "Nombre: " + lista.ultimo.Nombre + " " + lista.ultimo.Apellido + " --- Edad: " + lista.ultimo.Edad + " ---> Ha ganado en el turno: [ " + turno + " ]";
        Resultado result = new Resultado();
        result.ganadores = ganador;
        result.perdedores = listaperdedores;

        return result;
    }

}
