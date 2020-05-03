package br.pro.hashi.ensino.desagil.projeto1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TelaInicial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        TextView textExample = findViewById(R.id.text_example);
        TextView textTranslateExample = findViewById(R.id.text_translate_example);
        TextView editExample = findViewById(R.id.edit_example);
        EditText editTranslateExample = findViewById(R.id.edit_translate_example);

        Button buttonExample = findViewById(R.id.button_example);

        Button buttonMorse = findViewById(R.id.button_morse);
        Button buttonEspaco = findViewById(R.id.button_espaco);
        Button buttonBarra = findViewById(R.id.button_barra);
        Button buttonApaga = findViewById(R.id.button_apagar);

        buttonMorse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editExample.setText(editExample.getText() + ".");
            }
        });

        buttonMorse.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view){
                editExample.setText(editExample.getText() + "-");
                return true;
            }
        });



        buttonEspaco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editExample.setText(editExample.getText() + " ");

            }
        });

        buttonBarra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editExample.setText(editExample.getText() + "/");
            }
        });

        buttonApaga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str;
                str = editExample.getText().toString();
                String result = null;
                if ((str != null) && (str.length() > 0)) {
                    result = str.substring(0, str.length() - 1);
                    editExample.setText(result.toString());
                }

                else {
                    result="";
                    editExample.setText(result.toString());
                }

            }
        });



        buttonExample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String morse;
                String frase;
                String string;
                Translator tradutor = new Translator();
                string = "";
                frase = "";

                morse = editExample.getText().toString();


                for (int i = 0; i < (morse.length()); i++) {
                    try {
                        if (morse.charAt(i) != ' ') {
                            string = string + morse.charAt(i);
                            if (i == morse.length() - 1) {
                                frase += tradutor.morseToChar(string);
                            }
                        } else {
                            frase += tradutor.morseToChar(string);
                            string = "";
                        }
                        if (morse.charAt(i) == '/') {
                            frase += " ";
                            string = "";
                        } else if (morse.charAt(i) != ' ' && morse.charAt(i) != '/' && morse.charAt(i) != '.' && morse.charAt(i) != '-') {
                            frase += "!!ERRO!!";
                            break;
                        }

                    } catch (Exception e) {
                        frase += "!!ERRO!!";
                        break;
                    }
                }

                editTranslateExample.setText(frase.toString());
            }
        });

    }
}
