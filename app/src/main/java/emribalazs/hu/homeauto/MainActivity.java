package emribalazs.hu.homeauto;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    EditText e1;
    Button bGarage, bTemperature, bWatering, bSettings;
    ImageView ivConnectionStatus1, ivConnectionStatus2, ivMainButton;
    boolean garageButtonAvailable = true;
    String ip1, ip2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bGarage = (Button) findViewById(R.id.buttonGarageDoor);
        bTemperature = (Button) findViewById(R.id.buttonTemperature);
        bWatering = (Button) findViewById(R.id.buttonWatering);
        bSettings = (Button) findViewById(R.id.buttonSettings);
        bGarage.setBackgroundColor(Color.TRANSPARENT);
        bGarage.setVisibility(View.VISIBLE);
        bTemperature.setVisibility(View.VISIBLE);
        bTemperature.setBackgroundColor(Color.TRANSPARENT);
        bWatering.setVisibility(View.VISIBLE);
        bWatering.setBackgroundColor(Color.TRANSPARENT);
        ivConnectionStatus1 = (ImageView) findViewById(R.id.imageViewConnectionStatus1);
        ivConnectionStatus2 = (ImageView) findViewById(R.id.imageViewConnectionStatus2);
        ivMainButton = (ImageView) findViewById(R.id.imageViewMainButton);
        ip1 = (getSharedPreferences("sharedPref", 0).getString("RBip1",""));
        ip2 = (getSharedPreferences("sharedPref", 0).getString("RBip2",""));

        ServerThread1.getInstance(ip1).start();
        ServerThread2.getInstance(ip2).start();

        new Thread() {
            public void run() {
                while (true) {
                    try {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                ivConnectionStatus1.setImageResource(ServerThread1.getInstance(ip1).serverIsReachable ? R.drawable.connection_ok : R.drawable.connection_nok);
                                ivConnectionStatus2.setImageResource(ServerThread2.getInstance(ip1).serverIsReachable ? R.drawable.connection_ok : R.drawable.connection_nok);
                            }
                        });
                        Thread.sleep(500);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    public boolean server1Reachable(int i){
        if(i==1)
            return ServerThread1.getInstance(ip1).serverIsReachable;
        else
            return ServerThread2.getInstance(ip1).serverIsReachable;
    }

    public void openGarage(View v){
        if(server1Reachable(1)) {
            Toast.makeText(this, "Opening Garage", Toast.LENGTH_SHORT).show();
//            bGarage.setEnabled(false);
//            Timer buttonTimer = new Timer();
//            buttonTimer.schedule(new TimerTask() {
//
//                @Override
//                public void run() {
//                    runOnUiThread(new Runnable() {
//
//                        @Override
//                        public void run() {
//                            bGarage.setEnabled(true);
//                        }
//                    });
//                }
//            }, 10000);

            MessageSender messageSender = new MessageSender(this,1);
            messageSender.execute(getResources().getString(R.string.openGarage));

//            new AnimationThread() {
//                public void run() {
//                    while(i++<20) {
//                        try {
//                            runOnUiThread(new Runnable() {
//                                @Override
//                                public void run() {
//                                    switch(i%4){
//                                        case 0:
//                                            ivMainButton.setImageResource(R.drawable.startpage_house1);
//                                            break;
//                                        case 1:
//                                            ivMainButton.setImageResource(R.drawable.startpage_house2);
//                                            break;
//                                        case 2:
//                                            ivMainButton.setImageResource(R.drawable.startpage_house3);
//                                            break;
//                                        case 3:
//                                            ivMainButton.setImageResource(R.drawable.startpage_house4);
//                                            break;
//                                    }
//
//                                }
//                            });
//                            Thread.sleep(500);
//                        }
//                        catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            }.start();
        }
        else {
            Toast.makeText(this, "No connection!", Toast.LENGTH_LONG).show();
            return;
        }
        garageButtonAvailable = true;
    }

    public void openTemperatureMenu(View v){
        Intent temperatureMenu = new Intent(this, TemperatureMenu.class);
        startActivity(temperatureMenu);
    }

    public void openWateringMenu(View v){
        Intent wateringMenu = new Intent(this, WateringMenu.class);
        startActivity(wateringMenu);
    }

    public void openSettingsMenu(View v){
        Intent settingsMenu = new Intent(this, SettingsMenu.class);
        startActivity(settingsMenu);
    }

}
