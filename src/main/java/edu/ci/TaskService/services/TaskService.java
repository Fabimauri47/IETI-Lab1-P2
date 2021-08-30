package edu.ci.TaskService.services;

import edu.ci.TaskService.data.Task;

import java.util.List;

public interface TaskService
{
    Task create(Task task );

    Task findById( String id );

    List<Task> all();

    Boolean deleteById( String id );

    Task update( Task task, String id );
}