package com.example.practicabbdd1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createDDBB();
    }

    private void createDDBB() {
        //Creamos la base de datos "DOCTOR"
        BaseDatosHelper docdb = new BaseDatosHelper(this, "DOCTOR", null, 1);
        db = docdb.getWritableDatabase();
    }

    public void goToCreateForm(View v) {
        Intent i = new Intent(this, CreateDoc.class);
        startActivity(i);
    }

    public void goToDeleteForm(View v) {
        Intent i = new Intent(this, DeleteDoc.class);
        startActivity(i);
    }

    public void goToModForm(View v) {
        Intent i = new Intent(this, ModDoc.class);
        startActivity(i);
    }
}