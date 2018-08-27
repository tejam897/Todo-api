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
        TodoEntity todo = new TodoEntity();
        todo.setTitle("first todo");
        todo.setDesc("hard coding");
        todoRepository.save(todo);
       return todoRepository.findAll();
    }
}
