package com.gxc.lucene;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.LongField;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;

/**
 * Lucene入门
 * 创建索引
 * 查询索引
 * @author 宫新程
 *
 */
public class FirstLucene {

	
	/**
	 * 创建索引
	 * @throws Exception
	 */
	@Test
	public void testIndex1() throws Exception {
		
//		第一步：创建一个indexwriter对象。
//			1）指定索引库的存放位置Directory对象
		Directory directory = FSDirectory.open(new File("D:\\temp\\index"));
//			2）指定一个分析器，对文档内容进行分析。
		Analyzer analyzer = new StandardAnalyzer();	//官方推荐
		IndexWriterConfig writerConfig = new IndexWriterConfig(Version.LUCENE_4_10_3, analyzer);
		
		IndexWriter indexWriter = new IndexWriter(directory, writerConfig);
		
		
//		第三步：创建field对象，将field添加到document对象中。
		File f = new File("D:\\searchsource");
		File[] listFiles = f.listFiles();
		for (File file : listFiles) {
			
//			第二步：创建document对象。
			Document document = new Document();
			
			//域：文件名称
			String file_name = file.getName();
			Field fileNameField = new TextField("fileName", file_name, Store.YES);
			//域：文件大小
			long file_size = FileUtils.sizeOf(file);
			Field fileSizeField = new LongField("fileSize", file_size, Store.YES);
			//域：文件路径
			String file_path = file.getPath();
			Field filePathField = new StoredField("filePath", file_path);
			//域：文件内容
			String file_content = FileUtils.readFileToString(file);
			Field fileContentField = new TextField("fileContent", file_content, Store.YES);
		
			//将field添加到document对象中。
			document.add(fileNameField);
			document.add(fileSizeField);
			document.add(filePathField);
			document.add(fileContentField);
			
//			第四步：使用indexwriter对象将document对象写入索引库，此过程进行索引创建。并将索引和document对象写入索引库。
			indexWriter.addDocument(document);
		}
//		第五步：关闭IndexWriter对象。
		indexWriter.close();
	}
	
	
	
