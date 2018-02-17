package com.MainApp;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Beans.PersonBean;

public class ApplicationClass {

	public static void main(String[] args) {
		String xmlPath="SpringStandAlone.xml";
		
		/*Resource resource= new ClassPathResource(xmlPath);
		BeanFactory context = new XmlBeanFactory(resource);
		*/
		ApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);
		PersonBean obj=context.getBean("personBean2",PersonBean.class);
		System.out.println(obj.getStrName());
		System.out.println(obj.getIntAge());
		
		obj.setListAddress(new ArrayList<String>(){{
			add("one val");
			add("two val");
			add("three val");
		}});
		
		System.out.println(obj.getListAddress());
	}
}
