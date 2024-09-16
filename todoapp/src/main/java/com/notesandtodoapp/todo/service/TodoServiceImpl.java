package com.notesandtodoapp.todo.service;

import com.notesandtodoapp.todo.data.TODO;
import com.notesandtodoapp.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TodoServiceImpl implements  TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public TODO createTodo(TODO todo) {
        return todoRepository.save(todo);
    }

    @Override
    public Optional<TODO> getTodoById(Long id) {
        return todoRepository.findById(id);
    }

    @Override
    public Optional<TODO> updateTodoById(Long id, TODO todo) {
        return todoRepository.findById(id).map(existingTodo -> {
            existingTodo.setName(todo.getName());
            existingTodo.setTasks(todo.getTasks());
            return todoRepository.save(existingTodo);
        });
    }

    @Override
    public boolean deleteTodoById(Long id) {
        if (todoRepository.existsById(id)) {
            todoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<TODO> getAllTodos() {
        return todoRepository.findAll();
    }
}
