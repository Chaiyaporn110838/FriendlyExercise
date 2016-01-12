package pjstudio.rtc.chaiyaporn.friendlyexcercise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    //Explicit
    private ManageTABLE objManageTABLE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Connect DATABASE
        objManageTABLE = new ManageTABLE(this);

        //Test Value Add
       // testAddValue();


    }//Main Method

    private void testAddValue() {
        String strTest = "Test";
        objManageTABLE.addNewValueToUser(strTest, strTest, strTest, strTest,
                strTest, strTest, strTest, strTest, strTest, strTest, strTest, strTest, strTest);
        objManageTABLE.addNewValueToSubject(strTest, strTest, strTest, strTest, strTest, strTest, strTest, strTest );
    }
}//Main Class
