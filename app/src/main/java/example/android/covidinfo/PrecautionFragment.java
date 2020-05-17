package example.android.covidinfo;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class PrecautionFragment extends Fragment {
    ViewPager viewPager;
    PrecautionPagerAdapter precautionPagerAdapter;
    List<Precaution> precautionList = new ArrayList<>();


    public PrecautionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_precaution, container, false);
        Toolbar toolbar = view.findViewById(R.id.precautionToolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        toolbar.setTitle("Precautions");
        toolbar.setTitleTextColor(Color.WHITE);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager = view.findViewById(R.id.precautionViewPager);




        precautionList.add(new Precaution(R.drawable.wash_hand, "Wash Hand", "washk  hkf kjfh kjsafh ksajfh klsa alkhgsd kgshgiuwh ;ewohg dklhf"));
        precautionList.add(new Precaution(R.drawable.stay_home, "Stay Home", "jk hakfhauidsh fkashf kashdf kahsfkjhs dkfhaskdfh asdhfdkshf sf"));
        precautionList.add(new Precaution(R.drawable.face_mask, "Wear Mask", "jk hakfhauidsh fkashf kashdf kahsfkjhs dkfhaskdfh asdhfdkshf sf"));
        precautionList.add(new Precaution(R.drawable.keep_distance, "Maintain Distance", "jk hakfhauidsh fkashf kashdf kahsfkjhs dkfhaskdfh asdhfdkshf sf"));
        precautionList.add(new Precaution(R.drawable.emergency_call, "Call for help", "jk hakfhauidsh fkashf kashdf kahsfkjhs dkfhaskdfh asdhfdkshf sf"));

        precautionPagerAdapter = new PrecautionPagerAdapter(getActivity(), precautionList);
        viewPager.setPageMargin(16);
        viewPager.setAdapter(precautionPagerAdapter);


    }
}
