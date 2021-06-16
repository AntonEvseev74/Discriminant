package ru.evant.discriminant;

/*
    Решение квадратного уравнения.
            ax²+bx+c=0
    Как найти дискриминант:
            D=b²-4ac
    Корни уравнения:
        > если D<0 - уравнение не имеет корней (нет решений)
        > если D=0 - уравнение имеет 1 корень:
                x=-b²/2a
        > если D>0 - уравнение имеет 2 корня:
                x1=(-b+√D)/(2a)
                x2=(-b-√D)/(2a)
 */

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvResult;
    EditText edA, edB, edC;
    Button btnResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        tvResult = (TextView) findViewById(R.id.tvResult);
        edA = (EditText) findViewById(R.id.edA);
        edB = (EditText) findViewById(R.id.edB);
        edC = (EditText) findViewById(R.id.edC);
        btnResult = (Button) findViewById(R.id.btnResult);
    }

    public void onClick(View view) {
        calculate();
    }

    private void calculate() {
        double a = 1;
        double b = 1;
        double c = 0;
        double d;
        double x;
        double x1;
        double x2;

        if (edA.getText().toString().trim().length() != 0){
            a = Integer.parseInt(edA.getText().toString());
        } // если поле edA не пустое присваиваем переменной "a" значение полученное из поля edA

        if (edB.getText().toString().trim().length() != 0){
            b = Integer.parseInt(edB.getText().toString());
        } // если поле edB не пустое присваиваем переменной "b" значение полученное из поля edB

        if (edC.getText().toString().trim().length() != 0){
            c = Integer.parseInt(edC.getText().toString());
        } // если поле edC не пустое присваиваем переменной "c" значение полученное из поля edC

        d = Math.pow(b,2) - 4 * a * c;

        if(d < 0) tvResult.setText("D = " + d + "\nНет решений!");
        if(d == 0 && a != 0) {
            x = -b / 2*a;
            tvResult.setText("D = " + d + "\nx = " + x);
        }
        if (d > 0 && a != 0){
            x1 = (-b - Math.sqrt(d)) / (2 * a);
            x2 = (-b + Math.sqrt(d)) / (2 * a);
            tvResult.setText("D = " + d + "\nx1 = " + x1 + "\nx2 = " + x2);
        }
    }
}