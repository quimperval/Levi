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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.perval.levi.tuberias.PipeProvider;
import com.perval.levi.R;
import com.perval.levi.tuberias.TuberiaSanitaria;

import java.util.ArrayList;

import io.github.kexanie.library.MathView;

public class FragCanalCircular extends Fragment {
    private Spinner spin_mat_san, spin_diam_san, spin_unidades_san;
    ArrayAdapter<CharSequence> adapter_mat_san;

    ArrayAdapter<CharSequence> adapterUnits_san;
    ArrayAdapter<String> AdapterDiam_san;
    TextView TXDiam_san, TXResults_san;
    Button BtnCirc;

    TuberiaSanitaria TubSan;

    ArrayList<String> cadena = new ArrayList<>();
    String lista1[][];

    private double Rugosidad;
    private EditText ETNumber, ETSlope;
    private Button Calcular;
    private String StrUnidades;
    private double DSan_mm;

    //DiamPos se corresponde a la posición del diámetro seleccionado para hacer los cálculos.
    //IntUnidades se corrsponde a las unidades del valor base para realizar los cálculos, l/s, m/s, m/km
    private int IntUnidades, DiamPos;


    double flow, velocity, headloss;
    //TextView TXRD = (TextView) findViewById(R.id.TVRD);

    MathView MVResultados;
    WebView WVResults;


    //Material
    //0 - PVC Sanitario
    //1 - Concreto simple
    //2 - Concreto reforzado
    //3 - PEAD sanitario
    //4 - Duro Maxx
    //5 - Ultraflo 12
    //6 - Ultraflo 14
    //7 - Ultraflo 16
    private int Material;

    private Resources resources;
    private PipeProvider providerOfPipeInformation = null;

    public FragCanalCircular(){

        providerOfPipeInformation = new PipeProvider();

    }

