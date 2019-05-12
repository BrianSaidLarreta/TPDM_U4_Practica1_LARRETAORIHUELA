package com.example.tpdm_u4_practica1_larretaorihuela;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Circulo {
    int x,y,tamaño,movX,movY,color;

    public Circulo(Lienzo este, int posx, int posy){
        this.tamaño = (int)(Math.random()*150);
        x = posx;
        y = posy;

        if(Math.random()*10<5){
            movX = 10;
        }else{
            movX = -10;
        }

        if(Math.random()<5){
            movY = 10;
        }else{
            movY = -10;
        }

        int c = (int)(Math.random()*10);
        switch(c){
            case 0:
                color = Color.BLACK; break;
            case 1:
                color = Color.BLUE; break;
            case 2:
                color = Color.GRAY; break;
            case 3:
                color = Color.GREEN; break;
            case 4:
                color = Color.RED; break;
            case 5:
                color = Color.YELLOW; break;
            case 6:
                color = Color.MAGENTA; break;
            case 7:
                color = Color.CYAN; break;
            case 8:
                color = Color.rgb(234,114,19); break;
            case 9:
                color = Color.rgb(19,234,228); break;
            case 10:
                color = Color.rgb(163,19,234); break;
            default:
                color = Color.rgb(19,182,234); break;
        }

    }

    public void desplazarX(){
        x += movX;
    }

    public void desplazarY(){
        y += movY;
    }

    public void pintar(Canvas c, Paint p){
        p.setColor(color);
        c.drawCircle(x,y,tamaño,p);
    }

}
