package com.jwt.security;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.task.service.TaskService;

@SpringBootTest
public class TaskServiceTest {
	
	@Autowired
	private TaskService taskService;
	
	@Test
	public void getAllTasks() {
		int expectedNum=4;
		int actualNum=taskService.getAllTasks().size();
		assertEquals(expectedNum,actualNum);
		
	}
	
	

}
