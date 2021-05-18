package com.shi_zhao.play.android.play.StaticInformation;

/**
 * Created by Administrator on 2017/7/1 0001.
 */
public class HandleMessageInformation {

    //this is for UserLogin
    public static final int SUCCESS_LOGIN = 0x123;
    public static final int NONE_USER_ERROR_LOGIN = 0x124;
    public static final int PASSWORD_ERROR_LOGIN = 0x125;
    public static final int KEY_NUM_ERROR_LOGIN = 0x126;
    public static final int OTHER_ERROR_LOGIN = 0x127;
    public static final int WAITING_FOR_REPORT = 0x128;

    //this is for register
    public static final int REGISTER_SUCCESS = 0x129;
    public static final int REGISTER_USER_EXISTED = 0x130;
    public static final int REGISTER_OTHER_ERROR = 0x131;

    //this is for driver
    public static final int DRIVER_LOGIN_SUCCESS = 0x132;

    //this is for manager
    public static final int MANAGER_LOGIN_SUCCESS = 0x133;
}
