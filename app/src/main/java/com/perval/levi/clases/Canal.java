package com.perval.levi.clases;

import java.util.ArrayList;
import java.util.List;

public class Canal {

    private double CrossArea;
    private double velocity;
    private double gasto;
    private String seccion;
    private double Pm;
    private double AnchoSuperficie;
    private double Rh;
    private double Slope;
    private double hf;
    private double Length;
    private double Manning;



    //Si se trata de una sección compuesta La rugosidad se asignará de la siguiente forma
    //Herradura y medio punto
    //Elemento 0 el fondo
    //Elemento 1, primer tramo a la izquierda
    //Elemento 2, primer tramo a la derecha
    //Elemento 3, segundo tramo a la izquierda
    //Elemento 4, segundo tramo a la izquierda

    //En el caso de secciones circulares sólo se asignará un tipo de rugosidad
    //al elemento 0 se asignará el material.


    private double Fondo;
    private double Kder, Kizq;



    private double HRect;
    private double Radio;



    public void setCrossArea(double Area){
        this.CrossArea = Area;
    }

    public void setVelocity(double velocity){
        this.velocity = velocity;
    }

    public void setGasto(double gasto){
        this.gasto = gasto;
    }

    public void setSeccion(String seccion){
        this.seccion = seccion;
    }

    public void setPm(double Pm){
        this.Pm = Pm;
    }

    public void setAnchoSuperficie(double Ancho){
        this.AnchoSuperficie = Ancho;
    }

    public void setRh(double Rh){
        this.Rh = CrossArea/Pm;
    }

    public void setSlope(double Slope){
        this.Slope = Slope;
     }

     public void setHf(double Hf){

        this.hf = Hf;
     }

     public void setLength(double Longitud){

        this.Length = Longitud;
     }

     public void setFondo(double Fondo){
        this.Fondo = Fondo;
     }

     public void setKder(double Kder){

        this.Kder = Kder;
     }

     public void setKizq(double Kizq){
        this.Kizq = Kizq;
     }







     public void setHRect(double HRect){
        this.HRect = HRect;

     }

     public void setRadio(double Radio){

        this.Radio = Radio;
     }


     //Aquí termina la parte del código en el cual se definen las variables.
    //El siguiente código sirve para regresar las variables.

    public double getKder(){
        return Kder;
    }

    public double getKizq(){
        return Kizq;
    }


    public double getFondo(){
        return Fondo;
    }

    public double getRadio(){
        return Radio;
    }

    public double getHRect(){

    return HRect;
    }


     public double getVelocity(){
        return velocity;
     }

     public double getArea(){
        return CrossArea;
     }


     public double getGasto(){
        return gasto;
     }

     public String getSeccion(){
        return seccion;
     }

     public double getAncho(){
        return AnchoSuperficie;
     }

     public double getRh(){
        return Rh;
     }

     public double getSlope(){
        return Slope;
     }

     public double gethf(){
        return hf;
     }

     public double getLength(){

        return Length;
     }

     public double getManning(){

        return Manning;
     }

}
