package com.jwt.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.task.service.TaskService;

@SpringBootTest
class JWtSecurityApplicationTests {

	
	@Autowired
	private TaskService taskService;
	@Test
	void contextLoads() {
	}

}
