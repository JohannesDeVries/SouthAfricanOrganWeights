package com.example.johannesdevries.southafricanorganweights;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;

public class Results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);


        //receive data from OrganWeight
        Bundle organData = getIntent().getExtras();
        if(organData==null){
            return;
        }

        String brainMessage = organData.getString("brainMessage");
        final TextView brainPre = (TextView) findViewById(R.id.brainPre);
        brainPre.setText(brainMessage);

        String heartMessage = organData.getString("heartMessage");
        final TextView heartPre = (TextView) findViewById(R.id.heartPre);
        heartPre.setText(heartMessage);

        String rlungMessage = organData.getString("rlungMessage");
        final TextView rlungPre = (TextView) findViewById(R.id.rlungPre);
        rlungPre.setText(rlungMessage);

        String llungMessage = organData.getString("llungMessage");
        final TextView llungPre = (TextView) findViewById(R.id.llungPre);
        llungPre.setText(llungMessage);

        String liverMessage = organData.getString("liverMessage");
        final TextView liverPre = (TextView) findViewById(R.id.liverPre);
        liverPre.setText(liverMessage);

        String spleenMessage = organData.getString("spleenMessage");
        final TextView spleenPre = (TextView) findViewById(R.id.spleenPre);
        spleenPre.setText(spleenMessage);

        String rkidneyMessage = organData.getString("rkidneyMessage");
        final TextView rkidneyPre = (TextView) findViewById(R.id.rkidneyPre);
        rkidneyPre.setText(rkidneyMessage);

        String lkidneyMessage = organData.getString("lkidneyMessage");
        final TextView lkidneyPre = (TextView) findViewById(R.id.lkidneyPre);
        lkidneyPre.setText(lkidneyMessage);


        String sexMessage = organData.getString("sexMessage");
        if(sexMessage.equals("f")){
            final TextView brainId = (TextView) findViewById(R.id.brainId);
            brainId.setText("1043 - 1521g");

            final TextView heartId = (TextView) findViewById(R.id.heartId);
            heartId.setText("164 - 317g");

            final TextView rlungId = (TextView) findViewById(R.id.rlungId);
            rlungId.setText("148 - 569g");

            final TextView llungId = (TextView) findViewById(R.id.llungId);
            llungId.setText("145 - 496g");

            final TextView liverId = (TextView) findViewById(R.id.liverId);
            liverId.setText("707 - 1662g");

            final TextView spleenId = (TextView) findViewById(R.id.spleenId);
            spleenId.setText("< 189g");

            final TextView rkidneyId = (TextView) findViewById(R.id.rkidneyId);
            rkidneyId.setText("60 - 151g");

            final TextView lkidneyId = (TextView) findViewById(R.id.lkidneyId);
            lkidneyId.setText("64 - 154g");
        }


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */
    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_organ_weights, menu);
        return true;
    }
*/
}
