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
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.perval.levi.sections.CanalRectangular;
import com.perval.levi.R;

import java.util.ArrayList;

import io.github.kexanie.library.MathView;

public class FragCanalRectangular extends Fragment {
    private Spinner spin_tipo, spin_dimensiones, spin_unit_rect;
    ArrayAdapter<CharSequence> adapter_tipo, adapter_units;



    LinearLayout Layout_Dim;
    ArrayAdapter<String> AdapterDimensiones;
    TextView TXtipo, TXDim, TXResults_rect;

    TextView TXFondo, TXAltura, TXSlope;

    EditText ETFondo, ETAltura;

    Button BtnRect;

    CanalRectangular CanalRect;

    ArrayList<String> cadena = new ArrayList<>();
    String lista1[][];

    private static final double Rugosidad= 0.013;

    EditText ETNumberRect, ETSlope;
    Button Calc_rect;
    String StrUni_rect;
    double Hrect, Brect;

    //DiamPos se corresponde a la posición del diámetro seleccionado para hacer los cálculos.
    //IntUnidades se corrsponde a las unidades del valor base para realizar los cálculos, l/s, m/s, m/km
    int IntUnidades, PosSection;


    double flow, velocity, headloss;
    //TextView TXRD = (TextView) findViewById(R.id.TVRD);

    MathView MVResultados;
    WebView WVResults;


    //Material
    //0 - Cajón prefabricado
    //1 - Sección personalizada

    String tipo;

    public FragCanalRectangular(){


    }

    public FragCanalRectangular(Resources resources) {
    }

