
package com.sam_chordas.android.stockhawk.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import net.simonvt.schematic.annotation.Database;
import net.simonvt.schematic.annotation.OnCreate;
import net.simonvt.schematic.annotation.OnUpgrade;
import net.simonvt.schematic.annotation.Table;


@Database(version = QuoteDatabase.VERSION)
public class QuoteDatabase {

    private QuoteDatabase() {
    }

    public static final int VERSION = 21;

    public static final String QUOTES_TABLE = "CREATE TABLE quotes ("
            + QuoteColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + QuoteColumns.SYMBOL + " TEXT NOT NULL,"
            + QuoteColumns.PERCENT_CHANGE + " TEXT NOT NULL,"
            + QuoteColumns.CHANGE + " TEXT NOT NULL,"
            + QuoteColumns.BIDPRICE + " TEXT NOT NULL,"
            + QuoteColumns.CREATED + " TEXT,"
            + QuoteColumns.ISUP + " INTEGER NOT NULL,"
            + QuoteColumns.ISCURRENT + " INTEGER NOT NULL,"
            + QuoteColumns.NAME + " TEXT NOT NULL)";

    public static final String QUOTES_HISTORICAL_DATA_TABLE = "CREATE TABLE quotes_historical_data ("
            + QuoteHistoricalDataColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + QuoteHistoricalDataColumns.SYMBOL + " TEXT NOT NULL,"
            + QuoteHistoricalDataColumns.DATE + " TEXT NOT NULL,"
            + QuoteHistoricalDataColumns.BIDPRICE + " TEXT NOT NULL)";

    @Table(QuoteColumns.class)
    public static final String QUOTES = "quotes";

    @Table(QuoteHistoricalDataColumns.class)
    public static final String QUOTES_HISTORICAL_DATA = "quotes_historical_data";

    @OnCreate public static void onCreate(SQLiteDatabase db) {

    }

    @OnUpgrade public static void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion < newVersion){
            db.execSQL("DROP TABLE IF EXISTS " + QUOTES);
            db.execSQL("DROP TABLE IF EXISTS " + QUOTES_HISTORICAL_DATA);
            db.execSQL(QUOTES_TABLE);
            db.execSQL(QUOTES_HISTORICAL_DATA_TABLE);

        }
    }



}
