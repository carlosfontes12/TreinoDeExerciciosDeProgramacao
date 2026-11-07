package TreinoDeExerciciosDeProgramacao.ExerciciosJava;

import java.util.Scanner;

public class CaixaRegistadora {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // declaração de variáveis
        double preçoArtigo;
        int contadorProdutos = 0;
        double TotalCompras = 0;
        double MediaCompras = 0;
        double Desconto = 0;
        double TotalComDesconto = 0;
        int contadorArtigosAcimaDeCinco = 0;
        double MaisCaro = 0;

        do {

            //ler o preço do artigo
            System.out.print("Digite o preço do artigo (-1 para terminar): ");
            preçoArtigo = input.nextDouble();

            if (preçoArtigo < -1 || preçoArtigo == 0) {
                System.out.println("Preço Inválido");
                continue;
            }

            //verificar se o preço é válido
            if (preçoArtigo == -1) {
                break;
            }
            // incrementar o contador de produtos válidos
            contadorProdutos++;
            // atualizar o total de compras e a média
            TotalCompras += preçoArtigo;
            MediaCompras = TotalCompras / contadorProdutos;

            // aplicar desconto se o total de compras for maior ou igual a 50
            if (TotalCompras >= 50) {
                Desconto = TotalCompras * 0.1;
                TotalComDesconto = TotalCompras - Desconto;

            }
            // contar artigos com preço acima de 5
            if (preçoArtigo >= 5) {
                contadorArtigosAcimaDeCinco++;
            }
            if (preçoArtigo > MaisCaro) {
                MaisCaro = preçoArtigo;
            }

        } while (preçoArtigo != -1);

        //Apresentação dos resultados
        System.out.println("---Talão---");
        System.out.println("Artigos Registados " + contadorProdutos);
        System.out.println("Total: " + TotalCompras);
        System.out.println("Preço Médio: " + MediaCompras);
        System.out.println("Desconto de 10% aplicado: " + Desconto);
        System.out.println("Total a pagar " + TotalComDesconto);
        System.out.println("Artigos com preço acima de 5€: " + contadorArtigosAcimaDeCinco);
        System.out.println("Artigo mais caro: " + MaisCaro);
    }
}
