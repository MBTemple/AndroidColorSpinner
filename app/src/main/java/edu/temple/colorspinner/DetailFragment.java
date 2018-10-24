package edu.temple.colorspinner;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;

public class DetailFragment extends android.support.v4.app.Fragment {

    Context parent;
    View view;

    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.parent = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate fragment's layout
        view = inflater.inflate(R.layout.fragment_detail, container, false);

        final Spinner spinner = view.findViewById(R.id.spinner);

        //retrieve string-array resources
        Resources res = this.getResources();
        String[] spinnerLabels = res.getStringArray(R.array.colors_array);


        CustomAdapter customAdapter = new CustomAdapter(parent, spinnerLabels);
        spinner.setAdapter(customAdapter);

        //spinner.post prevents onItemSelected from launching immediately when app starts
        spinner.post(new Runnable() {
            @Override
            public void run() {
                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                        String colorItem = (String) adapterView.getItemAtPosition(position);
                        ((GetColorInterface) parent).colorSelect(colorItem);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });
            }
        });
        return view;
    }

    interface GetColorInterface {
        void colorSelect(String color);
    }

    public static DetailFragment newInstance() {
        Bundle args = new Bundle();
        DetailFragment fragment = new DetailFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
