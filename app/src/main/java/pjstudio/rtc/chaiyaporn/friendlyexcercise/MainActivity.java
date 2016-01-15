package pjstudio.rtc.chaiyaporn.friendlyexcercise;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    //Explicit
    private ManageTABLE objManageTABLE;
    private EditText userEditText, passwordEditText;
    private RadioGroup positionRadioGroup;
    private RadioButton studentRadioButton, teacherRadioButton;
    private String userString, passwordString, positionString;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //bind Widget
        bindWidget();

        //Connect DATABASE
        objManageTABLE = new ManageTABLE(this);

        //Test Value Add
       // testAddValue();
        //Delete All SQLite
        deleteAllSQLite();
        //Synchronize JSON to AQLite
        synJSONtoSQLite();


    }//Main Method

    private void synJSONtoSQLite() {
        //setup policy
        StrictMode.ThreadPolicy myPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(myPolicy);

        int intTimes = 1;
        while (intTimes <= 2) {
            //1. Create inputStream
            InputStream objInputStream = null;
            String strURLuser = "http://swiftcodingthai.com/pop/php_get_data_pop.php";
            String strURLsubject = "http://swiftcodingthai.com/pop/php_get_subject_pop.php";
            HttpPost objHttpPost = null;

            try {

                HttpClient objHttpClient = new DefaultHttpClient();
                switch (intTimes) {
                    case 1:
                        objHttpPost = new HttpPost(strURLuser);
                        break;
                    case 2:
                        objHttpPost = new HttpPost(strURLsubject);
                        break;
                } //switch
                HttpResponse objHttpResponse = objHttpClient.execute(objHttpPost);
                HttpEntity objHttpEntity = objHttpResponse.getEntity();
                objInputStream = objHttpEntity.getContent();

            } catch (Exception e) {
                Log.d("friend", "Input stream ==>" + e.toString());
            }
            //2.Create JSON String

            //3.Update to SQLite
            intTimes += 1;



        }//while

    }//synJSONtoSQLite

    public void clickSignIn(View view) {
        userString = userEditText.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();
        //Check Space
        if (userString.equals("")|| passwordString.equals("")) {
            //have space
            MyAlertDialog objMyAlertDialog = new MyAlertDialog();
            objMyAlertDialog.errorDialog(MainActivity.this,
                    "Have Space", "Please fill all Blank");
        } else {

        } //if


    }//clickSignIn

    private void bindWidget() {
        userEditText = (EditText) findViewById(R.id.editText);
        passwordEditText = (EditText) findViewById(R.id.editText2);
        positionRadioGroup = (RadioGroup) findViewById(R.id.ragPosition);
        studentRadioButton = (RadioButton) findViewById(R.id.radioButton);
        teacherRadioButton = (RadioButton) findViewById(R.id.radioButton2);
    }

    public void clickSignUp(View view) {
        startActivity(new Intent(MainActivity.this, SignUpActivity.class));
    }

    private void deleteAllSQLite() {
        SQLiteDatabase objSqLiteDatabase = openOrCreateDatabase(MyOpenHelper.DATABASE_NEME, MODE_PRIVATE, null);
        objSqLiteDatabase.delete(ManageTABLE.TABLE_USER, null, null);
        objSqLiteDatabase.delete(ManageTABLE.TABLE_SUBJECT, null, null);

    }

    private void testAddValue() {
        String strTest = "Test";
        objManageTABLE.addNewValueToUser(strTest, strTest, strTest, strTest,
                strTest, strTest, strTest, strTest, strTest, strTest, strTest, strTest, strTest);
        objManageTABLE.addNewValueToSubject(strTest, strTest, strTest, strTest, strTest, strTest, strTest, strTest );
    }
}//Main Class
