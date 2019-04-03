package com.ui.SpringUIdemo;

import com.ui.SpringUIdemo.entity.Task;
import com.ui.SpringUIdemo.entity.User;
import com.ui.SpringUIdemo.service.TaskService;
import com.ui.SpringUIdemo.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringUIdemoApplicationTests {

	@Autowired
	private UserService userService;

	@Autowired
	private TaskService taskService;

	@Before
	public void initDB(){
		{
			User newUser = new User("Tuser@gmail.com","testUser","123456");
			userService.createUser(newUser);
		}
		{
			User newUser = new User("Tadmin@gmail.com","testAdmin","123456");
			userService.createUser(newUser);
		}
		Task userTask = new Task("03/01/2019","00:11","11:00","WORK");
		User user = userService.findOne("Tuser@gmail.com");
		taskService.addTask(userTask,user);

	}

	@Test
	public void testUser() {
		User user = userService.findOne("Tuser@gmail.com");
		assertNotNull(user);
		User admin = userService.findOne("Tadmin@gmail.com");
		assertEquals(admin.getEmail(),"Tadmin@gmail.com");
	}

	@Test
	public void testTask() {
		User user = userService.findOne("Tuser@gmail.com");
		List<Task> task = taskService.findUserTask(user);
		assertNotNull(task);

	}

}
