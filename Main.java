package com.company;

import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Playlist playlist = new Playlist("My playlist");
        Album album1 = new Album("Album", "Me");
        album1.addSong("Gipsy", 3.24);
        album1.addSong("Humpback Whale", 3.25);
        album1.addSong("Champaign", 2.15);
        album1.addSong("Weak one", 1.45);

        Album album2 = new Album("Caboose", "Him");
        album2.addSong("Great", 5.21);
        album2.addSong("Freaky guy", 3.59);
        album2.addSong("Trumanshow", 2.25);
        album2.addSong("Jump highly", 4.15);
        album2.addSong("WTF", 2.37);
        System.out.println();


        playlist.setPlaylist(album1);
        playlist.setPlaylist(album2);

        System.out.println();

        playlist.playlistMenu();
    }

}
