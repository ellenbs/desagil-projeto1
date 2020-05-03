package br.pro.hashi.ensino.desagil.projeto1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SMS extends AppCompatActivity {

    private void showToast(String text) {

        // Constrói uma bolha de duração curta.
        Toast toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);

        // Mostra essa bolha.
        toast.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        TextView mensagemMorse = findViewById(R.id.mensagem_em_morse);
        TextView telefoneMorse = findViewById(R.id.telefone_em_morse);

        TextView telefoneTraduzido = findViewById(R.id.telefone_que_foi_traduzido);
        TextView mensagemTraduzida = findViewById(R.id.mensagem_que_foi_traduzida);

        Button buttonMorse = findViewById(R.id.button_morse);
        Button buttonEspaco = findViewById(R.id.button_espaco);
        Button buttonBarra = findViewById(R.id.button_barra);
        Button buttonApaga = findViewById(R.id.button_apagar);

        Button buttonTraduzir = findViewById(R.id.button_traduzir);

        Button buttonEnviar = findViewById(R.id.button_enviar);

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
                        }

                    } catch (Exception e) {
                        showToast("Ultimo Caractere Inexistente!");
                        return;
                    }
                }

                mensagemTraduzida.setText(frase.toString());
            }
        });

        buttonEnviar.setOnClickListener((view) -> {
            String message = mensagemTraduzida.getText().toString();

            if (message.isEmpty()) {
                showToast("Mensagem inválida!");
                return;
            }

            String phone = telefoneTraduzido.getText().toString();

            // Esta verificação do número de telefone é bem
            // rígida, pois exige até mesmo o código do país.
            if (!PhoneNumberUtils.isGlobalPhoneNumber(phone)) {
                showToast("Número inválido!");
                return;
            }

            // Enviar uma mensagem de SMS. Por simplicidade,
            // não estou verificando se foi mesmo enviada,
            // mas é possível fazer uma versão que verifica.
            SmsManager manager = SmsManager.getDefault();
            manager.sendTextMessage(phone, null, message, null, null);

            // Limpar o campo para nenhum engraçadinho
            // ficar apertando o botão várias vezes.
            telefoneTraduzido.setText("");
        });

    }
}
