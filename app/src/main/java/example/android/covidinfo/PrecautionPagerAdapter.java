package example.android.covidinfo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class PrecautionPagerAdapter extends PagerAdapter {

    Context context;
    List<Precaution> precautionList;

    public PrecautionPagerAdapter(Context context, List<Precaution> precautionList){
        this.context = context;
        this.precautionList = precautionList;
    }

    @Override
    public int getCount() {
        return precautionList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.precaution_item, container, false);
        ImageView imageView;
        TextView precautionName, precautionDesc;

        imageView = view.findViewById(R.id.preImage);
        precautionName = view.findViewById(R.id.precationName);
        precautionDesc = view.findViewById(R.id.precautionDesc);

        imageView.setImageResource(precautionList.get(position).getImg());
        precautionName.setText(precautionList.get(position).getPrecautionName());
        precautionDesc.setText(precautionList.get(position).getPrecationDescription());

        container.addView(view, 0);
        return  view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
