package edu.temple.colorspinner;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    Context context;
    String[] colors;

    public CustomAdapter(Context context, String[] colors) {
        this.context = context;
        this.colors = colors;
    }

    @Override
    public int getCount() {
        return colors.length;
    }

    @Override
    public Object getItem(int position) {
        return colors[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        TextView colorName = new TextView(context);
        colorName.setText(colors[position]);
        colorName.setTextSize(24);
        colorName.setTextColor(Color.WHITE);
        colorName.setBackgroundColor(Color.parseColor(colors[position]));
        return colorName;
    }
}
