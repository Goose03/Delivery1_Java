import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Menu {

    ArrayList<Student> studentList = new ArrayList<Student>();
    Scanner input = new Scanner(System.in);


    // Limpia el output en la consola
    static void clearConsole(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    

    // Hace que el usario tenga que ingresar algo para continuar
    public void pressToCont(){
        System.out.println("Ingresa cualquier tecla para continuar");
        input.nextLine();

        return;
    }


    // Imprime el menu inicial
    static void printMenu(){
        String title = "SISTEMA ESTUDIANTIL v1.0 ";
        
        ArrayList<String> options = new ArrayList<String>();
        options.add("\n1. Registrar estudiantes");
        options.add("\n2. Ver calificaciones");
        options.add("\n3. Ver estadísticas");
        options.add("\n4. Buscar estudiante");
        options.add("\n5. Salir\n");

        clearConsole();
        System.out.println(title);
        System.out.println(options);
    }


    // Agrega un estudiante a la lista
    public void addStudent(){
        System.out.println("Ingresa el nombre");
        String nombre = input.nextLine();
        
        System.out.println("Ingresa la edad");
        int edad = input.nextInt();
        input.nextLine();
        
        System.out.println("Ingresa la nota");
        double nota = input.nextDouble();
        input.nextLine();

        if(nota < 0 || nota > 10){
            System.out.println("Nota invalida, creada como 0");
            pressToCont();
            nota = 0;
        }

        System.out.println("Estudiante becado? (y/n)");
        String becado = input.nextLine();
        if(becado.equals("y")) {
            studentList.add(new EstudianteBeca(nombre, edad, nota));
        } else {
            studentList.add(new EstudianteRegular(nombre, edad, nota));
        }
    }


    // Imprime las calificaciones
    public void printGrades(){
        System.out.println("Notas");
        
        for(Student i : studentList){
            System.out.println("1. " + i.getNombre() + " " + i.getNota());
        }

        pressToCont();
    }


    // Imprime las estadisticas
    public void seeStats(){
        double[] notas = new double[0];
        
        for(int i = 0; i < studentList.size(); i++){
            notas = Arrays.copyOf(notas, notas.length + 1);
            notas[notas.length - 1] = studentList.get(i).getNota();
        }

        Stats stat = new Stats();

        System.out.println("Promedio: " + stat.calcularPromedio(notas));
        System.out.println("Nota mas alta: " + stat.notaMasAlta(notas));
        System.out.println("Nota mas baja: " + stat.notaMasBaja(notas));
        System.out.println("Total de aprovados: " + stat.contarAprobados(notas));

        pressToCont();
    }
    

    // Busca a un estudiante en la lista y regresa el primero que se encuentra
    public void searchStudent() {
        System.out.println("Escribe el nombre del estudiante");
        String name = input.nextLine();

        for(int i = 0; i < studentList.size(); i++){
            if(studentList.get(i).getNombre().equals(name)) {
                System.out.println("Mostrar el estado? (y/n)");
                String estado = input.nextLine();
                
                if(estado.equals("y")) {
                    studentList.get(i).mostrarInfo(true);
                }
                else{
                    studentList.get(i).mostrarInfo();
                }

                pressToCont();
                return;
            }
        }

        System.out.println("No se encontro el usario");
        pressToCont();
        return;
    }


    // Llama a las funciones disponibles en el menu
    public void menuFunc(){
        printMenu();

        boolean exist = true;
        
        while(exist){
            printMenu();
            String userName = input.nextLine();

            switch (userName) {
                case "1":
                    clearConsole();
                    addStudent();
                    break;
                case "2":
                    clearConsole();
                    printGrades();
                    break;
                case "3":
                    clearConsole();
                    seeStats();
                    break;
                case "4":
                    clearConsole();
                    searchStudent();
                    break;
                case "5":
                    clearConsole();
                    exist = false;
                    break;
            
                default:
                    System.out.println("Valor no valido");
                    break;
            }
        }
        
        return;
    }
}
