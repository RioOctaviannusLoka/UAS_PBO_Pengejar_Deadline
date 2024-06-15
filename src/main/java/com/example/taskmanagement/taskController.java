package com.example.taskmanagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Optional;
import java.util.Date;
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
    private TableColumn<taskData, String> myPlans_col_dateCreated;

    @FXML
    private TableColumn<taskData, String> myPlans_col_description;

    @FXML
    private TableColumn<taskData, String> myPlans_col_dueDate;

    @FXML
    private TableColumn<taskData, String> myPlans_col_plan;

    @FXML
    private TableColumn<taskData, String> myPlans_col_status;

    @FXML
    private TableColumn<taskData, String> myPlans_col_type;

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
    private DatePicker myPlans_dateCreated;

    @FXML
    private DatePicker myPlans_dueDate;

    @FXML
    private ComboBox<String> myPlans_status;

    @FXML
    private TableView<taskData> myPlans_tableView;

    @FXML
    private TextField myPlans_type;

    @FXML
    private Button myPlans_updateBtn;

    @FXML
    private Label page_label;

    // Database
    //Database
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;

    public void addTask(){
        String sql = "INSERT INTO plan "
                + "(id_plan, plan, description, date_created, due_date, type, status, id_user)"
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        connect = database.connectDb();

        try{
            Alert alert;
            if(myPlans_plan.getText().isEmpty()
                    || myPlans_dateCreated.getValue() == null
                    || myPlans_dueDate.getValue() == null
                    || myPlans_status.getValue() == null){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Harap isi semua kolom yang kosong");
                alert.showAndWait();
            }else {
                prepare = connect.prepareStatement(sql);

                prepare.setInt(1, 0);
                prepare.setString(2, myPlans_plan.getText());
                prepare.setString(3, myPlans_description.getText());
                java.sql.Date formattedDateCreated = java.sql.Date.valueOf(myPlans_dateCreated.getValue());
                prepare.setDate(4, formattedDateCreated);
                java.sql.Date formattedDueDate = java.sql.Date.valueOf(myPlans_dueDate.getValue());
                prepare.setDate(5, formattedDueDate);
                prepare.setString(6, myPlans_type.getText());
                prepare.setString(7, myPlans_status.getValue());
                prepare.setInt(8, data.idUser);

                prepare.executeUpdate();

                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Berhasil ditambah!!!");
                alert.showAndWait();

                addTaskShowListData();
                resetText();
            }
        } catch (Exception e){e.printStackTrace();}
    }

    public void resetText(){
        myPlans_plan.setText("");
        myPlans_description.setText("");
        myPlans_dateCreated.setValue(null);
        myPlans_dueDate.setValue(null);
        myPlans_type.setText("");
        myPlans_status.getSelectionModel().clearSelection();
    }

    public ObservableList<taskData> addTaskListData() {
        ObservableList<taskData> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM plan";

        connect = database.connectDb();

        try{
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            taskData taskDatas;

            while (result.next()) {
                taskDatas = new taskData(
                        result.getString("plan"),
                        result.getString("description"),
                        result.getDate("date_created"),
                        result.getDate("due_date"),
                        result.getString("type"),
                        result.getString("status"));
                listData.add(taskDatas);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return listData;
    }
    private ObservableList<taskData> addTaskList;
    public void addTaskShowListData(){
        addTaskList = addTaskListData();

        myPlans_col_plan.setCellValueFactory(new PropertyValueFactory<>("plan"));
        myPlans_col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        myPlans_col_dateCreated.setCellValueFactory(new PropertyValueFactory<>("date_created"));;
        myPlans_col_dueDate.setCellValueFactory(new PropertyValueFactory<>("due_date"));
        myPlans_col_type.setCellValueFactory(new PropertyValueFactory<>("type"));
        myPlans_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));

        myPlans_tableView.setItems(addTaskList);
    }

    public void tableItemSelect(){
        taskData taskDatas = myPlans_tableView.getSelectionModel().getSelectedItem();
        int idx = myPlans_tableView.getSelectionModel().getSelectedIndex();

        if((idx - 1) < -1){return;}

        myPlans_plan.setText(taskDatas.getPlan());
        myPlans_description.setText(taskDatas.getDescription());
        myPlans_dateCreated.setValue(taskDatas.getDate_created().toLocalDate());
        myPlans_dueDate.setValue(taskDatas.getDue_date().toLocalDate());
        myPlans_type.setText(taskDatas.getType());
        myPlans_status.setValue(taskDatas.getStatus());
    }

    // Display username di Home
    public void displayUsername(){
        home_username.setText(data.username);
    }

    public void logout(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Message");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to logout?");
        Optional<ButtonType> option = alert.showAndWait();

        try{
            if (option.get().equals(ButtonType.OK)) {
                // Hide plan.fxml
                logout_btn.getScene().getWindow().hide();
                // Show index.fxml
                Parent root = FXMLLoader.load(getClass().getResource("index.fxml"));

                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setTitle("Plan your to do list");
                stage.setScene(scene);
                stage.show();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

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
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        displayUsername();
        addTaskShowListData();
        myPlans_status.setItems(FXCollections.observableArrayList(
                "Unfinished", "In Progress", "Completed"));
    }
}
