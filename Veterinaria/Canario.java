public class Canario extends Animal {
    // 1. Atributos propios
    private final String colorPlumaje;
    private final boolean cantaEnJaula;

    // 2. Constructor
    public Canario(String nombre, int edad, double peso, String colorPlumaje, boolean cantaEnJaula) {
        super(nombre, edad, peso);
        this.colorPlumaje = colorPlumaje;
        this.cantaEnJaula = cantaEnJaula;
    }

    // 3. Metodos propios
    public void cantar() {
        System.out.println(getNombre() + " esta cantando:  pi pi pi");
    }

    public void volar() {
        System.out.println(getNombre() + " esta volando en la habitacion.");
    }

    // 4. Sobreescritura
    @Override
    public String toString() {
        String canta = cantaEnJaula ? "Si" : "No";
        return super.toString() + " | Plumaje: " + colorPlumaje + " | Canta en jaula: " + canta;
    }
}