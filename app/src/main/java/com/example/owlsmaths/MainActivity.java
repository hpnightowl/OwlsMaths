package com.example.owlsmaths;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

    public class MainActivity extends AppCompatActivity {

        private Button zero;
        private Button one;
        private Button two;
        private Button three;
        private Button four;
        private Button five;
        private Button six;
        private Button seven;
        private Button eight;
        private Button nine;
        private Button sum;
        private Button sub;
        private Button mult;
        private Button div;
        private Button dec;
        private Button result;
        private Button clear;
        private Button clearAll;
        private TextView resultadoText;
        private TextView operacionText;
        private double val1;
        private double val2;
        private double resultado;
        private String aux;
        private String[] operacion;
        private char accion;
        private boolean borrado = true;
        private boolean infinito = false;



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            setupUIViews();

            zero.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (borrado) newOp();
                    operacionText.append("0");
                }
            });

            one.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (borrado) newOp();
                    operacionText.append("1");
                }
            });

            two.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (borrado) newOp();
                    operacionText.append("2");
                }
            });

            three.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (borrado) newOp();
                    operacionText.append("3");
                }
            });

            four.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (borrado) newOp();
                    operacionText.append("4");
                }
            });

            five.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (borrado) newOp();
                    operacionText.append("5");
                }
            });

            six.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (borrado) newOp();
                    operacionText.append("6");
                }
            });

            seven.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (borrado) newOp();
                    operacionText.append("7");
                }
            });

            eight.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (borrado) newOp();
                    operacionText.append("8");
                }
            });

            nine.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (borrado) newOp();
                    operacionText.append("9");
                }
            });

            nine.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (borrado) newOp();
                    operacionText.append("9");
                }
            });

            sum.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (accion == 'f') {
                        operacionText.append("+");
                        accion = '+';
                    }
                }
            });

            sub.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (accion == 'f') {
                        operacionText.append("-");
                        accion = '-';
                    }
                }
            });

            mult.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (accion == 'f') {
                        operacionText.append("x");
                        accion = 'x';
                    }
                }
            });

            div.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (accion == 'f') {
                        operacionText.append("÷");
                        accion = '÷';
                    }
                }
            });

            dec.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (accion == 'f') {
                        operacionText.append(".");
                    }
                }
            });

            clear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (operacionText.getText().length() > 0){
                        CharSequence name = operacionText.getText().toString();
                        operacionText.setText(name.subSequence(0, name.length() - 1));
                    }
                }
            });

            clearAll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    operacionText.setText("");
                    resultadoText.setText("");
                    accion = '_';
                }
            });

            result.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (operacionText.getText().length() > 1)
                        Calcular();
                }
            });

        }

        private void setupUIViews() {
            zero = findViewById(R.id.bt0);
            one = findViewById(R.id.bt1);
            two = findViewById(R.id.bt2);
            three = findViewById(R.id.bt3);
            four = findViewById(R.id.bt4);
            five = findViewById(R.id.bt5);
            six = findViewById(R.id.bt6);
            seven = findViewById(R.id.bt7);
            eight = findViewById(R.id.bt8);
            nine = findViewById(R.id.bt9);
            sum = findViewById(R.id.btplus);
            sub = findViewById(R.id.btsub);
            mult = findViewById(R.id.btmulti);
            div = findViewById(R.id.btdiv);
            dec = findViewById(R.id.btdot);
            result = findViewById(R.id.btequal);
            clear = findViewById(R.id.btClear);
            clearAll = findViewById(R.id.btAllClear);
            resultadoText = findViewById(R.id.resText);
            operacionText = findViewById(R.id.opText);
        }

        private void Calcular() {
            switch (accion) {
                case '+':
                    aux = operacionText.getText().toString().replace("+", " +");
                    operacion = aux.split(" +");
                    val1 = Double.parseDouble(operacion[0]);
                    val2 = Double.parseDouble(operacion[1]);
                    resultado = val1 + val2;
                    break;

                case '-':
                    operacion = operacionText.getText().toString().split("-");
                    val1 = Double.parseDouble(operacion[0]);
                    val2 = Double.parseDouble(operacion[1]);
                    resultado = val1 - val2;
                    break;

                case 'x':
                    operacion = operacionText.getText().toString().split("x");
                    val1 = Double.parseDouble(operacion[0]);
                    val2 = Double.parseDouble(operacion[1]);
                    resultado = val1 * val2;
                    break;

                case '÷':
                    operacion = operacionText.getText().toString().split("÷");
                    val1 = Double.parseDouble(operacion[0]);
                    val2 = Double.parseDouble(operacion[1]);
                    if (val2 > 0) resultado = val1 / val2;
                    else infinito = true;
                    break;
            }
            borrado = true;
            if (!infinito)
                resultadoText.setText(Double.toString(resultado));
            else {
                resultadoText.setText("∞");
                infinito = false;
            }
        }

        private void newOp(){
            accion = 'f';
            borrado = false;
            operacionText.setText("");
            resultadoText.setText("");
        }
    }

