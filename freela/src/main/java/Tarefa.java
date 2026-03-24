public class Tarefa {
    private int id;
    private String descricao;
    private Momento inicio;
    private Momento fim;

    public Tarefa(int id){
        this.id = id;
        this.descricao = "";
        this.inicio = null;
        this.fim = null;
    }

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



    public void atualiza(Momento momento1, Momento momento2){
        if (momento1.minutos() >= momento2.minutos()) {
            throw new IllegalArgumentException("O início deve ser antes do fim.");
        }
        this.inicio = momento1;
        this.fim = momento2;
    }
}
