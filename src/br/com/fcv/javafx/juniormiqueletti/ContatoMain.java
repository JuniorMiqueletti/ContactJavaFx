package br.com.fcv.javafx.juniormiqueletti;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Junior-Pc on 25/02/2016.
 */
public class ContatoMain extends Application{

     @Override
        public void start(Stage primaryStage) throws Exception{
            Parent root = FXMLLoader.load(getClass().getResource("/br/com/fcv/javafx/juniormiqueletti/view/ContatoView.fxml"));

            primaryStage.setScene(new Scene(root));
            primaryStage.setTitle("ContatoFx");

            primaryStage.show();

        }

        public static void main(String[] args) {
            launch(args);
        }


}
