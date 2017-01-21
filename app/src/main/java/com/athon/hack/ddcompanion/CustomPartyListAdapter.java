package com.athon.hack.ddcompanion;

import android.content.Context;
import android.widget.ArrayAdapter;


public class CustomPartyListAdapter extends ArrayAdapter {
    public CustomPartyListAdapter(Context context, int resource) {
        super(context, R.layout.party_row);
    }
}
