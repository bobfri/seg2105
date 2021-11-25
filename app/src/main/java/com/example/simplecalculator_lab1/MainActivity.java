package com.example.simplecalculator_lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * The type Main activity.
 *
 * @author Charles Choiniere, Thomas Knox, Jaleelah Ammar
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity {
    /**
     * The Button 0.
     */
    Button btn0,
    /**
     * The Button 1.
     */
    btn1,
    /**
     * The Button 2.
     */
    btn2,
    /**
     * The Button 3.
     */
    btn3,
    /**
     * The Button 4.
     */
    btn4,
    /**
     * The Button 5.
     */
    btn5,
    /**
     * The Button 6.
     */
    btn6,
    /**
     * The Button 7.
     */
    btn7,
    /**
     * The Button 8.
     */
    btn8,
    /**
     * The Button 9.
     */
    btn9,
    /**
     * The Button plus.
     */
    btnPlus,
    /**
     * The Button minus.
     */
    btnMinus,
    /**
     * The Button times.
     */
    btnMult,
    /**
     * The Button decimal.
     */
    btnDec,
    /**
     * The Button divide.
     */
    btnDiv,
    /**
     * The Button clear.
     */
    btnClr,
    /**
     * The Button equal.
     */
    btnEql,
    /**
     * The Button negative.
     */
    btnNeg;

    /**
     * The Display.
     */
    TextView display;

    /**
     * The Val 1.
     */
    Double val1,
    /**
     * The Val 2.
     */
    val2;

    /**
     * The Clr result.
     */
    Boolean clr_result=false;

    /**
     * The enum Operator.
     */
    enum Operator{
        /**
         * None operator.
         */
        none,
        /**
         * Add operator.
         */
        add,
        /**
         * Subtract operator.
         */
        sub,
        /**
         * Multiply operator.
         */
        mul,
        /**
         * Divide operator.
         */
        div}

    /**
     * The Operator to execute next.
     */
    Operator optr = Operator.none;

    /**
     * when state is created, the view is switch to activity_main.xml,
     * all Button are link to there on screen button as well as the TextView is linked to the textview of the display.
     * @param savedInstanceState takes in the saved value of state.
     */
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
        btn0.setOnClickListener(new ButtonClick(0));
        //adds one to the screen
        btn1.setOnClickListener(new ButtonClick(1));
        //adds two to the screen
        btn2.setOnClickListener(new ButtonClick(2));
        //adds three to the screen
        btn3.setOnClickListener(new ButtonClick(3));
        //adds four to the screen
        btn4.setOnClickListener(new ButtonClick(4));
        //adds five to the screen
        btn5.setOnClickListener(new ButtonClick(5));
        //adds six to the screen
        btn6.setOnClickListener(new ButtonClick(6));
        //adds seven to the screen
        btn7.setOnClickListener(new ButtonClick(7));
        //adds eight to the screen
        btn8.setOnClickListener(new ButtonClick(8));
        //adds nine to the screen
        btn9.setOnClickListener(new ButtonClick(9));
        //adds decimal to the screen
        btnDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addDote();
            }
        });
        //toggles negative to the screen
        btnNeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNeg();
            }
        });
        //clears the screen then the operation selected
        btnClr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(optr!=Operator.none){
                    if(display.getText()==""){
                        optr=Operator.none;
                        flipColor(0);
                    }
                }
                else{
                    val1=null;
                    flipColor(0);
                }
                display.setText("");

            }
        });
        //execute last operation needed. then prepares for addion
        btnPlus.setOnClickListener(new OperatorClick(5, Operator.add));
        //execute last operation needed. then prepares for subtraction
        btnMinus.setOnClickListener(new OperatorClick(4, Operator.sub));
        //execute last operation needed. then prepares for multiplication
        btnMult.setOnClickListener(new OperatorClick(3, Operator.mul));
        //execute last operation needed. then prepares for division
        btnDiv.setOnClickListener(new OperatorClick(2, Operator.div));
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
                flipColor(1);
                optr = Operator.none;
                clr_result=true;
            }


        });
    }

    /**
     * toggles the negative on the display
     */
    private void addNeg() {
        if (clr_result) {
            display.setText("");
            clr_result = false;
        }
        //toggle negative
        String s = display.getText().toString();
        s = (s.indexOf("-") ==0) ? s.replaceAll("-","") : "-"+s;
        display.setText(s);
    }

    /**
     * adds a dot on the display.
     */
    private void addDote() {
        if(clr_result){
            display.setText("");
            clr_result=false;
        }
        display.setText(display.getText() + ".");
    }

    /**
     * changes the color of the operation button clicked.
     * takes in an int corresponding to operator: 1 = Equal, 2 = Divide, 3 = Multiply, 4 = Minus, 5 = Plus.
     * @param i takes in an int corresponding to a operator.
     */
    private void flipColor(int i) {
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

    /**
     *  will execute the operation stored in {@link MainActivity#optr}
     * @return value of executed operation. returns null if it fails.
     */
    private Double Execute() {
        if(!clr_result) {
            try {
                val2 = Double.parseDouble(display.getText().toString());
            }catch (Exception e){
                display.setText("Invalid Syntax");
                return null;
            }
        }
        try {
            switch (optr) {
                case add:
                    return add();
                case sub:
                    return sub();
                case mul:
                    return mul();
                case div:
                    return div();
                default:
                    break;


            }
        }catch (Exception e){
            display.setText("Math Error");
            return null;
        }
        return null;
    }

    /**
     * add the value of {@link MainActivity#val1} and {@link MainActivity#val2} together
     * {@link MainActivity#val1} will then be set to the result of the operation
     * @return the addition of both value
     */
    private Double add() {
        val1 += val2;
        return val1;
    }
    /**
     * substracte the value of {@link MainActivity#val1} by {@link MainActivity#val2}
     * {@link MainActivity#val1} will then be set to the result of the operation
     * @return the result of subtraction
     */
    private Double sub() {

        val1 -= val2;
        return val1;

    }
    /**
     * multiply value of {@link MainActivity#val1} and {@link MainActivity#val2}
     * {@link MainActivity#val1} will then be set to the result of the operation
     * @return the result of the multiplication
     */
    private Double mul() {
        val1 = val1 * val2;
        return val1;

    }
    /**
     * divide the value of {@link MainActivity#val1} by {@link MainActivity#val2}
     * {@link MainActivity#val1} will then be set to the result of the operation
     * @return the result of the division
     */
    private Double div() {
        val1 = val1 / val2;
        return val1;
    }

    /**
     * OnClickListener implementation to be used with the numbers button.
     */
    class ButtonClick implements View.OnClickListener{
        /**
         * The Number on the button.
         */
        int num;

        /**
         * Constructor of the onClickListener
         *
         * @param num the value to add to display when click is detected
         */
        public ButtonClick(int num) {
            this.num = num;
        }

        /**
         * if {@link MainActivity#clr_result} is true then the {@link MainActivity#display} text is removed and replace with the value of {@link ButtonClick#num}
         * else the {@link MainActivity#display} will have value of {@link ButtonClick#num} added at the end of the string
         * @param view takes in a View parameter
         */
        @Override
        public void onClick(View view) {
            if(clr_result){
                display.setText("");
                clr_result=false;
            }
            display.setText(display.getText()+String.valueOf(num));
        }
    }

    /**
     * OnClickListener implementation to be used with the operator buttons.
     */
    class OperatorClick implements View.OnClickListener{
        /**
         * then number to sent when calling {@link MainActivity#flipColor(int)}
         */
        int i;
        /**
         * The Operator on the button.
         */
        Operator optr_;


        /**
         * Constructor of the onClickListener
         *
         * @param i     the number to use on the filpColor call
         * @param optr_ Operator value that would be set on the click
         */
        public OperatorClick(int i, Operator optr_) {
            this.i = i;
            this.optr_ = optr_;
        }

        /**
         * will execute the last operation called, set {@link OperatorClick#optr_} to {@link MainActivity#optr}, call {@link MainActivity#flipColor(int)}, and finaly will set {@link MainActivity#clr_result} as true
         * @param view
         */
        @Override
        public void onClick(View view) {
            if(optr!=Operator.none&&display.getText()!=""){
                Execute();
                String s=val1.toString();
                s = s.indexOf(".") < 0 ? s : s.replaceAll("0*$", "").replaceAll("\\.$", "");
                display.setText(s);

            }

            flipColor(i);
            optr = optr_;
            if(display.getText()!=""){
                try {
                    val1 = Double.parseDouble(display.getText().toString());
                }catch (Exception e){
                    display.setText("Invalid Syntax");
                    optr = Operator.none;
                    flipColor(0);
                }
            }else{
                optr = Operator.none;
                flipColor(0);
            }
            clr_result=true;
        }
    }
}