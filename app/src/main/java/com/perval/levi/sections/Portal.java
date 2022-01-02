package com.perval.levi.sections;

import android.content.res.Resources;
import android.util.Log;

import com.perval.levi.R;

public class Portal {



    private double h1der, h1izq;
    private double h2der, h2izq;
    private double Bottom;
    private double tirantehidraulico;
    private double Radio;
    private double HT;
    private double Pm;
    private double Rh;
    private double nfondo;
    private double n1der,n1izq;
    private double n2der, n2izq;
    private double ntop;
    private double area;
    private double gasto;
    private double velocity;
    private double Rougpond;
    private double slope;
    private double Hrect;

    private double AnchoSuperficie;
    private double Froude;
    private String TipoFlujo ="";

    private double  Vmax1, Vmax2, QmaxAbsolute;
    private double tiranteQMaxAbs;
    private double tiranteVMaxAbs;
    private boolean qMaxWasCalculated = false;
    private boolean vMaxWasCalculated = false;

    private double vMaxAbsolute;

    private final double Pot23= (double)2/(double)3;
    private final double Pot12 = 0.5;
    private boolean Success= false;
    private boolean equalsides = false;

    private Resources resources;

    public Portal(Resources resources){
        this.resources = resources;
    }

    public Portal(){

    }
    
    public void seth1der(double h1der){
        this.h1der = h1der;
    }

    public void seth1izq(double h1izq){

        this.h1izq = h1izq;

    }


    public void seth2der(double h2der){
        this.h2der = h2der;
    }

    public void seth2izq(double h2izq){
        this.h2izq = h2izq;
    }

    public void setBottom(double bottom){
        this.Bottom = bottom;
    }

    public void setTirante(double tirante){
        this.tirantehidraulico = tirante;
    }

    public void setRadio(double radio){
        this.Radio = radio;
    }

    public void setHT(double Htot){
        this.HT = Htot;
    }

    public void setPm(double pm){
        this.Pm = pm;
    }

    public void setRh(double rh){
        this.Rh = rh;
    }

    public void setnfondo(double nfond){

        this.nfondo = nfond;
    }

    public void setn1der(double n1der){
        this.n1der = n1der;
    }

    public void setn1izq(double n1izq){
        this.n1izq = n1izq;
    }

    public void setn2der(double n2der){
        this.n2der = n2der;
    }

    public void setn2izq(double n2izq){
        this.n2izq = n2izq;
    }

    public void setntop(double ntop){
        this.ntop = ntop;
    }

    public void setarea(double area){
        this.area= area;
    }

    public void setGastoAsLPS(double gasto){
        this.gasto = gasto/1000;
    }

    public void setvel(double vel){
        this.velocity = vel;
    }

    public void setRoudpond(double roug){
        this.Rougpond = roug;
    }

    public void setslope(double slope){
        this.slope = slope/1000;
    }

    public void setHrect(){

        double hder= h1der + h2der;
        double hizq = h1izq + h2izq;
        if(hder==hizq){
            Hrect = hder;
            equalsides = true;
        } else {
            equalsides = false;
        }

    }

    //////////////inician los metodos get////////

    public double getFroude(){
        return  Froude;
    }

    public String getTipoFlujo(){
        return TipoFlujo;
    }

    public double getnfond(){
        return this.nfondo;
    }

    public double geth1der(){
        return this.h1der;
    }

    public double geth2der(){
        return this.h2der;
    }

    public double geth1izq(){
        return this.h1izq;
    }

    public double geth2izq(){
        return this.h2izq;
    }

    public double getBottom(){
        return this.Bottom;
    }

    public double getTirante(){
        return this.tirantehidraulico;
    }

    public double getRadio(){
        return this.Radio;
    }

    public double getHT(){
        return this.HT;
    }

    public double getPm(){
        return this.Pm;
    }

    public double getRh(){
        return this.Rh;
    }

    public double getn1der(){
        return this.n1der;
    }

    public double getn2der(){
        return this.n2der;
    }

    public double getn1izq(){
        return this.n1izq;
    }

    public double getn2izq(){
        return this.n2izq;
    }

    public double getntop(){
        return this.ntop;
    }

    public double getArea(){
        return this.area;
    }

    public double getGasto(){
        return this.gasto;
    }

    public double getVel(){
        return this.velocity;
    }

