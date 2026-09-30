public class Arquero extends Personaje {
    private final int precision;
    private final String movimientoEvasion;

    public Arquero(String nombre, int nivel, int puntosVida, int precision, String movimientoEvasion) {
        super(nombre, nivel, puntosVida);
        this.precision = precision;
        this.movimientoEvasion = movimientoEvasion;
    }

    @Override
    public void atacar() {
        System.out.println("[" + getNombre() + "] dispara una flecha con precision del " + precision + "%.");
    }

    @Override
    public int calcularDanio() {
        return nivel * 15 + precision;
    }

   @Override
    public String toString() {
        return super.toString() + " | Clase: Arquero | Evasion: " + movimientoEvasion;
    }
}