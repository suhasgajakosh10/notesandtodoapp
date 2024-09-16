package com.notesandtodoapp.todo.repository;

import com.notesandtodoapp.todo.data.TODO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends MongoRepository<TODO, Long> {
}
