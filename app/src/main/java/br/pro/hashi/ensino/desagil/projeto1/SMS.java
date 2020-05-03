package br.pro.hashi.ensino.desagil.projeto1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SMS extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        TextView mensagemMorse = findViewById(R.id.mensagem_em_morse);
        TextView telefoneMorse = findViewById(R.id.telefone_em_morse);

        TextView telefoneTraduzido = findViewById(R.id.telefone_que_foi_traduzido);
        TextView mensagemTraduzida = findViewById(R.id.mensagem_que_foi_traduzida);

        Button buttonTraduzir = findViewById(R.id.button_traduzir);

        Button buttonMorse = findViewById(R.id.button_morse);
        Button buttonEspaco = findViewById(R.id.button_espaco);
        Button buttonBarra = findViewById(R.id.button_barra);
        Button buttonApaga = findViewById(R.id.button_apagar);

        buttonMorse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mensagemMorse.setText(mensagemMorse.getText() + ".");
            }
        });

        buttonMorse.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view){
                mensagemMorse.setText(mensagemMorse.getText() + "-");
                return true;
            }
        });

        buttonEspaco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mensagemMorse.setText(mensagemMorse.getText() + " ");

            }
        });

        buttonBarra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mensagemMorse.setText(mensagemMorse.getText() + "/");
            }
        });

        buttonApaga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str;
                str = mensagemMorse.getText().toString();
                String result = null;
                if ((str != null) && (str.length() > 0)) {
                    result = str.substring(0, str.length() - 1);
                    mensagemMorse.setText(result.toString());
                }

                else {
                    result="";
                    mensagemMorse.setText(result.toString());
                }

            }
        });

        buttonTraduzir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String morse;
                String frase;
                String string;
                Translator tradutor = new Translator();
                string = "";
                frase = "";

                morse = mensagemMorse.getText().toString();

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

                mensagemTraduzida.setText(frase.toString());
            }
        });

    }
}
