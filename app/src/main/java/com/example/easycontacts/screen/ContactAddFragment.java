package com.example.easycontacts.screen;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.easycontacts.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactAddFragment extends Fragment {


    public ContactAddFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact_add, container, false);
    }

}