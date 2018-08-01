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

    public BuildUser(String un,String ps,String em, Boolean gn,Calendar br,ArrayList<String> tagsIn){
        mUsername = un;
        mPassword = ps;
        mEmail = em;
        gender = gn;
        mBirth = br;
        tags = tagsIn;

        Log.i("Built user from:" ,mUsername+" "+mPassword+" "+mEmail+" "+gender);


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
