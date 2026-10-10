public class ListaSimple<T> {

    private Nodo head;
    private Nodo tail;
    private int size;

    public ListaSimple(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int size(){
        return this.size;
    }

    public void setSize(int s){
        this.size = s;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public Nodo first(){
        return this.head;
    }

    public Nodo last(){
        return this.tail;
    }

    public void addFirst(T data){
        Nodo<T> n = new Nodo<>(data);

        if (isEmpty()){
            this.head = n;
            this.tail = n;
        } else {
            n.setNext(this.head);
            this.head = n;
        }
        this.size += 1;
    }

    public void addLast(T data){
        Nodo<T> n = new Nodo<>(data);

        if (isEmpty()){
            this.head = n;
            this.tail = n;
        } else {
            this.tail.setNext(n);
            this.tail = n;
        }
        this.size += 1;
    }

    public T removeFirst(){

        if (isEmpty()){
            System.out.println("La lista está vacía, no se puede eliminar nada.");
            return null;
        } else {
            Nodo<T> n = this.head;
            this.head = this.head.getNext();
            n.setNext(null);
            this.size -= 1;
            return n.getData();
        }
    }

    public T removeLast(){
        if (this.size < 1){
            System.out.println("La lista está vacía, no se puede eliminar nada.");
            return null;
        } else if (this.size == 1) {
            return removeFirst();
        } else{
            Nodo<T> anterior = this.head;
            Nodo<T> ultimo = this.tail;

            while(anterior.getNext() != ultimo){
                anterior = anterior.getNext();
            }

            anterior.setNext(null);
            this.tail = anterior;
            this.size -= 1;
            return ultimo.getData();
        }
    }

}
