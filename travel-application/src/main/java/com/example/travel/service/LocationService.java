package com.example.travel.service;

import com.example.travel.jpa.Comment;
import com.example.travel.jpa.Location;
import org.springframework.data.domain.Page;

import java.util.List;

public interface LocationService {
    List<Location> listLocations();
    List<Location> getLocationsByStatus(int status);
//    List<Location> getLocationsByUser(int userId);
    Location getLocationById(int locationId);
    boolean saveLocation(Location location);
    boolean deleteLocation(int locationId);
    boolean updateLocation(Location location);
    Page<Location> findPaginated(int pageNo, int pageSize);
    Page<Location> findPaginatedShow(int pageNo,int pageSize);
    Page<Location> findPaginatedHidden(int pageNo,int pageSize);
    boolean checkLocationName(String locationName);
}
