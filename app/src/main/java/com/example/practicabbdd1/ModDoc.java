package com.example.practicabbdd1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ModDoc extends AppCompatActivity {
    EditText inDocNo, inNewEsp;
    SQLiteDatabase db = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mod_doc);
        this.inDocNo = findViewById(R.id.inDocNoEdit);
        this.inNewEsp = findViewById(R.id.inNewEsp);
    }

    public void editEsp(View v) {
        try {
            BaseDatosHelper docdb = new BaseDatosHelper(this, "DOCTOR", null, 1);
            db = docdb.getWritableDatabase();

            String newSpec = inNewEsp.getText().toString();
            String docNo = inDocNo.getText().toString();

            ContentValues values = new ContentValues();
            values.put("ESPECIALIDAD", newSpec);

            db.update("DOCTOR", values, "DOCTOR_NO=?", new String[]{docNo});

            resetFields();
            Toast.makeText(this, "Doc editado", Toast.LENGTH_LONG).show();


        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void goIndex(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    private void resetFields(){
        this.inNewEsp.setText("");
        this.inDocNo.setText("");
    }
}