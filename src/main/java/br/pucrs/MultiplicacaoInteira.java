package br.pucrs;

public class MultiplicacaoInteira {

    static long contagemIteracoes = 0;

    public static long multiplicar(long x, long y, int n) {
        contagemIteracoes = 0;
        return MULTIPLY(x, y, n);
    }

    public static long MULTIPLY(long x, long y, int n) {
        contagemIteracoes++;
        if (n == 1) {
            return x * y;
        } else {
            int m = (int) Math.ceil(n / 2.0);
            long a = x >> m;
            long b = x & ((1L << m) - 1);
            long c = y >> m;
            long d = y & ((1L << m) - 1);

            long e = MULTIPLY(a, c, m);
            long f = MULTIPLY(b, d, m);
            long g = MULTIPLY(b, c, m);
            long h = MULTIPLY(a, d, m);

            return (1L << (2 * m)) * e + (1L << m) * (g + h) + f;
        }
    }

    public static void testarAlgoritmo(long x, long y, int n) {
        System.out.println("\nTestando multiplicação para números de " + n + " bits");
        long tempoInicio = System.nanoTime();
        long resultado = multiplicar(x, y, n);
        long tempoFim = System.nanoTime();
        System.out.println("Resultado: " + resultado);
        System.out.println("Tempo gasto: " + (tempoFim - tempoInicio) + " nanosegundos");
        System.out.println("Número de iterações: " + contagemIteracoes);
    }

    public static long gerarNumeroAleatorio(int bits) {
        return (long) (Math.random() * (1L << bits));
    }

    public static void main(String[] args) {
        int[] tamanhosBits = {4, 16, 64};

        for (int bits : tamanhosBits) {
            long x = gerarNumeroAleatorio(bits);
            long y = gerarNumeroAleatorio(bits);
            testarAlgoritmo(x, y, bits);
        }
    }
}
