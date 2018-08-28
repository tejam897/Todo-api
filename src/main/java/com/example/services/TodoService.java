package com.example.services;

import com.example.entities.TodoEntity;
import com.example.entities.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    TodoRepository todoRepository;

    public List<TodoEntity> getAllTodos(){
       return todoRepository.findAll();
    }
}
