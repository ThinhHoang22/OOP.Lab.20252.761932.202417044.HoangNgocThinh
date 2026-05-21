package hust.soict.ite6.aims;

import hust.soict.ite6.aims.cart.Cart.Cart;
import hust.soict.ite6.aims.store.Store.Store;
import hust.soict.ite6.aims.media.*;

import java.util.Scanner;

public class Aims {

    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initSampleData();

        int choice = -1;

        while (choice != 0) {
            showMenu();
            choice = readInt("Please choose a number: 0-1-2-3: ");

            switch (choice) {
                case 1 -> viewStore();
                case 2 -> updateStore();
                case 3 -> viewCart();
                case 0 -> System.out.println("Exiting AIMS...");
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    // sample data
    private static void initSampleData() {
        Book b1 = new Book(1, "Sherlock Holmes", "Detective", 15.5f);
        b1.addAuthor("Arthur Conan Doyle");

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(
                2, "The Lion King", "Animation", 19.95f, 87, "Roger Allers"
        );

        CompactDisc cd1 = new CompactDisc(
                3, "Greatest Hits", "Music", 12.99f, 62, "Producer X", "Artist A"
        );
        cd1.addTrack(new Track("Track 1", 4));
        cd1.addTrack(new Track("Track 2", 3));

        store.addMedia(b1);
        store.addMedia(dvd1);
        store.addMedia(cd1);
    }

    // main menu
    public static void showMenu() {
        System.out.println("""
                
                AIMS:
                ------------------------------
                1. View store
                2. Update store
                3. See current cart
                0. Exit
                ------------------------------
                """);
    }

    // store view
    public static void viewStore() {
        int choice = -1;

        while (choice != 0) {
            System.out.println("\n===== STORE =====");
            store.printStore();

            storeMenu();
            choice = readInt("Please choose a number: 0-1-2-3-4: ");

            switch (choice) {
                case 1 -> seeMediaDetails();
                case 2 -> addMediaToCart();
                case 3 -> playMediaInStore();
                case 4 -> viewCart();
                case 0 -> System.out.println("Back to main menu...");
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    public static void storeMenu() {
        System.out.println("""
                
                Options:
                ------------------------------
                1. See a media's details
                2. Add a media to cart
                3. Play a media
                4. See current cart
                0. Back
                ------------------------------
                """);
    }

    // media detail menu
    public static void seeMediaDetails() {
        String title = readString("Enter media title: ");
        Media media = store.searchByTitle(title);

        if (media == null) {
            System.out.println("Media not found!");
            return;
        }

        int choice = -1;

        while (choice != 0) {
            System.out.println("\n=== MEDIA DETAILS ===");
            System.out.println(media.toString());

            mediaDetailsMenu();
            choice = readInt("Please choose a number: 0-1-2: ");

            switch (choice) {
                case 1 -> cart.addMedia(media);
                case 2 -> {
                    if (media instanceof Playable playable) {
                        playable.play();
                    } else {
                        System.out.println("This media cannot be played!");
                    }
                }
                case 0 -> System.out.println("Back to store menu...");
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    public static void mediaDetailsMenu() {
        System.out.println("""
                
                Options:
                ------------------------------
                1. Add to cart
                2. Play
                0. Back
                ------------------------------
                """);
    }

    // cart view
    public static void viewCart() {
        int choice = -1;

        while (choice != 0) {
            System.out.println("\n===== CART =====");
            cart.printCart();

            cartMenu();
            choice = readInt("Please choose a number: 0-1-2-3-4-5: ");

            switch (choice) {
                case 1 -> filterCart();
                case 2 -> sortCart();
                case 3 -> removeFromCart();
                case 4 -> playFromCart();
                case 5 -> placeOrder();
                case 0 -> System.out.println("Back to previous menu...");
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    public static void cartMenu() {
        System.out.println("""
                
                Options:
                ------------------------------
                1. Filter medias in cart
                2. Sort medias in cart
                3. Remove media from cart
                4. Play a media
                5. Place order
                0. Back
                ------------------------------
                """);
    }

    // filter cart
    public static void filterCart() {
        System.out.println("""
                
                Filter options:
                1. Filter by ID
                2. Filter by title
                """);

        int choice = readInt("Your choice: ");

        switch (choice) {
            case 1 -> {
                int id = readInt("Enter ID: ");
                cart.filterById(id);
            }
            case 2 -> {
                String title = readString("Enter title: ");
                cart.filterByTitle(title);
            }
            default -> System.out.println("Invalid choice!");
        }
    }

    // sort cart
    public static void sortCart() {
        System.out.println("""
                
                Sort options:
                1. Sort by title
                2. Sort by cost
                """);

        int choice = readInt("Your choice: ");

        switch (choice) {
            case 1 -> {
                cart.sortByTitleCost();
                System.out.println("Cart sorted by title.");
                cart.printCart();
            }
            case 2 -> {
                cart.sortByCostTitle();
                System.out.println("Cart sorted by cost.");
                cart.printCart();
            }
            default -> System.out.println("Invalid choice!");
        }
    }

    // remove from cart
    public static void removeFromCart() {
        String title = readString("Enter media title to remove: ");
        Media media = cart.searchByTitle(title);

        if (media != null) {
            cart.removeMedia(media);
        } else {
            System.out.println("Media not found in cart!");
        }
    }

    // play from cart
    public static void playFromCart() {
        String title = readString("Enter media title: ");
        Media media = cart.searchByTitle(title);

        if (media == null) {
            System.out.println("Media not found in cart!");
        } else if (media instanceof Playable playable) {
            playable.play();
        } else {
            System.out.println("This media cannot be played!");
        }
    }

    // place order
    public static void placeOrder() {
        int itemCount = cart.getItemCount();

        if (itemCount == 0) {
            System.out.println("Your cart is empty. Nothing to order.");
            return;
        }

        System.out.println("You have " + itemCount + " item(s) in your order.");
        String confirm = readString("Do you want to proceed? (y/n): ");

        if (confirm.equalsIgnoreCase("y")) {
            System.out.println("Order placed successfully!");
            cart.clearCart();
            System.out.println("Thank you for shopping!");
        } else {
            System.out.println("Order cancelled. Your cart is unchanged.");
        }
    }

    // update store
    public static void updateStore() {
        System.out.println("""
                
                Update Store:
                ------------------------------
                1. Add media to store
                2. Remove media from store
                0. Back
                ------------------------------
                """);

        int choice = readInt("Your choice: ");

        switch (choice) {
            case 1 -> addMediaToStore();
            case 2 -> removeMediaFromStore();
            case 0 -> System.out.println("Back to main menu...");
            default -> System.out.println("Invalid choice!");
        }
    }

    // add media to store
    public static void addMediaToStore() {
        System.out.println("""
                
                What type of media?
                1. Book
                2. DVD
                3. CD
                0. Back
                """);

        int choice = readInt("Your choice: ");

        switch (choice) {
            case 1 -> createBook();
            case 2 -> createDVD();
            case 3 -> createCD();
            case 0 -> System.out.println("Back to update store menu...");
            default -> System.out.println("Invalid choice!");
        }
    }

    // book input
    public static void createBook() {
        int id = readInt("ID: ");
        String title = readString("Title: ");
        String category = readString("Category: ");
        float cost = readFloat("Cost: ");

        Book book = new Book(id, title, category, cost);

        while (true) {
            String ans = readString("Add author? (y/n): ");

            if (ans.equalsIgnoreCase("y")) {
                String authorName = readString("Author name: ");
                book.addAuthor(authorName);
            } else {
                break;
            }
        }

        store.addMedia(book);
    }

    // DVD input
    public static void createDVD() {
        int id = readInt("ID: ");
        String title = readString("Title: ");
        String category = readString("Category: ");
        String director = readString("Director: ");
        int length = readInt("Length: ");
        float cost = readFloat("Cost: ");

        DigitalVideoDisc dvd = new DigitalVideoDisc(
                id, title, category, cost, length, director
        );

        store.addMedia(dvd);
    }

    // CD input
    public static void createCD() {
        int id = readInt("ID: ");
        String title = readString("Title: ");
        String category = readString("Category: ");
        String director = readString("Director: ");
        String artist = readString("Artist: ");
        float cost = readFloat("Cost: ");
        int len = readInt("Length");

        CompactDisc cd = new CompactDisc( id, title, category, cost, len, director, artist);

        while (true) {
            String ans = readString("Add track? (y/n): ");

            if (!ans.equalsIgnoreCase("y")) {
                break;
            }

            String trackTitle = readString("Track title: ");
            int trackLength = readInt("Track length: ");

            cd.addTrack(new Track(trackTitle, trackLength));
        }

        store.addMedia(cd);
    }

    // remove media from store
    public static void removeMediaFromStore() {
        String title = readString("Enter title to remove: ");
        Media media = store.searchByTitle(title);

        if (media != null) {
            store.removeMedia(media);
        } else {
            System.out.println("Media not found in store!");
        }
    }

    // add media from store to cart
    public static void addMediaToCart() {
        String title = readString("Enter title: ");
        Media media = store.searchByTitle(title);

        if (media != null) {
            cart.addMedia(media);
        } else {
            System.out.println("Media not found in store!");
        }
    }

    // play media in store
    public static void playMediaInStore() {
        String title = readString("Enter title: ");
        Media media = store.searchByTitle(title);

        if (media == null) {
            System.out.println("Media not found in store!");
        } else if (media instanceof Playable playable) {
            playable.play();
        } else {
            System.out.println("This media cannot be played!");
        }
    }

    // input helper
    private static int readInt(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number! Please enter an integer.");
            }
        }
    }

    private static float readFloat(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Float.parseFloat(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number! Please enter a float number.");
            }
        }
    }

    private static String readString(String msg) {
        System.out.print(msg);
        return scanner.nextLine();
    }
}