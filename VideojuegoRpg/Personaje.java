public class Personaje implements Combatiente {
    // Atributos privados
    private final String nombre;
    private final int nivel;
    private int puntosVida;
    private boolean estaVivo;

    // Constructor
    public Personaje(String nombre, int nivel, int puntosVida) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.puntosVida = puntosVida;
        this.estaVivo = true; // Se inicializa en true por defecto
    }

    // Getters
    public String getNombre() { return nombre; }
    public int getNivel() { return nivel; }
    public int getPuntosVida() { return puntosVida; }
    public boolean isEstaVivo() { return estaVivo; }

    // Metodo para recibir danio
    public void recibirDanio(int danio) {
        this.puntosVida -= danio;
        if (this.puntosVida <= 0) {
            this.puntosVida = 0;
            this.estaVivo = false;
        }
        System.out.println(nombre + " recibe " + danio + " puntos de danio. Vida restante: " + puntosVida);
        if (!estaVivo) {
            System.out.println(nombre + " ha sido derrotado.");
        }
    }

    // Implementacion generica de los metodos de la interfaz
    @Override
    public void atacar() {
        System.out.println("[" + nombre + "] ataca con un golpe basico.");
    }

    @Override
    public void defender() {
        System.out.println(nombre + " se pone en guardia.");
    }

    // Sobreescritura de toString
    @Override
    public String toString() {
        String vivo = estaVivo ? "Si" : "No";
        return "Nombre: " + nombre + " | Nivel: " + nivel + " | Vida: " + puntosVida + " | Vivo: " + vivo;
    }
}