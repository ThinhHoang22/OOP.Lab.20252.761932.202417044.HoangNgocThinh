package hust.soict.ite6.aims.screen;

import hust.soict.ite6.aims.media.DigitalVideoDisc;
import hust.soict.ite6.aims.cart.Cart.*;
import hust.soict.ite6.aims.store.Store.*;
import java.awt.*;
import javax.swing.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {

    public AddDigitalVideoDiscToStoreScreen(Store store, Cart cart, Runnable onStoreChanged) {
        super(store, cart, onStoreChanged);
        setTitle("Add DVD");
    }

    @Override
    protected JPanel createForm() {
        JPanel panel = new JPanel(new GridLayout(7, 2, 5, 5));

        JTextField tfId = new JTextField();
        JTextField tfTitle = new JTextField();
        JTextField tfCategory = new JTextField();
        JTextField tfDirector = new JTextField();
        JTextField tfLength = new JTextField();
        JTextField tfCost = new JTextField();

        panel.add(new JLabel("ID:")); panel.add(tfId);
        panel.add(new JLabel("Title:")); panel.add(tfTitle);
        panel.add(new JLabel("Category:")); panel.add(tfCategory);
        panel.add(new JLabel("Director:")); panel.add(tfDirector);
        panel.add(new JLabel("Length:")); panel.add(tfLength);
        panel.add(new JLabel("Cost:")); panel.add(tfCost);

        JButton btnAdd = new JButton("Add DVD");
        panel.add(btnAdd);

        btnAdd.addActionListener(e -> {
                try {
                String title = tfTitle.getText().trim();
                String category = tfCategory.getText().trim();
                String director = tfDirector.getText().trim();
                int length = Integer.parseInt(tfLength.getText().trim());
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
                
                DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
                    store.addMedia(dvd);
                    dispose(); 
                    new StoreScreen(store, cart);
                    System.out.println("AddDigitalVideoDiscToStoreScreen: added DVD: " + dvd.getTitle());
                    JOptionPane.showMessageDialog(this, "DVD added: " + title);
                    if (onStoreChanged != null) SwingUtilities.invokeLater(onStoreChanged);
            } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Invalid input, item not added: " + ex.getMessage());
            }
        });

        return panel;
    }
}