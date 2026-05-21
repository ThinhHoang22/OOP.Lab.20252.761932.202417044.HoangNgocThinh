package hust.soict.ite6.aims.store.Store;

import hust.soict.ite6.aims.disc.DigitalVideoDisc.DigitalVideoDisc;

public class Store {
	private DigitalVideoDisc[] itemsInStore;
    private int qtyInStore=0;
    public static final int MAX_ITEMS = 100;

    public Store() {
        itemsInStore = new DigitalVideoDisc[MAX_ITEMS];
        qtyInStore = 0;
    }
    
    // add
    public void addDVD(DigitalVideoDisc dvd){
    	if(qtyInStore >= MAX_ITEMS) {
    		System.out.println("The store is full!");
            return;
    	}
    	itemsInStore[qtyInStore] = dvd;
        qtyInStore++;
        System.out.println("The DVD has been added to the store");
    }
    
    
    // remove
    public void removeDVD(DigitalVideoDisc dvd) {
    	int find = -1;
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i] == dvd) {
                find = i;
                break;
            }
        }

        if (find == -1) {
            System.out.println("The DVD does not exist!");
            return;
        }

        for (int i = find; i < qtyInStore - 1; i++) {
            itemsInStore[i] = itemsInStore[i + 1];
        }

        itemsInStore[qtyInStore - 1] = null;
        qtyInStore--;

        System.out.println("The DVD has been removed from the store");
    }

}
