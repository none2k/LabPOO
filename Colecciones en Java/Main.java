public class Main {
    public static void main(String[] args) {
        GestionGremio gremio = new GestionGremio();
        
        gremio.agregarMiembro(new Druida("Sylva", 10, 300, 100, 50, "Oso"));
        gremio.agregarMiembro(new Nigromante("Malachar", 8, 250, 120, 5));
        gremio.agregarMiembro(new Arquero("Legolas", 6, 150, 95, "Evasion agil"));
        gremio.agregarMiembro(new Guerrero("Thorin", 9, 400, 80, "Armadura pesada"));
        
        gremio.mostrarRoster();
        gremio.eliminarMiembro("Malachar");
        gremio.mostrarRoster();

        Personaje encontrado = gremio.buscarPorNombre("Legolas");
        if (encontrado != null) {
            System.out.println("\nEncontrado: " + encontrado.getNombre() + "\n");
        }

        gremio.encolarSolicitante("Gandalf");
        gremio.encolarSolicitante("Aragorn");
        gremio.encolarSolicitante("Gimli");
        gremio.mostrarCola();
        
        gremio.atenderSiguiente(); 
        gremio.mostrarCola();
        System.out.println();

        gremio.agregarItem("Pocion de vida", 5);
        gremio.agregarItem("Flecha elfica", 30);
        gremio.agregarItem("Pocion de vida", 3); 
        
        gremio.mostrarInventario();
        System.out.println();
        
        gremio.usarItem("Pocion de vida");
        gremio.usarItem("Pergamino de fuego"); 
        System.out.println();

        gremio.registrarHabilidad("Curacion");
        gremio.registrarHabilidad("Magia oscura");
        gremio.registrarHabilidad("Curacion"); 
        
        gremio.mostrarHabilidades();
        System.out.println();
        
        System.out.println("¿Tiene tiro con arco? " + gremio.tieneHabilidad("Tiro con arco"));
        System.out.println("¿Tiene curacion?      " + gremio.tieneHabilidad("Curacion"));
    }
}