package com.hy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.hy.service.db.ActivityService;
import com.hy.service.db.UserService;
import com.hy.service.http.StoreHttpService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HaiyangBootVueApplicationTests {

	
	
	@Autowired
	UserService userService;
	
	@Autowired
	ActivityService activityService;
	
	@Autowired
	StoreHttpService storeHttpService;
	
	@Test
	public void test1() {
		Object storeById = storeHttpService.getStoreById();
		System.out.println(storeById);
		
		Object userById = userService.getUserById(1l);
		System.out.println(userById);
		
		Object activityById = activityService.getActivityById(2l);
		System.out.println(activityById);
	}

}
