public class Arquero extends Personaje {
    private final String tipoArma;
    private final int flechas;
    private final int precision;

    public Arquero(String nombre, int nivel, int puntosVida, String tipoArma, int flechas, int precision) {
        super(nombre, nivel, puntosVida);
        this.tipoArma = tipoArma;
        this.flechas = flechas;
        this.precision = precision;
    }

    public String getTipoArma() {
        return tipoArma;
    }

    public int getFlechas() {
        return flechas;
    }

    public int getPrecision() {
        return precision;
    }
}