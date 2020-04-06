package com.s1920393.backhome1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE ="com.s1920393.backhome1";
    TextView out;
    //Declare Sharedpreferenced object
    SharedPreferences mSpf;
    EditText editText;
    String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        out = (TextView) this.findViewById(R.id.showtext);
        //Carry data from editTExt by the ID UserHome
        editText = (EditText)findViewById(R.id.UserHome);
        //Get SharedPreferenced object
        mSpf = super.getSharedPreferences("postcode",MODE_PRIVATE);
    }
    //Send a message to map activity and open it
    public void goToMap(View view) {
        //Respond to the button
        Intent intent = new Intent(this, stratMap.class);
        //Get the string from text
        message = editText.getText().toString();
        //Put the data to intent
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void save(View view) {
                //Get edit object
                SharedPreferences.Editor editor = mSpf.edit();
                //Write data through the editor object
                editor.putString("addr", editText.getText().toString());
                //Submit data to xml file
                editor.commit();
    }

    public void read(View view) {
        //To fetch the data, the first parameter is the key to be written,
        //and the second parameter is the value returned by default if no data is obtained.
        String info = mSpf.getString("addr", "Null");
        out.setText(info);
    }
}
