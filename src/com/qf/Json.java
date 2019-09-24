package com.qf;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.qf.Account.Account;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class Json {



    public static void test1() throws JSONException{
        String str = "{id:12,username:'kfw',password:'123'}";
        Gson gson = new Gson();
        Account account = gson.fromJson(str,Account.class);
        System.out.println(account.toString());
    }

    public static void test2() throws JSONException{
        String str = "[{id:12,username:'kfw',password:'123'},{id:14,username:'kqf',password:'456'}]";
        Gson gson = new Gson();
        TypeToken<ArrayList<Account>> arrayListTypeToken = new TypeToken<ArrayList<Account>>(){};
        ArrayList<Account> list = gson.fromJson(str,arrayListTypeToken.getType());
        for (Account account:list){
            System.out.println(account.toString());
        }
    }

    public static void test3() throws JSONException{
        String str = "{id:12,username:'kfw',password:'123'}";
        Account account = JSON.parseObject(str,Account.class);
        System.out.println(account);
    }

    public static void test4() throws JSONException{
        String str = "[{id:12,username:'kfw',password:'123'},{id:14,username:'kqf',password:'456'}]";
        List<Account> list = JSON.parseArray(str,Account.class);

        for (Account account:list){
            System.out.println(account);
        }
    }

    public static void main(String[] args) {
        try {
            test4();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
