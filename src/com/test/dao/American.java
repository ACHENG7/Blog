package com.test.dao;

import org.springframework.stereotype.Service;

@Service
public class American implements Man{
	 public String sayHello() {   
	        return "I am American!";   
	    }   

}
