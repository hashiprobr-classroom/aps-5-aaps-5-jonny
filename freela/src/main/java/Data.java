import java.util.HashMap;
import java.util.Map;

public class Data extends Momento {
    private int ano;
    private int mes;
    private int dia;
    private Map<Integer, Integer> limite;

    public Data() {
        this.ano = 1970;
        this.mes = 1;
        this.dia = 1;
        this.limite = new HashMap<>();

        limite.put(1, 31);
        limite.put(2, 28);
        limite.put(3, 31);
        limite.put(4, 30);
        limite.put(5, 31);
        limite.put(6, 30);
        limite.put(7, 31);
        limite.put(8, 31);
        limite.put(9, 30);
        limite.put(10, 31);
        limite.put(11, 30);
        limite.put(12, 31);
    }

    public int getAno() {
        return ano;
    }

    public int getMes() {
        return mes;
    }

    public int getDia() {
        return dia;
    }

    public void atualiza(int novoAno, int novoMes, int novoDia) {
        this.ano = ajusta(novoAno, 1970, 2070);
        this.mes = ajusta(novoMes, 1, 12);
        this.dia = ajusta(novoDia, 1, limite.get(this.mes));
    }

    @Override
    public int minutos() {
        int totalDias = 0;

        totalDias += (ano - 1970) * 365;

        for (int m = 1; m < mes; m++) {
            totalDias += limite.get(m);
        }

        totalDias += (dia - 1);

        return totalDias * 24 * 60;
    }
}