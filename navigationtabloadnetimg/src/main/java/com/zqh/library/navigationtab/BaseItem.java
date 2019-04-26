package com.zqh.library.navigationtab;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * @author zouqh
 * @date 2019/4/26 11:24
 * email：862635431@qq.com
 * description：
 */
public abstract class BaseItem extends FrameLayout {

    public BaseItem(@NonNull Context context) {
        super(context);
    }

    public BaseItem(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseItem(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    /**
     * 设置选中状态
     */
    abstract public void setChecked(boolean checked);

    /**
     * 设置消息数字。注意：一般数字需要大于0才会显示
     */
    abstract public void setMessageNumber(int number);

    /**
     * 设置是否显示无数字的小圆点。注意：如果消息数字不为0，优先显示带数字的圆
     */
    abstract public void setHasMessage(boolean hasMessage);

    /**
     * 设置标题
     */
    abstract public void setTitle(String title);

    /**
     * 设置未选中状态下的图标
     */
    abstract public void setDefaultDrawable(Drawable drawable);

    /**
     * 设置选中状态下的图标
     */
    abstract public void setSelectedDrawable(Drawable drawable);


    /**
     * 设置未选中状态下的图标
     */
    abstract public void setDefaultIconUrl(String icon);

    /**
     * 设置选中状态下的图标
     */
    abstract public void setSelectedIconUrl(String icon);


    /**
     * 获取标题文字
     */
    abstract public String getTitle();

    /**
     * 已选中的状态下再次点击时触发
     */
    public void onRepeat() {}
}
