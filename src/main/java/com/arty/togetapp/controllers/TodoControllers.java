package com.arty.togetapp.controllers;


import com.arty.togetapp.model.TodoItem;
import com.arty.togetapp.repositories.TodoItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TodoControllers implements CommandLineRunner {

    private final TodoItemRepository todoItemRepository;

    public TodoControllers(TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    @GetMapping
    public String index(Model model) {


        //model.addAttribute("data", "Hello");

        List<TodoItem> allTodos = todoItemRepository.findAll();

        model.addAttribute("allTodo", allTodos);
        model.addAttribute("newTodo", new TodoItem());
        return "index";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute TodoItem todoItem) {
        todoItemRepository.save(todoItem);
        return "redirect:/";
    }


    @Override
    public void run(String... args) throws Exception {
        todoItemRepository.save(new TodoItem("Item test 1"));
        todoItemRepository.save(new TodoItem("Item test 2"));
    }
}
