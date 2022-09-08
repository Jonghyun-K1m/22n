package jpabook.jpashop.Controller;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class MemberForm {

	@NotEmpty(message = "회원은 NULL안댐")
	private String name;
	
	private String city;
	private String street;
	private String zipcode;
	
}
