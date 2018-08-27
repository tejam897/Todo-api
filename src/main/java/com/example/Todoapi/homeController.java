package com.example.Todoapi;

import com.example.entities.TodoEntity;
import com.example.entities.TodoRepository;
import com.example.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class homeController {
    @Autowired
    private TodoService todoService;

    @RequestMapping(value = {"/","/allTodos"}, method = RequestMethod.GET)
    @ResponseBody
    public List<TodoEntity> showAllTodos(){
        return todoService.getAllTodos();
    }
}
