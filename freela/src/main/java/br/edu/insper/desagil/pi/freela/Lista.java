package br.edu.insper.desagil.pi.freela;

import java.util.ArrayList;
import java.util.List;

public class Lista {
    private List<Tarefa> tarefas;

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public Lista(){
        this.tarefas = new ArrayList<>();
    }

    public void adiciona(Tarefa tarefa){
        for (int cont = 0 ; cont <= tarefas.size(); cont+=1){
            Tarefa x = tarefas.get(cont);
            if (x.getId() == tarefa.getId()){
                return;
            }
        }
        tarefas.add(tarefa);
    }
}
