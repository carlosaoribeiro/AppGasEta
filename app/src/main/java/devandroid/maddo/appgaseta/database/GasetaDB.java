package devandroid.maddo.appgaseta.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class GasetaDB extends SQLiteOpenHelper {

    Cursor cursor;

    SQLiteDatabase db;
    public static final  String DB_NAME = "gaseta,db";

    public static final int DB_VERSION = 1;


   public GasetaDB (Context context){
       super
               (context, DB_NAME, null, DB_VERSION);

       db = getWritableDatabase();
   }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

