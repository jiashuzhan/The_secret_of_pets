package com.shi_zhao.play.android.play.StaticInformation;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/6/30 0030.
 */
public class ErrorTypeInformation implements Serializable {
    //private static final long serialVersionUID = -2739298570134828503L;

    public static final int NONE_USERNAME_ERROR = 0;
    public static final int PASSWORD_ERROR = 1;
    public static final int KEY_NUM_ERROR = 2;
    public static final int OTHER_ERROR = 3;
    public static final int SUCCESS_NONE_ERROR = 4;
    public static final int WAITING_FOR_REPORT = 5;
    public static final int REGISTER_EXISTED = 5;
    public static final int REGISTER_OTHER_ERROR = 6;
    public static final int REGISTER_SUCCESS = 7;
}