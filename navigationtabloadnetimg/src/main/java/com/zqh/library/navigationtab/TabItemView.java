package com.zqh.library.navigationtab;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * @author zouqh
 * @date 2019/4/26 11:24
 * email：862635431@qq.com
 * description：
 */
public class TabItemView extends BaseItem {
    private ImageView icon;
    private TextView title;
    private TabMessageView tabMessageView;

    private Drawable defaultDrawable;
    private Drawable checkedDrawable;

    private int mDefaultTextColor = 0x56000000;
    private int mCheckedTextColor = 0x56000000;

    private boolean mChecked;
    private boolean isNetWord;
    private String defaulUrl;
    private String checkUrl;
    private Context context;

    public TabItemView(@NonNull Context context) {
        this(context,null);
        this.context = context;
    }

    public TabItemView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
        this.context = context;
    }

    public TabItemView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
      LayoutInflater.from(context).inflate(R.layout.tab_item, this, true);
      icon = findViewById(R.id.icon);
      title = findViewById(R.id.title);
      tabMessageView = findViewById(R.id.messages);


    }

    /**
     * 设置本地图标
     * @param defaultDrawable
     * @param checkedDrawable
     * @param name
     */
    public void initLocalImg(int defaultDrawable,int checkedDrawable,String name){
        this.defaultDrawable =  ContextCompat.getDrawable(getContext(), defaultDrawable);
        this.checkedDrawable = ContextCompat.getDrawable(getContext(), checkedDrawable);
        title.setText(name);
        isNetWord = false;
    }

    public void initUrlImg(String defaulUrl,String checkUrl,String  name){
        this.checkUrl = checkUrl;
        this.defaulUrl = defaulUrl;
        title.setText(name);
        isNetWord = true;
    }


    @Override
    public void setChecked(boolean checked) {
        if (checked){
            title.setTextColor(mCheckedTextColor);
            if (isNetWord){
                setUrlIcon(checkUrl);
            }else{
                if (null!=checkedDrawable){
                    icon.setImageDrawable(checkedDrawable);
                }
            }
        }else{
            if (isNetWord){
                setUrlIcon(defaulUrl);
            }else{
                if (null!=defaultDrawable){
                    icon.setImageDrawable(defaultDrawable);
                }
            }
            title.setTextColor(mDefaultTextColor);
        }
        mChecked = checked;
    }

    @Override
    public void setMessageNumber(int number) {
        tabMessageView.setMessageNumber(number);
    }

    @Override
    public void setHasMessage(boolean hasMessage) {
        tabMessageView.setHasMessage(hasMessage);
    }

    @Override
    public void setTitle(String title) {
        this.title.setText(title);
    }

    @Override
    public void setDefaultDrawable(Drawable drawable) {
        defaultDrawable = drawable;
        if (!mChecked) {
            icon.setImageDrawable(drawable);
        }
    }

    @Override
    public void setSelectedDrawable(Drawable drawable) {
        checkedDrawable = drawable;
        if (mChecked) {
            icon.setImageDrawable(drawable);
        }
    }

    @Override
    public void setDefaultIconUrl(String icon) {
        defaulUrl = icon;
        if (!mChecked) {
            setUrlIcon(icon);
        }
    }

    @Override
    public void setSelectedIconUrl(String icon) {
        checkUrl = icon;
        if (mChecked) {
            setUrlIcon(icon);
        }

    }

    @Override
    public String getTitle() {
        return title.getText().toString();
    }

    public void setTextDefaultColor(@ColorInt int color) {
        mDefaultTextColor = color;
    }

    public void setTextCheckedColor(@ColorInt int color) {
        mCheckedTextColor = color;
    }

    private void setUrlIcon(String url){
        Glide.with(context)
                .load(url)
                .asBitmap()//只加载静态图片，如果是git图片则只加载第一帧。
//                .placeholder(R.drawable.loading)
//                .error(R.drawable.error)
                .into(icon);
    }
}
