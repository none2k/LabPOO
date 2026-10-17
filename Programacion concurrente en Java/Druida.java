public class Druida extends Personaje {
    private int mana;
    private final int poderCuracion;
    private final String formaNatural;

    public int getPoderCuracion() {
    return poderCuracion;
    }

    public Druida(String nombre, int nivel, int puntosVida, int mana, int poderCuracion, String formaNatural) {
        super(nombre, nivel, puntosVida);
        this.mana = mana;
        this.poderCuracion = poderCuracion;
        this.formaNatural = formaNatural;
    }

    @Override
    public void atacar() throws RpgException {
        if (!isEstaVivo()) throw new PersonajeDerrotadoException(getNombre());
        if (mana < 10) throw new RecursoInsuficienteException("mana", mana);
        
        mana -= 10;
        System.out.println("[" + getNombre() + "] en forma de " + formaNatural + " ataca. Mana: " + mana);
    }

    @Override
    public int calcularDanio() {
        return nivel * 30;
    }
}