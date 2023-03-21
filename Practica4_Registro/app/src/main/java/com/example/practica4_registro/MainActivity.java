package com.example.practica4_registro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
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
                boolean valido=false;
                if (!binding.campoNombre.getText().toString().matches("[A-Za-z]+"))
                    binding.tilNombre.setError("Debe introducir solamente simbolos alfabeticos");
                else{
                    binding.tilNombre.setError(null);
                    valido=true;
                }

                if (count>0 && valido){
                    if(!binding.tilApellido.getEditText().getText().toString().isEmpty())
                        binding.btnRegistro.setEnabled(true);
                }
                else
                    binding.btnRegistro.setEnabled(false);}

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.campoApellido.addTextChangedListener(new TextWatcher() {
            boolean valido=false;
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int i1, int i2) {

            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int before, int count) {
                if (!binding.campoApellido.getText().toString().matches("[A-Za-z]+"))
                    binding.tilApellido.setError("Debe introducir solamente simbolos alfabeticos");
                else{
                    binding.tilNombre.setError(null);
                    valido=true;

                    if (count>0 ){

                    if(!binding.tilApellido.getEditText().getText().toString().isEmpty())
                        binding.btnRegistro.setEnabled(true);

                } else
                        binding.btnRegistro.setEnabled(false);
            }}
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.seleccion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println("LONGITUDDD"+(getResources().getStringArray(R.array.lista).length -1));
                if(i !=  (getResources().getStringArray(R.array.lista).length -1))
                {
                    System.out.println("POSICION"+i);
                    binding.spinner1.setError("Esta app no es para ti");
                    binding.btnRegistro.setEnabled(false);
                }

                else
                    binding.spinner1.setError(null);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        binding.imgRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view instanceof TextView && view.getId()==R.id.img_registro)
                {
                    Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(i,0);
                }
            }
        });
        binding.condicionesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url ="https://developers.google.com/ml-kit/terms";
                Intent intentWeb = new Intent();
                intentWeb.setAction(Intent.ACTION_VIEW);
                intentWeb.setData(Uri.parse("http://"+url));
                startActivity(intentWeb);
            }
        });
    }



    private void binding() {// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter =new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.lista));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       binding.seleccion.setAdapter(adapter);
        binding.btnRegistro.setOnClickListener(this::validar);
        binding.campoNombre.setText("");
        binding.campoApellido.setText("");


    }

    private void validar(View view) {
        if (binding.campoNombre.toString().matches("[A-Za-z]+")&& binding.campoApellido.toString().matches("\"[A-Za-z]+\""))
            Snackbar.make(view,"Los campos no puede tener numeros o simbolos especiales",Snackbar.LENGTH_LONG).show();
        else
            Snackbar.make(view,"VALIDADO",Snackbar.LENGTH_LONG).show();

    }

    private boolean esCaracter(Character caracter){
        return Character.isDigit(caracter);
    }
}