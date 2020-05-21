package com.perval.levi;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.perval.levi.ayuda.EulaActivity;
import com.perval.levi.ayuda.Help;
import com.perval.levi.tuberias.Pead;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import io.github.kexanie.library.MathView;

public class FlujoAPresion extends AppCompatActivity {


    Pead tubospad = new Pead();
    PVCMetrico PVCMetric1 = new PVCMetrico();
    PVCIngles PVCIngles1 = new PVCIngles();
    Acero tuboacero = new Acero();
    PPR tuboPPR = new PPR();

    //[row][col]
    ArrayList<String> cadena = new ArrayList<>();

    //Entero para indicar qué tipo de TXRD.setText("RD"); se tiene.

    //0 PVC Métrico
    //1 PVC Inglés
    //2 PEAD
    //3 PPR
    //4 Acero
    int Material;




    Spinner Spin_materiales, Spin_RD, Spin_Diam, SpinUnits;
    ArrayAdapter<CharSequence> adapter_spin;
    ArrayAdapter<CharSequence> adapter_RD;
    ArrayAdapter<CharSequence> adapterUnits;
    ArrayAdapter<String> AdapterDint;
    TextView TXDiam, TXRD, TXResults; // = (TextView) findViewById(R.id.TVDiam);

    EditText ETNumber;
    Button Calcular;
    String StrUnidades;
    double Diam_mm;
    //DiamPos se corresponde a la posición del diámetro seleccionado para hacer los cálculos.
    //IntUnidades se corrsponde a las unidades del valor base para realizar los cálculos, l/s, m/s, m/km
    int IntUnidades, DiamPos;


    double flow, velocity, headloss;
    //TextView TXRD = (TextView) findViewById(R.id.TVRD);
    String lista1[][];

