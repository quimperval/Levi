package com.perval.levi;

import android.support.v4.app.Fragment;
import android.os.Bundle;
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

import java.util.ArrayList;

import io.github.kexanie.library.MathView;

public class FragCanalCircular extends Fragment{
    private Spinner spin_mat_san, spin_diam_san, spin_unidades_san;
    ArrayAdapter<CharSequence> adapter_mat_san;

    ArrayAdapter<CharSequence> adapterUnits_san;
    ArrayAdapter<String> AdapterDiam_san;
    TextView TXDiam_san, TXResults_san;
    Button BtnCirc;

    TuberiaSanitaria TubSan = new TuberiaSanitaria();

    ArrayList<String> cadena = new ArrayList<>();
    String lista1[][];

    private double Rugosidad;
    EditText ETNumber, ETSlope;
    Button Calcular;
    String StrUnidades;
    double DSan_mm;

    //DiamPos se corresponde a la posición del diámetro seleccionado para hacer los cálculos.
    //IntUnidades se corrsponde a las unidades del valor base para realizar los cálculos, l/s, m/s, m/km
    int IntUnidades, DiamPos;


    double flow, velocity, headloss;
    //TextView TXRD = (TextView) findViewById(R.id.TVRD);

    MathView MVResultados;
    WebView WVResults;


    //Material
    //0 - PVC Sanitario
    //1 - Concreto simple
    //2 - Concreto reforzado
    //3 - PEAD sanitario
    int Material;







    public FragCanalCircular(){


    }

    @Override
    public void onCreate(Bundle savedInstaceState){
        super.onCreate(savedInstaceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){


        View v = inflater.inflate(R.layout.fragment_canal_circular,container,false);



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
                        setRugosidad(Material);
                        TXResults_san.setText("");
                        ETSlope.setText("");


                        lista1 = TubSan.getPVCSanitario();

                        //String cadena = lista1.length];

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

                        break;
                    case 1:
                        //Concreto Simple
                        Material = 1;
                        setRugosidad(Material);
                        TXResults_san.setText("");
                        ETSlope.setText("");



                        lista1 = TubSan.getConcretoSimple();

                        //String cadena = lista1.length];

                        n = lista1.length;

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




                        break;
                    case 2:
                        //Concreto reforzado

                        Material = 2;
                        setRugosidad(Material);
                        TXResults_san.setText("");
                        ETSlope.setText("");



                        lista1 = TubSan.getConcretoReforzado();

                        //String cadena = lista1.length];

                        n = lista1.length;

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
                                TXResults_san.setText("");
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });
                        break;
                    case 3:
                        //PEAD Sanitario
                        Material = 3;
                        setRugosidad(Material);
                        TXResults_san.setText("");
                        ETSlope.setText("");



                        lista1 = TubSan.getPADSanitario();

                        //String cadena = lista1.length];

                        n = lista1.length;

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

                                TXResults_san.setText("");
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

                        switch (IntUnidades){

                            case 0:
                                Toast.makeText(getContext(), "Cálculo con el gasto", Toast.LENGTH_SHORT).show();

                                TubSan.setGasto(Double.parseDouble(ETNumber.getText().toString()));
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
                                    TXResults_san.setText(res1+"\n\n"+"El gasto máximo posible es: " + String.format("%.2f",TubSan.getQMAX()) + " m3/s");
                                    //Toast.makeText(getContext(), "El gasto máximo posible es: " + String.format("%.2f",TubSan.getQMAX()) + " m3/s", Toast.LENGTH_SHORT).show();


                                } else {

                                    //Mostrar los resultados

                                    String Resultados;

                                    String StrGasto, StrVel, Strh, StrRug, StrArea, StrFroude, StrFlujo, StrQmax1, StrQmax2;

                                    StrGasto = "Gasto (l/s): " + String.format("%.2f", TubSan.getGasto()*1000) + " \n";
                                    StrVel = "Velocidad (m/s): " + String.format("%.3f", TubSan.getVelocity()) + " \n";
                                    Strh = "Tirante (m): "+  String.format("%.3f", TubSan.getTirante()) + " \n";
                                    StrRug = "n Manning: " + String.format("%.3f", TubSan.getRugosidad()) + " \n";
                                    StrArea = "Area (m2): "+ String.format("%.3f", TubSan.getArea()) + " \n";
                                    StrFroude = "Froude: "+ String.format("%.3f", TubSan.getFroude()) + " \n";
                                    StrFlujo = "Tipo de flujo: " + TubSan.getTipoFlujo()+" \n";

                                    StrQmax1 = "Qmax a tubo lleno (l/s): "  + String.format("%.2f", TubSan.getQmax1()*1000) + " \n";
                                    StrQmax2 = "Q con tirante = 0.8D (l/s): "  + String.format("%.2f", TubSan.getQmax2()*1000) + " \n";
                                    Resultados = StrGasto + StrVel + StrArea+  Strh + StrRug + StrFroude + StrFlujo +StrQmax1 + StrQmax2;

                                   // Toast.makeText(getContext(), "El gasto máximo es: " + TubSan.getQMAX(), Toast.LENGTH_SHORT).show();
                                    TXResults_san.setText(Resultados);

                                }


