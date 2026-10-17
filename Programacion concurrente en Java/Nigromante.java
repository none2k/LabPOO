public class Nigromante extends Personaje {
    private int mana;
    private final int almasAbsorbidas;

    public Nigromante(String nombre, int nivel, int puntosVida, int mana, int almasAbsorbidas) {
        super(nombre, nivel, puntosVida);
        this.mana = mana;
        this.almasAbsorbidas = almasAbsorbidas;
    }

    @Override
    public void atacar() throws RpgException {
        if (!isEstaVivo()) throw new PersonajeDerrotadoException(getNombre());
        if (mana < 15) throw new RecursoInsuficienteException("mana", mana);
        
        mana -= 15;
        System.out.println("[" + getNombre() + "] lanza magia oscura con " + almasAbsorbidas + " almas. Mana: " + mana);
    }

    @Override
    public int calcularDanio() {
        return nivel * 50 + almasAbsorbidas * 10;
    }
}