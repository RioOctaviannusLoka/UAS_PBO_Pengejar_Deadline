package com.example.taskmanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class taskController implements Initializable {
    @FXML
    private Button filterPlans_btn;

    @FXML
    private TableColumn<?, ?> filterPlans_col_dateCreated;

    @FXML
    private TableColumn<?, ?> filterPlans_col_description;

    @FXML
    private TableColumn<?, ?> filterPlans_col_dueDate;

    @FXML
    private TableColumn<?, ?> filterPlans_col_plan;

    @FXML
    private TableColumn<?, ?> filterPlans_col_planID;

    @FXML
    private TableColumn<?, ?> filterPlans_col_status;

    @FXML
    private TableColumn<?, ?> filterPlans_col_type;

    @FXML
    private Button filterPlans_filterBtn;

    @FXML
    private AnchorPane filterPlans_form;

    @FXML
    private TextField filterPlans_search;

    @FXML
    private ComboBox<?> filterPlans_status;

    @FXML
    private TableView<?> filterPlans_tableView;

    @FXML
    private Label home_FP;

    @FXML
    private Label home_NAP;

    @FXML
    private Button home_btn;

    @FXML
    private AnchorPane home_form;

    @FXML
    private Label home_username;

    @FXML
    private Button logout_btn;

    @FXML
    private AnchorPane main_form;

    @FXML
    private Button myPlans_addBtn;

    @FXML
    private Button myPlans_btn;

    @FXML
    private Button myPlans_clearBtn;

    @FXML
    private TableColumn<?, ?> myPlans_col_dateCreated;

    @FXML
    private TableColumn<?, ?> myPlans_col_description;

    @FXML
    private TableColumn<?, ?> myPlans_col_dueDate;

    @FXML
    private TableColumn<?, ?> myPlans_col_plan;

    @FXML
    private TableColumn<?, ?> myPlans_col_status;

    @FXML
    private TableColumn<?, ?> myPlans_col_type;

    @FXML
    private Button myPlans_deleteBtn;

    @FXML
    private TextArea myPlans_description;

    @FXML
    private AnchorPane myPlans_endDate;

    @FXML
    private AnchorPane myPlans_form;

    @FXML
    private TextField myPlans_plan;

    @FXML
    private DatePicker myPlans_startDate;

    @FXML
    private ComboBox<?> myPlans_status;

    @FXML
    private TableView<?> myPlans_tableView;

    @FXML
    private TextField myPlans_type;

    @FXML
    private Button myPlans_updateBtn;

    @FXML
    private Label page_label;

    public void switchForm(ActionEvent event){
        // Hide all Form
        home_form.setVisible(false);
        myPlans_form.setVisible(false);
        filterPlans_form.setVisible(false);

        // Show form according to the button
        if (event.getSource() == home_btn) {
            home_form.setVisible(true);
            page_label.setText("Home");
        } else if (event.getSource() == myPlans_btn) {
            myPlans_form.setVisible(true);
            page_label.setText("My Plans");
        } else if (event.getSource() == filterPlans_btn) {
            filterPlans_form.setVisible(true);
            page_label.setText("Filter Plans");
        } else if (event.getSource() == logout_btn) {
            // Hide plan.fxml
            logout_btn.getScene().getWindow().hide();

            // Show index.fxml
            try{
                Parent root = FXMLLoader.load(getClass().getResource("index.fxml"));

                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setTitle("Plan your to do list");
                stage.setScene(scene);
                stage.show();
            } catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
