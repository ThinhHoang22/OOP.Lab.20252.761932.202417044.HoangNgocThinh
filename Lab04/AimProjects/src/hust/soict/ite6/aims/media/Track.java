package hust.soict.ite6.aims.media;


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
    public void play() {
        if (length <= 0) {
            System.out.println("Cannot play this track.");
            return;
        }

        System.out.println("Playing track: " + title);
        System.out.println("Track length: " + length);
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
}
