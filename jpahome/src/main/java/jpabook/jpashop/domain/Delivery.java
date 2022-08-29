package jpabook.jpashop.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity

@Getter
@Setter
public class Delivery {

	
	@Id @GeneratedValue
	@Column(name="delivery_id")
	private Long id;

	@OneToOne(mappedBy="delivery",fetch=FetchType.LAZY) //오더에있는 딜리버리에 종속
	private Order order;
	@Embedded
	private Address address;
	
	@Enumerated(EnumType.STRING)//ordinal=숫자
	private DeliverySatus status;
	
}
