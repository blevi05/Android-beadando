package com.example.diak.android_2017_12_06;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private Button btn_next, btn_new, btn_inform, btn_exit;
    private EditText editText;

    private AlertDialog.Builder alert_vege;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        init();
        listeners();


        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);

        editText.setText(sharedPreferences.getString("name: ",null));

    }

    public void init() {

        btn_next = (Button) findViewById(R.id.btn_next);
        btn_new = (Button) findViewById(R.id.btn_new);
        btn_inform = (Button) findViewById(R.id.btn_inform);
        btn_exit = (Button) findViewById(R.id.btn_exit);

        editText = (EditText) findViewById(R.id.edit_1);

    }

    public void listeners() {

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            Intent gonext = new Intent(Main2Activity.this, Main3Activity.class);
            startActivity(gonext);
            finish();

            }
        });

        btn_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent gonext_new = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(gonext_new);
                finish();

            }
        });

        btn_inform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
                String informacio = sharedPreferences.getString("name",null);
                Toast.makeText(Main2Activity.this, "Neved:" + informacio, Toast.LENGTH_SHORT).show();

            }
        });

        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                alert_vege = new AlertDialog.Builder(Main2Activity.this);
                alert_vege.setTitle("Biztos kilépsz?")
                        .setMessage("Biztos ki szeretnél lépni a progrmaból?")
                        .setPositiveButton("Folytatom", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {


                            }
                        })

                        .setNegativeButton("Kilépek", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();

                            }
                        })

                        .setCancelable(false)
                        .create();
                        alert_vege.show();
            }
        });


    }
}