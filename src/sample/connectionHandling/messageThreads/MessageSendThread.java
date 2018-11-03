package sample.connectionHandling.messageThreads;



import sample.connectionHandling.CommunicationSystem;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Random;

public class MessageSendThread extends Thread {

    Socket client;
    int rndn;


    public MessageSendThread(Socket client) {
        this.client = client;
        Random rd=new Random();
        rndn=rd.nextInt(100);
    }

    @Override
    public void run() {
        try{
            DataOutputStream dataOutputStream = new DataOutputStream(client.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(client.getInputStream());
            while(!interrupted()){
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                dataOutputStream.writeUTF("Hallo Server, Ich bin client "+rndn);

            }
            dataInputStream.close();
            dataOutputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        super.run();
    }

}
