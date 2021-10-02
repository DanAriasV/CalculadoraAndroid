
package com.example.conversiones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {


    DecimalFormat ndec = new DecimalFormat("0.00");
    DecimalFormat ndec2 = new DecimalFormat("0.000000");
    private EditText numero1;
    private TextView Resultado;
    Spinner spinnerParent;
    Spinner spinnerMet1;//spinner unidades metricas
    Spinner spinnerMet2;//spinner unidades metricas
    Spinner spinnerPeso1;
    Spinner spinnerPeso2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] opciones = {"Seleccione una opcion", "Unidades metricas", "Unidades de masa"};
        String[] opciones1 = {"-", "km", "mt", "cm", "mm"};
        String[] opciones2 = {"-", "km", "mt", "cm", "mm"};
        String[] opciones3 = {"-", "ton", "kg", "lb", "g"};
        String[] opciones4 = {"-", "ton", "kg", "lb", "g"};


        spinnerParent = (Spinner) findViewById(R.id.spinnerParent);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        spinnerParent.setAdapter(adapter);

        spinnerMet1 = findViewById(R.id.spnMet1);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones1);
        spinnerMet1.setAdapter(adapter1);

        spinnerMet2= findViewById(R.id.spinMet2);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones2);
        spinnerMet2.setAdapter(adapter2);

        spinnerPeso1= findViewById(R.id.spnPeso1);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones3);
        spinnerPeso1.setAdapter(adapter3);

        spinnerPeso2= findViewById(R.id.spnPeso2);
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones4);
        spinnerPeso2.setAdapter(adapter4);

        numero1 = (EditText) findViewById(R.id.txtNumero1);
        Resultado = (TextView) findViewById(R.id.txvResultado);

        spinnerParent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Button btnCalcular=(Button)findViewById(R.id.button2);
                if (position == 1) {
                    //  btnCalcular.setEnabled(true);
                    spinnerPeso1.setVisibility(View.INVISIBLE);
                    spinnerPeso2.setVisibility(View.INVISIBLE);
                    spinnerMet1.setVisibility(View.VISIBLE);
                    spinnerMet2.setVisibility(View.VISIBLE);


                }else if (position == 2) {
                    //btnCalcular.setEnabled(true);
                    spinnerMet1.setVisibility(View.INVISIBLE);
                    spinnerMet2.setVisibility(View.INVISIBLE);
                    spinnerPeso1.setVisibility(View.VISIBLE);
                    spinnerPeso2.setVisibility(View.VISIBLE);
                }else {
                    spinnerMet1.setVisibility(View.INVISIBLE);
                    spinnerMet2.setVisibility(View.INVISIBLE);
                    spinnerPeso1.setVisibility(View.INVISIBLE);
                    spinnerPeso2.setVisibility(View.INVISIBLE);

                    btnCalcular.setEnabled(false);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        spinnerMet1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Button btnCalcular=(Button)findViewById(R.id.button2);
                if (position == 0) {
                    btnCalcular.setEnabled(false);
                }else{
                    btnCalcular.setEnabled(true);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerPeso1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Button btnCalcular=(Button)findViewById(R.id.button2);
                if (position == 0) {
                    btnCalcular.setEnabled(false);
                }else{
                    btnCalcular.setEnabled(true);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





    }//fin on create



    public void calculo(View view) {

        String valor1 = numero1.getText().toString();
        if(valor1.length()==0){
            Toast.makeText(this,"Ingresa un numero",Toast.LENGTH_LONG).show();
        }else {
            double numero1 = Double.parseDouble(valor1);

            String seleccionSpn1 = spinnerMet1.getSelectedItem().toString();
            String seleccionSpn2 = spinnerMet2.getSelectedItem().toString();
            String seleccionSpn3 = spinnerPeso1.getSelectedItem().toString();
            String seleccionSpn4 = spinnerPeso2.getSelectedItem().toString();

     /*   if(valor1.equals("")){
            Toast.makeText(this, "Ingrese un numero",Toast.LENGTH_LONG).show();
        }*/

            if (seleccionSpn1.equals("km")) {
                if (seleccionSpn2.equals("km")) {
                    double conversion = numero1 * 1;
                    Resultado.setText(ndec.format(conversion));
                } else if (seleccionSpn2.equals("mt")) {
                    double conversion = numero1 * 1000;
                    Resultado.setText(ndec.format(conversion));
                } else if (seleccionSpn2.equals("cm")) {
                    double conversion = numero1 * 100000;
                    Resultado.setText(ndec.format(conversion));
                } else if (seleccionSpn2.equals("mm")) {
                    double conversion = numero1 * 1000000;
                    Resultado.setText(ndec.format(conversion));
                } else {
                    Toast.makeText(this, "Seleccione una opcion a convertir", Toast.LENGTH_SHORT).show();
                }

            } else if (seleccionSpn1.equals("mt")) {

                if (seleccionSpn2.equals("km")) {
                    double conversion = numero1 / 1000;
                    Resultado.setText(ndec.format(conversion));
                } else if (seleccionSpn2.equals("mt")) {
                    double conversion = numero1 * 1;
                    Resultado.setText(ndec.format(conversion));
                } else if (seleccionSpn2.equals("cm")) {
                    double conversion = numero1 * 100;
                    Resultado.setText(ndec.format(conversion));
                } else if (seleccionSpn2.equals("mm")) {
                    double conversion = numero1 * 1000;
                    Resultado.setText(ndec.format(conversion));
                } else {
                    Toast.makeText(this, "Seleccione una opcion a convertir", Toast.LENGTH_SHORT).show();
                }
            } else if (seleccionSpn1.equals("cm")) {

                if (seleccionSpn2.equals("km")) {
                    double conversion = numero1 / 100000;
                    Resultado.setText(ndec2.format(conversion));
                } else if (seleccionSpn2.equals("mt")) {
                    double conversion = numero1 / 100;
                    Resultado.setText(ndec.format(conversion));
                } else if (seleccionSpn2.equals("cm")) {
                    double conversion = numero1 * 1;
                    Resultado.setText(ndec.format(conversion));
                } else if (seleccionSpn2.equals("mm")) {
                    double conversion = numero1 * 10;
                    Resultado.setText(ndec.format(conversion));
                } else {
                    Toast.makeText(this, "Seleccione una opcion a convertir", Toast.LENGTH_SHORT).show();
                }
            } else if (seleccionSpn1.equals("mm")) {

                if (seleccionSpn2.equals("km")) {
                    double conversion = numero1 / 1000000;
                    Resultado.setText(ndec2.format(conversion));
                } else if (seleccionSpn2.equals("mt")) {
                    double conversion = numero1 / 1000;
                    Resultado.setText(ndec2.format(conversion));
                } else if (seleccionSpn2.equals("cm")) {
                    double conversion = numero1 / 10;
                    Resultado.setText(ndec.format(conversion));
                } else if (seleccionSpn2.equals("mm")) {
                    double conversion = numero1 * 1;
                    Resultado.setText(ndec.format(conversion));
                } else {
                    Toast.makeText(this, "Seleccione una opcion a convertir", Toast.LENGTH_SHORT).show();
                }
            }


            if (seleccionSpn3.equals("ton")) {
                if (seleccionSpn4.equals("ton")) {
                    double conversion = numero1 * 1;
                    Resultado.setText(ndec.format(conversion));
                } else if (seleccionSpn4.equals("kg")) {
                    double conversion = numero1 * 1000;
                    Resultado.setText(ndec.format(conversion));
                } else if (seleccionSpn4.equals("lb")) {
                    double conversion = numero1 * 2204.6;
                    Resultado.setText(ndec.format(conversion));
                } else if (seleccionSpn4.equals("g")) {
                    double conversion = numero1 * 1000000;
                    Resultado.setText(ndec.format(conversion));
                } else if (seleccionSpn4.equals("mg")) {
                    double conversion = numero1 * 1000000000;
                    Resultado.setText(ndec.format(conversion));
                } else {
                    Toast.makeText(this, "Seleccione una opcion a convertir", Toast.LENGTH_SHORT).show();
                }

            }else if (seleccionSpn3.equals("kg")) {
                if (seleccionSpn4.equals("ton")) {
                    double conversion = numero1/1000;
                    Resultado.setText(ndec2.format(conversion));
                } else if (seleccionSpn4.equals("kg")) {
                    double conversion = numero1 * 1;
                    Resultado.setText(ndec.format(conversion));
                } else if (seleccionSpn4.equals("lb")) {
                    double conversion = numero1 * 2.2046;
                    Resultado.setText(ndec.format(conversion));
                } else if (seleccionSpn4.equals("g")) {
                    double conversion = numero1 * 1000;
                    Resultado.setText(ndec.format(conversion));
                } else if (seleccionSpn4.equals("mg")) {
                    double conversion = numero1 * 1000000;
                    Resultado.setText(ndec.format(conversion));
                } else {
                    Toast.makeText(this, "Seleccione una opcion a convertir", Toast.LENGTH_SHORT).show();
                }

            }else if (seleccionSpn3.equals("lb")) {
                if (seleccionSpn4.equals("ton")) {
                    double conversion = numero1/2204.6;
                    Resultado.setText(ndec2.format(conversion));
                } else if (seleccionSpn4.equals("kg")) {
                    double conversion = numero1/2.2046;
                    Resultado.setText(ndec2.format(conversion));
                } else if (seleccionSpn4.equals("lb")) {
                    double conversion = numero1 * 1;
                    Resultado.setText(ndec.format(conversion));
                } else if (seleccionSpn4.equals("g")) {
                    double conversion = numero1 * 453.59;
                    Resultado.setText(ndec.format(conversion));
                } else if (seleccionSpn4.equals("mg")) {
                    double conversion = numero1 * 453592;                            ;
                    Resultado.setText(ndec.format(conversion));
                } else {
                    Toast.makeText(this, "Seleccione una opcion a convertir", Toast.LENGTH_SHORT).show();
                }

            }else if (seleccionSpn3.equals("g")) {
                if (seleccionSpn4.equals("ton")) {
                    double conversion = numero1/1000000;
                    Resultado.setText(ndec2.format(conversion));
                } else if (seleccionSpn4.equals("kg")) {
                    double conversion = numero1/1000;
                    Resultado.setText(ndec2.format(conversion));
                } else if (seleccionSpn4.equals("lb")) {
                    double conversion = numero1 /453.59;
                    Resultado.setText(ndec.format(conversion));
                } else if (seleccionSpn4.equals("g")) {
                    double conversion = numero1 * 1;
                    Resultado.setText(ndec.format(conversion));
                } else if (seleccionSpn4.equals("mg")) {
                    double conversion = numero1 * 1000;                            ;
                    Resultado.setText(ndec.format(conversion));
                } else {
                    Toast.makeText(this, "Seleccione una opcion a convertir", Toast.LENGTH_SHORT).show();
                }

            }else if (seleccionSpn3.equals("g")) {
                if (seleccionSpn4.equals("ton")) {
                    double conversion = numero1/1000000000;
                    Resultado.setText(ndec2.format(conversion));
                } else if (seleccionSpn4.equals("kg")) {
                    double conversion = numero1/1000000;
                    Resultado.setText(ndec2.format(conversion));
                } else if (seleccionSpn4.equals("lb")) {
                    double conversion = numero1 * 0.0000022046;
                    Resultado.setText(ndec2.format(conversion));
                } else if (seleccionSpn4.equals("g")) {
                    double conversion = numero1 /1000;
                    Resultado.setText(ndec.format(conversion));
                } else if (seleccionSpn4.equals("mg")) {
                    double conversion = numero1 * 1;                            ;
                    Resultado.setText(ndec.format(conversion));
                } else {
                    Toast.makeText(this, "Seleccione una opcion a convertir", Toast.LENGTH_SHORT).show();
                }

            }

        }
    }


}