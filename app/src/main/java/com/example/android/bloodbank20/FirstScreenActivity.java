package com.example.android.bloodbank20;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class FirstScreenActivity extends AppCompatActivity {

   ImageView newdonarbutn ,needdonarbutn;

    TextView newdonartxt, needdonartxt;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);

      newdonarbutn = (ImageView) findViewById(R.id.profile_image);

      needdonarbutn = (ImageView) findViewById(R.id.profile_images);


      newdonartxt =(TextView)findViewById(R.id.newdonar);

        needdonartxt = (TextView)findViewById(R.id.needaDonar);

    }
    public void Instantmessage(View view)
    {
        Intent intent = new Intent(this,MessageActivity.class);

        startActivity(intent);

    }
    public void Requirements(View view)
    {
        Intent intent = new Intent(this,Requirements.class);

        startActivity(intent);

        //  startActivity(new Intent(this,Requirements.class));
    }

    public void Newdonar(View view)
    {
        Intent intent = new Intent(this,NewDonar.class);

        startActivity(intent);

    }
    public void Needdonar(View view)
    {
        Intent intent = new Intent(this,PasswordActivity.class);

        startActivity(intent);

    }
}
