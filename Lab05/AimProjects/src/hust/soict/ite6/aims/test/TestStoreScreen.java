package hust.soict.ite6.aims.test;

import hust.soict.ite6.aims.cart.Cart.Cart;
import hust.soict.ite6.aims.media.*;
import hust.soict.ite6.aims.store.Store.Store;
import hust.soict.ite6.aims.screen.*;

public class TestStoreScreen {
    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();

        store.addMedia(new DigitalVideoDisc(
                "Mat Biec",
                "Romance",
                "Victor Vu",
                117,
                19.95f
        ));

        store.addMedia(new CompactDisc(
                2,
                "Trinh Cong Son Collection",
                "Music",
                15.99f,
                60,
                "Various Artists",
                "Trinh Cong Son"
        ));

        store.addMedia(new Book(
                3,
                "De Men Phieu Luu Ky",
                "Literature",
                12.50f
        ));

        new StoreScreen(store, cart);
    }
}