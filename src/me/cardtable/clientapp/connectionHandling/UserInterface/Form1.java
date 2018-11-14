package me.cardtable.clientapp.connectionHandling.UserInterface;

import me.cardtable.clientapp.connectionHandling.Message;
import me.cardtable.clientapp.connectionHandling.messageThreads.MessageReceiveThread;
import me.cardtable.clientapp.connectionHandling.messageThreads.MessageSendThread;

import javax.swing.*;

public class Form1 extends JFrame{
    private JLabel HeaderLabel;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    public JPanel BasePanel;

    public Form1(MessageSendThread mst, MessageReceiveThread mrt) {
        button1.addActionListener(e -> {
            Message msg=new Message(new byte[]{1,1,1,1});
            mst.setMessage(msg);
        });
        button2.addActionListener(e -> {
            Message msg=new Message(new byte[]{2,2,2,2});
            mst.setMessage(msg);
        });
        button3.addActionListener(e -> {
            Message msg=new Message(new byte[]{3,3,3,3});
            mst.setMessage(msg);
        });
        button4.addActionListener(e -> {
            Message msg=new Message(new byte[]{4,4,4,4});
            mst.setMessage(msg);
        });
    }
}
