package pjstudio.rtc.chaiyaporn.friendlyexcercise;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;

public class SignUpActivity extends AppCompatActivity {
    //Explicit
    private EditText userEditText, passwordEditText, nameEditText, surnameEditText;
    private static final String blankSTRING = "na";
    private String userString, passwordString, nameString, surnameString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //bind Widget
        bindWidget();
    }//main method

    private void bindWidget() {
        userEditText = (EditText) findViewById(R.id.editText3);
        passwordEditText = (EditText) findViewById(R.id.editText4);
        nameEditText = (EditText) findViewById(R.id.editText5);
        surnameEditText = (EditText) findViewById(R.id.editText6);
    }

    public void clickSaveData(View view) {

        userString = userEditText.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();
        nameString = nameEditText.getText().toString().trim();
        surnameString = surnameEditText.getText().toString().trim();

        //Check Space
        if (userString.equals("") ||
                passwordString.equals("") ||
                nameString.equals("") ||
                surnameString.equals("")) {
            //Have space
            MyAlertDialog objMyAlertDialog = new MyAlertDialog();
            objMyAlertDialog.errorDialog(SignUpActivity.this, "Have Space", "Please Fill All Blank");

        } else {
            //No space
            updateNewStudent();

        } //if


    }//ClickSaveData

    private void updateNewStudent() {
        //setup New policy
        StrictMode.ThreadPolicy myPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(myPolicy);
        //Update mySQL
        try {
            ArrayList<NameValuePair> objNameValuePairs = new ArrayList<NameValuePair>();
            objNameValuePairs.add(new BasicNameValuePair("isAdd","true"));
            objNameValuePairs.add(new BasicNameValuePair("User",userString));
            objNameValuePairs.add(new BasicNameValuePair("Password", passwordString));
            objNameValuePairs.add(new BasicNameValuePair("Name", nameString));
            objNameValuePairs.add(new BasicNameValuePair("Surname", surnameString));

            String strURL = "http://swiftcodingthai.com/pop/php_add_data_pop.php";
            HttpClient objHttpClient = new DefaultHttpClient();
            HttpPost objHttpPost = new HttpPost(strURL);
            objHttpPost.setEntity(new UrlEncodedFormEntity(objNameValuePairs, "UTF-8"));
            objHttpClient.execute(objHttpPost);
            Toast.makeText(SignUpActivity.this, "Update Finish", Toast.LENGTH_SHORT).show();
            finish();

        } catch (Exception e) {
            Toast.makeText(SignUpActivity.this, "Can't Update New Value to Server", Toast.LENGTH_SHORT).show();
        }
    }//updateNewStudent
}//main class
