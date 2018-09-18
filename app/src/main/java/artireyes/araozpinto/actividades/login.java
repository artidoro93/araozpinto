package artireyes.araozpinto.actividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import artireyes.araozpinto.R;

public class login extends AppCompatActivity {

    Button ingresar,registrar;
    EditText correo,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        correo=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.pass);
        ingresar=(Button)findViewById(R.id.ingresar);
        registrar=(Button)findViewById(R.id.registrar);

       // acciones de boton ingresar
        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //accion de boton registrar

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento=new Intent(login.this,registrar.class);
                startActivity(intento);
            }
        });

    }
}
