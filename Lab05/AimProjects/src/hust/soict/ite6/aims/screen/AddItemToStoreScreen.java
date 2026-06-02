package hust.soict.ite6.aims.screen;

import hust.soict.ite6.aims.cart.Cart.*;
import hust.soict.ite6.aims.store.Store.*;
import java.awt.*;
import javax.swing.*;

public abstract class AddItemToStoreScreen extends JFrame {
    protected final Store store;
    protected final Cart cart;
    protected final Runnable onStoreChanged;
    protected Runnable onViewStore;
    protected Runnable onViewCart;

    public AddItemToStoreScreen(Store store, Cart cart, Runnable onStoreChanged) {
        this.store = store;
        this.cart = cart;
        this.onStoreChanged = onStoreChanged;

        setTitle("Add Item to Store");
        setSize(500, 300);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Menu bar matches the StoreScreen
        setJMenuBar(createMenuBar());

        add(createForm(), BorderLayout.CENTER);
        setVisible(true);
    }

    public void setOnViewStore(Runnable onViewStore) {
        this.onViewStore = onViewStore;
    }

    public void setOnViewCart(Runnable onViewCart) {
        this.onViewCart = onViewCart;
    }

    protected JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem miAddBook = new JMenuItem("Add Book");
        JMenuItem miAddCd = new JMenuItem("Add CD");
        JMenuItem miAddDvd = new JMenuItem("Add DVD");

        smUpdateStore.add(miAddBook);
        smUpdateStore.add(miAddCd);
        smUpdateStore.add(miAddDvd);

        menu.add(smUpdateStore);

        JMenuItem miViewStore = new JMenuItem("View store");
        JMenuItem miViewCart = new JMenuItem("View cart");
        menu.add(miViewStore);
        menu.add(miViewCart);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        // Action handlers - prefer host callbacks when provided
        miViewStore.addActionListener(e -> {
            if (onViewStore != null) {
                onViewStore.run();
                this.dispose();
            } else {
                new StoreScreen(store, cart);
                this.dispose();
            }
        });
        miViewCart.addActionListener(e -> {
            if (onViewCart != null) {
                onViewCart.run();
                this.dispose();
            } else {
                new CartScreen(store, cart);
            }
        });
        miAddBook.addActionListener(e -> {
            AddBookToStoreScreen s = new AddBookToStoreScreen(store, cart, onStoreChanged);
            s.setOnViewStore(onViewStore);
            s.setOnViewCart(onViewCart);
            this.dispose();
        });
        miAddCd.addActionListener(e -> {
            AddCompactDiscToStoreScreen s = new AddCompactDiscToStoreScreen(store, cart, onStoreChanged);
            s.setOnViewStore(onViewStore);
            s.setOnViewCart(onViewCart);
            this.dispose();
        });
        miAddDvd.addActionListener(e -> {
            AddDigitalVideoDiscToStoreScreen s = new AddDigitalVideoDiscToStoreScreen(store, cart, onStoreChanged);
            s.setOnViewStore(onViewStore);
            s.setOnViewCart(onViewCart);
            this.dispose();
        });

        return menuBar;
    }

    protected abstract JPanel createForm();
}