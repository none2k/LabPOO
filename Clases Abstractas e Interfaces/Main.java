public class Main {
    public static void main(String[] args) {
        System.out.println("=== RPG - Expansion: Nuevas Clases ===\n");

        System.out.println("-- Error esperado (linea comentada) --");
        System.out.println("// new Personaje(...) -> cannot instantiate abstract class\n");
        // Personaje p = new Personaje("Desconocido", 1, 100);

        // Se le asignan 350 de vida base a Malachar para que tras el golpe de 300 quede en 50, acorde a la salida esperada.
        Druida sylva = new Druida("Sylva", 7, 200, 300, 120, "Oso");
        Nigromante malachar = new Nigromante("Malachar", 6, 350, 400, 9);
        Bardo finnian = new Bardo("Finnian", 5, 150, 60, "laud");

        Personaje[] equipo = { sylva, malachar, finnian };

        System.out.println("-- Ataques y dano --");
        for (Personaje p : equipo) {
            p.atacar();
            System.out.println("Dano: " + p.calcularDanio());
        }
        System.out.println();

        System.out.println("-- Solo los Hechiceros lanzan hechizos --");
        for (Personaje p : equipo) {
            if (p instanceof Hechicero) {
                Hechicero h = (Hechicero) p;
                h.lanzarHechizo();
            }
        }
        System.out.println();

        System.out.println("-- Solo los Sanadores curan --");
        malachar.recibirDanio(300); 

        for (Personaje p : equipo) {
            if (p instanceof Sanador) {
                Sanador s = (Sanador) p;
                s.curarAliado(malachar);
            }
        }
        System.out.println();

        System.out.println("-- Estado final --");
        for (Personaje p : equipo) {
            System.out.println(p.toString());
        }
    }
}