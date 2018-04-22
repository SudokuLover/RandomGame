package com.example.gauranggoel.randomgamebasedonet21042018;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2;
    Button btn,btn1;
    int n=5,sc=0,l=0,tt5=0,tt6=0;
    double d=0;
    TextView t1,t2,t3,t4,t5,t6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        e1= (EditText) findViewById(R.id.editText);
        e2= (EditText) findViewById(R.id.editText2);
        btn= (Button) findViewById(R.id.button);

        btn1= (Button) findViewById(R.id.button2);
        btn1.setVisibility(View.GONE);

        t1= (TextView) findViewById(R.id.textView);
        t2= (TextView) findViewById(R.id.textView2);
        t3= (TextView) findViewById(R.id.textView3);
        t4= (TextView) findViewById(R.id.textView4);
        t5= (TextView) findViewById(R.id.textView5);
        t6= (TextView) findViewById(R.id.textView6);

        t2.setText("SCORE:\n "+(sc));
        t1.setText("Attempts remains: \n"+n);

        t4.setText("No.Of Chances Played: \n"+l);

        t3.setText("ACCURACY:\n "+d);

        t5.setText("N0. Of Game Played:\n"+ tt5);
        t6.setText("N0. Of Game Won:\n"+ tt6);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
             public void onClick(View v) {

                n--;

                int num=Integer.parseInt(e1.getText().toString());

                Random random= new Random();

                int random_Number= random.nextInt(10)+1;

                e2.setText(""+random_Number);

                t4.setText("No.Of Chances Played:\n "+ ++l);

                if(num==random_Number) {
                    Toast.makeText(MainActivity.this, "You Won", Toast.LENGTH_LONG).show();
                    t2.setText("SCORE:\n "+(++sc));
                    d++;
                    n++;

                }else
                    Toast.makeText(MainActivity.this,"You Loss",Toast.LENGTH_LONG).show();

                t1.setText("Attempts remains: \n"+n);
                if(n==0) {
                    tt5++;
                    if(sc>0)
                        tt6++;

                    btn.setVisibility(View.GONE);
                    btn1.setVisibility(View.VISIBLE);
                }
                t5.setText("N0. Of Game Played:\n"+ tt5);
                t6.setText("N0. Of Game Won:\n"+ tt6);

                t3.setText("ACCURACY:\n "+(d*100/(l))+"%");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                n=5;
                sc=0;
                l=0;
                d=0;

                btn.setVisibility(View.VISIBLE);
                btn1.setVisibility(View.GONE);
                t1.setText("Attempts remains: \n"+n);
                t2.setText("SCORE: \n"+sc);
                t3.setText("ACCURACY:\n "+d);
                t4.setText("No.Of Chances Played: \n"+l);

                e1.setText("");
                e2.setText("");
            }
        });
    }
}
