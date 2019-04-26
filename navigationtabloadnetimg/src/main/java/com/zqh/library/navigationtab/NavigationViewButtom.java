package com.zqh.library.navigationtab;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zouqh
 * @date 2019/4/26 13:49
 * email：862635431@qq.com
 * description：
 */
public class NavigationViewButtom extends ViewGroup {

    private int mTabPaddingTop;
    private int mTabPaddingBottom;

    private NavigationController mNavigationController;

    private OnTabItemSelectedListener mTabItemListener = new OnTabItemSelectedListener() {
        @Override
        public void onSelected(int index, int old) {

        }

        @Override
        public void onRepeat(int index) {
        }
    };

    public NavigationViewButtom(Context context) {
        this(context,null);

    }

    public NavigationViewButtom(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public NavigationViewButtom(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setPadding(0, 0, 0, 0);

        final TypedArray a = context.obtainStyledAttributes(
                attrs, R.styleable.PageNavigationView);
        if (a.hasValue(R.styleable.PageNavigationView_NavigationPaddingTop)) {
            mTabPaddingTop = a.getDimensionPixelSize(R.styleable.PageNavigationView_NavigationPaddingTop, 0);
        }
        if (a.hasValue(R.styleable.PageNavigationView_NavigationPaddingBottom)) {
            mTabPaddingBottom = a.getDimensionPixelSize(R.styleable.PageNavigationView_NavigationPaddingBottom, 0);
        }
        a.recycle();
    }



    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        final int count = getChildCount();

        int maxWidth = MeasureSpec.getSize(widthMeasureSpec);
        int maxHeight = MeasureSpec.getSize(heightMeasureSpec);

        for (int i = 0; i < count; i++) {
            final View child = getChildAt(i);
            if (child.getVisibility() == GONE) {
                continue;
            }
            measureChild(child, widthMeasureSpec, heightMeasureSpec);

            maxWidth = Math.max(maxWidth, child.getMeasuredWidth());
            maxHeight = Math.max(maxHeight, child.getMeasuredHeight());
        }

        setMeasuredDimension(maxWidth, maxHeight);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        final int count = getChildCount();
        final int width = r - l;
        final int height = b - t;

        for (int i = 0; i < count; i++) {
            final View child = getChildAt(i);
            if (child.getVisibility() == GONE) {
                continue;
            }
            child.layout(0, 0, width, height);
        }
    }

    @Override
    public CharSequence getAccessibilityClassName() {
        return NavigationViewButtom.class.getName();
    }

    /**
     * 构建 自定义 的导航栏
     */
    public class CustomBuilder {

        private List<BaseItem> items;

        private boolean enableVerticalLayout = false;
        private boolean animateLayoutChanges = false;

        CustomBuilder() {
            items = new ArrayList<>();
        }

        /**
         * 完成构建
         *
         * @return {@link NavigationController},通过它进行后续操作
         * @throws RuntimeException 没有添加导航项时会抛出
         */
        public NavigationController build() {

//            mEnableVerticalLayout = enableVerticalLayout;

            //未添加任何按钮
            if (items.size() == 0) {
                throw new RuntimeException("must add a navigation item");
            }

            ItemController itemController;
//水平布局
                CustomItemLayout customItemLayout = new CustomItemLayout(getContext());
                customItemLayout.initialize(items, animateLayoutChanges);
                customItemLayout.setPadding(0, mTabPaddingTop, 0, mTabPaddingBottom);

                NavigationViewButtom.this.removeAllViews();
                NavigationViewButtom.this.addView(customItemLayout);
                itemController = customItemLayout;


            mNavigationController = new NavigationController( itemController);
            mNavigationController.addTabItemSelectedListener(mTabItemListener);

            return mNavigationController;
        }

        /**
         * 添加一个导航按钮
         *
         * @param baseTabItem {@link BaseItem},所有自定义Item都必须继承它
         * @return {@link CustomBuilder}
         */
        public CustomBuilder addItem(BaseItem baseTabItem) {
            items.add(baseTabItem);
            return CustomBuilder.this;
        }

        /**
         * 使用垂直布局
         *
         * @return {@link CustomBuilder}
         */
        public CustomBuilder enableVerticalLayout() {
            enableVerticalLayout = true;
            return CustomBuilder.this;
        }

        /**
         * 通过{@link NavigationController}动态移除/添加导航项时,显示默认的布局动画
         *
         * @return {@link CustomBuilder}
         */
        public CustomBuilder enableAnimateLayoutChanges() {
            animateLayoutChanges = true;
            return CustomBuilder.this;
        }
    }
    /**
     * 构建自定义导航栏
     */
    public CustomBuilder custom() {
        return new CustomBuilder();
    }

}
