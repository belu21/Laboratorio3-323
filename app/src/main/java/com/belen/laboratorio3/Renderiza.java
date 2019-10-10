package com.belen.laboratorio3;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;
import android.view.MotionEvent;

public class Renderiza extends GLSurfaceView implements Renderer {

    /* Objetos */
    private int alto;
    private int ancho;
    boolean flag=true;

    private CirculoGrafico c1_g, c2_g, c3_g;
    private Circulo c1, c2, c3;
    private RectanguloGrafico r1_g, r2_g, r3_g, r4_g, r5_g;
    private Rectangulo r1, r2, r3, r4, r5;

    /* Desplazamientos e Incrementos */
    private float x_c1 = 0, y_c1 =  -4;
    private float x_c2 =  2, y_c2 =  3;
    private float x_c3 = -5, y_c3 =  -2.5f;

    private float x_r1 = -2, y_r1 = 0;
    private float x_r2 =  2, y_r2 = 0;
    private float x_r3 =  2, y_r3 = 0;
    private float x_r4 = -2, y_r4 = 0;
    private float x_r5 =  2, y_r5 = 0;

    private float xVelocidad_c1 =   0.1f, yVelocidad_c1 = 0;
    private float xVelocidad_c2 =  -0.1f, yVelocidad_c2 = 0;
    private float xVelocidad_c3 =  0.03f, yVelocidad_c3 = 0;

    private float xVelocidad_r1 =  0.05f, yVelocidad_r1 = 0;
    private float xVelocidad_r2 = -0.04f, yVelocidad_r2 = 0;
    private float xVelocidad_r3 = -0.03f, yVelocidad_r3 = 0;
    private float xVelocidad_r4 = -0.02f, yVelocidad_r4 = 0;
    private float xVelocidad_r5 = -0.01f, yVelocidad_r5 = 0;

    private SonidoSoundPool sonido1, sonido2, sonido3;

    public Renderiza(Context contexto) {
        super(contexto);

        sonido1 = new SonidoSoundPool(contexto, "0437.ogg");
        sonido2 = new SonidoSoundPool(contexto, "0438.ogg");
        sonido3 = new SonidoSoundPool(contexto, "0564.ogg");

        this.setRenderer(this);
        this.setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig arg1) {

        c1_g = new CirculoGrafico(0.5f, 360, true);
        c1 = new Circulo(0, 0, 0.5f);
        c2_g = new CirculoGrafico(0.5f, 360, true);
        c2 = new Circulo(0, 0, 0.5f);
        c3_g = new CirculoGrafico(0.5f, 360, true);
        c3 = new Circulo(0, 0, 0.5f);

        r1_g = new RectanguloGrafico(0, 0, 2, 1);
        r1 = new Rectangulo(0, 0, 2, 1);
        r2_g = new RectanguloGrafico(0, 0, 2, 1);
        r2 = new Rectangulo(0, 0, 2, 1);
        r3_g = new RectanguloGrafico(0, 0, 2, 1);
        r3 = new Rectangulo(0, 0, 2, 1);
        r4_g = new RectanguloGrafico(0, 0, 2, 1);
        r4 = new Rectangulo(0, 0, 2, 1);
        r5_g = new RectanguloGrafico(0, 0, 2, 1);
        r5 = new Rectangulo(0, 0, 2, 1);



        gl.glClearColor(0, 0, 0, 0);
    }

    public void dibujaCirculo1(GL10 gl){
        gl.glPushMatrix();
        gl.glTranslatef(x_c1, y_c1, 0);
        c1.x = x_c1;
        c1.y = y_c1;
        gl.glColor4f(0, 1, 0, 1);
        c1_g.dibuja(gl);
        gl.glPopMatrix();
    }

    public void dibujaCirculo2(GL10 gl){
        gl.glPushMatrix();
        gl.glTranslatef(x_c2, y_c2, 0);
        c2.x = x_c2;
        c2.y = y_c2;
        gl.glColor4f(1, 1, 0, 1);
        c2_g.dibuja(gl);
        gl.glPopMatrix();
    }

    public void dibujaCirculo3(GL10 gl){
        gl.glPushMatrix();
        gl.glTranslatef(x_c3, y_c3, 0);
        c3.x = x_c3;
        c3.y = y_c3;
        gl.glColor4f(1, 0, 1, 1);
        c3_g.dibuja(gl);
        gl.glPopMatrix();
    }

    public void dibujaRectangulo1(GL10 gl){
        gl.glPushMatrix();
        gl.glTranslatef(0,1,0);
        gl.glTranslatef(x_r1, y_r1, 0);
        r1.x = x_r1;
        r1.y = y_r1;
        gl.glColor4f(1, 0, 0, 1);
        r1_g.dibuja(gl);
        gl.glPopMatrix();
    }

    public void dibujaRectangulo2(GL10 gl){
        gl.glPushMatrix();
        gl.glTranslatef(x_r2, y_r2, 0);
        r2.x = x_r2;
        r2.y = y_r2;
        gl.glColor4f(0, 0, 1, 1);
        r2_g.dibuja(gl);
        gl.glPopMatrix();
    }

