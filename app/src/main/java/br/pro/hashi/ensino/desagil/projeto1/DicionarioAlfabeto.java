package br.pro.hashi.ensino.desagil.projeto1;

import androidx.appcompat.app.AppCompatActivity;

import android.database.CursorJoiner;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class DicionarioAlfabeto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dicionario_alfabeto);
        Translator tradutor = new Translator();
        HashMap<Character, Node> mapa = new LinkedHashMap<>();
        mapa = tradutor.getMap();

        LinkedList<Character> lista_inicial = new LinkedList<>(mapa.keySet());
        Collections.sort(lista_inicial);
        LinkedList<Character>lista_numeros = new LinkedList<>();

        for (int n = 0; n < 10; n++){
            char numero = lista_inicial.get(n);
            lista_numeros.add(numero);
        }

        System.out.println(lista_numeros);

        LinkedList lista_alfabeto = new LinkedList();
        for (int a = 0; a < (lista_inicial.size()); a++ ){

            if (lista_inicial.get(a) != 'S' && lista_inicial.get(a) != 'A' && lista_inicial.get(a) != 'B' && lista_inicial.get(a) != 'C'&& !lista_numeros.contains(lista_inicial.get(a))){
                lista_alfabeto.add(lista_inicial.get(a));
            }
        }

        System.out.println(lista_alfabeto);

        for (char inteiro: lista_numeros){
            lista_alfabeto.add(inteiro);
        }

        System.out.println(lista_alfabeto);

        LinkedList<String> lista_morse = new LinkedList<>();
        for (Object letra: lista_alfabeto){
            for (Map.Entry<Character, Node> entrada : mapa.entrySet()){
                Character resultado = entrada.getKey();
                String morse = tradutor.charToMorse(resultado);
                if (letra == entrada.getKey()){
                    lista_morse.add(morse);
                }
            }
        }
        for (int i = 0; i < (lista_alfabeto.size()); i++){
            TableLayout tableLayout =  (TableLayout) findViewById(R.id.tablelayout);
            TableRow tablerow = new TableRow(this);
            TextView textViewUm = new TextView(this);
            TextView textViewDois = new TextView(this);
            textViewUm.setTextSize(65);
            textViewUm.setPadding(50,0,0,0);
            textViewUm.setText(lista_alfabeto.get(i).toString());
            tablerow.addView(textViewUm);
            textViewDois.setTextSize(65);
            textViewDois.setPadding(150, 0, 0, 0);
            textViewDois.setText(lista_morse.get(i));
            tablerow.addView(textViewDois);
            tableLayout.addView(tablerow);
        }




    }
}
