package jpabook.jpashop.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import javax.validation.*;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MemberController {

	
	private final MemberService ms;

	@GetMapping("/members/new")
	public String createForm(Model model) {

		
		model.addAttribute("memberForm",new MemberForm());
		return "members/createMemberForm";
	}

	@PostMapping("/members/new")
	public String create(@Valid MemberForm memberForm,BindingResult result) {
		//멤버가아니라 멤폼인이유-> valid등 뷰랑 서버랑 원하는 엔티티가다를수도
		if(result.hasErrors()) {
			return "members/createMemberForm";
		}
		Address add= new Address(memberForm.getCity(),memberForm.getStreet(),memberForm.getZipcode());
		Member mem=new Member();
		mem.setName(memberForm.getName());
		mem.setAddress(add);
		
		ms.join(mem);
		return "redirect:/";
	
	
	}

	@GetMapping("/members")
	public String list(Model model) {

		List<Member> members=ms.findMembers();
		model.addAttribute("members",members);
		return "members/memberList";
	}


	@GetMapping("/dd")
	public String listd(Model model) {


		return "NewFile";
	}

	@GetMapping("/ddd")
	public String listda(Model model) {


		return "login";
	}
}