    @Override
    public void onCreate(Bundle savedInstaceState){
        super.onCreate(savedInstaceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){


        View v = inflater.inflate(R.layout.fragment_canal_circular,container,false);
        TubSan = new TuberiaSanitaria(getActivity().getResources());

        if(getActivity().getResources()==null){
           Log.i("LogTest", "resources is null");
        }


        spin_mat_san = v.findViewById(R.id.spin_materialCirc);

        spin_diam_san = v.findViewById(R.id.spin_Diam_san);

        spin_unidades_san = v.findViewById(R.id.SpinUnits_san);

        BtnCirc = v.findViewById(R.id.Boton_canal_circ);

        spin_diam_san.setVisibility(View.GONE);
        spin_unidades_san.setVisibility(View.GONE);

        ETNumber = v.findViewById(R.id.ET_Number_san);
        ETSlope = v.findViewById(R.id.ET_Pendiente_Circ);

        TXDiam_san = v.findViewById(R.id.TVDiam_san);
        TXResults_san = v.findViewById(R.id.TVResults_circular);
        TXResults_san.setTextIsSelectable(true);

        //Spinner con el tipo de material.
        adapter_mat_san = ArrayAdapter.createFromResource(getContext(), R.array.Tuberias_sanitarias, android.R.layout.simple_spinner_item);
        adapter_mat_san.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_mat_san.setAdapter(adapter_mat_san);

        spin_mat_san.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                TXResults_san.setText("");
                ETSlope.setText("");

                switch (i){
                    case 0:
                        //PVC Sanitario
                        Material = 0;
                        lista1 = providerOfPipeInformation.getPipeList(PipeProvider.PVC_SANITARIO);
                        break;
                    case 1:
                        //Concreto Simple
                        Material = 1;
                        lista1 = providerOfPipeInformation.getPipeList(PipeProvider.CONCRETO_SIMPLE);
                        break;

                    case 2:
                        //Concreto reforzado
                        lista1 = providerOfPipeInformation.getPipeList(PipeProvider.CONCRETO_REFORZADO);
                        Material = 2;
                        break;

                    case 3:
                        //PEAD Sanitario
                        lista1 = providerOfPipeInformation.getPipeList(PipeProvider.PAD_SANITARIO);
                        Material = 3;
                        break;

                    case 4:
                        //4 - Duro Maxx
                        lista1 = providerOfPipeInformation.getPipeList(PipeProvider.DURO_MAXX);
                        Material = 4;
                        break;

                    case 5:
                        //5 - Ultraflo 12
                        lista1 = providerOfPipeInformation.getPipeList(PipeProvider.ULTRA_FLO12);
                        Material = 5;
                        break;

                    case 6:
                        //6 - Ultraflo 14
                        lista1 = providerOfPipeInformation.getPipeList(PipeProvider.ULTRA_FLO14);
                        Material = 6;
                        break;

                    case 7:
                        //7 - Ultraflo 16
                        lista1 = providerOfPipeInformation.getPipeList(PipeProvider.ULTRA_FLO16);
                        Material = 7;
                        break;
                    case 8:
                        //7 - Ultraflo 10 Alum
                        lista1 = providerOfPipeInformation.getPipeList(PipeProvider.ULTRA_FLO10_AL);
                        Material = 8;
                        break;
                    case 9:
                        //7 - Ultraflo 12 Alum
                        lista1 = providerOfPipeInformation.getPipeList(PipeProvider.ULTRA_FLO12_AL);
                        Material = 9;
                        break;
                    case 10:
                        //7 - Ultraflo 14 Alum
                        lista1 = providerOfPipeInformation.getPipeList(PipeProvider.ULTRA_FLO14_AL);
                        Material = 10;
                        break;
                    case 11:
                        //7 - Ultraflo 16 Alum
                        lista1 = providerOfPipeInformation.getPipeList(PipeProvider.ULTRA_FLO16_AL);
                        Material = 11;
                        break;
                }

                setRugosidad(Material);
                TXResults_san.setText("");
                ETSlope.setText("");

                int n = lista1.length;

                cadena.clear();

                for (int k1 = 0; k1 < n; k1++) {
                    String diam = lista1[k1][0] + "in - " + lista1[k1][3] + "mm";
                    cadena.add(diam);
                }

                AdapterDiam_san = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, cadena);
                AdapterDiam_san.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


                spin_diam_san.setAdapter(AdapterDiam_san);

                spin_diam_san.setVisibility(View.VISIBLE);
                spin_unidades_san.setVisibility(View.VISIBLE);

                spin_diam_san.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        TXResults_san.setText("");
                        ETNumber.setText("");

                        DiamPos = spin_diam_san.getSelectedItemPosition();
                        Log.i("DiamPos", "DiamPos: " +  DiamPos);
                        Log.i("DiamPos", "Value: " + lista1[DiamPos][3]);
                        DSan_mm = Double.parseDouble(lista1[DiamPos][3]);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });

                adapterUnits_san = ArrayAdapter.createFromResource(getContext(), R.array.unidades_san, android.R.layout.simple_spinner_item);

                adapterUnits_san.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spin_unidades_san.setAdapter(adapterUnits_san);

                spin_unidades_san.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        //ETNumber.setText("");
                        StrUnidades = spin_unidades_san.getSelectedItem().toString();
                        IntUnidades = spin_unidades_san.getSelectedItemPosition();

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });



            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        BtnCirc = (Button) v.findViewById(R.id.Boton_canal_circ);

        BtnCirc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(getContext(), "Llamando al método para calcular", Toast.LENGTH_SHORT).show();

                if(ETSlope.getText().toString().isEmpty()||(Double.parseDouble(ETSlope.getText().toString())<0)){

                    Toast.makeText(getContext(), getResources().getString(R.string.Toast_add_slope), Toast.LENGTH_SHORT).show();

                } else {


                    if(ETNumber.getText().toString().isEmpty()||(Double.parseDouble(ETNumber.getText().toString())<0)){
                        Toast.makeText(getContext(), getResources().getString(R.string.Toast_add_variable), Toast.LENGTH_SHORT).show();


                    } else {
                        boolean hasResults = false;
                        switch (IntUnidades){

                            case 0:
                                //Toast.makeText(getContext(), "Cálculo con el gasto", Toast.LENGTH_SHORT).show();

                                TubSan.setGastoLPS(Double.parseDouble(ETNumber.getText().toString()));
                                TubSan.setDiametro(DSan_mm/1000);
                                TubSan.setRugosidad(Rugosidad);
                                TubSan.setSlope(Double.parseDouble(ETSlope.getText().toString()));
                                TubSan.CalcfromQ();
                                String Calculo = TubSan.getCalcNoDone();
                                boolean resultado = TubSan.isSuccess();

                                //Toast.makeText(getContext(), "Resultado: " + resultado, Toast.LENGTH_SHORT).show();


                                if(resultado!=true){
                                    //Toast.makeText(getContext(), R.string.Calculo_fallido, Toast.LENGTH_SHORT).show();

                                    String res1 = getResources().getString(R.string.Calculo_fallido);
                                    String maxFlow = getResources().getString(R.string.maxflowText);
                                    TXResults_san.setText(res1+"\n\n"+maxFlow + String.format("%.2f",TubSan.getQMAX()) + " m3/s");
                                    //Toast.makeText(getContext(), "El gasto máximo posible es: " + String.format("%.2f",TubSan.getQMAX()) + " m3/s", Toast.LENGTH_SHORT).show();


                                } else {
                                    hasResults = true;


                                }


                                break;

                            case 1:

                                //Toast.makeText(getContext(), "Cálculo con la velocidad", Toast.LENGTH_SHORT).show();

                                TubSan.setVelocity(Double.parseDouble(ETNumber.getText().toString()));
                                TubSan.setDiametro(DSan_mm/1000);
                                TubSan.setRugosidad(Rugosidad);
                                TubSan.setSlope(Double.parseDouble(ETSlope.getText().toString()));
                                TubSan.CalcfromV();


                                if(TubSan.getTirante()<0){
                                    Toast.makeText(getContext(), R.string.Calculo_fallidoV, Toast.LENGTH_SHORT).show();

                                    //TXResults_san.setText(R.string.Calculo_fallidoV);

                                } else {
                                    hasResults = true;


                                }

                                break;

                            case 2:

                                //Toast.makeText(getContext(), "Cálculo con el tirante", Toast.LENGTH_SHORT).show();

                                if(Double.parseDouble(ETNumber.getText().toString())>(DSan_mm/1000)){
                                    Toast.makeText(getContext(), getResources().getString(R.string.Toast_h_mayoraD), Toast.LENGTH_SHORT).show();


                                } else {
                                    TubSan.setDiametro(DSan_mm/1000);
                                    TubSan.setRugosidad(Rugosidad);
                                    TubSan.setSlope(Double.parseDouble(ETSlope.getText().toString()));

                                    TubSan.setTirante(Double.parseDouble(ETNumber.getText().toString()));
                                    TubSan.CalcfromH();
                                    //Mostrar los resultados
                                    hasResults = true;




                                }

                                break;

                            default:
                                    break;

                        }

                        //Print results to TextView
                        if(hasResults){
                            String Resultados;
                            String StrGasto, StrVel, Strh, StrRug, StrArea, StrFroude, StrFlujo, StrQmax1, StrQmax2;

                            StrGasto = getResources().getString(R.string.res_flow) + String.format("%.2f", TubSan.getGasto()*1000) + " \n";
                            StrVel = getResources().getString(R.string.res_vel) + String.format("%.3f", TubSan.getVelocity()) + " \n";
                            Strh = getResources().getString(R.string.res_tirante)+  String.format("%.3f", TubSan.getTirante()) + " \n";
                            StrRug = getResources().getString(R.string.res_manning) + String.format("%.3f", TubSan.getRugosidad()) + " \n";
                            StrArea = getResources().getString(R.string.res_area)+ String.format("%.3f", TubSan.getArea()) + " \n";
                            StrFroude = getResources().getString(R.string.res_froude)+ String.format("%.3f", TubSan.getFroude()) + " \n";
                            StrFlujo = getResources().getString(R.string.res_tipo_flujo) + TubSan.getTipoFlujo()+" \n";

                            StrQmax1 = getResources().getString(R.string.res_qmax_full)  + String.format("%.2f", TubSan.getQmax1()*1000) + " \n";
                            StrQmax2 = getResources().getString(R.string.res_q_0_8D)  + String.format("%.2f", TubSan.getQmax2()*1000) + " \n";

                            Resultados = StrGasto + StrVel + StrArea+  Strh + StrRug + StrFroude + StrFlujo +StrQmax1 + StrQmax2;
                            TXResults_san.setText(Resultados);
                        }
                    }
                }
            }
        });


        return v;
    }


    public void setRugosidad(int material){
        Rugosidad=0.000;
        switch (material){
            case 0:
                //PVC Sanitario
                this.Rugosidad = 0.009;
                break;
            case 1:
                //Concreto simple
                this.Rugosidad = 0.013;
                break;
            case 2:
                //Concreto reforzado
                this.Rugosidad = 0.013;
                break;
            case 3:
                //PEAD Sanitario
                this.Rugosidad = 0.009;
                break;
            case 4:
                //4 - Duro Maxx
                this.Rugosidad = 0.012;
                break;
            case 5:
                //5 - Ultraflo 12
                this.Rugosidad = 0.012;
                break;
            case 6:
                //6 - Ultraflo 14
                this.Rugosidad = 0.012;
                break;
            case 7:
                //7 - Ultraflo 16
                this.Rugosidad = 0.012;
                break;
            case 8:
                //7 - Ultraflo 10 Alum
                this.Rugosidad = 0.012;
                break;
            case 9:
                //7 - Ultraflo 12 Alum
                this.Rugosidad = 0.012;
                break;
            case 10:
                //7 - Ultraflo 14 Alum
                this.Rugosidad = 0.012;
                break;
            case 11:
                //7 - Ultraflo 16 Alum
                this.Rugosidad = 0.012;
                break;
            default:
                break;
        }
    };

    public double getRugosidad(){
        return this.Rugosidad;
    };

}
