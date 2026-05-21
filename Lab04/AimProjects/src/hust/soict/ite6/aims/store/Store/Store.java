package hust.soict.ite6.aims.store.Store;

import hust.soict.ite6.aims.media.Media;

import java.util.ArrayList;


public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<>();

    public void addMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println("Media added to store.");
        } else {
            System.out.println("Media already exists in store.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("Media removed from store.");
        } else {
            System.out.println("Media does not exist in store.");
        }
    }

    public void printStore() {
        for (Media media : itemsInStore) {
            System.out.println(media);
        }
    }

    public Media searchByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }
}
