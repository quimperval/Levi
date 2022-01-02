package com.perval.levi.ayuda;



import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.perval.levi.NManning;
import com.perval.levi.R;

import org.w3c.dom.Text;

import java.net.URL;
import java.util.Arrays;

public class Help extends AppCompatActivity {

    private TextView Formula_3;
    private String texto1;

    private Button botonmanning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_Help);
        setSupportActionBar(toolbar);

        botonmanning = (Button) findViewById(R.id.Btn_select_manning);
        Formula_3 = findViewById(R.id.TV_Hid_ContD);
        texto1 = "&#x3BD; -"+ getString(R.string.Cont_presion4);
        Formula_3.setText(Html.fromHtml(texto1));

        botonmanning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupWindow(view);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        Formula_3 = findViewById(R.id.TV_Hid_ContD);
        texto1 = "&#x3BD; -"+ getString(R.string.Cont_presion4);
        Formula_3.setText(Html.fromHtml(texto1));

    }


    public void GoToPVCMetric (View view){
        goToUrl(getResources().getString(R.string.LinkPVCMetric));
    }

    public void GoToPVCInglesa (View view){
        goToUrl(getResources().getString(R.string.LinkPVCIng));
    }

    public void GoToPEADHid (View view){
        goToUrl(getResources().getString(R.string.LinkPEAD));
    }

    public void GoToPPR (View view){
        goToUrl(getResources().getString(R.string.LinkPPR));
    }

    public void GoToPAcero (View view){
        goToUrl(getResources().getString(R.string.LinkAcero));
    }

    public void GoToPVCSan (View view){
        goToUrl(getResources().getString(R.string.LinkPVCSan));
    }

    public void GoToPEADSan (View view){
        goToUrl(getResources().getString(R.string.LinkPEADSan));
    }

    public void GoToConcSimple (View view){
        goToUrl(getResources().getString(R.string.LinkConcSimple));
    }



    public void GoToCajon (View view){
        goToUrl(getResources().getString(R.string.LinkCajon));
    }

    public void GoToUltraFlo(View view ){goToUrl(getResources().getString(R.string.LinkUltraFlo));}


    public void showPopupWindow(View anchorView){

        LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);

        View popupView = inflater.inflate(R.layout.table_manning, null);





        PopupWindow popupWindow = new PopupWindow(popupView,
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        //popupWindow.showAtLocation(anchorView,Gravity.CENTER, 0,0 );

        TableLayout stk = popupWindow.getContentView().findViewById(R.id.TLayout_Manning);

        stk.setGravity(Gravity.CENTER_HORIZONTAL);

        TableRow tbrow0 = new TableRow(this);

        TextView tv0 = new TextView(this);
        tv0.setText(" ID ");
        tv0.setBackgroundColor(getResources().getColor(R.color.Fondo_gris));
        tv0.setTextColor(getResources().getColor(R.color.azul_perval));

        tv0.setGravity(Gravity.LEFT);

        tbrow0.addView(tv0);

        TextView tv1 = new TextView(this);
        tv1.setText(" Desc ");
        tv1.setBackgroundColor(getResources().getColor(R.color.Fondo_gris));
        tv1.setTextColor(getResources().getColor(R.color.azul_perval));
        tv1.setGravity(Gravity.CENTER);
        tbrow0.addView(tv1);


        TextView tv2 = new TextView(this);
        tv2.setText(" n mín ");
        tv2.setBackgroundColor(getResources().getColor(R.color.Fondo_gris));
        tv2.setTextColor(getResources().getColor(R.color.azul_perval));
        tv2.setGravity(Gravity.CENTER);
        tbrow0.addView(tv2);

        TextView tv3 = new TextView(this);
        tv3.setText(" n med ");
        tv3.setBackgroundColor(getResources().getColor(R.color.Fondo_gris));
        tv3.setTextColor(getResources().getColor(R.color.azul_perval));
        tv3.setGravity(Gravity.CENTER);
        tbrow0.addView(tv3);

        TextView tv4 = new TextView(this);
        tv4.setText(" n máx ");
        tv4.setBackgroundColor(getResources().getColor(R.color.Fondo_gris));
        tv4.setTextColor(getResources().getColor(R.color.azul_perval));
        tv4.setGravity(Gravity.LEFT);

        tbrow0.addView(tv4);

        stk.addView(tbrow0);

        NManning man = new NManning(getApplication().getResources());
        String[][] listadox = man.getListado();

        int rows = listadox.length;
        int cols = listadox[0].length;
        int i=0;
        try{
            for (i = 0; i < rows; i++) {

                if (listadox[i][2].equals("")) {
                    TableRow tbrow = new TableRow(this);

                    TextView tvc1 = new TextView(this);
                    tvc1.setText(listadox[i][0]);
                    tvc1.setTextColor(getResources().getColor(R.color.azul_perval));
                    tvc1.setBackgroundColor(getResources().getColor(R.color.Gris_2));
                    tvc1.setGravity(Gravity.CENTER);
                    tbrow.addView(tvc1);

                    TextView tvc2 = new TextView(this);

                    tvc2.setText(listadox[i][1]);
                    tvc2.setTextColor(getResources().getColor(R.color.azul_perval));
                    tvc2.setGravity(Gravity.LEFT);
                    tvc2.setWidth(260);
                    tvc2.setBackgroundColor(getResources().getColor(R.color.Gris_2));

                    tbrow.addView(tvc2);

                    stk.addView(tbrow);


                } else {


                    TableRow tbrow = new TableRow(this);

                    TextView tvc1 = new TextView(this);
                    tvc1.setText(listadox[i][0]);
                    tvc1.setTextColor(getResources().getColor(R.color.azul_perval));
                    tvc1.setGravity(Gravity.CENTER);
                    tbrow.addView(tvc1);

                    TextView tvc2 = new TextView(this);

                    tvc2.setText(listadox[i][1]);
                    tvc2.setTextColor(getResources().getColor(R.color.azul_perval));
                    tvc2.setGravity(Gravity.LEFT);
                    tvc2.setWidth(260);
                    tbrow.addView(tvc2);

                    TextView tvc3 = new TextView(this);

                    tvc3.setText(listadox[i][2]);
                    tvc3.setTextColor(getResources().getColor(R.color.azul_perval));
                    tvc3.setGravity(Gravity.CENTER);
                    tbrow.addView(tvc3);

                    TextView tvc4 = new TextView(this);

                    tvc4.setText(listadox[i][3]);
                    tvc4.setTextColor(getResources().getColor(R.color.azul_perval));
                    tvc4.setGravity(Gravity.CENTER);
                    tbrow.addView(tvc4);

                    TextView tvc5 = new TextView(this);

                    tvc5.setText(listadox[i][4]);


                    tvc5.setTextColor(getResources().getColor(R.color.azul_perval));
                    tvc5.setGravity(Gravity.CENTER);
                    tbrow.addView(tvc5);

                    stk.addView(tbrow);


                }


            }
        }catch (ArrayIndexOutOfBoundsException ex){
            Log.i("nManning", "listado[i].length:" + listadox[i].length);
            Log.i("nManning", Arrays.toString(listadox[i]));
            ex.printStackTrace();
            return;
        }





        // If the PopupWindow should be focusable
        popupWindow.setFocusable(true);

        // If you need the PopupWindow to dismiss when when touched outside
        popupWindow.setBackgroundDrawable(new ColorDrawable());

        int location[] = new int[2];

        // Get the View's(the one that was clicked in the Fragment) location
        anchorView.getLocationOnScreen(location);

        // Using location, the PopupWindow will be displayed right under anchorView
        popupWindow.showAtLocation(anchorView, Gravity.CENTER,
                0, 0);
    }



    public boolean findChar(String palabra, char caracter){
        boolean valor= false;
        if (palabra.length()==0){
            valor = false;
        } else {
            for(int j=0; j< palabra.length(); j++){
                char dummy = palabra.charAt(j);
                if(dummy==caracter){
                    valor = true ;
                    break;
                } else {
                    valor = false;
                }

            }
        }

        return valor;
    }


    private void goToUrl (String url){
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }



    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.top_in, R.anim.top_out);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
