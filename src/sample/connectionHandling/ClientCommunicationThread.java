package sample.connectionHandling;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientCommunicationThread extends Thread {

    Socket client;
    boolean cctRun=true;

    public ClientCommunicationThread(Socket client) {
        this.client=client;
    }

    @Override
    public void run() {
        try {
            DataOutputStream dataOutputStream=new DataOutputStream(client.getOutputStream());
            DataInputStream dataInputStream=new DataInputStream(client.getInputStream());
            int i=0;
            while(cctRun){
                i++;
                dataOutputStream.writeInt(i);
                Thread.sleep(1000);
                System.out.println(dataInputStream.readInt());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
