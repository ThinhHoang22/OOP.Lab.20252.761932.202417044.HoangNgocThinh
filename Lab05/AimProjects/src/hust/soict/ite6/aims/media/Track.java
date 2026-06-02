package hust.soict.ite6.aims.media;

import hust.soict.ite6.aims.exception.PlayerException;

public class Track implements Playable {
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            System.err.println("ERROR: Track length is non-positive!");
            throw new PlayerException("ERROR: Track length is non-positive!");
        }

        System.out.println("Playing Track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Track)) {
            return false;
        }

        Track other = (Track) o;
        return this.title.equals(other.title)
                && this.length == other.length;
    }
    
    @Override
    public String toString() {
        return "Track - "
                + title + " - "
                + length;
    }

}
