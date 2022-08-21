package hello.basic;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import hello.basic.member.MemberService;

public class AutoAppConfigTest {
	
	
	
	@Test
	void T()
	{
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppconfig.class);
		MemberService sc = ac.getBean(MemberService.class);
		Assertions.assertThat(sc).isInstanceOf(MemberService.class);
		
	}

}
