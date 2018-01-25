package com.taotao.rest.service;

import com.taotao.common.pojo.TaotaoResult;

/**
 * redis service接口
* <p>Title: RedisService</p>  
* <p>Description: </p>  
* @author 唯  
* @date 2018-1-12
 */
public interface RedisService {

	TaotaoResult syncContent(long contentCid);
}
