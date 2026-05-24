package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import model.*;

import java.time.LocalDate;

public class MainController {

    @FXML
    private TextField txtDescricao;

    @FXML
    private ListView<Tarefa> listTarefas;

    @FXML
    private TextArea output;

    // lista interna
    private ObservableList<Tarefa> tarefasObs =
            FXCollections.observableArrayList();

    // estado
    private Humor humorAtual = Humor.NEUTRO;
    private Dia diaAtual = new Dia(LocalDate.now(), humorAtual);

    @FXML
    private void initialize() {

        listTarefas.setItems(tarefasObs);

        // marcar/desmarcar
        listTarefas.setOnMouseClicked(event -> {
            Tarefa t = listTarefas.getSelectionModel().getSelectedItem();

            if (t != null) {
                t.setConcluida(!t.isConcluida());
                listTarefas.refresh();
            }
        });

        // visual da lista
        listTarefas.setCellFactory(param -> new javafx.scene.control.ListCell<>() {
            @Override
            protected void updateItem(Tarefa item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setText(null);
                } else {
                    setText((item.isConcluida() ? "✔ " : "❌ ") + item.getDescricao());
                }
            }
        });
    }

    // tarefa
    @FXML
    private void adicionarTarefa() {

        String desc = txtDescricao.getText();

        if (desc == null || desc.isBlank()) return;

        Tarefa tarefa = new Tarefa(desc, LocalDate.now(), humorAtual);

        diaAtual.adicionarTarefa(tarefa);
        tarefasObs.add(tarefa);

        txtDescricao.clear();
    }

    // humor
    @FXML
    private void setFeliz() {
        humorAtual = Humor.FELIZ;
        diaAtual.setHumor(humorAtual);
    }

    @FXML
    private void setNeutro() {
        humorAtual = Humor.NEUTRO;
        diaAtual.setHumor(humorAtual);
    }

    @FXML
    private void setTriste() {
        humorAtual = Humor.TRISTE;
        diaAtual.setHumor(humorAtual);
    }

    // resumo
    @FXML
    private void finalizarDia() {

        output.clear();

        output.appendText("=== RESUMO DO DIA ===\n\n");
        output.appendText("Data: " + diaAtual.getData() + "\n");
        output.appendText("Humor: " + diaAtual.getHumor() + "\n");
        output.appendText("Produtividade: " + diaAtual.calcularProdutividade() + "%\n\n");


        // contador de tarefas concluídas
        int concluidas = 0;

        for (Tarefa t : diaAtual.getTarefas()) {
            if (t.isConcluida()) {
                concluidas++;
            }
        }

        output.appendText("Tarefas concluídas: "
                + concluidas + "/" + diaAtual.getTarefas().size() + "\n\n");

        output.appendText("Tarefas:\n");

        for (Tarefa t : diaAtual.getTarefas()) {
            output.appendText((t.isConcluida() ? "✔ " : "❌ ")
                    + t.getDescricao() + "\n");
        }
    }
}