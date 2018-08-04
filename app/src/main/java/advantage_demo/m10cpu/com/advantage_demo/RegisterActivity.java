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

import javax.net.ssl.HttpsURLConnection;

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

            if(registerUser(myUser)){
                Toast toast = Toast.makeText(getBaseContext(),"Account Created Successfully!",Toast.LENGTH_LONG);
                toast.show();
                finish();
            }else{
                Toast toast = Toast.makeText(getBaseContext(),"Error! Something went wrong...",Toast.LENGTH_LONG);
                toast.show();
            }

        }

        if(slideViewPager.getCurrentItem()+2 == slideAdapter.getCount()){
            nextButton.setText("Done");
        }
        slideViewPager.setCurrentItem(slideViewPager.getCurrentItem()+1);

    }

    public boolean registerUser(BuildUser myUser){

        String data = "";
        int tmp;

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        try{
            URL url = new URL("http://68.134.243.17/register.php");
            String urlParams = "name="+myUser.mUsername+"&password="+myUser.mPassword+"&email="+myUser.mEmail+"&gender="+myUser.getGender()+"&date="+myUser.getDate()+"&tags="+myUser.tagString;

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);
            OutputStream os = urlConnection.getOutputStream();
            os.write(urlParams.getBytes());
            os.flush();
            os.close();

            InputStream is = urlConnection.getInputStream();
            while((tmp=is.read())!=1){
                data+= (char)tmp;
                Log.i("",data);
                if(data.contains("SQL Query Complete!")){
                    is.close();
                    urlConnection.disconnect();
                    return true;
                }
            }
            is.close();
            urlConnection.disconnect();



        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return false;
    }

}


