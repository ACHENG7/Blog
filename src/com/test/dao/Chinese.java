package com.test.dao;

import org.springframework.stereotype.Service;

@Service
public class Chinese implements Man{   
	public String sayHello() {   
        return "I am Chinese!";   
    }  

}
