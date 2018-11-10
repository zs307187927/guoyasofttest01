package com.guoyasoft.testcase;

import com.alibaba.fastjson.JSON;
import com.guoyasoft.bean.login.LoginReq;
import com.guoyasoft.bean.login.LoginResp;
import com.guoyasoft.tools.HttpTools;
import org.testng.Assert;
import org.testng.annotations.Test;
import sun.net.www.http.HttpClient;

public class LoginTest {
    @Test
    public  void login (){
        LoginReq req = new LoginReq();
        req.setUserName("zs1234");
        req.setPwd("zs123456");

        String loginreq = JSON.toJSONString(req,true);
        System.out.println("---------请求报文：----------");
        System.out.println(loginreq);

        String loginresp = HttpTools.doPostByJson("http://qa.guoyasoft.com:8080/user/login",loginreq,"UTF-8");
        System.out.println("---------响应报文--------");
        System.out.println(loginresp);

        LoginResp resp=JSON.parseObject(loginresp,LoginResp.class);
        String respCode=resp.getRespCode();
        System.out.println("---------响应code-------");
        System.out.println(respCode);

        Assert.assertEquals(respCode,"0000");


    }
}
