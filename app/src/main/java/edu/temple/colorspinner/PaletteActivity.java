package edu.temple.colorspinner;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PaletteActivity extends AppCompatActivity implements DetailFragment.GetColorInterface {

    boolean singlePane;
    FragmentManager fm;
    DetailFragment df;
    CanvasFragment cf;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        singlePane = findViewById(R.id.container2) == null;

        df = new DetailFragment();

        fm = getSupportFragmentManager();

        fm.beginTransaction()
                .replace(R.id.container, df)
                .commit();
    }

    public void colorSelect(String colorItem) {
        cf = (new CanvasFragment()).newInstance(colorItem);
        if (singlePane) {
            fm.beginTransaction()
                    .replace(R.id.container, cf)
                    .addToBackStack(null)
                    .commit();
        } else {
            fm.beginTransaction()
                    .replace(R.id.container2, cf)
                    .addToBackStack(null)
                    .commit();
        }
    }
}