package org.ram.controller;

import java.util.List;

import org.ram.model.Todo;

import org.ram.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

	 @Autowired
	    private TodoService todoService;

	    @GetMapping("/getTodoById/{id}")
	    public Todo getTodoById(@PathVariable int id) {
	        return todoService.getTodoById(id);
	    }

		@GetMapping("/getAllTodos")
	    public List<Todo> getAllTodos() {
	        return todoService.getAllTodos();
	    }

		@PostMapping("/createTodo")
	    public void createTodo(@RequestBody Todo todo) {
	        todoService.createTodo(todo);
	    }

	    @PutMapping("/updateTodo")
	    public void updateTodo(@RequestBody Todo todo) {
	        todoService.updateTodo(todo);
	    }

	    @DeleteMapping("/deleteTodoById/{id}")
	    public void deleteTodoById(@PathVariable int id) {
	        todoService.deleteTodoById(id);
	    }

}
