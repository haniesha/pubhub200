package com.boot.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boot.model.Book;
import com.boot.model.Order;
import com.boot.model.OrderItem;
import com.boot.model.User;
import com.boot.service.BookService;
import com.boot.service.OrderItemService;




@Controller
@RequestMapping(value="/OrderItem")
public class OrderItemController {
	@Autowired
	private OrderItemService orderitemservice;
	@Autowired
	private BookService bookservice;
	@PostMapping("/addToCart")
	public String addToCart(@RequestParam("book_id") int bookId, @RequestParam("quantity") Integer quantity,
			HttpSession session) {

		System.out.println("inside order item addtocart");
		User user = (User) session.getAttribute("LOGGED_IN_USER");
System.out.println("inside user order item controller"+user);
		Order order = (Order) session.getAttribute("MY_CART_ITEMS");
		System.out.println(order);
		// create order
		if (order == null) {
			order = new Order();
			order.setUser(user);
			order.setTotalPrice(0);
			order.setStatus("ORDERED");
		}

		// store orderItems
		List<OrderItem> orderItems = order.getOrderItems();

		// If already the item is added to cart, then add the quantity

		boolean isItemExists = false;
		for (OrderItem item : orderItems) {

			if (item.getBook().getId().equals(bookId)) {
				int totalQuantity = item.getQuantity() + quantity;
				item.setQuantity(totalQuantity);
				isItemExists = true;
			}
		}

		//If item not exists, create new Item
		if ( ! isItemExists) {

			OrderItem orderItem = new OrderItem();
			orderItem.setOrder(order);

			Book book = bookservice.findOne(bookId);
			orderItem.setBook(book);
			orderItem.setQuantity(quantity);
			orderItems.add(orderItem);
		}

		order.setOrderItems(orderItems);

		session.setAttribute("MY_CART_ITEMS", order);
		
		System.out.println(order);

		 //orderService.save(order);

		return "redirect:../Order/cart";
	}

	@GetMapping("/list")
	public String list(HttpSession session) {
		return null;

	}

	@GetMapping("/remove")
	public String removeItemFromCart(@RequestParam("id") Integer id, HttpSession session) {

		System.out.println("Remove Item from Card:" + id);
		Order order = (Order) session.getAttribute("MY_CART_ITEMS");

		if (order != null && order.getOrderItems().size() > 0) {
			List<OrderItem> orderItems = order.getOrderItems();
			OrderItem itemSelected = orderItems.get(id);
			orderItems.remove(itemSelected);
			order.setOrderItems(orderItems);
			session.setAttribute("MY_CART_ITEMS", order);
		}

		return "redirect:../order/cart";

	}

	@GetMapping("/emptycart")
	public String emptyCartid(HttpSession session) {

		session.removeAttribute("MY_CART_ITEMS");
		return "redirect:../order/cart";

	}



	
}