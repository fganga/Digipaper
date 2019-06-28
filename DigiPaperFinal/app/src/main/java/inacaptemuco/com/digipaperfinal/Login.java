package inacaptemuco.com.digipaperfinal;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;

import DTO.EstadoSolicitud;
import DTO.SolicitanteReporte;
import DTO.SolicitudReporte;
import Utilidades.Mensajeria;


public class Login extends AppCompatActivity implements View.OnClickListener {

    public static TextView txvUserToken;
    EditText edtUserMail;
    EditText edtUserPassword;
    String userName;
    Button btnIngresar;
    public static String token = null;
    boolean resultadoAPI = false;
    boolean resultadoComparacion = false;

    final ArrayList<SolicitanteReporte> arlSolicitanteReporte = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        txvUserToken = (TextView) findViewById(R.id.txv_user_token);
        edtUserMail = (EditText) findViewById(R.id.txv_user_mail);
        edtUserPassword = (EditText) findViewById(R.id.txv_user_password);
        btnIngresar = (Button) findViewById(R.id.btn_login_aceptar);


        btnIngresar.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.btn_login_aceptar:

                Login();
                if (token != null) {

                        Intent intentLogin = new Intent(Login.this, BarraNavegacion.class);
                        intentLogin.putExtra("token", token);
                        intentLogin.putExtra("userName", userName);
                        startActivity(intentLogin);
                        break;
                } else {
                    new Mensajeria("Correo o contraseña invalidos!", getApplicationContext());
                }

        }

    }


    public boolean Login() {

        this.edtUserMail.getText().toString();
        this.edtUserPassword.getText().toString();
        resultadoAPI = false;

        JsonObject json = new JsonObject();
        json.addProperty("Email", edtUserMail.getText().toString());
        json.addProperty("Password", edtUserPassword.getText().toString());
        Ion.with(this)
                .load("POST", "https://www.digipaper.online/account/login")
                .setJsonObjectBody(json)
                .asString()
                .setCallback(new FutureCallback<String>() {
                    @Override
                    public void onCompleted(Exception e, String result) {
                        if (result != null) {
                            try {

                                if (!TextUtils.isEmpty(result)) {
                                    token = result;
                                    txvUserToken.setText(result);
                                    resultadoAPI = true;
                                    // TODO save token

                                } else {
                                    new Mensajeria("Falló al obtener token", getApplicationContext());
                                }
                            } catch (Throwable t) {

                                new Mensajeria(t.getMessage(), getApplicationContext());

                            }

                        } else {

                            new Mensajeria("Error!", getApplicationContext());
                        }
                    }

                });

        return resultadoAPI;
    }
}