public class Guerrero extends Personaje {
    private final String tipoArma;
    private final int fuerza;

    public Guerrero(String nombre, int nivel, int puntosVida, String tipoArma, int fuerza) {
        super(nombre, nivel, puntosVida);
        this.tipoArma = tipoArma;
        this.fuerza = fuerza;
    }

    public String getTipoArma() {
        return tipoArma;
    }

    public int getFuerza() {
        return fuerza;
    }
}