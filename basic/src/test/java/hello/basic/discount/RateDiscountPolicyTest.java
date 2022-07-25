package hello.basic.discount;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hello.basic.member.Grade;
import hello.basic.member.Member;

class RateDiscountPolicyTest {

	RateDiscountPolicy dp = new RateDiscountPolicy();
	
	@Test
	@DisplayName("vip퍼센트테스트")
	void test() {
		Member member =new Member(1L,"VIPmem",Grade.VIP); 
		int discount = dp.discount(member, 10000);
		Assertions.assertThat(discount).isEqualTo(1000);		
	}

	@Test
	@DisplayName("일반인 퍼센트테스트")
	void test_fail() {
		Member member =new Member(1L,"VIPmem",Grade.Basic); 
		int discount = dp.discount(member, 10000);
		Assertions.assertThat(discount).isEqualTo(0);		
	}
}
