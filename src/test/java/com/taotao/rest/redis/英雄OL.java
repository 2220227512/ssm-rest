package com.taotao.rest.redis;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.taotao.common.utils.HttpClientUtil;
import com.taotao.mapper.YxolMapper;
import com.taotao.po.Yxol;
import com.taotao.po.YxolExample;

public class 英雄OL {
	
	//全部使用
	@Test
	public void runAll() throws InterruptedException{
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
	    YxolMapper olmapper = applicationContext.getBean(YxolMapper.class);
	    YxolExample example=new YxolExample();
	    List<Yxol> lists = olmapper.selectByExample(example);
	    for (Yxol yxol : lists) {
			for(int i=0;i<yxol.getRuncount();i++){
				Thread.sleep(500);
				HttpClientUtil.doGet(yxol.getUrl());
				System.out.println(yxol.getName());
			}
		}
	    
	}
	//分段调用
	@Test
	public void  run(){
		//执行选区1/2/3/4 
		int ps=2;
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
	    YxolMapper olmapper = applicationContext.getBean(YxolMapper.class);
	    YxolExample example=new YxolExample();
	    List<Yxol> lists = olmapper.selectByExample(example);
	    
	    for(int i=0;i<lists.size();i++){
	    	
	    	 if(ps==1){
	 	    	if(i<21){
	 	    		for(int j=0;j<lists.get(i).getRuncount();j++){
	 	    			System.out.println(lists.get(i).getName());
	 	    			System.out.println(lists.get(i).getUrl());
	 	    			try {
	 	   				Thread.sleep(500);
	 	   			} catch (InterruptedException e) {
	 	   				// TODO Auto-generated catch block
	 	   				e.printStackTrace();
	 	   			}
		 	    		HttpClientUtil.doGet(lists.get(i).getUrl());
	 	    		}
	 	    		
	 	    	}
	 	    }else if(ps==2){
	 	    	if(i>20&&i<42){
	 	    		
	 	    		for(int j=0;j<lists.get(i).getRuncount();j++){
	 	    			try {
	 	   				Thread.sleep(500);
	 	   			} catch (InterruptedException e) {
	 	   				// TODO Auto-generated catch block
	 	   				e.printStackTrace();
	 	   			}
	 	    			System.out.println(lists.get(i).getName());
		 	    		HttpClientUtil.doGet(lists.get(i).getUrl());
	 	    		}
	 	    	}
	 	    }else if(ps==3){
	 	    	if(i>41&&i<63){
	 	    		for(int j=0;j<lists.get(i).getRuncount();j++){
	 	    			try {
	 	   				Thread.sleep(500);
	 	   			} catch (InterruptedException e) {
	 	   				// TODO Auto-generated catch block
	 	   				e.printStackTrace();
	 	   			}
	 	    			System.out.println(lists.get(i).getName());
		 	    		HttpClientUtil.doGet(lists.get(i).getUrl());
	 	    		}
	 	    	}
	 	    }else{
	 	    	if(i>62){
	 	    		for(int j=0;j<lists.get(i).getRuncount();j++){
	 	    			try {
	 	   				Thread.sleep(500);
	 	   			} catch (InterruptedException e) {
	 	   				// TODO Auto-generated catch block
	 	   				e.printStackTrace();
	 	   			}
	 	    			System.out.println(lists.get(i).getName());
		 	    		HttpClientUtil.doGet(lists.get(i).getUrl());
	 	    		}
	 	    	}
	 	    }
	    }
	   
	   
	}
	//插入数据
	@Test
	public void inster(){
		// 4
		String names ="刀戟声";
		String url="http://hero.i8wan.com/x00/g?k=kC8wJu24&p=1&aid=41&rn=17409&clm=1";
		int runcount=2;
		instert2(names, url, runcount);
	}


	public static void instert2(String names,String url,int runcount ){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
	    YxolMapper olmapper = applicationContext.getBean(YxolMapper.class);
	    String name="";
	    if(runcount==1){
	    	name =names+"	帮排签到";
	    }else if(runcount==2){
	    	 name=names+"	活跃领取";
	    }else{
	    	 name=names+"	收宝";
	    }
	  
	    Yxol ol=new Yxol();
	    ol.setName(name);
	    ol.setUrl(url);
	    ol.setRuncount(runcount);
	   olmapper.insert(ol);
		
	}
	
	

}
