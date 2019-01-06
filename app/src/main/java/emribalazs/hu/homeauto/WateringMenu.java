package emribalazs.hu.homeauto;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


public class WateringMenu extends FragmentActivity {

    ImageButton b1, b2, b3, b4, b5;
    Button silent1, silent2, silent3;
    boolean b1On, b2On, b3On, b4On, b5On;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watering_menu);
        b1 = findViewById(R.id.buttonWater1);
        b2 = findViewById(R.id.buttonWater2);
        b3 = findViewById(R.id.buttonWater3);
        b4 = findViewById(R.id.buttonWater4);
        b5 = findViewById(R.id.buttonWater5);
        silent1 = findViewById(R.id.buttonWaterSilent1);
        silent2 = findViewById(R.id.buttonWaterSilent2);
        silent3 = findViewById(R.id.buttonWaterSilent3);
        silent1.setBackgroundColor(Color.TRANSPARENT);
        silent1.setVisibility(View.VISIBLE);
        silent2.setBackgroundColor(Color.TRANSPARENT);
        silent2.setVisibility(View.VISIBLE);
        silent3.setBackgroundColor(Color.TRANSPARENT);
        silent3.setVisibility(View.VISIBLE);


    }

    public void button1Clicked(View v){
        if(ServerThread2.getInstance().serverIsReachable) {
            if (b1On) {
                b1.setImageResource(R.drawable.watering_button_off);
                b1.setBackground(getResources().getDrawable(R.drawable.rounded_corner3));
                MessageSender messageSender = new MessageSender(this, 1);
                messageSender.execute(getResources().getString(R.string.closeCircle1));
                b1On = false;
            } else {
                b1.setImageResource(R.drawable.watering_button_on);
                b1.setBackground(getResources().getDrawable(R.drawable.rounded_corner4));
                MessageSender messageSender = new MessageSender(this, 1);
                messageSender.execute(getResources().getString(R.string.openCircle1));
                b1On = true;
            }
        }
        else{
            Toast.makeText(this, "No connection!", Toast.LENGTH_SHORT).show();
        }

    }

    public void button2Clicked(View v){
        if(ServerThread2.getInstance().serverIsReachable) {
            if (b2On) {
                b2.setImageResource(R.drawable.watering_button_off);
                b2.setBackground(getResources().getDrawable(R.drawable.rounded_corner3));
                MessageSender messageSender = new MessageSender(this, 1);
                messageSender.execute(getResources().getString(R.string.closeCircle2));
                b2On = false;
            } else {
                b2.setImageResource(R.drawable.watering_button_on);
                b2.setBackground(getResources().getDrawable(R.drawable.rounded_corner4));
                MessageSender messageSender = new MessageSender(this, 1);
                messageSender.execute(getResources().getString(R.string.openCircle2));
                b2On = true;
            }
        }
        else{
            Toast.makeText(this, "No connection!", Toast.LENGTH_SHORT).show();
        }

    }
    public void button3Clicked(View v){
        if(ServerThread2.getInstance().serverIsReachable) {
            if (b3On) {
                b3.setImageResource(R.drawable.watering_button_off);
                b3.setBackground(getResources().getDrawable(R.drawable.rounded_corner3));
                MessageSender messageSender = new MessageSender(this, 1);
                messageSender.execute(getResources().getString(R.string.closeCircle3));
                b3On = false;
            } else {
                b3.setImageResource(R.drawable.watering_button_on);
                b3.setBackground(getResources().getDrawable(R.drawable.rounded_corner4));
                MessageSender messageSender = new MessageSender(this, 1);
                messageSender.execute(getResources().getString(R.string.openCircle3));
                b3On = true;
            }
        }
        else{
            Toast.makeText(this, "No connection!", Toast.LENGTH_SHORT).show();
        }

    }
    public void button4Clicked(View v){
        if(ServerThread2.getInstance().serverIsReachable) {
            if (b4On) {
                b4.setImageResource(R.drawable.watering_button_off);
                b4.setBackground(getResources().getDrawable(R.drawable.rounded_corner3));
                MessageSender messageSender = new MessageSender(this, 1);
                messageSender.execute(getResources().getString(R.string.closeCircle4));
                b4On = false;
            } else {
                b4.setImageResource(R.drawable.watering_button_on);
                b4.setBackground(getResources().getDrawable(R.drawable.rounded_corner4));
                MessageSender messageSender = new MessageSender(this, 1);
                messageSender.execute(getResources().getString(R.string.openCircle4));
                b4On = true;
            }
        }
        else{
            Toast.makeText(this, "No connection!", Toast.LENGTH_SHORT).show();
        }

    }
    public void button5Clicked(View v){
        if(ServerThread2.getInstance().serverIsReachable) {
            if (b5On) {
                b5.setImageResource(R.drawable.watering_button_off);
                b5.setBackground(getResources().getDrawable(R.drawable.rounded_corner3));
                MessageSender messageSender = new MessageSender(this, 1);
                messageSender.execute(getResources().getString(R.string.closeCircle5));
                b5On = false;
            } else {
                b5.setImageResource(R.drawable.watering_button_on);
                b5.setBackground(getResources().getDrawable(R.drawable.rounded_corner4));
                MessageSender messageSender = new MessageSender(this, 1);
                messageSender.execute(getResources().getString(R.string.openCircle5));
                b5On = true;
            }
        }
        else{
            Toast.makeText(this, "No connection!", Toast.LENGTH_SHORT).show();
        }

    }

    public void allClicked(View v){
        button1Clicked(v);
        button2Clicked(v);
        button3Clicked(v);
        button4Clicked(v);
        button5Clicked(v);
    }

}
