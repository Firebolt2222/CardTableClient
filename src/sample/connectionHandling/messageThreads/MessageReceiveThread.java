package sample.connectionHandling.messageThreads;



import sample.connectionHandling.Message;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

public class MessageReceiveThread extends Thread {

    Socket client;

    public MessageReceiveThread(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try{
            DataOutputStream dataOutputStream = new DataOutputStream(client.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(client.getInputStream());
            while(!interrupted()) {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                byte[] buffer=new byte[4];
                int read=0;
                while((read=dataInputStream.read(buffer,0,buffer.length))!=-1){
                    System.out.println("Received:");
                    Message msg=new Message(buffer);
                    msg.readMessage();
                }
            }
            dataInputStream.close();
            dataOutputStream.close();
        } catch (SocketException se){
            System.err.println("The server has been closed");
            System.exit(-1);
        } catch (IOException e){
            e.printStackTrace();
        }
        super.run();
    }
}
