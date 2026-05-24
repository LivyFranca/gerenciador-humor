package model;
import java.time.LocalDate;
import java.util.ArrayList;

public class Dia {
    private LocalDate data;
    private Humor humor;
    private ArrayList<Tarefa> tarefas;

    // Construtor
    public Dia(LocalDate data, Humor humor) {
        this.data = data;
        this.humor = humor;
        this.tarefas = new ArrayList<>();
    }


    public void adicionarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
    }


    public void removerTarefa(Tarefa tarefa) {
        tarefas.remove(tarefa);
    }

    // Verifica se todas as tarefas foram concluídas
    public boolean todasConcluidas() {
        if (tarefas.isEmpty()) {
            return false;
        }

        for (Tarefa tarefa : tarefas) {
            if (!tarefa.isConcluida()) {
                return false;
            }
        }

        return true;
    }


    public double calcularProdutividade() {
        if (tarefas.isEmpty()) {
            return 0;
        }

        int concluidas = 0;

        for (Tarefa tarefa : tarefas) {
            if (tarefa.isConcluida()) {
                concluidas++;
            }
        }

        return (double) concluidas / tarefas.size() * 100;
    }

    // Getters
    public LocalDate getData() {
        return data;
    }

    public Humor getHumor() {
        return humor;
    }

    public ArrayList<Tarefa> getTarefas() {
        return tarefas;
    }

    // Setters
    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setHumor(Humor humor) {
        this.humor = humor;
    }

    public void setTarefas(ArrayList<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    // Exibição
    @Override
    public String toString() {
        return "Dia{" +
                "data=" + data +
                ", humor=" + humor +
                ", tarefas=" + tarefas +
                ", produtividade=" + calcularProdutividade() + "%" +
                '}';
    }
}
