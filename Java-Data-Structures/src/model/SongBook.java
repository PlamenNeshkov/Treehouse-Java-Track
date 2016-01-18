package model;

import java.io.*;
import java.util.*;

public class SongBook {
    private List<Song> mSongs;

    public SongBook() {
        mSongs = new ArrayList<>();
    }

    public void exportTo(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(filename))) {
            for (Song song : mSongs) {
                writer.printf("%s|%s|%s%n",
                        song.getArtist(),
                        song.getTitle(),
                        song.getVideoUrl());
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void importFrom(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] args = line.split("\\|");
                addSong(new Song(args[0], args[1], args[2]));
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void addSong(Song song) {
        mSongs.add(song);
    }

    public int getSongCount() {
        return mSongs.size();
    }

    // FIXME: Should be cached
    private Map<String, List<Song>> byArtist() {
        Map<String, List<Song>> byArtist = new TreeMap<>();

        for (Song song : mSongs) {
            List<Song> artistSongs = byArtist.get(song.getArtist());

            if (artistSongs == null) {
                artistSongs = new ArrayList<>();
                byArtist.put(song.getArtist(), artistSongs);
            }

            artistSongs.add(song);
        }

        return byArtist;
    }

    public Set<String> getArtists() {
        return byArtist().keySet();
    }

    public List<Song> getSongsForArtist(String artistName) {
        List<Song> songs = byArtist().get(artistName);
        songs.sort(new Comparator<Song>() {
            @Override
            public int compare(Song song1, Song song2) {
                if (song1.equals(song2)) {
                    return 0;
                }
                return song1.mTitle.compareTo(song2.mTitle);
            }
        });
        return songs;
    }
}
