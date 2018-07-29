package advantage_demo.m10cpu.com.advantage_demo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


public class RegisterAccountData extends Fragment {

    private String username;
    private String email;
    private String password;

    private View view;

    public String getUsername(){
        return username;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }


    public boolean fillInfo(){
        try{
            TextView textView = (TextView)view.findViewById(R.id.username_form);
                username = textView.getText().toString();
            textView = (TextView)view.findViewById(R.id.password_form);
                password = textView.getText().toString();
            textView = (TextView)view.findViewById(R.id.email_form);
                email = textView.getText().toString();
             return true;

        }catch(Exception e){
            return false;
        }
    }

    public RegisterAccountData() {
        // Required empty public constructor
    }


    public static RegisterAccountData newInstance() {
        RegisterAccountData fragment = new RegisterAccountData();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_register_account_data, container, false);
        return view;
    }


}
