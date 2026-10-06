package com.task;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class TaskService {
    private Map<Integer, Task> tasks = new HashMap<>();
    private int nextId = 1;

    public Task add(Task task) {
        task.setId(nextId++);
        tasks.put(task.getId(), task);
        return task;
    }

    public List<Task> getAll() {
        return new ArrayList<>(tasks.values());
    }

    public Task get(int id) { return tasks.get(id); }

    public List<Task> byCategory(String category) {
        List<Task> result = new ArrayList<>();
        for (Task t : tasks.values()) {
            if (t.getCategory().equalsIgnoreCase(category)) result.add(t);
        }
        return result;
    }

    public Task update(int id, Task u) {
        Task e = tasks.get(id);
        if (e != null) {
            e.setTitle(u.getTitle());
            e.setCategory(u.getCategory());
            e.setDueDate(u.getDueDate());
            e.setCompleted(u.isCompleted());
        }
        return e;
    }

    public boolean delete(int id) {
        return tasks.remove(id) != null;
    }
}