    public double getRougpond(){

        return this.Rougpond;
    }

    public double getHrect(){
        return this.Hrect;
    }

    public double getSlope(){
        return this.slope;
    }

    ///////Funciones de calculo

    public double calcnder(double tirante){

        double ni;
        if (tirante <= Hrect ){
            if(tirante <=h1der){
                ni = n1der;
            } else{

                ni= (n1der*h1der + n2der* (tirante-h1der))/tirante;

            }


        } else {
            //Cuando tirante es mayor que H rect y empieza a fluir el agua también en la parte curveada.

            ni= (n1der*h1der + n2der*h2der)/Hrect;

        }



        return ni;
    }

    public void calcHt(){

        HT = Hrect + Bottom/2;
    }

    public double calcnizq(double tirante){

        double ni;


        if(tirante< Hrect){


            if(tirante <h1izq){
                ni = n1izq;
            } else{

                ni= (n1izq*h1izq + n2izq* (tirante-h1izq))/tirante;


            }

        } else {
            //Cuando tirante es mayor que H rect y empieza a fluir el agua también en la parte curveada.
            ni= (n1izq*h1izq + n2izq* h2izq)/Hrect;

            }



        return ni;
    }

    public double calcPm(double tirante){
        double Pmi;
        double pmcup;
        if(tirante <= Hrect){
            Pmi = Bottom +2*tirante;
        } else {

            pmcup = calcPmcupula(tirante);
            Pmi = Bottom + 2*Hrect + pmcup;
        }
        return Pmi;
    }

    public double calcPmcupula(double tirante){
        double pmcupula;
        double radioi = Bottom/2;
        double theta;
        double areai;
        double Diami = 2*radioi;
        double A;
        double tirantei;
        if(tirante <= Hrect){
            pmcupula=0;
        } else {
            tirantei = radioi -(tirante - Hrect);

            A = 1 - 2*tirantei/(Diami);

            theta = Math.acos(A);

            pmcupula = 0.5*Diami*Math.PI - Diami*theta;
        }

        return pmcupula;
    }

    public double calcAcupula(double tirante){

        double radioi = Bottom/2;
        double theta;
        double areai;
        double Diami = 2*radioi;
        double A, B;
        double tirantei;
        if(tirante <=Hrect){
            areai=0;
        } else {

            tirantei = radioi -(tirante - Hrect);

            A = 1 - 2*tirantei/(Diami);

            theta = Math.acos(A);


            B = (Diami*Diami/4) *(theta -0.5* Math.sin(2*theta));


            areai = 0.5 * Math.PI* Diami*Diami/4 -B;

        }

        return areai;
    }

    public double calcArea(double tirante){

        double Ai;

        if(tirante <=Hrect){
            Ai = Bottom*tirante;
        } else {

            Ai = Bottom* Hrect +(calcAcupula(tirante));
        }


        return Ai;
    }


    public double calcRugpond(double tirante){

        double npond;
        if(tirante <=Hrect){
            npond = (Bottom*nfondo + calcnder(tirante)*tirante + calcnizq(tirante)*tirante)/calcPm(tirante);
        } else {

            npond = (Bottom*nfondo +calcnder(tirante)*Hrect +calcnizq(tirante)*Hrect + ntop*calcPmcupula(tirante))/calcPm(tirante);

        }


        return npond;

    }

    public double Vmann(double tirante){
        double vdum;
        double pmdum;
        double adum;
        double rhdum;
        double rougi;
        adum = calcArea(tirante);
        pmdum = calcPm(tirante);
        rhdum = adum/pmdum;
        rougi = calcRugpond(tirante);
        vdum = (1/rougi)*Math.pow(rhdum,this.Pot23)*Math.pow(this.slope,this.Pot12);
        return vdum;
    }

