package example.android.covidinfo;

import android.graphics.Color;
import android.media.Image;
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
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class SymptomFragment extends Fragment {
    RecyclerView symptomRecyclerView;
    SymptomAdapter symptomAdapter;
    ArrayList<Symptom> symptomsList = new ArrayList<>();

    public SymptomFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_symptom, container, false);

        Toolbar toolbar = view.findViewById(R.id.symptomToolbar);
       ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
       toolbar.setTitleTextColor(Color.WHITE);
       return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        NavController navController = Navigation.findNavController(view);

        ImageView backBtn = view.findViewById(R.id.symBackBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_symptomFragment_to_mainFragment);
            }
        });

        symptomsList.add(new Symptom(R.drawable.fever, "Fever", "kahfh jf kag kgha fkfg ajkdash fhfbjfabj fj"));

        symptomsList.add(new Symptom(R.drawable.coughing, "Dry Cough", "kjewhf kahf kj ksdgh goih\nergi akgh lkahbg jdsh khs  blg\n bgj abgjkaskjhfs hk hfk fg "));
        symptomsList.add(new Symptom(R.drawable.person_tired, "Tiredness", "fg alihalgi liah dislhg sbhga dgsdgh afl"));
        symptomsList.add(new Symptom(R.drawable.back_pain, "Aches and Pains", "ksj agfjk sgfkafdjf hhdsjf "));
        symptomsList.add(new Symptom(R.drawable.throat, "Soar Throat", "jhg fjakgd gafkyga fgafk "));
        symptomsList.add(new Symptom(R.drawable.diarrhoea, "Diarrhea", "fk hkfagiluwgh b k;ajb jhahoh skkh ihca iadhihf a;o"));
        symptomsList.add(new Symptom(R.drawable.headache, "Headache", "k hdsbaf lfhouy7aufi gfdsf sduh filahfiluah fli "));
        symptomsList.add(new Symptom(R.drawable.taste, "Loss in taste or Smell", "l ahflhahf iagh adgaygh8 a87 yguh "));
        symptomsList.add(new Symptom(R.drawable.skin, "Rash on Skin", "k ahlgh lughilayf8ywh he fywf yhiu fohf hf eyfh sdhbk;sd fh "));
        symptomsList.add(new Symptom(R.drawable.difficulty_breathing, "Difficulty in Breathing", "f fegfgwefg jfgdsjfygw3 gf agfi af "));
        symptomsList.add(new Symptom(R.drawable.chest_pain, "Chest Pain or Pressure", "kf fguagf khgiag biw yfaihfw9ay 8wg fgf is"));

        symptomRecyclerView = view.findViewById(R.id.symptomRecyclerView);
        symptomRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        symptomAdapter = new SymptomAdapter(symptomsList, getActivity());
        symptomRecyclerView.setAdapter(symptomAdapter);


    }
}
