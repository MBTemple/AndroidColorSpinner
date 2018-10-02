package edu.temple.colorspinner;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TextView;


public class PaletteActivity extends AppCompatActivity {

    String[] colors = {"Red", "Green", "Blue", "Cyan", "Yellow", "Magenta", "Gray", "Black", "Aqua"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        this.setTitle("Palette Activity");

        Spinner spinner = findViewById(R.id.spinner);

        CustomAdapter customAdapter = new CustomAdapter(PaletteActivity.this, colors);

        spinner.setAdapter(customAdapter);

        //prevents onItemSelected from launching immediately when app starts
        spinner.setSelection(0, false);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                //String colorSelect = adapterView.getItemAtPosition(position).toString();
                Intent intent = new Intent(PaletteActivity.this, CanvasActivity.class);
                intent.putExtra("color", colors[position]); //replace colorSelect with colors[position] and vice versa
                startActivity(intent);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    private class CustomAdapter extends BaseAdapter {
        Context context;
        String[] colors;

        private CustomAdapter(Context context, String[] colors) {
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
}

