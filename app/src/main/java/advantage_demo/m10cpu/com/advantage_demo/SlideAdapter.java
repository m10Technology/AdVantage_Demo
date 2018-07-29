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
    private Fragment[] myPages;


    public SlideAdapter(FragmentManager fm) {
        super(fm);
        myPages = new Fragment[4];
    }

    @Override
    public Fragment getItem(int i) {
        switch(i){
            case 0: myPages[0] = RegisterWelcome.newInstance(); return myPages[0];
            case 1: myPages[1] = RegisterAccountData.newInstance(); return myPages[1];
            case 2: myPages[2] = RegisterUserData.newInstance(); return myPages[2];
            case 3: myPages[3] = RegisterUserInfo.newInstance(); return myPages[3];
            default: myPages[0] = RegisterWelcome.newInstance(); return myPages[0];
        }
    }

    public Fragment[] getMyPages() {
        return myPages;
    }


    @Override
    public int getCount() {
        return 4;
    }
}
