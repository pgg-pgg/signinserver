package com.example.signinserver.controller;


import com.alibaba.fastjson.JSON;
import com.example.signinserver.domain.Location;
import com.example.signinserver.domain.ResponseMessage;
import com.example.signinserver.domain.User;
import com.example.signinserver.service.LocationEbi;
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
import java.util.List;

@RestController
@RequestMapping("/Location")
public class LocationController {

    @Resource
    private LocationEbi locationEbi;

    @RequestMapping(value = "/addLocation", method = {RequestMethod.POST, RequestMethod.GET})
    public String addLocation(@RequestBody Location location) {
        try{
            locationEbi.insertLocation(location);
            ResponseMessage<Location> message = new ResponseMessage<>(0, "添加成功！", location);
            return JSON.toJSONString(message);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseMessage.responseNot("添加失败！用户不存在！");
        }
    }

    @RequestMapping(value = "/getLocationInfo", method = {RequestMethod.GET, RequestMethod.POST})
    public String getLocationInfo(String id) {
        Location location = locationEbi.searchLocationById(id);
        if (location == null) {
            return ResponseMessage.responseNot("不存在此用户");
        } else {
            ResponseMessage<Location> message = new ResponseMessage<>(0, "成功", location);
            return JSON.toJSONString(message);
        }
    }

    @RequestMapping(value = "/getAllLocationInfo", method = {RequestMethod.GET, RequestMethod.POST})
    public String getAllLocationInfo() {
        List<Location> list = locationEbi.getAllLocation();
        ResponseMessage<List<Location>> message = new ResponseMessage<>(0, "成功", list);
        return JSON.toJSONString(message);
    }


}
