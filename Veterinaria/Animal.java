public class Animal {
    // 1. Atributos con modificador privado
    private final String nombre;
    private final int edad;
    private final double peso;

    // 2. Constructor
    public Animal(String nombre, int edad, double peso) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
    }

    // Método 'getter' para usar el nombre en las clases hijas
    public String getNombre() {
        return nombre;
    }

    // 3. Métodos
    public void comer() {
        System.out.println(nombre + " esta comiendo.");
    }

    public void dormir() {
        System.out.println(nombre + " esta durmiendo.");
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " | Edad: " + edad + " anios | Peso: " + peso + " kg";
    }
}