    @Override
    public void onCreate(Bundle savedInstaceState){
        super.onCreate(savedInstaceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View v = inflater.inflate(R.layout.fragment_canal_rectangular,container, false);
        CanalRect = new CanalRectangular(getActivity().getResources());
        if(getActivity().getResources()==null){
            Log.i("LogTest", "resources is null");
        }
        spin_tipo = v.findViewById(R.id.spin_tipo_rect);

        spin_dimensiones = v.findViewById(R.id.spin_dimensiones);

        spin_unit_rect = v.findViewById(R.id.SpinUnits_rect);

        Calc_rect = v.findViewById(R.id.BtnCalc_rect);
        Layout_Dim = v.findViewById(R.id.LLDimensiones);

        TXFondo = v.findViewById(R.id.TV_Bottom);
        TXAltura = v.findViewById(R.id.TV_Height);
        TXResults_rect = v.findViewById(R.id.TVResults_rect);
        TXSlope = v.findViewById(R.id.TVPendiente_rect);
        TXDim = v.findViewById(R.id.TVDimension);

        ETNumberRect = v.findViewById(R.id.ET_Number_rect);
        ETFondo = v.findViewById(R.id.ET_Bottom);
        ETAltura = v.findViewById(R.id.ET_Height);
        ETSlope = v.findViewById(R.id.ET_Pendiente_rect);

        TXFondo.setVisibility(View.GONE);
        TXAltura.setVisibility(View.GONE);
        ETAltura.setVisibility(View.GONE);
        ETFondo.setVisibility(View.GONE);

        BtnRect = v.findViewById(R.id.BtnCalc_rect);

        adapter_tipo = ArrayAdapter.createFromResource(getContext(),R.array.canal_rect, android.R.layout.simple_spinner_item);
        adapter_tipo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_tipo.setAdapter(adapter_tipo);

        spin_tipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                TXResults_rect.setText("");
                ETSlope.setText("");
                ETNumberRect.setText("");

                switch (i) {

                    case 0:
                        tipo = "cajon";
                        TXDim.setVisibility(View.VISIBLE);
                        spin_dimensiones.setVisibility(View.VISIBLE);
                        Layout_Dim.setVisibility(View.VISIBLE);
                        TXAltura.setVisibility(View.GONE);
                        TXFondo.setVisibility(View.GONE);
                        ETFondo.setVisibility(View.GONE);
                        ETAltura.setVisibility(View.GONE);
                        lista1 = CanalRect.getCajon();

                        //String cadena = lista1.length];

                        int n = lista1.length;

                        cadena.clear();

                        for (int k1 = 0; k1 < n; k1++) {

                            String diam = lista1[k1][0] + "mmX" + lista1[k1][1] + "mm";
                            cadena.add(diam);
                        }

                        AdapterDimensiones = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1,cadena);
                        AdapterDimensiones.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spin_dimensiones.setAdapter(AdapterDimensiones);

                        spin_dimensiones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {



                                PosSection = spin_dimensiones.getSelectedItemPosition();
                                Hrect = Double.parseDouble(lista1[PosSection][1]);
                                Brect = Double.parseDouble(lista1[PosSection][0]);
                                TXResults_rect.setText("");
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });

                        adapter_units = ArrayAdapter.createFromResource(getContext(),R.array.unidades_san, android.R.layout.simple_spinner_item);
                        adapter_units.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spin_unit_rect.setAdapter(adapter_units);

                        spin_unit_rect.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                StrUni_rect = spin_unit_rect.getSelectedItem().toString();
                                IntUnidades = spin_unit_rect.getSelectedItemPosition();
                                TXResults_rect.setText("");
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });


                        break;

                    case 1:
                        tipo = "personalizado";
                        TXDim.setVisibility(View.GONE);
                        spin_dimensiones.setVisibility(View.GONE);
                        Layout_Dim.setVisibility(View.GONE);
                        TXAltura.setVisibility(View.VISIBLE);
                        TXFondo.setVisibility(View.VISIBLE);
                        ETFondo.setVisibility(View.VISIBLE);
                        ETAltura.setVisibility(View.VISIBLE);

                        adapter_units = ArrayAdapter.createFromResource(getContext(),R.array.unidades_san,android.R.layout.simple_spinner_item);
                        adapter_units.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spin_unit_rect.setAdapter(adapter_units);

                        spin_unit_rect.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                StrUni_rect = spin_unit_rect.getSelectedItem().toString();
                                IntUnidades = spin_unit_rect.getSelectedItemPosition();
                                TXResults_rect.setText("");
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });

                        break;

                    default:
                        break;

                    }

                }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        BtnRect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (tipo.equals("cajon")) {


                    if (ETSlope.getText().toString().isEmpty() || (Double.parseDouble(ETSlope.getText().toString()) < 0)) {

                        Toast.makeText(getContext(), getResources().getString(R.string.Toast_add_slope), Toast.LENGTH_SHORT).show();

                    } else {


                        if (ETNumberRect.getText().toString().isEmpty() || (Double.parseDouble(ETNumberRect.getText().toString()) < 0)) {
                            Toast.makeText(getContext(), getResources().getString(R.string.Toast_add_variable), Toast.LENGTH_SHORT).show();


                        } else {

                            switch (IntUnidades) {

                                case 0:
                                   // Toast.makeText(getContext(), "Cálculo con el gasto", Toast.LENGTH_SHORT).show();



                                    CanalRect.setGastoLPS(Double.parseDouble(ETNumberRect.getText().toString()));
                                    CanalRect.setBrectAsMeter(Brect / 1000);
                                    CanalRect.setHrecAsMeter(Hrect / 1000);
                                    CanalRect.setslope(Double.parseDouble(ETSlope.getText().toString()));


                                    CanalRect.setRugRect(Rugosidad);
                                    CanalRect.calcfromQ();


                                    if (CanalRect.isSuccess()) {
                                        setResultsToTextView();

                                    } else {
                                        //FALSE
                                        Toast.makeText(getContext(), R.string.Calculo_fallido, Toast.LENGTH_SHORT).show();

                                        TXResults_rect.setText(R.string.Calculo_fallido);
                                    }

                                    break;
                                case 1:
                                    //Toast.makeText(getContext(), "Cálculo con la velocidad", Toast.LENGTH_SHORT).show();



                                    CanalRect.setVrect(Double.parseDouble(ETNumberRect.getText().toString()));
                                    CanalRect.setBrectAsMeter(Brect / 1000);
                                    CanalRect.setHrecAsMeter(Hrect / 1000);
                                    CanalRect.setslope(Double.parseDouble(ETSlope.getText().toString()));


                                    CanalRect.setRugRect(Rugosidad);
                                    CanalRect.calcfromV();

                                    if (CanalRect.isSuccess()) {
                                        setResultsToTextView();

                                    } else {
                                        //FALSE
                                        Toast.makeText(getContext(), R.string.Calculo_fallidoV, Toast.LENGTH_SHORT).show();

                                        TXResults_rect.setText(R.string.Calculo_fallidoV);
                                    }

                                    break;

                                case 2:
                                    //Toast.makeText(getContext(), "Cálculo con el tirante", Toast.LENGTH_SHORT).show();


                                    CanalRect.setTirante(Double.parseDouble(ETNumberRect.getText().toString()));
                                    CanalRect.setBrectAsMeter(Brect / 1000);
                                    CanalRect.setHrecAsMeter(Hrect / 1000);
                                    CanalRect.setslope(Double.parseDouble(ETSlope.getText().toString()));
                                    CanalRect.setRugRect(Rugosidad);
                                    CanalRect.calcfromH();


                                    if (CanalRect.isSuccess()) {
                                        setResultsToTextView();

                                    } else {
                                        //FALSE
                                        Toast.makeText(getContext(), R.string.Calculo_fallidoH, Toast.LENGTH_SHORT).show();

                                        TXResults_rect.setText(R.string.Calculo_fallidoH);
                                    }


                                    break;
                                default:
                                    break;
                            }

                        }
                    }

                } else {
                    if (ETFondo.getText().toString().isEmpty() || (Double.parseDouble(ETFondo.getText().toString()) < 0) || ETAltura.getText().toString().isEmpty() || (Double.parseDouble(ETAltura.getText().toString()) < 0) || ETSlope.getText().toString().isEmpty() || (Double.parseDouble(ETSlope.getText().toString()) < 0)) {

                        Toast.makeText(getContext(), getResources().getString(R.string.Toast_add_values), Toast.LENGTH_SHORT).show();

                    } else {


                        if (ETNumberRect.getText().toString().isEmpty() || (Double.parseDouble(ETNumberRect.getText().toString()) < 0)) {
                            Toast.makeText(getContext(), getResources().getString(R.string.Toast_add_variable), Toast.LENGTH_SHORT).show();


                        } else {


                            CanalRect.setBrectAsMeter(Double.parseDouble(ETFondo.getText().toString()));
                            CanalRect.setHrecAsMeter(Double.parseDouble(ETAltura.getText().toString()));
                            double valorX = (Double.parseDouble(ETNumberRect.getText().toString()));
                            CanalRect.setslope(Double.parseDouble(ETSlope.getText().toString()));
                            CanalRect.setRugRect(Rugosidad);

                            switch (IntUnidades) {
                                case 0:
                                    //Toast.makeText(getContext(), "Cálculo con el gasto", Toast.LENGTH_SHORT).show();
                                    CanalRect.setGastoLPS(valorX);
                                    CanalRect.calcfromQ();
                                    if (CanalRect.isSuccess()) {
                                        setResultsToTextView();

                                    } else {
                                        //FALSE
                                        Toast.makeText(getContext(), R.string.Calculo_fallido, Toast.LENGTH_SHORT).show();

                                        TXResults_rect.setText(R.string.Calculo_fallido);
                                    }
                                    break;
                                case 1:
                                    CanalRect.setVrect(valorX);
                                    CanalRect.calcfromV();
                                    if (CanalRect.isSuccess()) {
                                        setResultsToTextView();
                                    } else {
                                        //FALSE
                                        Toast.makeText(getContext(), R.string.Calculo_fallidoV, Toast.LENGTH_SHORT).show();

                                        TXResults_rect.setText(R.string.Calculo_fallidoV);
                                    }
                                    break;
                                case 2:
                                    if(valorX>Hrect){
                                        Toast.makeText(getContext(), R.string.Calculo_fallidoH, Toast.LENGTH_SHORT).show();
                                    } else {
                                        CanalRect.setTirante(valorX);
                                        CanalRect.calcfromH();
                                        if (CanalRect.isSuccess()) {
                                            setResultsToTextView();
                                        } else {
                                            //FALSE
                                            Toast.makeText(getContext(), R.string.Calculo_fallidoH, Toast.LENGTH_SHORT).show();
                                            TXResults_rect.setText(R.string.Calculo_fallidoH);
                                        }
                                    }

                                    break;
                                default:
                                    break;
                            }

                        }

                    }
                }

            }
        });

        return v;

    }

    private void setResultsToTextView(){
        String Resultados;
        TXResults_rect.setText("");
        String StrGasto, StrVel, Strh, StrRug, StrBLibre, StrArea, StrFroude, StrFlujo;

        StrGasto = getResources().getString(R.string.res_flow) + " " + String.format("%.2f", CanalRect.getgasto() * 1000) + " \n";
        StrVel = getResources().getString(R.string.res_vel) + " " + String.format("%.2f", CanalRect.getVrect()) + " \n";
        Strh = getResources().getString(R.string.res_tirante)+ " " + String.format("%.3f", CanalRect.getTirante()) + " \n";
        StrRug = getResources().getString(R.string.Text_MannRug) + " " + String.format("%.3f", CanalRect.getRugRect()) + " \n";

        StrArea = getResources().getString(R.string.res_area) + String.format("%.3f", CanalRect.getArea()) + " \n";
        StrFroude = "Froude: " + String.format("%.3f", CanalRect.getFroude()) + " \n";
        StrFlujo = getResources().getString(R.string.Text_Regimen) +" " + CanalRect.getTipoFlujo() + " \n";
        Resultados = StrGasto + StrVel + StrArea + Strh + StrRug  + StrFroude + StrFlujo;
        TXResults_rect.setText(Resultados);
    }


    }

