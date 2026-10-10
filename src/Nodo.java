public class Nodo <T>{

    private T data;
    private Nodo next;

    //métodos constructores
    public Nodo(T data){
        this.data = data;
        this.next = null;
    }

    public Nodo(){
        this.data = null;
        this.next = null;
    }

    //getters y setters
    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }
}
