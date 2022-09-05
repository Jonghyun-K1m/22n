package jpabook.jpashop.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OrderItem {

	@Id @GeneratedValue
	@Column(name="order_item_id")
	private Long id;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="item_id")	
	private Item item;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="order_id")
	private Order order;
	
	private int orderPrice;
	private int count;
	
	protected OrderItem() {
		
	}
	//생성자
	public static OrderItem createOrderItem(Item item,int orderPrice,int count)
	{
		OrderItem otm=new OrderItem();
		otm.setItem(item);
		otm.setOrderPrice(orderPrice);
		otm.setCount(count);
		
		item.removeStock(count);
		return otm;
	}
	
	
	//비지니스로직
	public void cancel() {
		getItem().addStock(count);
	}
	public int getTotalPrice() {
		return getOrderPrice()*getCount();
	}
}
