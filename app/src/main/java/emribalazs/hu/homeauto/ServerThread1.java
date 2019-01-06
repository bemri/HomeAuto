package emribalazs.hu.homeauto;

import android.content.Context;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;


public class ServerThread1 extends Thread{

    private static volatile ServerThread1 instance;
    private static Object mutex = new Object();
    public boolean serverIsReachable = false;
    public String message;
    IOException e;
    String ip;

    private ServerThread1(){

    }
    private ServerThread1(String ip) {
        this.ip = ip;
    }

    public static ServerThread1 getInstance() {
        ServerThread1 result = instance;
        if (result == null) {
            synchronized (mutex) {
                result = instance;
                if (result == null)
                    instance = result = new ServerThread1();
            }
        }
        return result;
    }

    public static ServerThread1 getInstance(String ip) {
        ServerThread1 result = instance;
        if (result == null) {
            synchronized (mutex) {
                result = instance;
                if (result == null)
                    instance = result = new ServerThread1(ip);
            }
        }
        return result;
    }

    public void run()
    {

        while(true){
            try {
                Socket soc = new Socket();
                soc.connect(new InetSocketAddress(ip, 10000), 5000);
                soc.close();
                serverIsReachable = true;
                e = null; }
            catch (IOException ex) {
                e= new IOException(ex);
                serverIsReachable = false;
            }
            try{
                sleep(500);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
