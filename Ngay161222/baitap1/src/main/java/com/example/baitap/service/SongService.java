package com.example.baitap.service;

import com.example.baitap.model.Song;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SongService {
    private static List<Song> songs = new ArrayList<Song>();
    private static long index;

    public List<Song> findAll(){
        return songs;
    }
    public Song findById(long id){
        for (Song song : songs){
            if(song.getId() == id){
                return song;
            }
        }
        return new Song();
    }
    public void save(Song song){
        if (song.getId() == 0){
            song.setId(++index);
            songs.add(song);
        }else {
            songs.set(songs.indexOf(findById(song.getId())),song);
        }
    }
    public void delete(Song song){
        songs.remove(findById(song.getId()));
    }

}
