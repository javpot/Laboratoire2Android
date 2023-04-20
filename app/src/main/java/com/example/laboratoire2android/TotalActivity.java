package com.example.laboratoire2android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class TotalActivity extends AppCompatActivity {
    ArrayList<Produit> listeTransmise = new ArrayList<>();
    private static final DecimalFormat decfor = new DecimalFormat("0.00");
    double somme;
    TextView textView;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total);
       textView = findViewById(R.id.textViewTotal);
        Intent i = getIntent();
        listeTransmise = i.getParcelableArrayListExtra("listeProduits");

        for(Produit p : listeTransmise){
            somme += p.getPrix_unitaire() * p.getUnites_en_stock();
        }
        textView.setText("$" +  decfor.format(somme));

    }

    public void CategoriePage(View view){
        Intent monInt = new Intent(this.getApplicationContext(),CategorieActivity.class);
        monInt.putParcelableArrayListExtra("listeProduits",listeTransmise);
        startActivity(monInt);
    }

    public void DetourPageMain(View view) {

        finish();

    }
}
