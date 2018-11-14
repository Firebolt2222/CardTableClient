package sample.connectionHandling.messageThreads;



import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Random;

public class MessageSendThread extends Thread {

    Socket client;
    int rndn;
    byte[] message;


    public MessageSendThread(Socket client) {
        this.client = client;
        Random rd=new Random();
        rndn=rd.nextInt(100);
        message=null;
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
                message=new byte[]{4,3,2,1};
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                /*
                if(message!=null){
                    dataOutputStream.write(3);
                    System.out.println("Sending "+3);
                    message=null;
                }*/
                //dataOutputStream.writeUTF("Hallo Server, ich bin Client "+a);
            }
            dataInputStream.close();
            dataOutputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        super.run();
    }

    public void setMessage(byte[] message) {
        this.message = message;
    }

}
