public class Main {
    public static void main(String[] args) {
        System.out.println("---- Sistema de Transporte Multimodal ----\n");

        // 1. Crear objetos
        Automovil auto = new Automovil("Toyota", "Corolla", 2022, 180.0, 4, false);
        Avion avion = new Avion("Boeing", "737", 2019, 850.0, 2, 41000.0);
        Barco barco = new Barco("Ferretti", "550", 2020, 45.0, "Fibra de vidrio", 17.0);

        // 2. Imprimir información inicial
        System.out.println("-- Automovil --");
        System.out.println(auto.toString());
        System.out.println();

        // 3. Probar validaciones con valores incorrectos a propósito
        System.out.println(">> Intentando poner valores invalidos al auto...");
        auto.setAnio(1800);       // Debe mostrar error
        auto.setNumPuertas(10);   // Debe mostrar error
        System.out.println();

        // 4. Corregir con valores válidos y volver a imprimir
        System.out.println(">> Corrigiendo con valores validos...");
        auto.setAnio(2024);
        auto.setNumPuertas(2);
        
        System.out.println("-- Automovil (Actualizado) --");
        System.out.println(auto.toString());
        System.out.println();

        // Imprimir el resto de los vehiculos
        System.out.println("-- Avion --");
        System.out.println(avion.toString());
        System.out.println();

        System.out.println("-- Barco --");
        System.out.println(barco.toString());
    }
}