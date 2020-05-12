package com.hy.service.http;

import com.hy.annotation.Url;

/**  
* StoreHttpService
* Creater by chenhaiyang on 2020年5月12日
*/
public interface StoreHttpService {

	@Url("store/getStoreById")
	Object getStoreById();
	
}
