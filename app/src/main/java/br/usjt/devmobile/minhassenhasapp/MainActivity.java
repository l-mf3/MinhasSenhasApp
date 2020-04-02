package br.usjt.devmobile.minhassenhasapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.orhanobut.hawk.Hawk;

public class MainActivity extends AppCompatActivity {

    EditText usuario;
    EditText senha;
    EditText usuario01;
    EditText senha01;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario = findViewById(R.id.emailEditTextInput);
        senha = findViewById(R.id.passwordEditTextInput);
        Hawk.init(this).build();

    }

    public void fazerLogin(View view){

        String usuario01 = Hawk.get("usuario");
        String senha01 = Hawk.get("senha");
        Log.d(TAG, "Já existe alguem chamado: "+usuario01);
        Log.d(TAG, "Já existe: "+senha01);

        if(usuario.toString() == usuario01 && senha.toString() == senha01){
            Intent intent = new Intent(this, ListaSenhasActivity.class);
            startActivity(intent);
            Log.d(TAG, "Já existe alguem chamado: "+usuario);
        } else {
            Toast.makeText(getApplication(), "senha ou usuário incorretas", Toast.LENGTH_LONG).show();


        }
        //Intent intent = new Intent(this, ListaSenhasActivity.class);
        //startActivity(intent);
    }

    public void novoCadastro(View view){
        if(Hawk.contains("usuario")){
            Toast.makeText(this,"Usuário já cadastrado!",Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent(this, CadastroUsuarioActivity.class);
            startActivity(intent);
        }
    }
}
