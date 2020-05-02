package br.pro.hashi.ensino.desagil.projeto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        Button buttonTelaTraduz = findViewById(R.id.button_telatraduz);
        Button buttonDicMorse = findViewById(R.id.button_dicmorse_char);

        Intent traduz = new Intent(this, TelaInicial.class);

        Intent dicMorse = new Intent(this, DicionarioMorse.class);

        buttonTelaTraduz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(traduz);
            }
        });

        buttonDicMorse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



    }
}
