public class Guerrero extends Personaje {
    private final int fuerza;
    private final String armadura;

    public Guerrero(String nombre, int nivel, int puntosVida, int fuerza, String armadura) {
        super(nombre, nivel, puntosVida);
        this.fuerza = fuerza;
        this.armadura = armadura;
    }

    @Override
    public void atacar() {
        System.out.println("!" + getNombre() + " golpea con su espada!");
    }

    @Override
    public int calcularDanio() {
        return nivel * 20 + fuerza;
    }

    @Override
    public String toString() {
        return super.toString() + " | Clase: Guerrero | Armadura: " + armadura;
    }
}