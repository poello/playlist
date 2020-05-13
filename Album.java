package com.company;

import java.util.ArrayList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String title, String artist) {
        this.name = title;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.artist;
    }

    public boolean addSong(String title, double duration) {
        if(findSong(title) == null) {
            this.songs.add(new Song(title, duration));
            System.out.println(title + " song added.");
            return true;
        }

        System.out.println(title + " song is already in the " + this.name + " album");
        return false;
    }

    public void printAlbum() {
        for(int i = 0; i < this.songs.size(); i++) {
            System.out.println((i+1) + ". " + this.songs.get(i).toString());
        }
        System.out.println("-----------------------------");
    }

    private Song findSong(String title) {
        for(Song checkedSong: this.songs) {
            if(checkedSong.getTitle().equals(title)) {
                return checkedSong;
            }
        }
        return null;
    }
}
