package jpabook.jpashop.Controller;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class BookForm {

	private	Long id;
	@NotEmpty(message = "이름은 NULL안댐")
	private String name;
	
	private int price;
	private int stockQuantity;
	
	private String author;
	private String isbn;
	
}
