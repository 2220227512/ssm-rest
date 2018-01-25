package com.taotao.rest.service;

import com.taotao.common.pojo.TaotaoResult;

/**
 * 商品做redis缓存服务Service接口
* <p>Title: ItemService</p>  
* <p>Description: </p>  
* @author 唯  
* @date 2018-1-15
 */
public interface ItemService {
	
	/**
	 * 根据商品id调用商品信息
	 * 加入缓存
	 * 设置有效期
	 * <p>Title: getItemBaseInfo</p>  
	 * <p>Description: </p>  
	 * @param itemId
	 * @return
	 */
	TaotaoResult getItemBaseInfo(long itemId);
	/**
	 * 根据商品id查询商品描述
	 * 加入缓存
	 * <p>Title: getItemDesc</p>  
	 * <p>Description: </p>  
	 * @param itemId
	 * @return
	 */
	TaotaoResult getItemDesc(long itemId);
	/**
	 * 根据商品id查询商品规格参数
	 * 加入缓存
	 * <p>Title: getItemParam</p>  
	 * <p>Description: </p>  
	 * @param itemId
	 * @return
	 */
	TaotaoResult getItemParam(long itemId);

}
