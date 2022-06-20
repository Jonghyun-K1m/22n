package com.dnf.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Properties;



public class dnfKey {
	String resource = "ad";
	Properties properties = new Properties();
	public dnfKey(){

    }  
	public String get_driver() {
        try {
        	properties.load(new dnfKey().getClass().getResourceAsStream(resource));
       //    System.out.println(properties.getProperty("driver"));
       //    System.out.println(properties.getProperty("user"));
       //     System.out.println(properties.getProperty("password"));
       //     System.out.println(properties.getProperty("url"));
        } catch (IOException e) {
            e.printStackTrace();
        }
		return properties.getProperty("apikey");
	}

}