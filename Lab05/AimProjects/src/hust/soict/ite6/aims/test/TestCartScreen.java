package hust.soict.ite6.aims.test;
import hust.soict.ite6.aims.cart.Cart.Cart;
import hust.soict.ite6.aims.screen.*;
import hust.soict.ite6.aims.store.Store.Store;
import hust.soict.ite6.aims.media.*;


public class TestCartScreen {
    public static void main(String[] args) {
        Cart cart = new Cart();
        Store store = new Store();

      
        DigitalVideoDisc dvd = new DigitalVideoDisc(
                "Mat Biec",
                "Romance",
                "Victor Vu",
                117,
                19.95f
        );
        
        DigitalVideoDisc errordvd = new DigitalVideoDisc(
                "DVD Loi",
                "Category",
                "Director",
                -5,
                19.95f
        );


        CompactDisc cd = new CompactDisc(
                2,
                "Trinh Cong Son Collection",
                "Music",
                15.99f,
                60,
                "Various Artists",
                "Trinh Cong Son"
        );

        cd.addTrack(new Track("Noi Vong Tay Lon", 5));
        cd.addTrack(new Track("Cat Bui", 4));
        cd.addTrack(new Track("Diem Xua", 6));

        CompactDisc cdLoi = new CompactDisc(
                5,
                "CD Loi Track",
                "Music",
                10.0f,
                30,
                "Unknown",
                "Unknown"
        );
        
        
        Book book = new Book(
                3,
                "De Men Phieu Luu Ky",
                "Literature",
                12.50f
        );
        
       
     
        cart.addMedia(dvd);
        cart.addMedia(errordvd);
        cart.addMedia(cd);
        cart.addMedia(cdLoi);
        cart.addMedia(book);
        
        new CartScreen(store, cart);
    }
}