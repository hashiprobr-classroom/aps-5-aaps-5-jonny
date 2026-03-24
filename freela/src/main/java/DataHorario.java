public class DataHorario extends Momento {
    private int hora;
    private int minuto;
    private Data data;

    public DataHorario(Data data) {
        this.hora = 0;
        this.minuto = 0;
        this.data = data;
    }

    public int getHora() {
        return this.hora;
    }

    public int getMinuto() {
        return this.minuto;
    }

    public Data getData() {
        return this.data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public void atualiza(int novaHora, int novoMinuto) {
        this.hora = ajusta(novaHora, 0, 23);
        this.minuto = ajusta(novoMinuto, 0, 59);
    }

    @Override
    public int minutos() {
        return this.data.minutos() + this.hora * 60 + this.minuto;
    }
}