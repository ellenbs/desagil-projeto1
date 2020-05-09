package br.pro.hashi.ensino.desagil.projeto1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Frases extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frases);

        TextView fome = findViewById(R.id.mensagem_fome);
        TextView sede = findViewById(R.id.mensagem_sede);
        TextView dor = findViewById(R.id.mensagem_dor);
        TextView banheiro = findViewById(R.id.mensagem_banheiro);

        fome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fome.setTextColor(Color.parseColor("#6200ee"));
                sede.setTextColor(Color.parseColor("#aaaaaa"));
                dor.setTextColor(Color.parseColor("#aaaaaa"));
                banheiro.setTextColor(Color.parseColor("#aaaaaa"));
            }
        });

        sede.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fome.setTextColor(Color.parseColor("#aaaaaa"));
                sede.setTextColor(Color.parseColor("#6200ee"));
                dor.setTextColor(Color.parseColor("#aaaaaa"));
                banheiro.setTextColor(Color.parseColor("#aaaaaa"));
            }
        });
        dor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fome.setTextColor(Color.parseColor("#aaaaaa"));
                sede.setTextColor(Color.parseColor("#aaaaaa"));
                dor.setTextColor(Color.parseColor("#6200ee"));
                banheiro.setTextColor(Color.parseColor("#aaaaaa"));
            }
        });
        banheiro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fome.setTextColor(Color.parseColor("#aaaaaa"));
                sede.setTextColor(Color.parseColor("#aaaaaa"));
                dor.setTextColor(Color.parseColor("#aaaaaa"));
                banheiro.setTextColor(Color.parseColor("#6200ee"));
            }
        });
    }
}

