package com.altierre.lista_de_tarefas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // Criação da tabela no banco de dados
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Para gerar uma chave automaticamente
    private Long id;

    private String description;

    private boolean completed;

    public Task() {
    }

    public Task(String description) {
        this.description = description;
        this.completed = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
