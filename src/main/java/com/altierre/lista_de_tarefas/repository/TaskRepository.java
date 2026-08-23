package com.altierre.lista_de_tarefas.repository;

import com.altierre.lista_de_tarefas.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
