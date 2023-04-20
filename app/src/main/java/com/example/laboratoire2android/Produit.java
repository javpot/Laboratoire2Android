package com.example.laboratoire2android;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Produit implements Parcelable {
    //ATTRIBUTS
    private int ref_produit;
    private String nom_du_produit;
    private String code_categorie;
    private double prix_unitaire;
    private int unites_en_stock;

    // Constructeur avec parametres
    public Produit(int ref_produit, String nom_du_produit, String code_categorie,
                   double prix_unitaire, int unites_en_stock) {
        this.ref_produit = ref_produit;
        this.nom_du_produit = nom_du_produit;
        this.code_categorie = code_categorie;
        this.prix_unitaire = prix_unitaire;
        this.unites_en_stock = unites_en_stock;
    }

    // Constructeur vide
    public Produit() {

    }

    // Constructeur copie???
    // ------------------

    // GETTERS / SETTERS
    public int getRef_produit() {
        return ref_produit;
    }

    public void setRef_produit(int ref_produit) {
        this.ref_produit = ref_produit;
    }

    public String getNom_du_produit() {
        return nom_du_produit;
    }

    public void setNom_du_produit(String nom_du_produit) {
        this.nom_du_produit = nom_du_produit;
    }

    public String getCode_categorie() {
        return code_categorie;
    }

    public void setCode_categorie(String code_categorie) {
        this.code_categorie = code_categorie;
    }

    public Double getPrix_unitaire() {
        return prix_unitaire;
    }

    public void setPrix_unitaire(Double prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

    public int getUnites_en_stock() {
        return unites_en_stock;
    }

    public void setUnites_en_stock(int unites_en_stock) {
        this.unites_en_stock = unites_en_stock;
    }

    // IMPLEMENTED Parcelable INTERFACE METHODS
    protected Produit(Parcel in) {
        ref_produit = in.readInt();
        nom_du_produit = in.readString();
        code_categorie = in.readString();
        prix_unitaire = in.readDouble();
        unites_en_stock = in.readInt();
    }

    public static final Creator<Produit> CREATOR = new Creator<Produit>() {
        @Override
        public Produit createFromParcel(Parcel in) {
            return new Produit(in);
        }

        @Override
        public Produit[] newArray(int size) {
            return new Produit[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(ref_produit);
        parcel.writeString(nom_du_produit);
        parcel.writeString(code_categorie);
        parcel.writeDouble(prix_unitaire);
        parcel.writeInt(unites_en_stock);
    }

    public String toString(){
        return ref_produit +", "+ nom_du_produit + ", "+ code_categorie + ", $" + prix_unitaire  +", "+ unites_en_stock + " unites";
    }

}
