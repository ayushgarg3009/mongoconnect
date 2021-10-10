package com.example.mongoconnect;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class TodoController {

    @Autowired(required = false)
    public TodoRepository todoRepo;

//    @Autowired
//    public MongoTemplate mongoTemplate;

    @GetMapping("/hello")
    public String first(){
        System.out.println("hello");
        return "Just for Test !!";
    }

    @PostMapping("/addtodos")
    public String savetodo(@RequestBody TodoDTO todo){
        todoRepo.save(todo);
        //mongoTemplate.save(todo);
        return "Added todo by id"+todo.getId();
    }

    @GetMapping("/todos")
    public ResponseEntity<?> getAllTodos(){
        List<TodoDTO> todos = todoRepo.findAll();
        if(todos.size()>0){
            return new ResponseEntity<List<TodoDTO>>(todos, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No todos", HttpStatus.NOT_FOUND);
        }
    }
}
