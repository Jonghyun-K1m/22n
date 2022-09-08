package jpabook.jpashop.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jpabook.jpashop.db.ItemDB;
import jpabook.jpashop.db.MemberDB;
import jpabook.jpashop.db.OrderDB;
import jpabook.jpashop.db.OrderSearch;
import jpabook.jpashop.domain.Delivery;
import jpabook.jpashop.domain.Item;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor//파이널생성자만해줌
public class OrderService {

	/*
	 * @Autowired //필드주입
	 */
	private final OrderDB oDB;
	private final MemberDB mDB;
	private final ItemDB iDB;

	

	//주문
	@Transactional
	public Long order(Long memberId,Long itemId,int count) {
		Member mem= mDB.findOne(memberId);
		Item itm = iDB.findOne(itemId);
		
		
		Delivery dlv =new Delivery();
		dlv.setAddress(mem.getAddress());
		
		OrderItem oitm = OrderItem.createOrderItem(itm, itm.getPrice(), count);
		
		Order order= Order.createOrder(mem, dlv, oitm);
		
		oDB.save(order);
		return order.getId();
	}
	
	

	@Transactional
	public void cancelOrder(Long orderId) {
		Order order = oDB.findOne(orderId);
		order.cancel(); //오더의 cancel에서 다함
	}
	
	public List<Order> findsOrders(OrderSearch osch){
		return oDB.findAllByString(osch);
	}
}
