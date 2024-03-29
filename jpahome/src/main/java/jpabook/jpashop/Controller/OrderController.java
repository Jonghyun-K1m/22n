package jpabook.jpashop.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jpabook.jpashop.db.OrderSearch;
import jpabook.jpashop.domain.Item;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.service.ItemService;
import jpabook.jpashop.service.MemberService;
import jpabook.jpashop.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import jpabook.jpashop.service.ItemService;
import jpabook.jpashop.service.MemberService;
import jpabook.jpashop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequiredArgsConstructor
public class OrderController {

	private final OrderService osv;
	private final MemberService msv;
	private final ItemService isv;
	
	@GetMapping("/order")
	public String createForm(Model model) {
		
		List<Member> members = msv.findMembers();
		List<Item> items=isv.findItems();
		
		
		model.addAttribute("members", members);
		model.addAttribute("items",items);
		
		
		return "order/orderForm";
	}




	@PostMapping("/order")
	public String order(@RequestParam("memberId") Long memberId,
			@RequestParam("itemId") Long itemId,
			@RequestParam("count") int count )
	{

		osv.order(memberId, itemId, count);
		
		
		return "redirect:/orders";
	}
	
	
	@GetMapping("/orders")
	public String orderList(@ModelAttribute("orderSearch") OrderSearch osh,Model model)
	{
		List<Order> orders = osv.findsOrders(osh);
	
		model.addAttribute("orders",orders);
		
		return "order/orderList";
	}

    @PostMapping("/orders/{orderId}/cancel")
    public String cancelOrder(@PathVariable("orderId") Long orderId) {
        osv.cancelOrder(orderId);
        return "redirect:/orders";
    }
}
