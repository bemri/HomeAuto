package emribalazs.hu.homeauto;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SettingsMenu extends FragmentActivity {

   SharedPreferences mSharedPreferences;
   SharedPreferences.Editor ed;
   TextView ip1TV, ip2TV;
   EditText ip1ET, ip2ET;
   Button buttonApply, buttonReset;
   String ip1, ip2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_menu);
        mSharedPreferences = getSharedPreferences("sharedPref",0);
        ed = mSharedPreferences.edit();
        if(!mSharedPreferences.contains("RBip1") && !mSharedPreferences.contains("RBip2")) {
            ed.putString("RBip1", getResources().getString(R.string.defaultIP1));
            ed.putString("RBip2", getResources().getString(R.string.defaultIP2));
            ed.commit();
        }

        ip1TV = (TextView) findViewById(R.id.textViewCurrentIPRB1);
        ip2TV = (TextView) findViewById(R.id.textViewCurrentIPRB2);
        ip1ET = (EditText) findViewById(R.id.editTextRBIP1);
        ip2ET = (EditText) findViewById(R.id.editTextRBIP2);

        refreshIPTVs();
    }

    public void applyPressed (View v){
        ed.putString("RBip1", ip1ET.getText().toString());
        ed.putString("RBip2", ip2ET.getText().toString());
        ed.commit();
        refreshIPTVs();
        ServerThread1.getInstance().ip = mSharedPreferences.getString("RBip1","");
        ServerThread2.getInstance().ip = mSharedPreferences.getString("RBip2","");
        finish();
    }

    public void resetPressed (View v){
        ed.putString("RBip1", getResources().getString(R.string.defaultIP1));
        ed.putString("RBip2", getResources().getString(R.string.defaultIP2));
        ed.commit();
        refreshIPTVs();
    }

    public void refreshIPTVs(){
        ip1TV.setText(mSharedPreferences.getString("RBip1",""));
        ip2TV.setText(mSharedPreferences.getString("RBip2",""));
        ip1ET.setText(ip1TV.getText());
        ip2ET.setText(ip2TV.getText());
    }
}
