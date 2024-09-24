package com.task.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	


}
