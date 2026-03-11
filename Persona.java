public class Persona {
    String nombre;
    int edad;


    // Construye el objeto de persona
    public Persona(String varNombre, int varEdad){
        nombre = varNombre;
        edad = varEdad;
    }


    // Regresa el nombre de la persona
    public String getNombre(){
        return nombre;
    }


    // Regresa la edad de la persona
    public int getEdad(){
        return edad;
    }
}
