public class Main {
    public static void main(String[] args) {
        System.out.println("=== RPG - Sistema con Manejo de Excepciones ===");

        MotorCombate motor = new MotorCombate();
        
        Druida druida = new Druida("Sylva", 7, 200, 100, 50);
        Nigromante nigromante = new Nigromante("Malachar", 6, 240, 50);
        Druida druida2 = new Druida("Finnian", 5, 150, 80, 40);
        
        // Escenario 1 - Turno normal sin excepcion
        motor.ejecutarTurno(druida, nigromante);

        // Escenario 2 - Personaje derrotado intenta atacar
        try {
            druida.recibirDanio(9999); // primero derrota al druida
        } catch (AccionInvalidaException e) {
            // Se ignora para la prueba
        }
        motor.ejecutarTurno(druida, nigromante); // captura PersonajeDerrotadoException

        // Escenario 3 - Arquero sin flechas
        Arquero sinFlechas = new Arquero("Legolas", 6, 150, "Arco Largo", 0, 95);
        motor.ejecutarTurno(sinFlechas, nigromante); // captura RecursoInsuficienteException

        // Escenario 4 - Curar aliado derrotado
        System.out.println("\n-- Intento de curar aliado derrotado --");
        try {
            druida2.curarAliado(druida); // 'druida' (Sylva) fue derrotada en el escenario 2
        } catch (RpgException e) {
            System.out.println("No se pudo curar: " + e.getMessage());
        }

        // Escenario 5 - Dano negativo con finally
        System.out.println("\n-- Bloque manual try-catch-finally --");
        try {
            nigromante.recibirDanio(-50);
        } catch (AccionInvalidaException e) {
            System.out.println("Capturado: " + e.getMessage());
        } finally {
            System.out.println("El bloque finally siempre se ejecuta.");
        }

        // Escenario 6 - Mostrar bitacora completa
        motor.mostrarBitacora();
    }
}