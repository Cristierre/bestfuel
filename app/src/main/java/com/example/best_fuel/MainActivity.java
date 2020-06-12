package com.example.best_fuel;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText etGasolina, etEtanol;
    private Button btnCalcula;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etGasolina = findViewById(R.id.etGasolina);
        etEtanol = findViewById(R.id.etEtanol);
        btnCalcula = (Button)findViewById(R.id.btnCalcula);

        btnCalcula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder mensagem = new AlertDialog.Builder(MainActivity.this);
                mensagem.setTitle("Resultado");
                mensagem.setMessage("Resultado: " + calculaPreco()+"\n");
                mensagem.setNeutralButton("OK", null);
                mensagem.show();
            }
        });

    }

    public String calculaPreco() {
        float gasolina = Float.parseFloat(etGasolina.getText().toString());
        float etanol = Float.parseFloat(etEtanol.getText().toString());
        float resultado = etanol/gasolina;

        if (resultado < 0.7) {
            return resultado + " abasteça com Etanol!";
        } else {
            return resultado + " abasteça com Gasolina!";
        }
    }
}
