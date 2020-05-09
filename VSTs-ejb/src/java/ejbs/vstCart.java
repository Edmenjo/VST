/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;

/**
 *
 * @author zuzu
 */
@Stateful
public class vstCart implements vstCartLocal {

    ArrayList<Song> products = new ArrayList();
    
    public void addProduct(Song product) {
        products.add(product);
    }

    public ArrayList<Song> getProducts() {
        return products;
    }

    @Remove
    public void remove() {
        System.out.println("Cart::remove - @Remove del Stateful");
    }

    @PostConstruct
    public void init() {
        System.out.println("Cart::init - @Init del Stateful");
    }
    
    @PreDestroy
    public void destroy() {
        System.out.println("Cart::destroy - @Destroy del Stateful");
    }
    
    @PostActivate
    public void postActivate() {
        System.out.println("Cart::postActivate - @PostActivate del Stateful");
    }
    
    @PrePassivate
    public void prePassivate() {
        System.out.println("Cart::prePassivate - @Remove del Stateful");
    }
}
