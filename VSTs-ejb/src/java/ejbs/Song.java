package ejbs;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author zuzu
 */
public class Song {
    
    private String name;
    private int duration;
    
    public Song(){
    }
    
    public Song(String name){
        this.name = name;
        //this.duration = duration;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public int getDuration(){
        return duration;
    }
    
    public void setDuration(int duration){
        this.duration = duration;
    }
    
    @Override
    public String toString(){
        return name;
    }
}
