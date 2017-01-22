package com.athon.hack.ddcompanion;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Map;

import Models.Character;


public class Character_More_Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";
    private static final String ARG_PARAM4 = "param4";
    private static final String ARG_PARAM5 = "param5";
    private static final String ARG_PARAM6 = "param6";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String mParam3;
    private String mParam4;
    private String mParam5;
    private int mParam6;


    private Button okBtn;
    private EditText ideals;
    private EditText traits;
    private EditText bonds;
    private EditText flaws;
    private EditText lvl;

    private FirebaseAuth myAuth;

    private String NAME;
    private String currentKey;
    private DatabaseReference root = FirebaseDatabase.getInstance().getReference().getRoot();
    private DatabaseReference userRoot = FirebaseDatabase.getInstance().getReference().getRoot().child("Users");
    private ChildEventListener childEventListener;

    public Character_More_Fragment() {
        // Required empty public constructor
    }

    public static Character_More_Fragment newInstance(String param1, String param2,String param3, String param4,String param5, int param6) {
        Character_More_Fragment fragment = new Character_More_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putString(ARG_PARAM3, param3);
        args.putString(ARG_PARAM4, param4);
        args.putString(ARG_PARAM5, param5);
        args.putInt(ARG_PARAM6, param6);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mParam3 = getArguments().getString(ARG_PARAM3);
            mParam4 = getArguments().getString(ARG_PARAM4);
            mParam5 = getArguments().getString(ARG_PARAM5);
            mParam6 = getArguments().getInt(ARG_PARAM6);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_character__more_, container, false);

        okBtn = (Button) view.findViewById(R.id.OkButtonID);
        ideals = (EditText) view.findViewById(R.id.IdealsID);
        traits = (EditText) view.findViewById(R.id.PersonalityTraitsID);
        bonds = (EditText) view.findViewById(R.id.BondsID);
        flaws = (EditText) view.findViewById(R.id.FlawsID);
        lvl = (EditText) view.findViewById(R.id.lvlId);
        myAuth = FirebaseAuth.getInstance();
        NAME = myAuth.getCurrentUser().getDisplayName();

        //child listener
        childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                getInfo(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

        okBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String profession = mParam1;
                String background = mParam2;
                String name = mParam3;
                String race = mParam4;
                String alignment = mParam5;
                int exp = mParam6;
                String ideal = ideals.getText().toString();
                String trait = traits.getText().toString();
                String bond = bonds.getText().toString();
                String flaw = flaws.getText().toString();
                int level = Integer.parseInt(lvl.getText().toString());


                String key = root.push().getKey();
                Character chr = new Character(alignment,bond,exp,flaw,ideal,level,name,profession,race,trait,background,key,NAME);

                chr.addHPAndWealth();
                chr.addRaceStats();
                root.child(key).setValue(chr);

                userRoot.child(currentKey).child("created").setValue("true");

                //Go to Game Frag
                GameFragment frag = new GameFragment();
                getFragmentManager().beginTransaction().replace(R.id.content_drawer,frag).commit();
            }
        });

        return view;
    }

    private void getInfo(DataSnapshot dataSnapshot) {
        Map<String,Object> map = (Map<String,Object>) dataSnapshot.getValue();

        String name = (String)map.get("name");

        if(NAME.equals(name)){
            currentKey = dataSnapshot.getKey();
        }

    }

    @Override
    public void onStart() {
        super.onStart();
        userRoot.addChildEventListener(childEventListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if(childEventListener != null){
            userRoot.removeEventListener(childEventListener);
        }
    }
}
