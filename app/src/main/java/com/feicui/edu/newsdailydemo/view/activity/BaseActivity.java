package com.feicui.edu.newsdailydemo.view.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.feicui.edu.newsdailydemo.R;
import com.feicui.edu.newsdailydemo.app.MyApplication;

/**
 * Created by Administrator on 2016/12/22 0022.
 */
public abstract class BaseActivity extends FragmentActivity {
    //屏幕的宽高属性
    protected int screen_w,screen_h;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //在初始化的时候把当前activity对象添加到application的集合对象中便于管理
        MyApplication.getInstance().addActivity(this);

        //获取屏幕的宽高
        WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(dm);
        screen_w = dm.widthPixels;      //设备的宽
        screen_h = dm.heightPixels;     //设备的高

    }

    /**
     * 显示activity的三个重载方法
     */
    public void openActivity(Class<?> pClass){
        openActivity(pClass,null);
    }

    public void openActivity(Class<?> pClass,Bundle mBundle){
        openActivity(pClass,mBundle,null);
    }

    public void openActivity(Class<?> pClass,Bundle mBundle,Uri uri){
        Intent intent = new Intent(this,pClass);
        if(mBundle!=null){
            intent.putExtras(mBundle);
        }
        if(uri!=null){
            intent.setData(uri);
        }
        startActivity(intent);
        //加载一个跳转延迟动画
        overridePendingTransition(R.anim.screen_right_in, R.anim.screen_left_out);

    }





    @Override
    protected void onDestroy() {
        //在应用销毁的时候把当前activity对象移除出application的集合对象中
        MyApplication.getInstance().removeActivity(this);
        super.onDestroy();
    }
}
