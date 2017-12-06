package com.example.diak.android_2017_12_06;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Button btn_submit;
    private EditText edit_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        listeners();

    }

    public void init() {

        btn_submit = (Button) findViewById(R.id.btn_submit);
        edit_name = (EditText) findViewById(R.id.edit_name);


    }

    public void listeners() {

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name",edit_name.getText().toString());
                editor.commit();

                Toast.makeText(MainActivity.this, "Adat mentve", Toast.LENGTH_SHORT).show();

                Intent gonext = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(gonext);
                finish();
            }
        });


    }
}
