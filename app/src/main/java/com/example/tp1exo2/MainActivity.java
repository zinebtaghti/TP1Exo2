package com.example.tp1exo2;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText nom,adresse,surface,nbrepieces;
    private CheckBox piscine;
    private Button calcul;
    private TextView ib;
    private TextView is;
    private TextView it;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        nom = findViewById(R.id.nom);
        surface = findViewById(R.id.surface);
        nbrepieces = findViewById(R.id.nbrepieces);
        piscine = findViewById(R.id.piscine);
        calcul = findViewById(R.id.calcul);
        piscine = findViewById(R.id.piscine);
        ib = findViewById(R.id.ib);
        it = findViewById(R.id.it);
        is = findViewById(R.id.is);
        calcul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nombrepieces = Integer.parseInt(nbrepieces.getText().toString());
                int srfce = Integer.parseInt(surface.getText().toString());
                int impotbase=2*srfce;;
                int impotsupp;
                if(piscine.isChecked())
                {
                    impotsupp=nombrepieces*50+100;
                }
                else {
                    impotsupp = nombrepieces * 50;
                }
                    ib.setText("Impot de base : "+impotbase);
                    is.setText("Impot supplémentare : "+impotsupp);
                    it.setText("Impot total : "+(impotbase+impotsupp));
                }


            }

        );

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}