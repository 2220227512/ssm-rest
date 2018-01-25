package com.taotao.rest.redis;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.po.TbItemParamItem;
import com.taotao.po.TbItemParamItemExample;

public class Testitemparam {

	@Test
	public void run(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		  TbItemParamItemMapper itemParamItemMapper = applicationContext.getBean(TbItemParamItemMapper.class);
		
		TbItemParamItemExample example = new TbItemParamItemExample();
		TbItemParamItemExample.Criteria criteria = example.createCriteria();
		Long itemid=48l;
		criteria.andItemIdEqualTo(itemid);
		List<TbItemParamItem> lists = itemParamItemMapper.selectByExampleWithBLOBs(example);
		TbItemParamItem paramItem=lists.get(0);
		System.out.println(paramItem.getParamData());
	}
}
