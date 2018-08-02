package advantage_demo.m10cpu.com.advantage_demo;

import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity {

    private ViewPager slideViewPager;
    private LinearLayout dotsContainer;
    private SlideAdapter slideAdapter;

    private Button backButton;
    private Button nextButton;

    private BuildUser myUser;
    private Fragment[] myPages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        backButton = (Button) findViewById(R.id.backButton);
        nextButton = (Button) findViewById(R.id.nextButton);

        slideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
       // dotsContainer = (LinearLayout) findViewById(R.id.dotsContainer);

        slideAdapter = new SlideAdapter(getSupportFragmentManager());
        slideViewPager.setAdapter(slideAdapter);
    }

    public void backButtonClick(View view){
        if(slideViewPager.getCurrentItem() != slideAdapter.getCount()){
            nextButton.setText("Next");
        }
        slideViewPager.setCurrentItem(slideViewPager.getCurrentItem()-1);
    }
    public void nextButtonClick(View view){
        if(nextButton.getText().equals("Done")){
            //Build User
            myPages = slideAdapter.getMyPages();

            RegisterAccountData accountDataPage = (RegisterAccountData)myPages[1];
            accountDataPage.fillInfo();
            String username = accountDataPage.getUsername();
            String email = accountDataPage.getEmail();
            String password = accountDataPage.getPassword();


            RegisterUserData userDataPage = (RegisterUserData)myPages[2];
            Boolean gender = null;
            Calendar date = null;
            try {
                gender = userDataPage.getGender();
                date = userDataPage.getMyCal();
            }catch(Exception e){}

            RegisterUserInfo userInfoPage = (RegisterUserInfo)myPages[3];
            ArrayList<String> tags = userInfoPage.getTags();

            myUser = new BuildUser(username,password,email,gender,date,tags);



        }

        if(slideViewPager.getCurrentItem()+2 == slideAdapter.getCount()){
            nextButton.setText("Done");
        }
        slideViewPager.setCurrentItem(slideViewPager.getCurrentItem()+1);

    }


}


