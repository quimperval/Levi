package com.perval.levi.fragments;


import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.perval.levi.sections.CanalTrapecial;
import com.perval.levi.R;

import java.util.ArrayList;

import io.github.kexanie.library.MathView;

public class FragCanalTrapecial extends Fragment {
    private Spinner spin_unit_trap;
    ArrayAdapter<CharSequence> adapter_units_trap;


    private RelativeLayout mRelativeLayout;

    TextView TXtipo, TXDim, TXResults_trap;

    TextView TXFondo, TXAltura, TXSlope;

    EditText ETFondo, ETAltura;




    CanalTrapecial CanalTrap;

    ArrayList<String> cadena = new ArrayList<>();

    EditText ETNumberTrap, ETSlopeTrap, ETRugder, ETRugizq, ETRugFondo;
    EditText ETTaludDer, ETTaludIzq;
    Button Calc_trap;
    String StrUni_rect;
    double Hrect, Brect;

    //DiamPos se corresponde a la posición del diámetro seleccionado para hacer los cálculos.
    //IntUnidades se corrsponde a las unidades del valor base para realizar los cálculos, l/s, m/s, m/km
    int IntUnidades, PosSection;


    double flow, velocity, headloss;
    //TextView TXRD = (TextView) findViewById(R.id.TVRD);

    MathView MVResultados;
    WebView WVResults;


    public FragCanalTrapecial(){


    }

    public FragCanalTrapecial(Resources resources) {
    }

