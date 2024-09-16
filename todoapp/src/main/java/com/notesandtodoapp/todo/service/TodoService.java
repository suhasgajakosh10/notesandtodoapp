package com.notesandtodoapp.todo.service;

import com.notesandtodoapp.todo.data.TODO;

import java.util.List;
import java.util.Optional;

public interface TodoService {

    TODO createTodo(TODO todo);

    Optional<TODO> getTodoById(Long id);

    Optional<TODO> updateTodoById(Long id, TODO todo);

    boolean deleteTodoById(Long id);

    List<TODO> getAllTodos();
}
