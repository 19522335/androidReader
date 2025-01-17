package com.example.androidreader.Apdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.androidreader.Model.MangaChapter;
import com.example.androidreader.R;

import java.util.List;

public class ContentPagerAdapter extends PagerAdapter {

    private Context mContext;
    private List<String> content;

    public ContentPagerAdapter(Context mContext, List<String> content) {
        this.mContext = mContext;
        this.content = content;
    }

    @Override
    public int getCount() {
        return content.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        View layout = (ViewGroup) inflater.inflate(R.layout.content_page,container,false);

        ImageView page_image = (ImageView) layout.findViewById(R.id.content_IV);
        Glide.with(mContext).load(content.get(position)).into(page_image);

        container.addView(layout);
        return layout;
    }



    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);

    }
}
