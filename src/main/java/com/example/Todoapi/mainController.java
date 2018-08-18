package com.example.Todoapi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class mainController {
@RequestMapping(value = "/", method = RequestMethod.GET)
   public String showAllTodos(){
        return "allTodos";
   }
}
