package br.edu.insper.desagil.pi.freela;

import java.util.HashMap;
import java.util.Map;

public class Data extends Momento{
    private int ano;
    private int mes;
    private int dia;
    private Map<Integer, Integer> limite;

    public Data(){
        this.ano = 1970;
        this.mes = 1;
        this.dia = 1;
        Map<Integer, Integer> limite = new HashMap<>();
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
        this.limite = limite;
    }
    public int getAno(){
        return ano;
    }
    public int getMes(){
        return mes;
    }
    public int getDia(){
        return dia;
    }

    public void atualiza(int novoAno, int novoMes, int novoDia){
        if (novoAno < 1970 || novoAno > 2070){
            ano = ajusta(novoAno, 1970, 2070);
        }
        if (novoMes < 1 || novoMes > 12){
            mes = ajusta(novoMes, 1, 12);
        }
        if (novoDia < 1 || novoDia > limite.get(mes)){
            dia = ajusta(novoDia, 1, limite.get(mes));
        }
    }

    @Override
    public int minutos(){
        int anos = 0;
        int meses = mes;
        int dias = 0;
        int minutos = 0;

        anos = ano - 1970;
        dias = anos * 365;

        for (int contador = 1 ; contador<meses ; contador++){
            dias += limite.get(contador);
        }

        dias += dia -1;
        minutos = dias * 24 *  60;

        return minutos;
    }
}
