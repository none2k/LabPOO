public class Perro extends Animal {
    // 1. Atributos propios
    private final String raza;
    private final boolean estaVacunado;

    // 2. Constructor usando super()
    public Perro(String nombre, int edad, double peso, String raza, boolean estaVacunado) {
        super(nombre, edad, peso); // Llama al constructor de Animal
        this.raza = raza;
        this.estaVacunado = estaVacunado;
    }

    // 3. Metodos propios
    public void ladrar() {
        System.out.println(getNombre() + " dice: Guau guau!");
    }

    public void buscarPelota() {
        System.out.println(getNombre() + " esta buscando la pelota...");
    }

    // Sobreescritura de toString()
    @Override
    public String toString() {
        String vacunado = estaVacunado ? "Si" : "No";
        // Llamamos al toString() de Animal y le concatenamos lo propio del Perro
        return super.toString() + " | Raza: " + raza + " | Vacunado: " + vacunado;
    }
}