package com.boot.service;

//import java.util.List;

//import javax.persistence.criteria.Order;
//import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.boot.model.Book;
import com.boot.model.OrderItem;
import com.boot.repository.BookRepository;
import com.boot.repository.OrderItemRepository;


@Service
public class OrderItemService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BookService.class);
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	
	public void save(OrderItem orderItem) {
		orderItemRepository.save(orderItem);
	}
	

	
	

}
