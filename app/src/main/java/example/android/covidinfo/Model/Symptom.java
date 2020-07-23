package example.android.covidinfo.Model;

public class Symptom {

    private int symptomImage;
    private String symptomName;
    private  String symptomDesc;

    public Symptom(int symptomImage, String symptomName, String symptomDesc) {
        this.symptomImage = symptomImage;
        this.symptomName = symptomName;
        this.symptomDesc = symptomDesc;
    }

    public int getSymptomImage() {
        return symptomImage;
    }

    public String getSymptomName() {
        return symptomName;
    }

    public String getSymptomDesc() {
        return symptomDesc;
    }
}
