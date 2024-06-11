//Controller untuk login dan register
package com.example.taskmanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.ResourceBundle;

public class indexController implements Initializable {
    @FXML
    private AnchorPane login_form;

    @FXML
    private AnchorPane main_form;

    @FXML
    private Hyperlink si_createAccount;

    @FXML
    private Button si_loginBtn;

    @FXML
    private PasswordField si_password;

    @FXML
    private TextField si_username;

    @FXML
    private AnchorPane signup_form;

    @FXML
    private Hyperlink su_alreadyhaveAccount;

    @FXML
    private PasswordField su_password;

    @FXML
    private Button su_signupBtn;

    @FXML
    private TextField su_username;

    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;

    private Alert alert;

    public void loginAccount(){
        String selectData = "SELECT username, password FROM user WHERE username = '"
                + si_username.getText() + "' and password = '" + si_password.getText() + "'";

        connect = database.connectDb();

        try{
            if(si_username.getText().isEmpty() || si_password.getText().isEmpty()){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Massage");
                alert.setHeaderText(null);
                alert.setContentText("Harap isi semua kolom yang kosong");
                alert.showAndWait();
            }else{
                prepare = connect.prepareStatement(selectData);
                result = prepare.executeQuery();

                if(result.next()){
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Massage");
                    alert.setHeaderText(null);
                    alert.setContentText("Login Berhasil!");
                    alert.showAndWait();
                }else{
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Massage");
                    alert.setHeaderText(null);
                    alert.setContentText("Username/Password Anda Salah");
                    alert.showAndWait();
                }
            }



        }catch(Exception e) {e.printStackTrace();}
    }

    public void registerAccount(){
        String insertData = "INSERT INTO user(username, password, date) VALUES(?, ?, ?)";
        connect = database.connectDb();
        try{
            if(su_username.getText() .isEmpty() || su_password.getText() .isEmpty()){
                alert = new Alert (Alert.AlertType.ERROR);
                alert.setTitle("Error Massage");
                alert.setHeaderText(null);
                alert.setContentText("Harap isi semua kolom yang kosong");
                alert.showAndWait();
            }else{

                String checkUsername = "SELECT username FROM user WHERE username = '"
                        + su_username.getText() +"'";

                prepare = connect.prepareStatement(checkUsername);
                result = prepare.executeQuery();

                if(result.next()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Massage");
                    alert.setHeaderText(null);
                    alert.setContentText("Username " + su_username.getText() + " telah digunakan");
                    alert.showAndWait();
                }else{
                    if(su_password.getText(). length() < 8) {
                        alert = new Alert (Alert.AlertType.ERROR);
                        alert.setTitle("Error Massage");
                        alert.setHeaderText(null);
                        alert.setContentText("Password tidak valid, dibutuhkan minimal 8 karakter");
                        alert.showAndWait();
                    }else{
                        prepare = connect.prepareStatement(insertData);
                        prepare.setString(1,su_username.getText() );
                        prepare.setString(2,su_password.getText() );

                        Date date = new Date();
                        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                        prepare.setString(3, String.valueOf(sqlDate));

                        prepare.executeUpdate();

                        alert = new Alert (Alert.AlertType.INFORMATION);
                        alert.setTitle("Information Massage");
                        alert.setHeaderText(null);
                        alert.setContentText("Registrasi Berhasil !");
                        alert.showAndWait();

                        su_username.setText("");
                        su_password.setText("");

                        signup_form.setVisible(false);
                        login_form.setVisible(true);
                    }
                }
            }

        }catch (Exception e) {e.printStackTrace();}
    }

    public void swicthForm(ActionEvent event){
        if(event.getSource() == si_createAccount){
            signup_form.setVisible(true);
            login_form.setVisible(false);
        }else if(event.getSource() == su_alreadyhaveAccount){
            signup_form.setVisible(false);
            login_form.setVisible(true);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}