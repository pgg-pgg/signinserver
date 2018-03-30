package com.example.signinserver.service;

import com.example.signinserver.domain.Location;

import java.util.List;

public interface LocationEbi {

    /**
     * 添加一个位置
     */
    void insertLocation(Location location);

    /**
     * 通过id找到一个位置
     * @param id
     * @return
     */
    Location searchLocationById(String id);

    List<Location> getAllLocation();
}
