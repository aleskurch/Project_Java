package com.company;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class SignInController {
    @FXML
    Button SignUp;
    @FXML
    PasswordField password1;
    @FXML
    PasswordField password2;
    @FXML
    TextField login;
    @FXML
    Button Back;
    @FXML
    Label label; 

    public void OnSignUpClick() throws IOException, NoSuchAlgorithmException {

        UserDao userDao = new UserDao();
        if (password1.getText().length() < 4) {
            label.setText("incorrect password!");

        } else if (!password1.getText().equals(password2.getText())) {
            label.setText("password are different!");
        } else if (login.getText().length() < 5) {
            label.setText("incorrect login!");
        } else if (userDao.findByName(login.getText()) != -1) {
            label.setText("incorrect login!");
        } else {
            userDao.saveUser(login.getText(), MD5Util.md5Custom(password1.getText()));
            Stage stage = (Stage) SignUp.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(LoginController.class.getResource("main.fxml"));
            Parent root = loader.load();
            stage.setScene(new Scene(root));
        }
    }

    public void OnBackClick() throws IOException {
        Stage stage = (Stage) SignUp.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(LoginController.class.getResource("main.fxml"));
        Parent root = loader.load();
        stage.setScene(new Scene(root));
    }

}
