package br.pro.hashi.ensino.desagil.projeto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsManager;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
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

        TextView LegMorseMen = findViewById(R.id.mensagem_morse);
        TextView LegMorseTel = findViewById(R.id.telefone_morse);


        TextView telefoneTraduzido = findViewById(R.id.telefone_que_foi_traduzido);
        TextView mensagemTraduzida = findViewById(R.id.mensagem_que_foi_traduzida);

        Button buttonMorse = findViewById(R.id.button_morse);
        Button buttonEspaco = findViewById(R.id.button_espaco);
        Button buttonBarra = findViewById(R.id.button_barra);
        Button buttonApaga = findViewById(R.id.button_apagar);

        Button buttonTraduzir = findViewById(R.id.button_traduzir);

        Button buttonEnviar = findViewById(R.id.button_enviar);

        telefoneMorse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LegMorseTel.setTextColor(Color.parseColor("#6200ee"));
                LegMorseMen.setTextColor(Color.parseColor("#aaaaaa"));
                buttonMorse.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        telefoneMorse.setText(telefoneMorse.getText() + ".");
                    }
                });

                buttonMorse.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view){
                        telefoneMorse.setText(telefoneMorse.getText() + "-");
                        return true;
                    }
                });

                buttonEspaco.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        telefoneMorse.setText(telefoneMorse.getText() + " ");

                    }
                });

                buttonBarra.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        telefoneMorse.setText(telefoneMorse.getText() + "/");
                    }
                });

                buttonApaga.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String str;
                        str = telefoneMorse.getText().toString();
                        String result = null;
                        if ((str != null) && (str.length() > 0)) {
                            result = str.substring(0, str.length() - 1);
                            telefoneMorse.setText(result.toString());
                        }

                        else {
                            result="";
                            telefoneMorse.setText(result.toString());
                        }

                    }
                });

            }
        });

        mensagemMorse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LegMorseMen.setTextColor(Color.parseColor("#6200ee"));
                LegMorseTel.setTextColor(Color.parseColor("#aaaaaa"));
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

                String morse1;
                String frase1;
                String string1;
                Translator tradutor1 = new Translator();
                string1 = "";
                frase1 = "";

                morse1 = telefoneMorse.getText().toString();

                for (int i = 0; i < (morse1.length()); i++) {
                    try {
                        if (morse1.charAt(i) != ' ') {
                            string1 = string1 + morse1.charAt(i);
                            if (i == morse1.length() - 1) {
                                frase1 += tradutor1.morseToChar(string1);
                            }
                        } else {
                            frase1 += tradutor1.morseToChar(string1);
                            string1 = "";
                        }
                        if (morse1.charAt(i) == '/') {
                            frase1 += " ";
                            string1 = "";
                        }

                    } catch (Exception e) {
                        showToast("Ultimo Caractere Inexistente!");
                        return;
                    }
                }

                telefoneTraduzido.setText(frase1.toString());

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
