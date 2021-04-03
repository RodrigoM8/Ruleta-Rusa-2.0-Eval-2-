package ruletarusa;

public class Nodo {

    String Nombre, Apellido;
    int Edad;
    int Posicion_bala_actual; // Posicion que se va moviendo
    int Posicion_bala; //Posicion de bala real
    static int Barril = 6; // Capacidad maxima de revolver
    Nodo siguiente;

    public Nodo(String nombre, String apellido, int edad) {
        this.Nombre = nombre;
        this.Apellido = apellido;
        this.Edad = edad;
        this.Posicion_bala = Util.numero_al_azar(Barril, 1);
        this.Posicion_bala_actual = Util.numero_al_azar(Barril, 1);

    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

}
