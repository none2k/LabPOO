public class Avion extends Vehiculo {
    // 1. Atributos propios
    private int numMotores;
    private double altitudMaxima;

    // 2. Constructor
    public Avion(String marca, String modelo, int anio, double velocidadMax, int numMotores, double altitudMaxima) {
        super(marca, modelo, anio, velocidadMax);
        this.numMotores = numMotores;
        this.altitudMaxima = altitudMaxima;
    }

    // 3. Getters y Setters
    public int getNumMotores() { return numMotores; }
    
    public void setNumMotores(int numMotores) {
        if (numMotores > 0) {
            this.numMotores = numMotores;
        } else {
            System.out.println("Error: numero de motores no valido.");
        }
    }

    public double getAltitudMaxima() { return altitudMaxima; }

    public void setAltitudMaxima(double altitudMaxima) {
        // Validacion
        if (altitudMaxima > 0) {
            this.altitudMaxima = altitudMaxima;
        } else {
            System.out.println("Error: la altitud maxima no puede ser negativa o cero.");
        }
    }

    // 4. Sobreescribir toString
    @Override
    public String toString() {
        return super.toString() + "\nMotores: " + numMotores + " | Altitud Max: " + altitudMaxima + " ft";
    }
}