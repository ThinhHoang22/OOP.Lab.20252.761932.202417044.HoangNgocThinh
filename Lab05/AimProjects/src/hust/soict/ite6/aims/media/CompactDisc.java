package hust.soict.ite6.aims.media;

import java.util.ArrayList;
import hust.soict.ite6.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();
    
    public CompactDisc(String title, String category, float cost
                       , String director, String artist) {
        super(0, title, category, cost, 0 , director);
        this.artist = artist;
    }

    public CompactDisc(int id, String title, String category,
            float cost, int length, String director, String artist) {
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
    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            System.err.println("ERROR: CD length is non-positive!");
            throw new PlayerException("ERROR: CD length is non-positive!");
        }

        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD length: " + this.getLength());

        for (Track track : tracks) {
            try {
                track.play();
            } catch (PlayerException e) {
                throw e;
            }
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