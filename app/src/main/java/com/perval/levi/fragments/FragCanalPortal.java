package com.perval.levi.fragments;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.ViewCompat;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.core.app.ActivityOptionsCompat;

import com.perval.levi.sections.Portal;
import com.perval.levi.R;
import com.perval.levi.imgPortal;
import com.perval.levi.utils.Utils;


public class FragCanalPortal extends Fragment {



    private Portal secPortal ;

    private EditText ETAlt_portal, ETBottom_portal, ETh1der_portal, ETh2der_portal, ETh1izq_portal, ETh2izq_portal;
    private EditText Slope_portal, ValorX;

    private EditText ETn1der_portal, ETn2der_portal, ETnbottom_portal, ETn1izq_portal, ETn2izq_portal, ETntop_portal;
    private EditText Rugpon;
    private TextView Results_portal;

    private Spinner spin_units_portal;

    private ArrayAdapter<CharSequence> AdapterUnits_portal;

    private int IntUnidades, PosSection;
    private String StrUni_portal;

    private Button boton_portal;





    private ImageView imagenPortal;


    public static final String TAG = FragCanalPortal.class.getSimpleName();

    public FragCanalPortal(){


    }

    public FragCanalPortal(Resources resources) {
    }

    public static FragCanalPortal newInstance(){

        return new FragCanalPortal();
    }

    /**
    @Override
    public void onCreateView(Bundle savedInstaceState){

        super.onCreate(savedInstaceState);
    }
     */


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        imagenPortal = (ImageView) view.findViewById(R.id.Image_Seccion_portal);

        imagenPortal.setOnClickListener(new gotoimgPortal());

        int[] screenLoc2 = new int[2];

        imagenPortal.getLocationOnScreen(screenLoc2);


    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        secPortal = new Portal(getActivity().getResources());

        View v  =  inflater.inflate(R.layout.fragment_canal_portal,container, false);
        spin_units_portal = v.findViewById(R.id.SpinUnits_portal);


        ETBottom_portal = v.findViewById(R.id.ET_B_Portal);

        ETh1der_portal = v.findViewById(R.id.ET_Portal_der_h1);

        ETh2der_portal = v.findViewById(R.id.ET_Portal_der_h2);

        ETh1izq_portal = v.findViewById(R.id.ET_Portal_izq_h1);

        ETh2izq_portal = v.findViewById(R.id.ET_Portal_izq_h2);

        Slope_portal =  v.findViewById(R.id.ET_Pendiente_Portal);

        ValorX = v.findViewById(R.id.ET_Number_portal);

        ETn1der_portal = v.findViewById(R.id.ET_Rug_der_h1);

        ETn2der_portal = v.findViewById(R.id.ET_Rug_der_h2);

        ETnbottom_portal = v.findViewById(R.id.ET_Rug_fondo_portal);

        ETn1izq_portal = v.findViewById(R.id.ET_Rug_izq_h1);

        ETn2izq_portal = v.findViewById(R.id.ET_Rug_izq_h2);

        ETntop_portal = v.findViewById(R.id.ET_Rug_techo);

        Results_portal = v.findViewById(R.id.TVResults_portal);

        boton_portal = v.findViewById(R.id.Boton_portal);





        AdapterUnits_portal = ArrayAdapter.createFromResource(getContext(),R.array.unidades_san,android.R.layout.simple_spinner_item);
        AdapterUnits_portal.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_units_portal.setAdapter(AdapterUnits_portal);

