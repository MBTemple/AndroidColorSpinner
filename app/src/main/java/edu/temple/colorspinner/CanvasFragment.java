package edu.temple.colorspinner;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CanvasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

public class CanvasFragment extends Fragment {

    private static final String COLOR_KEY = "color";
    String color;
    View view;

    public CanvasFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Bundle bundle = getArguments();
            this.color = bundle.getString(COLOR_KEY);
        }
    }

    public static CanvasFragment newInstance(String color) {
        CanvasFragment canvasFragment = new CanvasFragment();
        Bundle args = new Bundle();
        args.putString(CanvasFragment.COLOR_KEY, color);
        canvasFragment.setArguments(args);
        return canvasFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_canvas, container, false);
        View fragView = view.findViewById(R.id.canvasFrag);
        fragView.setBackgroundColor(Color.parseColor(color));
        return view;
    }

    public static CanvasFragment newInstance() {
        Bundle args = new Bundle();
        CanvasFragment fragment = new CanvasFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
