package advantage_demo.m10cpu.com.advantage_demo;


import android.util.Log;

import java.util.*;

public class BuildUser {

    ArrayList<String> tags = new ArrayList();
    String mUsername;
    String mPassword;
    String mEmail;
    Calendar mBirth;
    Boolean gender;

    public BuildUser(String un,String ps,String em, Boolean gn,Calendar br){
        mUsername = un;
        mPassword = ps;
        mEmail = em;
        gender = gn;
        mBirth = br;
    }

    public BuildUser(String un,String ps, String em){
        mUsername = un;
        mPassword = ps;
        mEmail = em;

        Log.i("Build User","User build with info " + mUsername+" "+mPassword+" "+mEmail);
    }


    public void addTag(String tag){
        tags.add(tag);
    }
    public void setmUsername(String username) {mUsername = username;};
    public void setmPassword(String password) {mPassword = password;};
    public void setmEmail(String email) {mEmail = email;};
    public void setmBirth(Calendar date) {mBirth = date;};
    public void setGender(Boolean genderIn) {gender = genderIn;};

    public BuildUser getUser() {return this;};

}
