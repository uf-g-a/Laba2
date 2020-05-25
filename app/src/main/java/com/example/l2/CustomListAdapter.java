package com.example.l2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class CustomListAdapter extends BaseAdapter {
    private ArrayList<String> listData;
    private ArrayList<String> textData;
    private ArrayList<String> nameData;
    private LayoutInflater layoutInflater;
    public CustomListAdapter(Context context, ArrayList<String> listData, ArrayList<String> textData,  ArrayList<String> nameData) {
        this.listData = listData;
        this.textData = textData;
        this.nameData = nameData;
        layoutInflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder();
            holder.icon = (ImageView) convertView.findViewById(R.id.icon);
            holder.text = (TextView) convertView.findViewById(R.id.text);
            holder.name = (TextView) convertView.findViewById(R.id.name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.text.setText(textData.get(position));
        holder.name.setText(nameData.get(position));
        if (holder.icon != null) {
            new BitmapWorkerTask(holder.icon).execute(listData.get(position));
        }
        return convertView;
    }
    class ViewHolder {
        ImageView icon;
        TextView text;
        TextView name;
    }
    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public int getCount() {
        return listData.size();
    }
}