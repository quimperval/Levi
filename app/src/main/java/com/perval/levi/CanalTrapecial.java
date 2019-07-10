package com.perval.levi;

import android.util.Log;

public class CanalTrapecial {


    private double kder, kizq;
    private double BLibre;
    private double Htrap;
    private double Btrap;
    private double Pmtrap;
    private double AnchoSuperficie;
    private double RHtrap;
    private double Froude;
    private String TipoFlujo;
    private double Vrect;

    private double Rugpond;

    private double sloperect;

    private double gastorect;

    private double tirantehidraulico;

    private double RelTH;

    private double Rugizq, Rugder, Rugfondo;

    private double Lizq, Lder;

    private double Aizq, Ader, Afondo;

    private double Atotal;

    private double Qmax, Vmax;


    private boolean Success = false;

    public void CanalRectangular(){

    }

    public void setTirante(double tirante){
        this.tirantehidraulico = tirante;
    }
    public void setHtrap(double Htrap){
        this.Htrap = Htrap;
    }

    public void setBtrap(double Btrap){
        this.Btrap = Btrap;
    }

    public void setPmtrap(double Pmtrap){
        this.Pmtrap = Pmtrap;
    }

    public void setRHtrap(double RHtrap){
        this.RHtrap = RHtrap;

    }

    public void setVrect(double Vrect){
        this.Vrect = Vrect;
    }

    public void setRugizq(double rugizq){
        this.Rugizq = rugizq;
    }

    public void setRugder(double rugder){

        this.Rugder = rugder;
    }

    public void setRugfondo(double rugfondo){

        this.Rugfondo = rugfondo;

    }

    public void setslope(double slope){
        this.sloperect = slope/1000;
    }

    public void setgasto(double gasto){
        this.gastorect = gasto/((double)1000);
    }

    public void setKder(double kder){

        this.kder = kder;
    }

    public void setKizq(double kizq){
        this.kizq = kizq;
    }

    //////////////////////////////////////////

    public String getTipoFlujo(){
        return TipoFlujo;
    }

    public double getFroude(){
        return Froude;
    }

    public double getRugizq(){
        return Rugizq;
    }

    public double getRugder(){
        return Rugder;
    }

    public double getRugfondo(){
        return Rugfondo;
    }

    public double calcRugpond(double Lizq1, double Lder1){

        double Lt = Lizq1 + Lder1 +Btrap;

        return (((Rugizq*Lizq1)+(Rugder*Lder1)+(Rugfondo*Btrap))/Lt);

    }


    public double calcPmlado(double Li, double tirante){
        double valor;
        valor = Math.pow((Li*Li)+(tirante*tirante),0.5);
        return valor;

    }

    public double calcLi(double K, double tirante){
        double valor;

        valor = K*tirante;

        return valor;
    }

    public double calcAi(double Li, double tirante){
        double valor;

        valor = (double)0.5*(Li*tirante);
        return valor;

    }

    public double calcAfondo(double tirante){
        
        return (tirante * Btrap);
    }

    public double getTirante(){
        return this.tirantehidraulico;
    }

    public double getHtrap(){
        return this.Htrap;
    }

    public double getBtrap(){
        return this.Btrap;
    }

    public double getPmtrap(){
        return this.Pmtrap;
    }

