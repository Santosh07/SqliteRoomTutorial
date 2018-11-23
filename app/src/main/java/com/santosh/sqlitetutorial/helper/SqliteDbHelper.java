package com.santosh.sqlitetutorial.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.widget.Toast;

import javax.inject.Inject;
import java.io.*;

public class SqliteDbHelper extends SQLiteOpenHelper {
    Context context;
    String DB_PATH;
    String divider = "/";
    String DB_NAME;

    @Inject
    public SqliteDbHelper(Context context, String name) {
        super(context, name, null, 1);
        this.context = context;
        this.DB_NAME = name;
        DB_PATH = divider + "data" + divider + "data" + divider + context.getPackageName() + divider + "databases/";
    }

    public void importDataBaseFromAssets() throws IOException {

        this.getReadableDatabase();

        InputStream myInput = context.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream myOutput = new FileOutputStream(outFileName);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }
        Toast.makeText(context.getApplicationContext(),  DB_NAME + " Successfully Imported", Toast.LENGTH_SHORT).show();
        // Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();

    }

    public boolean isDatabaseExists() {
        return new File(DB_PATH + DB_NAME).exists();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
