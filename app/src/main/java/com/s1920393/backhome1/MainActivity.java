package com.s1920393.backhome1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE ="com.s1920393.backhome1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //Send a message to map activity and open it
    public void goToMap(View view) {
        //Respond to the button
        Intent intent = new Intent(this, stratMap.class);
        //Carry data from editTExt by the ID UserHome
        EditText editText = (EditText)findViewById(R.id.UserHome);
        //Get the string from text
        String message = editText.getText().toString();
        //Put the data to intent
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
