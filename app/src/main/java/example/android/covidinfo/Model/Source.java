package example.android.covidinfo.Model;

import com.google.gson.annotations.SerializedName;

public class Source {

    @SerializedName("source")
    private String sourceName;

    public Source(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getSourceName() {
        return sourceName;
    }
}
