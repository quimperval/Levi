package com.perval.levi.sections;

import android.content.res.Resources;
import android.util.Log;

import com.perval.levi.R;

public class CanalRectangular {

    //columna 0 - Ancho
    //columna 1 - altura
    //columna 3 - longitud
    //columna 4 - peso por unidad
    private String[][] cajon_prefabricado = {
            {"1000","2000","2500","8.25"},
            {"2000","1000","2500","8.25"},
            {"2000","2000","1860","7.2"},
            {"2000","2500","1610","7.2"},
            {"2500","2000","1610","7.2"},
            {"2500","3500","1350","12.4"},
            {"3500","2500","1350","12.4"},
            {"3800","1500","2100","15"},
            {"1500","3800","2100","15"},
            {"4000","2000","1500","12.7"},
            {"4500","2000","1500","13.2"},
            {"5000","2000","1500","19.1"},
            {"5500","2000","1500","20.3"},
            {"6000","2000","1500","21.6"},
            {"6500","2000","1500","23"},
            {"7000","2000","1500","24.2"},
            {"4000","2500","1500","13.6"},
            {"4500","2500","1500","15.9"},
            {"5000","2500","1500","20.2"},
            {"5500","2500","1500","21.4"},
            {"6000","2500","1500","22.7"},
            {"6500","2500","1500","24.1"},
            {"7000","2500","1500","25.4"},
            {"4000","3000","1500","14.4"},
            {"4500","3000","1500","16.8"},
            {"5000","3000","1500","21.4"},
            {"5500","3000","1500","22.6"},
            {"6000","3000","1500","23.8"},
            {"6500","3000","1500","25.2"},
            {"7000","3000","1500","26.5"}
    };


    //Tipos disponibles
    // cajon
    // U
    private String tipo="";

    private double BLibre;
    private double Hrect;
    private double Brect;
    private double Pmrect;
    private double Area;
    private double Rhrect;
    private double Vrect;
    private double Rugrect;
    private double sloperect;
    private double gastorect;
    private double tirantehidraulico;
    private double RelTH;
    private double Froude;
    private String tipoFlujo;

    private boolean isTest= false;

    private Resources resources;
    private boolean Success = false;

    public  CanalRectangular(Resources resources){
        this.resources = resources;
    }

    public CanalRectangular(){

    }

    public CanalRectangular(boolean isTest){
        this.isTest = isTest;
    }



    public void setTirante(double tirante){
    this.tirantehidraulico = tirante;
    }
    public void setHrecAsMeter(double Hrect){
        this.Hrect = Hrect;
    }

    public void setBrectAsMeter(double Brect){
        this.Brect = Brect;
    }

    public void setPmrect(double Pmrect){
        this.Pmrect = Pmrect;
    }

    public void setArea(double Area){
        this.Area = Area;
    }

    public void setRhrect(double Rhrect){
        this.Rhrect = Rhrect;

    }

    public void setVrect(double Vrect){
        this.Vrect = Vrect;
    }

    public void setRugRect(double rugosidad){
        this.Rugrect = rugosidad;
    }

    public void setslope(double slope){
        this.sloperect = slope/1000;
    }

    public void setGastoLPS(double gasto){
        this.gastorect = gasto/((double)1000);
    }

    //////////////////////////////////////////


    public double getTirante(){
        return this.tirantehidraulico;
    }

    public double getHrec(){
        return this.Hrect;
    }

    public double getBrect(){
        return this.Brect;
    }

    public double getPmrect(){
        return this.Pmrect;
    }

    public double getArea(){
        return this.Area;
    }

    public double getRhrect(){
        return this.Rhrect;

    }

    public double getBLibre(){
        return this.BLibre;
    }

    public double getRelTH(){

        return this.RelTH;
    }

    public double getVrect(){
        return this.Vrect;
    }

    public double getRugRect(){
        return this.Rugrect;
    }

    public double getslope(){
        return this.sloperect;
    }

    public double getgasto(){
        return this.gastorect;
    }

    public double calcPm(double hcalc){

        double tir_calc;

        tir_calc = Brect + 2*hcalc;
        return tir_calc;

    }

    public double calcAH(double hcalc){

        double Acalc;

        Acalc = Brect*hcalc;
        return Acalc;
    }

    public double Vmann_rect(double tirante){

    double Vdumm;
    double Adumm = calcAH(tirante);

    double Pmdumm = calcPm(tirante);

    double Rhdumm =Adumm/Pmdumm;

    double Rh23 = Math.pow(Rhdumm, (double)2/(double)3);

    double pot12 = ((double)1)/((double)2);

    double slope12 = Math.pow(sloperect, 0.5);

    Vdumm = ((double)1/Rugrect) *Rh23*slope12;

    return Vdumm;


    }

