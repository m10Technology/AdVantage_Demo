package advantage_demo.m10cpu.com.advantage_demo;


import java.util.*;

public class BuildUser {

    ArrayList<String> tags = new ArrayList();
    String musername;
    String mPassword;
    String mEmail;
    Date mBirth;
    Boolean gender;

    public BuildUser(){

    }

    public void addTag(String tag){
        tags.add(tag);
    }


}
