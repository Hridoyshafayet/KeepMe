package com.example.hridoy.keepme;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class NoteAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> titleAL;
    ArrayList<String> descriptionAL;

    public NoteAdapter(Context context, ArrayList<String> titleAL, ArrayList<String> descriptionAL) {
        this.context = context;
        this.titleAL = titleAL;
        this.descriptionAL = descriptionAL;
    }

    @Override
    public int getCount() {
        return titleAL.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = LayoutInflater.from(context);

        view = inflater.inflate(R.layout.list_view_item,null,false);

        TextView titleTV = view.findViewById(R.id.titleText);
        TextView descriptionTV = view.findViewById(R.id.descriptionText);

        titleTV.setText(titleAL.get(i));
        descriptionTV.setText(descriptionAL.get(i));


        return view;
    }
}
