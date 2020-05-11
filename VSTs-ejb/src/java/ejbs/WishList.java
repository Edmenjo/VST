/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateful;
import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;

/**
 *
 * @author zuzu
 */
@Stateful
@LocalBean
public class WishList {
    ArrayList<VST> products = new ArrayList();
    
    public void addProduct(VST product) {
        products.add(product);
    }

    public ArrayList<VST> getProducts() {
        return products;
    }
    
    @Remove
    public void remove() {
        System.out.println("WishList::remove - @Remove del Stateful");
    }
    
    @PostConstruct
    public void init() {
        System.out.println("WishList::init - @Init del Stateful");
    }
    
    @PreDestroy
    public void destroy() {
        System.out.println("WishList::destroy - @Destroy del Stateful");
    }
    
    @PostActivate
    public void postActivate() {
        System.out.println("WishList::postActivate - @PostActivate del Stateful");
    }
    
    @PrePassivate
    public void prePassivate() {
        System.out.println("WishList::prePassivate - @Remove del Stateful");
    }
}
