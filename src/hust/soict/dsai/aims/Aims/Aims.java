package hust.soict.dsai.aims.Aims;

import javax.naming.LimitExceededException;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.exception.PlayerException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Aims extends Application {

    private Store store;
    private Cart cart;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediacategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlaceOrder;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblTotalCost;

    @FXML
    private MenuBar menuBar;

    @FXML
    private TextField tfFilter;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        store = new Store();
        cart = new Cart();

        BorderPane root = new BorderPane();
        VBox leftMenu = new VBox(10);
        leftMenu.setPadding(new Insets(10));

        Menu fileMenu = new Menu("File");
        MenuItem exitItem = new MenuItem("Exit");
        exitItem.setOnAction(e -> System.exit(0));
        fileMenu.getItems().add(exitItem);

        tblMedia = new TableView<>();
        colMediaTitle = new TableColumn<>("Title");
        colMediacategory = new TableColumn<>("Category");
        colMediaCost = new TableColumn<>("Cost");

      
        tblMedia.getColumns().addAll(colMediaTitle, colMediacategory, colMediaCost);
        tblMedia.setItems(FXCollections.observableArrayList(store.getItemsInStore()));

        btnAddToCart = new Button("Add to Cart");
        btnAddToCart.setOnAction(e -> {
            Media selected = tblMedia.getSelectionModel().getSelectedItem();
            if (selected != null) {
                cart.addMedia(selected);
				updateTotalCost();
            }
        });

        btnPlaceOrder = new Button("Place Order");
        btnPlaceOrder.setOnAction(e -> {
            cart.clearCart();
            updateTotalCost();
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Order placed successfully!");
            alert.show();
        });

        btnPlay = new Button("Play");
        btnPlay.setOnAction(e -> {
            Media selected = tblMedia.getSelectionModel().getSelectedItem();
            if (selected instanceof Playable) {
                ((Playable) selected).play();
            }
        });

        lblTotalCost = new Label("Total Cost: $0.00");

        HBox buttonBar = new HBox(10, btnAddToCart, btnPlaceOrder, btnPlay, lblTotalCost);

        VBox content = new VBox(10, tblMedia, buttonBar);
        root.setCenter(content);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("AIMS Store");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateTotalCost() {
        lblTotalCost.setText("Total Cost: $" + String.format("%.2f", cart.totalCost()));
    }
}
