package com.example.pbvmpandur.ui.gallery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.pbvmpandur.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {

    RecyclerView convRecycler,techRecycler, comRecycler,cultuRecycler,otherRecycler;
    GalleryAdapter adapter;

    DatabaseReference reference;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        convRecycler = view.findViewById(R.id.convRecycler);
        techRecycler = view.findViewById(R.id.techRecycler);
        comRecycler = view.findViewById(R.id.comRecycler);
        cultuRecycler = view.findViewById(R.id.cultuRecycler);
        otherRecycler = view.findViewById(R.id.otherRecycler);

        reference = FirebaseDatabase.getInstance().getReference().child("gallery");

        getConvImage();

        getTechIamge();

        getComImage();

        getCultuImage();

        getOtherImage();


        return view;
    }

    private void getOtherImage() {
        reference.child("Other Event").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    String data = (String) snapshot.getValue();
                    imageList.add(data);
                }

                adapter =  new GalleryAdapter(getContext(), imageList);
                otherRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                otherRecycler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void getCultuImage() {
        reference.child("Cultural").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    String data = (String) snapshot.getValue();
                    imageList.add(data);
                }

                adapter =  new GalleryAdapter(getContext(), imageList);
                cultuRecycler.setLayoutManager(new GridLayoutManager(getContext(), 4));
                cultuRecycler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void getComImage() {
        reference.child("Com-Fest").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    String data = (String) snapshot.getValue();
                    imageList.add(data);
                }

                adapter =  new GalleryAdapter(getContext(), imageList);
                comRecycler.setLayoutManager(new GridLayoutManager(getContext(), 4));
                comRecycler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void getTechIamge() {
        reference.child("Tech-Rex").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    String data = (String) snapshot.getValue();
                    imageList.add(data);
                }

                adapter =  new GalleryAdapter(getContext(), imageList);
                techRecycler.setLayoutManager(new GridLayoutManager(getContext(), 4));
                techRecycler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void getConvImage() {
        reference.child("Convocation").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    String data = (String) snapshot.getValue();
                    imageList.add(data);
                }

                adapter =  new GalleryAdapter(getContext(), imageList);
                convRecycler.setLayoutManager(new GridLayoutManager(getContext(), 4));
                convRecycler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}