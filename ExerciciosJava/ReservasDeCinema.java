package TreinoDeExerciciosDeProgramacao.ExerciciosJava;

import java.util.Scanner;

public class ReservasDeCinema {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //declarar variaveis
        char[][] matriz = new char[4][6];
        int fila;

        //ciclo para inicializar a matriz com 'L' (livre)
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int lugar = 0; lugar < matriz[0].length; lugar++) {
                matriz[linha][lugar] = 'L';
            }
        }

        //ciclo para ler as reservas do cinema
        System.out.print("Fila (-1 para terminar): ");
        fila = input.nextInt();

        while (fila != -1) {

            System.out.print("Lugar: ");
            int lugar = input.nextInt();

            //para o utilizador as filas e lugares começam em 1, na matriz começam em 0
            if (fila < 1 || fila > matriz.length || lugar < 1 || lugar > matriz[0].length) {
                System.out.println("Lugar inexistente!");
            } else if (matriz[fila - 1][lugar - 1] == 'X') {
                System.out.println("Lugar já ocupado!");
            } else {
                matriz[fila - 1][lugar - 1] = 'X';
                System.out.println("Reserva efetuada!");
            }

            System.out.print("Fila (-1 para terminar): ");
            fila = input.nextInt();
        }
        //imprimir o cabeçalho com os números dos lugares (1 a 6)
        System.out.print("     ");
        for (int lugar = 0; lugar < matriz[0].length; lugar++) {
            System.out.print((lugar + 1) + " ");
        }
        System.out.println();

        //imprimir a matriz final com as reservas
        for (int linha = 0; linha < matriz.length; linha++) {
            System.out.print("F" + (linha + 1) + "   ");
            for (int lugar = 0; lugar < matriz[0].length; lugar++) {
                System.out.print(matriz[linha][lugar] + " ");
            }
            System.out.println();
        }

        //estatísticas: livres por fila, total de ocupados e fila com mais livres
        int totalOcupados = 0;
        int maxLivres = -1;
        int filaComMaisLivres = 0;

        for (int linha = 0; linha < matriz.length; linha++) {
            int livres = 0;
            for (int lugar = 0; lugar < matriz[0].length; lugar++) {
                if (matriz[linha][lugar] == 'L') {
                    livres++;
                } else {
                    totalOcupados++;
                }
            }
            System.out.println("Livres na F" + (linha + 1) + ": " + livres);

            if (livres > maxLivres) {
                maxLivres = livres;
                filaComMaisLivres = linha;
            }
        }

        int totalLugares = matriz.length * matriz[0].length;
        double taxa = (double) totalOcupados / totalLugares * 100;

        System.out.println("Lugares ocupados: " + totalOcupados + " de " + totalLugares);
        System.out.printf("Taxa de ocupação: %.1f%%%n", taxa);
        System.out.println("Fila com mais lugares livres: F" + (filaComMaisLivres + 1));
    }
}
