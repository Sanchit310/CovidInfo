package example.android.covidinfo;

public class Precaution {
    private int img;
    private String precautionName;
    private String precationDescription;

    public Precaution(int img, String precautionName, String precationDescription) {
        this.img = img;
        this.precautionName = precautionName;
        this.precationDescription = precationDescription;
    }

    public int getImg() {
        return img;
    }

    public String getPrecautionName() {
        return precautionName;
    }

    public String getPrecationDescription() {
        return precationDescription;
    }
}
