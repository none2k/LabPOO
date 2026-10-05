public class Druida extends Personaje {
    private int mana;
    private final int poderCuracion;

    public Druida(String nombre, int nivel, int puntosVida, int mana, int poderCuracion) {
        super(nombre, nivel, puntosVida);
        this.mana = mana;
        this.poderCuracion = poderCuracion;
    }

    @Override
    public void atacar() throws RpgException {
        if (!isEstaVivo()) {
            throw new PersonajeDerrotadoException(getNombre());
        }
        if (mana < 10) {
            throw new RecursoInsuficienteException("mana", mana);
        }
        mana -= 10;
        System.out.println("[" + getNombre() + "] invoca raices del bosque y ataca con furia natural.");
    }

    @Override
    public int calcularDanio() {
        return nivel * 30 + 30;
    }

    public void curarAliado(Personaje aliado) throws RpgException {
        if (aliado == null) {
            throw new PersonajeNuloException("curarAliado");
        }
        if (!aliado.isEstaVivo()) {
            throw new AccionInvalidaException("curarAliado", "No se puede curar a un personaje derrotado");
        }
        aliado.puntosVida += poderCuracion;
        System.out.println(getNombre() + " cura a " + aliado.getNombre() + ". Vida actual: " + aliado.getPuntosVida());
    }
}