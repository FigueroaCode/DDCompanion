package com.athon.hack.ddcompanion;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

import Models.Character;


public class CustomPartyListAdapter extends ArrayAdapter<Character> {

    public CustomPartyListAdapter(Context context, ArrayList<Character> list) {
        super(context, R.layout.party_row,list);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.party_row,parent,false);

        ProgressBar hpBar = (ProgressBar) view.findViewById(R.id.progressBar);
        TextView nameText = (TextView) view.findViewById(R.id.partyNameText);
        TextView lvlText = (TextView) view.findViewById(R.id.partyIdText);
        TextView classText = (TextView) view.findViewById(R.id.classText);

        String name = getItem(position).getName();
        int lvl = getItem(position).getLevel();
        String profession = getItem(position).getProfession();

        nameText.setText(name);
        lvlText.setText("Lvl "+String.valueOf(lvl));
        classText.setText(profession);

        hpBar.setMax(getItem(position).getMaxHP());
        hpBar.setProgress(getItem(position).getHitPoints());
        return view;
    }
}
