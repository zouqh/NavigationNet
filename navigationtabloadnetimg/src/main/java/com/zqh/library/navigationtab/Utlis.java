package com.zqh.library.navigationtab;

import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;

/**
 * @author zouqh
 * @date 2019/4/26 15:36
 * email：862635431@qq.com
 * description：
 */
public class Utlis {

    /**
     * Drawable 染色
     *
     * @param drawable 染色对象
     * @param color    颜色
     * @return 染色后的资源
     */
    public static Drawable initDrawable(Drawable drawable, int color) {
        final Drawable wrappedDrawable = DrawableCompat.wrap(drawable);
        wrappedDrawable.mutate();
        DrawableCompat.setTint(wrappedDrawable, color);
        return wrappedDrawable;
    }
}
