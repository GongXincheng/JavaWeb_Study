package com.gxc.test;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

public class ActiveMqTest {

	/************* Queue 发送消息 ***************************************/
	@Test
	/**
	 * 点对点形式发送消息
	 * @throws Exception
	 */
	public void testQueueProducer() throws Exception {
		
		//1、创建一个连接工厂对象,需要指定服务的ip和端口
		ConnectionFactory connectionFactory 
				= new ActiveMQConnectionFactory("tcp://192.168.11.128:61616");
		
		//2、使用工厂对象创建Connection对象
		Connection connection = connectionFactory.createConnection();
		
		//3、开启连接,调用Connection对象的start方法
		connection.start();
		
		//4、创建一个Session对象
		//		参数1：是否开启事务(一般不开)【如果开启事务第二个参数无意义】
		//		参数2：应答模式。一般自动应答(一般) 或者 手动应答
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		//5、使用Session对象创建一个Destination(目的地)对象。两种形式queue,topic，现在用queue
		//			参数：Queue的名称
		Queue queue = session.createQueue("test-queue");
		
		//6、使用Session对象创建一个Producer对象
		MessageProducer producer = session.createProducer(queue);
		
		//7、创建一个Message(消息)对象，可以使用TextMessage
		//	方式一：
		//		TextMessage textMessage = new ActiveMQTextMessage();
		//		textMessage.setText("Hello ActiveMQ ! ");
		//	方式二：
		TextMessage textMessage = session.createTextMessage("Hello ActiveMQ ! ");
		
		//8、发送消息
		producer.send(textMessage);
		
		//9、关闭资源
		producer.close();
		session.close();
		connection.close();
	}
	
	/************* Queue 接收消息 ***************************************/
	@Test
	public void testQueueConsumer() throws Exception{
		//1、创建ConnectionFactory对象连接服务器
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.11.128:61616");
		//2、创建一个连接对象
		Connection connection = connectionFactory.createConnection();
		//3、开启连接
		connection.start();
		//4、使用Connection对象创建session对象
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		//5、创建Destination对象。Queue
		Queue queue = session.createQueue("test-queue");
		//6、使用Session对象创建一个消费者对象
		MessageConsumer consumer = session.createConsumer(queue);
		//7、接收消息
		consumer.setMessageListener(new MessageListener() {
			@Override
			public void onMessage(Message message) {
				if(message instanceof TextMessage){
					TextMessage textMessage = (TextMessage)message;
					//并打印结果
					try {
						System.out.println(textMessage.getText());
					} catch (JMSException e) {
						e.printStackTrace();
					}
				}
			}
		});
		//等待接收消息
		System.in.read();
		
		//8、关闭资源
		consumer.close();
		session.close();
		connection.close();
	}
	
	
//-----------------------------------------------------------------------------------
	
	/************* Topic 发送消息 ***************************************/
	@Test
	public void testTopicProducer() throws Exception {
		//创建ConnectionFactory对象
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.11.128:61616");
		//创建Connction对象
		Connection connection = connectionFactory.createConnection();
		//打开连接
		connection.start();
		//创建Session对象
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		//创建Destination对象 Topic对象
		Topic topic = session.createTopic("test-topic");
		//创建Producer对象
		MessageProducer producer = session.createProducer(topic);
		//创建消息
		TextMessage textMessage = session.createTextMessage("topic -> Message");
		//发送消息
		producer.send(textMessage);
		//关闭资源
		producer.close();
		session.close();
		connection.close();
	}
	
	/************* Topic 接收消息 ***************************************/
	@Test
	public void testTopicConsumer() throws Exception {
		//1、创建ConnectionFactory对象连接服务器
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.11.128:61616");
		//2、创建一个连接对象
		Connection connection = connectionFactory.createConnection();
		//3、开启连接
		connection.start();
		//4、使用Connection对象创建session对象
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		//5、创建Destination对象。Topic
		Topic topic = session.createTopic("test-topic");
		//6、使用Session对象创建一个消费者对象
		MessageConsumer consumer = session.createConsumer(topic);
		//7、接收消息
		consumer.setMessageListener(new MessageListener() {
			@Override
			public void onMessage(Message message) {
				TextMessage textMessage = (TextMessage)message;
				try {
					System.out.println(textMessage.getText());
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		});
		//等待接收消息
		System.in.read();
		
		//8、关闭资源
		consumer.close();
		session.close();
		connection.close();
	}
}
