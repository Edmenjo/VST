/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author zuzu
 */
@Stateless
@LocalBean
public class VST {

    private String name;
    
    public VST(){
    }
    
    public VST(String name){
        this.name = name;
        //this.duration = duration;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    @Override
    public String toString(){
        return name;
    }

    @PostConstruct
    public void init() {
        System.out.println("VST::init() - @PostConstruct");
    }
    
    @PreDestroy
    public void destroy(){
        System.out.println("VST::destroy() - @PreDestroy");
    }
}
