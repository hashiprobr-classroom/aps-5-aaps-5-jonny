package br.edu.insper.desagil.pi.freela;

public class Tarefa {
    private int id;
    private String descricao;
    private Momento inicio;
    private Momento fim;

    public int getId(){
        return id;
    }
    public String getDescricao(){
        return descricao;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    public Momento getInicio(){
        return inicio;
    }
    public Momento getFim(){
        return fim;
    }

    public Tarefa(int id){
        this.id = id;
        this.descricao = "";
        this.inicio = null;
        this.fim = null;
    }

    public void atualiza(Momento momento0, Momento momento1){
        if (momento0.minutos() > momento1.minutos()){
            throw new IllegalArgumentException("Data invertida");
        }
        inicio = momento0;
        fim = momento1;
    }
}
