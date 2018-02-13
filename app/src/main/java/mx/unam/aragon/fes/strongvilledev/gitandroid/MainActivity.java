package mx.unam.aragon.fes.strongvilledev.gitandroid;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private Button btnClic, btnOtroClic, btnDescargaImagen;
    private TextView txtHola;
    private ImageView vistaImagen;
    //private Bitmap imagenDescargada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnClic = findViewById(R.id.btnClic);
        btnOtroClic = findViewById(R.id.btnOtroClic);
        btnDescargaImagen = findViewById(R.id.btnDescargaImagen);
        txtHola = findViewById(R.id.txtHola);
        vistaImagen = findViewById(R.id.vistaImagen);

        btnClic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtHola.setText(R.string.hola);
                Toast.makeText(MainActivity.this, "Se cambió el mensaje en el TextView",
                        Toast.LENGTH_SHORT).show();
            }
        });
        btnOtroClic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtHola.setText(R.string.diplomado);
            }
        });
        btnDescargaImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    txtHola.setText(R.string.espera);
                    new DescargarImagen().execute(new URL("https://vignette.wikia.nocookie.net/toontown/images/f/fe/A_Toon.jpg/revision/latest?cb=20101013223907"));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    class DescargarImagen extends AsyncTask<URL, Integer, Bitmap> {
        @Override protected Bitmap doInBackground(URL... params) {
            try {
                return BitmapFactory.decodeStream(params[0].openConnection().getInputStream());
            }

            catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override protected void onPostExecute(Bitmap bitmap) {
            vistaImagen.setImageBitmap(bitmap);
            txtHola.setText(R.string.descargada);
            super.onPostExecute(bitmap);
        }
    }
}
