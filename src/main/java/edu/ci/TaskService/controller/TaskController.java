package edu.ci.TaskService.controller;

import edu.ci.TaskService.data.Task;
import edu.ci.TaskService.dto.TaskDto;
import edu.ci.TaskService.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/v1/task" )

public class TaskController {
    private final TaskService taskService;

    public TaskController(@Autowired TaskService taskService )
    {
        this.taskService = taskService;
    }


    @GetMapping
    public ResponseEntity<List<Task>> all()
    {
        return new ResponseEntity(taskService.all(), HttpStatus.OK;

    }

    @GetMapping( "/{id}" )
    public ResponseEntity<Task> findById(@PathVariable String id )
    {
        return new ResponseEntity(taskService.findById(id),HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Task> create(@RequestBody TaskDto userDto ) {
        return new ResponseEntity(taskService.create(new Task(userDto)), HttpStatus.OK);

    }


    @PutMapping( "/{id}" )
    public ResponseEntity<Task> update( @RequestBody TaskDto userDto, @PathVariable String id )
    {
        return new ResponseEntity(taskService.update(new Task(userDto,id),id),HttpStatus.OK);

    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Boolean> delete( @PathVariable String id )
    {
        return new ResponseEntity(taskService.deleteById(id),HttpStatus.OK);
    }
}
