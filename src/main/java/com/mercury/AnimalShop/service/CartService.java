package com.mercury.AnimalShop.service;

import java.util.List;

import com.mercury.AnimalShop.bean.Cart;
import com.mercury.AnimalShop.dao.CartDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {


    @Autowired
    private CartDao cartDao;

    public void save(Cart cart) {
        List<Cart> carts=cartDao.findByUserId(cart.getUserId());
        for(Cart item : carts) {
//            System.out.println(item.getProduct());
//            System.out.println(cart.getProduct());
            if(item.getProduct().getId()==cart.getProduct().getId()){
                item.setQty(item.getQty()+cart.getQty());
                cartDao.save(item);
                return;
            }
        }
        cartDao.save(cart);
    }

    public void update(Cart cart) {
        cartDao.save(cart);
    }


    public List<Cart> getByUserId(long id){
        return cartDao.findByUserId(id);
    }

    public void deleteById(long id) {
        cartDao.deleteById(id);
    }

}