    public void dibujaRectangulo3(GL10 gl){
        gl.glPushMatrix();
        gl.glTranslatef(0,-1,0);
        gl.glTranslatef(x_r3, y_r3, 0);
        r3.x = x_r3;
        r3.y = y_r3;
        gl.glColor4f(0, 1, 1, 1);
        r3_g.dibuja(gl);
        gl.glPopMatrix();
    }
    public void dibujaRectangulo4(GL10 gl){
        gl.glPushMatrix();
        gl.glTranslatef(0,-2,0);
        gl.glTranslatef(x_r4, y_r4, 0);
        r4.x = x_r4;
        r4.y = y_r4;
        gl.glColor4f(1, 1, 1, 1);
        r4_g.dibuja(gl);
        gl.glPopMatrix();
    }
    public void dibujaRectangulo5(GL10 gl){
        gl.glPushMatrix();
        gl.glTranslatef(0,-3,0);
        gl.glTranslatef(x_r5, y_r5, 0);
        r5.x = x_r5;
        r5.y = y_r5;
        gl.glColor4f(1, 1, 0, 1);
        r5_g.dibuja(gl);
        gl.glPopMatrix();
    }

    @Override
    public void onDrawFrame(GL10 gl) {

        gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

        /* Colisión de dos circulos
        dibujaCirculo1(gl);
        dibujaCirculo2(gl);

        if (seSobreponen(c1, c2)) {
            xVelocidad_c1 = -xVelocidad_c1;
            xVelocidad_c2 = -xVelocidad_c2;
            sonido1.play();
        }

        x_c1 = x_c1 + xVelocidad_c1;
        if (x_c1 < -3.5f || x_c1 > 3.5f) // izq y der
            xVelocidad_c1 = -xVelocidad_c1;

        x_c2 = x_c2 + xVelocidad_c2;
        if (x_c2 < -3.5f || x_c2 > 3.5f)  // izq y der
            xVelocidad_c2 = -xVelocidad_c2; */

        /* Colisión de dos rectángulos */

        dibujaRectangulo1(gl);
        x_r1 = x_r1 + xVelocidad_r1;
        if (x_r1 < -5 || x_r1 > 3) // izq y der
            xVelocidad_r1 = -xVelocidad_r1;


        dibujaRectangulo2(gl);

        x_r2 = x_r2 + xVelocidad_r2;
        if (x_r2 < -5 || x_r2 > 3) // izq y der
            xVelocidad_r2 = -xVelocidad_r2;

        /* if (seSobreponen(r1, r2)) {
            xVelocidad_r1 = -xVelocidad_r1;
            xVelocidad_r2 = -xVelocidad_r2;
            sonido2.play();
        }
        */




        /* Colisión circulo y rectángulo */


       /* if (seSobreponen(c3, r3)) {
            xVelocidad_c3 = -xVelocidad_c3;
            xVelocidad_r3 = -xVelocidad_r3;
            sonido3.play();
        }
*/
        dibujaRectangulo3(gl);
        x_r3 = x_r3 + xVelocidad_r3;
        if (x_r3 < -5 || x_r3 > 3) // izq y der
            xVelocidad_r3 = -xVelocidad_r3;


        dibujaRectangulo4(gl);

        x_r4 = x_r4 + xVelocidad_r4;
        if (x_r4 < -5 || x_r4 > 3) // izq y der
            xVelocidad_r4 = -xVelocidad_r4;


        dibujaRectangulo5(gl);

        x_r5 = x_r5 + xVelocidad_r5;
        if (x_r5 < -5 || x_r5 > 3) // izq y der
            xVelocidad_r5 = -xVelocidad_r5;





            dibujaCirculo1(gl);



        if (seSobreponen(c1, r1)) {

            x_c1 = 0;
            y_c1 =  -4;
            flag=false;

        }
        if (seSobreponen(c1, r2)) {
            flag=false;
            x_c1 = 0;
            y_c1 =  -4;

        }
        if (seSobreponen(c1, r3)) {
            flag=false;
            x_c1 = 0;
            y_c1 =  -4;
        }
        if (seSobreponen(c1, r4)) {
            flag=false;
            x_c1 = 0;
            y_c1 =  -4;

        }
        if (seSobreponen(c1, r5)) {
            flag=false;
            x_c1 = 0;
            y_c1 =  -4;
        }

        gl.glFlush();
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int w, int h) {
        /* Obtiene el ancho y el alto de la pantalla */
        ancho = w;
        alto = h;

        gl.glViewport(0, 0, w, h);
        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();
        GLU.gluOrtho2D(gl, -4, 4, -6, 6);
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();
    }
    @Override
    public boolean onTouchEvent(MotionEvent e) {
        x_c1 = (e.getX() * (8 / (float) ancho)) - 4;
        y_c1 = (e.getY() * (12 / (float) alto)) - 6;
        y_c1 = y_c1*(-1);
        return true;
    }

    public boolean seSobreponen(Rectangulo r1, Rectangulo r2) {
        return (r1.x < r2.x + r2.ancho && r1.x + r1.ancho >  r2.x  &&
                r1.y < r2.y + r2.alto && r1.y	+ r1.alto > r2.y);
    }

    public float distancia2(float x1, float y1, float x2, float y2) {
        return (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
    }

    public boolean seSobreponen(Circulo c1, Circulo c2) {
        float distanciaCentros2 = distancia2(c1.x, c1.y, c2.x, c2.y);
        float sumaRadios2 =(c1.radio + c2.radio) * (c1.radio + c2.radio);
        return distanciaCentros2 <= sumaRadios2;
    }

    public boolean seSobreponen(Circulo c, Rectangulo r) {
        float x0 = c.x;
        float y0 = c.y;

        if (c.x < r.x) {
            x0 = r.x;
        } else if (c.x > r.x + r.ancho) {
            x0 = r.x + r.ancho;
        }

        if (c.y < r.y) {
            y0 = r.y;
        } else if (c.y > r.y + r.alto) {
            y0 = r.y + r.alto;
        }

        float d2 = distancia2(c.x, c.y, x0, y0);
        return  d2 < c.radio * c.radio;
    }
}
