package com.company;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.xml.datatype.DatatypeConfigurationException;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.io.Serializable;

public class Main extends Application {

    public static void main(String[] args) throws IOException, ClassNotFoundException, DatatypeConfigurationException {
		Container A1 = new Container();
		launch(args);
		A1.Read();
		A1.Write();
		System.out.println("----------------------\n");
		A1.Malysheva();
		A1.Write();
		A1.XML();
		A1.Binary();
		System.out.println();
		Img img= new Img();
		img.loadImage();

    }

	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("main.fxml"));
		Parent root = loader.load();
		stage.setScene(new Scene(root));
		stage.setOnCloseRequest(e->{e.consume();});
		stage.show();
	}
}
