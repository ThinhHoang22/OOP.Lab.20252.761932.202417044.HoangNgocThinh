package hust.soict.ite6.test.store.StoreTest;

import hust.soict.ite6.aims.disc.DigitalVideoDisc.DigitalVideoDisc;
import hust.soict.ite6.aims.store.Store.Store;

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