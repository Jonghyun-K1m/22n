package jpabook.jpashop.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

import jpabook.jpashop.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="dtype")
public abstract class Item {

	
	@Id @GeneratedValue
	@Column(name="item_id")
	private Long id;
	private String name;
	private int price;
	private int stockQuantity;

	@ManyToMany(mappedBy="items")
	private List<Category> categories =new ArrayList<>();

	
	//entity 에 비지니스로직추가
	//setter등 사용안하게하기위함임
	public void addStock(int quantity)
	{
		this.stockQuantity+=quantity;
	}
	public void removeStock(int quantity)
	{
		int result = this.stockQuantity-quantity;
		if(result<0) {
			throw new NotEnoughStockException("수량이0보다작ㅇ");
		}
		this.stockQuantity=result;
	}
	
	
	
}
