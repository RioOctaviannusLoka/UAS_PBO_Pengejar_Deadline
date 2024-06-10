package com.example.taskmanagement;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class taskController implements Initializable {
    @FXML
    private Button finishedPlans_btn;

    @FXML
    private TableColumn<?, ?> finishedPlans_col_endDate;

    @FXML
    private TableColumn<?, ?> finishedPlans_col_plan;

    @FXML
    private TableColumn<?, ?> finishedPlans_col_planID;

    @FXML
    private TableColumn<?, ?> finishedPlans_col_startDate;

    @FXML
    private TableColumn<?, ?> finishedPlans_col_status;

    @FXML
    private TableColumn<?, ?> finishedPlans_col_type;

    @FXML
    private AnchorPane finishedPlans_form;

    @FXML
    private TextField finishedPlans_planID;

    @FXML
    private ComboBox<?> finishedPlans_status;

    @FXML
    private TableView<?> finishedPlans_tableView;

    @FXML
    private Button finishedPlans_updateBtn;

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
    private TableColumn<?, ?> myPlans_col_endDate;

    @FXML
    private TableColumn<?, ?> myPlans_col_plan;

    @FXML
    private TableColumn<?, ?> myPlans_col_startDate;

    @FXML
    private TableColumn<?, ?> myPlans_col_status;

    @FXML
    private TableColumn<?, ?> myPlans_col_type;

    @FXML
    private Button myPlans_deleteBtn;

    @FXML
    private AnchorPane myPlans_endDate;

    @FXML
    private AnchorPane myPlans_form;

    @FXML
    private TextArea myPlans_plan;

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

    public void switchForm(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
