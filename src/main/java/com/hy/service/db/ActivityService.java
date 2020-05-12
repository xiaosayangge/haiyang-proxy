package com.hy.service.db;

import com.hy.annotation.Sql;

/**  
* ActivityService
* Creater by chenhaiyang on 2020年5月12日
*/
public interface ActivityService {
	@Sql("select * from activity where id=2")
	Object	getActivityById(Long id);

}
