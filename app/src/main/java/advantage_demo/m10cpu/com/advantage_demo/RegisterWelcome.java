package advantage_demo.m10cpu.com.advantage_demo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class RegisterWelcome extends Fragment {


    public RegisterWelcome() {
        // Required empty public constructor
    }


    public static RegisterWelcome newInstance() {
        RegisterWelcome fragment = new RegisterWelcome();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register_welcome, container, false);
    }


}
