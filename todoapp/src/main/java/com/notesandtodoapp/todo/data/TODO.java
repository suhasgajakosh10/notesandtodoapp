package com.notesandtodoapp.todo.data;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "todos")
public class TODO {
    @Id
    private Long id;


    private String name;
    private List<String> tasks;


    public List<String> getTasks() {
        return tasks;
    }

    public void setTasks(List<String> tasks) {
        this.tasks = tasks;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}