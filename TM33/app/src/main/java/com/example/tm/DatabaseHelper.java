package com.example.tm;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.location.Address;

public class DatabaseHelper extends SQLiteOpenHelper  {
    String c;
    public static final String DATABASE_NAME = "TMMM.db";
    //tables
    public static final String TABLE_NAME = "REGISTER";
    public static final String TABLE_PLACE = "PLACE";
    public static final String TABLE_DIST = "DIST";
//table NAME
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "ADDRESS";
    public static final String COL_4 = "PHONE";
    public static final String COL_5 = "PASSWORD";
    //TABLE PLACE
    public static final String KEY_PLACE_ID = "PLACE_ID";
    public static final String KEY_PLACE = "PLACE";
    public static final String KEY_DESCR = "DESCR";
    public static final String KEY_IMG = "IMAGE";
    //TABLE DIST

    public static final String KEY_DIST_ID = "DIS_ID";
    public static final String KEY_DISTRICT = "DISTRICT";
    //SQL FOR CREATING DETAILS TABLE
    public static final String SQL_TABLE_DISTRICT = " CREATE TABLE " + TABLE_DIST
            + " ( "
            + KEY_DIST_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + KEY_DISTRICT + " VARCHAR "
            + " ) ";

   /*
   SQL FOR CREATING DISTRICT TABLE
        public static final String SQL_TABLE_DISTRICT= " CREATE TABLE " + TABLE_DIST
                + " ( "
                + KEY_DIST_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_DISTRICT + " VARCHAR "
                + " ) ";
                //SQL for creating PLACES table
    public static final String SQL_TABLE_PLACE = " CREATE TABLE " + TABLE_PLACE
            + " ( "
            + KEY_PLACE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + KEY_DISTRICT + " TEXT, "
            + KEY_PLACE + " TEXT, "
            + KEY_DESCR + " TEXT "
            + " ) ";*/
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,ADDRESS VARCHAR,PHONE VARCHAR,PASSWORD VARCHAR)");
       //db.execSQL("create table " + TABLE_DIST +" (DIS_ID INTEGER PRIMARY KEY AUTOINCREMENT,DISTRICT VARCHAR) ");
       db.execSQL("create table " + TABLE_PLACE +" (PLACE_ID INTEGER PRIMARY KEY AUTOINCREMENT,DISTRICT TEXT,PLACE TEXT,DESCR TEXT,IMAGE BLOB)");
db.execSQL(SQL_TABLE_DISTRICT);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_DIST);
       db.execSQL("DROP TABLE IF EXISTS "+TABLE_PLACE);
        onCreate(db);
    }
    public Cursor getUserInfo(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        String whereclause = COL_2 + "=?"; //<<<< select according to NAME
        String[] whereargs = new String[]{name};
        return db.query(
                TABLE_NAME,
                null,
                whereclause,
                whereargs,
                null,null,null
        );
    }
    //using this method we can add PLACE
    public void addplace(String district,String place,String descr) {

        //get writable database
        SQLiteDatabase db = this.getWritableDatabase();

        //create content values to insert
        ContentValues values = new ContentValues();

        values.put(KEY_DISTRICT, district);
        values.put(KEY_PLACE, place);
        values.put(KEY_DESCR, descr);

        long todo_id = db.insert( TABLE_PLACE , null, values);

    }
    public void adddist(String district) {

        //get writable database
        SQLiteDatabase db = this.getWritableDatabase();

        //create content values to insert
        ContentValues values = new ContentValues();

        //Put username in  @values
        values.put( KEY_DISTRICT , district);

        // insert row
        long todo_id = db.insert( TABLE_DIST , null, values);
    }
    //    update price
    public void updatePlace(int id,String descr) {

        //get writable database
        SQLiteDatabase db = this.getWritableDatabase();

       // String sql = " UPDATE " + TABLE_PLACE + " set " + KEY_DESCR + " = " + descr + " where " + KEY_PLACE_ID + " = " + id + " ; " ;
        // insert row

        //db.execSQL(sql);
        ContentValues cv=new ContentValues();
        cv.put(KEY_DESCR,descr);
        db.update(TABLE_PLACE, cv, KEY_PLACE_ID + "= ?", new String[] { String.valueOf(id)} );
    }

    //    delete item
    public void deleteItem(int id) {

        //get writable database
        SQLiteDatabase db = this.getWritableDatabase();

        //String sql = " DELETE FROM " + TABLE_PLACE + " where " + KEY_PLACE_ID + " = " + id + ";";
        // insert row
       // db.execSQL(sql);
        db.delete(TABLE_PLACE, KEY_PLACE_ID + "=?",new  String[]{String.valueOf(id)});
    }
    public void insertData(String dis,String name, String price, byte[] image){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "INSERT INTO PLACE VALUES (NULL, ?, ?, ?, ?)";

        SQLiteStatement statement = db.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1, dis);
        statement.bindString(2, name);

        statement.bindString(3, price);
        statement.bindBlob(4, image);

        statement.executeInsert();
    }
    public Cursor getData(String sql){
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery(sql, null);
    }
    public void updateData(String name, String price, byte[] image, int id) {
        SQLiteDatabase database = getWritableDatabase();

       /* String sql = "UPDATE PLACE SET PLACE = ?, DESCR = ?, IMAGE = ? WHERE PLACE_ID = ?";
        SQLiteStatement statement = database.compileStatement(sql);

        statement.bindString(2, name);
        statement.bindString(3, price);
        statement.bindBlob(4, image);
       // statement.bindDouble(1, (double)id);

        statement.execute();
        database.close();*/
       ContentValues cv=new ContentValues();
        cv.put(KEY_PLACE,name);

        cv.put(KEY_DESCR,price);
        cv.put(KEY_IMG,image);
        database.update(TABLE_PLACE, cv, KEY_PLACE_ID + "= ?", new String[] { String.valueOf(id)} );
    }

    public  void deleteData(int id) {
        SQLiteDatabase database = getWritableDatabase();

        String sql = "DELETE FROM PLACE WHERE PLACE_ID = ?";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindDouble(1, (double)id);

        statement.execute();
        database.close();
    }
}



