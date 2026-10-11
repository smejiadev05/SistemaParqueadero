public class Parqueadero {

    private int capacidadMaxima;
    private Pila<Vehiculo> parqueadero;
    private Cola<Vehiculo> colaEspera;

    public Parqueadero(int capacidadMaxima){
        this.capacidadMaxima = capacidadMaxima;
        this.parqueadero = new Pila<>();
        this.colaEspera = new Cola<>();

    }

    public void ingresarVehiculo(String placa){
        Vehiculo v = new Vehiculo(placa);
        if(parqueadero.size() < capacidadMaxima){
            parqueadero.push(v);
            System.out.println("Vehiculo " + v.getPlaca() + " ingreso al parqueadero.");
        }else{
            colaEspera.enqueue(v);
            System.out.println("parqueadero lleno. Vehiculo "+ v.getPlaca() + " ingreso a la cola de espera.");

        }
    }

    public void salirVehiculo(String placa){
        placa = placa.toUpperCase();

        if(!contieneVehiculo(placa)){
            System.out.println("Error: El vehiculo con placa "+ placa+ " no esta en el parqueadero.");
            return;
        }
        Pila<Vehiculo> pilaAuxiliar = new Pila<>();
        int movimientos = 0;

        while (!parqueadero.isEmpty() && !parqueadero.top().getPlaca().equalsIgnoreCase(placa)){
            pilaAuxiliar.push(parqueadero.pop());
            movimientos++;
        }

        Vehiculo retirado = parqueadero.pop();
        System.out.println("\nVehiculo "+ retirado.getPlaca()+ " ha SALIDO del parqueadero.");
        if(movimientos > 0){
            System.out.println("-> se movieron temporalmente " + movimientos + " vehiculo.");

        }
        while (!pilaAuxiliar.isEmpty()){
            parqueadero.push(pilaAuxiliar.pop());

        }
        pasarColaAParqueadero();
    }

    public boolean contieneVehiculo(String placa){
        Pila<Vehiculo> temp = new Pila<>();
        boolean encontrado = false;

        while (!parqueadero.isEmpty()){
            Vehiculo v = parqueadero.pop();
            if (v.getPlaca().equalsIgnoreCase(placa)){
                encontrado = true;
            }
            temp.push(v);
        }

        while (!temp.isEmpty()){
            parqueadero.push(temp.pop());
        }

        return encontrado;
    }

    public void pasarColaAParqueadero(){
        if (!colaEspera.isEmpty() && parqueadero.size() < capacidadMaxima){
            Vehiculo siguiente = colaEspera.dequeue();
            parqueadero.push(siguiente);
            System.out.println("El vehiculo de placa " + siguiente.getPlaca() + " ingreso automaticamente al parqueadero desde la cola de espera.");
        }
    }

    public void mostrarEstado() {
        System.out.println("\n==========================================");
        System.out.println("   ESTADO DEL PARQUEADERO (" + parqueadero.size() + "/" + capacidadMaxima + ")");
        System.out.print("Pila de Parqueadero (Tope -> Entrada): ");
        parqueadero.mostrar();
        System.out.print("Cola de Espera (Frente -> Final): ");
        colaEspera.mostrar();
        System.out.println("==========================================\n");
    }

}
