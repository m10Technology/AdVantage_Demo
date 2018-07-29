package advantage_demo.m10cpu.com.advantage_demo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;


public class RegisterUserInfo extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ImageView checkBox1;
    private ImageView checkBox2;
    private ImageView checkBox3;
    private ImageView checkBox4;
    private ViewGroup vg;
    private ArrayList<String> itemsSelected;

    public RegisterUserInfo() {
        // Required empty public constructor
    }


    public static RegisterUserInfo newInstance() {
        RegisterUserInfo fragment = new RegisterUserInfo();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vg = container;
        itemsSelected = new ArrayList<>();

        View myView = inflater.inflate(R.layout.fragment_register_user_info, container, false);
        recyclerView = (RecyclerView) myView.findViewById(R.id.rcView);
        recyclerView.setHasFixedSize(true);

        checkBox1 = (ImageView)myView.findViewById(R.id.itemSelected1);
        checkBox2 = (ImageView)myView.findViewById(R.id.itemSelected2);
        checkBox3 = (ImageView)myView.findViewById(R.id.itemSelected3);
        checkBox4 = (ImageView)myView.findViewById(R.id.itemSelected4);


        layoutManager = new GridLayoutManager(container.getContext(),3);
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<String> Items = new ArrayList<>();
        Items.add("Sports");
        Items.add("Video Games");
        Items.add("Health");
        Items.add("Outdoors");
        Items.add("Education");
        Items.add("Local Events");
        Items.add("Artists");
        Items.add("Show me all special offers");
        Items.add("Outdoors");
        Items.add("Technology");
        mAdapter = new UserInfoAdapter(Items, this);
        recyclerView.setAdapter(mAdapter);

        return myView;
    }

    public void buttonClicked(String buttonText){
        Vibrator v = (Vibrator) vg.getContext().getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(20);

        if(!itemsSelected.contains(buttonText)){
            Log.i("","Added");
            itemsSelected.add(buttonText);
        }
        else{
            Log.i("","Removed");
            itemsSelected.remove(buttonText);
        }

        int mSize = itemsSelected.size();

        if(mSize == 0){
            Log.i("","Got 0"); checkBox1.setImageResource(R.drawable.empty_circle); checkBox2.setImageResource(R.drawable.empty_circle); checkBox3.setImageResource(R.drawable.empty_circle); checkBox4.setImageResource(R.drawable.empty_circle);
        }else if(mSize == 1){
            Log.i("","Got 1"); checkBox1.setImageResource(R.drawable.check_circle); checkBox2.setImageResource(R.drawable.empty_circle); checkBox3.setImageResource(R.drawable.empty_circle); checkBox4.setImageResource(R.drawable.empty_circle);
        }else if(mSize ==2){
            Log.i("","Got 2"); checkBox1.setImageResource(R.drawable.check_circle); checkBox2.setImageResource(R.drawable.check_circle); checkBox3.setImageResource(R.drawable.empty_circle); checkBox4.setImageResource(R.drawable.empty_circle);
        }else if(mSize ==3){
            Log.i("","Got 3"); checkBox1.setImageResource(R.drawable.check_circle); checkBox2.setImageResource(R.drawable.check_circle); checkBox3.setImageResource(R.drawable.check_circle); checkBox4.setImageResource(R.drawable.empty_circle);
        }else if(mSize ==4){
            Log.i("","Got 4"); checkBox1.setImageResource(R.drawable.check_circle); checkBox2.setImageResource(R.drawable.check_circle); checkBox3.setImageResource(R.drawable.check_circle); checkBox4.setImageResource(R.drawable.check_circle);
        }


    }

}
