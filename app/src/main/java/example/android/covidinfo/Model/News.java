package example.android.covidinfo.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class News implements Parcelable {

    @SerializedName("articles")
    private ArrayList<Articles> articles;

    public News(ArrayList<Articles> articles) {
        this.articles = articles;
    }

    protected News(Parcel in) {
        articles = in.createTypedArrayList(Articles.CREATOR);
    }

    public static final Creator<News> CREATOR = new Creator<News>() {
        @Override
        public News createFromParcel(Parcel in) {
            return new News(in);
        }

        @Override
        public News[] newArray(int size) {
            return new News[size];
        }
    };

    public ArrayList<Articles> getArticles() {
        return articles;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(articles);
    }
}
