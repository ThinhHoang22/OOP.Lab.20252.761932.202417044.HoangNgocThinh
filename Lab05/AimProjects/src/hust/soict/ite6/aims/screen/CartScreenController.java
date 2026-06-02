package hust.soict.ite6.aims.screen;

import hust.soict.ite6.aims.cart.Cart.Cart;
import hust.soict.ite6.aims.media.*;
import hust.soict.ite6.aims.media.Playable;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import hust.soict.ite6.aims.exception.PlayerException;
import hust.soict.ite6.aims.store.Store.Store;
import javax.swing.SwingUtilities;

public class CartScreenController {
    private final Cart cart;
    private final Store store;

    @FXML
    private TableView<Media> tblMedia;
    @FXML
    private TableColumn<Media, String> colMediaTitle;
    @FXML
    private TableColumn<Media, String> colMediaCategory;
    @FXML
    private TableColumn<Media, Float> colMediaCost;
    @FXML
    private Button btnPlay;
    @FXML
    private Button btnRemove;
    @FXML
    private Label lblTotalCost;
    @FXML
    private TextField tfFilter;
    @FXML
    private RadioButton radioBtnFilterId;
    @FXML
    private RadioButton radioBtnFilterTitle;
    @FXML
    private  Button btnPlayPressed;
  

    public CartScreenController(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
    }

    @FXML
    private void initialize() {
        // 1. Cấu hình cột hiển thị
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        // 2. Cấu hình FilteredList (Phần 10)
        FilteredList<Media> filteredData = new FilteredList<>(this.cart.getItemsOrdered(), p -> true);
        
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
        
        tfFilter.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(media -> {
                if (newValue == null || newValue.trim().isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (radioBtnFilterTitle.isSelected()) {
                    return media.getTitle().toLowerCase().contains(lowerCaseFilter);
                } else if (radioBtnFilterId.isSelected()) {
                    return String.valueOf(media.getId()).contains(lowerCaseFilter);
                }
                return true;
            });
        });

        tblMedia.setItems(filteredData);

        // 3. Cấu hình ẩn hiện nút (Phần 8)
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                updateButtonBar(newValue);
            } else {
                btnPlay.setVisible(false);
                btnRemove.setVisible(false);
            }
        });

        updateTotalCost();
        
        tblMedia.getSelectionModel().selectedItemProperty().addListener(
        	    (observable, oldValue, newValue) -> {
        	        if (newValue != null) {
        	            updateButtonBar(newValue);
        	        }
        	    }
        	);
    }

    private void updateButtonBar(Media media) {
        btnRemove.setVisible(true);

        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }

    private void updateTotalCost() {
        lblTotalCost.setText(String.format("%.2f $", cart.totalCost()));
    }

    @FXML
    private void btnRemovePressed(ActionEvent event) {

        Media media =
            tblMedia.getSelectionModel()
                    .getSelectedItem();

        if(media != null) {
            cart.removeMedia(media);
            updateTotalCost();
        }
    }

        
    @FXML
    private void btnPlayPressed(ActionEvent event) {
        handlePlay();
    }

    private void handlePlay() {
        Media selected = tblMedia.getSelectionModel().getSelectedItem();
        if (selected == null) return;

        if (selected instanceof Playable) {
            Playable playable = (Playable) selected;

            try {
                playable.play();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Playing media");
                alert.setHeaderText("Now playing: " + selected.getTitle());
                alert.setContentText("Playing...");
                alert.showAndWait();

            } catch (PlayerException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Play failed");
                alert.setHeaderText("Failed to play media");
                alert.setContentText(ex.getMessage());
                alert.showAndWait();

                System.err.println(ex.getMessage());
                System.err.println(ex.toString());
                ex.printStackTrace();
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Cannot Play");
            alert.setHeaderText("This media cannot be played");
            alert.showAndWait();
        }
    }
    
    @FXML
    private void btnPlaceOrderPressed(ActionEvent event) {
        if (cart.getItemsOrdered().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Cart is empty");
            alert.setHeaderText(null);
            alert.setContentText("Your cart is empty!");
            alert.showAndWait();
            return;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Order placed");
        alert.setHeaderText(null);
        alert.setContentText("Your order has been placed successfully!");
        alert.showAndWait();

        cart.getItemsOrdered().clear();
        updateTotalCost();

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
    }
    
    @FXML
    private void sortByTitle(ActionEvent event) {
        cart.sortByTitleCost();
        tblMedia.refresh();
    }

    @FXML
    private void sortByCost(ActionEvent event) {
        cart.sortByCostTitle();
        tblMedia.refresh();
    }
    
    @FXML
    private void viewStore(ActionEvent event) {
        SwingUtilities.invokeLater(() -> new StoreScreen(store, cart));
    }
}