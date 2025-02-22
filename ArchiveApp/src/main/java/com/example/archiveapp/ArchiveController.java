package com.example.archiveapp;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.ChoiceBox;

import java.io.File;
import java.nio.file.Files;
import javafx.stage.FileChooser;
import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

import static java.awt.SystemColor.scrollbar;
import static java.awt.SystemColor.window;
import static java.util.Collections.addAll;

public class ArchiveController implements Initializable {
    @FXML
    //quit menu item
    private MenuItem quitMenu;
    //Anchor pane declaration
    @FXML
    private AnchorPane mainPane;

    @FXML
    private Label typeLabel;

    @FXML
    private ChoiceBox<String> bottleType;
    public ChoiceBox<String> bottleAge;
    //array containing the choices for the choicebox "bottleType"
    private String[] bottleTypes = {"Medicine", "Soda", "Beer", "Jar", "Toiletry", "Food/Condiment", "Wine", "Whiskey/Liquor"};
    private String[] bottleAges = {"1700s", "1800-1810", "1820-1830", "1830-1840", "1840-1850", "1850-1860", "1860-1870",
                                   "1870-1880", "1880-1890", "1890-1900", "1900-1910","1910-1920","1920-1930", "1930-1940",
                                   "1940-1950", "Modern"};
    @FXML
    private Button entryButton;

    Stage stage;
    @FXML
    String filename;
    public MenuItem saveFile;

    //saving functionality (currently broken)

    public void save(ActionEvent event){
        File file = new File(filename);
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save file");
        fileChooser.showSaveDialog(stage);
    }
    //quit function
    public void quit(ActionEvent event){
        Alert quitAlert = new Alert(Alert.AlertType.CONFIRMATION);
        quitAlert.setTitle("Quit?");
        quitAlert.setHeaderText("You're about to quit");
        quitAlert.setContentText("Are you sure you want to quit?");


        Alert peterAlert = new Alert(Alert.AlertType.CONFIRMATION);
        peterAlert.setTitle("Peter Alert");
        peterAlert.setHeaderText("Peter Alert");
        peterAlert.setContentText("Peter Alert");

        if(quitAlert.showAndWait().get() == ButtonType.OK) {
            Image peter = new Image("https://upload.wikimedia.org/wikipedia/en/c/c2/Peter_Griffin.png");
            ImageView imageview = new ImageView(peter);
            peterAlert.setGraphic(imageview);
            peterAlert.showAndWait();
        }

        if(peterAlert.showAndWait().get()==ButtonType.OK) {
            stage = (Stage) mainPane.getScene().getWindow();
            System.out.println("You have successfully quit");
            stage.close();
        }
    }
    @FXML
        private ListView<String> bottleList;

        String [] entryList = {"Warner's Safe Cure", "Straight Side Script Pepsi", "Straight Side Coke",
                "Straight Side Block Pepsi", "Cobalt Poison", "Rochester Brewing Co", "Bovox",
        "Dr King's Consumption Cure", "NuGrape Embossed Grape Style", "1915 Coke High Point", "J Hostetter's Bitters",
            "Rumford Chemical Co", "Henry K Wampole", "Roseneck Brewing Co", "Virginia Brewing Co", "Dr Kilmer's Swamp",
        "Starboys Pepsi Product", "Seville Packing Preserves", "Warranted Flask", "Kiss Kola", "Thomasville Bottling Co",
        "Horrmann Brewing Co", "Grand Union Tea Co"};
        String currentBottle;

    //choice box functionality
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bottleType.getItems().addAll(bottleTypes);
        bottleList.getItems().addAll(entryList);
        bottleAge.getItems().addAll(bottleAges);

        ScrollBar scrollBarOne;

        scrollBarOne = (ScrollBar) bottleList.lookup(".scroll-bar:vertical");
       // bottleList.getSelectionModel().selectionModeProperty().addListener(new ChangeListener<String>() {
       //     @Override
         //   public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2){

            //}
       // });

    }


}

