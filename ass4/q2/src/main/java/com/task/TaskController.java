package com.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private TaskService service;

    @PostMapping
    public Task create(@RequestBody Task task) { return service.add(task); }

    @GetMapping
    public List<Task> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public Task getOne(@PathVariable int id) { return service.get(id); }

    @GetMapping("/category/{category}")
    public List<Task> byCategory(@PathVariable String category) {
        return service.byCategory(category);
    }

    @PutMapping("/{id}")
    public Task update(@PathVariable int id, @RequestBody Task task) {
        return service.update(id, task);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        return service.delete(id) ? "Deleted" : "Not found";
    }
}
