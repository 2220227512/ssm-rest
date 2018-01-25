package com.taotao.rest.redis;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class TestSolr {
	
	@Test
	public void addDoucmend()throws Exception{
		SolrServer solrServer=new HttpSolrServer("http://192.168.190.128:8080/solr");
		SolrInputDocument document=new SolrInputDocument();
		document.addField("id", "test002");
		document.addField("item_title", "eclipse代码测试+修改");
		document.addField("item_price", 22222);
		
		solrServer.add(document);
		solrServer.commit();
		
	}

}
