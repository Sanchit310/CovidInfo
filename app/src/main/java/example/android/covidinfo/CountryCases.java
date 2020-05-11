package example.android.covidinfo;

public class CountryCases {

    private String countryName;
    private String confirmedCases, recoveredCases, deathCases;

    public CountryCases(String countryName, String  confirmedCases, String recoveredCases, String deathCases) {
        this.countryName = countryName;
        this.confirmedCases = confirmedCases;
        this.recoveredCases = recoveredCases;
        this.deathCases = deathCases;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getConfirmedCases() {
        return confirmedCases;
    }

    public String getRecoveredCases() {
        return recoveredCases;
    }

    public String getDeathCases() {
        return deathCases;
    }
}
