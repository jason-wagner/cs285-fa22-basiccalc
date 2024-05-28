package edu.wilkes.mathcs.wagner.basiccalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {
    TextView inputTV;
    TextView resultTV;

    String input = "";

    boolean parenOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputTV = (TextView) findViewById(R.id.inputTextView);
        resultTV = (TextView) findViewById(R.id.resultTextView);
        parenOpen = false;
    }

    private void setInputString(String value) {
        input += value;
        inputTV.setText(input);
    }

    public void zeroOnClick(View view) {
        setInputString("0");
    }

    public void oneOnClick(View view) {
        setInputString("1");
    }

    public void twoOnClick(View view) {
        setInputString("2");
    }

    public void threeOnClick(View view) {
        setInputString("3");
    }

    public void fourOnClick(View view) {
        setInputString("4");
    }

    public void fiveOnClick(View view) {
        setInputString("5");
    }

    public void sixOnClick(View view) {
        setInputString("6");
    }

    public void sevenOnClick(View view) {
        setInputString("7");
    }

    public void eightOnClick(View view) {
        setInputString("8");
    }

    public void nineOnClick(View view) {
        setInputString("9");
    }

    public void addOnClick(View view) {
        setInputString("+");
    }

    public void subtractOnClick(View view) {
        setInputString("-");
    }

    public void decimalOnClick(View view) {
        setInputString(".");
    }

    public void multiplyOnClick(View view) {
        setInputString("*");
    }

    public void divideOnClick(View view) {
        setInputString("/");
    }

    public void equalsOnClick(View view) {
        Double result = null;

        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");

        try {
            result = (double) engine.eval(input);
        } catch (ScriptException e) {
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
        }

        if(result != null) {
            resultTV.setText(String.valueOf(result.doubleValue()));
        }
    }

    public void clearOnClick(View view) {
        input = "";
        inputTV.setText("");
        resultTV.setText("");
        parenOpen = false;
    }

    public void parenOnClick(View view) {
        if(parenOpen) {
            setInputString(")");
            parenOpen = false;
        } else {
            setInputString("(");
            parenOpen = true;
        }
    }

    public void powerOnClick(View view) {
        setInputString("");
    }
}