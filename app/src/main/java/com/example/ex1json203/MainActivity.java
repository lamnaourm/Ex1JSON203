package com.example.ex1json203;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    TextView tnom, tage, tfiliere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tnom = findViewById(R.id.tnom);
        tage = findViewById(R.id.tage);
        tfiliere = findViewById(R.id.tfil);

        String json = loadJsonFromRaw(R.raw.stagiaire);

        try {
            JSONObject obj = new JSONObject(json);

            tnom.setText("Nom : " + obj.getString("nom"));
            tage.setText("age : " + obj.getInt("age"));
            tfiliere.setText("Filiere : " + obj.getString("filiere"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    // Lire fichier
    public String loadJsonFromRaw(int resId){
        try {
            InputStream in = getResources().openRawResource(resId);
            byte[] data = new byte[in.available()];
            in.read(data);
            in.close();
            return new String(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}