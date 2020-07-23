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
import example.android.covidinfo.Model.FaqnMyth;
import example.android.covidinfo.Adapters.MythAdapter;
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
public class MythsFragment extends Fragment {

    RecyclerView faqReyclerView;
    MythAdapter mythAdapter;
    List<FaqnMyth> mythList = new ArrayList<>();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_myths, container, false);
        Toolbar toolbar = view.findViewById(R.id.mythToolbar);
        toolbar.setTitle("Myths");
        toolbar.setTitleTextColor(Color.WHITE);
        ( (AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mythList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_purple_24dp, getString(R.string.myth1), getString(R.string.myth1a)));
        mythList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_purple_24dp, getString(R.string.myth2), getString(R.string.myth2a)));
        mythList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_purple_24dp, getString(R.string.myth3), getString(R.string.myth3a)));
        mythList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_purple_24dp, getString(R.string.myth4), getString(R.string.myth4a)));
        mythList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_purple_24dp, getString(R.string.myth5), getString(R.string.myth5a)));
        mythList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_purple_24dp, getString(R.string.myth6), getString(R.string.myth6a)));
        mythList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_purple_24dp, getString(R.string.myth7), getString(R.string.myth7a)));
        mythList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_purple_24dp, getString(R.string.myth8), getString(R.string.myth8a)));
        mythList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_purple_24dp, getString(R.string.myth9), getString(R.string.myth9a)));
        mythList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_purple_24dp, getString(R.string.myth10), getString(R.string.myth10a)));
        mythList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_purple_24dp, getString(R.string.myth11), getString(R.string.myth11a)));
        mythList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_purple_24dp, getString(R.string.myth12), getString(R.string.myth12a)));
        mythList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_purple_24dp, getString(R.string.myth13), getString(R.string.myth13a)));
        mythList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_purple_24dp, getString(R.string.myth14), getString(R.string.myth14a)));
        mythList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_purple_24dp, getString(R.string.myth15), getString(R.string.myth15a)));

        NavController navController = Navigation.findNavController(view);

        ImageView bacKBtn = view.findViewById(R.id.mythBackBtn);
        bacKBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_mythsFragment_to_mainFragment);
            }
        });

        faqReyclerView = view.findViewById(R.id.mythRecyclerView);
        faqReyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mythAdapter = new MythAdapter(getActivity(), mythList  );
        mythAdapter.setOnClickListener(new MythAdapter.OnItemclikListener() {
            @Override
            public void OnItemClick(int position) {
                if (!mythList.get(position).isExpanded()){
                    mythList.get(position).setExpanded(true);
                    mythAdapter.notifyDataSetChanged();
                }else {
                    mythList.get(position).setExpanded(false);
                    mythAdapter.notifyDataSetChanged();
                }
            }
        });
        faqReyclerView.setAdapter(mythAdapter);

    }
}
