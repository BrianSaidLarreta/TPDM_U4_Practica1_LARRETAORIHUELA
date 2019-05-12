package com.example.tpdm_u4_practica1_larretaorihuela;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo extends View {
    Thread hilo;
    Circulo [] circulos = new Circulo[4];


    public Lienzo(Context context){
        super(context);
        circulos[0] = new Circulo(this,100,100);
        circulos[1] = new Circulo(this,200,300);
        circulos[2] = new Circulo(this,300,250);
        circulos[3] = new Circulo(this,350,100);
        hilo = new Thread() {

            public void run() {
                while (true) {
                    for(int i = 0; i < circulos.length;i++){
                        circulos[i].desplazarX();
                        circulos[i].desplazarY();
                    }

                    try {
                        sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    postInvalidate();
                }
            }
        };
        hilo.start();
    }

    public void bordes(Circulo cir , Canvas c){
        if((cir.x + cir.tamaño) >= c.getWidth()){
            cir.movX = cir.movX*-1;
        }
        if((cir.x - cir.tamaño) < 1){
            cir.movX = cir.movX*-1;
        }
        if((cir.y + cir.tamaño) >= c.getHeight()){
            cir.movY = cir.movY*-1;
        }
        if((cir.y - cir.tamaño) < 1){
            cir.movY = cir.movY*-1;
        }
    }

    protected void onDraw (Canvas c){
        Paint p = new Paint();
        for(int i = 0; i< circulos.length;i++){
            circulos[i].pintar(c,p);
            bordes(circulos[i],c);
        }
    }

    public boolean onTouchEvent(MotionEvent e){
        return true;
    }

}
