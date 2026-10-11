public class Main {
    public static void main(String[] args) {
        // Inicializamos parqueadero con capacidad de 3 vehiculos
        Parqueadero miParqueadero = new Parqueadero(3);

        System.out.println("--- 1. INGRESANDO 3 VEHÍCULOS (LLENAR PARQUEADERO) ---");
        miParqueadero.ingresarVehiculo("SMV507");
        miParqueadero.ingresarVehiculo("SSR341");
        miParqueadero.ingresarVehiculo("MDM136");

        miParqueadero.mostrarEstado();

        System.out.println("--- 2. INGRESANDO MÁS VEHÍCULOS (PASA A COLA DE ESPERA) ---");
        miParqueadero.ingresarVehiculo("TMG986");
        miParqueadero.ingresarVehiculo("JMC162");

        miParqueadero.mostrarEstado();

        System.out.println("--- 3. SALIDA DE VEHÍCULO BLOQUEADO (SSR341) ---");
        miParqueadero.salirVehiculo("SSR341");

        miParqueadero.mostrarEstado();

        System.out.println("--- 4. INTENTO DE SALIDA DE PLACA INEXISTENTE ---");
        miParqueadero.salirVehiculo("XYZ923");
    }
}
