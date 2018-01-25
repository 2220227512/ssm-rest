package com.taotao.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.rest.pojo.CatResult;
import com.taotao.rest.service.ItemCatService;

@Controller
public class ItemCatController {
	@Autowired
	private ItemCatService itemCatService;
	
	@RequestMapping("/item/cat")
	@ResponseBody
	public Object getItemCatList(String callback){
		CatResult result =itemCatService.getItemCatList();
		MappingJacksonValue value=new MappingJacksonValue(result);
		value.setJsonpFunction(callback);
		
		return value;
	}

}
