package edu.ci.TaskService.services;

import edu.ci.TaskService.data.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Service

public class TaskServiceHashMap implements TaskService {
    private final HashMap<String,Task> tasks = new HashMap();
    @Override
    public Task create(Task task) {
        tasks.put(task.getId(),task);
        return task;
    }

    @Override
    public Task findById(String id) {
        if(tasks.containsKey(id)){
            return tasks.get(id);
        }
        return null;
    }

    @Override
    public List<Task> all() {
        List<Task>list = new ArrayList();
        for(Task task: tasks.values()){
            list.add(task);
        }
        return list;
    }

    @Override
    public Boolean deleteById(String id) {
        return tasks.remove(id,tasks.get(id));
    }

    @Override
    public Task update(Task task, String taskId) {
        tasks.put(taskId,task);
        return task;
    }
}
