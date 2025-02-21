package com.example.archiveapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.ChoiceBox;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

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

    private String[] bottleTypes = {"Medicine", "Soda", "Beer", "Jar", "Toiletry", "Food/Condiment", "Wine", "Whiskey/Liquor"};



    Stage stage;
    //Quit function
    @FXML
    private void quit(ActionEvent event){
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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bottleType.getItems().addAll(bottleTypes);
    }
}

