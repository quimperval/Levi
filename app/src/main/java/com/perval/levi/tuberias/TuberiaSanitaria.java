package com.perval.levi.tuberias;

import android.content.res.Resources;
import android.util.Log;
import android.widget.Toast;

import com.perval.levi.R;

import java.util.ArrayList;
import java.math.*;
import java.util.HashMap;


public class TuberiaSanitaria {


    private double CrossArea;
    private double velocity;
    private double gasto;
    private String seccion;
    private double Pm;
    private double AnchoSuperficie;
    private double Rh;
    private double tirantehidraulico;
    private double Slope;
    private double Length;
    private double Manning;
    private double Froude;

    private ArrayList<Double> listaGastos = new ArrayList<Double>();

    private double Qmax1, Qmax2;
    private double QMAX;
    private double hQMAX;
    private double Qmed;
    private double Vmax1, Vmax2;
    //Supercrítico
    //Subcrítico
    //Crítico
    private String tipoFlujo;
    private String CalcNoDone = "";

    private boolean Success;
    //Si se trata de una sección compuesta La rugosidad se asignará de la siguiente forma
    //Herradura y medio punto
    //Elemento 0 el fondo
    //Elemento 1, primer tramo a la izquierda
    //Elemento 2, primer tramo a la derecha
    //Elemento 3, segundo tramo a la izquierda
    //Elemento 4, segundo tramo a la izquierda

    //En el caso de secciones circulares sólo se asignará un tipo de rugosidad
    //al elemento 0 se asignará el material.


    private double Rugosidad;

    private double Diametro;

    //Variables for Qmax
    private double QMAX_CrossAreaX = -99;
    private double QMAX_PmX = -99;
    private double QMAX_RhX = -99;
    private double QMAX_velocityX = -99;
    private double QMAX_gastoX = -99;

    private Resources resources;

    private boolean isTest = false;

    public TuberiaSanitaria(Resources resources){
        this.resources = resources;
    }

    public TuberiaSanitaria(){

    }

    public TuberiaSanitaria(boolean isTest){
        this.isTest = isTest;
    }


    public void setTirante(double tirante){
        this.tirantehidraulico = tirante;
    }

    public void setCrossArea(double Area){
        this.CrossArea = Area;
    }

    public void setVelocity(double velocity){
        this.velocity = velocity;
    }

