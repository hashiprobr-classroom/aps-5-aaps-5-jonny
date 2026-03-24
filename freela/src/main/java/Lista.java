import java.util.ArrayList;
import java.util.List;

public class Lista {
    private List<Tarefa> tarefas;

    public Lista(){
        this.tarefas = new ArrayList<>();
    }

    public List<Tarefa> getTarefas(){
        return tarefas;
    }
    public void adiciona(Tarefa tarefa){
            for (Tarefa t : tarefas){
                if (t.getId() == tarefa.getId()){
                    return;
                }
            }
            tarefas.add(tarefa);
    }
}

