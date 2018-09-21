package com.example.traceactivity.tracker;

/**
 * APP状态跟踪器常量码
 */
public class AppStatusConstant {
    public static final int STATUS_FORCE_KILLED = -1; //应用放在后台被强杀了
    public static final int STATUS_KICK_OUT = 1;//TOKEN失效或者被踢下线
    public static final int STATUS_NORMAL = 2;  //APP正常态
    public static final int STATUS_LOGOUT = 3;//用户注销登录
    public static final int STATUS_OFFLINE = 4;//未登录状态
    public static final int STATUS_ONLINE = 5;//登录状态

    //intent到MainActivity 区分跳转目的
    public static final String KEY_HOME_ACTION = "key_home_action";//返回到主页面

    public static final int ACTION_BACK_TO_HOME = 11; //默认值
    public static final int ACTION_RESTART_APP = 12;//重启APP
    public static final int ACTION_KICK_OUT = 13;//被踢出
    public static final int ACTION_LOGOUT = 14;//退出登录
}
