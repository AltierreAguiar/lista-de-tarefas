package com.altierre.lista_de_tarefas.service;


import com.altierre.lista_de_tarefas.model.Task;
import com.altierre.lista_de_tarefas.repository.TaskRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private static TaskRepository taskRepository;

    public List<Task> listarTudo(){
        return taskRepository.findAll();
    }

    public static Task salvar(Task task){
        return taskRepository.save(task);
    }

    public void marcarComoConcluida(Long id){//O tratamento de exceções
        Task task= taskRepository.findById(id).orElseThrow();
        task.setCompleted(true);
        taskRepository.save(task);
    }

    public void deletar(Long id){
        taskRepository.deleteById(id);
    }


}
