package jpabook.jpashop;

import org.springframework.transaction.annotation.Transactional;

public class comment {

	
	/*220831
	em.flush 영속성컨텐츠에 있는거 날림
	@Transactional ->기본적으로 롤백
	src/test/java -> Test에 app.properties 있으면 테스트설정물어옴

	*/

	/*
	 *	220905
	 *	api반환시 entity를 반환하면 절떄떄떄떄 안댐
	 *	->dto 활용
	 *	merge 대신 변경감지사용
	 *	merge하고 파라미터는 준영속상태유지 객체반환값은 영속상태임
	 *	merge 모든속성변경되므로 null로 변경댈수도잇음
	 */

}
