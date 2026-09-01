public class Main {
    public static void main(String[] args) {
        System.out.println("---- Clinica Veterinaria ----\n");

        // 1. Instanciar Perro
        Perro perro = new Perro("Bruno", 8, 18, "Husky", true);
        System.out.println("-- Perro --");
        System.out.println(perro.toString());
        perro.comer();
        perro.ladrar();
        perro.buscarPelota();
        System.out.println(); // Salto de línea

        // 2. Instanciar Gato
        Gato gato = new Gato("Bola de nieve", 4, 5, "Blanco", true);
        System.out.println("-- Gato --");
        System.out.println(gato.toString());
        gato.dormir();
        gato.maullar();
        gato.ronronear();
        System.out.println();

        // 3. Instanciar Canario
        Canario canario = new Canario("Hugo sanchez", 3, 1, "Rojo", true);
        System.out.println("-- Canario --");
        System.out.println(canario.toString());
        canario.comer();
        canario.cantar();
        canario.volar();
    }
}