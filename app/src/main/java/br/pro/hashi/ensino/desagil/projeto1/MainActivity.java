package br.pro.hashi.ensino.desagil.projeto1;

import androidx.appcompat.app.AppCompatActivity;

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

        TextView textExample = findViewById(R.id.text_example);
        TextView textTranslateExample = findViewById(R.id.text_translate_example);

        EditText editExample = findViewById(R.id.edit_example);
        EditText editTranslateExample = findViewById(R.id.edit_translate_example);

        Button buttonExample = findViewById(R.id.button_example);

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


                for (int i = 0; i < (morse.length()); i++){
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
                        }else if (morse.charAt(i) != ' ' && morse.charAt(i) != '/' && morse.charAt(i) != '.' && morse.charAt(i) != '-' ) {
                            frase += "!!ERRO!!";
                            break;
                        }

                    }catch (Exception e){
                        frase += "!!ERRO!!";
                        break;
                    }
                }

                editTranslateExample.setText(frase.toString());
            }
        });



    }
}
