package com.example.signinserver.dao;


import com.example.signinserver.domain.Location;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface LocationDao {

    /**
     * 添加一个新位置
     * POST
     * @return
     */
    void updateLocationById(Location location);
    /**
     * 得到对应用户的位置
     */
    Location searchLocationById(String id);

    /**
     * 获取所有用户的位置
     */
    List<Location> searchAllLocation();
}
