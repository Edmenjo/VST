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
    private List<Song> playlist;
    private String res = "";
    
    public Playlist(){
        playlist = new ArrayList<>();
    }
    
    public List<Song> getPlaylist(){
        return playlist;
    }
    
    public void addSongToPlaylist(Song song){
        playlist.add(song);
    }
    
    
    @Override
    public String toString(){
        for(Song recorrer: playlist){
            res += recorrer.toString() + "<br>";
        }
        return res;
    }
}
