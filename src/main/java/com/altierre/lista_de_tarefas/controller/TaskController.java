package com.altierre.lista_de_tarefas.controller;

import com.altierre.lista_de_tarefas.model.Task;
import com.altierre.lista_de_tarefas.repository.TaskRepository;
import com.altierre.lista_de_tarefas.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/tarefas")
    public String listar(Model model){
        model.addAttribute("Tarefas", taskService.listarTudo());
        return "tarefas";
    }

    @PostMapping("/tarefas/adicionar")
    public String adicionar(@RequestParam String description){
        TaskService.salvar(new Task(description));
        return "redirect:/tarefas";
    }

    @PostMapping ("/tarefas/concluir")
    public String concluir(@RequestParam Long id){
        taskService.marcarComoConcluida(id);
        return "redirect:/tarefas";
    }

    @PostMapping("/tarefas/deletar")
    public String deletar(@RequestParam long id){
        taskService.deletar(id);
        return "redirect:/tarefas";
    }
}
