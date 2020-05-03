package br.pro.hashi.ensino.desagil.projeto1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.LinkedList;

public class DicionarioMorse extends AppCompatActivity {

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_dicionario_morse);
            Translator tradutor = new Translator();
            LinkedList<String> lista = new LinkedList<>();
            lista = tradutor.getCodes();
            for (int i = 0; i < (lista.size()); i++){
                TextView alguma = findViewById(R.id.sera);
            }
        }

}

