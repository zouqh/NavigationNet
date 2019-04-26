package com.zouqh.navigationnet;

import android.content.Context;
import android.graphics.Color;


import com.zqh.library.navigationtab.BaseItem;
import com.zqh.library.navigationtab.NavigationController;
import com.zqh.library.navigationtab.NavigationViewButtom;
import com.zqh.library.navigationtab.TabItemView;

import java.util.ArrayList;
import java.util.List;


/**
 * @author zouqh
 * @date 2019/4/24 14:11
 * email：862635431@qq.com
 * description：导航设置
 */
public class TabUtil {

    public List<BaseItem> tabItem = new ArrayList<>();
    private static TabUtil tabUtil;

    public static TabUtil getInstens(){
        if (tabUtil == null){
            tabUtil = new TabUtil();
        }

        return tabUtil;
    }

    /**
     * 创建首页的底部导航栏 ,本地图片
     *
     * @param context
     * @param buttomTab
     * @return NavigationController
     */

    public static NavigationController initNavigation(Context context, NavigationViewButtom buttomTab) {
        return buttomTab.custom().addItem(newItem(context, R.mipmap.ic_launcher, R.mipmap.ic_launcher_round, "首页"))
                .addItem(newItem(context, R.mipmap.ic_launcher, R.mipmap.ic_launcher_round, "分类"))
                .addItem(newItem(context, R.mipmap.ic_launcher, R.mipmap.ic_launcher_round, "购物车"))
                .addItem(newItem(context, R.mipmap.ic_launcher, R.mipmap.ic_launcher_round, "我的"))
                .build();
    }

    public static BaseItem newItem(Context context, int drawable, int checkedDrawable, String text) {
        TabItemView normalItemView = new TabItemView(context);
        normalItemView.initLocalImg(drawable, checkedDrawable, text);
        normalItemView.setTextDefaultColor(Color.GRAY);
//        normalItemView.setMessageNumber(33);
        normalItemView.setTextCheckedColor(context.getResources().getColor(R.color.theme_text));
        TabUtil.getInstens().tabItem.add(normalItemView);
        return normalItemView;
    }

    /**
     * 创建首页的底部导航栏 ,网络图片
     *
     * @param context
     * @param buttomTab
     * @return NavigationController
     */

    public static NavigationController initNavigationUrl(Context context, NavigationViewButtom buttomTab) {
        return buttomTab.custom().addItem(newItemUrl(context, "http://img1.imgtn.bdimg.com/it/u=1312359376,3488606149&fm=26&gp=0.jpg",
                "http://img4.imgtn.bdimg.com/it/u=459029210,2275163639&fm=27&gp=0.jpg", "首页"))
                .addItem(newItemUrl(context, "http://www.agri35.com/UploadFiles/img_1_2060807979_1004877196_26.jpg",
                        "http://img14.360buyimg.com/n1/jfs/t2335/188/1170038786/207152/9dfd40d6/567a4083N14f0a307.jpg", "分类"))
//                .addItem(newItemUrl(context, R.mipmap.ic_launcher, R.mipmap.ic_launcher_round, "购物车"))
//                .addItem(newItemUrl(context, R.mipmap.ic_launcher, R.mipmap.ic_launcher_round, "我的"))
                .build();
    }

    public static BaseItem newItemUrl(Context context, String drawable, String checkedDrawable, String text) {
        TabItemView normalItemView = new TabItemView(context);
        normalItemView.initUrlImg(drawable, checkedDrawable, text);
        normalItemView.setTextDefaultColor(Color.GRAY);
//        normalItemView.setMessageNumber(33);
        normalItemView.setTextCheckedColor(context.getResources().getColor(R.color.theme_text));
        TabUtil.getInstens().tabItem.add(normalItemView);
        return normalItemView;
    }
}
