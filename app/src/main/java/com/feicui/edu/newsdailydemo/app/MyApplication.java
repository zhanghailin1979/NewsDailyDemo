package com.feicui.edu.newsdailydemo.app;

import android.app.Activity;
import android.app.Application;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/22 0022.
 */
public class MyApplication extends Application {

    //当前应用对象，单例模式
    private static MyApplication myApplication = null;

    //activity的集合对象
    private ArrayList<Activity> activities = new ArrayList<>();


    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
    }

    //获取当前应用对象
    public static MyApplication getInstance(){
        return myApplication;
    }


    //添加activity对象到集合中
    public void addActivity(Activity activity){
        activities.add(activity);
    }

    //移除activity
    public void removeActivity(Activity activity){
        activities.remove(activity);
    }

    //退出当前应用
    public void exitApplication(){
        for(Activity activity:activities){
            activity.finish();
        }
    }











}