    MathView MVResultados;
    WebView WVResults;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flujo_apresion);

        Toolbar toolbar = (Toolbar) findViewById(R.id.Tb_Flujo_presion);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        setSupportActionBar(toolbar);



        Spin_materiales = findViewById(R.id.spin_material);

        Spin_RD = findViewById(R.id.spin_RD);
        Spin_RD.setVisibility(View.GONE);


        ETNumber = findViewById(R.id.ET_Number);
        TXRD = findViewById(R.id.TVRD);
        TXDiam = findViewById(R.id.TVDiam);

        ETNumber.setVisibility(View.GONE);
        TXDiam.setVisibility(View.GONE);
        TXRD.setVisibility(View.GONE);


        Spin_Diam = findViewById(R.id.spin_Diam);
        Spin_Diam.setVisibility(View.GONE);


        SpinUnits = findViewById(R.id.SpinUnits);
        SpinUnits.setVisibility(View.GONE);

        Calcular = findViewById(R.id.CalcButton);
        Calcular.setVisibility(View.GONE);

        TXResults = findViewById(R.id.TVResults);
        TXResults.setTextIsSelectable(true);
        TXResults.setGravity(Gravity.CENTER_HORIZONTAL);

        //Spinner con el tipo de material.
        adapter_spin = ArrayAdapter.createFromResource(this, R.array.lista_materiales, android.R.layout.simple_spinner_item);
        adapter_spin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spin_materiales.setAdapter(adapter_spin);


        Spin_materiales.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                TXResults.setText("");
                ETNumber.setText("");

                //Aquí inicia el método swicth
                switch(i){
                    case 0:
                        //PVC Métrico
                        TXRD.setText("RD");
                        Material = 0;
                        //Toast.makeText(getApplicationContext(), "PVC Métrico", Toast.LENGTH_SHORT).show();
                        adapter_RD = ArrayAdapter.createFromResource(getBaseContext(), R.array.listPVCMetric, android.R.layout.simple_spinner_item);
                        adapter_RD.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        Spin_RD.setAdapter(adapter_RD);
                        Spin_RD.setVisibility(View.VISIBLE);
                        TXRD.setVisibility(View.VISIBLE);


                        Spin_RD.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            //Spinner con el diámetro interno de las tuberías.
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                //String Texto = Spin_RD.getSelectedItem().toString();
                                //Toast.makeText(getApplicationContext(), Texto, Toast.LENGTH_SHORT).show();
                                TXResults.setText("");
                                ETNumber.setText("");

                                //getpipes regresa la lista de tuberías con base en el RD seleccionado.
                                lista1 = PVCMetric1.getpipes(i);

                                //String cadena = lista1.length];

                                int n = lista1.length;
                                cadena.clear();
                                for (int k1 = 0; k1 < n; k1++) {
                                    String diam = lista1[k1][0] + "in - " + lista1[k1][3] + "mm";
                                    cadena.add(diam);
                                }


                                AdapterDint = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, cadena);
                                AdapterDint.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                Spin_Diam.setAdapter(AdapterDint);

                                Spin_Diam.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                                        TXResults.setText("");
                                        ETNumber.setText("");

                                        DiamPos = Spin_Diam.getSelectedItemPosition();
                                        Diam_mm = Double.parseDouble(lista1[DiamPos][3]);
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> adapterView) {

                                    }
                                });

                                adapterUnits = ArrayAdapter.createFromResource(getBaseContext(), R.array.unidades, android.R.layout.simple_spinner_item);
                                adapterUnits.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                SpinUnits.setAdapter(adapterUnits);
                                SpinUnits.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                        //ETNumber.setText("");
                                        StrUnidades = SpinUnits.getSelectedItem().toString();
                                        IntUnidades = SpinUnits.getSelectedItemPosition();

                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> adapterView) {

                                    }
                                });


                                Spin_Diam.setVisibility(View.VISIBLE);
                                SpinUnits.setVisibility(View.VISIBLE);
                                TXDiam.setVisibility(View.VISIBLE);
                                ETNumber.setVisibility(View.VISIBLE);
                                Calcular.setVisibility(View.VISIBLE);
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });


                        break;
                    case 1:
                        //PVC Inglés
                        //Toast.makeText(getApplicationContext(), "PVC Inglés", Toast.LENGTH_SHORT).show();
                        TXRD.setText("RD");
                        Material = 1;
                        adapter_RD = ArrayAdapter.createFromResource(getBaseContext(), R.array.listPVCInglesa, android.R.layout.simple_spinner_item);
                        adapter_RD.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        Spin_RD.setAdapter(adapter_RD);
                        Spin_RD.setVisibility(View.VISIBLE);
                        TXRD.setVisibility(View.VISIBLE);

                        Spin_RD.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            //Spinner con el diámetro interno de las tuberías.
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                //String Texto = Spin_RD.getSelectedItem().toString();
                                //Toast.makeText(getApplicationContext(), Texto, Toast.LENGTH_SHORT).show();
                                TXResults.setText("");
                                ETNumber.setText("");

                                //getpipes regresa la lista de tuberías por con base en el RD seleccionado.
                                lista1 = PVCIngles1.getpipes(i);

                                //String cadena = lista1.length];

                                int n = lista1.length;
                                cadena.clear();
                                for (int k1 = 0; k1 < n; k1++) {
                                    String diam = lista1[k1][0] + "in - " + lista1[k1][3] + "mm";
                                    cadena.add(diam);
                                }


                                AdapterDint = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, cadena);
                                AdapterDint.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                Spin_Diam.setAdapter(AdapterDint);
                                Spin_Diam.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                                        TXResults.setText("");
                                        ETNumber.setText("");

                                        DiamPos = Spin_Diam.getSelectedItemPosition();
                                        Diam_mm = Double.parseDouble(lista1[DiamPos][3]);
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> adapterView) {

                                    }
                                });

                                adapterUnits = ArrayAdapter.createFromResource(getBaseContext(), R.array.unidades, android.R.layout.simple_spinner_item);
                                adapterUnits.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                SpinUnits.setAdapter(adapterUnits);
                                SpinUnits.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                        //ETNumber.setText("");
                                        StrUnidades = SpinUnits.getSelectedItem().toString();
                                        IntUnidades = SpinUnits.getSelectedItemPosition();

                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> adapterView) {

                                    }
                                });


                                Spin_Diam.setVisibility(View.VISIBLE);
                                SpinUnits.setVisibility(View.VISIBLE);
                                TXDiam.setVisibility(View.VISIBLE);
                                ETNumber.setVisibility(View.VISIBLE);
                                Calcular.setVisibility(View.VISIBLE);
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });

                        break;
                    case 2:
                        //PEAD
                        //Toast.makeText(getApplicationContext(), "PEAD", Toast.LENGTH_SHORT).show();
                        Material = 2;
                        TXRD.setText("RD");
                        //Toast.makeText(getApplicationContext(), "PEAD.", Toast.LENGTH_SHORT).show();

                        adapter_RD = ArrayAdapter.createFromResource(getBaseContext(), R.array.listRD, android.R.layout.simple_spinner_item);
                        adapter_RD.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        Spin_RD.setAdapter(adapter_RD);
                        Spin_RD.setVisibility(View.VISIBLE);
                        Spin_RD.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            //Spinner con el diámetro interno de las tuberías.
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                //String Texto = Spin_RD.getSelectedItem().toString();
                                //Toast.makeText(getApplicationContext(), Texto, Toast.LENGTH_SHORT).show();
                                TXResults.setText("");
                                ETNumber.setText("");

                                //getpipes regresa la lista de tuberías por con base en el RD seleccionado.
                                lista1 = tubospad.getpipes(i);

                                //String cadena = lista1.length];

                                int n = lista1.length;
                                cadena.clear();
                                for (int k1 = 0; k1 < n; k1++) {
                                    String diam = lista1[k1][0] + "in - " + lista1[k1][3] + "mm";
                                    cadena.add(diam);
                                }


                                AdapterDint = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, cadena);
                                AdapterDint.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                Spin_Diam.setAdapter(AdapterDint);
                                Spin_Diam.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                                        TXResults.setText("");
                                        ETNumber.setText("");

                                        DiamPos = Spin_Diam.getSelectedItemPosition();
                                        Diam_mm = Double.parseDouble(lista1[DiamPos][3]);
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> adapterView) {

                                    }
                                });

                                adapterUnits = ArrayAdapter.createFromResource(getBaseContext(), R.array.unidades, android.R.layout.simple_spinner_item);
                                adapterUnits.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                SpinUnits.setAdapter(adapterUnits);
                                SpinUnits.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                        //ETNumber.setText("");
                                        StrUnidades = SpinUnits.getSelectedItem().toString();
                                        IntUnidades = SpinUnits.getSelectedItemPosition();

                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> adapterView) {

                                    }
                                });


                                Spin_Diam.setVisibility(View.VISIBLE);
                                SpinUnits.setVisibility(View.VISIBLE);
                                TXRD.setVisibility(View.VISIBLE);
                                TXDiam.setVisibility(View.VISIBLE);
                                ETNumber.setVisibility(View.VISIBLE);
                                Calcular.setVisibility(View.VISIBLE);
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });

                        break;
                    case 3:
                        //PPR
                        //Toast.makeText(getApplicationContext(), "PPR", Toast.LENGTH_SHORT).show();
                        Material = 3;


                        adapter_RD = ArrayAdapter.createFromResource(getBaseContext(), R.array.listPPR, android.R.layout.simple_spinner_item);
                        adapter_RD.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        Spin_RD.setAdapter(adapter_RD);
                        Spin_RD.setVisibility(View.VISIBLE);
                        TXRD.setVisibility(View.VISIBLE);

                        Spin_RD.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            //Spinner con el diámetro interno de las tuberías.
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                //String Texto = Spin_RD.getSelectedItem().toString();
                                //Toast.makeText(getApplicationContext(), Texto, Toast.LENGTH_SHORT).show();
                                TXResults.setText("");
                                ETNumber.setText("");

                                //getpipes regresa la lista de tuberías por con base en el RD seleccionado.
                                lista1 = tuboPPR.getpipes(i);

                                //String cadena = lista1.length];

                                int n = lista1.length;
                                cadena.clear();
                                for (int k1 = 0; k1 < n; k1++) {
                                    String diam = lista1[k1][0] + "mm - " + lista1[k1][3] + "mm";
                                    cadena.add(diam);
                                }


                                AdapterDint = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, cadena);
                                AdapterDint.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                Spin_Diam.setAdapter(AdapterDint);
                                Spin_Diam.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                                        TXResults.setText("");
                                        ETNumber.setText("");

                                        DiamPos = Spin_Diam.getSelectedItemPosition();
                                        Diam_mm = Double.parseDouble(lista1[DiamPos][3]);
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> adapterView) {

                                    }
                                });

                                adapterUnits = ArrayAdapter.createFromResource(getBaseContext(), R.array.unidades, android.R.layout.simple_spinner_item);
                                adapterUnits.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                SpinUnits.setAdapter(adapterUnits);
                                SpinUnits.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                        //ETNumber.setText("");
                                        StrUnidades = SpinUnits.getSelectedItem().toString();
                                        IntUnidades = SpinUnits.getSelectedItemPosition();

                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> adapterView) {

                                    }
                                });


                                Spin_Diam.setVisibility(View.VISIBLE);
                                SpinUnits.setVisibility(View.VISIBLE);
                                TXDiam.setVisibility(View.VISIBLE);
                                ETNumber.setVisibility(View.VISIBLE);
                                Calcular.setVisibility(View.VISIBLE);
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });
                        break;
                    case 4:
                        //Acero
                        TXRD.setText("Cédula");
                        Material = 4;
                        adapter_RD = ArrayAdapter.createFromResource(getBaseContext(), R.array.listAcero, android.R.layout.simple_spinner_item);
                        adapter_RD.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        Spin_RD.setAdapter(adapter_RD);
                        Spin_RD.setVisibility(View.VISIBLE);
                        TXRD.setVisibility(View.VISIBLE);


                        Spin_RD.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            //Spinner con el diámetro interno de las tuberías.
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                String Texto = Spin_RD.getSelectedItem().toString();
                                //Toast.makeText(getApplicationContext(), Texto, Toast.LENGTH_SHORT).show();
                                TXResults.setText("");
                                ETNumber.setText("");

                                //getpipes regresa la lista de tuberías por con base en el RD seleccionado.
                                lista1 = tuboacero.getpipes(i);

                                //String cadena = lista1.length];

                                int n = lista1.length;
                                cadena.clear();
                                for (int k1 = 0; k1 < n; k1++) {
                                    String diam = lista1[k1][0] + "in - " + lista1[k1][3] + "mm";
                                    cadena.add(diam);
                                }


                                AdapterDint = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, cadena);
                                AdapterDint.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                                Spin_Diam.setAdapter(AdapterDint);
                                Spin_Diam.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                                        TXResults.setText("");
                                        ETNumber.setText("");

                                        DiamPos = Spin_Diam.getSelectedItemPosition();
                                        Diam_mm = Double.parseDouble(lista1[DiamPos][3]);
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> adapterView) {

                                    }
                                });

                                adapterUnits = ArrayAdapter.createFromResource(getBaseContext(), R.array.unidades, android.R.layout.simple_spinner_item);
                                adapterUnits.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                SpinUnits.setAdapter(adapterUnits);
                                SpinUnits.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                        //ETNumber.setText("");
                                        StrUnidades = SpinUnits.getSelectedItem().toString();
                                        IntUnidades = SpinUnits.getSelectedItemPosition();

                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> adapterView) {

                                    }


                                });


                                Spin_Diam.setVisibility(View.VISIBLE);
                                SpinUnits.setVisibility(View.VISIBLE);
                                TXDiam.setVisibility(View.VISIBLE);
                                ETNumber.setVisibility(View.VISIBLE);
                                Calcular.setVisibility(View.VISIBLE);
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });
                        break;






                    default:
                        break;


                }

                //Aquí terminará la implementación del switch

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




        Button boton = (Button) findViewById(R.id.CalcButton);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calcular();
            }
        });





    }



    public void Calcular() {
        double Dobrugosidad = 0;
        switch (Material) {
            case 0:
                //1 PVC Métrico

                Dobrugosidad = 0.0015;

                break;
            case 1:
                //2 PVC Inglés

                Dobrugosidad = 0.0015;
                break;
            case 2:
                //3 PEAD

                Dobrugosidad = 0.0015;
                break;
            case 3:
                //4 PPR
                Dobrugosidad = 0.007;

                break;
            case 4:
                Dobrugosidad = 0.06;
                //5 Acero
                break;


        };


        String texto, gasto, velocidad, reynolds, perdidas, rugosidad;

        if (ETNumber.getText().toString().isEmpty()) {

            Toast.makeText(this, getString(R.string.ETNumberWarn), Toast.LENGTH_LONG).show();
        } else {
            //Comprobación mayor que cero.
            if (Double.parseDouble(ETNumber.getText().toString()) <= 0) {

                Toast.makeText(this, getString(R.string.ETPositiveWarn), Toast.LENGTH_LONG).show();
            } else {

                switch (IntUnidades) {
                    case 0:
                        //Calculos a partir del gasto.
                        //Realizar los cálculos

                        Tuberia tubocalc = new Tuberia();
                        tubocalc.setflow(Double.parseDouble(ETNumber.getText().toString()) / 1000);
                        //la clase hace la conversioń de forma interna del diámetro a metros.
                        tubocalc.setDint(Diam_mm);
                        tubocalc.setrough(Dobrugosidad);
                        tubocalc.CalcfromQ();
                        //MVResultados.setVisibility(View.VISIBLE);

                        gasto = getString(R.string.Gasto) + ": "+ String.format("%.2f", tubocalc.getQ() * 1000) + " \n";
                        //gasto = "$$ Q = " + String.format("%.2f", tubocalc.getQ() * 1000) + " \\; l/s" + "$$";
                        //texto = "$$ Q = " + NumberFormat.getNumberInstance(Locale.US).format( tubocalc.getQ()*1000) + " \\; l/s" +"$$";

                        velocidad = getString(R.string.Velocidad) + ": " + String.format("%.2f", tubocalc.getvel()) + " \n";
                        //velocidad = "$$ vel = " + String.format("%.2f", tubocalc.getvel()) + " \\; m/s" + " $$";
                        //texto = texto + "$$Reynolds = " + String.format("%.2f",tubocalc.getRey()) + " $$";

                        reynolds = getString(R.string.Reynolds)+ ": " + NumberFormat.getNumberInstance(Locale.US).format(tubocalc.getRey()) + " \n";

//                        reynolds = "$$ Reynolds = " + NumberFormat.getNumberInstance(Locale.US).format(tubocalc.getRey()) + "$$";

                        //perdidas = "$$ P\\acute{e}rdidas = " + String.format("%.2f", tubocalc.getHL() * 1000) + " \\; m/km" + " $$";

                        perdidas = getString(R.string.Perdidas) + ": " + String.format("%.2f", tubocalc.getHL() * 1000) + " \n";

                        //rugosidad = "$$ Rugosidad = " + tubocalc.getRough()*1000 + " \\; mm" + " $$";
                        rugosidad = getString(R.string.Rugosidad) + ": " + tubocalc.getRough()*1000 + " \n";

                        texto = gasto + velocidad + reynolds + perdidas + rugosidad;

                        //MVResultados.setText(texto);

                        TXResults.setText(texto);

                        //Toast.makeText(getApplicationContext(), StrUnidades, Toast.LENGTH_LONG).show();
                        break;
                    case 1:

                        Tuberia tubocalc2 = new Tuberia();
                        tubocalc2.setVel(Double.parseDouble(ETNumber.getText().toString()));
                        tubocalc2.setDint(Diam_mm);
                        tubocalc2.setrough(Dobrugosidad);
                        tubocalc2.CalcfromV();
                        //MVResultados.setVisibility(View.VISIBLE);

                        gasto = getString(R.string.Gasto) + ": " + String.format("%.2f", tubocalc2.getQ() * 1000) + " \n";
                        //gasto = "$$ Q = " + String.format("%.2f", tubocalc2.getQ() * 1000) + " \\; l/s" + "$$";
                        //texto = "$$ Q = " + NumberFormat.getNumberInstance(Locale.US).format( tubocalc.getQ()*1000) + " \\; l/s" +"$$";

                        velocidad = getString(R.string.Velocidad) + ": " + String.format("%.2f", tubocalc2.getvel()) + " \n";
                        //velocidad = "$$ vel = " + String.format("%.2f", tubocalc2.getvel()) + " \\; m/s" + " $$";
                        //texto = texto + "$$Reynolds = " + String.format("%.2f",tubocalc.getRey()) + " $$";

                        reynolds = getString(R.string.Reynolds) + ": " + NumberFormat.getNumberInstance(Locale.US).format(tubocalc2.getRey()) + " \n";

                        //reynolds = "$$ Reynolds = " + NumberFormat.getNumberInstance(Locale.US).format(tubocalc2.getRey()) + "$$";

                        perdidas = getString(R.string.Perdidas) + ": " + String.format("%.2f", tubocalc2.getHL() * 1000) + " \n";

                        //perdidas = "$$ P\\acute{e}rdidas = " + String.format("%.2f", tubocalc2.getHL() * 1000) + " \\; m/km" + " $$";

                        //rugosidad = "$$ Rugosidad = " + tubocalc2.getRough()*1000 + " \\; mm" + " $$";
                        rugosidad = getString(R.string.Rugosidad) + ": " + tubocalc2.getRough()*1000 + " \n";


                        texto = gasto + velocidad + reynolds + perdidas + rugosidad;
                        //MVResultados.setText(texto);

                        TXResults.setText(texto);
                        //Toast.makeText(getApplicationContext(), StrUnidades, Toast.LENGTH_LONG).show();
                        break;

                    case 2:

                        Tuberia tubocalc3 = new Tuberia();
                        double HLin = Double.parseDouble(ETNumber.getText().toString())/1000;

                        tubocalc3.setHL(Double.parseDouble(ETNumber.getText().toString()));
                        tubocalc3.setDint(Diam_mm);
                        tubocalc3.setrough(Dobrugosidad);



                        //Gastos en m3/s

                        double Qdummy, Qdummy0, Qdummy1;
                        //Qdummy1 irá hacia abajo
                        //Qdummy2 irá hacia arriba
                        //MVResultados.setVisibility(View.VISIBLE);
                        Qdummy0 = 0.00001;
                        Qdummy1 = Math.pow((Diam_mm/1000)/1.2,2);
                        double Dif1;

                        Tuberia tubodummy0 = new Tuberia();
                        tubodummy0.setDint(Diam_mm);
                        tubodummy0.setrough(0.0015);

                        Tuberia tubodummy1 = new Tuberia();
                        tubodummy1.setDint(Diam_mm);
                        tubodummy1.setrough(0.0015);

                        //La función objetivo será
                        //Fx = Hl(q) - HLint
                        double Fx0, Fx1;
                        double Derivada;

                        do {

                            //ingresar datos a tubodummy0
                            tubodummy0.setflow(Qdummy0);
                            tubodummy0.CalcfromQ();
                            Fx0 = tubodummy0.getHL() - HLin;

                            tubodummy1.setflow(Qdummy1);
                            tubodummy1.CalcfromQ();
                            Fx1 = tubodummy1.getHL()-HLin;

                            Derivada = (Fx1 - Fx0) / (Qdummy1- Qdummy1);
                            double Qnext = Qdummy1 - (Fx1 *(Qdummy0-Qdummy1))/(Fx0-Fx1);

                            Qdummy0 = Qdummy1*1;
                            Qdummy1 = Qnext*1;

                            Dif1 = Math.abs(Qdummy1- Qdummy0);
                        } while (Dif1 >0.00001);

                        tubocalc3.setflow(Qdummy1);
                        tubocalc3.CalcfromQ();


                        //gasto = "$$ Q = " + String.format("%.2f", tubocalc3.getQ() * 1000) + " \\; l/s" + "$$";
                        //texto = "$$ Q = " + NumberFormat.getNumberInstance(Locale.US).format( tubocalc.getQ()*1000) + " \\; l/s" +"$$";

                        gasto = getString(R.string.Gasto) + ": " + String.format("%.2f", tubocalc3.getQ() * 1000) + " \n";

                        //velocidad = "$$ vel = " + String.format("%.2f", tubocalc3.getvel()) + " \\; m/s" + " $$";
                        //texto = texto + "$$Reynolds = " + String.format("%.2f",tubocalc.getRey()) + " $$";

                        velocidad = getString(R.string.Velocidad) + ": " + String.format("%.2f", tubocalc3.getvel()) + " \n";
                        //reynolds = "$$ Reynolds = " + NumberFormat.getNumberInstance(Locale.US).format(tubocalc3.getRey()) + "$$";

                        reynolds = getString(R.string.Reynolds) + ": " + NumberFormat.getNumberInstance(Locale.US).format(tubocalc3.getRey()) + " \n";

                        //perdidas = "$$ P\\acute{e}rdidas = " + String.format("%.2f", tubocalc3.getHL() * 1000) + " \\; m/km" + " $$";

                        perdidas = getString(R.string.Perdidas) + ": " + String.format("%.2f", tubocalc3.getHL() * 1000) + " \n";

                        //rugosidad = "$$ Rugosidad = " + tubocalc3.getRough()*1000 + " \\; mm"+ " $$";


                        rugosidad = getString(R.string.Rugosidad) + tubocalc3.getRough()*1000 + " mm \n";
                        texto = gasto + velocidad + reynolds + perdidas + rugosidad;

                        //MVResultados.setText(texto);

                        TXResults.setText(texto);
                        //Toast.makeText(getApplicationContext(), StrUnidades, Toast.LENGTH_LONG).show();

                        break;

                    default:

                        break;
                }

            }
        }

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {

            case R.id.ayuda:
                Intent helpIntent = new Intent(this, Help.class);
                startActivity(helpIntent);
                overridePendingTransition(R.anim.bottom_in, R.anim.bottom_out);

                return true;
            case R.id.contacto:
                Intent Cont_Intent = new Intent(this, Contacto.class );
                startActivity(Cont_Intent);
                overridePendingTransition(R.anim.bottom_in, R.anim.bottom_out);

                return true;

            case R.id.licencia:
                Intent Eula_Intent = new Intent(this, EulaActivity.class );
                startActivity(Eula_Intent);
                overridePendingTransition(R.anim.bottom_in, R.anim.bottom_out);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
