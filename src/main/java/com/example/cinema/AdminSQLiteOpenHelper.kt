package com.example.cinema

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class AdminSQLiteOpenHelper (context: Context, name: String, factory: SQLiteDatabase.CursorFactory?, version: Int): SQLiteOpenHelper(context,name,factory,version) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table encuesta(id integer primary key autoincrement, pregunta1 text,pregunta2 text,pregunta3 text,pregunta4 text,pregunta5 text )")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

}