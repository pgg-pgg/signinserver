package com.example.signinserver.service.impl;


import com.example.signinserver.dao.LocationDao;
import com.example.signinserver.domain.Location;
import com.example.signinserver.service.LocationEbi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LocationEbo implements LocationEbi{
    @Resource
    public LocationDao locationDao;


    @Override
    public void insertLocation(Location location) {
        locationDao.updateLocationById(location);
    }

    @Override
    public Location searchLocationById(String id) {
        return locationDao.searchLocationById(id);
    }

    @Override
    public List<Location> getAllLocation() {
        return locationDao.searchAllLocation();
    }
}
