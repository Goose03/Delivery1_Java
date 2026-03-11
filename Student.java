public class Student extends Persona {
    double nota;


    // Construye el objeto de estudiante
    public Student(String varNombre, int varEdad, double varNota){
        super(varNombre, varEdad);
        nota = varNota;
    }


    // Regresa la nota
    public double getNota(){
        return nota;
    }


    // Valida si un estudiante esta aprovado
    String obtenerEstado() {
        return (nota >= 6.0) ? "Aprobado" : "Reprobado";   
    }


    // Regresa la informacion de un usario
    void mostrarInfo() {
        System.out.println("Nombre: " +  getNombre());
        System.out.println("Edad: " +  getEdad());
        System.out.println("Nota: " +  getNota());
    }


    // Muestra la informacion del usario y si esta aprovado
    void mostrarInfo(boolean mostrarEstado) {
        mostrarInfo();

        if(mostrarEstado) {
            System.out.println("Estado: " + obtenerEstado());
        }
    }
}
