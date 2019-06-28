package Utilidades;

import android.content.Context;
import android.widget.Toast;

public class Mensajeria {

    Context contextApp;
    public String Mensaje;

    public Mensajeria(String mensaje, Context context) {
        Mensaje = mensaje;
        contextApp = context;
        CharSequence text = mensaje;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }


}

                            /*Context context = getApplicationContext();
                            CharSequence text = e.getMessage();
                            int duration = Toast.LENGTH_SHORT;

                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();*/