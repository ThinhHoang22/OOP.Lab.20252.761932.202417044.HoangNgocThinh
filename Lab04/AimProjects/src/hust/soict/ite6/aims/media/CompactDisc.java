package hust.soict.ite6.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();
    
    public CompactDisc(int id, String title, String category, float cost,
                       int length, String director, String artist) {
        super(id, title, category, cost, length, director);
        this.artist = artist;
    }
    
    public CompactDisc() {
        super();
    }
    
    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Track added.");
        } else {
            System.out.println("Track already exists.");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track removed.");
        } else {
            System.out.println("Track does not exist.");
        }
    }

    @Override
    public int getLength() {
        int total = 0;
        for (Track track : tracks) {
            total += track.getLength();
        }
        return total;
    }

    @Override
    public void play() {
        if (getLength() <= 0) {
            System.out.println("Cannot play this CD.");
            return;
        }

        System.out.println("Playing CD: " + getTitle());
        System.out.println("CD length: " + getLength());

        for (Track track : tracks) {
            track.play();
        }
    }

    @Override
    public String toString() {
        return "CD - " + getTitle() + " - " + getCategory()
                + " - Artist: " + artist
                + " - Director: " + getDirector()
                + " - Length: " + getLength()
                + " - Cost: " + getCost();
    }
}