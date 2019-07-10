package com.perval.levi;

import android.util.Log;

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
    private double Pmder, Pmizq;
    private double nder, nizq;
    private double Pmtop;
    private double AnchoSuperficie;
    private double Froude;
    private String TipoFlujo;

    private double Qmax1, Qmax2, Vmax1, Vmax2;

    private final double Pot23= (double)2/(double)3;
    private final double Pot12 = 0.5;
    private boolean Success= false;
    private boolean equalsides = false;


    public void Portal(){


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

    public void setgasto(double gasto){
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

    public void calcfromQ(double gastox){
        double tirante0 = 0.01;

        double tirante1 = HT - 0.01;
        double Adummy0, Adummy1;
        double Vdummy0, Vdummy1;

        double Q0, Q1;
        double Rh0, Rh1;
        double Pm0, Pm1;
        double diferencia= 0;

        double Fx0, Fx1;


        //Fx0 = q(h0) - gasto

        //Fx1 = q(h1) - gasto
        double iterador = 0;
        calcQmax();
        if(gastox>Qmax1 || gastox >Qmax2){

            Success = false;

        } else {


            do {
                ++iterador;

                //Calculo de Fx0
                Adummy0 = calcArea(tirante0);
                Pm0=calcPm(tirante0);
                Rh0 = Adummy0 /Pm0;
                Vdummy0 = Vmann(tirante0);
                Q0 = Adummy0 * Vdummy0;

                Fx0 = Q0 - gastox;


                ///////////////
                //Calculo de Fx1

                Adummy1 = calcArea(tirante1);
                Pm1 = calcPm(tirante1);
                Rh1 = Adummy1 /Pm1;
                Vdummy1 = Vmann(tirante1);
                Q1 = Adummy1 * Vdummy1;

                Fx1 = Q1 - gastox;


                //Calculo del siguiente valor de tirante
                double Next;

                Next = tirante1  - ((tirante0 - tirante1)/(Fx0 - Fx1))*Fx1;

                if(Next <0){
                    Next = 0.01;

                } else {
                    //NADA
                }


                tirante0 = tirante1;
                tirante1 = Next;
                diferencia = Math.abs(tirante1 - tirante0);

                if(tirante0 == tirante1){
                    tirante0 = 0.05*HT;
                }



            } while (diferencia >0.001&&(iterador <50));

            if((tirante1>HT&&(iterador>50)||tirante1>HT)||iterador>50){

                Success = false;
            } else {
                Success = true;

            }


            if(Success){

                tirantehidraulico = tirante1;
                area = calcArea(tirantehidraulico);
                Rougpond = calcRugpond(tirantehidraulico);

                velocity =  Vmann(tirantehidraulico);
                Pm = calcPm(tirantehidraulico);
                Rh = area /Pm;
                gasto = area * velocity;

                AnchoSuperficie = calcAnchoLibre(tirantehidraulico);
                Froude = calcFroude(velocity, AnchoSuperficie,area);
                calcFlujo(Froude);


            } else {
                //nada
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
        double tirante0 = 0.01;

        double tirante1 = HT - 0.01;
        double Adummy0, Adummy1;
        double Vdummy0, Vdummy1;

        double Q0, Q1;
        double Rh0, Rh1;
        double Pm0, Pm1;
        double diferencia= 0;

        double Fx0, Fx1;


        //Fx0 = q(h0) - gasto

        //Fx1 = q(h1) - gasto

        double iterador=0;

        if(velx>Vmax1 || velx>Vmax2){
            Success = false;

        } else {

            do {
                ++iterador;
                //Calculo de Fx0
                Adummy0 = calcArea(tirante0);
                Pm0=calcPm(tirante0);
                Rh0 = Adummy0 /Pm0;
                Vdummy0 = Vmann(tirante0);


                Fx0 = Vdummy0 - velx;

                ///////////////
                //Calculo de Fx1

                Adummy1 = calcArea(tirante1);
                Pm1 = calcPm(tirante1);
                Rh1 = Adummy1 /Pm1;
                Vdummy1 = Vmann(tirante1);

                Fx1 = Vdummy1 - velx;


                //Calculo del siguiente valor de tirante
                double Next;

                Next = tirante1  - ((tirante0 - tirante1)/(Fx0 - Fx1))*Fx1;
                if(Next <0){
                    Next = 0.01;

                } else {
                    //NADA
                }


                tirante0 = tirante1;
                tirante1 = Next;
                diferencia = Math.abs(tirante1 - tirante0);

                if(tirante0 == tirante1){
                    tirante0 = 0.5*HT;
                }

            } while (diferencia >0.001&&(iterador<50));


            if(tirante1>HT){

                Success = false;

            } else {
                Success = true;
            }

            if(Success){

                tirantehidraulico = tirante1;
                area = calcArea(tirantehidraulico);
                Rougpond = calcRugpond(tirantehidraulico);
                velocity =  Vmann(tirantehidraulico);
                Pm = calcPm(tirantehidraulico);
                Rh = area /Pm;
                gasto = area * velocity;
                AnchoSuperficie = calcAnchoLibre(tirantehidraulico);
                Froude = calcFroude(velocity, AnchoSuperficie,area);
                calcFlujo(Froude);


            } else {
                //nada
            }

        }

    }

    public boolean isSuccess(){
        return this.Success;
    }

    public void calcQmax(){
        double A1, A2;
        double V1, V2;

        A1 = calcArea(HT);
        Vmax1 = Vmann(HT);

        A2 = calcArea(HT-0.01);
        Vmax2 = Vmann(HT-0.01);
        Qmax1 = A1*Vmax1;
        Qmax2 = A2*Vmax2;
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

            TipoFlujo = "Crítico";
        } else {

            if(Froudex<1){
                TipoFlujo = "Subcrítico";
            } else {

                TipoFlujo = "Supercrítico";
            }
        }

    }

}
