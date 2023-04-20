package com.example.laboratoire2android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CategorieActivity extends AppCompatActivity {
    ArrayList<Produit> listeTransmise= new ArrayList<>();
    String[] categories = {"Boissons","Condiments","Produits secs", "Poissons et fruits de mer","Viandes"};
    Spinner spinner;
    ArrayAdapter<String> adapterC;
    ArrayAdapter<String> adapterP;
    ListView listView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        Intent i= getIntent();
        listeTransmise = i.getParcelableArrayListExtra("listeProduits");
        spinner = findViewById(R.id.spinner);
        adapterC = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, categories);
        spinner.setAdapter(adapterC);
        listView = findViewById(R.id.listView);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                recherche(selectedItem);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }

    private void recherche(String categorie) {
        ArrayList<String> listeCorrespondante = new ArrayList<>();
        for (Produit p : listeTransmise) {
            if(p.getCode_categorie().equals(categorie))
                listeCorrespondante.add(p.toString());
        }
        adapterP = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listeCorrespondante);
        this.listView.setAdapter(adapterP);
    }
}
