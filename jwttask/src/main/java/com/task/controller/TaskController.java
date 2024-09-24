package com.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.task.dto.MessageDto;
import com.task.exception.InvalidIdException;
import com.task.model.Task;
import com.task.service.TaskService;

@RestController
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	//Add a new task
	@PostMapping("/task/add")
	public ResponseEntity<?> addTask (@RequestBody Task task, MessageDto messageDto) {
        try {
            Task savedTask = taskService.addTask(task);
            return ResponseEntity.ok(savedTask);
        } catch (Exception e) {
            messageDto.setMsg(e.getMessage());
            return ResponseEntity.badRequest().body(messageDto);
        }
    }

	
	//Retrieve all tasks
	@GetMapping("/task/getallTasks")
	public List<Task> getAllTasks() {
	    return taskService.getAllTasks();
	}

	//Retrieve a single task by its ID
	@GetMapping("/task/find/{id}")
	public ResponseEntity<?> getTaskById(@PathVariable int id, MessageDto messagedto) {
	    try {
	        Task task = taskService.getTaskById(id);
	        return ResponseEntity.ok(task);
	    } catch (InvalidIdException e) {
	        messagedto.setMsg(e.getMessage());
	        return ResponseEntity.badRequest().body(messagedto);
	    }
	}
	
	//Delete a task by its ID
	@DeleteMapping("/task/delete/{id}")
	public ResponseEntity<?> deleteTask(@PathVariable int id, MessageDto messagedto) {
	    try {
	        taskService.deleteTask(id);
	        messagedto.setMsg("Task Deleted Successfully.");
	        return ResponseEntity.ok(messagedto);
	    } catch (InvalidIdException e) {
	        messagedto.setMsg(e.getMessage());
	        return ResponseEntity.badRequest().body(messagedto);
	    }
	}

	//Update an existing task
	@PutMapping("/task/update/{taskId}")
    public ResponseEntity<?> updateTask(
            @PathVariable int taskId,
            @RequestBody Task newTask,
            MessageDto messageDto) {
        try {
            Task updatedTask = taskService.updateTask(taskId, newTask);
            return ResponseEntity.ok(updatedTask);
        } catch (InvalidIdException e) {
            messageDto.setMsg(e.getMessage());

            // Return a bad request with the error message
            return ResponseEntity.badRequest().body(messageDto);
        
    }
	}
}
