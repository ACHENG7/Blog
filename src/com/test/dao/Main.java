package com.test.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class Main {
	@Autowired
    @Qualifier("chinese")   
    private Man man;   
	  
    public static void main(String[] args) {   
        // TODO code application logic here   
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");   
        Main main = (Main) ctx.getBean("main");   
        System.out.println(main.getMan().sayHello());   
    }   
  
    public Man getMan() {   
        return man;   
    }   


}
