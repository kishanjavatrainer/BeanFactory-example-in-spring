package com.infotech.client;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.infotech.model.Message;

public class ClientTest {

	public static void main(String[] args) {

		Resource resource = new ClassPathResource("Beans.xml");
		BeanFactory beanFactory = new XmlBeanFactory(resource);
		
		Object object = beanFactory.getBean("message");
		if(object != null){
			Message message=(Message)object;
			
			System.out.println(message.getMessageId()+"\t"+message.getMessage());
		}
		
		System.out.println("------------------------------------");
		
		Message message = beanFactory.getBean("message", Message.class);
		System.out.println(message.getMessageId()+"\t"+message.getMessage());
		
		System.out.println("------------------------------------");
		
		String[] aliases = beanFactory.getAliases("message");
		for (String aName : aliases) {
			System.out.println(aName);
		}
		System.out.println("------------------------------------");
		
		Message message1 = beanFactory.getBean(Message.class);
		System.out.println(message1.getMessageId()+"\t"+message1.getMessage());
		
		System.out.println("------------------------------------");
		
		Class<?> cls = beanFactory.getType("message");
		
		System.out.println(cls.getName());
		
		System.out.println("------------------------------------");
		
		System.out.println(beanFactory.isSingleton("message"));
	}

}
