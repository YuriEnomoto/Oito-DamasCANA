public class OitoRainhas {

    static final int N = 8; // tamanho do tabuleiro

// função para imprimir a solução
    static void imprimirSolucao(int tabuleiro[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + tabuleiro[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

// verificar se uma rainha pode ser colocada em tabuleiro[linha][coluna]
    static boolean ehSeguro(int tabuleiro[][], int linha, int coluna) {
        int i, j;

// verifica a linha à esquerda
        for (i = 0; i < coluna; i++)
            if (tabuleiro[linha][i] == 1)
                return false;

// verifica a diagonal superior à esquerda
        for (i = linha, j = coluna; i >= 0 && j >= 0; i--, j--)
            if (tabuleiro[i][j] == 1)
                return false;

// verifica a diagonal inferior à esquerda
        for (i = linha, j = coluna; j >= 0 && i < N; i++, j--)
            if (tabuleiro[i][j] == 1)
                return false;

        return true;
    }

// função recursiva para resolver o problema das oito rainhas
    static boolean resolverOitoRainhasRec(int tabuleiro[][], int coluna) {
// se todas as rainhas estão colocadas, então retorna verdadeiro
        if (coluna >= N)
            return true;

// considere esta coluna e tente colocar esta rainha em todas as linhas uma por uma
        for (int i = 0; i < N; i++) {
// verifica se a rainha pode ser colocada em tabuleiro[i][coluna]
            if (ehSeguro(tabuleiro, i, coluna)) {
// coloca a rainha nesta posição tabuleiro[i][coluna]
                tabuleiro[i][coluna] = 1;
// imprime o tabuleiro após colocar uma rainha
                imprimirSolucao(tabuleiro);

// recursivamente coloca as rainhas nas colunas restantes
                if (resolverOitoRainhasRec(tabuleiro, coluna + 1))
                    return true;

// se colocar a rainha em tabuleiro[i][coluna] não leva a uma solução, então remova a rainha desta posição
                tabuleiro[i][coluna] = 0; // backtracking
// imprime o tabuleiro após remover uma rainha
                imprimirSolucao(tabuleiro);
            }
        }

// se a rainha não pode ser colocada em nenhuma linha nesta coluna, então retorna falso
        return false;
    }

// função principal para resolver o problema das oito rainhas
    static void resolverOitoRainhas() {
        int tabuleiro[][] = new int[N][N];

        if (!resolverOitoRainhasRec(tabuleiro, 0)) {
            System.out.println("Não possui solução");
            return;
        }

//imprime a solução final
        imprimirSolucao(tabuleiro);
    }

    public static void main(String[] args) {
        resolverOitoRainhas();
    }
}
