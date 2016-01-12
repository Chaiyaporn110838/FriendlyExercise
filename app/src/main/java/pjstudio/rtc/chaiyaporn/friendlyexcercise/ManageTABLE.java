package pjstudio.rtc.chaiyaporn.friendlyexcercise;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by User on 12/1/2559.
 */
public class ManageTABLE {
    //Explicit
    private MyOpenHelper ObjMyOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase, readSqLiteDatabase;

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_USER = "User";
    public static final String COLUMN_PASSWORD = "Password";
    public static final String COLUMN_STATUS = "Status";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_SURNAME = "Surname";
    public static final String COLUMN_SUBJECT1 = "Subject1";
    public static final String COLUMN_DATESUB1 = "DateSubject1";
    public static final String COLUMN_SUBJECT2 = "Subject2";
    public static final String COLUMN_DATESUB2 = "DateSubject2";
    public static final String COLUMN_SUBJECT3 = "Subject3";
    public static final String COLUMN_DATESUB3 = "DateSubject3";
    public static final String COLUMN_SUBJECT4 = "Subject4";
    public static final String COLUMN_DATESUB4 = "DateSubject4";
    public static final String TABLE_USER = "userTABLE";

    public static final String TABLE_SUBJECT = "subjectTABLE";
    public static final String COLUMN_Subject = "Subject";
    public static final String COLUMN_Question = "Question";
    public static final String COLUMN_Image = "Image";
    public static final String COLUMN_Choice1 = "Choice1";
    public static final String COLUMN_Choice2 = "Choice2";
    public static final String COLUMN_Choice3 = "Choice3";
    public static final String COLUMN_Choice4 = "Choice4";
    public static final String COLUMN_Answer = "Answer";

    public ManageTABLE(Context context) {
        //Create & Connected
        ObjMyOpenHelper = new MyOpenHelper(context);
        writeSqLiteDatabase = ObjMyOpenHelper.getWritableDatabase();
        readSqLiteDatabase = ObjMyOpenHelper.getReadableDatabase();


    }//Constructor

}//Main class
