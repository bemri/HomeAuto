package emribalazs.hu.homeauto;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.text.format.Formatter;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;


public class ServerThread2 extends Thread{

    private static volatile ServerThread2 instance;
    private static Object mutex = new Object();
    public boolean serverIsReachable = false;
    public String message;
    IOException e;
    int whichServer;
    String ip;

    private ServerThread2() {

    }

    private ServerThread2(String ip) {
        this.ip = ip;
    }

    public static ServerThread2 getInstance() {
        ServerThread2 result = instance;
        if (result == null) {
            synchronized (mutex) {
                result = instance;
                if (result == null)
                    instance = result = new ServerThread2();
            }
        }
        return result;
    }

    public static ServerThread2 getInstance(String ip) {
        ServerThread2 result = instance;
        if (result == null) {
            synchronized (mutex) {
                result = instance;
                if (result == null)
                    instance = result = new ServerThread2(ip);
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
