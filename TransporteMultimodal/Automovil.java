public class Automovil extends Vehiculo {
    // 1. Atributos propios
    private int numPuertas;
    private boolean esElectrico;

    // 2. Constructor
    public Automovil(String marca, String modelo, int anio, double velocidadMax, int numPuertas, boolean esElectrico) {
        super(marca, modelo, anio, velocidadMax);
        this.numPuertas = numPuertas;
        this.esElectrico = esElectrico;
    }

    // 3. Getters
    public int getNumPuertas() { return numPuertas; }
    public boolean isElectrico() { return esElectrico; }

    // 4. Setter con validacion
    public void setNumPuertas(int numPuertas) {
        if (numPuertas >= 2 && numPuertas <= 6) {
            this.numPuertas = numPuertas;
        } else {
            System.out.println("Error: numero de puertas no valido.");
        }
    }

    // Setter para esElectrico (opcional, pero buena practica)
    public void setEsElectrico(boolean esElectrico) {
        this.esElectrico = esElectrico;
    }

    // 5. Sobreescribir toString
    @Override
    public String toString() {
        String electrico = esElectrico ? "Si" : "No";
        return super.toString() + "\nPuertas: " + numPuertas + " | Electrico: " + electrico;
    }
}