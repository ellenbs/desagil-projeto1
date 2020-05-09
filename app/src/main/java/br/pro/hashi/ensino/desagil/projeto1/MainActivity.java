package br.pro.hashi.ensino.desagil.projeto1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonDicMorse = findViewById(R.id.button_dicmorse_char);
        Button buttonDicAlfa = findViewById(R.id.button_dicchar_morse);
        Button buttonTelaTraduz = findViewById(R.id.button_telatraduz);
        Button buttonSMS = findViewById(R.id.button_sms);
        Button buttonFrases = findViewById(R.id.button_frases);

        Intent dicMorse = new Intent(this, DicionarioMorse.class);

        Intent dicAlfa = new Intent(this, DicionarioAlfabeto.class);

        Intent traduz = new Intent(this, TelaInicial.class);

        Intent sms = new Intent(this, Permissao.class);

        Intent frase = new Intent(this, Frases.class);


        buttonTelaTraduz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(traduz);
            }
        });

        buttonDicMorse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { startActivity(dicMorse);

            }
        });

        buttonSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { startActivity(sms);

            }
        });

        buttonFrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { startActivity(frase);

            }
        });

        buttonDicAlfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { startActivity(dicAlfa);

            }
        });
    }
}
