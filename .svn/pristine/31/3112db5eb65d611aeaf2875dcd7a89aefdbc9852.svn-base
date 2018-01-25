package com.taotao.rest.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.JsonUtils;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.po.TbItem;
import com.taotao.po.TbItemDesc;
import com.taotao.po.TbItemDescExample;
import com.taotao.po.TbItemParamItem;
import com.taotao.po.TbItemParamItemExample;
import com.taotao.rest.dao.JedisClient;
import com.taotao.rest.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	//注入redis对象
	@Autowired
	private JedisClient jedisClient;
	
	@Autowired
	private TbItemMapper itemMapper;
	@Autowired TbItemDescMapper itemDescMapper;
	@Autowired
	private TbItemParamItemMapper itemParamItemMapper;
	
	//商品加入缓存key
	@Value("${REDIS_ITEM_KEY}")
	private String  REDIS_ITEM_KEY;
	
	//商品在缓存中有效时间1天
	@Value("${REDIS_ITEM_EXPIRE}")
	private Integer REDIS_ITEM_EXPIRE;

	
	@Override
	public TaotaoResult getItemBaseInfo(long itemId) {
	
		//缓存逻辑
		// 查询缓存是否存在
		try {
			String string = jedisClient.get(REDIS_ITEM_KEY + ":" + itemId
					+ ":base");
			if (!StringUtils.isBlank(string)) {
				TbItem item = JsonUtils.jsonToPojo(string, TbItem.class);
				return TaotaoResult.ok(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		TbItem item = itemMapper.selectByPrimaryKey(itemId);

		// 缓存逻辑
		// 加入到缓存
		try {
			jedisClient.set(REDIS_ITEM_KEY + ":" + itemId + ":base",
					JsonUtils.objectToJson(item));
			// 设置key的有效期
			jedisClient.expire(REDIS_ITEM_KEY + ":" + itemId + ":base",
					REDIS_ITEM_EXPIRE);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return TaotaoResult.ok(item);
	}


	@Override
	public TaotaoResult getItemDesc(long itemId) {
		//缓存逻辑
				// 查询缓存是否存在
				try {
					String string = jedisClient.get(REDIS_ITEM_KEY + ":" + itemId
							+ ":desc");
					if (!StringUtils.isBlank(string)) {
						TbItemDesc itemdesc = JsonUtils.jsonToPojo(string, TbItemDesc.class);
						return TaotaoResult.ok(itemdesc);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
		
		TbItemDesc itemdesc = itemDescMapper.selectByPrimaryKey(itemId);
		
		// 缓存逻辑
				// 加入到缓存
				try {
					jedisClient.set(REDIS_ITEM_KEY + ":" + itemId + ":desc",
							JsonUtils.objectToJson(itemdesc));
					// 设置key的有效期
					jedisClient.expire(REDIS_ITEM_KEY + ":" + itemId + ":desc",
							REDIS_ITEM_EXPIRE);

				} catch (Exception e) {
					e.printStackTrace();
				}
		return TaotaoResult.ok(itemdesc);
	}


	@Override
	public TaotaoResult getItemParam(long itemId) {
		//缓存逻辑
		// 查询缓存是否存在
		try {
			String string = jedisClient.get(REDIS_ITEM_KEY + ":" + itemId
					+ ":param");
			if (!StringUtils.isBlank(string)) {
				TbItemParamItem itemparam = JsonUtils.jsonToPojo(string, TbItemParamItem.class);
				return TaotaoResult.ok(itemparam);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		TbItemParamItemExample example = new TbItemParamItemExample();
		TbItemParamItemExample.Criteria criteria = example.createCriteria();
		criteria.andItemIdEqualTo(itemId);
		List<TbItemParamItem> lists = itemParamItemMapper.selectByExampleWithBLOBs(example);
		if(lists!=null&&lists.size()>0){
			TbItemParamItem itemparam =lists.get(0);
			try {
				jedisClient.set(REDIS_ITEM_KEY + ":" + itemId + ":param",
						JsonUtils.objectToJson(itemparam));
				// 设置key的有效期
				jedisClient.expire(REDIS_ITEM_KEY + ":" + itemId + ":param",
						REDIS_ITEM_EXPIRE);

			} catch (Exception e) {
				e.printStackTrace();
			}
			return TaotaoResult.ok(itemparam);
			
		}

		
	
		return TaotaoResult.build(400, "该商品没规格参数");
	}

}
