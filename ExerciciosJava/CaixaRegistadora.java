package TreinoDeExerciciosDeProgramacao.ExerciciosJava;

import java.util.Scanner;

public class CaixaRegistadora {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // declaração de variáveis
        double preçoArtigo;
        int contadorProdutos = 0;
        double totalCompras = 0;
        double mediaCompras = 0;
        double desconto = 0;
        double totalComDesconto = 0;
        int contadorArtigosAcimaDeCinco = 0;
        double maisCaro = 0;

        do {

            //ler o preço do artigo
            System.out.print("Digite o preço do artigo (-1 para terminar): ");
            preçoArtigo = input.nextDouble();

            if (preçoArtigo <= 0 && preçoArtigo != -1) {
                System.out.println("Preço inválido. Digite um valor positivo.");
                continue;
            }

            //verificar se o preço é válido
            if (preçoArtigo == -1) {
                break;
            }
            // incrementar o contador de produtos válidos
            contadorProdutos++;
            // atualizar o total de compras e a média
            totalCompras += preçoArtigo;
            mediaCompras = totalCompras / contadorProdutos;

            // aplicar desconto se o total de compras for maior ou igual a 50
            if (totalCompras >= 50) {
                desconto = totalCompras * 0.1;
                totalComDesconto = totalCompras - desconto;
            } else {
                totalComDesconto = totalCompras;
            }

            // contar artigos com preço acima de 5
            if (preçoArtigo > 5) {
                contadorArtigosAcimaDeCinco++;
            }
            if (preçoArtigo > maisCaro) {
                maisCaro = preçoArtigo;
            }

        } while (preçoArtigo != -1);

        //Apresentação dos resultados
        System.out.println("---Talão---");
        System.out.println("Artigos Registados " + contadorProdutos);
        System.out.println("Total: " + totalCompras);
        System.out.println("Preço Médio: " + mediaCompras);
        System.out.println("Desconto de 10% aplicado: " + desconto);
        System.out.println("Total a pagar " + totalComDesconto);
        System.out.println("Artigos com preço acima de 5€: " + contadorArtigosAcimaDeCinco);
        System.out.println("Artigo mais caro: " + maisCaro);
    }
}
