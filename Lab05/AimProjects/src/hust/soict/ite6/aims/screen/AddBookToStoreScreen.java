package hust.soict.ite6.aims.screen;

import hust.soict.ite6.aims.media.Book;
import hust.soict.ite6.aims.cart.Cart.Cart;
import hust.soict.ite6.aims.store.Store.Store;

import java.awt.*;
import javax.swing.*;

public class AddBookToStoreScreen extends AddItemToStoreScreen {

    public AddBookToStoreScreen(Store store, Cart cart, Runnable onStoreChanged) {
        super(store, cart, onStoreChanged);
        setTitle("Add Book");
    }

    @Override
    protected JPanel createForm() {
        JPanel panel = new JPanel(new GridLayout(6,2,10,10));

        JTextField tfId = new JTextField();
        JTextField tfTitle = new JTextField();
        JTextField tfCategory = new JTextField();
        JTextField tfAuthor = new JTextField();
        JTextField tfCost = new JTextField();

        panel.add(new JLabel("ID:")); panel.add(tfId);
        panel.add(new JLabel("Title:")); panel.add(tfTitle);
        panel.add(new JLabel("Category:")); panel.add(tfCategory);
        panel.add(new JLabel("Author:")); panel.add(tfAuthor);
        panel.add(new JLabel("Cost:")); panel.add(tfCost);

        JButton btnAdd = new JButton("Add Book");
        panel.add(btnAdd);

        btnAdd.addActionListener(e -> {
                try {
                int id = Integer.parseInt(tfId.getText().trim());
                String title = tfTitle.getText().trim();
                String category = tfCategory.getText().trim();
                String author = tfAuthor.getText().trim();
                float cost = Float.parseFloat(tfCost.getText().trim());
                
                if (cost < 0) {
                    JOptionPane.showMessageDialog(
                            this,
                            "Cost must be greater than or equal to 0!",
                            "Invalid Cost",
                            JOptionPane.ERROR_MESSAGE
                    );
                    return;
                }
                
                Book b = new Book(
                	    Integer.parseInt(tfId.getText()),
                	    tfTitle.getText(),
                	    tfCategory.getText(),
                	    Float.parseFloat(tfCost.getText())
                	);

                	if (!tfAuthor.getText().trim().isEmpty()) {
                	    b.addAuthor(tfAuthor.getText().trim());
                	}
                    store.addMedia(b);
                    dispose(); 
                    new StoreScreen(store, cart);
                    
                    System.out.println("AddBookToStoreScreen: added Book: " + b.getTitle());
                    JOptionPane.showMessageDialog(this, "Book added: " + title);
                    if (onStoreChanged != null) SwingUtilities.invokeLater(onStoreChanged);
            } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Invalid input, item not added: " + ex.getMessage());
            }
        });

        return panel;
    }
}