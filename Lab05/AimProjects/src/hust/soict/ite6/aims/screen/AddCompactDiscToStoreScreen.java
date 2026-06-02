package hust.soict.ite6.aims.screen;


import hust.soict.ite6.aims.media.CompactDisc;
import hust.soict.ite6.aims.cart.Cart.*;
import hust.soict.ite6.aims.store.Store.*;
import java.awt.*;
import javax.swing.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {

    public AddCompactDiscToStoreScreen(Store store, Cart cart, Runnable onStoreChanged) {
        super(store, cart, onStoreChanged);
        setTitle("Add CD");
    }

    @Override
    protected JPanel createForm() {
        JPanel panel = new JPanel(new GridLayout(7, 2, 5, 5));

        JTextField tfId = new JTextField();
        JTextField tfTitle = new JTextField();
        JTextField tfCategory = new JTextField();
        JTextField tfCost = new JTextField();
        JTextField tfDirector = new JTextField();
        JTextField tfArtist = new JTextField();

        panel.add(new JLabel("ID:")); panel.add(tfId);
        panel.add(new JLabel("Title:")); panel.add(tfTitle);
        panel.add(new JLabel("Category:")); panel.add(tfCategory);
        panel.add(new JLabel("Cost:")); panel.add(tfCost);
        panel.add(new JLabel("Director:")); panel.add(tfDirector);
        panel.add(new JLabel("Artist:")); panel.add(tfArtist);

        JButton btnAdd = new JButton("Add CD");
        panel.add(btnAdd);

        btnAdd.addActionListener(e -> {
                try {
                int id = Integer.parseInt(tfId.getText().trim());
                String title = tfTitle.getText().trim();
                String category = tfCategory.getText().trim();
                float cost = Float.parseFloat(tfCost.getText().trim());
                String director = tfDirector.getText().trim();
                String artist = tfArtist.getText().trim();

                if (cost < 0) {
                    JOptionPane.showMessageDialog(
                            this,
                            "Cost must be greater than or equal to 0!",
                            "Invalid Cost",
                            JOptionPane.ERROR_MESSAGE
                    );
                    return;
                }
                CompactDisc cd = new CompactDisc(title, category, cost, director, artist);
                // no tracks in this simple example
                    store.addMedia(cd);
                    dispose(); 
                    new StoreScreen(store, cart);
                    System.out.println("AddCompactDiscToStoreScreen: added CD: " + cd.getTitle());
                    JOptionPane.showMessageDialog(this, "CD added: " + title);
                    if (onStoreChanged != null) SwingUtilities.invokeLater(onStoreChanged);
            } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Invalid input, item not added: " + ex.getMessage());
            }
        });

        return panel;
    }
}