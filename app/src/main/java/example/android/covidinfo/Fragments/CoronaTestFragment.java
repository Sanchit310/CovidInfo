package example.android.covidinfo.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import example.android.covidinfo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CoronaTestFragment extends Fragment {

    TextView male, female, other, genAns, ageQues, ageAns, sympQues, cough, fever, diffInBreath, noneOne, sympAns, noneQues,
            diabetes, hyperTension, lungDisease, heartDisease, noneTwo, otherSympAns, travQues, yesTra, noTra, traAns,
            lastQues, lastOptOne, lastOptTwo, lastOptThree, lastOptAns, conclusion;
    EditText ageEditText;
    Button ageBtn;
    NestedScrollView nestedScrollView;

    public CoronaTestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_corona_test, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        nestedScrollView = view.findViewById(R.id.testScrollView);
        male = view.findViewById(R.id.male);
        female = view.findViewById(R.id.female);
        other = view.findViewById(R.id.other);
        genAns = view.findViewById(R.id.genAns);
        ageQues = view.findViewById(R.id.ageQues);
        ageAns = view.findViewById(R.id.ageAns);
        ageEditText = view.findViewById(R.id.ageEditText);
        ageBtn = view.findViewById(R.id.ageBtn);
        sympQues = view.findViewById(R.id.sympQues);
        cough = view.findViewById(R.id.cough);
        fever = view.findViewById(R.id.fever);
        diffInBreath = view.findViewById(R.id.diffInBreath);
        noneOne = view.findViewById(R.id.noneOne);
        noneQues = view.findViewById(R.id.noneQues);
        diabetes = view.findViewById(R.id.diabetes);
        hyperTension = view.findViewById(R.id.hyperTension);
        lungDisease = view.findViewById(R.id.lungDisease);
        heartDisease = view.findViewById(R.id.heartDisease);
        noneTwo = view.findViewById(R.id.noneTwo);
        sympAns = view.findViewById(R.id.sympAns);
        otherSympAns = view.findViewById(R.id.otherSymAns);
        travQues = view.findViewById(R.id.travelledQues);
        yesTra = view.findViewById(R.id.yesTra);
        noTra = view.findViewById(R.id.noTra);
        traAns = view.findViewById(R.id.travellAns);
        lastQues = view.findViewById(R.id.lastQues);
        lastOptOne = view.findViewById(R.id.lastOptOne);
        lastOptTwo = view.findViewById(R.id.lastOptTwo);
        lastOptThree = view.findViewById(R.id.lastOptThree);
        lastOptAns = view.findViewById(R.id.lastOptAns);
        conclusion = view.findViewById(R.id.conclusion);

        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        male.setVisibility(View.GONE);
                        female.setVisibility(View.GONE);
                        other.setVisibility(View.GONE);
                        String gender = male.getText().toString();
                        genAns.setVisibility(View.VISIBLE);
                        genAns.setText(gender);
                        ageQues.setVisibility(View.VISIBLE);
                        ageEditText.setVisibility(View.VISIBLE);
                        ageBtn.setVisibility(View.VISIBLE);
                        getBottom();
                    }
                }, 1000);


            }
        });

        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        male.setVisibility(View.GONE);
                        female.setVisibility(View.GONE);
                        other.setVisibility(View.GONE);
                        String gender = female.getText().toString();
                        genAns.setVisibility(View.VISIBLE);
                        genAns.setText(gender);
                        ageQues.setVisibility(View.VISIBLE);
                        ageEditText.setVisibility(View.VISIBLE);
                        ageBtn.setVisibility(View.VISIBLE);
                        getBottom();
                    }
                }, 1000);

            }
        });
        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        male.setVisibility(View.GONE);
                        female.setVisibility(View.GONE);
                        other.setVisibility(View.GONE);
                        String gender = other.getText().toString();
                        genAns.setVisibility(View.VISIBLE);
                        genAns.setText(gender);
                        ageQues.setVisibility(View.VISIBLE);
                        ageEditText.setVisibility(View.VISIBLE);
                        ageBtn.setVisibility(View.VISIBLE);
                        getBottom();
                    }
                }, 1000);

            }
        });
        ageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        String age = ageEditText.getText().toString();
                        ageEditText.setVisibility(View.GONE);
                        ageBtn.setVisibility(View.GONE);
                        ageAns.setVisibility(View.VISIBLE);
                        ageAns.setText(age);
                        sympQues.setVisibility(View.VISIBLE);
                        cough.setVisibility(View.VISIBLE);
                        fever.setVisibility(View.VISIBLE);
                        diffInBreath.setVisibility(View.VISIBLE);
                        noneOne.setVisibility(View.VISIBLE);
                        getBottom();
                    }
                }, 1000);


                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(ageEditText.getWindowToken(), 0);

            }
        });
        cough.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        cough.setVisibility(View.GONE);
                        fever.setVisibility(View.GONE);
                        diffInBreath.setVisibility(View.GONE);
                        noneOne.setVisibility(View.GONE);
                        String symptom = cough.getText().toString();
                        sympAns.setVisibility(View.VISIBLE);
                        sympAns.setText(symptom);
                        travQues.setVisibility(View.VISIBLE);
                        yesTra.setVisibility(View.VISIBLE);
                        noTra.setVisibility(View.VISIBLE);
                        getBottom();
                    }
                }, 1000);

            }
        });
        fever.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        cough.setVisibility(View.GONE);
                        fever.setVisibility(View.GONE);
                        diffInBreath.setVisibility(View.GONE);
                        noneOne.setVisibility(View.GONE);
                        String symptom = fever.getText().toString();
                        sympAns.setVisibility(View.VISIBLE);
                        sympAns.setText(symptom);
                        travQues.setVisibility(View.VISIBLE);
                        yesTra.setVisibility(View.VISIBLE);
                        noTra.setVisibility(View.VISIBLE);
                        nestedScrollView.fullScroll(View.FOCUS_DOWN);
                        getBottom();
                    }
                }, 1000);


            }
        });
        diffInBreath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        cough.setVisibility(View.GONE);
                        fever.setVisibility(View.GONE);
                        diffInBreath.setVisibility(View.GONE);
                        noneOne.setVisibility(View.GONE);
                        String symptom = diffInBreath.getText().toString();
                        sympAns.setVisibility(View.VISIBLE);
                        sympAns.setText(symptom);
                        travQues.setVisibility(View.VISIBLE);
                        yesTra.setVisibility(View.VISIBLE);
                        noTra.setVisibility(View.VISIBLE);
                        getBottom();
                    }
                }, 100);


            }
        });
        noneOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        cough.setVisibility(View.GONE);
                        fever.setVisibility(View.GONE);
                        diffInBreath.setVisibility(View.GONE);
                        noneOne.setVisibility(View.GONE);
                        String symptom = noneOne.getText().toString();
                        sympAns.setVisibility(View.VISIBLE);
                        sympAns.setText(symptom);
                        noneQues.setVisibility(View.VISIBLE);
                        diabetes.setVisibility(View.VISIBLE);
                        hyperTension.setVisibility(View.VISIBLE);
                        lungDisease.setVisibility(View.VISIBLE);
                        heartDisease.setVisibility(View.VISIBLE);
                        noneTwo.setVisibility(View.VISIBLE);
                        getBottom();
                    }
                }, 1000);


            }
        });
        diabetes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        diabetes.setVisibility(View.GONE);
                        hyperTension.setVisibility(View.GONE);
                        lungDisease.setVisibility(View.GONE);
                        heartDisease.setVisibility(View.GONE);
                        noneTwo.setVisibility(View.GONE);
                        String otherSymptom = diabetes.getText().toString();
                        otherSympAns.setVisibility(View.VISIBLE);
                        otherSympAns.setText(otherSymptom);
                        travQues.setVisibility(View.VISIBLE);
                        yesTra.setVisibility(View.VISIBLE);
                        noTra.setVisibility(View.VISIBLE);
                        getBottom();
                    }
                }, 1000);


            }
        });
        hyperTension.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        diabetes.setVisibility(View.GONE);
                        hyperTension.setVisibility(View.GONE);
                        lungDisease.setVisibility(View.GONE);
                        heartDisease.setVisibility(View.GONE);
                        noneTwo.setVisibility(View.GONE);
                        String otherSymptom = heartDisease.getText().toString();
                        otherSympAns.setVisibility(View.VISIBLE);
                        otherSympAns.setText(otherSymptom);
                        travQues.setVisibility(View.VISIBLE);
                        yesTra.setVisibility(View.VISIBLE);
                        noTra.setVisibility(View.VISIBLE);
                        getBottom();
                    }
                }, 1000);

            }
        });
        lungDisease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        diabetes.setVisibility(View.GONE);
                        hyperTension.setVisibility(View.GONE);
                        lungDisease.setVisibility(View.GONE);
                        heartDisease.setVisibility(View.GONE);
                        noneTwo.setVisibility(View.GONE);
                        String otherSymptom = lungDisease.getText().toString();
                        otherSympAns.setVisibility(View.VISIBLE);
                        otherSympAns.setText(otherSymptom);
                        travQues.setVisibility(View.VISIBLE);
                        yesTra.setVisibility(View.VISIBLE);
                        noTra.setVisibility(View.VISIBLE);
                        getBottom();
                    }
                }, 1000);

            }
        });

        heartDisease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        diabetes.setVisibility(View.GONE);
                        hyperTension.setVisibility(View.GONE);
                        lungDisease.setVisibility(View.GONE);
                        heartDisease.setVisibility(View.GONE);
                        noneTwo.setVisibility(View.GONE);
                        String otherSymptom = heartDisease.getText().toString();
                        otherSympAns.setVisibility(View.VISIBLE);
                        otherSympAns.setText(otherSymptom);
                        travQues.setVisibility(View.VISIBLE);
                        yesTra.setVisibility(View.VISIBLE);
                        noTra.setVisibility(View.VISIBLE);
                        getBottom();
                    }
                }, 1000);

            }
        });
        noneTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        diabetes.setVisibility(View.GONE);
                        hyperTension.setVisibility(View.GONE);
                        lungDisease.setVisibility(View.GONE);
                        heartDisease.setVisibility(View.GONE);
                        noneTwo.setVisibility(View.GONE);
                        String otherSymptom = noneTwo.getText().toString();
                        otherSympAns.setVisibility(View.VISIBLE);
                        otherSympAns.setText(otherSymptom);
                        travQues.setVisibility(View.VISIBLE);
                        yesTra.setVisibility(View.VISIBLE);
                        noTra.setVisibility(View.VISIBLE);
                        getBottom();
                    }
                }, 1000);

            }
        });
        yesTra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        yesTra.setVisibility(View.GONE);
                        noTra.setVisibility(View.GONE);
                        String travel = yesTra.getText().toString();
                        traAns.setVisibility(View.VISIBLE);
                        traAns.setText(travel);
                        lastQues.setVisibility(View.VISIBLE);
                        lastOptOne.setVisibility(View.VISIBLE);
                        lastOptTwo.setVisibility(View.VISIBLE);
                        lastOptThree.setVisibility(View.VISIBLE);

                        getBottom();
                    }
                }, 1000);

            }
        });
        noTra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        yesTra.setVisibility(View.GONE);
                        noTra.setVisibility(View.GONE);
                        String travel = noTra.getText().toString();
                        traAns.setVisibility(View.VISIBLE);
                        traAns.setText(travel);
                        lastQues.setVisibility(View.VISIBLE);
                        lastOptOne.setVisibility(View.VISIBLE);
                        lastOptTwo.setVisibility(View.VISIBLE);
                        lastOptThree.setVisibility(View.VISIBLE);
                        getBottom();
                    }
                }, 1000);

            }
        });
        lastOptOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        lastOptOne.setVisibility(View.GONE);
                        lastOptTwo.setVisibility(View.GONE);
                        lastOptThree.setVisibility(View.GONE);
                        String lastAns = lastOptOne.getText().toString();
                        lastOptAns.setVisibility(View.VISIBLE);
                        lastOptAns.setText(lastAns);
                        conclusion.setVisibility(View.VISIBLE);
                        getBottom();
                    }
                }, 1000);

            }
        });
        lastOptTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        lastOptOne.setVisibility(View.GONE);
                        lastOptTwo.setVisibility(View.GONE);
                        lastOptThree.setVisibility(View.GONE);
                        String lastAns = lastOptTwo.getText().toString();
                        lastOptAns.setVisibility(View.VISIBLE);
                        lastOptAns.setText(lastAns);
                        conclusion.setVisibility(View.VISIBLE);
                        getBottom();
                    }
                }, 1000);

            }
        });
        lastOptThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        lastOptOne.setVisibility(View.GONE);
                        lastOptTwo.setVisibility(View.GONE);
                        lastOptThree.setVisibility(View.GONE);
                        String lastAns = lastOptThree.getText().toString();
                        lastOptAns.setVisibility(View.VISIBLE);
                        lastOptAns.setText(lastAns);
                        lastOptThree.setFocusable(true);
                        conclusion.setVisibility(View.VISIBLE);
                        getBottom();
                    }
                }, 1000);

            }
        });


    }

    public void getBottom() {
        nestedScrollView.post(new Runnable() {
            @Override
            public void run() {
                nestedScrollView.fullScroll(View.FOCUS_DOWN);
            }
        });
    }
}
