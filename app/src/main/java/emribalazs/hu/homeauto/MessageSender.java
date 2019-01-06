package emribalazs.hu.homeauto;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class MessageSender extends AsyncTask<String,Void,Void>
{
    Socket s;
    PrintWriter pw;
    IOException ex = new IOException();
    SharedPreferences mSharedPreferences;
    String ip;

    MessageSender(Context c, int i){
        mSharedPreferences = c.getSharedPreferences("sharedPref", 0);
        if(i==1) {
            ip = mSharedPreferences.getString("RBip1", "");
        }
        if(i==2) {
            ip = mSharedPreferences.getString("RBip1", "");
        }
    }
    @Override
    protected Void doInBackground(String... voids) {
        String message = voids[0];
        try{
            s = new Socket(ip, 10000);
            pw = new PrintWriter(s.getOutputStream());
            pw.write(message);
            pw.flush();
            pw.close();
            s.close();
        }
        catch(IOException e) {

            e.printStackTrace();
        }

        return null;
    }

}
