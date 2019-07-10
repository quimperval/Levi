package com.perval.levi;

import java.util.*;

public class Tuberia
{
	private String ID;
	//Dint in m
	private double Dint;
	//Dext in m;
	private double DExt;
	//Dext in mm
	private double thickness;
	//area in m2
	private double CrossArea;
	//flow in m3/s
	private double flow;
	//vel in m/s
	private double velocity;
	//roughness in mm
	private double roughness;
	//viscocity in SI
	private static double visc=0.00000104 ;
	
	private double HV;
	
	//headloss in m/km
	private double headloss;
	
	private double Reynolds;
	
	private double Darcyf;
	
	public void Tuberia(){
		
		ID = "";
		Dint=0.00;
		DExt=0.00;
		thickness= 0.00;
		CrossArea = 0.00;
		flow = 0.00;
		velocity=0.00;
		roughness =0.00;
		headloss = 0.00;
		Reynolds= 0.00;
		Darcyf = 0.00;	
	}
	
	public void setID(String IDin){
		ID = IDin;
	}
	
	public void setVel(double vel){
		velocity = vel;
	}
	
	public void setrough(double roughness){

		this.roughness = roughness/1000;
	}
	
	public void setflow(double Qin){
		flow = Qin;
	}
	
	public void setDint(double DiamInt){
		System.out.println("setDint " + DiamInt);
		Dint = DiamInt/1000;
	}
	
	public void setDext(double Diamext){
		DExt = Diamext;
	}
	
	public void setHL(double HLin){
		headloss = HLin;
	}
	
	public void CalcArea(){
		System.out.println("calc area, Dint " + Dint);
		CrossArea = 3.14159 * ((Dint * Dint)/4);
	}
	
	public void CalcReynolds(){
		Reynolds = velocity * Dint /visc;
		System.out.println("Reynolds " + Reynolds);
	}
	
	public void calcDarcyf(){
		//ecuacion de swamee jain
		double A =( (roughness/ Dint)/3.71) + 5.74/ (Math.pow(Reynolds,0.90));
		double B = Math.log10(A);
		Darcyf= 0.25/(B*B);
		System.out.println("Darcy f " + Darcyf);
		
	}
	
	public void CalcfromQ(){
		CalcArea();
		velocity = flow / CrossArea;
		CalcReynolds();
		calcDarcyf();
		HV = velocity* velocity/(2*9.81);
		System.out.println("HV " + HV);
		headloss = Darcyf * 1* HV/Dint;
		
	} 
	
	public void CalcfromV(){
		CalcArea();
		flow = velocity* CrossArea;
		CalcReynolds();
		calcDarcyf();
		headloss = Darcyf * velocity * velocity / (2 * 9.81);
	}
	
	public void CalcfromHL(){
		
		double HLdummy = 1* headloss;
		
		do {
			
		} while ((HLdummy - headloss)<0.001);
		
		
	}
	
	
	public double getQ(){
		return flow;
	}
	
	public double getArea(){
		return CrossArea;
	}
	
	public double getvel(){
		return velocity;
	}
	
	public double getHL(){
		return headloss;
	}
	
	public double getRey(){
		
		return Reynolds;
	}
	
	public double getDarcyf(){
		return Darcyf;
	}

	public double getRough(){
	    return roughness;
    }
}
