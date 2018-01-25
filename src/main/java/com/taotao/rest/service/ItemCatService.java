package com.taotao.rest.service;

import com.taotao.rest.pojo.CatResult;

/**
 * 商品分类接口
* <p>Title: ItemCatService</p>  
* <p>Description: </p>  
* @author 唯  
* @date 2018-1-6
 */
public interface ItemCatService {

	/**
	 * 获得所以分类
	 * <p>Title: getItemCatList</p>  
	 * <p>Description: </p>  
	 * @return
	 */
	CatResult getItemCatList();
}