	/*********************************************	Index2()	*********************************************************************'
	 * 
	 * 创建索引
	 * @throws Exception
	 */
	@Test
	public void testIndex2() throws Exception {
		//指定索引库的位置
		Directory directory = FSDirectory.open(new File("D:\\temp\\index"));
		
		//指定一个分析器，对文档内容进行分析。
		Analyzer analyzer = new StandardAnalyzer();
		//分析器版本
		IndexWriterConfig config  = new IndexWriterConfig(Version.LATEST, analyzer);
		
		//创建IndexWriter对象，传入 索引库位置 和 分析器
		IndexWriter indexWriter = new IndexWriter(directory , config);
		
		//获取文件列表
		File f = new File("D:\\searchsource");
		File[] listFiles = f.listFiles();
		for (File file : listFiles) {
			
			//创建一个 Document 对象
			Document document = new Document();
			
			//创建field对象
			String file_name = file.getName();
			Field fileNameField = new TextField("fileName", file_name, Store.YES);
			
			long file_size = FileUtils.sizeOf(file);
			Field fileSizeField = new LongField("fileSize", file_size, Store.YES);
			
			String file_path = file.getPath();
			Field filePathField = new StoredField("filePath", file_path);
			
			String file_content = FileUtils.readFileToString(file);
			Field fileContentField = new TextField("fileContent", file_content, Store.YES);
			
			//将field添加到document对象中
			document.add(fileContentField);
			document.add(filePathField);
			document.add(fileSizeField);
			document.add(fileNameField);
			
			//用indexwriter对象将document对象写入索引库，此过程进行索引创建。并将索引和document对象写入索引库。
			indexWriter.addDocument(document);
		}
		
		indexWriter.close();
		
	}
	
	
	/*******************************************	Index3()	***********************************************************************
	 * 
	 * 创建索引
	 * @throws Exception
	 */
	@Test
	public void testIndex3() throws Exception {
		
		Analyzer analyzer = new StandardAnalyzer();
		IndexWriterConfig config = new IndexWriterConfig(Version.LATEST, analyzer );
		Directory directory = FSDirectory.open(new File("D:\\temp\\index"));
		IndexWriter indexWriter = new IndexWriter(directory , config);
		
		File f = new File("D:\\searchsource");
		File[] listFiles = f.listFiles();
		for (File file : listFiles) {
			
			Document document = new Document();
			
			//创建field对象
			String file_name = file.getName();
			Field fileNameField = new TextField("fileName", file_name, Store.YES);
			
			long file_size = FileUtils.sizeOf(file);
			Field fileSizeField = new LongField("fileSize", file_size, Store.YES);
			
			String file_path = file.getPath();
			Field filePathField = new StoredField("filePath", file_path);
			
			String file_content = FileUtils.readFileToString(file);
			Field fileContentField = new TextField("fileContent", file_content, Store.YES);
			
			document.add(fileNameField);
			document.add(fileSizeField);
			document.add(filePathField);
			document.add(fileContentField);
		}
		
		indexWriter.close();
	}
	
	
	
	
	/*******************************************	Search1()	***********************************************************************
	 * 
	 * 搜索索引
	 * @throws Exception
	 */
	@Test
	public void testSearch1() throws Exception {
//		第一步：创建一个Directory对象，也就是索引库存放的位置。
		Directory directory = FSDirectory.open(new File("D:\\temp\\index"));

//		第二步：创建一个indexReader对象，需要指定Directory对象。
		IndexReader indexReader = DirectoryReader.open(directory);

//		第三步：创建一个indexsearcher对象，需要指定IndexReader对象
		IndexSearcher indexSearcher = new IndexSearcher(indexReader);

//		第四步：创建一个TermQuery对象，指定查询的域和查询的关键词。
		Query query = new TermQuery(new Term("fileContent", "java"));
		
//		第五步：执行查询。
		TopDocs topDocs = indexSearcher.search(query, 2);
		
//		第六步：返回查询结果。遍历查询结果并输出。
		ScoreDoc[] scoreDocs = topDocs.scoreDocs;
		for (ScoreDoc scoreDoc : scoreDocs) {
			int doc = scoreDoc.doc;
			Document document = indexSearcher.doc(doc);
			
			//文件名称
			String fileName = document.get("fileName");
			//文件大小
			long fileSize = Long.parseLong(document.get("fileSize"));
			//文件路径
			String filePath = document.get("filePath");
			//文件内容
			String fileContent = document.get("fileContent");
			
			System.out.println(fileName+"："+fileContent);
			System.out.println("fileSize："+fileSize);
			System.out.println("filePath："+filePath);
			System.out.println("---------------------------------------------------------");
		}
		
//		第七步：关闭IndexReader对象
		indexReader.close();
	}
	
	
	
	
	
	/*******************************************	Search2()	***********************************************************************
	 * 
	 * 搜索索引
	 * @throws Exception
	 */
	@Test
	public void testSearch2() throws Exception {
		//第一步：创建一个Directory对象，也就是索引库存放的位置。
		Directory directory = FSDirectory.open(new File("D:\\temp\\index"));
		
		//第二步：创建一个indexReader对象，需要指定Directory对象。
		IndexReader indexReader = DirectoryReader.open(directory );
		
		//第三步：创建一个indexsearcher对象，需要指定IndexReader对象
		IndexSearcher indexSearcher = new IndexSearcher(indexReader );
		
		//第四步：创建一个TermQuery对象，指定查询的域和查询的关键词。
		Query query = new TermQuery(new Term("fileContent", "java"));
		
		//第五步：执行查询。
		TopDocs topDocs = indexSearcher.search(query , 2);
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
	

	
	/*******************************************	Search3()	***********************************************************************
	 * 
	 * 搜索索引
	 * @throws Exception
	 */
	@Test
	public void testSearch3() throws Exception {
		
		Directory directory = FSDirectory.open(new File("D:\\temp\\index"));
		IndexReader indexReader = DirectoryReader.open(directory );
		IndexSearcher indexSearcher = new IndexSearcher(indexReader );
		
		Query query = new TermQuery(new Term("fileName","apache"));
		TopDocs topDocs = indexSearcher.search(query, 2);
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
		
}
	
	
	
	
	
	
	
	
	
	
	
	
	
