package com.example.practicabbdd1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class CreateDoc extends AppCompatActivity {
    private TextView inHospitalCod, inDoctorNo, inApellido, inEspecialidad, inSalario;
    SQLiteDatabase db = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_doc);

        this.inHospitalCod = findViewById(R.id.inHospitalCod);
        this.inDoctorNo = findViewById(R.id.inDoctorNo);
        this.inApellido = findViewById(R.id.inApellido);
        this.inEspecialidad = findViewById(R.id.inEspecialidad);
        this.inSalario = findViewById(R.id.inSalario);
    }

    public void createDoc(View v) {
        try {
            BaseDatosHelper docdb = new BaseDatosHelper(this, "DOCTOR", null, 1);
            db = docdb.getWritableDatabase();
            //String queryDOCNO = "SELECT MAX(DOCTOR_NO) + 1 FROM DOCTOR";
            //String[] args = new String[]{};
            //if tabla vacía -> id = 00001
            //else SELECT MAX(DOCTOR_NO) + 1 FROM DOCTOR

            ContentValues newReg = new ContentValues();
            newReg.put("HOSPITAL_COD", inHospitalCod.getText().toString());
            newReg.put("DOCTOR_NO", inDoctorNo.getText().toString());
            //newReg.put("DOCTOR_NO", db.rawQuery(inDoctorNo, args).toString());
            newReg.put("APELLIDO", inApellido.getText().toString());
            newReg.put("ESPECIALIDAD", inEspecialidad.getText().toString());
            newReg.put("SALARIO", inSalario.getText().toString());

            db.insert("DOCTOR", null, newReg);

            resetFields();
            Toast.makeText(this, "Doc creado", Toast.LENGTH_LONG).show();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void goIndex(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    private void resetFields(){
        this.inHospitalCod.setText("");
        this.inDoctorNo.setText("");
        this.inApellido.setText("");
        this.inEspecialidad.setText("");
        this.inSalario.setText("");
    }
}