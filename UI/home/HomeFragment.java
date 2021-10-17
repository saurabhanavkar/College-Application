package com.example.pbvmpandur.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.pbvmpandur.R;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;


public class HomeFragment extends Fragment {

    private SliderLayout sliderLayout;
    private ImageView map;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        sliderLayout = view.findViewById(R.id.slider);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.SCALE);
        sliderLayout.setSliderTransformAnimation(SliderAnimations.CUBEINDEPTHTRANSFORMATION);
        sliderLayout.setScrollTimeInSec(3);

        setSliderView();

        map = view.findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
        });

        return view;
    }

    private void openMap() {
        Uri uri = Uri.parse("geo:0, 0?q=Pandur College");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }

    private void setSliderView() {
        for (int i = 0;i< 4;i++){
            DefaultSliderView sliderView = new DefaultSliderView(getContext());



            switch (i){
                case 0 :
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/pbvm-pandur.appspot.com/o/Slider%2Fcollerg.jpg?alt=media&token=bf8a49d6-244d-4f71-bcf7-5befef1c1f60");
                    break;

                 case 1 :
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/pbvm-pandur.appspot.com/o/Slider%2FDSC_1988-min.JPG?alt=media&token=c990e08c-bf0e-465f-b684-499bbd1bca63");
                    break;

                 case 2 :
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/pbvm-pandur.appspot.com/o/Slider%2FDSC_2098-min.JPG?alt=media&token=ac48dd5a-1052-422f-8ab0-5138a9d0acff");
                    break;

                 case 3 :
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/pbvm-pandur.appspot.com/o/Slider%2FDSC_2053-min.JPG?alt=media&token=73e4bf54-2de2-49db-ac74-c326227f8a5b");
                    break;



            }
            sliderView.setImageScaleType(ImageView.ScaleType.FIT_XY);

            sliderLayout.addSliderView(sliderView);
        }
    }
}