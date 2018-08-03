package advantage_demo.m10cpu.com.advantage_demo;

import android.content.Intent;

/*
    AdVantage Code Manager handles checking codes sent in and authenticates it
    Step 1: Ensure its AdVantage Certified, Encrypted passcode unique to each QR code created for AdVantage is Checked for validity
    Step 2: Each QR Code has a Location embedded inside it, this is compared to the users Phones current location and checked for validity

 */


public class CodeManager {

    public static boolean validCode(String codeValue){
        if(codeValue.contains("AdVantageCODE:")){
            return true;
        }
        else return false;
    }



}
