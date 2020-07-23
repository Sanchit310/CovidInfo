package example.android.covidinfo.Model;

public class FaqnMyth {

    private int img;
    private String ques, ans;
    private boolean expanded = false;

    public FaqnMyth(int img, String ques, String ans) {
        this.img = img;
        this.ques = ques;
        this.ans = ans;
    }

    public int getImg() {
        return img;
    }

    public String getQues() {
        return ques;
    }

    public String getAns() {
        return ans;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }
}
