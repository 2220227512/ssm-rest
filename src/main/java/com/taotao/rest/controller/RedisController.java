package com.taotao.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.rest.service.RedisService;

/**
 * redis 调用入口
* <p>Title: RedisController</p>  
* <p>Description: </p>  
* @author 唯  
* @date 2018-1-12
 */
@Controller
@RequestMapping("/cache/sync")
public class RedisController {

	@Autowired
	private RedisService redisService;
	
	@RequestMapping("/content/{contentCid}")
	public TaotaoResult contentCacheSync(@PathVariable Long contentCid) {
		TaotaoResult result = redisService.syncContent(contentCid);
		return result;
	}
	
	/*@RequestMapping("/hget")
	public TaotaoResult hget() {
		TaotaoResult result = redisService.syncContent(contentCid);
		return result;
	}
	@RequestMapping("/hset")
	public TaotaoResult hset() {
		TaotaoResult result = redisService.syncContent(contentCid);
		return result;
	}
	*/
}


