package TreinoDeExerciciosDeProgramacao;

import java.util.Scanner;

public class Corrida {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

// declarar e inicializar o array de números
        double[] km = new double[7];
        double[] treinosLongos = new double[7];
        double total = 0;
        double media = 0;
        int contadorMaiorQueMedia = 0;
        int contadorKmZero = 0;

        //ciclo de leitura
        for (int i = 0; i < km.length; i++) {
            do {
                if (km[i] < 0) {
                    System.out.println("Valor inválido. Insira um valor maior ou igual a 0.");
                }
                System.out.print("Insira os km: ");
                km[i] = input.nextDouble();
            } while (km[i] < 0);
        }

        //ciclo de escrita para calcular o total de km
        for (int i = 0; i < km.length; i++) {
            total += km[i];
        }

        // calcular a média
        media = total / km.length;

        // mostrar cada km
        for (int i = 0; i < km.length; i++) {
            if (km[i] > media) {
                contadorMaiorQueMedia++;
            }
        }

        // contar os dias de descanso (km == 0)
        for (int i = 0; i < km.length; i++) {
            if (km[i] == 0) {
                contadorKmZero++;
            }
        }

        //copiar os treinos longos (5 km ou mais) para o segundo vetor
        int quantosLongos = 0; // próxima posição livre = quantas posições já estão preenchidas
        for (int i = 0; i < km.length; i++) {
            if (km[i] >= 5) {
                treinosLongos[quantosLongos] = km[i];
                quantosLongos++;
            }
        }

        //mostrar só as posições preenchidas do segundo vetor
        for (int i = 0; i < quantosLongos; i++) {
            System.out.println("Treino longo: " + treinosLongos[i]);
        }

        //ver o maior numero de km
        double maior = km[0];
        int indiceMaior = 0;

        for (int i = 1; i < km.length; i++) {
            if (km[i] > maior) {
                maior = km[i];
                indiceMaior = i;
            }

        }

        //leitura em ordem inversa
        for (int i = km.length - 1; i >= 0; i--) {
            System.out.println("Km " + (i + 1) + ": " + km[i]);
        }
        System.out.println();

        // mostrar resultados
        System.out.println("Total: " + total);
        System.out.println("Média: " + media);
        System.out.println("Dias de descanso: " + contadorKmZero);
        System.out.println("Número de km acima da média: " + contadorMaiorQueMedia);
        System.out.println("Melhor dia: dia " + (indiceMaior + 1) + " (" + maior + " km)");

    }

}
//System.out.println("Km " + (i + 1) + ": " + km[i]);
