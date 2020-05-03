package br.pro.hashi.ensino.desagil.projeto1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TelaInicial extends AppCompatActivity {

    private void showToast(String text) {

        // Constrói uma bolha de duração curta.
        Toast toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);

        // Mostra essa bolha.
        toast.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        TextView textoMorse = findViewById(R.id.texto_morse);
        TextView textoTraduzido = findViewById(R.id.texto_traduzido);

        Button buttonTraduzir = findViewById(R.id.button_traduzir);

        Button buttonMorse = findViewById(R.id.button_morse);
        Button buttonEspaco = findViewById(R.id.button_espaco);
        Button buttonBarra = findViewById(R.id.button_barra);
        Button buttonApaga = findViewById(R.id.button_apagar);

        buttonMorse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textoMorse.setText(textoMorse.getText() + ".");
            }
        });

        buttonMorse.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view){
                textoMorse.setText(textoMorse.getText() + "-");
                return true;
            }
        });

        buttonEspaco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textoMorse.setText(textoMorse.getText() + " ");

            }
        });

        buttonBarra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textoMorse.setText(textoMorse.getText() + "/");
            }
        });

        buttonApaga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str;
                str = textoMorse.getText().toString();
                String result = null;
                if ((str != null) && (str.length() > 0)) {
                    result = str.substring(0, str.length() - 1);
                    textoMorse.setText(result.toString());
                }
                else {
                    result="";
                    textoMorse.setText(result.toString());
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

                morse = textoMorse.getText().toString();

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
                        }
                    } catch (Exception e) {
                        showToast("Ultimo Caractere Inexistente!");
                        return;
                    }
                }
                textoTraduzido.setText(frase.toString());
            }
        });
    }
}
