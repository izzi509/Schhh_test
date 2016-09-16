package com.example.marcgregor.schhh;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Delva on 8/29/2016.
 */
public class Hotel {
    String nom;
    String adresse;
    String imagePath;
    String classHotel;

    public String getNom() {
        return nom;
    }

    public String getAdresse() {
        return adresse;
    }

   public String getClassHotel() {
        return classHotel;
    }

    public String getImagePath() {
        return String.format("http://gogweb.info/schhh/media/PhotoHotel/%s",imagePath);
    }

    public Hotel(JSONObject jsonObject) throws JSONException {
        this.nom = jsonObject.getString("nomHotel");
        this.adresse = jsonObject.getString("adresseHotel");
        this.imagePath = jsonObject.getString("logoHotel");
        this.classHotel = jsonObject.getString("classification");
        

    }

    public static ArrayList<Hotel> fromJsonArray(JSONArray array){
        ArrayList<Hotel> results = new ArrayList<>();

        for(int x = 0; x < array.length(); x++){
            try {
                results.add(new Hotel(array.getJSONObject(x)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return results;
    }
}
