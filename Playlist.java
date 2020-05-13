package com.company;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Playlist {
    private String name;
    private LinkedList<Song> playlist;
    private Scanner scanner = new Scanner(System.in);

    public Playlist(String name) {
        this.name = name;
        this.playlist = new LinkedList<Song>();
    }

    public void playlistMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean next = true;
        ListIterator<Song> listIterator = this.playlist.listIterator();

        printPlaylistMenu();
        if(this.playlist.isEmpty()) {
            System.out.println("No songs to play");
        } else {
            System.out.println("Now listening " + listIterator.next());
        }

        while(!quit) {
            System.out.println("Enter your action:\r");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch(action) {
                case 0:
                    printPlaylistMenu();
                    break;

                case 1:
                    if(!next) {
                        if(listIterator.hasNext()) {
                            listIterator.next();
                        }
                        next = true;
                    }

                    if(listIterator.hasNext()) {
                        System.out.println("Now listening " + listIterator.next());
                    } else {
                        System.out.println("You are at the end of the playlist");
                        next = false;
                    }
                    break;

                case 2:
                    if(next) {
                        if(listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        next = false;
                    }

                    if(listIterator.hasPrevious()) {
                        System.out.println("Now listening " + listIterator.previous());
                    } else {
                        System.out.println("You are at the beginning of the playlist");
                        next = true;
                    }
                    break;

                case 3:
                    if(next) {
                        if(listIterator.hasPrevious()) {
                            System.out.println("Now replaying " + listIterator.previous());
                            listIterator.next();
                        } else {
                            System.out.println("Can't repeat.");
                        }
                    } else {
                        if(listIterator.hasNext()) {
                            System.out.println("Now replaying " + listIterator.next());
                            listIterator.previous();
                        } else {
                            System.out.println("Can't repeat.");
                        }
                    }
                    break;

                case 4:
                    if(next) {
                        if(listIterator.hasPrevious()) {
                            System.out.println("Removed " + listIterator.previous());
                            listIterator.remove();
                        } else {
                            System.out.println("Can't remove.");
                        }
                    } else {
                        if(listIterator.hasNext()) {
                            System.out.println("Removed " + listIterator.next());
                            listIterator.remove();
                        } else {
                            System.out.println("Can't remove.");
                        }
                    }
                    break;

                case 5:
                    printPlayList();
                    break;

                case 6:
                    quit = true;
                    break;
            }
        }
    }

    public void setPlaylist(Album album) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        int i = 0;
        int choice;
        printAddingMenu();
        while(i < album.getSongs().size() && !quit) {
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 0:
                    album.printAlbum();
                    break;
                case 1:
                    addPlaylistSong(album);
                    break;
                case 2:
                    printAddingMenu();
                    break;
                case 3:
                    quit = true;
                    break;
            }

        }
    }

    private void printPlayList() {
        Iterator<Song> iterator = this.playlist.iterator();

        int i = 1;
        while(iterator.hasNext()) {
            System.out.println(i + ". " + iterator.next());
            i++;
        }
        System.out.println("==============================");
    }

    private void addPlaylistSong(Album album) {
        ListIterator<Song> songListIterator = this.playlist.listIterator();

        int i = 0;
        if(!this.playlist.isEmpty()) {
            while (songListIterator.hasNext()) {
                songListIterator.next();
            }
        }
        adding(i, album, songListIterator);
    }

    private boolean playlistHasSong(Song song) {
        ListIterator<Song> songListIterator = this.playlist.listIterator();

        while(songListIterator.hasNext()) {
            if(songListIterator.next().getTitle().equals(song.getTitle())) {
                System.out.println("This song is already in the playlist");
                return true;
            }
        }

        return false;
    }

    private void printAddingMenu() {
        System.out.println("0 - print album\n" +
                "1 - add song to the playlist\n" +
                "2 - print menu\n" +
                "3 - quit menu");
    }

    private void printPlaylistMenu() {
        System.out.println("0 - print menu\n" +
                        "1 - play next\n" +
                        "2 - play previous\n" +
                        "3 - repeat song\n" +
                        "4 - remove song from the playlist\n" +
                        "5 - show playlist\n" +
                        "6 - stop listening\n" +
                        "=======================");
    }

    private void adding(int index, Album album, ListIterator<Song> iterator) {
        int choice;
        while (index < album.getSongs().size()) {
            System.out.println("Enter song number you want to add (-1 to quit): ");
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == -1)
                break;
            else if(choice > album.getSongs().size())
                System.out.println("No such a song.");
            else if (!playlistHasSong(album.getSongs().get(choice - 1))) {
                iterator.add(album.getSongs().get(choice - 1));
                index++;
            }
        }
    }
}
