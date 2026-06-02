package hust.soict.ite6.aims;

import hust.soict.ite6.aims.cart.Cart.Cart;
import hust.soict.ite6.aims.store.Store.Store;
import hust.soict.ite6.aims.media.*;
import hust.soict.ite6.aims.screen.StoreScreen;
import hust.soict.ite6.aims.exception.*;
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.io.OutputStream;
import java.io.PrintStream;

public class Aims {

    private static Store store = new Store();
    private static Cart cart = new Cart();

    public static void main(String[] args) {
        System.setOut(new PrintStream(OutputStream.nullOutputStream()));
        initSampleData();  // Sample items

        new StoreScreen(store, cart);
    }

    // ========================================================================
    // SAMPLE DATA
    // ========================================================================

    private static void initSampleData() {
        Book b1 = new Book(1, "Sherlock Holmes", "Detective", 15.5f);
        b1.addAuthor("Arthur Conan Doyle");

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(
                2, "The Lion King", "Animation", "Roger Allers", 87, 19.95f);

        CompactDisc cd1 = new CompactDisc(
                3, "Greatest Hits", "Music", 12.99f, "Producer X", "Artist A");
        cd1.addTrack(new Track("Track 1", 4));
        cd1.addTrack(new Track("Track 2", 3));
            
        Book b2 = new Book(4, "Snowfall", "Romance", 10.0f);

        CompactDisc cd2 = new CompactDisc(
                5, "Sommmarfagel", "Music", 14.99f, "None", "Wintergartan");
        cd2.addTrack(new Track("Sommarfagel", 5));
        cd2.addTrack(new Track("Vinter", 6));
        cd2.addTrack(new Track("Höst", 4));

        DigitalVideoDisc dvd2 = new DigitalVideoDisc(
                6, "Avengers: Endgame", "Action", "Anthony Russo", 181, 24.99f);

        Book b3 = new Book(7, "The Great Gatsby", "Classic", 8.75f);
        b3.addAuthor("F. Scott Fitzgerald");

        Book b4 = new Book(8, "Ghost in the Shell", "Sci-Fi", 11.0f);
        b4.addAuthor("Masamune Shirow");
        
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(
                9, "Inception", "Sci-Fi", "Christopher Nolan", 148, 21.99f);

        try {
            store.addMedia(b1);
        } catch (InvalidDataException ex) {
            System.out.println("Failed to add to store: " + ex.getMessage());
        }
        try {
            store.addMedia(dvd1);
        } catch (InvalidDataException ex) {
            System.out.println("Failed to add to store: " + ex.getMessage());
        }
        try {
            store.addMedia(cd1);
        } catch (InvalidDataException ex) {
            System.out.println("Failed to add to store: " + ex.getMessage());
        }

        try {
            store.addMedia(b2);
        } catch (InvalidDataException ex) {
            System.out.println("Failed to add to store: " + ex.getMessage());
        }

        try {
            store.addMedia(cd2);
        } catch (InvalidDataException ex) {
            System.out.println("Failed to add to store: " + ex.getMessage());
        }

        try {
            store.addMedia(dvd2);
        } catch (InvalidDataException ex) {
            System.out.println("Failed to add to store: " + ex.getMessage());
        }

        try {
            store.addMedia(b3);
        } catch (InvalidDataException ex) {
            System.out.println("Failed to add to store: " + ex.getMessage());
        }

        try {
            store.addMedia(b4);
        } catch (InvalidDataException ex) {
            System.out.println("Failed to add to store: " + ex.getMessage());
        }

        try {
            store.addMedia(dvd3);
        } catch (InvalidDataException ex) {
            System.out.println("Failed to add to store: " + ex.getMessage());
        }
    }
}