package com.gxc.solrj;

import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

/**
 * SolrJ管理
 * 添加
 * 删除
 * 修改
 * 查询
 * @author 宫新程
 *
 */
public class SolrJManager {

	//添加
	@Test
	public void testAdd() throws Exception {
		String baseURL = "http://localhost:8080/solr";
		SolrServer solrServer = new HttpSolrServer(baseURL);
		
		//添加
		SolrInputDocument doc = new SolrInputDocument();
		doc.addField("id", "1502144");
		doc.addField("name", "gxc");
		solrServer.add(doc);
		
		//提交
		solrServer.commit();
	}
	
	//删除
	@Test
	public void testDelete() throws Exception {
		String baseURL = "http://localhost:8080/solr";
		SolrServer solrServer = new HttpSolrServer(baseURL);
		
		String query = "name:gxc";
		solrServer.deleteByQuery(query );
		
		solrServer.commit();
	}
	
	//更新
	@Test
	public void testUpdate() throws Exception {
		String baseURL = "http://localhost:8080/solr";
		SolrServer solrServer = new HttpSolrServer(baseURL);
		
		SolrInputDocument doc = new SolrInputDocument();
		doc.addField("id", "1502144");
		doc.addField("name", "cq");
		
		//只要id相同就是更新，id不同就是添加
		solrServer.add(doc);
		
		solrServer.commit();
	}
	
	
	//查询
	//	"product_picture": "2014032612461139.png",
	//  "product_catalog_name": "幽默杂货",
	//  "product_price": 18.9,
	//  "product_name": "幸福一家人彩色金属门后挂 8钩免钉门背挂钩2088",
	//  "id": "2",
	@Test
	public void testSearch() throws Exception {
		String baseURL = "http://localhost:8080/solr";
		SolrServer solrServer = new HttpSolrServer(baseURL);
		
		SolrQuery solrQuery = new SolrQuery();
		
		//关键词："台灯" 
		solrQuery.set("q", "台灯"); //solrQuery.setQuery("product_name:台灯");
		//过滤条件 "product_catalog_name": "幽默杂货", 
		solrQuery.set("fq", "product_catalog_name:幽默杂货");
		//价格区间//"product_price": 18.9,
		solrQuery.set("fq", "product_price:[* TO 10]");
		//价格排序
		solrQuery.addSort("product_price", ORDER.desc);
		//分页 开始行  每页数，
		solrQuery.setStart(0);
		solrQuery.setRows(5);
		//默认域
		solrQuery.set("df", "product_name");
		//指定查询域
		solrQuery.set("fl", "id,product_name");
		//高亮
		solrQuery.setHighlight(true);
		//指定高亮的域
		solrQuery.addHighlightField("product_name");
		//前缀
		solrQuery.setHighlightSimplePre("<span style='color:red'>");
		//后缀
		solrQuery.setHighlightSimplePost("</span>");
		
		//执行查询
		QueryResponse response = solrServer.query(solrQuery);
		
		//文档结果集
		SolrDocumentList docs = response.getResults();
		
		//获取高亮域的数据
		//	Map K:id    V:Map
		//	Map	K:域名	V:List
		//	List  list.get(0)
		Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();
		
		
		//获取总条数
		long numFound = docs.getNumFound();
		System.out.println(numFound);
		
		for (SolrDocument doc : docs) {
			//System.out.println(doc.get("product_picture"));
			//System.out.println(doc.get("product_catalog_name"));
			//System.out.println(doc.get("product_price"));
			System.out.println(doc.get("product_name"));
			System.out.println();
			
			System.out.println("-------------------------------------------");
			Map<String, List<String>> map = highlighting.get(doc.get("id"));
			List<String> list = map.get("product_name");
			System.out.println(list.get(0));
			System.out.println("-------------------------------------------");
		}
		
	}
	
	
	
	
}
