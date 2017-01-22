package com.athon.hack.ddcompanion;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.text.TextDirectionHeuristicCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class Character_Register extends Fragment {

    private Button nextBtn;
    private EditText classAndLvl;
    private EditText background;
    private EditText playerName;
    private EditText race;
    private EditText alignment;
    private EditText expPoints;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_character__register,container,false);

        nextBtn = (Button) view.findViewById(R.id.nextButtonID);
        classAndLvl = (EditText) view.findViewById(R.id.classAndLevelID);
        background = (EditText) view.findViewById(R.id.backgroundID);
        playerName = (EditText) view.findViewById(R.id.playerNameID);
        race = (EditText) view.findViewById(R.id.raceID);
        alignment = (EditText) view.findViewById(R.id.alignmentID);
        expPoints = (EditText) view.findViewById(R.id.experiencePointsID);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Character_More_Fragment frag = Character_More_Fragment.newInstance(classAndLvl.getText().toString(),
                        background.getText().toString(),playerName.getText().toString(),
                        race.getText().toString(),alignment.getText().toString(),Integer.parseInt(expPoints.getText().toString()));

                getFragmentManager().beginTransaction().replace(R.id.content_drawer,frag).commit();
            }
        });

        return view;
    }
}
