package example.android.covidinfo;

import com.google.gson.annotations.SerializedName;

public class Global {

    @SerializedName("TotalConfirmed")
    private String worldConfirmedCases;

    @SerializedName("TotalRecovered")
    private String worldRecoveredCases;

    @SerializedName("TotalDeaths")
    private String worldDeathCases;

    public String getWorldConfirmedCases() {
        return worldConfirmedCases;
    }

    public String getWorldRecoveredCases() {
        return worldRecoveredCases;
    }

    public String getWorldDeathCases() {
        return worldDeathCases;
    }
}