                                break;

                            case 1:

                                Toast.makeText(getContext(), "Cálculo con la velocidad", Toast.LENGTH_SHORT).show();

                                TubSan.setVelocity(Double.parseDouble(ETNumber.getText().toString()));
                                TubSan.setDiametro(DSan_mm/1000);
                                TubSan.setRugosidad(Rugosidad);
                                TubSan.setSlope(Double.parseDouble(ETSlope.getText().toString()));
                                TubSan.CalcfromV();


                                if(TubSan.getTirante()<0){
                                    Toast.makeText(getContext(), R.string.Calculo_fallidoV, Toast.LENGTH_SHORT).show();

                                    //TXResults_san.setText(R.string.Calculo_fallidoV);

                                } else {

                                    //Mostrar los resultados

                                    String Resultados;

                                    String StrGasto, StrVel, Strh, StrRug, StrArea, StrFroude, StrFlujo, StrQmax1, StrQmax2;

                                    StrGasto = "Gasto (l/s): " + String.format("%.2f", TubSan.getGasto()*1000) + " \n";
                                    StrVel = "Velocidad (m/s) :" + String.format("%.3f", TubSan.getVelocity()) + " \n";
                                    Strh = "Tirante (m): "+  String.format("%.3f", TubSan.getTirante()) + " \n";
                                    StrRug = "n Manning: " + String.format("%.3f", TubSan.getRugosidad()) + " \n";
                                    StrArea = "Area (m2): "+ String.format("%.3f", TubSan.getArea()) + " \n";
                                    StrFroude = "Froude: "+ String.format("%.3f", TubSan.getFroude()) + " \n";
                                    StrFlujo = "Tipo de flujo: " + TubSan.getTipoFlujo()+" \n";
                                    StrQmax1 = "Qmax a tubo lleno (l/s): "  + String.format("%.2f", TubSan.getQmax1()*1000) + " \n";
                                    StrQmax2 = "Q con tirante = 0.8D (l/s): "  + String.format("%.2f", TubSan.getQmax2()*1000) + " \n";
                                    Resultados = StrGasto + StrVel + StrArea+  Strh + StrRug + StrFroude + StrFlujo +StrQmax1 + StrQmax2;

                                    TXResults_san.setText(Resultados);

                                }

                                break;

                            case 2:

                                Toast.makeText(getContext(), "Cálculo con el tirante", Toast.LENGTH_SHORT).show();

                                if(Double.parseDouble(ETNumber.getText().toString())>(DSan_mm/1000)){
                                    Toast.makeText(getContext(), getResources().getString(R.string.Toast_h_mayoraD), Toast.LENGTH_SHORT).show();


                                } else {
                                    TubSan.setDiametro(DSan_mm/1000);
                                    TubSan.setRugosidad(Rugosidad);
                                    TubSan.setSlope(Double.parseDouble(ETSlope.getText().toString()));

                                    TubSan.setTirante(Double.parseDouble(ETNumber.getText().toString()));
                                    TubSan.CalcfromH();
                                    //Mostrar los resultados

                                    String Resultados;
                                    String StrGasto, StrVel, Strh, StrRug, StrArea, StrFroude, StrFlujo, StrQmax1, StrQmax2;

                                    StrGasto = "Gasto (l/s): " + String.format("%.2f", TubSan.getGasto()*1000) + " \n";
                                    StrVel = "Velocidad (m/s) :" + String.format("%.3f", TubSan.getVelocity()) + " \n";
                                    Strh = "Tirante (m): "+  String.format("%.3f", TubSan.getTirante()) + " \n";
                                    StrRug = "n Manning: " + String.format("%.3f", TubSan.getRugosidad()) + " \n";
                                    StrArea = "Area (m2): "+ String.format("%.3f", TubSan.getArea()) + " \n";
                                    StrFroude = "Froude: "+ String.format("%.3f", TubSan.getFroude()) + " \n";
                                    StrFlujo = "Tipo de flujo: " + TubSan.getTipoFlujo()+" \n";

                                    StrQmax1 = "Qmax a tubo lleno (l/s) "  + String.format("%.2f", TubSan.getQmax1()*1000) + " \n";
                                    StrQmax2 = "Q con tirante = 0.8D (l/s) "  + String.format("%.2f", TubSan.getQmax2()*1000) + " \n";

                                    Resultados = StrGasto + StrVel + StrArea+  Strh + StrRug + StrFroude + StrFlujo +StrQmax1 + StrQmax2;
                                    TXResults_san.setText(Resultados);



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
            default:
                break;
        }
    };

    public double getRugosidad(){
        return this.Rugosidad;
    };

    public void calcularAtarjeas(View view){

        Toast.makeText(getContext(), "Cálculo de atarjeas", Toast.LENGTH_SHORT).show();

    }

}
