package advantage_demo.m10cpu.com.advantage_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.journeyapps.barcodescanner.CaptureActivity;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //openScanner();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent){
            IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode,resultCode,intent);
            if(intentResult !=null){
                if(CodeManager.validCode(intentResult.getContents())){
                    Intent adIntent = new Intent(MainActivity.this,VideoAdActivity.class);
                    MainActivity.this.startActivity(adIntent);
                }
                else{
                    Toast toast = Toast.makeText(getBaseContext(),"Not a valid AdVantage code, please retry.",Toast.LENGTH_LONG);
                    toast.show();
                    openScanner();
                }
                }else{
                    Toast toast = Toast.makeText(getBaseContext(),"No QR code found, please retry.",Toast.LENGTH_LONG);
                    toast.show();
                    openScanner();
                }

    }

    public void scanButtonClicked(View view){
        openScanner();
    }

    private void openScanner(){
        IntentIntegrator scanIntegrator = new IntentIntegrator(MainActivity.this);
        scanIntegrator.setPrompt("Scan AdVantage Code");
        scanIntegrator.setBeepEnabled(true);
        scanIntegrator.setOrientationLocked(true);
        scanIntegrator.setBarcodeImageEnabled(false);
        scanIntegrator.setCaptureActivity(CaptureActivityPortrait.class);
        scanIntegrator.initiateScan(IntentIntegrator.QR_CODE_TYPES);
    }

    public void captureCode(View view){

    }

}


