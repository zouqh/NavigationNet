package com.zqh.library.navigationtab;

import android.graphics.drawable.Drawable;

/**
 * @author zouqh
 * @date 2019/4/26 11:19
 * email：862635431@qq.com
 * description：
 */
public class NavigationController implements ItemController{
    public ItemController mItemController;

    public NavigationController (ItemController controller){
        this.mItemController = controller;
    }


    @Override
    public void setSelect(int index) {
        mItemController.setSelect(index);
    }

    @Override
    public void setSelect(int index, boolean listener) {
        mItemController.setSelect(index, listener);
    }

    @Override
    public void setMessageNumber(int index, int number) {
        mItemController.setMessageNumber(index, number);
    }

    @Override
    public void setHasMessage(int index, boolean hasMessage) {
        mItemController.setHasMessage(index, hasMessage);
    }

    @Override
    public void addTabItemSelectedListener( OnTabItemSelectedListener listener) {
        mItemController.addTabItemSelectedListener(listener);
    }



    @Override
    public void setTitle(int index, String title) {
        mItemController.setTitle(index, title);
    }

    @Override
    public void setDefaultDrawable(int index, Drawable drawable) {
        mItemController.setDefaultDrawable(index, drawable);
    }

    @Override
    public void setSelectedDrawable(int index, Drawable drawable) {
        mItemController.setSelectedDrawable(index, drawable);
    }

    @Override
    public void setDefaulUrl(int index, String url) {
        mItemController.setDefaulUrl(index, url);
    }

    @Override
    public void setSelectUrl(int index, String url) {
mItemController.setSelectUrl(index, url);
    }

    @Override
    public int getSelected() {
        return mItemController.getSelected();
    }

    @Override
    public int getItemCount() {
        return mItemController.getItemCount();
    }

    @Override
    public String getItemTitle(int index) {
        return mItemController.getItemTitle(index);
    }

    @Override
    public boolean removeItem(int index) {
        return mItemController.removeItem(index);
    }


    @Override
    public void addCustomItem(int index, BaseItem item) {
        mItemController.addCustomItem(index, item);
    }


}