    public double getRHtrap(){
        return this.RHtrap;

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


    public double getslope(){
        return this.sloperect;
    }

    public double getRugpond(){

        return this.Rugpond;
    }

    public double getAtotal(){
        return Atotal;
    }

    public double getgasto(){
        return this.gastorect;
    }

    public double calcPm(double der, double izq, double tirante){

        double A = Math.pow((der*der + tirante*tirante),(double)0.5) + Math.pow((izq*izq + tirante*tirante),(double)0.5);
        return (A +Btrap);
    }

    public double calcAH(double Aizq, double Ader, double Arecta){

        return (Aizq+Ader+Arecta);
    }

    public double Vmann_rect(double tirante, double rugosidad){

        double Vdumm;
        double lDer, lIzq;
        double Ader, Aizq;
        double Abase = calcAfondo(tirante);
        lDer = calcLi(kder, tirante);
        lIzq = calcLi(kizq, tirante);
        Ader = calcAi(lDer,tirante);
        Aizq = calcAi(lIzq,tirante);
        double Adumm = calcAH(Ader, Aizq,Abase);

        double Pmdumm = calcPm(lDer, lIzq, tirante);

        double Rhdumm =Adumm/Pmdumm;

        double Rh23 = Math.pow(Rhdumm, (double)2/(double)3);

        double pot12 = ((double)1)/((double)2);

        double slope12 = Math.pow(sloperect, (double) 0.5);

        Vdumm = ((double)1/rugosidad) *Rh23*slope12;

        return Vdumm;


    }

    public void calcfromQ(){

        double Qdummy0, Qdummy1;
        double lDer0, lIzq0;
        double lDer1, lIzq1;
        double Abase0, Abase1;
        double Ader0, Aizq0;
        double Ader1, Aizq1;
        double Adummy0, Adummy1;
        double Vdummy0, Vdummy1;
        double Rhdummy0, Rhdummy1;
        double Pmdummy0, Pmdummy1;
        double rug0, rug1;
        double tirante0 = (double) 0.01;
        double tirante1 = (Htrap-(double)0.01);

        double diferencia;

        double Fx0, Fx1;
        calcMax();
        if(gastorect > Qmax){

            Success = false;
        } else {

            double iteracion = 0;
            do{
                ++iteracion;

                lDer0 = calcLi(kder,tirante0);
                lIzq0 = calcLi(kizq, tirante0);
                Ader0 = calcAi(lDer0, tirante0);
                Aizq0 = calcAi(lIzq0, tirante0);
                Abase0 = calcAfondo(tirante0);
                Adummy0 = calcAH(Aizq0, Ader0,Abase0);

                Pmdummy0 = calcPm(lDer0,lIzq0, tirante0);

                Rhdummy0 = Adummy0/Pmdummy0;

                rug0 = calcRugpond(lDer0,lIzq0);

                Vdummy0 = Vmann_rect(tirante0, rug0);
                Qdummy0 = Adummy0 * Vdummy0;
                Fx0 = Qdummy0 - gastorect;

                lDer1 = calcLi(kder,tirante1);
                lIzq1 = calcLi(kizq, tirante1);
                Ader1 = calcAi(lDer1, tirante1);
                Aizq1 = calcAi(lIzq1, tirante1);
                Abase1 = calcAfondo(tirante1);
                Adummy1 = calcAH(Aizq1, Ader1,Abase1);

                Pmdummy1 = calcPm(lDer1,lIzq1, tirante1);

                Rhdummy1 = Adummy1/Pmdummy1;

                rug1 = calcRugpond(lDer1,lIzq1);

                Vdummy1 = Vmann_rect(tirante1, rug1);
                Qdummy1 = Adummy1 * Vdummy1;
                Fx1 = Qdummy1 - gastorect;


                double Tnext = tirante1 - (Fx1 *(tirante0-tirante1))/(Fx0-Fx1);

                tirante0 = tirante1*1;
                tirante1 = Tnext*1;

                diferencia = Math.abs(tirante1- tirante0);

            } while (diferencia >0.00001);

            if(tirante1>Htrap){
                Success = false;
            } else {

                Success = true;
                tirantehidraulico = tirante1;

                Lder = calcLi(kder,tirante1);
                Lizq = calcLi(kizq,tirante1);
                Ader = calcAi(Lder,tirante1);
                Aizq = calcAi(Lizq, tirante1);
                Afondo = calcAfondo(tirante1);
                Atotal = calcAH(Ader, Aizq,Afondo);
                Pmtrap = calcPm(Lder, Lizq, tirantehidraulico);
                RHtrap = Atotal / Pmtrap;
                Rugpond = calcRugpond(Lder,Lizq);
                Vrect = Vmann_rect(tirante1, Rugpond);
                gastorect = Atotal * Vrect;

                BLibre = Htrap-tirantehidraulico;

                RelTH = tirantehidraulico/Htrap;

                AnchoSuperficie = Btrap + Lder + Lizq;
                Froude = calcFroude(Vrect,AnchoSuperficie,Atotal);
                calcFlujo(Froude);


            }
        }

    }



    public void calcfromV(){
        double Qdummy0, Qdummy1;
        double lDer0, lIzq0;
        double lDer1, lIzq1;
        double Abase0, Abase1;
        double Ader0, Aizq0;
        double Ader1, Aizq1;
        double Adummy0, Adummy1;
        double Vdummy0, Vdummy1;
        double Rhdummy0, Rhdummy1;
        double Pmdummy0, Pmdummy1;
        double rug0, rug1;

        double tirante0 = (double) 0.0001;
        double tirante1 = (Htrap-(double)0.0001);

        double diferencia;

        double Fx0, Fx1;

        int contador = 0;
        calcMax();

        if(Vrect > Vmax) {
            Success = false;

        } else {

            do{
                contador = contador+1;

                lDer0 = calcLi(kder,tirante0);
                lIzq0 = calcLi(kizq, tirante0);
                Ader0 = calcAi(lDer0, tirante0);
                Aizq0 = calcAi(lIzq0, tirante0);
                Abase0 = calcAfondo(tirante0);
                Adummy0 = calcAH(Aizq0, Ader0,Abase0);

                Pmdummy0 = calcPm(lDer0,lIzq0, tirante0);

                Rhdummy0 = Adummy0/Pmdummy0;

                rug0 = calcRugpond(lDer0,lIzq0);

                Vdummy0 = Vmann_rect(tirante0, rug0);

                Fx0 = Vdummy0 - Vrect;

                lDer1 = calcLi(kder,tirante1);
                lIzq1 = calcLi(kizq, tirante1);
                Ader1 = calcAi(lDer1, tirante1);
                Aizq1 = calcAi(lIzq1, tirante1);
                Abase1 = calcAfondo(tirante1);
                Adummy1 = calcAH(Aizq1, Ader1,Abase1);

                Pmdummy1 = calcPm(lDer1,lIzq1, tirante1);


                Rhdummy1 = Adummy1/Pmdummy1;


                rug1 = calcRugpond(lDer1,lIzq1);

                Vdummy1 = Vmann_rect(tirante1, rug1);


                Fx1 = Vdummy1 - Vrect;


                double Tnext = tirante1 - (Fx1 *(tirante0-tirante1))/(Fx0-Fx1);

                if(Tnext<0){
                    Tnext = 0.0001;
                } else {
                    //NADA
                }

                tirante0 = tirante1*1;
                tirante1 = Tnext*1;


                diferencia = Math.abs(tirante1- tirante0);

            } while ((diferencia >0.00001)&&(contador<50)&&(tirante1<(2*Htrap)));

            if((tirante1>Htrap)){
                Success = false;
            } else {

                Success = true;


                tirantehidraulico = tirante1;

                Lder = calcLi(kder,tirante1);
                Lizq = calcLi(kizq,tirante1);

                Ader = calcAi(Lder,tirante1);
                Aizq = calcAi(Lizq, tirante1);
                Afondo = calcAfondo(tirante1);
                Atotal = calcAH(Ader, Aizq,Afondo);

                Pmtrap = calcPm(Lder, Lizq, tirantehidraulico);
                RHtrap = Atotal / Pmtrap;
                Rugpond = calcRugpond(Lder,Lizq);
                Vrect = Vmann_rect(tirante1, Rugpond);

                gastorect = Atotal * Vrect;

                BLibre = Htrap-tirantehidraulico;

                RelTH = tirantehidraulico/Htrap;

                AnchoSuperficie = Btrap + Lder + Lizq;
                Froude = calcFroude(Vrect,AnchoSuperficie,Atotal);
                calcFlujo(Froude);


            }

        }


    }


    public void calcfromH(){
        if(tirantehidraulico>Htrap){

            Success = false;
        } else {

            Success = true;


            Lder = calcLi(kder,tirantehidraulico);
            Lizq = calcLi(kizq,tirantehidraulico);
            Ader = calcAi(Lder,tirantehidraulico);
            Aizq = calcAi(Lizq, tirantehidraulico);
            Afondo = calcAfondo(tirantehidraulico);
            Atotal = calcAH(Ader, Aizq,Afondo);

            Pmtrap = calcPm(Lder, Lizq, tirantehidraulico);
            RHtrap = Atotal / Pmtrap;
            Rugpond = calcRugpond(Lder,Lizq);
            Vrect = Vmann_rect(tirantehidraulico, Rugpond);

            gastorect = Atotal * Vrect;

            BLibre = Htrap-tirantehidraulico;

            RelTH = tirantehidraulico/Htrap;
            AnchoSuperficie = Btrap + Lder + Lizq;
            Froude = calcFroude(Vrect,AnchoSuperficie,Atotal);
            calcFlujo(Froude);
        }



    }


    public void calcMax(){

        double tirante0 = Htrap;


        double lDer0 = calcLi(kder,tirante0);
        double lIzq0 = calcLi(kizq, tirante0);
        double Ader0 = calcAi(lDer0, tirante0);
        double Aizq0 = calcAi(lIzq0, tirante0);
        double Abase0 = calcAfondo(tirante0);
        double Adummy0 = calcAH(Aizq0, Ader0,Abase0);

        double Pmdummy0 = calcPm(lDer0,lIzq0, tirante0);

        double Rhdummy0 = Adummy0/Pmdummy0;

        double rug0 = calcRugpond(lDer0,lIzq0);

        Vmax = Vmann_rect(tirante0, rug0);
        Qmax = Adummy0 * Vmax;


    }

    public boolean isSuccess(){
        return Success;
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
