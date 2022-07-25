package hello.basic.order;

import hello.basic.discount.DiscountPolicy;
import hello.basic.discount.FixDiscountPolicy;
import hello.basic.member.Member;
import hello.basic.member.MemberRepository;
import hello.basic.member.MemoeyMemberRepository;

public class OrderServiceImpl implements OrderService {

	
	private final MemberRepository mr = new MemoeyMemberRepository();
	private final DiscountPolicy dp = new FixDiscountPolicy();
	
	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		// TODO Auto-generated method stub
		Member member = mr.findById(memberId);
		int discountPrice = dp.discount(member, itemPrice);
		
		return new Order(memberId,itemName,itemPrice,discountPrice);
	}

}
