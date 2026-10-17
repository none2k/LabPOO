public class PersonajeDerrotadoException extends RpgException {
    public PersonajeDerrotadoException(String nombrePersonaje) {
        super("El personaje '" + nombrePersonaje + "' esta derrotado y no puede realizar esta accion.");
    }
}