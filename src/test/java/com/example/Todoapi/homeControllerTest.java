package com.example.Todoapi;

import com.example.entities.TodoEntity;
import com.example.services.TodoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class homeControllerTest {

    @MockBean
    TodoService todoService;

    @Autowired
    private MockMvc mvc;

    TodoEntity todoEntity;

    @Before
    public void setUp() throws Exception {
        todoEntity = new TodoEntity();
        given(todoService.getAllTodos()).willReturn(Arrays.asList(todoEntity));
    }

    @Test
    public void shouldReturnAllTodos() throws Exception {
        mvc.perform(get("/api/allTodos"))
                .andExpect(jsonPath("$",hasSize(1)))
                .andExpect(jsonPath("$[0].title",is(todoEntity.getTitle())))
                .andExpect(jsonPath("$[0].description",is(todoEntity.getDescription())))
                .andExpect(status().isOk());
    }
}