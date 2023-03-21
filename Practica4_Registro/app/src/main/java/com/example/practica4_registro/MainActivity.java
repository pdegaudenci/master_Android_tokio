package com.example.practica4_registro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.practica4_registro.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

import java.time.Duration;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    binding();
    listener();
    }

    private void listener() {

        binding.campoNombre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int i1, int i2) {

            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int before, int count) {

                if (count>0){
                    if(binding.campoApellido.length()>0)
                        binding.btnRegistro.setEnabled(true);
                }
                else
                    binding.btnRegistro.setEnabled(false);}

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.campoApellido.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int i1, int i2) {

            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int before, int count) {

                if (count>0){
                    if(binding.campoNombre.length()>0)
                        binding.btnRegistro.setEnabled(true);
                }
            else
                    binding.btnRegistro.setEnabled(false);}
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void binding() {// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.lista, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       binding.seleccion.setAdapter(adapter);
        binding.btnRegistro.setOnClickListener(this::validar);
        binding.campoNombre.setText("");
        binding.campoApellido.setText("");


    }

    private void validar(View view) {
        if (!binding.campoNombre.toString().matches("[0-9]+")&& !binding.campoApellido.toString().matches("[0-9]+"))
            Snackbar.make(view,"Los campos no puede tener numeros",Snackbar.LENGTH_LONG).show();
        else
            Snackbar.make(view,"VALIDADO",Snackbar.LENGTH_LONG).show();

    }

    private boolean esCaracter(Character caracter){
        return Character.isDigit(caracter);
    }
}