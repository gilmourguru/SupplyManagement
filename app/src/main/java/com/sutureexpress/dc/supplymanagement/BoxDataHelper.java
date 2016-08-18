package com.sutureexpress.dc.supplymanagement;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by taylor on 7/20/16.
 */

public class BoxDataHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "supplydatabase";
    private static final String TABLE_NAME = "boxmaster";
    private static final int DATABASE_VERSION = 1;
    private static final String UID = "_id";
    private static final String VENDOR_ID = "vendor_id";
    private static final String DIM = "dim";
    private static final String COUNT = "count";
    private static final String UNIT_QTY = "unitQty";
    private static final String PRICE = "price";

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + UID + " INTEGER PRIMARY " +
            "KEY AUTOINCREMENT, " + VENDOR_ID + " VARCHAR(255), " + DIM + " VARCHAR(255), "
            + COUNT +  " INTEGER, " + UNIT_QTY + " VARCHAR(255), " + PRICE + " DECIMAL(11,2));";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS "+TABLE_NAME;
    private Context context;
    public BoxDataHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
        Message.message(context, "constructor called");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //TODO: finish me
        try {
            db.execSQL(CREATE_TABLE);
            Message.message(context, "onCreate called");
        } catch (SQLException e) {
           Message.message(context, ""+e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            Message.message(context, "onUpgrade called");
            db.execSQL(DROP_TABLE);
            onCreate(db);
        } catch (SQLException e) {
            Message.message(context, ""+e);
        }
    }

}
