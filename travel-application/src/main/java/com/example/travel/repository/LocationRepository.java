package com.example.travel.repository;

import com.example.travel.jpa.Comment;
import com.example.travel.jpa.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Integer> {

    List<Location> findLocationsByStatus(int status);

    @Query("SELECT p FROM Location p WHERE locationId = ?1")
    List<Location> findLocationsByUser(int userId);

    @Query("SELECT p FROM Location p WHERE status = 1 OR status = 2")
    List<Location> getAllLocations();

    @Query("SELECT p FROM Location p WHERE status = 1 OR status = 2")
    Page<Location> findPaginateLocationsStatus(Pageable pageable);

    @Query("SELECT p FROM Location p WHERE status = 1 ")
    Page<Location> findPaginateLocationsStatusShow(Pageable pageable);

    @Query("SELECT p FROM Location p WHERE status = 2 ")
    Page<Location> findPaginateLocationsStatusHidden(Pageable pageable);

    @Query("SELECT p FROM Location p WHERE locationName = ?1 AND userId = ?2")
    Location findByLocationName(String locationName);
}

