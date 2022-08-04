package hello.basic.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import hello.basic.Appconfig;

public class statefulServiceTest {
	
	@Test
	void statefulServiceSingleton() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(Tconfig.class);
		
		statefulService scc1 = ac.getBean(statefulService.class);
		statefulService scc2 = ac.getBean(statefulService.class);
/*		
		//a사용자가 상태를 1로변경
		scc1.check("USERA",1);
		//b사용자가 상태를 2로변경
		scc2.check("USERB",2);
		int test = scc1.getManager();
		
*/
		int userAprice= scc1.check("USERA", 1);
		int userBprice= scc2.check("USERB", 2);
		
		
		System.out.println(userAprice);
	}
	
	static class Tconfig{
		@Bean
		public statefulService sc() {
			return new statefulService();
		}
	}
}