    public void calcFromQLimitSearch(double gastox){
        Log.i("LogTest", "calcFromQLimitSearch, start");
        double tirante0 = 0.001;

        double tirante1;
        double tirante2 = HT - 0.01;
        double oldTirante1 = -9;
        double Pm0, Pm1, Pm2;
        double diferencia= 10;

        calcQmaxAbs();
        int counter = 0;
        if(qMaxWasCalculated==false){
            Log.i("LogTest", "qMaxWasCalculated is false");
            return;
        }

        tirante2 = this.tiranteQMaxAbs;
        Log.i("LogTest", "qMaxWasCalculated before calculation");
        if(gastox> QmaxAbsolute){

            Log.i("LogTest", "gastox < QmaxAbsolute");
            Success = false;
        } else {
            Log.i("LogTest", "calcFromQLimitSearch starting calculation");
            do {
                Log.i("LogTest", "calcFromQLimitSearch, counter: "  + counter);
                if(tirante0>tirante2){
                    Success = false;
                    break;
                }
                double Adummy0, Adummy1, Adummy2;
                double Vdummy0, Vdummy1, Vdummy2;
                double Q0, Q1, Q2;
                double Rh0, Rh1;

                tirante1 = (tirante0 + tirante2) / 2;

                Adummy0 = calcArea(tirante0);
                Pm0 = calcPm(tirante0);
                Vdummy0 = Vmann(tirante0);
                Q0 = Adummy0 * Vdummy0;

                Adummy1 = calcArea(tirante1);
                Pm1 = calcPm(tirante1);
                Vdummy1 = Vmann(tirante1);
                Q1 = Adummy1 * Vdummy1;

                Adummy2 = calcArea(tirante2);
                Pm2 = calcPm(tirante2);
                Vdummy2 = Vmann(tirante2);
                Q2 = Adummy2 * Vdummy2;
                Log.i("LogTest", "lowebound: " + tirante0 + ", middle value: "+ tirante1 + ", upper value: "+ tirante2) ;
                Log.i("LogTest", "Q(h0): " + Q0 + ", Q(h1): "+ Q1 + ", Q(h2): "+Q2) ;
                if (gastox < Q1) {
                    //The value is in the first middle (the lower)
                    //Next Upper bound


                    //Tirante 0 keeps the same value, just is updated the upper limit.

                    oldTirante1 = tirante1;
                    tirante2 = tirante1;

                } else {
                    //The value is in the second part (the upper)
                    //Next lower bound
                    //Tirante 2 keeps the same value, just is updated the lower bound.
                    oldTirante1 = tirante1;
                    tirante0 = tirante1;
                }

                diferencia = Math.abs(gastox - Q1);
                counter++;
            }while(diferencia>0.001);


            Log.i("LogTest", "It was passed the do while");
            if(diferencia<0.002){
                if(oldTirante1<0){
                    Success = false;
                } else {
                    Success = true;
                    this.setTirante(oldTirante1);
                    area = calcArea(tirantehidraulico);
                    Rougpond = calcRugpond(tirantehidraulico);
                    velocity =  Vmann(tirantehidraulico);
                    Pm = calcPm(tirantehidraulico);
                    Rh = area /Pm;
                    gasto = area * velocity;
                    AnchoSuperficie = calcAnchoLibre(tirantehidraulico);
                    Froude = calcFroude(velocity, AnchoSuperficie,area);
                    calcFlujo(Froude);
                }
            }
        }

    }

    public void calcfromH(double tirante){


        if(tirante>HT){

            Success = false;

        } else {
            Success = true;

            area = calcArea(tirantehidraulico);
            velocity =  Vmann(tirantehidraulico);
            Rougpond = calcRugpond(tirantehidraulico);

            Pm = calcPm(tirantehidraulico);
            Rh = area /Pm;
            gasto = area * velocity;

            AnchoSuperficie = calcAnchoLibre(tirantehidraulico);
            Froude = calcFroude(velocity, AnchoSuperficie,area);
            calcFlujo(Froude);
        }

    }


