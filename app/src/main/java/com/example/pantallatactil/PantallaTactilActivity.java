package com.example.pantallatactil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class PantallaTactilActivity extends AppCompatActivity implements View.OnTouchListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        TextView entrada = (TextView) findViewById(R.id.txtPulsaAqui);
        entrada.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TextView salida = (TextView) findViewById(R.id.txtPulsaciones);
        salida.append("\n" + motionEvent.toString() + "\n");

        return true;
    }
}
