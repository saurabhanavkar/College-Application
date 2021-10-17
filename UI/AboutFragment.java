package com.example.pbvmpandur.ui.about;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.pbvmpandur.R;

import java.util.ArrayList;
import java.util.List;


public class AboutFragment extends Fragment {

    private ViewPager viewPager;
    private CourseAdapter adapter;
    private List<CourseModel>list;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_about, container, false);

        list = new ArrayList<>();
        list.add(new CourseModel(R.drawable.ic_computer,"B.Sc.(I.T),B.Sc.(C.S)","It is a branch of B.Sc which studies elements from both electrical engineering and computer science angles,combining the principle and techniques of these two for the making and development of computer and computer-based systems.Professionals who work with computer hardware and software are termed as Computer Engineers."));
        list.add(new CourseModel(R.drawable.ic_commerce,"B.Com,B.Com(B&I)","Commerce Is the field of study in which students learn topics related to business,financial information/transactions,trading of economic values,merchandising and trading.Commerce acts as trading conduct for economic agents.It also plays a vital role in magnifying the well being of citizens by providing goods and services,which are beneficial."));

        adapter = new CourseAdapter(getContext(),list);

        viewPager = view.findViewById(R.id.viewPager);

        viewPager.setAdapter(adapter);

        ImageView imageView = view.findViewById(R.id.college_gate);

        Glide.with(getContext())
                .load("https://firebasestorage.googleapis.com/v0/b/pbvm-pandur.appspot.com/o/gallery%2Fcollege_gate.jpg?alt=media&token=41b7d6f2-74fa-4c0b-a4f4-365ba2711773")
                .into(imageView);

       return  view;
    }
}