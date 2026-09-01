public class Mago extends Personaje {
    private final int mana;
    private final String escudoMagico;

    public Mago(String nombre, int nivel, int puntosVida, int mana, String escudoMagico) {
        super(nombre, nivel, puntosVida);
        this.mana = mana;
        this.escudoMagico = escudoMagico;
    }

    public int getMana() { return mana; }
    public String getEscudoMagico() { return escudoMagico; }

    @Override
    public void atacar() {
        super.atacar(); // Llama al ataque basico primero
        System.out.println("!" + getNombre() + " lanza una bola de fuego causando " + mana + " de mana!\n");
    }

    @Override
    public void defender() {
        System.out.println(getNombre() + " invoca un " + escudoMagico + ".");
    }

    @Override
    public String toString() {
        return super.toString() + " | Clase: Mago";
    }
}