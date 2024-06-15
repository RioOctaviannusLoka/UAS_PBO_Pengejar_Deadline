//Controller untuk login dan register
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
import java.security.MessageDigest;
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

    //Database
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;

    // Id User for usage in taskController.java
    private static int idUser;

    private Alert alert;

    public void loginAccount(){
        connect = database.connectDb();

        try{
            if(si_username.getText().isEmpty() || si_password.getText().isEmpty()){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Massage");
                alert.setHeaderText(null);
                alert.setContentText("Harap isi semua kolom yang kosong");
                alert.showAndWait();
            }else{
                String selectData = "SELECT id_user, password FROM user WHERE username = '"
                        + si_username.getText() + "'";

                prepare = connect.prepareStatement(selectData);
                result = prepare.executeQuery();

                if(result.next()){
                    String password =  result.getString("password");
                    String hashedPassword = PasswordHash(si_password.getText());

                    if (password.equals(hashedPassword)){
                        // Save id_user for usage in other forms
                        int id_user = result.getInt("id_user");
                        SetIdUser(id_user);

                        alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information Massage");
                        alert.setHeaderText(null);
                        alert.setContentText("Login Berhasil!");
                        alert.showAndWait();

                        // HIDE LOGIN FORM
                        si_loginBtn.getScene().getWindow().hide();

                        // LINK DASHBOARD
                        Parent root = FXMLLoader.load(getClass().getResource("plan.fxml"));

                        Stage stage = new Stage();
                        Scene scene = new Scene(root);
                        stage.setTitle("Plan your to do list");
                        stage.setScene(scene);
                        stage.show();
                    }else{
                        alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error Massage");
                        alert.setHeaderText(null);
                        alert.setContentText("Password Anda Salah.");
                        alert.showAndWait();
                    }
                }else{
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Massage");
                    alert.setHeaderText(null);
                    alert.setContentText("Username Anda Salah. Akun Tidak Ditemukan.");
                    alert.showAndWait();
                }
            }
        }catch(Exception e) {e.printStackTrace();}
    }

    public void registerAccount(){
        connect = database.connectDb();
        try{
            if(su_username.getText() .isEmpty() || su_password.getText() .isEmpty()){
                alert = new Alert (Alert.AlertType.ERROR);
                alert.setTitle("Error Massage");
                alert.setHeaderText(null);
                alert.setContentText("Harap isi semua kolom yang kosong");
                alert.showAndWait();
            }else{
                // Check if the username has already been used in database
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
                    // Check if the password length is below 8 characters
                    if(su_password.getText(). length() < 8) {
                        alert = new Alert (Alert.AlertType.ERROR);
                        alert.setTitle("Error Massage");
                        alert.setHeaderText(null);
                        alert.setContentText("Password tidak valid, dibutuhkan minimal 8 karakter");
                        alert.showAndWait();
                    } else{
                        // Insert user data into database using Password Hashing
                        String hashedPassword =  PasswordHash(su_password.getText());

                        String insertData = "INSERT INTO user(username, password, date) VALUES(?, ?, ?)";
                        prepare = connect.prepareStatement(insertData);
                        prepare.setString(1,su_username.getText() );
                        prepare.setString(2,hashedPassword );

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

    public void switchForm(ActionEvent event){
        if(event.getSource() == si_createAccount){
            signup_form.setVisible(true);
            login_form.setVisible(false);
        }else if(event.getSource() == su_alreadyhaveAccount){
            signup_form.setVisible(false);
            login_form.setVisible(true);
        }
    }

    // Password Hashing
    public static String PasswordHash(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA");
            md.update(password.getBytes());
            byte[] rbt = md.digest();
            StringBuilder sb = new StringBuilder();

            for(byte b: rbt) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (Exception e) {
        }
        return null;
    }

    private void SetIdUser(int id_user){
        idUser = id_user;
    }

    public static int GetIdUser(){
        return idUser;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}