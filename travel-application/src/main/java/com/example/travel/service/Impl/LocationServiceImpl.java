package com.example.travel.service.Impl;

import com.example.travel.jpa.Comment;
import com.example.travel.jpa.Location;
import com.example.travel.repository.LocationRepository;
import com.example.travel.service.LocationService;
import org.apache.tomcat.jni.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public List<Location> listLocations() {
        try{
            List<Location> locations = locationRepository.getAllLocations();
            return locations;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Location> getLocationsByStatus(int status) {
        try{
            List<Location> locations = locationRepository.findLocationsByStatus(status);
            return locations;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

//    @Override
//    public List<Location> getLocationsByUser(int userId) {
//        try{
//            List<Location> locations = locationRepository.findLocationsByUser(userId);
//            return locations;
//        }catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//        return null;
//    }

    @Override
    public Location getLocationById(int locationId) {
        try{
            Location location = locationRepository.findById(locationId).get();
            return location;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean saveLocation(Location location) {
        try {
            locationRepository.save(location);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteLocation(int locationId) {
        try{
            Location location = locationRepository.findById(locationId).get();
            locationRepository.delete(location);
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateLocation(Location location) {
        try{
            locationRepository.save(location);
            return true;

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Page<Location> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return this.locationRepository.findPaginateLocationsStatus(pageable);
    }

    @Override
    public Page<Location> findPaginatedShow(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return this.locationRepository.findPaginateLocationsStatusShow(pageable);
    }

    @Override
    public Page<Location> findPaginatedHidden(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return this.locationRepository.findPaginateLocationsStatusHidden(pageable);
    }

    @Override
    public boolean checkLocationName(String locationName) {
        Location location = locationRepository.findByLocationName(locationName);
        if (location==null)
        {
            return true;
        }else{
            return false;
        }
    }
}
