package com.zouqh.navigationnet;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zqh.library.navigationtab.NavigationController;
import com.zqh.library.navigationtab.NavigationViewButtom;
import com.zqh.library.navigationtab.OnTabItemSelectedListener;

public class MainActivity extends AppCompatActivity {

    private NavigationViewButtom navigationViewButtom;
    private NavigationController navigationController;
    private TestFragment1 testFragment1;
    private TestFragment2 testFragment2;
    private FragmentManager manager;
    private Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationViewButtom = findViewById(R.id.homeTab);
        testFragment1 = new TestFragment1();
        testFragment2 = new TestFragment2();
        manager = getSupportFragmentManager();

        navigationController = TabUtil.initNavigationUrl(this, navigationViewButtom);

        setSelected(0);
        navigationController.addTabItemSelectedListener(new OnTabItemSelectedListener() {
            @Override
            public void onSelected(int index, int old) {

                switch (index) {
                    case 0:
//
                        setSelected(0);

                        break;
                    case 1:
//

                        setSelected(1);

                        break;

                    default:
                        break;
                }
            }

            @Override
            public void onRepeat(int index) {
            }
        });
    }

    private void setSelected(int i) {

        switch (i) {
            case 0:
                showFragment(testFragment1);
                break;

            case 1:
                showFragment(testFragment2);
                break;


            default:

                break;

        }

    }

    /**
     * 使用show() hide()切换页面
     * 显示fragment
     */
    private void showFragment(Fragment fg) {

        FragmentTransaction transaction = manager.beginTransaction();

        //如果之前没有添加过
        if (!fg.isAdded()) {
            if (null != currentFragment) {
                transaction
                        .hide(currentFragment)
                        .add(R.id.homeContainer, fg);
            } else {
                transaction
                        .add(R.id.homeContainer, fg);
            }

        } else {
            transaction
                    .hide(currentFragment)
                    .show(fg);
        }

        //全局变量，记录当前显示的fragment
        currentFragment = fg;

        transaction.commit();

    }
}
