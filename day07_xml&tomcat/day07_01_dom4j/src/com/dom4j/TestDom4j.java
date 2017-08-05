package com.dom4j;

import java.util.List;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class TestDom4j {
	@Test
	public void test1() throws DocumentException{
		SAXReader reader = new SAXReader();	//创建一个xml解析对象
		Document document = reader.read("src/Book.xml");	//把xml文档加载到document对象中
		
		Element root = document.getRootElement();	//获取跟节点
/*		Element bookNode = root.element("书");
		System.out.println(bookNode.getName());
*/
		List list = root.elements();//得到当前节点的所有子节点
		Element secondBook = (Element)list.get(1);	//得到第二本书对象
		String name = secondBook.element("书名").getText();//得到当前节点的文本内容
		System.out.println(name);
	}
	
	
	@Test	//遍历所有元素节点
	public void test2() throws DocumentException{
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/Book.xml");
		Element root = document.getRootElement();
		
		treeWalk(root);
	}

	public void treeWalk(Element ele) {
		System.out.println(ele.getName());	//输出当前节点的名字
		for (int i = 0, size = ele.nodeCount(); i < size; i++) {//ele.nodeCount()得到当前节点的所有子节点的个数
			Node node = ele.node(i);	//取出下标为i的节点
			if(node instanceof Element){	//如果当前节点的类型为Element(标签)
				treeWalk( (Element)node );	//把Node强转成Element
			}
			else{
				System.out.print(node.getText());
			}
		}
	}
}
