package com.example.practicabbdd1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteDoc extends AppCompatActivity {
    private EditText inNoDoc;
    SQLiteDatabase db = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_doc);
        this.inNoDoc = findViewById(R.id.inDocNoDelete);
    }

    public void deleteDoc(View v) {
        try {
            BaseDatosHelper docdb = new BaseDatosHelper(this, "DOCTOR", null, 1);
            db = docdb.getWritableDatabase();
            String doctorNo = inNoDoc.getText().toString();
            db.delete("DOCTOR", "DOCTOR_NO=?", new String[]{doctorNo});

            resetFields();
            Toast.makeText(this, "Doc eliminado", Toast.LENGTH_LONG).show();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void goIndex(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    private void resetFields() {
        this.inNoDoc.setText("");
    }
}