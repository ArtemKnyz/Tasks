package com.arty.togetapp.repositories;

import com.arty.togetapp.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoItemRepository extends JpaRepository <TodoItem, Long>{


}
