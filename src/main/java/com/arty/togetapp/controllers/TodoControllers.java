package com.arty.togetapp.controllers;


import com.arty.togetapp.model.TodoItem;
import com.arty.togetapp.repositories.TodoItemRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodoControllers {

    private final TodoItemRepository todoItemRepository;

    public TodoControllers(TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    @GetMapping
    public String index (Model model){

        todoItemRepository.save(new TodoItem("Item 1"));
        todoItemRepository.save(new TodoItem("Item 2"));

        model.addAttribute("data", "Hello");
         return "index";
    }

}
