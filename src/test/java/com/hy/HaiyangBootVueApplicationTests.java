package com.hy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.junit4.SpringRunner;

import com.hy.service.ActivityService;
import com.hy.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HaiyangBootVueApplicationTests {

	
	
	@Autowired
	UserService userService;
	
	@Autowired
	ActivityService activityService;
	
	@Test
	public void test1() {
		Object userById = userService.getUserById(1l);
		System.out.println(userById);
		
		Object activityById = activityService.getActivityById(2l);
		System.out.println(activityById);
		
	}

}
