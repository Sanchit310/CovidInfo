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
        Toolbar toolbar = view.findViewById(R.id.faqToolbar);
        toolbar.setTitle("Myths");
        toolbar.setTitleTextColor(Color.WHITE);
        ( (AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView imageView = view.findViewById(R.id.img);


        mythList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_purple_24dp, "What is corona virus", "string/A1"));
        mythList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_purple_24dp, "What is corona virus", "string/A1"));
        mythList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_purple_24dp, "What is corona virus", "string/A1"));
        mythList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_purple_24dp, "What is corona virus", "string/A1"));
        mythList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_purple_24dp, "What is corona virus", "string/A1"));
        mythList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_purple_24dp, "What is corona virus", "string/A1"));
        mythList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_purple_24dp, "What is corona virus", "string/A1"));
        mythList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_purple_24dp, "What is corona virus", "string/A1"));
        mythList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_purple_24dp, "What is corona virus", "string/A1"));
        mythList.add(new FaqnMyth(R.drawable.ic_keyboard_arrow_down_purple_24dp, "What is corona virus", "string/A1"));


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
