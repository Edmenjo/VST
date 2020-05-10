package ejbs;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author zuzu
 */
public class Playlist {
    private List<VST> playlist;
    private String res = "";
    
    public Playlist(){
        playlist = new ArrayList<>();
    }
    
    public List<VST> getPlaylist(){
        return playlist;
    }
    
    public void addSongToPlaylist(VST song){
        playlist.add(song);
    }
    
    
    @Override
    public String toString(){
        for(VST recorrer: playlist){
            res += recorrer.toString() + "<br>";
        }
        return res;
    }
}
