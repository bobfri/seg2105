package com.example.simplecalculator_lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnPlus, btnMinus, btnMult, btnDec, btnDiv, btnClr, btnEql;

    TextView display;

    Double val1, val2;

    Boolean clr_result=false;
    enum Operator{none, add, sub, mul, div}
    Operator optr = Operator.none;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnMult = findViewById(R.id.btnMult);
        btnDec = findViewById(R.id.btnDec);
        btnDiv = findViewById(R.id.btnDiv);
        btnClr = findViewById(R.id.btnClr);
        btnEql = findViewById(R.id.btnEql);
        display = findViewById(R.id.displayNum);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(clr_result){
                    display.setText("");
                    clr_result=false;
                }
                display.setText(display.getText()+"0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(clr_result){
                    display.setText("");
                    clr_result=false;
                }
                display.setText(display.getText()+"1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(clr_result){
                    display.setText("");
                    clr_result=false;
                }
                display.setText(display.getText()+"2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(clr_result){
                    display.setText("");
                    clr_result=false;
                }
                display.setText(display.getText()+"3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(clr_result){
                    display.setText("");
                    clr_result=false;
                }
                display.setText(display.getText()+"4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(clr_result){
                    display.setText("");
                    clr_result=false;
                }
                display.setText(display.getText()+"5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(clr_result){
                    display.setText("");
                    clr_result=false;
                }
                display.setText(display.getText()+"6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(clr_result){
                    display.setText("");
                    clr_result=false;
                }
                display.setText(display.getText()+"7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(clr_result){
                    display.setText("");
                    clr_result=false;
                }
                display.setText(display.getText()+"8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(clr_result){
                    display.setText("");
                    clr_result=false;
                }
                display.setText(display.getText()+"9");
            }
        });
        btnDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(clr_result){
                    display.setText("");
                    clr_result=false;
                }
                display.setText(display.getText() + ".");
            }
        });
        btnClr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(optr!=Operator.none){
                    if(display.getText()==""){
                        optr=Operator.none;
                    }
                }
                else{
                    val1=null;
                }
                display.setText("");
            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(optr!=Operator.none){
                    Execute();
                    display.setText(val1.toString());

                }
                optr = Operator.add;
                val1 = Double.parseDouble(display.getText().toString());
                clr_result=true;
            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(optr!=Operator.none){
                    Execute();
                    display.setText(val1.toString());

                }
                optr = Operator.add;
                val1 = Double.parseDouble(display.getText().toString());
                clr_result=true;
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(optr!=Operator.none){
                    Execute();
                    display.setText(val1.toString());

                }
                optr = Operator.sub;
                val1 = Double.parseDouble(display.getText().toString());
                clr_result=true;
            }
        });
        btnMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(optr!=Operator.none){
                    Execute();
                    display.setText(val1.toString());

                }
                optr = Operator.mul;
                val1 = Double.parseDouble(display.getText().toString());
                clr_result=true;
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(optr!=Operator.none){
                    Execute();
                    display.setText(val1.toString());

                }
                optr = Operator.div;
                val1 = Double.parseDouble(display.getText().toString());
                clr_result=true;
            }
        });
        btnEql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(optr!=Operator.none){
                    Execute();
                    display.setText(val1.toString());

                }
                optr = Operator.none;
                val1 = Double.parseDouble(display.getText().toString());
                clr_result=true;
            }


        });
    }

    private void Execute() {
        val2 = Double.parseDouble(display.getText().toString());
        switch (optr){
            case add: val1 += val2;
                break;
            case sub: val1 -= val2;
                break;
            case mul: val1 = val1*val2;
                break;
            case div: val1 = val1/val2;
                break;
            default: break;

        }
    }
}