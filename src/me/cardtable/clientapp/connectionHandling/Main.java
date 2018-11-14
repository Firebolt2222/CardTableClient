package me.cardtable.clientapp.connectionHandling;

import me.cardtable.clientapp.connectionHandling.UserInterface.Form1;
import me.cardtable.clientapp.connectionHandling.messageThreads.MessageReceiveThread;
import me.cardtable.clientapp.connectionHandling.messageThreads.MessageSendThread;

import javax.swing.*;
import java.io.IOException;
import java.net.Socket;

public class Main{

    public static void main(String[] args) {
        try {
            Socket client=new Socket("localhost",1234);
            MessageReceiveThread mrt=new MessageReceiveThread(client);
            mrt.start();
            MessageSendThread mst=new MessageSendThread(client);
            mst.start();
            JFrame frame=new JFrame("Test Frame");
            frame.setContentPane(new Form1(mst,mrt).BasePanel);
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (UnsupportedLookAndFeelException e) {
                e.printStackTrace();
            }
            frame.pack();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
