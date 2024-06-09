package com.example.taskmanagement;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class taskController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}