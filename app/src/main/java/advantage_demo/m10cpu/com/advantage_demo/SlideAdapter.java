package advantage_demo.m10cpu.com.advantage_demo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


public class SlideAdapter extends FragmentPagerAdapter{
    private Context context;
    private LayoutInflater layoutInflater;

    public SlideAdapter(FragmentManager fm) {
        super(fm);
    }
    //private int[] pages = {R.layout.activity_register_welcome,R.layout.activity_register_account_data};


    @Override
    public Fragment getItem(int i) {
        switch(i){
            case 0: return RegisterWelcome.newInstance();
            case 1: return RegisterAccountData.newInstance();
            case 2: return RegisterUserData.newInstance();
            case 3: return RegisterUserInfo.newInstance();
            default: return RegisterWelcome.newInstance();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
