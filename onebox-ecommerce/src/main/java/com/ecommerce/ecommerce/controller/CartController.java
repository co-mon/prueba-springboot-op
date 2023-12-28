package com.ecommerce.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecommerce.entity.Cart;
import com.ecommerce.ecommerce.entity.Product;
import com.ecommerce.ecommerce.service.CartService;

@RestController
@RequestMapping("/api/carts")
public class CartController {

	@Autowired
	private CartService cartService;

	@PostMapping("/{cartId}/products")
	public ResponseEntity<Cart> addProduct(
			@PathVariable int cartId,
			@RequestBody Product product) {
		Cart cart = cartService.addProduct(cartId, product);
		return ResponseEntity.ok(cart);
	}

	@GetMapping("/{cartId}")
	public ResponseEntity<Cart> getCart(@PathVariable int cartId) {
		Cart cart = cartService.getCart(cartId);
		return ResponseEntity.ok(cart);
	}

	@DeleteMapping("/{cartId}")
	public ResponseEntity<?> deleteCart(@PathVariable int cartId) {
		cartService.deleteCart(cartId);
		return ResponseEntity.ok().build();
	}

}
