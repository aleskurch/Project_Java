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

import javax.swing.text.html.ImageView;
import java.io.IOException;


public class LoginController {

    @FXML
    Button signIn;
    @FXML
    Button signUp;
    @FXML
    TextField login;
    @FXML
    PasswordField password;
    @FXML
    Label label;
    @FXML
    Label Lable2;
    @FXML
    ImageView Image;

    public void onSignInClick(){
        UserDao userDao = new UserDao();
        try {
            if(userDao.indexOfUser(login.getText(),MD5Util.md5Custom(password.getText())) == -1){
                label.setText("illegal name or password!");
            }
            else{
                Lable2.setText("Success");
                Stage stage = (Stage) signUp.getScene().getWindow();
                stage.close();
            }
        } catch (IOException e) {
            label.setText("problem with file!");
        }
    }

    public void onSignUpClick() throws IOException {
        Stage stage = (Stage) signUp.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(LoginController.class.getResource("login.fxml"));
        Parent root = loader.load();
        stage.setScene(new Scene(root));
    }
}
