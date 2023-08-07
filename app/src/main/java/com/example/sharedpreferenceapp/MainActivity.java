package com.example.sharedpreferenceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;
     Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredText = editText.getText().toString();
                DisplayAndSaveText(enteredText);
            }
        });
        DisplaySavedText();

    }

    private void DisplaySavedText() {
        //Retrieving the value from SharedPref
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        String s1 = sharedPreferences.getString("name"," ");
        textView.setText(s1);
    }

    private void DisplayAndSaveText(String enteredText) {
        //Display the Text
        textView.setText(enteredText);

        //Saving the text int SharedPref
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);

        //writing data to sharedPref
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name",enteredText);
        editor.commit();
    }
}