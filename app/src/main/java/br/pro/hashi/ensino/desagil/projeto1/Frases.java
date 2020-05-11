package br.pro.hashi.ensino.desagil.projeto1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Frases extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frases);

        Button fome = findViewById(R.id.mensagem_fome);
        Button sede = findViewById(R.id.mensagem_sede);
        Button dor = findViewById(R.id.mensagem_dor);
        Button banheiro = findViewById(R.id.mensagem_banheiro);
        TextView mensagem = findViewById(R.id.mensagem);

        fome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mensagem.setText("Estou com fome");
                fome.setTextColor(Color.parseColor("#6200ee"));
                sede.setTextColor(Color.parseColor("#aaaaaa"));
                dor.setTextColor(Color.parseColor("#aaaaaa"));
                banheiro.setTextColor(Color.parseColor("#aaaaaa"));
            }
        });

        sede.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mensagem.setText("Estou com sede");
                fome.setTextColor(Color.parseColor("#aaaaaa"));
                sede.setTextColor(Color.parseColor("#6200ee"));
                dor.setTextColor(Color.parseColor("#aaaaaa"));
                banheiro.setTextColor(Color.parseColor("#aaaaaa"));
            }
        });
        dor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mensagem.setText("Estou com dor");
                fome.setTextColor(Color.parseColor("#aaaaaa"));
                sede.setTextColor(Color.parseColor("#aaaaaa"));
                dor.setTextColor(Color.parseColor("#6200ee"));
                banheiro.setTextColor(Color.parseColor("#aaaaaa"));
            }
        });
        banheiro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mensagem.setText("Quero ir ao banheiro");
                fome.setTextColor(Color.parseColor("#aaaaaa"));
                sede.setTextColor(Color.parseColor("#aaaaaa"));
                dor.setTextColor(Color.parseColor("#aaaaaa"));
                banheiro.setTextColor(Color.parseColor("#6200ee"));
            }
        });
    }
}

