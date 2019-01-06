package emribalazs.hu.homeauto;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class TemperatureMenu extends FragmentActivity {

    ImageView iv1, iv2, iv3, iv4, iv5, iv6;
    TextView tv1, tv2, tv3, tv4, tv5, tv6;
    EditText et1, et2, et3, et4, et5, et6;
    Button b1, b2, b3, b4, b5, b6, main;
    LinearLayout ll1, ll2, ll3, ll4, ll5, ll6;
    int levelSelected = 0;
    SharedPreferences mSharedPreferences;
    SharedPreferences.Editor ed;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature_menu);

        iv1 = findViewById(R.id.imageViewTemp1);
        iv2 = findViewById(R.id.imageViewTemp2);
        iv3 = findViewById(R.id.imageViewTemp3);
        iv4 = findViewById(R.id.imageViewTemp4);
        iv5 = findViewById(R.id.imageViewTemp5);
        iv6 = findViewById(R.id.imageViewTemp6);

        tv1 = findViewById(R.id.textViewTemp1);
        tv2 = findViewById(R.id.textViewTemp2);
        tv3 = findViewById(R.id.textViewTemp3);
        tv4 = findViewById(R.id.textViewTemp4);
        tv5 = findViewById(R.id.textViewTemp5);
        tv6 = findViewById(R.id.textViewTemp6);

        et1 = findViewById(R.id.editTextTemp1);
        et2 = findViewById(R.id.editTextTemp2);
        et3 = findViewById(R.id.editTextTemp3);
        et4 = findViewById(R.id.editTextTemp4);
        et5 = findViewById(R.id.editTextTemp5);
        et6 = findViewById(R.id.editTextTemp6);

        main = findViewById(R.id.buttonTempMenuTop);
        b1 = findViewById(R.id.buttonTemp1);
        b2 = findViewById(R.id.buttonTemp2);
        b3 = findViewById(R.id.buttonTemp3);
        b4 = findViewById(R.id.buttonTemp4);
        b5 = findViewById(R.id.buttonTemp5);
        b6 = findViewById(R.id.buttonTemp6);

        ll1 = findViewById(R.id.LinearLayout1);
        ll2 = findViewById(R.id.LinearLayout2);
        ll3 = findViewById(R.id.LinearLayout3);
        ll4 = findViewById(R.id.LinearLayout4);
        ll5 = findViewById(R.id.LinearLayout5);
        ll6 = findViewById(R.id.LinearLayout6);
        initTempSharedPref();
        initGUI();

    }

    public void initTempSharedPref(){
        mSharedPreferences = getSharedPreferences("sharedPref", 0);
        ed=mSharedPreferences.edit();
        if(!mSharedPreferences.contains("m1_office")){
            ed.putInt("m1_office", getResources().getInteger(R.integer.m1_officeDefaultTemp));
            ed.putInt("b_bedroom", getResources().getInteger(R.integer.b_bedroomDefaultTemp));
            ed.putInt("b_office", getResources().getInteger(R.integer.b_officeDefaultTemp));
            ed.putInt("b_wardrobe", getResources().getInteger(R.integer.b_wardrobeDefaultTemp));
            ed.putInt("b_livingRoom", getResources().getInteger(R.integer.b_livingRoomDefaultTemp));
            ed.putInt("b_kitchen", getResources().getInteger(R.integer.b_kitchenDefaultTemp));
            ed.putInt("b_bathroom", getResources().getInteger(R.integer.b_bathroomDefaultTemp));
            ed.putInt("u_bedroomZsofi", getResources().getInteger(R.integer.u_bedroomZsofiDefaultTemp));
            ed.putInt("u_bedroomGeri", getResources().getInteger(R.integer.u_bedroomGeriDefaultTemp));
            ed.putInt("u_bedroomBali", getResources().getInteger(R.integer.u_bedroomBaliDefaultTemp));
            ed.putInt("u_livingRoom", getResources().getInteger(R.integer.u_livingRoomDefaultTemp));
            ed.putInt("u_kitchen", getResources().getInteger(R.integer.u_kitchenDefaultTemp));
            ed.putInt("u_bathroom", getResources().getInteger(R.integer.u_bathroomDefaultTemp));
        }
    }

    public void initGUI(){
        if(levelSelected == -1){
            main.setBackground(getDrawable(R.drawable.floor_m1_button));
            iv1.setImageResource(R.drawable.office);
            ll2.setVisibility(View.GONE);
            ll3.setVisibility(View.GONE);
            ll4.setVisibility(View.GONE);
            ll5.setVisibility(View.GONE);
            ll6.setVisibility(View.GONE);
            et1.setText(String.valueOf(mSharedPreferences.getInt("m1_office",0)));
        }
        if(levelSelected == 0){
            main.setBackground(getDrawable(R.drawable.floor_0_button));
            iv1.setImageResource(R.drawable.bedroom);
            iv2.setImageResource(R.drawable.office);
            iv3.setImageResource(R.drawable.wardrobe);
            iv4.setImageResource(R.drawable.livingroom);
            iv5.setImageResource(R.drawable.kitchen);
            iv6.setImageResource(R.drawable.bathroom);
            et1.setText(String.valueOf(mSharedPreferences.getInt("b_bedroom",0)));
            et2.setText(String.valueOf(mSharedPreferences.getInt("b_office",0)));
            et3.setText(String.valueOf(mSharedPreferences.getInt("b_wardrobe",0)));
            et4.setText(String.valueOf(mSharedPreferences.getInt("b_livingRoom",0)));
            et5.setText(String.valueOf(mSharedPreferences.getInt("b_kitchen",0)));
            et6.setText(String.valueOf(mSharedPreferences.getInt("b_bathroom",0)));
            ll2.setVisibility(View.VISIBLE);
            ll3.setVisibility(View.VISIBLE);
            ll4.setVisibility(View.VISIBLE);
            ll5.setVisibility(View.VISIBLE);
            ll6.setVisibility(View.VISIBLE);
        }
        if(levelSelected == 1){
            main.setBackground(getDrawable(R.drawable.floor_1_button));
            iv1.setImageResource(R.drawable.bedroom_zsofi);
            iv2.setImageResource(R.drawable.bedroom_geri);
            iv3.setImageResource(R.drawable.bedroom_bali);
            iv4.setImageResource(R.drawable.livingroom);
            iv5.setImageResource(R.drawable.kitchen);
            iv6.setImageResource(R.drawable.bathroom);
            et1.setText(String.valueOf(mSharedPreferences.getInt("u_bedroomZsofi",0)));
            et2.setText(String.valueOf(mSharedPreferences.getInt("u_bedroomGeri",0)));
            et3.setText(String.valueOf(mSharedPreferences.getInt("u_bedroomBali",0)));
            et4.setText(String.valueOf(mSharedPreferences.getInt("u_livingRoom",0)));
            et5.setText(String.valueOf(mSharedPreferences.getInt("u_livingRoom",0)));
            et6.setText(String.valueOf(mSharedPreferences.getInt("u_bathroom",0)));
            ll2.setVisibility(View.VISIBLE);
            ll3.setVisibility(View.VISIBLE);
            ll4.setVisibility(View.VISIBLE);
            ll5.setVisibility(View.VISIBLE);
            ll6.setVisibility(View.VISIBLE);
        }
    }

    public void mainButtonPressed(View v){
        levelSelected++;
        if(levelSelected > 1)
            levelSelected = -1;
        initGUI();
    }

    public void commitSharedPref(String key, int temp){
        ed.putInt(key,temp);
        ed.commit();
    }

    public void button1Pressed(View v){
        if(ServerThread2.getInstance().serverIsReachable) {
            MessageSender messageSender = new MessageSender(this, 1);
            String message = "error";
            if (levelSelected == -1) {
                message = getResources().getString(R.string.setTemp_M1_Office) + et1.getText().toString() + " °C";
                commitSharedPref("m1_office", Integer.parseInt(et1.getText().toString()));
            }
            if (levelSelected == 0) {
                message = getResources().getString(R.string.setTemp_B_Bedroom) + et1.getText().toString() + " °C";
                commitSharedPref("b_bedroom", Integer.parseInt(et1.getText().toString()));
            }
            if (levelSelected == 1) {
                message = getResources().getString(R.string.setTemp_U_BedroomZsofi) + et1.getText().toString() + " °C";
                commitSharedPref("u_bedroomZsofi", Integer.parseInt(et1.getText().toString()));
            }
            messageSender.execute(message);
        }
        else{
            Toast.makeText(this, "No connection!", Toast.LENGTH_SHORT).show();
        }
    }

    public void button2Pressed(View v){
        if(ServerThread2.getInstance().serverIsReachable) {
            MessageSender messageSender = new MessageSender(this, 1);
            String message = "error";
            if (levelSelected == 0) {
                message = getResources().getString(R.string.setTemp_B_Office) + et2.getText().toString() + " °C";
                commitSharedPref("b_office", Integer.parseInt(et2.getText().toString()));
            }
            if (levelSelected == 1) {
                message = getResources().getString(R.string.setTemp_U_BedroomGeri) + et2.getText().toString() + " °C";
                commitSharedPref("u_bedroomGeri", Integer.parseInt(et2.getText().toString()));
            }
            messageSender.execute(message);
        }
        else{
            Toast.makeText(this, "No connection!", Toast.LENGTH_SHORT).show();
        }
    }

    public void button3Pressed(View v){
        if(ServerThread2.getInstance().serverIsReachable) {
            MessageSender messageSender = new MessageSender(this, 1);
            String message = "error";
            if (levelSelected == 0) {
                message = getResources().getString(R.string.setTemp_B_Wardrobe) + et3.getText().toString() + " °C";
                commitSharedPref("b_wardrobe", Integer.parseInt(et3.getText().toString()));
            }
            if (levelSelected == 1) {
                message = getResources().getString(R.string.setTemp_U_BedroomBali) + et3.getText().toString() + " °C";
                commitSharedPref("u_bedroomBali", Integer.parseInt(et3.getText().toString()));
            }
            messageSender.execute(message);
        }
        else{
            Toast.makeText(this, "No connection!", Toast.LENGTH_SHORT).show();
        }
    }

    public void button4Pressed(View v){
        if(ServerThread2.getInstance().serverIsReachable) {
            MessageSender messageSender = new MessageSender(this, 1);
            String message = "error";
            if (levelSelected == 0) {
                message = getResources().getString(R.string.setTemp_B_LivingRoom) + et4.getText().toString() + " °C";
                commitSharedPref("b_livingRoom", Integer.parseInt(et4.getText().toString()));
            }
            if (levelSelected == 1) {
                message = getResources().getString(R.string.setTemp_U_LivingRoom) + et4.getText().toString() + " °C";
                commitSharedPref("u_livingRoom", Integer.parseInt(et4.getText().toString()));
            }
            messageSender.execute(message);
        }
        else{
            Toast.makeText(this, "No connection!", Toast.LENGTH_SHORT).show();
        }
    }

    public void button5Pressed(View v){
        if(ServerThread2.getInstance().serverIsReachable) {
            MessageSender messageSender = new MessageSender(this, 1);
            String message = "error";
            if (levelSelected == 0) {
                message = getResources().getString(R.string.setTemp_B_Kitchen) + et5.getText().toString() + " °C";
                commitSharedPref("b_kitchen", Integer.parseInt(et5.getText().toString()));
            }
            if (levelSelected == 1) {
                message = getResources().getString(R.string.setTemp_U_Kitchen) + et5.getText().toString() + " °C";
                commitSharedPref("u_kitchen", Integer.parseInt(et5.getText().toString()));
            }
            messageSender.execute(message);
        }
        else{
            Toast.makeText(this, "No connection!", Toast.LENGTH_SHORT).show();
        }
    }

    public void button6Pressed(View v){
        if(ServerThread2.getInstance().serverIsReachable) {
            MessageSender messageSender = new MessageSender(this, 1);
            String message = "error";
            if (levelSelected == 0) {
                message = getResources().getString(R.string.setTemp_B_Bathroom) + et6.getText().toString() + " °C";
                commitSharedPref("b_bathroom", Integer.parseInt(et6.getText().toString()));
            }
            if (levelSelected == 1) {
                message = getResources().getString(R.string.setTemp_U_Bathroom) + et6.getText().toString() + " °C";
                commitSharedPref("u_bathroom", Integer.parseInt(et6.getText().toString()));
            }
            messageSender.execute(message);
        }
        else{
            Toast.makeText(this, "No connection!", Toast.LENGTH_SHORT).show();
        }
    }
}