    public void calcfromQ(){
        //Log.i("calcfromQ","Dentro de la funcion calcfromQ");
        //System.out.println("Dentro de la funcion calcfromQ");
        double Qdummy0, Qdummy1;
        double Adummy0, Adummy1;
        double Vdummy0, Vdummy1;
        double Rhdummy0, Rhdummy1;
        double Pmdummy0, Pmdummy1;
        double tirante0 = (double) 0.0001;
        double tirante1 = (Hrect-(double)0.0001);

        if(Hrect==0 || Brect==0 || gastorect ==0 ){
            Success = false;
            Log.i("LogTest", "Calculation failed, a required parameter is zero");
            return;
        }

        double diferencia;

        double Fx0, Fx1;

        do{

            Adummy0 = calcAH(tirante0);

            Pmdummy0 = calcPm(tirante0);
            Rhdummy0 = Adummy0/Pmdummy0;


            Vdummy0 = Vmann_rect(tirante0);
            Qdummy0 = Adummy0 * Vdummy0;
            Fx0 = Qdummy0 - gastorect;

            Adummy1 = calcAH(tirante1);
            Vdummy1 = Vmann_rect(tirante1);
            Qdummy1 = Adummy1 * Vdummy1;
            Fx1 = Qdummy1 - gastorect;

            double Tnext = tirante1 - (Fx1 *(tirante0-tirante1))/(Fx0-Fx1);
            tirante0 = tirante1*1;
            tirante1 = Tnext*1;

            diferencia = Math.abs(tirante1- tirante0);

        } while (diferencia >0.00001);

        if(tirante1>Hrect){
            Success = false;
        } else {
            Log.i("LogTest", "Success calculating hydraulic variables.");
            Success = true;
            tirantehidraulico = tirante1;
            Area = calcAH(tirante1);

            Pmrect = calcPm(tirante1);
            Rhrect = Area / Pmrect;
            Vrect = Vmann_rect(tirante1);
            gastorect = Area * Vrect;
            BLibre = Hrect-tirantehidraulico;
            RelTH = tirantehidraulico/Hrect;
            Froude = calcFroude(Vrect,Brect, Area);
            if(isTest==false){
                calcFlujo(Froude);
            }



        }




    }



    public void calcfromV(){

        double Qdummy0, Qdummy1;
        double Adummy0, Adummy1;
        double Vdummy0, Vdummy1;
        double Rhdummy0, Rhdummy1;
        double Pmdummy0, Pmdummy1;
        double tirante0 = (double) 0.0001;
        double tirante1 = (Hrect-(double)0.0001);

        double diferencia;

        double Fx0, Fx1;

        int contador = 0;

        do{
            contador = contador+1;

            Adummy0 = calcAH(tirante0);

            Pmdummy0 = calcPm(tirante0);
            Rhdummy0 = Adummy0/Pmdummy0;


            Vdummy0 = Vmann_rect(tirante0);

            Fx0 = Vdummy0 - Vrect;

            Adummy1 = calcAH(tirante1);
            Vdummy1 = Vmann_rect(tirante1);

            Fx1 = Vdummy1 - Vrect;

            double Tnext = tirante1 - (Fx1 *(tirante0-tirante1))/(Fx0-Fx1);

            if(Tnext<0){
                Tnext = 0.0001;
            } else {
            }

            tirante0 = tirante1*1;
            tirante1 = Tnext*1;



            diferencia = Math.abs(tirante1- tirante0);

        } while ((diferencia >0.00001)&&(contador<50)&&(tirante1<(2*Hrect)));

        if((tirante1>Hrect)){
            Success = false;
        } else {

            Success = true;
            tirantehidraulico = tirante1;
            Area = calcAH(tirante1);

            Pmrect = calcPm(tirante1);
            Rhrect = Area / Pmrect;
            Vrect = Vmann_rect(tirante1);
            gastorect = Area * Vrect;
            RelTH = tirantehidraulico/Hrect;
            BLibre = Hrect-tirantehidraulico;
            Froude = calcFroude(Vrect,Brect,Area);
            if(isTest==false){
                calcFlujo(Froude);
            }

        }




    }


    public void calcfromH(){
        if(tirantehidraulico>Hrect){

            Success = false;
        } else {

            Area = calcAH(tirantehidraulico);
            Pmrect = calcPm(tirantehidraulico);
            Rhrect = Area / Pmrect;
            Vrect = Vmann_rect(tirantehidraulico);
            gastorect = Area * Vrect;
            BLibre = Hrect-tirantehidraulico;
            RelTH = tirantehidraulico/Hrect;
            Froude = calcFroude(Vrect,Brect,Area);
            if(isTest==false){
                calcFlujo(Froude);
            }
            Success = true;
        }



    }


    public double getFroude(){
        return  Froude;
    }

    public String getTipoFlujo() {
        return tipoFlujo;
    }

    public double calcFroude(double velocity, double Tancho, double Areax){

        double Froudex;

        Froudex = velocity/(Math.pow((9.81*(Areax/Tancho)),0.5));

        return Froudex;

    }

    public void calcFlujo(double Froudex){

        if(Froudex ==1){

            tipoFlujo = resources.getString(R.string.critico);
        } else {

            if(Froudex<1){
                tipoFlujo = resources.getString(R.string.subcritico);
            } else {

                tipoFlujo = resources.getString(R.string.supercritico);
            }
        }

    }

    public String[][] getCajon(){
        return cajon_prefabricado;
    }


    public boolean isSuccess(){
        return Success;
    }

}