        spin_units_portal.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                StrUni_portal = spin_units_portal.getSelectedItem().toString();
                IntUnidades = spin_units_portal.getSelectedItemPosition();
                Results_portal.setText("");
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        boton_portal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(
                        ETBottom_portal.getText().toString().isEmpty() || (Double.parseDouble(ETBottom_portal.getText().toString()) < 0)||
                        ETh1der_portal.getText().toString().isEmpty() || (Double.parseDouble(ETh1der_portal.getText().toString()) < 0)||
                        ETh2der_portal.getText().toString().isEmpty() || (Double.parseDouble(ETh2der_portal.getText().toString()) < 0)||
                        ETh1izq_portal.getText().toString().isEmpty() || (Double.parseDouble(ETh1izq_portal.getText().toString()) < 0)||
                        ETh2izq_portal.getText().toString().isEmpty() || (Double.parseDouble(ETh2izq_portal.getText().toString()) < 0)||
                        Slope_portal.getText().toString().isEmpty() || (Double.parseDouble(Slope_portal.getText().toString()) < 0)||
                        ValorX.getText().toString().isEmpty() || (Double.parseDouble(ValorX.getText().toString()) < 0)||
                        ETn1der_portal.getText().toString().isEmpty() || (Double.parseDouble(ETn1der_portal.getText().toString()) < 0)||
                        ETn2der_portal.getText().toString().isEmpty() || (Double.parseDouble(ETn2der_portal.getText().toString()) < 0)||
                        ETn1izq_portal.getText().toString().isEmpty() || (Double.parseDouble(ETn1izq_portal.getText().toString()) < 0)||
                        ETn2izq_portal.getText().toString().isEmpty() || (Double.parseDouble(ETn2izq_portal.getText().toString()) < 0)|| ETnbottom_portal.getText().toString().isEmpty() || (Double.parseDouble(ETnbottom_portal.getText().toString()) < 0)||
                        ETntop_portal.getText().toString().isEmpty() || (Double.parseDouble(ETntop_portal.getText().toString()) < 0)

                        ){
                    Toast.makeText(getContext(), getResources().getString(R.string.Toast_add_values), Toast.LENGTH_SHORT).show();

                    //Si algo está vacío no se continúa el análisis.
                }   else {



                        secPortal.setBottom(Double.parseDouble(ETBottom_portal.getText().toString()));
                        secPortal.seth1der(Double.parseDouble(ETh1der_portal.getText().toString()));
                        secPortal.seth2der(Double.parseDouble(ETh2der_portal.getText().toString()));
                        secPortal.seth1izq(Double.parseDouble(ETh1izq_portal.getText().toString()));
                        secPortal.seth2izq(Double.parseDouble(ETh2izq_portal.getText().toString()));
                        secPortal.setslope(Double.parseDouble(Slope_portal.getText().toString()));

                        double Valor = Double.parseDouble(ValorX.getText().toString());
                        secPortal.setn1der(Double.parseDouble(ETn1der_portal.getText().toString()));
                        secPortal.setn2der(Double.parseDouble(ETn2der_portal.getText().toString()));
                        secPortal.setnfondo(Double.parseDouble(ETnbottom_portal.getText().toString()));
                        secPortal.setn1izq(Double.parseDouble(ETn1izq_portal.getText().toString()));
                        secPortal.setn2izq(Double.parseDouble(ETn2izq_portal.getText().toString()));
                        secPortal.setntop(Double.parseDouble(ETntop_portal.getText().toString()));

                        secPortal.setHrect();

                        secPortal.setHT(secPortal.getHrect()+secPortal.getBottom()*0.5);



                        if((secPortal.geth1der()+secPortal.geth2der())!=(secPortal.geth1izq()+secPortal.geth2izq())){
                            Toast.makeText(getContext(), R.string.Warning_hdif, Toast.LENGTH_SHORT).show();

                        } else {
                            switch (IntUnidades){
                                case 0:
                                    secPortal.setGastoAsLPS(Valor);
                                    secPortal.calcFromQLimitSearch(Valor/1000);
                                    if(secPortal.isSuccess()){

                                        setResultsToTextView();


                                    } else {
                                        //Toast.makeText(getContext(), R.string.Calculo_fallidoV, Toast.LENGTH_SHORT).show();
                                        Results_portal.setText("");
                                        Results_portal.setText(R.string.Calculo_fallidoV);

                                    }

                                    break;

                                case 1:

                                    secPortal.setvel(Valor);
                                    secPortal.calcfromV(Valor);
                                    if(secPortal.isSuccess()) {
                                        //Si hubo éxito.

                                        setResultsToTextView();
                                    } else {
                                        //NADA
                                        //Toast.makeText(getContext(), R.string.Calculo_fallidoV, Toast.LENGTH_SHORT).show();
                                        Results_portal.setText("");
                                        Results_portal.setText(R.string.Calculo_fallidoV);
                                    }

                                    break;
                                case 2:

                                    if(Valor > secPortal.getHT()){

                                        Toast.makeText(getContext(),getResources().getString(R.string.Toast_h_mayoraHT),Toast.LENGTH_SHORT).show();

                                    } else {



                                        secPortal.setTirante(Valor);

                                        secPortal.calcfromH(Valor);
                                        if(secPortal.isSuccess()) {
                                            //Si hubo éxito.

                                            setResultsToTextView();
                                        } else {
                                            //NADA
                                            //Toast.makeText(getContext(), R.string.Calculo_fallidoH, Toast.LENGTH_SHORT).show();
                                            Results_portal.setText("");
                                            Results_portal.setText(R.string.Calculo_fallidoV);
                                        }
                                    }
                                    break;

                                default:
                                    break;
                            }

                        }

                }

            }
        });




        return v;
    }

    private void setResultsToTextView(){
        String Resultados;
        String StrGasto, StrVel, StrArea, Strh, StrRug, StrFroude, StrFlujo;

        Results_portal.setText("");
        StrGasto = getResources().getString(R.string.res_flow) + " " + String.format("%.2f", secPortal.getGasto() * 1000) + " \n";
        StrVel = getResources().getString(R.string.res_vel)+ " " + String.format("%.2f", secPortal.getVel()) + " \n";
        StrArea = getResources().getString(R.string.res_area) + " " + String.format("%.3f", secPortal.getArea()) + "\n";
        Strh = getResources().getString(R.string.res_tirante)  +" " + String.format("%.3f", secPortal.getTirante()) + " \n";
        StrRug = getResources().getString(R.string.res_manning) + " " + String.format("%.4f", secPortal.getRougpond()) + " \n";
        StrFroude = "Froude: " +  String.format("%.3f", secPortal.getFroude()) + " \n";
        StrFlujo = getResources().getString(R.string.res_tipo_flujo)+ " " + secPortal.getTipoFlujo() + " \n";

        Resultados = StrGasto + StrVel + StrArea + Strh + StrRug + StrFroude + StrFlujo;
        Results_portal.setText(Resultados);
    }


    class gotoimgPortal implements  View.OnClickListener{
        @Override
        public void onClick(View v){


            int mHeight, mWidth;
            mHeight = imagenPortal.getHeight();
            mWidth = imagenPortal.getWidth();

            int[] screenLoc = new int[2];

            imagenPortal.getLocationOnScreen(screenLoc);

            Rect myRect = new Rect();

            imagenPortal.getGlobalVisibleRect(myRect);

            //Toast.makeText(getContext(), "RectTop: " + myRect.top + " RectLeft: "+ myRect.left , Toast.LENGTH_SHORT).show();


            Intent mIntent = new Intent(getContext(), imgPortal.class);
            ActivityOptionsCompat options  = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    (Activity) getContext(), imagenPortal, ViewCompat.getTransitionName(imagenPortal));

            mIntent.putExtra(Utils.PACK + Utils.mLeft, screenLoc[0]);
            mIntent.putExtra(Utils.PACK+Utils.mTop, screenLoc[1]);
            mIntent.putExtra(Utils.PACK+Utils.mHeight, mHeight);
            mIntent.putExtra(Utils.PACK+Utils.mWidth, mWidth);




           // Toast.makeText(getContext(), "mTop: " + screenLoc[1] + " mLeft: "+ screenLoc[0] + " mWidth: "+ mWidth + " mHeight: "+mHeight, Toast.LENGTH_SHORT).show();

            startActivity(mIntent);

            getActivity().overridePendingTransition(0,0);

        }


    }



}
