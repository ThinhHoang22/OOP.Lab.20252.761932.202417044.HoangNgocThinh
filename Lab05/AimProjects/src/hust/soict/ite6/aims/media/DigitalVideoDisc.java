package hust.soict.ite6.aims.media;

import hust.soict.ite6.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
	private static int nbDigitalVideoDiscs = 0;
	
	public DigitalVideoDisc(String title) {
        super(++nbDigitalVideoDiscs, title, null, 0f, 0, null);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost, 0, null);
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost, 0, director);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost, length, director);
    }

	
    @Override
    public String toString() {
        return "DVD - " + getTitle()
                + " - Category: " + getCategory()
                + " - Director: " + getDirector()
                + " - Length: " + getLength()
                + " - Cost: " + getCost() + " $";
    }

	@Override
	 public void play() throws PlayerException {
        if (getLength() > 0) {
            System.out.println("Playing DVD: " + getTitle());
            System.out.println("DVD length: " + getLength());
        } else {
            System.err.println("ERROR: DVD length is non-positive: " + getLength());
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }
    }
	

}
