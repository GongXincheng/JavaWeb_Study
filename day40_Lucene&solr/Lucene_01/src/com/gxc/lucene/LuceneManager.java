package com.gxc.lucene;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.MatchAllDocsQuery;
import org.apache.lucene.search.NumericRangeQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

/**
 * 索引维护
 * 删除
 * 修改
 * @author 宫新程
 *
 */
public class LuceneManager {

	/**
	 * 获取IndexWriter对象
	 * @return
	 * @throws IOException
	 */
	public IndexWriter getIndexWriter() throws IOException{
		Directory directory = FSDirectory.open(new File("D:\\temp\\index"));
		Analyzer analyzer = new IKAnalyzer();
		IndexWriterConfig config = new IndexWriterConfig(Version.LATEST, analyzer);
		return new IndexWriter(directory, config);
	}
	
	//全删
	@Test
	public void testDeleteAll() throws Exception {
		IndexWriter indexWriter = this.getIndexWriter();
		indexWriter.deleteAll();
		indexWriter.close();
	}
	
	//根据条件删除
	@Test
	public void testDeleteByInfo() throws Exception {
		IndexWriter indexWriter = this.getIndexWriter();
		
		Query query = new TermQuery(new Term("fileName", "apache"));
		indexWriter.deleteDocuments(query);
		
		indexWriter.close();
	}
	
	//修改 
	@Test
	public void testUpdate() throws Exception {
		IndexWriter indexWriter = this.getIndexWriter();
		Document document = new Document();
		document.add(new TextField("fileN", "测试文件名", Store.YES));
		document.add(new TextField("fileC", "测试文件内容", Store.YES));
		indexWriter.updateDocument(new Term("fileName", "lucene"), document, new IKAnalyzer());
		indexWriter.close();
	}
	
	/***************************************************************************************/
	/**
	 * 获取IndexSearcher
	 * @throws Exception 
	 */
	public IndexSearcher getIndexSearcher() throws Exception{
		Directory directory = FSDirectory.open(new File("D:\\temp\\index"));
		IndexReader indexReader = DirectoryReader.open(directory );
		IndexSearcher indexSearcher = new IndexSearcher(indexReader );
		return indexSearcher;
	}
	
	//执行查询结果
	public void printResult(Query query,IndexSearcher indexSearcher) throws IOException{
		TopDocs topDocs = indexSearcher.search(query , 20);
		ScoreDoc[] scoreDocs = topDocs.scoreDocs;
		for (ScoreDoc scoreDoc : scoreDocs) {
			int docID = scoreDoc.doc;
			Document document = indexSearcher.doc(docID);
			
			String fileName = document.get("fileName");
			long fileSize = Long.parseLong(document.get("fileSize"));
			String filePath = document.get("filePath");
			String fileContent = document.get("fileContent");
			
			System.out.println(fileName+"："+fileContent);
			System.out.println("fileSize："+fileSize);
			System.out.println("filePath："+filePath);
			System.out.println("---------------------------------------------------------");
		}
	}
	
	
	/**
	 * 高级查询
	 */
	
	
	/**
	 * Query子类查询
	 * @throws Exception
	 */
	//查询所有
	@Test
	public void testMatchAllDocsQuery() throws Exception {
		IndexSearcher indexSearcher = this.getIndexSearcher();
		Query query = new MatchAllDocsQuery();
		this.printResult(query, indexSearcher);
		indexSearcher.getIndexReader().close();
	}
	
	//根据范围查询
	@Test
	public void testNumericRangeQuery() throws Exception {
		IndexSearcher indexSearcher = this.getIndexSearcher();
		Query query = NumericRangeQuery.newLongRange("fileSize", 0l, 200l, true, true);
		this.printResult(query , indexSearcher);
		indexSearcher.getIndexReader().close();
		
	}  
	
	//组合查询
	@Test
	public void testBooleanQuery() throws Exception {
		IndexSearcher indexSearcher = this.getIndexSearcher();
		
		BooleanQuery booleanQuery = new BooleanQuery();
		Query query1 = new TermQuery(new Term("fileName","apache"));
		Query query2 = new TermQuery(new Term("fileName","lucene"));
		booleanQuery.add(query1, Occur.MUST);
		booleanQuery.add(query2, Occur.MUST);
		
		this.printResult(booleanQuery, indexSearcher);
		indexSearcher.getIndexReader().close();
	}
	
	
	
	/**************************************************************************************
	 * 
	 * queryParse 解析语法查询
	 */
	@Test
	public void testQueryParser() throws Exception {
		IndexSearcher indexSearcher = this.getIndexSearcher();
		
		//参数一：默认查询的域
		QueryParser queryParser = new QueryParser("fileName", new IKAnalyzer());
		Query query = queryParser.parse("*:*");
		
		this.printResult(query, indexSearcher);
		indexSearcher.getIndexReader().close();
	}
	
	 /* 多个默认域 
	 * queryParse 解析语法查询
	 */
	@Test
	public void testMultiFieldQueryParser () throws Exception {
		
		IndexSearcher indexSearcher = this.getIndexSearcher();
		
		String[] fields = {"fileName","fileContent"};
		  
		MultiFieldQueryParser queryParser = new MultiFieldQueryParser(fields , new IKAnalyzer());
		Query query = queryParser.parse("fileName:apache AND fileName:lucene");
		
		this.printResult(query, indexSearcher);
		indexSearcher.getIndexReader().close();
	}
	
}
















