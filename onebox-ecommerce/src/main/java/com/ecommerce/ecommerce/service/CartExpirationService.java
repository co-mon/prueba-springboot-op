package com.ecommerce.ecommerce.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.entity.Cart;

@Service
public class CartExpirationService {
	
	@Autowired
	private CartService cartService;

	@Scheduled(fixedRate = 600000) // 10 minutos
	public void deleteExpiredCart() {
		long actualTime = System.currentTimeMillis();
		for (Map.Entry<Integer, Cart> entry : cartService.getCarts().entrySet()) {
			Integer carritoId = entry.getKey();
			Cart cart = entry.getValue();
			if (actualTime > cart.getTtl()) {
				cartService.deleteCart(entry.getKey());
			}
		}
	}

}
