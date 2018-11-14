package me.cardtable.clientapp.connectionHandling.messageThreads;



import me.cardtable.clientapp.connectionHandling.Message;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;
import java.util.Random;

public class MessageSendThread extends Thread {

    Socket client;
    int rndn;
    Message msg;


    public MessageSendThread(Socket client) {
        this.client = client;
        Random rd=new Random();
        rndn=rd.nextInt(100);
        msg=null;
    }

    @Override
    public void run() {
        try{
            DataOutputStream dataOutputStream = new DataOutputStream(client.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(client.getInputStream());
            Random rd=new Random();
            int a=rd.nextInt();
            while(!interrupted()){
                /*int n=rd.nextInt();
                message=new byte[n];
                for(int i=0;i<n;i++){
                    message[i]=(byte) rd.nextInt(200);
                }
                */

                if(msg!=null){
                    //dataOutputStream.writeUTF("Hallo");
                    System.out.println(Arrays.toString(msg.message));
                    dataOutputStream.write(msg.message);
                    //System.out.println("Sending:");
                    //msg.readMessage();
                    msg=null;
                }
            }
            dataInputStream.close();
            dataOutputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        super.run();
    }

    public void setMessage(Message msg) {
        this.msg =msg;
    }

}
