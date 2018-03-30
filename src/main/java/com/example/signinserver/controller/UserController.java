package com.example.signinserver.controller;


import com.alibaba.fastjson.JSON;
import com.example.signinserver.domain.ResponseMessage;
import com.example.signinserver.domain.User;
import com.example.signinserver.service.UserEbi;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Decoder;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/User")
public class UserController {

    @Resource
    private UserEbi userEbi;

    @RequestMapping(value = "/register", method = {RequestMethod.POST, RequestMethod.GET})
    public String insertUserCon(@RequestBody User user) {
        System.out.println(user.toString());
        if (userEbi.searchUserById(user.getId())==null){
            String s1="I:\\idea\\signinserver\\src\\main\\resources\\static\\images\\";
            String photo=user.getId()+".jpg";
            FileOutputStream fos = null;
            byte[] buffer;
            try {
                buffer = new BASE64Decoder().decodeBuffer(user.getHead_icon());
                user.setHead_icon("images/"+photo);

                //对android传过来的图片字符串进行解码
                File destDir = new File(s1);
                if(!destDir.exists()) destDir.mkdir();
                fos = new FileOutputStream(new File(destDir,photo));   //保存图片
                fos.write(buffer);
                fos.flush();
                fos.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            userEbi.insertUser(user);
            ResponseMessage<User> message=new ResponseMessage<>(0,"注册成功！",user);
            return JSON.toJSONString(message);
        }else {
            return ResponseMessage.responseNot("注册失败！用户已存在！");
        }
    }
    @RequestMapping(value = "/login",method = {RequestMethod.GET,RequestMethod.POST})
    public String LoginCon(String id, String password){
        User user=userEbi.searchUserById(id);
        if (user==null){
            return ResponseMessage.responseNot("不存在此用户");
        }else {
            if (user.getPassword().equals(password)){
                ResponseMessage<User> message=new ResponseMessage<>(0,"登录成功",user);
                return JSON.toJSONString(message);
            }else {
                return ResponseMessage.responseNot("密码错误");
            }
        }
    }
}
