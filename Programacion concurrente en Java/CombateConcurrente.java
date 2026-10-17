public class CombateConcurrente implements Runnable {
    private final String nombre;
    private final Personaje atacante;
    private final Personaje defensor;
    private final TablaResultados resultados;

    public CombateConcurrente(String nombre, Personaje atacante, Personaje defensor, TablaResultados resultados) {
        this.nombre = nombre;
        this.atacante = atacante;
        this.defensor = defensor;
        this.resultados = resultados;
    }

    @Override
    public void run() {
        System.out.println("[" + nombre + "] INICIO - " + atacante.getNombre() + " vs " + defensor.getNombre());
        int ronda = 1;

        while (atacante.isEstaVivo() && defensor.isEstaVivo()) {
            System.out.println("[" + nombre + "] Ronda " + ronda);
            try {
                Thread.sleep(500);
                atacante.atacar();
                int danio = atacante.calcularDanio();
                defensor.recibirDanio(danio);
            } catch (RpgException e) {
                System.out.println("[" + nombre + "] Error: " + e.getMessage());
                break;
            } catch (InterruptedException e) {
                System.out.println("[" + nombre + "] Combate interrumpido.");
                Thread.currentThread().interrupt();
                break;
            }
            ronda++;
        }

        String ganador = atacante.isEstaVivo() ? atacante.getNombre() : defensor.getNombre();
        String registro = nombre + " -> Ganador: " + ganador + " (rondas: " + ronda + ")";
        
        resultados.registrar(registro);
        System.out.println("[" + nombre + "] FIN - " + ganador + " gana.");
    }
}