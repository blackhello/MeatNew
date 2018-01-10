package com.example.meat;
import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.app.Application;
/**
 * Created by hetao on 2018/1/6.
 */

public class AgentApp extends Application {
    private List<Activity> activities=new ArrayList<Activity>();
    private static AgentApp instance;
    private  AgentApp(){}//单例模式中获取唯一的application
    public static  AgentApp getInstance(){
        if(null==instance){
            instance=new AgentApp();
        }return instance;
    }//存放Activity到list中
    public void addActivity(Activity activity){
        activities.add(activity);
    }
    @Override
    public void onTerminate() {
        super.onTerminate();
        for(Activity activity:activities){
            activity.finish();
        }
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
