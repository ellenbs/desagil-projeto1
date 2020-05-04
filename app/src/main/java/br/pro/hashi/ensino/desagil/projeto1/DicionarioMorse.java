package br.pro.hashi.ensino.desagil.projeto1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.LinkedList;

public class DicionarioMorse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dicionario_morse);
        Translator tradutor = new Translator();
        LinkedList<String> lista_codigo = new LinkedList<>();
        LinkedList<Character> lista_alfabeto = new LinkedList<>();
        lista_codigo = tradutor.getCodes();

        for (String codigo: lista_codigo){
            Character t;
            t = tradutor.morseToChar(codigo);
            lista_alfabeto.add(t);
        }



        for (int i = 0; i < (lista_codigo.size()); i++){
            TableLayout tableLayout =  (TableLayout) findViewById(R.id.tablelayout);
            TableRow tablerow = new TableRow(this);
            TextView textViewUm = new TextView(this);
            TextView textViewDois = new TextView(this);
            textViewUm.setTextSize(65);
            textViewUm.setPadding(50,0,0,0);
            textViewUm.setText(lista_codigo.get(i));
            tablerow.addView(textViewUm);
            textViewDois.setTextSize(65);
            textViewDois.setPadding(150, 0, 0, 0);
            textViewDois.setText(lista_alfabeto.get(i).toString());
            tablerow.addView(textViewDois);
            tableLayout.addView(tablerow);

        }

        


    }

}
