package com.example.johannesdevries.southafricanorganweights;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;


public class OrganWeights extends AppCompatActivity {


    String sex, race;  //sex = m/f    race = b/w/c
    int age, height, weight; //age = years     height = cm    weight = kg

    RadioGroup sexGroup;
    RadioGroup raceGroup;
    RadioButton blackRadioButton;
    RadioButton maleRadioButton;


    SeekBar ageSeek;
    EditText ageInput;

    SeekBar weightSeek;
    EditText weightInput;

    SeekBar heightSeek;
    EditText heightInput;

    int weightDelta;
    int heightDelta;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_organ_weights);

        sexGroup = (RadioGroup) findViewById(R.id.sexGroup);
        raceGroup = (RadioGroup) findViewById(R.id.raceGroup);
        blackRadioButton = (RadioButton)findViewById(R.id.blackRadio);
        maleRadioButton = (RadioButton)findViewById(R.id.maleRadio);

        ageSeek = (SeekBar)findViewById(R.id.ageSeek);
        ageInput = (EditText) findViewById(R.id.ageInput);

        weightSeek = (SeekBar)findViewById(R.id.weightSeek);
        weightInput = (EditText) findViewById(R.id.weightInput);

        heightSeek = (SeekBar)findViewById(R.id.heightSeek);
        heightInput = (EditText) findViewById(R.id.heightInput);

        sexGroup.check(maleRadioButton.getId());
        raceGroup.check(blackRadioButton.getId());

        weightDelta = 35;
        heightDelta = 135;

        sex = "m";
        race = "b";


        Button aboutButton = (Button)findViewById(R.id.aboutButton);

        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OrganWeights.this, About.class));
            }
        });


        sexGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                // racechecked = radioGroup.indexOfChild(findViewById(i));
                switch (i){
                    case R.id.maleRadio:
                        sex = "m";
                        raceGroup.check(blackRadioButton.getId());

                        heightDelta = 135;
                        heightSeek.setProgress(170-heightDelta);
                        heightInput.setText("170");
                        heightSeek.setMax(200-heightDelta);

                        ageSeek.setProgress(30-18);
                        ageInput.setText("30");

                        weightDelta = 35;
                        weightSeek.setProgress(70-weightDelta);
                        weightInput.setText("70");
                        weightSeek.setMax(200-weightDelta);

                        break;
                    case R.id.femaleRadio:
                        sex = "f";
                        raceGroup.check(blackRadioButton.getId());

                        heightDelta = 135;
                        heightSeek.setProgress(160-heightDelta);
                        heightInput.setText("160");
                        heightSeek.setMax(185-heightDelta);

                        ageSeek.setProgress(30-18);
                        ageInput.setText("30");

                        weightDelta = 25;
                        weightSeek.setProgress(70-weightDelta);
                        weightInput.setText("70");
                        weightSeek.setMax(150-weightDelta);

                        break;
                    default:
                        break;

                }
            }
        });

        raceGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                // racechecked = radioGroup.indexOfChild(findViewById(i));
                switch (i){
                    case R.id.whiteRadio:
                        race = "w";
                        break;
                    case R.id.blackRadio:
                        race = "b";
                        break;
                    case R.id.colouredRadio:
                        race = "c";
                        break;
                    default:
                        break;

                }
            }
        });


        heightSeek.setProgress(170-heightDelta);
        heightInput.setText("170");

        heightSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                heightInput.setText((Integer.toString(progress+heightDelta)));
            }
        });

        ageSeek.setProgress(30-18);
        ageInput.setText("30");

        ageSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ageInput.setText((Integer.toString(progress+18)));
            }
        });

        weightSeek.setProgress(70-weightDelta);
        weightInput.setText("70");

        weightSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                weightInput.setText((Integer.toString(progress+weightDelta)));
            }
        });





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

    public void onClick(View view){
        //create instance of intent class
        //add calculations
        Intent i = new Intent(this, Results.class);



        double pHeart = 0;
        double pBrain = 0;
        double pRlung = 0;
        double pLlung = 0;
        double pLiver = 0;
        double pSpleen = 0;
        double pRkidney = 0;
        double pLkidney = 0;

        double calcHeart = 0;
        double calcBrain = 0;
        double calcRlung = 0;
        double calcLlung = 0;
        double calcSpleen = 0;
        double calcLiver = 0;
        double calcRkidney = 0;
        double calcLkidney = 0;

        int[][] inputHeart = new int[10][1];
        int[][] inputBrain = new int[10][1];
        int[][] inputRlung = new int[14][1];
        int[][] inputLlung = new int[14][1];
        int[][] inputLiver = new int[9][1];
        int[][] inputSpleen = new int[8][1];
        int[][] inputRkidney = new int[9][1];
        int[][] inputLkidney = new int[9][1];

        double heartMatrixNext [][] = new double [10][1];
        double brainMatrixNext [][] = new double [10][1];
        double rlungMatrixNext [][] = new double [14][1];
        double llungMatrixNext [][] = new double [14][1];
        double liverMatrixNext [][] = new double [9][1];
        double spleenMatrixNext [][] = new double [8][1];
        double rkidneyMatrixNext [][] = new double [9][1];
        double lkidneyMatrixNext [][] = new double [9][1];


        //get data from text field, save as String/Int variable, send over to other activity
        //final EditText sexInput = (EditText) findViewById(R.id.sexInput);
        //sex = sexInput.getText().toString();

        //final EditText raceInput = (EditText) findViewById(R.id.raceInput);
        //race = raceInput.getText().toString();

        final EditText ageInput = (EditText) findViewById(R.id.ageInput);
        age = Integer.parseInt(ageInput.getText().toString());

        final EditText heightInput = (EditText) findViewById(R.id.heightInput);
        height = Integer.parseInt(heightInput.getText().toString());

        final EditText weightInput = (EditText) findViewById(R.id.weightInput);
        weight = Integer.parseInt(weightInput.getText().toString());




        if(sex.equals("f")){
            inputHeart[0][0] = 1;
            inputBrain[0][0] = 1;
            inputRlung[0][0] = 1;
            inputLlung[0][0] = 1;
            inputLiver[0][0] = 1;
            inputRkidney[0][0] = 1;
            inputLkidney[0][0] = 1;
        }
        else{
            inputHeart[0][0] = 0;
            inputBrain[0][0] = 0;
            inputRlung[0][0] = 0;
            inputLlung[0][0] = 0;
            inputLiver[0][0] = 0;
            inputRkidney[0][0] = 0;
            inputLkidney[0][0] = 0;
        }

        if(race.equals("b")){
            inputHeart[1][0] = 0;
            inputHeart[2][0] = 0;

            inputBrain[1][0] = 0;
            inputBrain[2][0] = 0;

            inputRlung[1][0] = 0;
            inputRlung[2][0] = 0;

            inputLlung[1][0] = 0;
            inputLlung[2][0] = 0;

            inputLiver[1][0] = 0;
            inputLiver[2][0] = 0;

            inputSpleen[0][0] = 0;
            inputSpleen[1][0] = 0;

            inputRkidney[1][0] = 0;
            inputRkidney[2][0] = 0;

            inputLkidney[1][0] = 0;
            inputLkidney[2][0] = 0;


        }
        else if(race.equals("w")){
            inputHeart[1][0] = 1;
            inputHeart[2][0] = 0;

            inputBrain[1][0] = 1;
            inputBrain[2][0] = 0;

            inputRlung[1][0] = 1;
            inputRlung[2][0] = 0;

            inputLlung[1][0] = 1;
            inputLlung[2][0] = 0;

            inputLiver[1][0] = 1;
            inputLiver[2][0] = 0;

            inputSpleen[0][0] = 1;
            inputSpleen[1][0] = 0;

            inputRkidney[1][0] = 1;
            inputRkidney[2][0] = 0;

            inputLkidney[1][0] = 1;
            inputLkidney[2][0] = 0;
        }
        else{
            inputHeart[1][0] = 0;
            inputHeart[2][0] = 1;

            inputBrain[1][0] = 0;
            inputBrain[2][0] = 1;

            inputRlung[1][0] = 0;
            inputRlung[2][0] = 1;

            inputLlung[1][0] = 0;
            inputLlung[2][0] = 1;

            inputLiver[1][0] = 0;
            inputLiver[2][0] = 1;

            inputSpleen[0][0] = 0;
            inputSpleen[1][0] = 1;

            inputRkidney[1][0] = 0;
            inputRkidney[2][0] = 1;

            inputLkidney[1][0] = 0;
            inputLkidney[2][0] = 1;
        }

        inputHeart[3][0] = age;
        inputHeart[4][0] = height;
        inputHeart[5][0] = weight;
        inputHeart[6][0] = inputHeart[0][0]*inputHeart[5][0];
        inputHeart[7][0] = inputHeart[0][0]*inputHeart[1][0];
        inputHeart[8][0] = inputHeart[0][0]*inputHeart[2][0];
        inputHeart[9][0] = 1;

        inputBrain[3][0] = age;
        inputBrain[4][0] = height;
        inputBrain[5][0] = weight;
        inputBrain[6][0] = inputBrain[0][0]*inputBrain[3][0];
        inputBrain[7][0] = inputBrain[0][0]*inputBrain[1][0];
        inputBrain[8][0] = inputBrain[0][0]*inputBrain[2][0];
        inputBrain[9][0] = 1;

        inputRlung[3][0] = age;
        inputRlung[4][0] = height;
        inputRlung[5][0] = weight;
        inputRlung[6][0] = inputRlung[0][0]*inputRlung[3][0];
        inputRlung[7][0] = inputRlung[0][0]*inputRlung[1][0];
        inputRlung[8][0] = inputRlung[0][0]*inputRlung[2][0];
        inputRlung[9][0] = inputRlung[1][0]*inputRlung[3][0];
        inputRlung[10][0] = inputRlung[1][0]*inputRlung[5][0];
        inputRlung[11][0] = inputRlung[2][0]*inputRlung[3][0];
        inputRlung[12][0] = inputRlung[2][0]*inputRlung[5][0];
        inputRlung[13][0] = 1;

        inputLlung[3][0] = age;
        inputLlung[4][0] = height;
        inputLlung[5][0] = weight;
        inputLlung[6][0] = inputLlung[0][0]*inputLlung[3][0];
        inputLlung[7][0] = inputLlung[0][0]*inputLlung[1][0];
        inputLlung[8][0] = inputLlung[0][0]*inputLlung[2][0];
        inputLlung[9][0] = inputLlung[1][0]*inputLlung[3][0];
        inputLlung[10][0] = inputLlung[1][0]*inputLlung[5][0];
        inputLlung[11][0] = inputLlung[2][0]*inputLlung[3][0];
        inputLlung[12][0] = inputLlung[2][0]*inputLlung[5][0];
        inputLlung[13][0] = 1;

        inputLiver[3][0] = age;
        inputLiver[4][0] = height;
        inputLiver[5][0] = weight;
        inputLiver[6][0] = inputLiver[1][0]*inputLiver[3][0];
        inputLiver[7][0] = inputLiver[2][0]*inputLiver[3][0];
        inputLiver[8][0] = 1;

        inputSpleen[2][0] = age;
        inputSpleen[3][0] = height;
        inputSpleen[4][0] = weight;
        inputSpleen[5][0] = inputSpleen[0][0]*inputSpleen[4][0];
        inputSpleen[6][0] = inputSpleen[1][0]*inputSpleen[4][0];
        inputSpleen[7][0] = 1;

        inputRkidney[3][0] = age;
        inputRkidney[4][0] = height;
        inputRkidney[5][0] = weight;
        inputRkidney[6][0] = inputRkidney[0][0]*inputRkidney[3][0];
        inputRkidney[7][0] = inputRkidney[0][0]*inputRkidney[5][0];
        inputRkidney[8][0] = 1;

        inputLkidney[3][0] = age;
        inputLkidney[4][0] = height;
        inputLkidney[5][0] = weight;
        inputLkidney[6][0] = inputLkidney[0][0]*inputLkidney[3][0];
        inputLkidney[7][0] = inputLkidney[0][0]*inputLkidney[5][0];
        inputLkidney[8][0] = 1;



        //CALCULATE P ....
        double [][] coefHeart  = {{ -7.886036 },
                { 9.761264 },
                { -5.299839 },
                { 1.035107},
                { 0.5265666},
                { 1.87055},
                { -0.5884666},
                { 4.621931 },
                { 21.35064},
                { 60.08412 }};


        double [][] coefBrain = {{ -61.21363 },
                { 14.9703 },
                { -48.38613 },
                { -1.232043 },
                { 1.846671 },
                { 0.6833222 },
                { -1.561691 },
                { 48.13198 },
                { 17.41346 },
                { 1095.802 }};

        double [][] coefRlung = {{ 21.68094 },
                { -14.88376 },
                { -2.632056 },
                { 2.710012},
                { 0.7459987 },
                { 0.0296956 },
                { -1.97751 },
                { 113.254 },
                { -18.01576 },
                { -2.583524 },
                { 1.403674 },
                { -0.6259564 },
                { 0.3157665 },
                { 190.4043 }};

        double [][] coefLlung = {{ -10.11308 },
                { 28.1533 },
                { 0.8818888 },
                { 1.916791},
                { 2.1721 },
                { -0.0227646 },
                { -1.038797},
                { 109.0594},
                { -0.799587 },
                { -2.4836 },
                { 0.9485997 },
                { -0.1465953 },
                { -0.0164519 },
                { -56.32341 }};

        double [][] coefLiver = {{ -0.0422287 },
                { 0.2455466 },
                { 0.1686659 },
                { 0.0021543},
                { 0.0023987 },
                { 0.0052956 },
                { -0.0041007},
                { -0.0033368},
                { 6.305185 }};

        double [][] coefSpleen = {{ 0.1299233 },
                { -0.2977356 },
                { -0.0023161 },
                { 0.0037507},
                { 0.0072083 },
                { 0.0020634 },
                { 0.0047591},
                { 3.436634 }};

        double [][] coefRkidney = {{ 0.18164 },
                { 0.0675104 },
                { 0.0485123 },
                { 0.001918},
                { 0.0025523 },
                { 0.0060408},
                { -0.0023469},
                { -0.0021669},
                { 3.825807 }};

        double [][] coefLkidney = {{ 0.1617607 },
                { 0.0634176 },
                { 0.0483177 },
                { 0.0019389},
                { 0.0029617 },
                { 0.0058376},
                { -0.0029935},
                { -0.0016939},
                { 3.804954 }};

        //P. HEART,BRAIN
        for (int l = 0; l < 10; l++) {
            for (int j = 0; j < 1; j++) {
                pHeart += coefHeart[l][j] * inputHeart[l][j];
                pBrain += coefBrain[l][j] * inputBrain[l][j];

            }
        }

        //P. RLUNG,LLUNG
        for (int l = 0; l < 14; l++) {
            for (int j = 0; j < 1; j++) {
                pRlung += coefRlung[l][j] * inputRlung[l][j];
                pLlung += coefLlung[l][j] * inputLlung[l][j];
            }
        }

        //P. LIVER,RKIDNEY,LKIDNEY
        for (int l = 0; l < 9; l++) {
            for (int j = 0; j < 1; j++) {
                pLiver += coefLiver[l][j] * inputLiver[l][j];
                pRkidney += coefRkidney[l][j] * inputRkidney[l][j];
                pLkidney += coefLkidney[l][j] * inputLkidney[l][j];
            }
        }

        //P. SPLEEN
        for (int l = 0; l < 8; l++) {
            for (int j = 0; j < 1; j++) {
                pSpleen += coefSpleen[l][j] * inputSpleen[l][j];
            }
        }



        //CALCULATE S.E. ....
        double heartMatrix [][] = {{ 0.07495089,-0.00219826,0.00372449,-0.00001065,0.00015788,0.00028557,-0.00088651,-0.00928871,-0.01749712,-0.04894422},
                { -0.00219826,0.01000007,0.00275674,-0.00001356,-0.00006013,-0.00005371,0.00006554,-0.00961105,-0.00267686,0.01152497},
                { 0.00372449,0.00275674,0.00582461,-0.000002626,0.0000145,0.000007103,-0.000009797,-0.00275329,-0.00580072,-0.00577359},
                { -0.00001065,-0.00001356,-0.000002626,0.000002884,0.000000801,-0.0000007139,0.0000004833,-0.00003622,-0.00001823,-0.00020552},
                { 0.00015788,-0.00006013,0.0000145,0.000000801,0.0000173,-0.000003361,0.00000004073,-0.0000006573,-0.00001479,-0.00273646},
                { 0.00028557,-0.00005371,0.000007103,-0.0000007139,-0.000003361,0.000005302,-0.000004642,0.00007473,-0.000002961,0.00023423},
                { -0.00088651,0.00006554,-0.000009797,0.0000004833,0.00000004073,-0.000004642,0.00001218,-0.000001118,0.00011414,0.00029294},
                { -0.00928871,-0.00961105,-0.00275329,-0.00003622,-0.0000006573,0.00007473,-0.000001118,0.03016691,0.00980057,-0.0006114 },
                { -0.01749712,-0.00267686,-0.00580072,-0.00001823,-0.00001479,-0.000002961,0.00011414,0.00980057,0.01988321,0.00639601},
                { -0.04894422,0.01152497,-0.00577359,-0.00020552,-0.00273646,0.00023423,0.00029294,-0.0006114,0.00639601,0.45939693}};

        double brainMatrix [][] = {{0.02776135,0.00192185,0.00281597,0.00018139,0.00011173,-0.00005926,-0.00046832,-0.00368142,-0.00707954,-0.02527514},
                {0.00192185,0.00967175,0.0028168,-0.00002205,-0.0000585,-0.00002847,0.00001759,-0.0098187,-0.0033704,0.00986019},
                {0.00281597,0.0028168,0.00581893,-0.000004001,0.00001509,0.000003445,0.000005268,-0.00281818,-0.00573259,-0.00556422},
                {0.00018139,-0.00002205,-0.000004001,0.000004282,0.0000003555,-0.0000005916,-0.000004233,0.00001524,-0.000003709,-0.00019599},
                {0.00011173,-0.0000585,0.00001509,0.0000003555,0.00001744,-0.000003326,0.000001325,-0.00001675,-0.00002114,-0.00274407},
                {-0.00005926,-0.00002847,0.000003445,-0.0000005916,-0.000003326,0.000003535,0.0000001852,0.00007205,0.00003972,0.00034499},
                {-0.00046832,0.00001759,0.000005268,-0.000004233,0.000001325,0.0000001852,0.00001264,-0.00015351,-0.00005687,-0.00006316},
                {-0.00368142,-0.0098187,-0.00281818,0.00001524,-0.00001675,0.00007205,-0.00015351,0.03203145,0.01050183,0.00018265},
                {-0.00707954,-0.0033704,-0.00573259,-0.000003709,-0.00002114,0.00003972,-0.00005687,0.01050183,0.0190692,0.00393416},
                {-0.02527514,0.00986019,-0.00556422,-0.00019599,-0.00274407,0.00034499,-0.00006316,0.00018265,0.00393416,0.45266457}};

        double rlungMatrix [][] = {{ 0.02787668,-0.00009578,0.00309496,0.00019877,0.00011044,-0.00007134,-0.00046706,-0.00334896,-0.00726754,-0.00002546,0.00003938,-0.0000233,0.000009866,-0.02494011},
                { -0.00009578,0.16414806,0.03609919,0.00025605,-0.0000765,0.00033792,0.00004127,-0.02701793,-0.00227999,-0.0007943,-0.00147144,-0.00027403,-0.00031818,-0.02378594},
                { 0.00309496,0.03609919,0.08600836,0.00026768,0.0000534,0.00034771,-0.00001944,-0.00132409,-0.00738233,-0.00025521,-0.00033598,-0.00048111,-0.00088947,-0.04697249},
                { 0.00019877,0.00025605,0.00026768,0.00001039,0.00000005899,-0.000001806,-0.000003678,-0.00001414,-0.0000432,-0.000009094,0.000001625,-0.000009036,0.000001496,-0.00031359},
                {0.00011044,-0.0000765,0.0000534,0.00000005899,0.00001752,-0.000003017,0.000001278,-0.00001572,-0.00001869,0.0000009364,-0.0000003564,0.0000001221,-0.0000006356,-0.00276638},
                {-0.00007134,0.00033792,0.00034771,-0.000001806,-0.000003017,0.000006771,-0.0000001896,0.00005883,0.00005426,0.000001646,-0.000005797,0.000001764,-0.000006139,0.00011978},
                {-0.00046706,0.00004127,-0.00001944,-0.000003678,0.000001278,-0.0000001896,0.00001274,-0.00016425,-0.00005949,-0.0000007003,0.000000143,-0.000000949,0.0000009468,-0.00005215},
                { -0.00334896,-0.02701793,-0.00132409,-0.00001414,-0.00001572,0.00005883,-0.00016425,0.0355093,0.01014301,0.00002934,0.00019259,0.00007383,-0.00006875,0.00212942},
                { -0.00726754,-0.00227999,-0.00738233,-0.0000432,-0.00001869,0.00005426,-0.00005949,0.01014301,0.0194198,0.00006277,-0.00004837,0.00005244,-0.0000073,0.00414565},
                { -0.00002546,-0.0007943,-0.00025521,-0.000009094,0.0000009364,0.000001646,-0.0000007003,0.00002934,0.00006277,0.00001985,-0.000001496,0.000009386,-0.000001903,0.00010255},
                { 0.00003938,-0.00147144,-0.00033598,0.000001625,-0.0000003564,-0.000005797,0.000000143,0.00019259,-0.00004837,-0.000001496,0.00001929,-0.000001691,0.000005885,0.00039284},
                { -0.0000233,-0.00027403,-0.00048111,-0.000009036,0.0000001221,0.000001764,-0.000000949,0.00007383,0.00005244,0.000009386,-0.000001691,0.00001614,-0.000002777,0.0002301},
                { 0.000009866,-0.00031818,-0.00088947,0.000001496,-0.0000006356,-0.000006139,0.0000009468,-0.00006875,-0.0000073,-0.000001903,0.000005885,-0.000002777,0.00001483,0.00046906},
                { -0.02494011,-0.02378594,-0.04697249,-0.00031359,-0.00276638,0.00011978,-0.00005215,0.00212942,0.00414565,0.00010255,0.00039284,0.0002301,0.00046906,0.47680968}};

        double llungMatrix [][] = {{ 0.02787668,-0.00009578,0.00309496,0.00019877,0.00011044,-0.00007134,-0.00046706,-0.00334896,-0.00726754,-0.00002546,0.00003938,-0.0000233,0.000009866,-0.02494011},
                { -0.00009578,0.16414806,0.03609919,0.00025605,-0.0000765,0.00033792,0.00004127,-0.02701793,-0.00227999,-0.0007943,-0.00147144,-0.00027403,-0.00031818,-0.02378594},
                { 0.00309496,0.03609919,0.08600836,0.00026768,0.0000534,0.00034771,-0.00001944,-0.00132409,-0.00738233,-0.00025521,-0.00033598,-0.00048111,-0.00088947,-0.04697249},
                { 0.00019877,0.00025605,0.00026768,0.00001039,0.00000005899,-0.000001806,-0.000003678,-0.00001414,-0.0000432,-0.000009094,0.000001625,-0.000009036,0.000001496,-0.00031359},
                { 0.00011044,-0.0000765,0.0000534,0.00000005899,0.00001752,-0.000003017,0.000001278,-0.00001572,-0.00001869,0.0000009364,-0.0000003564,0.0000001221,-0.0000006356,-0.00276638},
                { -0.00007134,0.00033792,0.00034771,-0.000001806,-0.000003017,0.000006771,-0.0000001896,0.00005883,0.00005426,0.000001646,-0.000005797,0.000001764,-0.000006139,0.00011978},
                { -0.00046706,0.00004127,-0.00001944,-0.000003678,0.000001278,-0.0000001896,0.00001274,-0.00016425,-0.00005949,-0.0000007003,0.000000143,-0.000000949,0.0000009468,-0.00005215},
                { -0.00334896,-0.02701793,-0.00132409,-0.00001414,-0.00001572,0.00005883,-0.00016425,0.0355093,0.01014301,0.00002934,0.00019259,0.00007383,-0.00006875,0.00212942},
                { -0.00726754,-0.00227999,-0.00738233,-0.0000432,-0.00001869,0.00005426,-0.00005949,0.01014301,0.0194198,0.00006277,-0.00004837,0.00005244,-0.0000073,0.00414565},
                { -0.00002546,-0.0007943,-0.00025521,-0.000009094,0.0000009364,0.000001646,-0.0000007003,0.00002934,0.00006277,0.00001985,-0.000001496,0.000009386,-0.000001903,0.00010255},
                { 0.00003938,-0.00147144,-0.00033598,0.000001625,-0.0000003564,-0.000005797,0.000000143,0.00019259,-0.00004837,-0.000001496,0.00001929,-0.000001691,0.000005885,0.00039284},
                { -0.0000233,-0.00027403,-0.00048111,-0.000009036,0.0000001221,0.000001764,-0.000000949,0.00007383,0.00005244,0.000009386,-0.000001691,0.00001614,-0.000002777,0.0002301},
                { 0.000009866,-0.00031818,-0.00088947,0.000001496,-0.0000006356,-0.000006139,0.0000009468,-0.00006875,-0.0000073,-0.000001903,0.000005885,-0.000002777,0.00001483,0.00046906},
                { -0.02494011,-0.02378594,-0.04697249,-0.00031359,-0.00276638,0.00011978,-0.00005215,0.00212942,0.00414565,0.00010255,0.00039284,0.0002301,0.00046906,0.47680968}};

        double liverMatrix [][] = {{ 0.00511124,0.00026872,0.00106809,0.00002197,0.00015425,-0.00002348,-0.00001754,-0.00001996,-0.02668146},
                { 0.00026872,0.04644035,0.01553964,0.00035417,-0.00010517,-0.00003202,-0.00087649,-0.00035325,0.00383206},
                { 0.00106809,0.01553964,0.02944856,0.00034278,0.000006545,0.000002222,-0.00034438,-0.0006247,-0.01708038},
                { 0.00002197,0.00035417,0.00034278,0.000008831,0.0000004892,-0.0000007283,-0.00000887,-0.000008762,-0.0003858},
                { 0.00015425,-0.00010517,0.000006545,0.0000004892,0.00001735,-0.0000033,0.0000009524,0.000000104,-0.00273324},
                { -0.00002348,-0.00003202,0.000002222,-0.0000007283,-0.0000033,0.000003351,0.0000006043,0.0000003301,0.00034928},
                { -0.00001754,-0.00087649,-0.00034438,-0.00000887,0.0000009524,0.0000006043,0.00001937,0.00000884,0.00015392},
                { -0.00001996,-0.00035325,-0.0006247,-0.000008762,0.000000104,0.0000003301,0.00000884,0.00001539,0.00031164},
                { -0.02668146,0.00383206,-0.01708038,-0.0003858,-0.00273324,0.00034928,0.00015392,0.00031164,0.45774676}};

        double spleenMatrix [][] = {{ 0.10359481,0.03058062,-0.00006782,0.0001016,0.00038235,-0.00127472,-0.00039907,-0.04343683},
                { 0.03058062,0.06852421,-0.00001297,0.00010605,0.00039605,-0.00040582,-0.00095147,-0.0473203},
                { -0.00006782,-0.00001297,0.000002816,0.0000004615,-0.0000005124,0.0000005323,0.0000000415,-0.00015175},
                { 0.0001016,0.00010605,0.0000004615,0.00001287,-0.000001752,-0.000001973,-0.000001509,-0.00204235},
                { 0.00038235,0.00039605,-0.0000005124,-0.000001752,0.000006042,-0.000005252,-0.000005541,-0.00011711},
                { -0.00127472,-0.00040582,0.0000005323,-0.000001973,-0.000005252,0.00001676,0.000005676,0.00068224},
                { -0.00039907,-0.00095147,0.0000000415,-0.000001509,-0.000005541,0.000005676,0.00001405,0.00064469},
                { -0.04343683,-0.0473203,-0.00015175,-0.00204235,-0.00011711,0.00068224,0.00064469,0.357311}};

        double rkidneyMatrix [][] = {{ 0.0748741,-0.00353034,-0.00094036,0.00012403,0.00010084,0.0002529,-0.0004285,-0.00075502,-0.04052209},
                { -0.00353034,0.00702654,0.00204581,-0.00001268,-0.00006353,-0.00003177,-0.00003467,0.00006476,0.01138824},
                { -0.00094036,0.00204581,0.00414432,-0.000003515,0.000008902,0.000005007,-0.00001221,0.00002467,-0.00380948},
                { 0.00012403,-0.00001268,-0.000003515,0.000004333,0.0000003582,-0.0000009513,-0.000004231,0.0000008476,-0.00017515},
                { 0.00010084,-0.00006353,0.000008902,0.0000003582,0.00001742,-0.000003291,0.000001235,0.00000004683,-0.00273905},
                { 0.0002529,-0.00003177,0.000005007,-0.0000009513,-0.000003291,0.000005139,0.000000896,-0.000004521,0.00024046},
                { -0.0004285,-0.00003467,-0.00001221,-0.000004231,0.000001235,0.000000896,0.00001197,-0.0000009095,-0.0000808},
                { -0.00075502,0.00006476,0.00002467,0.0000008476,0.00000004683,-0.000004521,-0.0000009095,0.00001146,0.00025384},
                { -0.04052209,0.01138824,-0.00380948,-0.00017515,-0.00273905,0.00024046,-0.0000808,0.00025384,0.45732569}};

        double lkidneyMatrix [][] = {{ 0.0748741,-0.00353034,-0.00094036,0.00012403,0.00010084,0.0002529,-0.0004285,-0.00075502,-0.04052209},
                { -0.00353034,0.00702654,0.00204581,-0.00001268,-0.00006353,-0.00003177,-0.00003467,0.00006476,0.01138824},
                { -0.00094036,0.00204581,0.00414432,-0.000003515,0.000008902,0.000005007,-0.00001221,0.00002467,-0.00380948},
                { 0.00012403,-0.00001268,-0.000003515,0.000004333,0.0000003582,-0.0000009513,-0.000004231,0.0000008476,-0.00017515},
                { 0.00010084,-0.00006353,0.000008902,0.0000003582,0.00001742,-0.000003291,0.000001235,0.00000004683,-0.00273905},
                { 0.0002529,-0.00003177,0.000005007,-0.0000009513,-0.000003291,0.000005139,0.000000896,-0.000004521,0.00024046},
                { -0.0004285,-0.00003467,-0.00001221,-0.000004231,0.000001235,0.000000896,0.00001197,-0.0000009095,-0.0000808},
                { -0.00075502,0.00006476,0.00002467,0.0000008476,0.00000004683,-0.000004521,-0.0000009095,0.00001146,0.00025384},
                { -0.04052209,0.01138824,-0.00380948,-0.00017515,-0.00273905,0.00024046,-0.0000808,0.00025384,0.45732569}};


        //S.E. HEART,BRAIN
        for (int l = 0; l < 10; l++) {
            for (int j = 0; j < 1; j++) {
                heartMatrixNext[l][j] = 0;
                brainMatrixNext[l][j] = 0;
                for (int k = 0; k < 10; k++) {
                    heartMatrixNext[l][j] += heartMatrix[l][k] * inputHeart[k][j];
                    brainMatrixNext[l][j] += brainMatrix[l][k] * inputBrain[k][j];
                }
            }
        }

        for (int l = 0; l < 10; l++) {
            for (int j = 0; j < 1; j++) {
                calcHeart += heartMatrixNext[l][j] * inputHeart[l][j];
                calcBrain += brainMatrixNext[l][j] * inputBrain[l][j];
            }
        }

        double seHeart = Math.sqrt((calcHeart + 1)*1502.22675);
        double seBrain = Math.sqrt((calcBrain + 1)*14843.962);


        //S.E. RLUNG,LLUNG
        for (int l = 0; l < 14; l++) {
            for (int j = 0; j < 1; j++) {
                rlungMatrixNext[l][j] = 0;
                llungMatrixNext[l][j] = 0;
                for (int k = 0; k < 14; k++) {
                    rlungMatrixNext[l][j] += rlungMatrix[l][k] * inputRlung[k][j];
                    llungMatrixNext[l][j] += llungMatrix[l][k] * inputLlung[k][j];
                }
            }
        }

        for (int l = 0; l < 14; l++) {
            for (int j = 0; j < 1; j++) {
                calcRlung += rlungMatrixNext[l][j] * inputRlung[l][j];
                calcLlung += llungMatrixNext[l][j] * inputLlung[l][j];
            }
        }

        double seRlung = Math.sqrt((calcRlung + 1)*9306.3883);
        double seLlung = Math.sqrt((calcLlung + 1)*8517.87691);


        //S.E. LIVER,RKIDNEY,LKIDNEY
        for (int l = 0; l < 9; l++) {
            for (int j = 0; j < 1; j++) {
                liverMatrixNext[l][j] = 0;
                rkidneyMatrixNext[l][j] = 0;
                lkidneyMatrixNext[l][j] = 0;
                for (int k = 0; k < 9; k++) {
                    liverMatrixNext[l][j] += liverMatrix[l][k] * inputLiver[k][j];
                    rkidneyMatrixNext[l][j] += rkidneyMatrix[l][k] * inputRkidney[k][j];
                    lkidneyMatrixNext[l][j] += lkidneyMatrix[l][k] * inputLkidney[k][j];
                }
            }
        }

        for (int l = 0; l < 9; l++) {
            for (int j = 0; j < 1; j++) {
                calcLiver += liverMatrixNext[l][j] * inputLiver[l][j];
                calcRkidney += rkidneyMatrixNext[l][j] * inputRkidney[l][j];
                calcLkidney += lkidneyMatrixNext[l][j] * inputLkidney[l][j];
            }
        }

        double seLiver = Math.sqrt((calcLiver + 1)*0.030622276);
        double seRkidney = Math.sqrt((calcRkidney + 1)*0.03013673);
        double seLkidney = Math.sqrt((calcLkidney + 1)*0.030233905);


        //S.E. SPLEEN
        for (int l = 0; l < 8; l++) {
            for (int j = 0; j < 1; j++) {
                spleenMatrixNext[l][j] = 0;
                for (int k = 0; k < 8; k++) {
                    spleenMatrixNext[l][j] += spleenMatrix[l][k] * inputSpleen[k][j];
                }
            }
        }

        for (int l = 0; l < 8; l++) {
            for (int j = 0; j < 1; j++) {
                calcSpleen += spleenMatrixNext[l][j] * inputSpleen[l][j];
            }
        }

        double seSpleen = Math.sqrt((calcSpleen + 1)*0.143550502);



        //CALCULATE HEART LOWER/HEART UPPER AND SEND TO RESULTS
        int heartLower = (int) Math.round(pHeart -(seHeart * 1.962173148));
        int heartUpper = (int) Math.round(pHeart +(seHeart * 1.962173148));
        String heart = heartLower + " - " + heartUpper + "g";

        //CALCULATE BRAIN LOWER/BRAIN UPPER AND SEND TO RESULTS
        int brainLower = (int) Math.round(pBrain -(seBrain * 1.962072979));
        int brainUpper = (int) Math.round(pBrain +(seBrain * 1.962072979));
        String brain = brainLower + " - " + brainUpper + "g";

        //CALCULATE RLUNG LOWER/RLUNG UPPER AND SEND TO RESULTS
        int rlungLower = (int) Math.round(pRlung -(seRlung * 1.964326208));
        int rlungUpper = (int) Math.round(pRlung +(seRlung * 1.964326208));
        String rlung = rlungLower + " - " + rlungUpper + "g";

        //CALCULATE LLUNG LOWER/LLUNG UPPER AND SEND TO RESULTS
        int llungLower = (int) Math.round(pLlung -(seLlung * 1.964626283));
        int llungUpper = (int) Math.round(pLlung +(seLlung * 1.964626283));
        String llung = llungLower + " - " + llungUpper + "g";

        //CALCULATE LIVER LOWER/LIVER UPPER AND SEND TO RESULTS
        int liverLower = (int) Math.round(Math.exp(pLiver -(seLiver * 1.962236642)));
        int liverUpper = (int) Math.round(Math.exp(pLiver +(seLiver * 1.962236642)));
        String liver = liverLower + " - " + liverUpper + "g";

        //CALCULATE SPLEEN LOWER/SPLEEN UPPER AND SEND TO RESULTS
        int spleenLower = (int) Math.round(Math.exp(pSpleen -(seSpleen * 1.962183482)));
        int spleenUpper = (int) Math.round(Math.exp(pSpleen +(seSpleen * 1.962183482)));
        String spleen = spleenLower + " - " + spleenUpper + "g";

        //CALCULATE RKIDNEY LOWER/RKIDNEY UPPER AND SEND TO RESULTS
        int rkidneyLower = (int) Math.round(Math.exp(pRkidney -(seRkidney * 1.962360632)));
        int rkidneyUpper = (int) Math.round(Math.exp(pRkidney +(seRkidney * 1.962360632)));
        String rkidney = rkidneyLower + " - " + rkidneyUpper + "g";

        //CALCULATE LKIDNEY LOWER/LKIDNEY UPPER AND SEND TO RESULTS
        int lkidneyLower = (int) Math.round(Math.exp(pLkidney -(seLkidney * 1.962365485)));
        int lkidneyUpper = (int) Math.round(Math.exp(pLkidney +(seLkidney * 1.962365485)));
        String lkidney = lkidneyLower + " - " + lkidneyUpper + "g";


        //what do you want to call the piece of info, the piece of info that you want to send over
        i.putExtra("brainMessage", brain);
        i.putExtra("heartMessage", heart);
        i.putExtra("rlungMessage", rlung);
        i.putExtra("llungMessage", llung);
        i.putExtra("liverMessage", liver);
        i.putExtra("spleenMessage", spleen);
        i.putExtra("rkidneyMessage", rkidney);
        i.putExtra("lkidneyMessage", lkidney);

        i.putExtra("sexMessage", sex);


        startActivity(i);
    }



/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_organ_weights, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

*/

}
