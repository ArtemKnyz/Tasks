package com.arty.togetapp.controllers;

import com.arty.togetapp.model.TodoItem;
import com.arty.togetapp.repositories.TodoItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class TodoControllers implements CommandLineRunner {

    private final TodoItemRepository todoItemRepository;

    public TodoControllers(TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    @GetMapping
    public String index(@RequestParam(required = false) LocalDate filterDate, Model model) {
        List<TodoItem> allTodos;

        if (filterDate != null) {
            allTodos = todoItemRepository.findByDate(filterDate);
        } else {
            allTodos = todoItemRepository.findAll();
        }

        model.addAttribute("allTodo", allTodos);
        model.addAttribute("newTodo", TodoItem.builder()
                .date(filterDate != null ? filterDate : LocalDate.now())
                .build());
        model.addAttribute("currentDate", filterDate);

        return "index";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute TodoItem todoItem) {
        todoItemRepository.save(todoItem);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long id) {
        if (id != null && todoItemRepository.existsById(id)) {
            todoItemRepository.deleteById(id);
        }
        return "redirect:/";
    }


    @Override
    public void run(String... args) throws Exception {
        todoItemRepository.save(TodoItem.builder().title("Написать письмо контрагенту").build());
        todoItemRepository.save(TodoItem.builder().title("Составить проект протокола совещания").build());
        todoItemRepository.save(TodoItem.builder().title("Оформить командировку").build());
    }
}
