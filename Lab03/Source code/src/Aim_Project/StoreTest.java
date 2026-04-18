package Aim_Project;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Lion King");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("SnowWhite");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Star Wars");
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Hopper");

        // add
        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);
        store.addDVD(dvd4);

        // remove
        store.removeDVD(dvd2);
    }
}