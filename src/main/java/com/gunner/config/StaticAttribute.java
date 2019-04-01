package com.gunner.config;

import java.util.ArrayList;

public class StaticAttribute {
    //正式
    public static String appid="wxc75d0b1f540ce385";
    public static String secret="e4d264c0f2dc4c9743743b9b6ea05daa";

    /*
    //测试
    public static String appid="wx8a49f5efdd635440";
    public static String secret="dca487f13b537bed4eaff81f96277815";
    */

    //false代表未曾获得AccessToken，true代表已经获取了AccessToken
    public static Boolean AccessTokenFlag=false;

    //AccessToken
    public static String AccessToken;

    //AccessToken的生产日期
    public static Long AccessTokenTime;

    //AccessToken的保质期
    public static Integer expiresIn;

    //特殊处理一下早期注册人员没有昵称问题
    public static ArrayList list = new ArrayList();

    static {
        list.add("oPX6Ojv7lkTjK21bbmjf_LrePQE0");
        list.add("oPX6Ojp7fhoUFbomPHf03P3YEPoc");
        list.add("oPX6OjrNtuqIYkDYoIduUfnov1IY");
        list.add("oPX6OjuhQB0kXSb800SSxldFNWYc");
        list.add("oPX6OjlfLt5iQ750rPWBK3sYWskw");
        list.add("oPX6Oju5hkWpxQTYzFjOMClm3MKU");
        list.add("oPX6OjlXUFTOBsUlmKGYYBNJHzTw");
        list.add("oPX6Ojq-Ncvzny55knO2HYu_NZsw");
        list.add("oPX6OjlEThdM1C-ndImts58GTr9o");
        list.add("oPX6OjguFEusvYTTrLtxJHQ-o-VE");
        list.add("oPX6OjjUsgejjjrTJZcmyAPh9hcA");
    }
}
