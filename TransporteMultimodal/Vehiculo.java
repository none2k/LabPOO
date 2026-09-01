public class Vehiculo {
    // 1. Atributos
    private final String marca;
    private final String modelo;
    private int anio;
    protected double velocidadMax; // protected: accesible por las subclases

    // 2. Constructor
    public Vehiculo(String marca, String modelo, int anio, double velocidadMax) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.velocidadMax = velocidadMax;
    }

    // 3. Getters
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public int getAnio() { return anio; }
    public double getVelocidadMax() { return velocidadMax; }

    // 4. Setters con validacion
    public void setAnio(int anio) {
        if (anio >= 1885 && anio <= 2100) {
            this.anio = anio;
        } else {
            System.out.println("Error: anio no valido.");
        }
    }

    public void setVelocidadMax(double vel) {
        if (vel > 0) {
            this.velocidadMax = vel;
        } else {
            System.out.println("Error: velocidad no valida.");
        }
    }

    // 5. Metodo describir
    public void describir() {
        System.out.println(toString());
    }

    // 6. Sobreescribir toString
    @Override
    public String toString() {
        return "Marca: " + marca + " | Modelo: " + modelo + " | Anio: " + anio + " | Vel. Max: " + velocidadMax + " km/h";
    }
}