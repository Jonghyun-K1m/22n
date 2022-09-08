package jpabook.jpashop.Controller;

//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jpabook.jpashop.domain.Item;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ItemController {

	
	private final ItemService isv;
	@GetMapping("/items/new")
	public String createForm(Model model) {

		
		model.addAttribute("form",new BookForm());
		return "items/createItemForm";
	}

	@PostMapping("/items/new")
	public String create(@Valid BookForm Form,BindingResult result) {
		//멤버가아니라 멤폼인이유-> valid등 뷰랑 서버랑 원하는 엔티티가다를수도
		if(result.hasErrors()) {
			return "items/createItemForm";
		}
		
		Book book=new Book();
		book.setName(Form.getName());
		book.setPrice(Form.getPrice());
		book.setStockQuantity(Form.getStockQuantity());
		book.setAuthor(Form.getAuthor());
		book.setIsbn(Form.getIsbn());
		
		isv.saveItem(book);
		return "redirect:/";
	
	
	}

	@GetMapping("/items")
	public String list(Model model) {

		List<Item> itms=isv.findItems();
		model.addAttribute("items",itms);
		return "items/itemList";
	}





	@GetMapping("items/{itemId}/edit")
	public String updateItemForm(@PathVariable("itemId") Long itemId,Model model){
		
		Book item = (Book)isv.findOne(itemId);
		BookForm form = new BookForm();
		form.setName(item.getName());
		form.setPrice(item.getPrice());
		form.setStockQuantity(item.getStockQuantity());
		form.setAuthor(item.getAuthor());
		form.setIsbn(item.getIsbn());
		
		model.addAttribute("form",form);
		return "items/updateItemForm";
	}

	@PostMapping("items/{itemId}/edit")
	public String updateItem(@ModelAttribute("form") BookForm form,@PathVariable("itemId") Long itemId){
		
		//auth체크필요함
		//merge거의안함
		//asis 동작이상함
		isv.updateItem(itemId, form.getName(), form.getPrice(), form.getStockQuantity());
		return "redirect:/items";
	}

	
}
