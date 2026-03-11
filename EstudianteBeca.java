public class EstudianteBeca extends Student {
    String tipo;


    // Construye el tipo de estudiante
    public EstudianteBeca(String varNombre, int varEdad, double varNota){
        super(varNombre, varEdad, varNota);
        tipo = "Becado";
    }


    // Regresa el tipo de estudiante
    public String obtenerTipo() {
        return tipo;
    }


    // Imprime la informacion del estudiante
    @Override
    void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Tipo: " +  obtenerTipo());
    }
}
