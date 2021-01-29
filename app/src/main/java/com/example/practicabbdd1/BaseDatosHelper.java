package com.example.practicabbdd1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDatosHelper extends SQLiteOpenHelper {

    String sqlCreate = "CREATE TABLE DOCTOR(HOSPITAL_COD INT,DOCTOR_NO INT,APELLIDO VARCHAR(50),ESPECIALIDAD VARCHAR(40),SALARIO INT);";

    public BaseDatosHelper(Context contexto, String nombre, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(contexto, nombre, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(sqlCreate);
        System.out.println("Tabla creada");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
        db.execSQL("DROP TABLE IF EXISTS DOCTOR");
        db.execSQL(sqlCreate);
    }
}