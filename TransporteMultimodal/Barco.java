public class Barco extends Vehiculo {
    // 1. Atributos propios
    private String tipoCasco;
    private double eslora; // Longitud del barco

    // 2. Constructor
    public Barco(String marca, String modelo, int anio, double velocidadMax, String tipoCasco, double eslora) {
        super(marca, modelo, anio, velocidadMax);
        this.tipoCasco = tipoCasco;
        this.eslora = eslora;
    }

    // 3. Getters y Setters
    public String getTipoCasco() { return tipoCasco; }
    
    public void setTipoCasco(String tipoCasco) {
        this.tipoCasco = tipoCasco;
    }

    public double getEslora() { return eslora; }

    public void setEslora(double eslora) {
        // Validacion
        if (eslora > 0) {
            this.eslora = eslora;
        } else {
            System.out.println("Error: la eslora debe ser mayor a 0.");
        }
    }

    // 4. Sobreescribir toString
    @Override
    public String toString() {
        return super.toString() + "\nTipo de Casco: " + tipoCasco + " | Eslora: " + eslora + " metros";
    }
}