public class Gato extends Animal {
    // 1. Atributos propios
    private final String color;
    private final boolean esInterior;

    // 2. Constructor
    public Gato(String nombre, int edad, double peso, String color, boolean esInterior) {
        super(nombre, edad, peso);
        this.color = color;
        this.esInterior = esInterior;
    }

    // 3. Metodos propios
    public void maullar() {
        System.out.println(getNombre() + " dice: Miau!");
    }

    public void ronronear() {
        System.out.println(getNombre() + " esta ronroneando...");
    }

    // 4. Sobreescritura
    @Override
    public String toString() {
        String interior = esInterior ? "Si" : "No";
        return super.toString() + " | Color: " + color + " | Interior: " + interior;
    }
}