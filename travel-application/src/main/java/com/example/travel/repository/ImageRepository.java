package com.example.travel.repository;

import com.example.travel.jpa.Comment;
import com.example.travel.jpa.Image;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Integer> {
    List<Image> findImagesByStatus(int status);

    @Query("SELECT p FROM Image p WHERE locationId = ?1")
    List<Image> findImagesByLocation(int locationId);

    @Query("SELECT p FROM Image p WHERE status = 1 OR status = 2")
    List<Image> getAllImages();

    @Query("SELECT p FROM Image p WHERE status = 1 OR status = 2")
    Page<Image> findPaginateImagesStatus(Pageable pageable);

    @Query("SELECT p FROM Image p WHERE status = 1 ")
    Page<Image> findPaginateImagesStatusShow(Pageable pageable);

    @Query("SELECT p FROM Image p WHERE status = 2 ")
    Page<Image> findPaginateImagesStatusHidden(Pageable pageable);

    @Query("SELECT p FROM Image p WHERE imageName = ?1 AND locationId = ?2")
    Image findByImageName(String imageName,int locationId);
}
