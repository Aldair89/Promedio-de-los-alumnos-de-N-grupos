package com.mycompany.mavenproject1;
import java.util.Scanner;

public class Mavenproject1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de grupos que va a calificar: ");
        int numGrupos = scanner.nextInt();
        scanner.nextLine();

        System.out.println();

        // Arreglos para almacenar los datos de los alumnos
        String[][] nombres = new String[numGrupos][];
        String[][] grados = new String[numGrupos][];
        String[][] grupos = new String[numGrupos][];
        String[][] especialidades = new String[numGrupos][];
        int[][] parciales = new int[numGrupos][];
        double[][][] promedios = new double[numGrupos][][];

        for (int i = 0; i < numGrupos; i++) {
            System.out.println("Grupo " + (i + 1));

            System.out.print("Ingrese el número de alumnos en el grupo: ");
            int numAlumnos = scanner.nextInt();
            scanner.nextLine();

            // Almacenar los datos de cada alumno en los arreglos correspondientes
            nombres[i] = new String[numAlumnos];
            grados[i] = new String[numAlumnos];
            grupos[i] = new String[numAlumnos];
            especialidades[i] = new String[numAlumnos];
            parciales[i] = new int[numAlumnos];
            promedios[i] = new double[numAlumnos][];

            boolean evaluarOtroParcial = true;

            while (evaluarOtroParcial) {
                for (int j = 0; j < numAlumnos; j++) {
                    System.out.println("Alumno " + (j + 1));

                    System.out.print("Ingrese el nombre del alumno: ");
                    nombres[i][j] = scanner.nextLine();

                    System.out.print("Ingrese el grado del alumno: ");
                    grados[i][j] = scanner.nextLine();

                    System.out.print("Ingrese el grupo del alumno: ");
                    grupos[i][j] = scanner.nextLine();

                    System.out.print("Ingrese la especialidad del alumno: ");
                    especialidades[i][j] = scanner.nextLine();

                    System.out.print("Ingrese en qué parcial se encuentra el alumno: ");
                    int numParcial = scanner.nextInt();
                    scanner.nextLine();

                    if (numParcial > parciales[i][j]) {
                        parciales[i][j] = numParcial;
                    } else {
                        System.out.println("Ya se ha ingresado una calificación para el parcial " + numParcial);
                        continue;
                    }

                    System.out.print("Ingrese el número de materias del alumno: ");
                    int numMaterias = scanner.nextInt();
                    scanner.nextLine();

                    // Crear arreglos para almacenar los nombres de las materias y las calificaciones
                    String[] materias = new String[numMaterias];
                    double[] calificaciones = new double[numMaterias];
                    promedios[i][j] = new double[numParcial];

                    for (int k = 0; k < numMaterias; k++) {
                        System.out.print("Ingrese el nombre de la materia " + (k + 1) + ": ");
                        materias[k] = scanner.nextLine();

                        for (int p = 0; p < numParcial; p++) {
                            System.out.print("Ingrese la calificación del parcial " + (p + 1) + " para la materia " + materias[k] + ": ");
                            calificaciones[k] = scanner.nextDouble();
                            promedios[i][j][p] += calificaciones[k];
                        }
                        scanner.nextLine();
                    }

                    System.out.println();
                }

                System.out.print("¿Desea evaluar otro parcial? (S/N): ");
                String respuesta = scanner.nextLine();
                if (respuesta.equalsIgnoreCase("N")) {
                    evaluarOtroParcial = false;
                }
            }

            System.out.println();
        }

        System.out.println("Resultados:");

        for (int i = 0; i < numGrupos; i++) {
            System.out.println("Grupo " + (i + 1));

            for (int j = 0; j < nombres[i].length; j++) {
                System.out.println("Alumno: " + nombres[i][j]);
                System.out.println("Salón: " + grados[i][j] + " " + grupos[i][j]);
                System.out.println("Especialidad: " + especialidades[i][j]);

                System.out.println("Parciales:");

                for (int k = 0; k < parciales[i][j]; k++) {
                    System.out.println("Parcial " + (k + 1));
                    System.out.println("Promedio: " + (promedios[i][j][k] / nombres[i].length));

                    if ((promedios[i][j][k] / nombres[i].length) >= 6.0) {
                        System.out.println("Estado: Aprobado");
                    } else {
                        System.out.println("Estado: Reprobado");
                    }

                    System.out.println();
                }

                // Calcular y mostrar el promedio de los parciales de forma individual
                for (int k = 0; k < parciales[i][j]; k++) {
                    System.out.println("Promedio Parcial " + (k + 1) + ": " + (promedios[i][j][k] / nombres[i].length));
                }

                System.out.println();
            }
        }

        scanner.close();
    }
}