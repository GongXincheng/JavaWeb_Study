package com.gxc.jd.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.gxc.jd.pojo.ProductModel;

@Repository
public class JDdaoImpl implements JDdao{

	//索引库
	@Autowired
	private SolrServer solrServer;
	
	public List<ProductModel> selectProductModelListByQuery(String queryString,String catalog_name,
			   String price,String sort) throws Exception{
		
		SolrQuery solrQuery = new SolrQuery();
		solrQuery.set("q", queryString);
		
		//过滤条件
		if(catalog_name!=null && !catalog_name.equals("")){
			solrQuery.set("fq", "product_catalog_name:" + catalog_name);
		}
		
		//价格区间
		if(price!=null && !price.equals("")){
			String[] p = price.split("-");
			solrQuery.set("fq", "product_price:[" + p[0] + " TO " + p[1] + "]");
		}
		
		//排序
		if(sort!=null && !sort.equals("")){
			if(!sort.equals("1"))
				solrQuery.setSort("product_price", ORDER.desc);
			else
				solrQuery.setSort("product_price", ORDER.asc);
		}
		
		//分页
		solrQuery.setStart(0); 
		solrQuery.setRows(16);
		
		//设置显示的域
		solrQuery.set("fl", "id,product_name,product_picture,product_price");
		
		//设置默认域
		solrQuery.set("df", "product_keywords");
		
		//设置高亮
		solrQuery.setHighlight(true);
		solrQuery.addHighlightField("product_name");
		solrQuery.setHighlightSimplePre("<span style='color:red'>");
		solrQuery.setHighlightSimplePost("</span>");
		
		QueryResponse response = solrServer.query(solrQuery);
		SolrDocumentList documentList = response.getResults();
		
		//高亮
		Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();
		
		//总条数
		//long numFound = documentList.getNumFound();
		
		List<ProductModel> productModels = new ArrayList<ProductModel>();
		for (SolrDocument doc : documentList) {
			ProductModel pm = new ProductModel();
			pm.setPid((String)doc.get("id"));
			pm.setPrice((float)doc.get("product_price"));
			pm.setPicture((String)doc.get("product_picture"));
			
			
			//获取高亮后的'product_name'
			Map<String, List<String>> map = highlighting.get(doc.get("id"));
			
			if(map.size()>0){
				List<String> list = map.get("product_name");
				pm.setName(list.get(0));
			}
			else{
				pm.setName((String)doc.get("product_name"));
			}
			productModels.add(pm);
		}
		
		return productModels;
	}
	
}
