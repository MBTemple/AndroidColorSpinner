package edu.temple.colorspinner;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        this.setTitle("Canvas Activity");

        Intent getIntent = getIntent();
        findViewById(R.id.background).setBackgroundColor(Color.parseColor(
                getIntent.getStringExtra("color")));

        /*
        RelativeLayout relativeLayout = findViewById(R.id.background);

        //Sends user back to Palette Activity when they click on the background

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CanvasActivity.this, PaletteActivity.class);
                startActivity(intent);
            }
        });
        */
    }
}