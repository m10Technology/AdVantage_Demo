package advantage_demo.m10cpu.com.advantage_demo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Vibrator;

import java.util.ArrayList;
import java.util.List;

public class UserInfoAdapter extends RecyclerView.Adapter<UserInfoAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView buttonText;
        public ImageView buttonIcon;
        public View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            buttonText = (TextView) view.findViewById(R.id.firstLine);
            buttonIcon = (ImageView)view.findViewById(R.id.itemicon);

        }

    }


    private ArrayList<String> itemTexts;
    private ArrayList<String> itemIcons;
    private ViewGroup vg;
    private ViewHolder vh;
    private RegisterUserInfo mParent;


    public UserInfoAdapter(ArrayList<String> texts, RegisterUserInfo parent){
        itemTexts = texts;
        mParent = parent;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View v = inflater.inflate(R.layout.user_info_button_layout,viewGroup,false);

        vg = viewGroup;
        vh = new ViewHolder(v);
        return vh;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {



        final String itemText = itemTexts.get(i);
        String itemIcon = itemTexts.get(i);

        viewHolder.buttonIcon.setImageResource(R.drawable.appicon);
        viewHolder.buttonText.setText(itemText);
        viewHolder.buttonIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mParent.buttonClicked(itemText);
            }
        });

    }

    public void add(int pos, String text){
        itemTexts.add(pos,text);
       // itemIcons.add(pos,icon);
        notifyItemInserted(pos);
    }

    public void remove(int pos){
        itemTexts.remove(pos);
        //itemIcons.remove(pos);
        notifyItemRemoved(pos);
    }

    @Override
    public int getItemCount() {
        return itemTexts.size();
    }



}
