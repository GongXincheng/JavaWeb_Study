package com.gxc.solrj;

import java.util.List;
import java.util.Map;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.junit.Test;

public class Test1 {

	@Test
	public void testSearch2() throws Exception {
		String baseURL = "http://localhost:8080/solr";
		SolrServer solrServer = new HttpSolrServer(baseURL);
		
		SolrQuery solrQuery = new SolrQuery();
		solrQuery.set("q", "台灯");
		solrQuery.set("fq", "product_catalog_name:幽默杂货");
		solrQuery.set("fq", "product_price:[* TO 10]");
		solrQuery.addSort("product_price", ORDER.desc);
		solrQuery.setStart(0);
		solrQuery.setRows(5);
		solrQuery.set("fl", "id,product_name");
		solrQuery.set("df", "product_name");
		
		//设置高亮
		solrQuery.setHighlight(true);
		solrQuery.addHighlightField("product_name");
		solrQuery.setHighlightSimplePre("<span style='color:red'>");
		solrQuery.setHighlightSimplePre("</span>");
		
		QueryResponse response = solrServer.query(solrQuery);
		
		Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();
		
		SolrDocumentList docs = response.getResults();
		long numFound = docs.getNumFound();
		System.out.println(numFound);
		
		for (SolrDocument doc : docs) {
			System.out.println(doc.get("product_catalog_name"));
			System.out.println(doc.get("product_name"));
			System.out.println(doc.get("id"));
			System.out.println("-------------------------------------");
			
			Map<String, List<String>> map = highlighting.get(doc.get("id"));
			List<String> list = map.get("product_name");
			System.out.println(list);
			System.out.println("-------------------------------------");
		}
		
	}
	
}
