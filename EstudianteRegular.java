public class EstudianteRegular extends Student {
    String tipo;


    // Construye el tipo de estudiante
    public EstudianteRegular(String varNombre, int varEdad, double varNota){
        super(varNombre, varEdad, varNota);
        tipo = "Regular";
    }

    
    // Regresa el tipo de estudiante que es
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
