package com.task.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.exception.InvalidIdException;
import com.task.model.Task;
import com.task.repo.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	private Logger logger = LoggerFactory.getLogger(TaskService.class);
	
	//Add a new task
	public Task addTask(Task task) {
        logger.info("Adding task to DB: " + task);
        return taskRepository.save(task);
    }
    
    //Retrieve all tasks
	public List<Task> getAllTasks() {
        logger.info("Fetching all tasks from the DB...");
        return taskRepository.findAll();
    }
	
	//Retrive a task by its ID
	public Task getTaskById(int taskId) throws InvalidIdException {
        Optional<Task> optional = taskRepository.findById(taskId);
        if (optional.isEmpty()) {
            logger.error("Invalid Task ID found in request, Exception thrown.. ");
            throw new InvalidIdException("Invalid Task ID Given");
        }
        logger.info("Task object retrieved based on given ID: " + taskId);
        return optional.get();
    }
	


}
