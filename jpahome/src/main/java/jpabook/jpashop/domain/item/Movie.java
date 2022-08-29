package jpabook.jpashop.domain.item;

import javax.persistence.Entity;

import jpabook.jpashop.domain.Item;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Movie extends Item{
	
	private String direcotr;
	private String actor;
	
}
