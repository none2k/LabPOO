public class Nigromante extends Personaje implements Hechicero {
    private int mana;
    private int almasAbsorbidas;

    public Nigromante(String nombre, int nivel, int puntosVida, int mana, int almasAbsorbidas) {
        super(nombre, nivel, puntosVida);
        this.mana = mana;
        this.almasAbsorbidas = almasAbsorbidas;
    }

    @Override
    public void atacar() {
        System.out.println("[" + nombre + "] drena la esencia vital.");
    }

    @Override
    public int calcularDanio() {
        return nivel * 50 + almasAbsorbidas * 10; 
    }

    @Override
    public void lanzarHechizo() {
        System.out.println(nombre + " lanza: !Maldicion de decadencia! (mana: 220)");
    }

    @Override
    public int getMana() { return mana; }
}