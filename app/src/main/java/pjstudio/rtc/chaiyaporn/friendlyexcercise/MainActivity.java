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



    }//Main Method
}//Main Class
