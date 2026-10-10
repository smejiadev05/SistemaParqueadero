public class Pila<T> {
    private ListaSimple<T> lista;

    public Pila() {
        this.lista = new ListaSimple<>();
    }

    public void push(T data) {
        this.lista.addFirst(data); // Insertar al inicio (tope de la pila)
    }

    public T pop() {
        return lista.removeFirst(); // Retirar del inicio
    }

    public T top() {
        if (this.lista.first() != null){
            return this.lista.first().getData();
        } else{
            System.out.println("No se encontró información de este vehiculo.");
            return null;
        }
    }

    public boolean isEmpty() {
        return this.lista.isEmpty();
    }

    public int size() {
        return this.lista.size();
    }

    public void mostrar() {
        Nodo<T> actual = lista.first();
        while (actual != null) {
            System.out.print("[" + actual.getData() + "] ");
            actual = actual.getNext();
        }
        System.out.println();
    }
}
