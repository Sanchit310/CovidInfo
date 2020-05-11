package example.android.covidinfo;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Covid {

    @SerializedName("Countries")
    private ArrayList<Countries> countries;

    @SerializedName("Global")
    private Global global;

    public ArrayList<Countries> getCountries() {
        return countries;
    }

    public Global getGlobal() {
        return global;
    }
}
