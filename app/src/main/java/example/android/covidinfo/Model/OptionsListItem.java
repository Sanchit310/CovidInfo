package example.android.covidinfo.Model;

public class OptionsListItem {

    private int imageUrl;
    private  String optionName;

    public OptionsListItem(int imageUrl, String optionName) {
        this.imageUrl = imageUrl;
        this.optionName = optionName;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public String getOptionName() {
        return optionName;
    }
}
