package com.ecommerce.ecommerce.service;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;
import com.ecommerce.ecommerce.entity.Cart;
import com.ecommerce.ecommerce.entity.Product;

@Service
public class CartService {

    private final Map<Integer, Cart> carts = new ConcurrentHashMap<>();
    
	public Cart addProduct(int cartId, Product product) {
		Cart cart = carts.getOrDefault(cartId, new Cart());
		cart.setId(cartId);

		if (cart.getProducts() == null) {
            cart.setProducts(new ArrayList<>());
        }
		
		boolean productExist = false;
		for (Product p : cart.getProducts()) {
			if (p.getId()==product.getId()) {
				p.setAmount(p.getAmount() + product.getAmount());
				productExist = true;
				break;
			}

		}
        if (!productExist) {
            cart.getProducts().add(product);
        }
        
        // Establecer tiempo de vida al carrito
		cart.setTtl(System.currentTimeMillis() + (10 * 60 * 1000));
		
		carts.put(cartId, cart);
		return cart;
	}
	
	public Map<Integer, Cart> getCarts() {
        return carts;
    }

	public Cart getCart(int cartId) {
		return carts.get(cartId);
	}

	public void deleteCart(int cartId) {
		carts.remove(cartId);
	}

}
