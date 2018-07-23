package com.example.cybertech2.timee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {
     TextView textView;
     EditText editTextName,editTextPhoneNumber;
     Button buttonConfirm;
     int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        textView = findViewById(R.id.textRegister);
        editTextName = findViewById(R.id.editTextName);
        editTextPhoneNumber = findViewById(R.id.editTextPhone);
        buttonConfirm = findViewById(R.id.textRegister);

        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextName.getText().length()<12 && editTextPhoneNumber.getText().length()!=12 ){
                    Toast toast = Toast.makeText(getApplicationContext(),"eofjwperofjrew",Toast.LENGTH_SHORT);
                        toast.show();
                }
            }
        });


    }
}
