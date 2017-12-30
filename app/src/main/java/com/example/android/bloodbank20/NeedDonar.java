package com.example.android.bloodbank20;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class NeedDonar extends AppCompatActivity {




    Button Opositive,Onegative,Apositive,Anegative,Bpositive,Bnegative,ABnegative,ABpositive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_need_donar);


        Apositive = (Button)findViewById(R.id.apositive) ;

        Bpositive  = (Button)findViewById(R.id.bpositive);

        Opositive   = (Button)findViewById(R.id.opositive);

        ABpositive  = (Button)findViewById(R.id.abpositive);

        Anegative   = (Button)findViewById(R.id.anegative);

        Onegative    = (Button)findViewById(R.id.onegative);

        Bnegative    = (Button)findViewById(R.id.bnegative);

        ABnegative   = (Button)findViewById(R.id.abnegative);
    }
      public void bnegativegroup(View view)
      {
          startActivity(new Intent(this,Bnegative.class));

      }
      public void update(View view)
      {
          Intent intent = new Intent(this,Newpassword.class);
          startActivity(intent);
      }

      public  void onegativegroup(View view)
      {
          startActivity(new Intent(this,Onegative.class));
      }

      public void anegativegroup(View view)
      {
          startActivity(new Intent(this,Anegative.class));
      }
      public void abnegativegroup(View view)
      {
          startActivity(new Intent(this,ABnegative.class));
      }
      public void opositivegroup(View view)
      {
          startActivity(new Intent(this,Opositive.class));
      }

      public void bpositivegroup(View view)
      {
          startActivity(new Intent(this,Bpositive.class));
      }

      public void abpositivegroup(View view)
      {
          startActivity(new Intent(this,ABpositive.class));
      }

      public void apositivegroup(View view)
      {
          startActivity(new Intent(this,Apositive.class));
      }

      public void aonepositive(View view)
      {
          startActivity(new Intent(this,ABPositives.class));
      }
     public void atwopositive(View view)
     {
         startActivity(new Intent(this,ABPositivesss.class));
     }
}
