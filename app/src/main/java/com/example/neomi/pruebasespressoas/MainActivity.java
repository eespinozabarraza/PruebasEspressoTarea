package com.example.neomi.pruebasespressoas;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button verificar, limpiar;
    EditText lado1,lado2, lado3;
    TextView tipo;
    String catA,catB,catC,tipoTriangulo;
    AlertDialog.Builder dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        verificar =(Button) findViewById(R.id.verBtn);
        limpiar = (Button)findViewById(R.id.cleanBtn);
        lado1 = (EditText)findViewById(R.id.lado1);
        lado2 = (EditText)findViewById(R.id.lado2);
        lado3 = (EditText)findViewById(R.id.lado3);
        tipo = (TextView)findViewById(R.id.tipo);

        limpiar.setEnabled(false);

        verificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                catA = lado1.getText().toString();
                catB = lado2.getText().toString();
                catC = lado3.getText().toString();

                if (catA.length() == 0){
                    dialog = new AlertDialog.Builder(MainActivity.this);
                    dialog.setTitle("Error");
                    dialog.setMessage("Ingresar el valor del Primer Lado");
                    dialog.setCancelable(false);
                    dialog.setPositiveButton("Cerrar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                            lado1.requestFocus();
                        }
                    });
                    dialog.show();
                }else{
                    if (catB.length()==0){
                        dialog = new AlertDialog.Builder(MainActivity.this);
                        dialog.setTitle("Error");
                        dialog.setMessage("Ingresar el valor del Segundo Lado");
                        dialog.setCancelable(false);
                        dialog.setPositiveButton("Cerrar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                lado2.requestFocus();
                            }
                        });
                        dialog.show();
                    }else{
                        if(catC.length()==0){
                            dialog = new AlertDialog.Builder(MainActivity.this);
                            dialog.setTitle("Error");
                            dialog.setMessage("Ingresar el valor del Tercer Lado");
                            dialog.setCancelable(false);
                            dialog.setPositiveButton("Cerrar", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                    lado3.requestFocus();
                                }
                            });
                            dialog.show();
                        }else{
                            double a =Double.parseDouble(catA);
                            double b =Double.parseDouble(catB);
                            double c =Double.parseDouble(catC);
                            if((a+b)>c && (a+c)> b && (b+c)>a){
                                if(a==b && b==c){
                                    tipoTriangulo = "es Equilatero";
                                }else if(a==b || b == c || c == a){
                                    tipoTriangulo = "es Isosceles";
                                }else{
                                    tipoTriangulo = "es Escaleno";
                                }

                            }else{
                                tipoTriangulo = "no se puede construir";
                            }
                            tipo.setText("El triangulo " + tipoTriangulo);
                            limpiar.setEnabled(true);
                            verificar.setEnabled(false);


                        }
                    }
                }

            }
        });
        limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiar_todo();
            }
        });
    }
    public void limpiar_todo(){
        lado1.setText("");
        lado2.setText("");
        lado3.setText("");
        tipo.setText("");
        limpiar.setEnabled(false);
        verificar.setEnabled(true);
    }
}
