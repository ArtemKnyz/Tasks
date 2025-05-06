package com.arty.togetapp.repositories;

import com.arty.togetapp.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
    List<TodoItem> findByDate(LocalDate date);
    
}



