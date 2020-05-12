package com.hy.service;

import com.hy.annotation.Sql;

/**  
* UserService
* Creater by chenhaiyang on 2020年5月11日
*/
public interface UserService {
	
	@Sql("select * from user where id=?")
	Object getUserById(Long id);

}
