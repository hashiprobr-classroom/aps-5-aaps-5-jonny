package br.edu.insper.desagil.pi.freela;

public class DataHorario extends Momento{
    private int hora;
    private int minuto;
    private Data data;

    public DataHorario(Data data){
        this.hora = 0;
        this.minuto = 0;
        this.data = data;
    }
    public int getHora(){
        return hora;
    }
    public int getMinuto(){
        return minuto;
    }
    public Data getData(){
        return data;
    }
    public void setData(Data data){
        this.data = data;
    }

    public void atualiza(int hora, int minuto){
        if (hora < 0 || hora > 23){
            hora = ajusta(hora,0,23);
        }
        if (minuto < 0 || minuto > 59){
            minuto = ajusta(minuto,0,59);
        }
        this.hora = hora;
        this.minuto = minuto;
    }
    @Override
    public int minutos(){
        int minutos = 0;
        minutos = hora*60 + minuto;
        return data.minutos() + minutos;
    }
}
