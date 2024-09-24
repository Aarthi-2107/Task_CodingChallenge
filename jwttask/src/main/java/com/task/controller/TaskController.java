package com.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	public ResponseEntity<?> getTaskById(@PathVariable int id, MessageDto dto) {
	    try {
	        Task task = taskService.getTaskById(id);
	        return ResponseEntity.ok(task);
	    } catch (InvalidIdException e) {
	        dto.setMsg(e.getMessage());
	        return ResponseEntity.badRequest().body(dto);
	    }
	}
	

}