    public void setGastoLPS(double gasto){
        this.gasto = gasto/1000;
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



    public void setLength(double Longitud){

        this.Length = Longitud;
    }






    public void setRugosidad(double Rug){

        this.Rugosidad = Rug;
    }





    public void setDiametro(double Diametro){

        this.Diametro = Diametro;
    }


    //Aquí termina la parte del código en el cual se definen las variables.
    //El siguiente código sirve para regresar las variables.

    public double getRugosidad(){
        return Rugosidad;
    }

    public double getDiametro(){
        return Diametro;
    }

    public double getFroude(){
        return Froude;
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



    public double getLength(){

        return Length;
    }

    public double getManning(){

        return Manning;
    }

    public String getTipoFlujo(){

        return tipoFlujo;
    }

    public void CalcfromQ(){

        CalcQmax();

        tirantehidraulico= 0;
        velocity = 0;
        CrossArea = 0;
        Rh = 0;
        Pm = 0;

        //theta = Acos(A)
        double diferencia = 1;

        double Fx0, Fx1;

        double Rhh0, Qh0;
        double Ah0, Pmh0, Vh0;


        double Rhh1, Qh1;
        double Ah1, Pmh1, Vh1;

        double hm;
        double Rhhm, Qhm;
        double Ahm, Pmhm, Vhm;
        double Fxhm;


        double contador = 0;

        double hAnt=0;

        //Verificando el gasto máximo de la tubería.

        double h0, h1;

        double hAnt2;
        h0 = 0.01;
        h1 = hQMAX*1;

        //Log.i("Test", "hQMAX: " + hQMAX);

        if(gasto>QMAX){
            //Log.i("Test", "El gasto es mayor a QMAX, la tubería no puede conducir este gasto. ");

            Success = false;
        } else {
            //Log.i("Test", "Calculando si la tubería puede conducir el gasto. ");

            do {
                ++contador;
                //Calcular el gasto.
                //Usando el método de la secante.
                //Log.i("Test", "///////////Iteracioń:  "+contador+ "  ///////");

                Ah0 = CalcAfromh(h0);
                Pmh0 = CalcPmfromh(h0);
                Rhh0 = Ah0 / Pmh0;
                Vh0 = Vmanning(Rhh0);

                Qh0 = Vh0 * Ah0;

                Fx0 = Qh0 - gasto;

                ///Evaluación en el punto medio entre los h0 y h1
                hm = (h0+h1)/2;
                hAnt2 = hAnt*1;
                hAnt = hm*1;

                Ahm = CalcAfromh(hm);
                Pmhm = CalcPmfromh(hm);
                Rhhm = Ahm / Pmhm;
                Vhm = Vmanning(Rhhm);

                Qhm = Vhm * Ahm;

                Fxhm = Qhm - gasto;

                //////////////////////
                //Cálculo para xi+1
                Ah1 = CalcAfromh(h1);
                Pmh1 = CalcPmfromh(h1);
                Rhh1 = Ah1 / Pmh1;
                Vh1 = Vmanning(Rhh1);

                Qh1 = Vh1 * Ah1;

                Fx1 = Qh1 - gasto;


                //Log.i("Test", "Qh0:  "+Qh0+ " Qhm: " + Qhm + " Qh1: " + Qh1);


                if(Fx0<0&&Fx1>0){
                    if(Fxhm>0){
                        h1 = hm*1;

                        if(contador==1){
                            continue;
                        } else {
                            diferencia = Math.abs(h1-hAnt2);
                        }

                    } else {
                        h0= hm*1;

                        if(contador==1){
                            continue;
                        } else {
                            diferencia = Math.abs(h0-hAnt2);
                        }
                    }
                }



                //Log.i("Test", "Diferencia: "+ diferencia);

            } while (diferencia >0.0001&contador<100);


            double Qdeh1 = CalcQfromH(h1, false);

            if(Math.abs(Qdeh1-gasto)<0.05){

                //Log.i("Test", "Calculo exitoso ");
                //Cálculo realizado
                tirantehidraulico = h1;
                CrossArea = CalcAfromh(tirantehidraulico);
                Pm = CalcPmfromh(tirantehidraulico);
                Rh = CrossArea/ Pm;
                velocity = Vmanning(Rh);
                gasto = velocity*CrossArea;
                AnchoSuperficie = calcAnchoSuperficie(tirantehidraulico);
                Froude = calcFroude(velocity,AnchoSuperficie, CrossArea);
                if(isTest==false){
                    calcFlujo(Froude);
                }

                Success = true;

            } else {

                //Log.i("Test", "Calculo fallido");
                Success= false;

            }


        }




    }



    public void CalcfromV(){

        CalcQmax();


        tirantehidraulico= 0;
        gasto = 0;
        CrossArea = 0;
        Rh = 0;


        //theta = Acos(A)
        double diferencia;
        double tirante = (double)0.0001;
        do{


            double Rhdummy;
            double Qdummy;

            double Adummy = CalcAfromh(tirante);
            double Pmdummy = CalcPmfromh(tirante);

            Rhdummy = Adummy/Pmdummy;
            double Vdummy = Vmanning(Rhdummy);

            Qdummy =  Vdummy* Adummy;


            diferencia = Math.abs(Vdummy-velocity);


            if(((tirante+((double)0.0001)) < Diametro) || ((tirante +((double)0.0001)) ==Diametro)){
                tirante = tirante +0.0001;
            } else {
                tirante = -(double)9999;
            }
        } while (diferencia >0.0002);

        if(tirante ==(-(double)9999)){
            CalcNoDone = Resources.getSystem().getString(R.string.Calculo_fallido);

        } else {

            tirantehidraulico = tirante;
            CrossArea = CalcAfromh(tirantehidraulico);
            Pm = CalcPmfromh(tirantehidraulico);
            Rh = CrossArea/ Pm;
            velocity = Vmanning(Rh);
            gasto = velocity*CrossArea;
            AnchoSuperficie = calcAnchoSuperficie(tirantehidraulico);

            Froude = calcFroude(velocity,AnchoSuperficie, CrossArea);
            if(isTest==false){
                calcFlujo(Froude);
            }


        }



    }



    public void CalcfromH(){


            CrossArea = CalcAfromh(tirantehidraulico);
            Pm = CalcPmfromh(tirantehidraulico);
            Rh = CrossArea/ Pm;
            velocity = Vmanning(Rh);
            gasto = CrossArea*velocity;
            AnchoSuperficie = calcAnchoSuperficie(tirantehidraulico);

            Froude = calcFroude(velocity,AnchoSuperficie, CrossArea);
            if(isTest==false){
                calcFlujo(Froude);
            }



    }

    public double CalcQfromH(double tirante, boolean isQmax){



        double CrossAreaX = CalcAfromh(tirante);
        double PmX = CalcPmfromh(tirante);
        double RhX = CrossAreaX/ PmX;
        double velocityX = Vmanning(RhX);
        double gastoX = CrossAreaX*velocityX;

        if(isQmax){
            this.QMAX_CrossAreaX = CrossAreaX;
            this.QMAX_PmX = PmX;
            this.QMAX_RhX = RhX;
            this.QMAX_velocityX = velocityX;
            this.QMAX_gastoX = gastoX;
        }

        return gastoX;

    }




    public double CalcAfromh(double tirante){
        double Areadummy;
        //A = 1-2d/D
        double A = 1-((2*tirante)/Diametro);
        double theta = Math.acos(A);

        Areadummy = 0.25*(theta-0.5*(Math.sin(theta*2)))*Diametro*Diametro;
        return Areadummy;
    }

    public double Vmanning(double radioH){
        double Vdummy;
        double Pot23 = (double)2/(double)3;
        double Rh23 =  Math.pow(radioH,Pot23);
        double Pot12 = (double)1/(double)2;
        double slope12 = Math.pow(Slope/((double)1000),Pot12);


        Vdummy = (1/Rugosidad)* (Rh23)*(slope12);

        return Vdummy;

    }



    public double CalcPmfromh(double tirante){
        double PmDummy;

        //A = 1-2d/D
        double A = 1-((2*tirante)/Diametro);
        double theta = Math.acos(A);

        PmDummy = theta*Diametro;
        return PmDummy;
    }


    public double calcAnchoSuperficie(double tirante){
        double ancho;

        //A = 1-2d/D
        double A = 1-((2*tirante)/Diametro);
        double theta = Math.acos(A);

        ancho = Diametro * Math.sin(theta);
        System.out.println( "Ancho de superficie" + ancho);
        return ancho;

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






    public String getCalcNoDone() {
        return CalcNoDone;
    }

    public double getTirante(){
        return tirantehidraulico;
    }

    public double getQmax1() {
        return Qmax1;
    }

    public void setQmax1(double qmax1) {
        Qmax1 = qmax1;
    }

    public double getQmax2() {
        return Qmax2;
    }

    public void setQmax2(double qmax2) {
        Qmax2 = qmax2;
    }

    public void CalcQmax(){

        Qmax1 = CalcQfromH(Diametro, true);
        Qmax2 = CalcQfromH(0.8*Diametro, false);
        Qmed =  CalcQfromH(0.5*Diametro, false);

        QMAX = calcQmaxTuberia();
        hQMAX = calcHQmaxTuberia();
    }

    public void CalcVmax(double tirante){
        Vmax1 = calcVfromH(Diametro);
        Vmax2 = calcVfromH(0.8*Diametro);
    }

    public double calcVfromH(double tirante){
        double AdumX = CalcAfromh(tirante);
        double PmdumX = CalcPmfromh(tirante);
        double RhdummyX = AdumX/PmdumX;
        double VdummyX = Vmanning(RhdummyX);

        return VdummyX;
    }

    public double calcQmaxTuberia(){

        double tirder;

        double Adumder;
        double Pmdumder;
        double Rhdummyder;
        double Vdummyder;

        double Qdummyder;


        double tirC;

        double AdumC;
        double PmdumC;
        double RhdummyC;
        double VdummyC;

        double QdummyC;


        double tiranteIzq ;

        double AdumIzq;
        double PmdumIzq;
        double RhdummyIzq;
        double VdummyIzq;

        double QdummyIzq;
        double dummy = Diametro;

        boolean condicion = true;

        do {
            tirder = dummy;
            tirC = dummy - 0.001;
            tiranteIzq = dummy - 0.002;

            Adumder = CalcAfromh(tirder);
            Pmdumder = CalcPmfromh(tirder);
            Rhdummyder = Adumder / Pmdumder;
            Vdummyder = Vmanning(Rhdummyder);

            Qdummyder = Vdummyder * Adumder;



            AdumC = CalcAfromh(tirC);
            PmdumC = CalcPmfromh(tirC);
            RhdummyC = AdumC / PmdumC;
            VdummyC = Vmanning(RhdummyC);

            QdummyC = VdummyC * AdumC;



            AdumIzq = CalcAfromh(tiranteIzq);
            PmdumIzq = CalcPmfromh(tiranteIzq);
            RhdummyIzq = AdumIzq / PmdumIzq;
            VdummyIzq = Vmanning(RhdummyIzq);

            QdummyIzq = VdummyIzq * AdumIzq;

            //Log.i("Test", "QdummyIzq: " + QdummyIzq + " QdummyC: " + QdummyC + " Qdummyder: "+Qdummyder);

            if (QdummyC>Qdummyder&&QdummyC>QdummyIzq)
            {
                condicion = false;
            } else {
                dummy = dummy - 0.001;

            }

        }while(condicion);




        return QdummyC;



    }

    public double calcHQmaxTuberia(){

        double tirder;

        double Adumder;
        double Pmdumder;
        double Rhdummyder;
        double Vdummyder;

        double Qdummyder;


        double tirC;

        double AdumC;
        double PmdumC;
        double RhdummyC;
        double VdummyC;

        double QdummyC;


        double tiranteIzq ;

        double AdumIzq;
        double PmdumIzq;
        double RhdummyIzq;
        double VdummyIzq;

        double QdummyIzq;
        double dummy = Diametro;

        boolean condicion = true;

        do {
            tirder = dummy;
            tirC = dummy - 0.001;
            tiranteIzq = dummy - 0.002;

            Adumder = CalcAfromh(tirder);
            Pmdumder = CalcPmfromh(tirder);
            Rhdummyder = Adumder / Pmdumder;
            Vdummyder = Vmanning(Rhdummyder);

            Qdummyder = Vdummyder * Adumder;



            AdumC = CalcAfromh(tirC);
            PmdumC = CalcPmfromh(tirC);
            RhdummyC = AdumC / PmdumC;
            VdummyC = Vmanning(RhdummyC);

            QdummyC = VdummyC * AdumC;



            AdumIzq = CalcAfromh(tiranteIzq);
            PmdumIzq = CalcPmfromh(tiranteIzq);
            RhdummyIzq = AdumIzq / PmdumIzq;
            VdummyIzq = Vmanning(RhdummyIzq);

            QdummyIzq = VdummyIzq * AdumIzq;

            //Log.i("Test", "QdummyIzq: " + QdummyIzq + " QdummyC: " + QdummyC + " Qdummyder: "+Qdummyder);

            if (QdummyC>Qdummyder&&QdummyC>QdummyIzq)
            {
                condicion = false;
            } else {
                dummy = dummy - 0.001;

            }

        }while(condicion);




        return tirder;



    }


    public double getQMAX(){

        return QMAX;
    }


    public boolean isSuccess(){
        return Success;
    }

    public double getQMAX_CrossAreaX() {
        return QMAX_CrossAreaX;
    }

    public void setQMAX_CrossAreaX(double QMAX_CrossAreaX) {
        this.QMAX_CrossAreaX = QMAX_CrossAreaX;
    }

    public double getQMAX_PmX() {
        return QMAX_PmX;
    }

    public void setQMAX_PmX(double QMAX_PmX) {
        this.QMAX_PmX = QMAX_PmX;
    }

    public double getQMAX_vRhX() {
        return QMAX_RhX;
    }

    public void setQMAX_vRhX(double QMAX_vRhX) {
        this.QMAX_RhX = QMAX_RhX;
    }

    public double getQMAX_velocityX() {
        return QMAX_velocityX;
    }

    public void setQMAX_velocityX(double QMAX_velocityX) {
        this.QMAX_velocityX = QMAX_velocityX;
    }

    public double getQMAX_gastoX() {
        return QMAX_gastoX;
    }

    public void setQMAX_gastoX(double QMAX_gastoX) {
        this.QMAX_gastoX = QMAX_gastoX;
    }
}
