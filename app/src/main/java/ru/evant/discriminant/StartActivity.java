package ru.evant.discriminant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    Button btnDiscriminant, btnLongMathTask;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        init();

    }

    private void init() {
        btnDiscriminant = (Button)findViewById(R.id.btnDiscriminant);
        btnLongMathTask = (Button)findViewById(R.id.btnLongMathTask);
    }


    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnDiscriminant:
                intent = new Intent(this, DiscriminantActivity.class);
                startActivity(intent);
                break;
            case R.id.btnLongMathTask:
                intent = new Intent(this, LongMathTaskActivity.class);
                startActivity(intent);
                break;
            default:break;
        }
    }
}