package jpabook.jpashop.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Member {

	@Id @GeneratedValue
	@Column(name="merber_id")
	private Long id;
	

	private String name;
	
	private String salt;
	
	
	@Embedded
	private Address address;
	//@JsonIgnore 	-> 엔티티에 화면을 위한로직 ㄴㄴ
	@OneToMany(mappedBy="member")//오더필드의 멤버에의해서 매핑댐, 을임
	private List<Order> orders =new ArrayList<>();
	
	
}
