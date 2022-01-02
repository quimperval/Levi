package com.perval.levi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Symbology extends AppCompatActivity {

    //private String[] options = {"Trapecial","Rectangular","Portal","Circular", "Presión"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symbology);
        TextView mTextView = (TextView) findViewById(R.id.contents);
        TextView mTextEjemplo = (TextView) findViewById(R.id.howtouse) ;

        TextView titUso = (TextView) findViewById(R.id.title_ejemplo);


        Intent intent = this.getIntent();
        if(intent.getStringExtra("option")!=null){
            String option = intent.getStringExtra("option");
            //Toast.makeText(this, option, Toast.LENGTH_SHORT).show();

            String symbologyContent = "";
            String ejemplo = "";
            switch (option){
                case "Trapecial":
                    symbologyContent = this.getTrapecialContent();
                    ejemplo = this.getExampleTrapezoidal();
                    break;
                case "Rectangular":
                    symbologyContent = this.getRectangularContent();
                    ejemplo = this.getExampleRectangular();
                    break;
                case "Portal":
                    symbologyContent = this.getPortalContent();
                    ejemplo = this.getExamplePortal();
                    break;
                case "Circular":
                    symbologyContent = this.getCircularContent();
                    ejemplo = this.getExampleCircular();
                    break;
                case "Presión":
                    symbologyContent = this.getPresionContent();

                    break;
            }

            mTextView.setText(symbologyContent);

            if(!ejemplo.equals("")){
                mTextEjemplo.setText(ejemplo);
            } else {
                titUso.setText("");
                mTextEjemplo.setText("");
            }


        }


    }

    private String getPresionContent(){
        StringBuffer sb = new StringBuffer();
        sb.append(getResources().getString(R.string.symbol_RD) + "\n");
        sb.append(getResources().getString(R.string.symbol_DN) + "\n");
        sb.append(getResources().getString(R.string.symbol_Dint) + "\n");
        sb.append(getResources().getString(R.string.symbol_Q) + "\n");
        sb.append(getResources().getString(R.string.symbol_Vel) + "\n");
        sb.append(getResources().getString(R.string.symbol_Hl) + "\n");
        sb.append(getResources().getString(R.string.symbol_ls) + "\n");
        sb.append(getResources().getString(R.string.symbol_ms) + "\n");
        sb.append(getResources().getString(R.string.symbol_PPR) + "\n");
        sb.append(getResources().getString(R.string.symbol_in) + "\n");

        return sb.toString();
    }


    private String getCircularContent(){
        StringBuffer sb = new StringBuffer();
        sb.append(getResources().getString(R.string.symbol_DN) + "\n");
        sb.append(getResources().getString(R.string.symbol_Dint) + "\n");
        sb.append(getResources().getString(R.string.symbol_Q) + "\n");
        sb.append(getResources().getString(R.string.symbol_Vel) + "\n");
        return sb.toString();
    }


    private String getPortalContent(){
        StringBuffer sb = new StringBuffer();

        sb.append(getResources().getString(R.string.symbol_PORTAL_R) + "\n");
        sb.append(getResources().getString(R.string.symbol_PORTAL_H) + "\n");
        sb.append(getResources().getString(R.string.symbol_PORTAL_H1) + "\n");
        sb.append(getResources().getString(R.string.symbol_PORTAL_H2) + "\n");
        sb.append(getResources().getString(R.string.symbol_PORTAL_n1) + "\n");
        sb.append(getResources().getString(R.string.symbol_PORTAL_n2) + "\n");
        sb.append(getResources().getString(R.string.symbol_PORTAL_nteto) + "\n");
        sb.append(getResources().getString(R.string.symbol_PORTAL_nb) + "\n");


        return sb.toString();
    }


    private String getRectangularContent(){
        StringBuffer sb = new StringBuffer();
        /*
            <string name="symbol_Rect_B" >B - Bottom width</string>
    <string name="symbol_Rect_H" >H - Height</string>

         */
        sb.append(getResources().getString(R.string.symbol_Rect_B) + "\n");
        sb.append(getResources().getString(R.string.symbol_Rect_H) + "\n");
        sb.append(getResources().getString(R.string.symbol_Q) + "\n");
        sb.append(getResources().getString(R.string.symbol_Vel) + "\n");
        sb.append(getResources().getString(R.string.symbol_ls) + "\n");


        return sb.toString();
    }


    private String getTrapecialContent(){
        StringBuffer sb = new StringBuffer();
        /*
        <string name="symbol_Trap_B" >k:1 - Pendente, horizontal:vertical</string>
<string name="symbol_Trap_Base" >Bottom - Bottom width</string>
         */
        sb.append(getResources().getString(R.string.symbol_Trap_k) + "\n");
        sb.append(getResources().getString(R.string.symbol_Trap_Base) + "\n");
        sb.append(getResources().getString(R.string.symbol_Q) + "\n");
        sb.append(getResources().getString(R.string.symbol_Vel) + "\n");
        sb.append(getResources().getString(R.string.symbol_ls) + "\n");
        return sb.toString();
    }

    private String getExampleCircular(){
        StringBuffer sb = new StringBuffer();
        sb.append(getResources().getString(R.string.uso_circular1));
        return sb.toString();
    }

    private String getExampleRectangular(){
        StringBuffer sb = new StringBuffer();
        sb.append(getResources().getString(R.string.uso_rectangular));
        return sb.toString();
    }

    private String getExampleTrapezoidal(){
        StringBuffer sb = new StringBuffer();
        sb.append(getResources().getString(R.string.uso_trapecial));
        return sb.toString();
    }

    private String getExamplePortal(){
        StringBuffer sb = new StringBuffer();
        sb.append(getResources().getString(R.string.uso_tunnel));
        return sb.toString();
    }


}