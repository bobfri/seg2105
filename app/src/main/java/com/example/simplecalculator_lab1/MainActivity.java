package com.example.simplecalculator_lab1;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnPlus, btnMinus, btnMult, btnDec, btnDiv, btnClr, btnEql, btnNeg;

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
        btnNeg = findViewById(R.id.btnNeg);
        display = findViewById(R.id.displayNum);

        //adds zero to the screen
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
        //adds one to the screen
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
        //adds two to the screen
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
        //adds three to the screen
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
        //adds four to the screen
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
        //adds five to the screen
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
        //adds six to the screen
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
        //adds seven to the screen
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
        //adds eight to the screen
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
        //adds nine to the screen
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
        //adds decimal to the screen
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
        //toggles negative to the screen
        btnNeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clr_result) {
                    display.setText("");
                    clr_result = false;
               }
                //toggle negative
                String s = display.getText().toString();
                s = (s.indexOf("-") ==0) ? s.replaceAll("-","") : "-"+s;
                display.setText(s);

            }
        });
        //clears the screen then the operation selected
        btnClr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(optr!=Operator.none){
                    if(display.getText()==""){
                        optr=Operator.none;
                        flipcolor(0);
                    }
                }
                else{
                    val1=null;
                    flipcolor(0);
                }
                display.setText("");

            }
        });
        //execute last operation needed. then prepares for addion
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(optr!=Operator.none&&display.getText()!=""){
                    Execute();
                    String s=val1.toString();
                    s = s.indexOf(".") < 0 ? s : s.replaceAll("0*$", "").replaceAll("\\.$", "");
                    display.setText(s);

                }
                flipcolor(5);
                optr = Operator.add;
                if(display.getText()!=""){
                    try {
                        val1 = Double.parseDouble(display.getText().toString());
                    }catch (Exception e){
                        display.setText("Invalid Syntax");
                        optr = Operator.none;
                        flipcolor(0);
                    }
                }else{
                    optr = Operator.none;
                    flipcolor(0);
                }
                clr_result=true;
            }
        });
        //execute last operation needed. then prepares for subtraction
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(optr!=Operator.none&&display.getText()!=""){
                    Execute();
                    String s=val1.toString();
                    s = s.indexOf(".") < 0 ? s : s.replaceAll("0*$", "").replaceAll("\\.$", "");
                    display.setText(s);

                }

                flipcolor(4);
                optr = Operator.sub;
                if(display.getText()!=""){
                    try {
                        val1 = Double.parseDouble(display.getText().toString());
                    }catch (Exception e){
                        display.setText("Invalid Syntax");
                        optr = Operator.none;
                        flipcolor(0);
                    }
                }else{
                    optr = Operator.none;
                    flipcolor(0);
                }
                clr_result=true;

            }
        });
        //execute last operation needed. then prepares for multiplication
        btnMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(optr!=Operator.none&&display.getText()!=""){
                    Execute();
                    String s=val1.toString();
                    s = s.indexOf(".") < 0 ? s : s.replaceAll("0*$", "").replaceAll("\\.$", "");
                    display.setText(s);
                }
                optr = Operator.mul;
                flipcolor(3);
                if(display.getText()!=""){
                    try {
                        val1 = Double.parseDouble(display.getText().toString());
                    }catch (Exception e){
                        display.setText("Invalid Syntax");
                        optr = Operator.none;
                        flipcolor(0);
                    }
                }else{
                    optr = Operator.none;
                    flipcolor(0);
                }
                clr_result=true;
            }
        });
        //execute last operation needed. then prepares for division
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(optr!=Operator.none&&display.getText()!=""){
                    Execute();
                    String s=val1.toString();
                    s = s.indexOf(".") < 0 ? s : s.replaceAll("0*$", "").replaceAll("\\.$", "");
                    display.setText(s);
                }
                optr = Operator.div;
                flipcolor(2);
                if(display.getText()!=""){
                    try {
                        val1 = Double.parseDouble(display.getText().toString());
                    }catch (Exception e){
                        display.setText("Invalid Syntax");
                        optr = Operator.none;
                        flipcolor(0);
                    }
                }else{
                    optr = Operator.none;
                    flipcolor(0);
                }
                clr_result=true;
            }
        });
        //execute last operation
        btnEql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(optr!=Operator.none&&display.getText()!=""){
                    Execute();
                    String s=val1.toString();

                    s = s.indexOf(".") < 0 ? s : s.replaceAll("0*$", "").replaceAll("\\.$", "");
                    //if result is "-0"
                    s = s.indexOf("-") ==0 && s.length() == 2 && s.indexOf("0") ==1 ? s.replaceAll("-","") : s;
                    display.setText(s);

                    val1 = Double.parseDouble(display.getText().toString());
                }
                flipcolor(1);
                optr = Operator.none;
                clr_result=true;
            }


        });
    }
    //toggle the color of the button of the operation selected
    private void flipcolor(int i) {
        btnEql.setBackgroundColor(Color.parseColor("#FF6200EE"));
        btnDiv.setBackgroundColor(Color.parseColor("#FF6200EE"));
        btnMult.setBackgroundColor(Color.parseColor("#FF6200EE"));
        btnMinus.setBackgroundColor(Color.parseColor("#FF6200EE"));
        btnPlus.setBackgroundColor(Color.parseColor("#FF6200EE"));
        switch (i){
            case 1:btnEql.setBackgroundColor(Color.parseColor("#FFBB86FC"));
                break;
            case 2: btnDiv.setBackgroundColor(Color.parseColor("#FFBB86FC"));
                break;
            case 3:btnMult.setBackgroundColor(Color.parseColor("#FFBB86FC"));
                break;
            case 4:btnMinus.setBackgroundColor(Color.parseColor("#FFBB86FC"));
                break;
            case 5:btnPlus.setBackgroundColor(Color.parseColor("#FFBB86FC"));
                break;
            default:
                break;
        }
    }
    //execute the math operation.
    private void Execute() {
        if(!clr_result) {
            try {
                val2 = Double.parseDouble(display.getText().toString());
            }catch (Exception e){
                display.setText("Invalid Syntax");
            }
        }
        try {
            switch (optr) {
                case add:
                    val1 += val2;
                    break;
                case sub:
                    val1 -= val2;
                    break;
                case mul:
                    val1 = val1 * val2;
                    break;
                case div:
                    val1 = val1 / val2;
                    break;
                default:
                    break;

            }
        }catch (Exception e){
            display.setText("Math Error");
        }
    }
}