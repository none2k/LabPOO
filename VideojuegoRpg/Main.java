public class Main {
    public static void main(String[] args) {
        System.out.println("=== Batalla RPG ===\n");

        // 1. Crear objetos
        Guerrero thorin = new Guerrero("Thorin", 5, 200, 85, "Cota de Malla");
        Mago gandalf = new Mago("Gandalf", 8, 120, 120, "escudo arcano");
        Arquero legolas = new Arquero("Legolas", 6, 120, 95, "esquivando el ataque");

        // 2. Ronda de Ataques
        System.out.println("-- Ronda 1: Ataques --");
        thorin.atacar();
        gandalf.atacar();
        legolas.atacar();

        // 3. Ronda de Defensas
        System.out.println("-- Ronda 2: Defensas --");
        thorin.defender();
        gandalf.defender();
        legolas.defender();
        System.out.println();

        // 4. Danio recibido
        System.out.println("-- Danio recibido --");
        thorin.recibirDanio(60);
        gandalf.recibirDanio(200); // Esto lo llevara a 0
        System.out.println();

        // 5. Estado Final
        System.out.println("-- Estado final --");
        System.out.println(thorin.toString());
        System.out.println(gandalf.toString());
        System.out.println(legolas.toString());
    }
}