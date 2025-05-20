package com.tomcat.android6d3r;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int jugadores;
    private int[] CASILLAS;
    private  Partida partida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        CASILLAS =new int[9];
        CASILLAS[0]=R.id.a1;
        CASILLAS[1]=R.id.a2;
        CASILLAS[2]=R.id.a3;

        CASILLAS[3]=R.id.b1;
        CASILLAS[4]=R.id.b2;
        CASILLAS[5]=R.id.b3;

        CASILLAS[6]=R.id.c1;
        CASILLAS[7]=R.id.c2;
        CASILLAS[8]=R.id.c3;

    }

    public void aJugar(View v){
        ImageView imagen;
        for (int cadaCasilla: CASILLAS){
            imagen = (ImageView) findViewById(cadaCasilla);
            imagen.setImageResource(R.drawable.casilla);
            jugadores =1;
            if(v.getId() ==R.id.dosjug){
                jugadores =2;
            }
            RadioGroup configDificultad =(RadioGroup) findViewById(R.id.configD);
            int id =configDificultad.getCheckedRadioButtonId();

            int dificultad = 0;
            if (id == R.id.normal){
                dificultad =1;
            }else if(id ==R.id.imposible){
                dificultad =2;
            }
            partida = new Partida(dificultad);
            ((Button)findViewById(R.id.unjug)).setEnabled(false);
            ((Button)findViewById(R.id.dosjug)).setEnabled(false);
            ((RadioGroup)findViewById(R.id.configD)).setAlpha(0);
        }
    }

}