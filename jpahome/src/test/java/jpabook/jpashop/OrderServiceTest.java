package jpabook.jpashop;

import static org.junit.Assert.fail;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import jpabook.jpashop.db.OrderDB;
import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Item;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderStatus;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.exception.NotEnoughStockException;
import jpabook.jpashop.service.OrderService;
import junit.framework.Assert;
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional

public class OrderServiceTest {
	
	@Autowired
	EntityManager em;
	@Autowired
	OrderService osc;
	@Autowired
	OrderDB odb;
	@Test
	public void 주문() throws Exception{
		
		Member mem=new Member();
		mem.setName("ONE");
		mem.setAddress(new Address("서울","리버뷰","1-1"));
		em.persist(mem);
		
		
		Book book=new Book();
		book.setName("JPA북");
		book.setPrice(10000);
		book.setStockQuantity(10);
		em.persist(book);
		int acc=2;
		Long orderId= osc.order(mem.getId(), book.getId(), acc);
		Order getOrder =odb.findOne(orderId);
		
		Assert.assertEquals(OrderStatus.ORDER, getOrder.getStatus());
		Assert.assertEquals("수체크",1, getOrder.getOrderItems().size());
	
		
	}
	@Test
	public void 주문취소() throws Exception{
		Member mem=new Member();
		mem.setName("ONE");
		mem.setAddress(new Address("서울","리버뷰","1-1"));
		em.persist(mem);
		
		
		Book book=new Book();
		book.setName("JPA북");
		book.setPrice(10000);
		book.setStockQuantity(10);
		em.persist(book);
		
		int acc=2;
		Long orderId= osc.order(mem.getId(), book.getId(), acc);

		
		osc.cancelOrder(orderId);
		
		
		Order getoreder = odb.findOne(orderId);
		
		Assert.assertEquals(OrderStatus.CANCEL, getoreder.getStatus());
		Assert.assertEquals(10, book.getStockQuantity());
		
	}

	@Test()
	public void 주문_수량초과() throws NotEnoughStockException{
		Member mem=new Member();
		mem.setName("ONE");
		mem.setAddress(new Address("서울","리버뷰","1-1"));
		em.persist(mem);
		
		
		Book book=new Book();
		book.setName("JPA북");
		book.setPrice(10000);
		book.setStockQuantity(10);
		em.persist(book);
		
		Item itm=book;
		osc.order(mem.getId(), itm.getId(), 10);
		
		fail("재고수량부족");
		
	}




}
