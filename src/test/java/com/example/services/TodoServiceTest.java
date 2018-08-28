package com.example.services;

import com.example.entities.TodoEntity;
import com.example.entities.TodoRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class TodoServiceTest {

    @Autowired
    TodoService todoService;

    @MockBean
    TodoRepository todoRepository;

    @Before
    public void setUp() throws Exception {
        TodoEntity todo = new TodoEntity();
        todo.setTitle("testing");
        Mockito.when(todoRepository.findAll()).thenReturn(Arrays.asList(todo));
    }

    @Test
    public void shouldReturnAllTodos() {
        List<TodoEntity> todos = todoService.getAllTodos();
        assertEquals(todos.size(),1);
    }
}