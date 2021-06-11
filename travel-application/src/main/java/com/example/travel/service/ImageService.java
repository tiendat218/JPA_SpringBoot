package com.example.travel.service;

import com.example.travel.jpa.Comment;
import com.example.travel.jpa.Image;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ImageService {
    List<Image> listImages();
    List<Image> getImagesByStatus(int status);
    List<Image> getImagesByLocation(int locationId);
    Image getImageById(int imageId);
    boolean saveImage(Image image);
    boolean deleteImage(int imageId);
    boolean updateImage(Image image);
    Page<Image> findPaginated(int pageNo, int pageSize);
    Page<Image> findPaginatedShow(int pageNo,int pageSize);
    Page<Image> findPaginatedHidden(int pageNo,int pageSize);
    boolean checkImageName(String imageName,int locationId);
}
