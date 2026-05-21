package hust.soict.ite6.aims.cart.Cart;

import hust.soict.ite6.aims.media.Media;
import java.util.ArrayList;
import java.util.Collections;

public class Cart {
    private ArrayList<Media> itemsOrdered = new ArrayList<>();

    public void addMedia(Media media) {
        if (!itemsOrdered.contains(media)) {
            itemsOrdered.add(media);
            System.out.println("Media added to cart.");
        } else {
            System.out.println("Media already exists in cart.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("Media removed from cart.");
        } else {
            System.out.println("Media does not exist in cart.");
        }
    }

    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }
    
    public void printCart() {
    	System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (Media media : itemsOrdered) {
            System.out.println(media);
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");
    }
    
    public Media searchByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }
    
    public void filterById(int id) {
        System.out.println("Filter by ID = " + id);
        boolean found = false;

        for (Media m : itemsOrdered) {
            if (m.getId() == id) {
                System.out.println(m.toString());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No media with that ID found.");
        }
    }

    public void filterByTitle(String title) {
        System.out.println("Filter by title = " + title);
        boolean found = false;

        for (Media m : itemsOrdered) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                System.out.println(m.toString());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No media with that title found.");
        }
    }
    
    public void sortByTitleCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByCostTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }

    public int getItemCount() {
        return itemsOrdered.size();
    }

    public void clearCart() {
        itemsOrdered.clear();
    }
}