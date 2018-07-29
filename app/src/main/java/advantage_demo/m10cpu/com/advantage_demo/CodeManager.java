package advantage_demo.m10cpu.com.advantage_demo;

import android.content.Intent;

public class CodeManager {

    public static boolean validCode(String codeValue){
        if(codeValue.contains("AdVantageCODE:")){
            return true;
        }
        else return false;
    }

    public static void openAd(){

    }

}
