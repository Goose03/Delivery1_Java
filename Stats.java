import java.util.Arrays;

public class Stats {
    // Suma la nota de todos los estudiantes
    double sumarNotas(double[] notas, int i){
        if (i <= 0) {
            return notas[0];
        } else {
            return notas[i] + sumarNotas(notas, i - 1);
        }
    }


    // Calcula el promedio de todos los estudiantes
    double calcularPromedio(double[] notas){
        return sumarNotas(notas, notas.length - 1) / notas.length;
    }


    // Regresa la nota mas alta
    double notaMasAlta(double[] notas){
        return Arrays.stream(notas).max().getAsDouble();
    }


    // Regresa la nota mas baja
    double notaMasBaja(double[] notas){
        return Arrays.stream(notas).min().getAsDouble();
    }


    // Cuenta la cantidad de estudiantes aprovados
    int contarAprobados(double[] notas){
        int count = 0;

        for(int i = 0; i < notas.length; i++){
            if(notas[i] >= 6.0) {
                count += 1;
            }
        }

        return count;
    }
}
