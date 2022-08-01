package hello.basic.beanfind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.Iterator;
import hello.basic.Appconfig;

public class beanALLFINDTest {
	
	ApplicationContext ac = new AnnotationConfigApplicationContext(Appconfig.class);
	
	@Test
	@DisplayName("모든BEAN조회")
	void findAllBean() {
		String[] bdns=ac.getBeanDefinitionNames();
		for(String bdn : bdns) {
			Object bean =ac.getBean(bdn);
			System.out.println("name = " + bdn + "obj  = " + bean);
		}
	}

	@Test
	@DisplayName("beanTest")
	void findAppBean() {
		String[] bdns=ac.getBeanDefinitionNames();
		for(String bdn : bdns) {
			Object bean =ac.getBean(bdn);
			System.out.println("name = " + bdn + "obj  = " + bean);
			
		}
	}

}
