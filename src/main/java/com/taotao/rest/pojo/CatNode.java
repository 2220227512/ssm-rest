package com.taotao.rest.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * 商品分类节点
* <p>Title: CatNode</p>  
* <p>Description: </p>  
* @author 唯  
* @date 2018-1-6
 */
public class CatNode {
	@JsonProperty("n")
	private String  name;
	@JsonProperty("u")
	private String  url;
	@JsonProperty("i")
	private List<?> item;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<?> getItem() {
		return item;
	}
	public void setItem(List<?> item) {
		this.item = item;
	}
	

}
