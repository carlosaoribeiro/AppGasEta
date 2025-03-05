package devandroid.maddo.appgaseta.controller;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.Nullable;
import java.util.List;
import devandroid.maddo.appgaseta.database.GasEtaDB;
import devandroid.maddo.appgaseta.model.Combustivel;

public class CombustivelController extends GasEtaDB {

    SharedPreferences preferences;
    SharedPreferences.Editor preferencesData;
    public static final String PREFERENCES_NAME = "pref_gaseta";

    public CombustivelController(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    public void saveData(Combustivel combustivel) {
        ContentValues data = new ContentValues();

        //save on SharedPreferences
        preferencesData.putString("fuelType", combustivel.getFuelType());
        preferencesData.putFloat("fuelPrice", (float) combustivel.getFuelPrice());
        preferencesData.putString("suggestion", combustivel.getSuggestion());
        preferencesData.apply();

        //save to database
        data.put("fuelType", combustivel.getFuelType());
        data.put("fuelPrice", (float) combustivel.getFuelPrice());
        data.put("suggestion", combustivel.getSuggestion());

        saveObj("Combustivel", data);
        int pra = 0;
    }

    public void saveObj(String combustivel, ContentValues data) {
    }


    public List<Combustivel> getAllData() {

        return listData();
    }

    public List<Combustivel> listData() {
        return java.util.Collections.emptyList();
    }


    public void update(Combustivel combustivel) {
        ContentValues data = new ContentValues();

        data.put("id", combustivel.getId());
        data.put("fuelType", combustivel.getFuelType());
        data.put("fuelPrice", (float) combustivel.getFuelPrice());
        data.put("suggestion", combustivel.getSuggestion());

        updateData("Combustivel", data);
    }

    public void updateData(String combustivel, ContentValues data) {
    }


    public void delete(int id) {
        deleteData("Combustivel", id);
    }

    public SharedPreferences getPreferences() {
        return preferences;
    }

    public void setPreferences(SharedPreferences preferences) {
        this.preferences = preferences;
    }

    public SharedPreferences.Editor getPreferencesData() {
        return preferencesData;
    }

    public void setPreferencesData(SharedPreferences.Editor preferencesData) {
        this.preferencesData = preferencesData;
    }

    public void deleteData(String combustivel, int id) {
    }


    public void clearData() {
        preferencesData.clear();
        preferencesData.apply();
    }

}