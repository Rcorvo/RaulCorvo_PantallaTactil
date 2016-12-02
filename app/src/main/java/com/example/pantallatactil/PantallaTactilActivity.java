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
        //salida.append("\n" + motionEvent.toString() + "\n");
        String acciones[] = { "ACTION_DOWN", "ACTION_UP", "ACTION_MOVE", "ACTION_CANCEL",
                "ACTION_OUTSIDE", "ACTION_POINTER_DOWN", "ACTION_POINTER_UP" };
        int action = motionEvent.getAction();
        int codigoAccion = action & MotionEvent.ACTION_MASK;
        int iPuntero = (action & MotionEvent.ACTION_POINTER_INDEX_MASK)
                >> MotionEvent.ACTION_POINTER_INDEX_SHIFT;
        salida.append("\n" + acciones[codigoAccion]);
        salida.append(" Generada por puntero: " + iPuntero);
        for(int i = 0; i < motionEvent.getPointerCount(); i++){
            salida.append("\npuntero: " + motionEvent.getPointerId(i) +
            " x:" + motionEvent.getX(i) + " y:" + motionEvent.getY(i));
        }
        salida.append("\n");

        return true;
    }
}
