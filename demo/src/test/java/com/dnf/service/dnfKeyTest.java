package com.dnf.service;
import org.junit.jupiter.api.Test;

import com.dnf.service.*;


public class dnfKeyTest {

	
	
	@Test
	public void test()
	{
//		dnfKey a = new dnfKey();
//		String abbb=a.resource;
//		String abc= a.get_driver();
		System.out.println("SDSD");

		double ac=1;
		double ka=0.05;
		double acs;
		double etc=400;
		for(int i=0;i<10;i++)
		{
			acs=ac*ka;
			ac=ac+acs;
			System.out.println(ac+etc);
		}
	}
}

