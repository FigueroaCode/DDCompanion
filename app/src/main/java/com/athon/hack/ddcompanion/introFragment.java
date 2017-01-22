package com.athon.hack.ddcompanion;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class IntroFragment extends Fragment {


    private Button contBtn;
    private Button restartBtn;

    public IntroFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_intro, container, false);

        contBtn = (Button) view.findViewById(R.id.continueBtn);
        restartBtn = (Button) view.findViewById(R.id.restartBtn);

        contBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Character_Register frag = new Character_Register();
                getFragmentManager().beginTransaction().replace(R.id.content_drawer,frag).commit();
            }
        });

        restartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Character_Register frag = new Character_Register();
                getFragmentManager().beginTransaction().replace(R.id.content_drawer,frag).commit();
            }
        });
        return view;
    }

}