    @Override
    public void onCreate(Bundle savedInstaceState){
        super.onCreate(savedInstaceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View v = inflater.inflate(R.layout.fragment_canal_trapecial,container, false);;
        CanalTrap = new CanalTrapecial(getActivity().getResources());
        if(getActivity().getResources()==null){
            Log.i("LogTest", "resources is null");
        }
        spin_unit_trap = v.findViewById(R.id.SpinUnitsTrap);

        ETAltura = v.findViewById(R.id.ET_H_Trap);
        ETFondo = v.findViewById(R.id.ET_B_Trap);

        ETRugizq = v.findViewById(R.id.ET_Rug_izqTrap);
        ETRugder = v.findViewById(R.id.ET_Rug_derTrap);
        ETRugFondo = v.findViewById(R.id.ET_Rug_fondoTrap);
        ETTaludDer = v.findViewById(R.id.ET_Talud_der);
        ETTaludIzq = v.findViewById(R.id.ET_Talud_izq);

        ETSlopeTrap = v.findViewById(R.id.ET_Pendiente_Trap);
        ETNumberTrap = v.findViewById(R.id.ET_NumberTrap);

        TXResults_trap = v.findViewById(R.id.TVResults_trapecial);
        Calc_trap = v.findViewById(R.id.BtnCalc_trap);


        adapter_units_trap = ArrayAdapter.createFromResource(getContext(), R.array.unidades_san, android.R.layout.simple_spinner_item);
        adapter_units_trap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_unit_trap.setAdapter(adapter_units_trap);

        spin_unit_trap.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                StrUni_rect = spin_unit_trap.getSelectedItem().toString();
                IntUnidades = spin_unit_trap.getSelectedItemPosition();
                TXResults_trap.setText("");
                ETNumberTrap.setText("");

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Calc_trap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            if(ETSlopeTrap.getText().toString().isEmpty() || (Double.parseDouble(ETSlopeTrap.getText().toString()) < 0)||
                    ETNumberTrap.getText().toString().isEmpty() || (Double.parseDouble(ETNumberTrap.getText().toString()) < 0)||
                    ETAltura.getText().toString().isEmpty() || (Double.parseDouble(ETAltura.getText().toString()) < 0)||
                    ETFondo.getText().toString().isEmpty() || (Double.parseDouble(ETFondo.getText().toString()) < 0)||
                    ETRugder.getText().toString().isEmpty() || (Double.parseDouble(ETRugder.getText().toString()) < 0)||
                    ETRugizq.getText().toString().isEmpty() || (Double.parseDouble(ETRugizq.getText().toString()) < 0)||
                    ETRugFondo.getText().toString().isEmpty() || (Double.parseDouble(ETRugFondo.getText().toString()) < 0)||
                    ETTaludDer.getText().toString().isEmpty() || (Double.parseDouble(ETTaludDer.getText().toString()) < 0)||
                    ETTaludIzq.getText().toString().isEmpty() || (Double.parseDouble(ETTaludIzq.getText().toString()) < 0)

                    ){
                Toast.makeText(getContext(), getResources().getString(R.string.Toast_add_values), Toast.LENGTH_SHORT).show();

                //Si algo está vacío no se continúa el análisis.
            }   else {

                double ValorX = (Double.parseDouble(ETNumberTrap.getText().toString()));;

                CanalTrap.setslope(Double.parseDouble(ETSlopeTrap.getText().toString()));

                CanalTrap.setBtrap(Double.parseDouble(ETFondo.getText().toString()));
                CanalTrap.setHtrap(Double.parseDouble(ETAltura.getText().toString()));

                CanalTrap.setRugder(Double.parseDouble(ETRugder.getText().toString()));
                CanalTrap.setRugizq(Double.parseDouble(ETRugizq.getText().toString()));
                CanalTrap.setRugfondo(Double.parseDouble(ETRugFondo.getText().toString()));

                CanalTrap.setKder(Double.parseDouble(ETTaludDer.getText().toString()));
                CanalTrap.setKizq(Double.parseDouble(ETTaludIzq.getText().toString()));

                switch (IntUnidades) {

                    case 0:
                        //Calculo con el gasto.

                        CanalTrap.setgasto(ValorX);


                        CanalTrap.calcfromQ();

                        if (CanalTrap.isSuccess()) {
                            setResultsToTextView();

                        } else {
                            //FALSE
                            Toast.makeText(getContext(), R.string.Calculo_fallido, Toast.LENGTH_SHORT).show();

                            TXResults_trap.setText(R.string.Calculo_fallido);
                        }

                        break;
                    case 1:
                        //Calculo con la velocidad.



                        CanalTrap.setVrect(ValorX);

                        CanalTrap.calcfromV();

                        if (CanalTrap.isSuccess()) {
                            setResultsToTextView();

                        } else {
                            //FALSE
                            Toast.makeText(getContext(), R.string.Calculo_fallidoV, Toast.LENGTH_SHORT).show();

                            TXResults_trap.setText(R.string.Calculo_fallidoV);
                        }


                        break;
                    case 2:
                        //Calculo con el tirante.

                        if(ValorX>(Double.parseDouble(ETAltura.getText().toString()))){

                            Toast.makeText(getContext(), R.string.Calculo_fallidoH, Toast.LENGTH_SHORT).show();

                        } else {

                            CanalTrap.setTirante(ValorX);

                            CanalTrap.calcfromH();


                            if (CanalTrap.isSuccess()) {
                                setResultsToTextView();

                            } else {
                                //FALSE
                                Toast.makeText(getContext(), R.string.Calculo_fallidoH, Toast.LENGTH_SHORT).show();

                                TXResults_trap.setText(R.string.Calculo_fallidoH);
                            }


                        }

                        break;
                    default:

                        break;

                }
                }


            }
        });



        return v;
    }


    private void setResultsToTextView(){
        String Resultados;
        String StrGasto, StrArea, StrVel, Strh, StrRug, StrBLibre, StrFroude, StrFlujo;
        TXResults_trap.setText("");
        StrGasto = getResources().getString(R.string.res_flow)  +" "+ String.format("%.2f", CanalTrap.getgasto() * 1000) + " \n";
        StrArea = getResources().getString(R.string.res_area) +" " + String.format("%.3f", CanalTrap.getAtotal()) + " \n";

        StrVel = getResources().getString(R.string.res_vel)  +" "+ String.format("%.2f", CanalTrap.getVrect()) + " \n";
        Strh = getResources().getString(R.string.res_tirante) +" " + String.format("%.3f", CanalTrap.getTirante()) + " \n";
        StrRug = getResources().getString(R.string.Text_MannRug) +" " + String.format("%.3f", CanalTrap.getRugpond()) + " \n";
        StrBLibre = getResources().getString(R.string.Text_Freeboard) +" "+String.format("%.2f", CanalTrap.getBLibre()) + " \n";
        StrFroude = "Froude: " + String.format("%.2f", CanalTrap.getFroude()) + " \n";
        StrFlujo = getResources().getString(R.string.Text_Regimen) +" " + CanalTrap.getTipoFlujo() + " \n";
        Resultados = StrGasto  +StrVel + StrArea + Strh + StrRug + StrBLibre + StrFroude + StrFlujo;
        TXResults_trap.setText(Resultados);

    }


}
