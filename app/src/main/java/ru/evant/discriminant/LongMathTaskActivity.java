package ru.evant.discriminant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LongMathTaskActivity extends AppCompatActivity {

    TextView tvResultL;
    EditText edInputL;
    Button btnResultL;

    String str;
    char[] tokens;
    int pos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_long_math_task);

        init();
    }

    private void init() {
        tvResultL = (TextView) findViewById(R.id.tvResultL);
        edInputL = (EditText) findViewById(R.id.edInputL);
        btnResultL = (Button) findViewById(R.id.btnResultL);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnResultL:
                str = edInputL.getText().toString();
                tokens = str.toCharArray();
                pos = 0;

                double result = parse();
                tvResultL.setText("Результат: " + String.valueOf(result));
                break;
            default:
                break;
        }
    }

    private double parse() {
        double first = multyplay();

        while (pos < tokens.length) {
            String op = String.valueOf(tokens[pos]);
            String operator = op;
            if (!operator.equals("+") && !operator.equals("-")) {
                break;
            } else {
                pos++;
            }

            double second = multyplay();
            if (operator.equals("+")) {
                first += second;
            } else {
                first -= second;
            }
        }

        return first;
    }

    private double multyplay() {
        double first = factor();

        while (pos < tokens.length) {
            String op = String.valueOf(tokens[pos]);
            String operator = op;
            if (!operator.equals("*") && !operator.equals("/")) {
                break;
            } else {
                pos++;
            }

            double second = multyplay();
            if (operator.equals("*")) {
                first *= second;
            } else {
                first /= second;
            }
        }

        return first;
    }

    private double factor() {
        String op = String.valueOf(tokens[pos]);
        String next = op;
        double result;

        if (next.equals("(")) {
            pos++;
            result = parse();
            String closingBracket;
            if (pos < tokens.length) {
                String op2 = String.valueOf(tokens[pos]);
                closingBracket = op2;
            } else {
                throw new IllegalArgumentException("Неожиданный конец выражения!");
            }
            if (closingBracket.equals(")")) {
                pos++;
                return result;
            }
            throw new IllegalArgumentException("')' ожидаемый символ" + closingBracket + " не найден");
        }
        pos++;
        return Double.parseDouble(next);
    }
}