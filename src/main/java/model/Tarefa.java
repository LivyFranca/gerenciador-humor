package model;

import java.time.LocalDate;

public class Tarefa{
    private String descricao;
    private LocalDate data;
    Humor humorAtual;
    private boolean concluida;



    public Tarefa(String descricao, LocalDate data, Humor humorAtual) {
        this.descricao = descricao;
        this.data = data;
        this.humorAtual = humorAtual;
        this.concluida = false; // forçamos o atributo a começar sempre desabilitado
    }

    // Métodos
    public void concluir() {
        this.concluida = true;
    }

    public void desconcluir() {
        this.concluida = false;
    }

    // Getters
    public String getDescricao() {
        return descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public Humor getHumorAtual() {
        return humorAtual;
    }

    public LocalDate getData() {
        return data;
    }

    // Setters
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setHumorAtual(Humor humorAtual) {
        this.humorAtual = humorAtual;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    @Override
    public String toString() {
        return "📝 " + descricao +
                "\nStatus: " + (concluida ? "✔ Concluída" : "❌ Pendente") +
                "\nHumor: " + humorAtual +
                "\n📅 Data: " + data;
    }
}