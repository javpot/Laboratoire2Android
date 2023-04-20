package com.example.laboratoire2android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Produit> listeProduits = new ArrayList<>();
    ArrayList<String> listeCategories = new ArrayList<>();

    ArrayList<String> listerString = new ArrayList<>();
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button boutonLister = findViewById(R.id.buttonLister);
        listView = findViewById(R.id.listViewMain);
        listeProduits.add(new Produit(1,"Chal","Boissons",90.00,39));
        listeProduits.add(new Produit(2,"Chang","Boissons",95.00,17));
        listeProduits.add(new Produit(3,"Aniseed Syrup","Condiments",50.00,13));
        listeProduits.add(new Produit(4,"Chef Anton's Cajun Seasoning","Condiments",110.00,53));
        listeProduits.add(new Produit(5,"Chef Anton's Gumbo Mix","Condiments",106.75,0));
        listeProduits.add(new Produit(6,"Grandma's Boysenberry Spread","Condiments",125.00,15));
        listeProduits.add(new Produit(7,"Uncle Bob's Organic Dried Pears","Produits secs",150.00,15));
        listeProduits.add(new Produit(8,"Northwoods Cranberry Sauce","Condiments",200.00,29));
        listeProduits.add(new Produit(9,"Mishi Kobe Niku","Viandes",485.00,29));
        listeProduits.add(new Produit(10,"Ikura","Viandes",155.00,23));
for(Produit p : listeProduits){
    if(!listeCategories.contains(p.getCode_categorie())){
        listeCategories.add(p.getCode_categorie());
    }
}

for (Produit p : listeProduits){
    String s = p.getRef_produit()+ ", " + p.getNom_du_produit();
    listerString.add(s);
}


        //test

    }

    public void listerProduits(View view) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, listerString);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        listView.setAdapter(adapter);

    }
}