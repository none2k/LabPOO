public class Druida extends Personaje implements Hechicero, Sanador {
    private int mana;
    private int poderCuracion;
    private String formaNatural;

    public Druida(String nombre, int nivel, int puntosVida, int mana, int poderCuracion, String formaNatural) {
        super(nombre, nivel, puntosVida);
        this.mana = mana;
        this.poderCuracion = poderCuracion;
        this.formaNatural = formaNatural;
    }

    @Override
    public void atacar() {
        System.out.print("[" + nombre + "] en forma de " + formaNatural + " invoca raices del bosque. ");
    }

    @Override
    public int calcularDanio() {
        return nivel * 30 + 30; 
    }

    @Override
    public void lanzarHechizo() {
        System.out.println(nombre + " lanza: !Tormenta de espinas! (mana: 180)");
    }

    @Override
    public int getMana() { return mana; }

    @Override
    public void curarAliado(Personaje aliado) {
        aliado.puntosVida += poderCuracion; 
        System.out.println(nombre + " toca la tierra y cura a " + aliado.getNombre() + " +" + poderCuracion + ". Vida: " + aliado.puntosVida);
    }

    @Override
    public int getPoderCuracion() { return poderCuracion; }
}