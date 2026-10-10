public class Cola<T> {
    private ListaSimple<T> lista;

    public Cola() {
        this.lista = new ListaSimple<>();
    }
    public void  enqueue(T data){
        lista.addLast(data);
    }
    public T dequeue(){
        return lista.removeFirst();
    }
    public T top() {
        if (this.lista.first() != null){
            return this.lista.first().getData();
        } else{
            System.out.println("No se encontró información de este vehiculo.");
            return null;
        }
    }
    public boolean isEmpty(){
        return lista.isEmpty();
    }
    public int size(){
        return lista.size();
    }
    public void mostrar(){
        Nodo<T> actual = lista.first();
        while ( actual !=null){
            System.out.print("["+ actual.getData()+"]");
            actual = actual.getNext();
        }
        System.out.println();
    }
}