    public void calcfromV(double velx){
        calcVmaxAbs();

        double tirante0 = 0.001;

        double tirante1;
        double tirante2;

        double oldTirante;
        double V0, V1, V2;

        double diferencia= 10;



        if(vMaxWasCalculated==false){
            return;
        }
        tirante2= tiranteVMaxAbs;
        if(velx>vMaxAbsolute){
            Success = false;
            return;

        } else {

            do {

                tirante1 = (tirante0+tirante2)/2;
                V0 = Vmann(tirante0);
                V1 = Vmann(tirante1);
                V2 = Vmann(tirante2);

                Log.i("TestLog", "CalcFromV");
                Log.i("TestLog", "tirante0: " + tirante0 + ", tirante1: " + tirante1 +
                        "tirante2: " + tirante2);

                Log.i("TestLog", "V0: " + V0 + ", V1: " + V1 +
                        "V2: " + V2);


                if (velx < V1) {
                    //The value is in the first middle (the lower)
                    //Next Upper bound
                    //Tirante 0 keeps the same value, just is updated the upper limit.
                    oldTirante = tirante1;
                    tirante2 = tirante1;

                } else {
                    //The value is in the second part (the upper)
                    //Next lower bound
                    //Tirante 2 keeps the same value, just is updated the lower bound.
                    oldTirante = tirante1;
                    tirante0 = tirante1;
                }

                diferencia = Math.abs(velx - V1);
            } while (diferencia >=0.0005);

            if(tirante1>HT || tirante1<0){
                Success = false;
                return;
            }

            if(diferencia<=0.005){
                Success = true;
                tirantehidraulico = oldTirante;
                area = calcArea(tirantehidraulico);
                Rougpond = calcRugpond(tirantehidraulico);
                velocity =  Vmann(tirantehidraulico);
                Pm = calcPm(tirantehidraulico);
                Rh = area /Pm;
                gasto = area * velocity;
                AnchoSuperficie = calcAnchoLibre(tirantehidraulico);
                Froude = calcFroude(velocity, AnchoSuperficie,area);
                calcFlujo(Froude);
            }
        }

    }

    public boolean isSuccess(){
        return this.Success;
    }



    public void calcQmaxAbs(){
        //This method calculates the maximum capacity of the tunnel
        double tirante = this.Hrect;
        double oldTirante = -9;
        double deltaH = 0.01;
        double oldQmax = 0;
        double qMaxCurrent = 0;
        //double diferencia = 10;
        double areaQmax = -999;
        double vQmax = -999;
        boolean goToNexCalculation = true;
        do{
            areaQmax = calcArea(tirante);
            vQmax = Vmann(tirante);
            qMaxCurrent = areaQmax*vQmax;

            if(qMaxCurrent<oldQmax ){
                goToNexCalculation = false;
            } else {
                oldQmax = qMaxCurrent;
                oldTirante = tirante;
                tirante = tirante + deltaH;

            }

        }while (goToNexCalculation);

        if(oldTirante<0){
            return;
        } else {
            tiranteQMaxAbs = oldTirante;
            areaQmax = calcArea(oldTirante);
            vQmax = Vmann(oldTirante);
            QmaxAbsolute = areaQmax * vQmax;
            qMaxWasCalculated = true;
        }
    }

    public void calcVmaxAbs(){
        //This method calculates the maximum capacity of the tunnel
        double tirante = this.Hrect/2;
        double oldTirante = -9;
        double deltaH = 0.01;
        double oldVmax = 0;
        double vMaxCurrent = 0;
        //double diferencia = 10;
        double areaQmax = -999;
        double vQmax = -999;
        boolean goToNexCalculation = true;
        do{

            vMaxCurrent = Vmann(tirante);


            if(vMaxCurrent<oldVmax ){
                goToNexCalculation = false;
            } else {
                oldVmax = vMaxCurrent;
                oldTirante = tirante;
                tirante = tirante + deltaH;

            }

        }while (goToNexCalculation);

        if(oldTirante<0){
            return;
        } else {


            vMaxAbsolute = Vmann(oldTirante);
            tiranteVMaxAbs = oldTirante;
            vMaxWasCalculated = true;
        }
    }

    public double calcAnchoLibre(double tirantex){
        double ancholibre;
        if(tirantex<Hrect){
            ancholibre = Bottom;
        } else {
            tirantex = 0.5*Bottom -(tirantex - Hrect);
            double A = 1 - 2*tirantex/(Bottom);
            double theta = Math.acos(A);
            ancholibre = (Bottom) * Math.sin(theta);
        }
        return ancholibre;
    }


    public double calcFroude(double velocity, double Tancho, double Areax){

        double Froudex;
        Froudex = velocity/(Math.pow((9.81*(Areax/Tancho)),0.5));
        return Froudex;

    }

    public void calcFlujo(double Froudex){

        if(Froudex ==1){

            TipoFlujo = resources.getString(R.string.critico);
        } else {

            if(Froudex<1){
                TipoFlujo = resources.getString(R.string.subcritico);
            } else {

                TipoFlujo = resources.getString(R.string.supercritico);
            }
        }

    }

}
