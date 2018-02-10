package mx.unam.aragon.fes.strongvilledev.gitandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnClic, btnOtroClic;
    private TextView txtHola;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnClic = findViewById(R.id.btnClic);
        btnOtroClic = findViewById(R.id.btnOtroClic);
        txtHola = findViewById(R.id.txtHola);

        btnClic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtHola.setText(R.string.hola);
            }
        });
        btnOtroClic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtHola.setText(R.string.diplomado);
            }
        });
    }
}
