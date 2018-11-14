package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.connectionHandling.messageThreads.MessageReceiveThread;
import sample.connectionHandling.messageThreads.MessageSendThread;

import java.io.IOException;
import java.net.Socket;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        try {
            Socket client=new Socket("localhost",1234);
            MessageReceiveThread mrs=new MessageReceiveThread(client);
            mrs.start();
            MessageSendThread mst=new MessageSendThread(client);
            mst.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        launch(args);
    }
}
