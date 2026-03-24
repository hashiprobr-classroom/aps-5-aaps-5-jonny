package br.edu.insper.desagil.pi.tocha;

public class Filtro {
    private String tipo;

    public Filtro(String tipo) {
        this.tipo = tipo;
    }

    private Imagem aplica(Imagem imagem, double[][] pesos) {
        int[][] entrada = imagem.getPixels();

        int altura = entrada.length;
        if (altura < 3) {
            throw new IllegalStateException("altura pequena");
        }

        int largura = entrada[0].length;
        if (largura < 3) {
            throw new IllegalStateException("largura pequena");
        }

        int[][] saida = new int[altura - 2][largura - 2];

        for (int y = 1; y < altura - 1; y++) {
            for (int x = 1; x < largura - 1; x++) {
                double s = 0;
                for (int dy = -1; dy < 2; dy++) {
                    for (int dx = -1; dx < 2; dx++) {
                        s += entrada[y + dy][x + dx] * pesos[dy + 1][dx + 1];
                    }
                }
                saida[y - 1][x - 1] = (int) s;
            }
        }

        return new Imagem(saida);
    }

    public Imagem processa(Imagem imagem) {
        if (tipo.equals("media")) {
            double[][] pesos = new double[3][3];
            pesos[0][0] = 0.111111;
            pesos[0][1] = 0.111111;
            pesos[0][2] = 0.111111;
            pesos[1][0] = 0.111111;
            pesos[1][1] = 0.111111;
            pesos[1][2] = 0.111111;
            pesos[2][0] = 0.111111;
            pesos[2][1] = 0.111111;
            pesos[2][2] = 0.111111;
            return aplica(imagem, pesos);
        } else if (tipo.equals("sobel_x")) {
            double[][] pesos = new double[3][3];
            pesos[0][0] = -1;
            pesos[0][1] = 0;
            pesos[0][2] = 1;
            pesos[1][0] = -2;
            pesos[1][1] = 0;
            pesos[1][2] = 2;
            pesos[2][0] = -1;
            pesos[2][1] = 0;
            pesos[2][2] = 1;
            return aplica(imagem, pesos);
        } else if (tipo.equals("sobel_y")) {
            double[][] pesos = new double[3][3];
            pesos[0][0] = -1;
            pesos[0][1] = -2;
            pesos[0][2] = -1;
            pesos[1][0] = 0;
            pesos[1][1] = 0;
            pesos[1][2] = 0;
            pesos[2][0] = 1;
            pesos[2][1] = 2;
            pesos[2][2] = 1;
            return aplica(imagem, pesos);
        } else if (tipo.equals("laplace")) {
            double[][] pesos = new double[3][3];
            pesos[0][0] = 0;
            pesos[0][1] = -1;
            pesos[0][2] = 0;
            pesos[1][0] = -1;
            pesos[1][1] = 4;
            pesos[1][2] = -1;
            pesos[2][0] = 0;
            pesos[2][1] = -1;
            pesos[2][2] = 0;
            return aplica(imagem, pesos);
        } else {
            throw new IllegalStateException("tipo invalido");
        }
    }
}