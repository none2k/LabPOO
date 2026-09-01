public class Arquero extends Personaje {
    private final int precision;
    private final String movimientoEvasion;

    public Arquero(String nombre, int nivel, int puntosVida, int precision, String movimientoEvasion) {
        super(nombre, nivel, puntosVida);
        this.precision = precision;
        this.movimientoEvasion = movimientoEvasion;
    }

    public int getPrecision() { return precision; }
    public String getMovimientoEvasion() { return movimientoEvasion; }

    @Override
    public void atacar() {
        // No usa super.atacar() segun el ejemplo de salida
        System.out.println("[" + getNombre() + "] dispara una flecha con precision del " + precision + "%.\n");
    }

    @Override
    public void defender() {
        System.out.println(getNombre() + " se desplaza agilmente " + movimientoEvasion + ".");
    }

    @Override
    public String toString() {
        return super.toString() + " | Clase: Arquero";
    }
}