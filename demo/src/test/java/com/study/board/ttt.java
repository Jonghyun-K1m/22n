package com.study.board;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.jupiter.api.Test;

public class ttt {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/pjtdev";
	
	private static final String USER = "root";
	private static final String PW = "root";
	
	@Test
	public void testConnection() throws Exception{
		Class.forName(DRIVER);
		
		try(Connection conn = DriverManager.getConnection(URL, USER, PW)){
			
			System.out.println(conn); // 콘솔창에서 연결정보를 출력하여 확인한다.
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}