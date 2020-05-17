package example.android.covidinfo;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FaqFragment extends Fragment {
    RecyclerView faqReyclerView;
    FaqAdapter faqnMythAdapter;
    List<FaqnMyth> faqList = new ArrayList<>();

    public FaqFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_faq, container, false);
        Toolbar toolbar = view.findViewById(R.id.faqToolbar);
        toolbar.setTitle("FAQ");
        toolbar.setTitleTextColor(Color.WHITE);
        ( (AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        faqList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_black_24dp, "What is corona virus", "string/A1"));
        faqList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_black_24dp, "What is co fsdfrona virus", "strib kfng/A1"));
        faqList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_black_24dp, "What is corona  f sdf virus", "string/A1"));
        faqList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_black_24dp, "Wh f sdfat is corona virus", "string jh dj/A1"));
        faqList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_black_24dp, "What is  sf sdcorona virus", "string/A1"));
        faqList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_black_24dp, "What is coronaf sd dsf f virus", "string/A1"));
        faqList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_black_24dp, "W fsdf hat is corona virus", "string/A1"));
        faqList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_black_24dp, "What issdfdsf  corona virus", "strinfkj hg/A1"));
        faqList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_black_24dp, "What is corons fd ffda virus", "string/A1"));
        faqList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_black_24dp, "What is corona vir us", "string/A1"));
        faqList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_black_24dp, "What is corona virf sdus", "string/A1"));
        faqList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_black_24dp, "What is corona virus", "string/A1"));
        faqList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_black_24dp, "W ghat is corona virus", "strinfh wg/A1"));
        faqList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_black_24dp, "What r hht is corona virus", "string/A1"));
        faqList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_black_24dp, "What isrjyjy corona virus", "string/A1"));
        faqList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_black_24dp, "What is co jtyy  rona virus", "string/A1"));
        faqList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_black_24dp, "What is corona uyt virus", "string/A1"));
        faqList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_black_24dp, "What is corona viruyu5e us", "string/A1"));
        faqList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_black_24dp, "What is corona virus", "string/A1"));
        faqList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_black_24dp, "Whart t try tryis c  tyuorona virus", "string/A1"));
        faqList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_black_24dp, "What is corona t ytviru yuy sy ", "string/A1"));

        faqReyclerView = view.findViewById(R.id.faqRecyclerView);
        faqReyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        faqnMythAdapter = new FaqAdapter(faqList, getActivity());
        faqnMythAdapter.setOnItemClickListener(new FaqAdapter.onItemClickListener() {
            @Override
            public void onItemClick(int postion) {
                if (!faqList.get(postion).isExpanded()){
                    faqList.get(postion).setExpanded(true);
                    faqnMythAdapter.notifyDataSetChanged();
                }else {
                    faqList.get(postion).setExpanded(false);
                    faqnMythAdapter.notifyDataSetChanged();
                }
            }
        });
        faqReyclerView.setAdapter(faqnMythAdapter);


    }
}
