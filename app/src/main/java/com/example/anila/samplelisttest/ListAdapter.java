package com.example.anila.samplelisttest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends ArrayAdapter {


    List<String> mObjects=new ArrayList<String>();
    Context mContext;
    TextView mTextView;
    public ListAdapter(Context context, List objects) {
        super(context,R.layout.list_custom_layout, objects);
        mObjects=objects;
        mContext=context;

    }

    @Override
    public int getCount() {
        return mObjects.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
         LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.list_custom_layout, null);
         mTextView=convertView.findViewById(R.id.textView);
         Holder holder=new Holder(mTextView);

         holder.txtView.setText(mObjects.get(position));
         return convertView;
    }
    private  class Holder
    {
        TextView txtView;
        public Holder(TextView txt){
            txtView=txt;
        }
    }
}


