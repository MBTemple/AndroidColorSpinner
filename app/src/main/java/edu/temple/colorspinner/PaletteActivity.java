package edu.temple.colorspinner;

import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class PaletteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        //retrieve string-array resources
        Resources res = this.getResources();
        String[] spinnerLabels = res.getStringArray(R.array.colors_array);

        final Spinner spinner = findViewById(R.id.spinner);
        CustomAdapter customAdapter = new CustomAdapter(PaletteActivity.this, spinnerLabels);
        spinner.setAdapter(customAdapter);

        //spinner.post prevents onItemSelected from launching immediately when app starts
        spinner.post(new Runnable() {
            @Override
            public void run() {
                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                        String colorSelect = adapterView.getItemAtPosition(position).toString();
                        Fragment fragment = new CanvasFragment();
                        Bundle bundle = new Bundle();
                        bundle.putString("color", colorSelect);
                        fragment.setArguments(bundle);
                        FragmentManager fragManager = getSupportFragmentManager();
                        fragManager.beginTransaction()
                                .replace(R.id.container, fragment)
                                .addToBackStack(null)
                                .commit();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {
                    }
                });
            }
        });

    }
}