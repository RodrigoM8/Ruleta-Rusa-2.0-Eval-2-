package ruletarusa;

public class Lista {

    Nodo primero;
    Nodo ultimo;
    int total;

    public Lista() {
        primero = null;
        ultimo = null;
        total = 0; // va a llevar el conteo de cuantos elementos hay en la lista
    }

    public Lista insertar(String nombre, String apellido, int edad) {
        Nodo nuevo = new Nodo(nombre, apellido, edad);
        if (primero == null) {
            primero = nuevo;
            ultimo = primero;
            primero.siguiente = ultimo;
        } else {
            ultimo.siguiente = nuevo;
            nuevo.siguiente = primero;
            ultimo = nuevo;
        }
        return this;
    }
}
