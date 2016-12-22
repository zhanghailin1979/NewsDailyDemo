package com.feicui.edu.newsdailydemo;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.feicui.edu.newsdailydemo.view.activity.BaseActivity;

import me.tangke.slidemenu.SlideMenu;

public class MainActivity extends BaseActivity {

    private SlideMenu menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        menu = new SlideMenu(this);
//        setContentView(R.layout.activity_main);
        testSlideMenu();
    }

    private void testSlideMenu() {
        SlideMenu slideMenu = new SlideMenu(this);
        setContentView(slideMenu);

        // Setup the content
//        View contentView = new View(this);

        View contentView = getLayoutInflater().inflate(R.layout.activity_main,null);

        slideMenu.addView(contentView, new SlideMenu.LayoutParams(
                SlideMenu.LayoutParams.MATCH_PARENT, SlideMenu.LayoutParams.MATCH_PARENT,
                SlideMenu.LayoutParams.ROLE_CONTENT));

        // Setup the primary menu
        View leftMenu = getLayoutInflater().inflate(R.layout.fragment_menu_left,null);
        slideMenu.addView(leftMenu, new SlideMenu.LayoutParams(300,
                SlideMenu.LayoutParams.MATCH_PARENT, SlideMenu.LayoutParams.ROLE_PRIMARY_MENU));

        // Setup the secondary menu
        View rightMenu = getLayoutInflater().inflate(R.layout.fragment_menu_right,null);
        slideMenu.addView(rightMenu, new SlideMenu.LayoutParams(300,
                SlideMenu.LayoutParams.MATCH_PARENT, SlideMenu.LayoutParams.ROLE_SECONDARY_MENU));

        //设置滑动模式(两种滑动模式：一种是内容MODE_SLIDE_CONTENT 一种是窗口:MODE_SLIDE_WINDOW
        slideMenu.setSlideMode(SlideMenu.MODE_SLIDE_CONTENT);
        //设置是否开启边框滑动
        slideMenu.setEdgeSlideEnable(false);

        //设置左右阴影的宽度
       slideMenu.setPrimaryShadowWidth(0);
        slideMenu.setSecondaryShadowWidth(0);

        slideMenu.open(true,false);

      





    }
}
