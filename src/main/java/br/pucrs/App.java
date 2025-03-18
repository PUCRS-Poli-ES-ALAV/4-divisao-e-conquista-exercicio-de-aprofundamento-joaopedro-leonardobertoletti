package br.pucrs;

public class App {

    public static long encontrarMaiorValor1(long[] A, int n) {
        long maior = A[0];
        for (int i = 1; i < n; i++) {
            if (A[i] > maior)
                maior = A[i];
        }
        return maior;
    }

    public static long encontrarMaiorValor2(long[] A, int inicio, int fim) {
        if (fim - inicio <= 1)
            return Math.max(A[inicio], A[fim]);
        else {
            int meio = (inicio + fim) / 2;
            long v1 = encontrarMaiorValor2(A, inicio, meio);   
            long v2 = encontrarMaiorValor2(A, meio + 1, fim);  
            return Math.max(v1, v2);
        }
    }

    public static long[] gerarVetorAleatorio(int tamanho) {
        long[] vetor = new long[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = (long) (Math.random() * 1000000);
        }
        return vetor;
    }

    public static void testarAlgoritmo(long[] vetor, int n) {
        System.out.println("Algoritmo iterativo:");
        long tempoInicio = System.nanoTime();
        long maiorIterativo = encontrarMaiorValor1(vetor, n);
        long tempoFim = System.nanoTime();
        System.out.println("Máximo encontrado (Iterativo): " + maiorIterativo);
        System.out.println("Tempo gasto (Iterativo): " + (tempoFim - tempoInicio) + " nanosegundos");

        System.out.println("Algoritmo recursivo:");
        tempoInicio = System.nanoTime();
        long maiorRecursivo = encontrarMaiorValor2(vetor, 0, n - 1);
        tempoFim = System.nanoTime();
        System.out.println("Máximo encontrado (Recursivo): " + maiorRecursivo);
        System.out.println("Tempo gasto (Recursivo): " + (tempoFim - tempoInicio) + " nanosegundos");
    }

    public static void main(String[] args) {
        int[] tamanhos = {32, 2048, 1048576};

        for (int tamanho : tamanhos) {
            System.out.println("\nTestando vetor de tamanho: " + tamanho);
            long[] vetorAleatorio = gerarVetorAleatorio(tamanho);

            testarAlgoritmo(vetorAleatorio, tamanho);
        }
    }
}
