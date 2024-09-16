package com.notesandtodoapp.todo.controller;

import com.notesandtodoapp.todo.data.TODO;
import com.notesandtodoapp.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    // POST /todos: Create a new TODO
    @PostMapping
    public ResponseEntity<TODO> createTodo(@RequestBody TODO todo) {
        TODO createdTodo = todoService.createTodo(todo);
        return new ResponseEntity<>(createdTodo, HttpStatus.CREATED);
    }

    // GET /todos/{id}: Get TODO by ID
    @GetMapping("/{id}")
    public ResponseEntity<TODO> getTodoById(@PathVariable Long id) {
        Optional<TODO> todo = todoService.getTodoById(id);
        return todo.map(t -> new ResponseEntity<>(t, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // PUT /todos/{id}: Update TODO by ID
    @PutMapping("/{id}")
    public ResponseEntity<TODO> updateTodoById(@PathVariable Long id, @RequestBody TODO todo) {
        Optional<TODO> updatedTodo = todoService.updateTodoById(id, todo);
        return updatedTodo.map(t -> new ResponseEntity<>(t, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // DELETE /todos/{id}: Delete TODO by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodoById(@PathVariable Long id) {
        boolean isDeleted = todoService.deleteTodoById(id);
        return isDeleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // GET /todos: Get all TODO lists
    @GetMapping
    public ResponseEntity<List<TODO>> getAllTodos() {
        List<TODO> todos = todoService.getAllTodos();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }
}
