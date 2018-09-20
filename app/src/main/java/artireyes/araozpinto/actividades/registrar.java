package artireyes.araozpinto.actividades;
import artireyes.araozpinto.R;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class registrar extends AppCompatActivity {

    EditText emailregistro,passwregistro;
    Button btnregistro;
   FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrar);
        auth=FirebaseAuth.getInstance(); //instanciamos firebase siempre se susa
        emailregistro=(EditText) findViewById(R.id.emailregistro);
        passwregistro=(EditText) findViewById(R.id.passregistro);

        //dando accion al boton
        btnregistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//capturabdo datos
                        String emailo=emailregistro.getText().toString();
                        String passo=passwregistro.getText().toString();

                        //validando que no este vacio
                        if (TextUtils.isEmpty(emailo)){
                            Toast.makeText(getApplicationContext(),"coloca un correo" ,Toast.LENGTH_SHORT).show();
                        }
                        if (TextUtils.isEmpty(passo)){
                            Toast.makeText(getApplicationContext(),"ingresa una contraseña",Toast.LENGTH_SHORT).show();
                        }

//comunicnadonos con firebase y crenado correo y pass
                auth.createUserWithEmailAndPassword(emailo,passo).
    /*avise si esta bien lo hemos hecho es un metodo con parametros*/
    addOnCompleteListener(registrar.this, new OnCompleteListener<AuthResult>() {
        @Override                                      //agrrega onclomplete
        public void onComplete(@NonNull Task<AuthResult> task) {
            Toast.makeText(getApplicationContext(),"se ha creado el usuariuo",Toast.LENGTH_SHORT).show();

            //validamos si fue exitosos prguntamos  oye task
            if (!task.isSuccessful()){
                Toast.makeText(getApplicationContext(),"no se pudo registrar",Toast.LENGTH_SHORT).show();
                Intent ingreso=new Intent(registrar.this,bienvenido.class);
                startActivity(ingreso);
            }




        }
    });
            }
        });
    }
}
//nota para usar firebasde agregar permisos de intenet