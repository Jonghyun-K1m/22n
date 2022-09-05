package jpabook.jpashop.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jpabook.jpashop.db.ItemDB;
import jpabook.jpashop.domain.Item;
import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor//파이널생성자만해줌
public class ItemService {

	/*
	 * @Autowired //필드주입
	 */
	private final ItemDB iDB;
	

	//저장
	@Transactional
	public void saveItem(Item Item)
	{
		iDB.save(Item);
	
	}
		
	
	//조회
	@Transactional(readOnly=true) //스부트 트랜잭션사용,성능개선위한 코드
	public List<Item> findMembers(){
		return iDB.findAll();
	}
	@Transactional(readOnly=true) //스부트 트랜잭션사용,성능개선위한 코드
	public Item findOne(Long itemId){
		return iDB.findOne(itemId);
	}
		
}
