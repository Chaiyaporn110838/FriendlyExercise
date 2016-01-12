package pjstudio.rtc.chaiyaporn.friendlyexcercise;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by User on 12/1/2559.
 */
public class MyOpenHelper extends SQLiteOpenHelper{
    //Explicit
    public static final String DATABASE_NEME = "Friend.db";
    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_USER_TABLE = "create table userTABLE (" +
            "_id integer primary key, " +
            "User text, " +
            "Password text, " +
            "Status text, " +
            "Name text, " +
            "Surname text, " +
            "Subject1 text, " +
            "DateSubject1 text," +
            "Subject2 text, " +
            "DateSubject2 text," +
            "Subject3 text, " +
            "DateSubject3 text," +
            "Subject4 text, " +
            "DateSubject4 text);";

    private static final String CREATE_SUBJECT_TABLE = "create table subjectTABLE (" +
            "_id integer primary key," +
            "Subject text, " +
            "Question text, " +
            "Image text, " +
            "Choice1 text, " +
            "Choice2 text, " +
            "Choice3 text, " +
            "Choice4 text," +
            "Answer text);";


    public MyOpenHelper(Context context) {
        super(context, DATABASE_NEME, null, DATABASE_VERSION);


    } // Constructor

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_SUBJECT_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
} //Cain class
