package com.zqh.library.navigationtab;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;


import java.util.Locale;


/**
 * @author zouqh
 * @date 2019/4/26 11:40
 * email：862635431@qq.com
 * description：消息数量显示
 */
public class TabMessageView extends FrameLayout {

    private  View mOval;
    private  TextView mMessages;

    private int mMessageNumber;
    private boolean mHasMessage;

    public TabMessageView( Context context) {
        this(context,null);
    }

    public TabMessageView( Context context,  AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TabMessageView( Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.round_message_view, this, true);

        mOval = findViewById(R.id.oval);
        mMessages = findViewById(R.id.msg);
        mMessages.setTypeface(Typeface.DEFAULT_BOLD);
        mMessages.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 10);
    }

    public void setMessageNumber(int number) {
        mMessageNumber = number;

        if(mMessageNumber > 0) {
            mOval.setVisibility(View.INVISIBLE);
            mMessages.setVisibility(View.VISIBLE);

            if(mMessageNumber < 10){
                mMessages.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);
            } else {
                mMessages.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 10);
            }

            if(mMessageNumber <= 99) {
                mMessages.setText(String.format(Locale.ENGLISH,"%d",mMessageNumber));
            } else {
                mMessages.setText(String.format(Locale.ENGLISH,"%d+",99));
            }
        } else {
            mMessages.setVisibility(View.INVISIBLE);
            if(mHasMessage){
                mOval.setVisibility(View.VISIBLE);
            }
        }
    }

    public void setHasMessage(boolean hasMessage) {
        mHasMessage = hasMessage;

        if(hasMessage) {
            mOval.setVisibility(mMessageNumber > 0 ? View.INVISIBLE : View.VISIBLE);
        } else {
            mOval.setVisibility(View.INVISIBLE);
        }
    }

    public void tintMessageBackground(@ColorInt int color)
    {
        Drawable drawable = Utlis.initDrawable(ContextCompat.getDrawable(getContext(), R.drawable.message_round),color);
        ViewCompat.setBackground(mOval,drawable);
        ViewCompat.setBackground(mMessages,drawable);
    }

    public void setMessageNumberColor(@ColorInt int color){
        mMessages.setTextColor(color);
    }

    public int getMessageNumber() {
        return mMessageNumber;
    }

    public boolean hasMessage() {
        return mHasMessage;
    }
}
