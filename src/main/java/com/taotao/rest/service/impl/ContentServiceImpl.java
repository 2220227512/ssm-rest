package com.taotao.rest.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taotao.common.utils.JsonUtils;
import com.taotao.mapper.TbContentMapper;
import com.taotao.po.TbContent;
import com.taotao.po.TbContentExample;
import com.taotao.rest.dao.JedisClient;
import com.taotao.rest.service.ContentService;
/**
 * 首页大广告展示服务
 */
@Service
public class ContentServiceImpl implements ContentService {

	@Value("${INDEX_CONTENT_REDIS_KEY}")
	private String INDEX_CONTENT_REDIS_KEY;
	@Autowired
	private TbContentMapper contentMapper;
	@Autowired
	private JedisClient jedisClient;
	@Override
	public List<TbContent> getContentList(long contentCid) {
		//查询缓存是否存在
		try {
			String result=jedisClient.hget(INDEX_CONTENT_REDIS_KEY, contentCid+"");
			System.out.println("查缓存"+result);
			if(!StringUtils.isBlank(result)){ //如果不是null  
				List<TbContent> list =JsonUtils.jsonToList(result, TbContent.class);
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		TbContentExample  example =new TbContentExample();
		TbContentExample.Criteria criteria=example.createCriteria();
		criteria.andCategoryIdEqualTo(contentCid);
		List<TbContent> list = contentMapper.selectByExample(example);
		//向缓存添加内容
		try {
			jedisClient.hset(INDEX_CONTENT_REDIS_KEY, contentCid+"", JsonUtils.objectToJson(list));
			System.out.println("加缓存");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("进入首页");
		return list;
	}

}
