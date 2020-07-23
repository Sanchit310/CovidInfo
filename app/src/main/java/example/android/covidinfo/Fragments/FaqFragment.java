package example.android.covidinfo.Fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import example.android.covidinfo.Adapters.FaqAdapter;
import example.android.covidinfo.Model.FaqnMyth;
import example.android.covidinfo.R;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

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

        faqList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_black_24dp, getString(R.string.q1), getString(R.string.a1)));
        faqList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_black_24dp, getString(R.string.q2), getString(R.string.a2)));
        faqList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_black_24dp, getString(R.string.q3), getString(R.string.a3)));
        faqList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_black_24dp, getString(R.string.q4), getString(R.string.a4)));
        faqList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_black_24dp, getString(R.string.q5), getString(R.string.a5)));
        faqList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_black_24dp, getString(R.string.q6), getString(R.string.a6)));
        faqList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_black_24dp, getString(R.string.q7), getString(R.string.a7)));
        faqList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_black_24dp, getString(R.string.q8), getString(R.string.a8)));
        faqList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_black_24dp, getString(R.string.q9), getString(R.string.a9)));
        faqList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_black_24dp, getString(R.string.q10), getString(R.string.a10)));
        faqList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_black_24dp, getString(R.string.q11), getString(R.string.a11)));
        faqList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_black_24dp, getString(R.string.q12), getString(R.string.a12)));
        faqList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_black_24dp, getString(R.string.q13), getString(R.string.a13)));
        faqList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_black_24dp, getString(R.string.q14), getString(R.string.a14)));
        faqList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_black_24dp, getString(R.string.q15), getString(R.string.a15)));

        ImageView backBtn = view.findViewById(R.id.faqBackBtn);
        NavController navController = Navigation.findNavController(view);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_faqFragment_to_mainFragment);
            }
        });

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
