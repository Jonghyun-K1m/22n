package jpabook.jpashop.api;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

//@Controller @ResponseBody
//->
@RestController
@RequiredArgsConstructor
//-> fianl 값에대해 생성자만들어줌 , the blank final.. initialized 해결
public class MemberApiController {


	private final MemberService msv;
	
	//pure
	//member 엔티티변화시 장애
	@GetMapping("/api/v1/members")
	public List<Member> membersV1(){
		return msv.findMembers();
	}	
	
	@GetMapping("/api/v2/members")
	public Result membersV2(){
		List<Member> findmem=msv.findMembers();
		
		List<MemberDTO> collect = findmem.stream().map(m->new MemberDTO(m.getName()))
		.collect(Collectors.toList());
		
		return new Result(collect);
	}	

	@Data
	@AllArgsConstructor
	static class Result<T>{
		
		private T data;
		
	}
	@Data
	@AllArgsConstructor
	static class MemberDTO{
		
		private String name;
		
	}

	
	//pure
	//member 엔티티변화시 장애
	@PostMapping("/api/v1/members")
	public CreateMemberResponse saveMemverV1(@RequestBody @Valid Member mem) {
		Long id = msv.join(mem);
		return new CreateMemberResponse(id);
	}
	
	//dto
	@PostMapping("/api/v2/members")
	public CreateMemberResponse saveMemverV2(@RequestBody @Valid CreateMemberRequest req) {
		
		Member mem= new Member();
		mem.setName(req.getName());
		Long id = msv.join(mem);
		return new CreateMemberResponse(id);
	}
	//dto
	@PutMapping("/api/v2/members/{id}")
	public UpdateMemberResponse updateMemverV2(
			@PathVariable("id") Long id, 
			@RequestBody @Valid UpdateMemberRequest req) {
		
		msv.update(id,req.getName());
		
		Member findMem=msv.findOne(id);
		return new UpdateMemberResponse(findMem.getId(),findMem.getName());
	}
	
	@Data
	static class UpdateMemberRequest{
		@NotEmpty
		private String name;
		
	}
	@Data
	@AllArgsConstructor
	static class UpdateMemberResponse{
		
		private Long id;
		private String name;
		
	}
	@Data
	static class CreateMemberRequest{
		@NotEmpty
		private String name;
		
	}

	
	@Data
	static class CreateMemberResponse{
		private Long id;
		
		public CreateMemberResponse(Long id) {
			this.id=id;
		}
	}
}
