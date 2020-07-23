package example.android.covidinfo.Model;

import com.google.gson.annotations.SerializedName;

public class Countries {

    @SerializedName("Country")
    private String country;

    @SerializedName("TotalConfirmed")
    private String totalConfirmedCases;

    @SerializedName("TotalRecovered")
    private String totalRecoveredCases;

    @SerializedName("TotalDeaths")
    private String totalDeathCases;

    public String getCountry() {
        return country;
    }

    public String getTotalConfirmedCases() {
        return totalConfirmedCases;
    }

    public String getTotalRecoveredCases() {
        return totalRecoveredCases;
    }

    public String getTotalDeathCases() {
        return totalDeathCases;
    }
}
