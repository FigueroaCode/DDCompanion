package com.athon.hack.ddcompanion;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Map;

import Models.Character;


/**
 * A simple {@link Fragment} subclass.
 */
public class GameFragment extends Fragment {


    private ListView list;
    private CustomPartyListAdapter adapter;
    private ArrayList<Character> characters = new ArrayList<>();

    private DatabaseReference root = FirebaseDatabase.getInstance().getReference().getRoot();
    private ChildEventListener childListener;

    public GameFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_party, container, false);

        childListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                updateList(dataSnapshot);
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

        list = (ListView) view.findViewById(R.id.list);
        adapter = new CustomPartyListAdapter(getContext(),characters);

        list.setAdapter(adapter);

        return view;
    }

    private void updateList(DataSnapshot dataSnapshot) {
        if(!dataSnapshot.getKey().equals("Users")) {
            Map<String, Object> map = (Map<String, Object>) dataSnapshot.getValue();

            String name = (String) map.get("name");
            long hp, lvl;
            try {
                hp = (long) map.get("hitPoints");
                lvl = (long) map.get("level");
            } catch (Exception e) {
                hp = 0;
                lvl = 0;
            }
            String profession = (String) map.get("profession");
            String race = (String) map.get("race");

            Character chr = new Character(name, race);
            chr.setLevel((int) lvl);
            chr.setHitPoints((int) hp);
            chr.setProfession(profession);
            if (profession != null && race != null) {
                chr.addHPAndWealth();
                chr.addRaceStats();
            }

            characters.add(chr);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        root.addChildEventListener(childListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if(childListener != null){
            root.removeEventListener(childListener);
        }
    }
}
