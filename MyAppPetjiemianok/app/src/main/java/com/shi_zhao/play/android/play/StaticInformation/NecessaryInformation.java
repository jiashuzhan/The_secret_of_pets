package com.shi_zhao.play.android.play.StaticInformation;

import com.TheSecretOfPet.entity.Pet;
import com.TheSecretOfPet.entity.Worker;
import com.TheSecretOfPet.information.NewCompanyMessage;

/**
 * Created by Administrator on 2017/6/30 0030.
 */
public class NecessaryInformation {
    public static final int USER_LOGIN_TYPE_PASSENGER = 0;
    public static final int USER_LOGIN_TYPE_DRIVER = 1;
    public static final int USER_LOGIN_TYPE_MANAGER = 2;
    public static final int SQL_IS_UPDATE = 3;
    public static final int SQL_IS_NOT_UPDATE = 4;
    public static int TICKET_COAST = 2;
    public static  String COAST_PROJECT = "";
    public static boolean SQL_UPDATA = true;
    public static int LOGIN_IN_TIME =-1;
    //public static AllRoadLineStation allRoadLineStation = new AllRoadLineStation();
    public static String string;

    //public static Customer customer = new Customer();

    //this is for driver
    public static Pet pet = new Pet();//
    public static Worker worker = new Worker();
    public static NewCompanyMessage newCompanyMessage = new NewCompanyMessage();
    public static final int EXAM_HEALTHY = 1;
    public static final int EXAM_UNHEALTHY = 0;
    public static final int MALE = 1;
    public static final int FEMALE = 2;
    public static int LOGIN_STATUS = ErrorTypeInformation.WAITING_FOR_REPORT;
    public static int REGISTER_STATUS = ErrorTypeInformation.WAITING_FOR_REPORT;



    //this is for Manager
    //public static Manager manager = new Manager();
    //public static ToManagerInformation toManagerInformation= new ToManagerInformation();
    public static boolean paySucceed = false;
    //public static PaySucess paySucess = null;
}
