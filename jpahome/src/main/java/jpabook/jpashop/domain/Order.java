package jpabook.jpashop.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="orders")
@Getter
@Setter
public class Order {


	@Id @GeneratedValue
	@Column(name="order_id")
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="member_id")
	private Member member;

	@OneToMany(mappedBy="order",cascade =CascadeType.ALL)
	//orderitem의order에 의해 종속댐
	//cascade -> persist(order)하면 orderitems도 persist댐
	private List<OrderItem> orderItems =new ArrayList<>();
	
	@OneToOne(fetch=FetchType.LAZY,cascade =CascadeType.ALL)
	@JoinColumn(name="delivery_id")
	private Delivery delivery;
	private LocalDateTime orderDate;
	
	
	@Enumerated(EnumType.STRING)//ordinal=숫자
	private OrderStatus status;

	//연관관계
	public void setMember(Member mem) {
		this.member=mem;
		mem.getOrders().add(this);
	}
	public void addOrderItem(OrderItem otm) {
		orderItems.add(otm);
		otm.setOrder(this);
	}
	public void setDelivery(Delivery dlv) {
		this.delivery=dlv;
		dlv.setOrder(this);
	}

	//생성자
	public static Order createOrder(Member mem, Delivery del, OrderItem... orderItems)
	{
		Order order=new Order();
		order.setMember(mem);
		order.setDelivery(del);
		for(OrderItem itm : orderItems) {
			order.addOrderItem(itm);
		}
		order.setStatus(OrderStatus.ORDER);
		order.setOrderDate(LocalDateTime.now());
		return order;
	}

	//주문취소
	public void cancel(){
		if(delivery.getStatus()==DeliverySatus.COMP) {
			//배송완료면 캔슬안대
			throw new IllegalStateException("이미 배송완료");
		}
		this.setStatus(OrderStatus.CANCEL);
		for(OrderItem otm : orderItems) {
			otm.cancel(); //->otm의 cancel로직호출
		}
		
	}

	//조회로직
	public int getTotalPrice() {
		int totalPrice=0;
		for(OrderItem otm : orderItems) {
			totalPrice += otm.getTotalPrice(); //otm -> gtP호출
		}
	
		return totalPrice;
	}
	
	
	
}
