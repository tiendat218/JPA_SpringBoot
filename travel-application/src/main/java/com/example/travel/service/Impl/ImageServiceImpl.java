package com.example.travel.service.Impl;

import com.example.travel.jpa.Comment;
import com.example.travel.jpa.Image;
import com.example.travel.repository.ImageRepository;
import com.example.travel.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public List<Image> listImages() {
        try {
            List<Image> images = imageRepository.getAllImages();
            return images;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Image> getImagesByStatus(int status) {
        try {
            List<Image> images = imageRepository.findImagesByStatus(status);
            return images;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Image> getImagesByLocation(int locationId) {
        try {
            List<Image> images = imageRepository.findImagesByLocation(locationId);
            return images;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Image getImageById(int imageId) {
        try {
            Image image = imageRepository.findById(imageId).get();
            return image;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean saveImage(Image image) {
        try {
            imageRepository.save(image);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteImage(int imageId) {
        try {
            Image image = imageRepository.findById(imageId).get();
            imageRepository.delete(image);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateImage(Image image) {
        try {
            imageRepository.save(image);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Page<Image> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return this.imageRepository.findPaginateImagesStatus(pageable);
    }

    @Override
    public Page<Image> findPaginatedShow(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return this.imageRepository.findPaginateImagesStatusShow(pageable);
    }

    @Override
    public Page<Image> findPaginatedHidden(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return this.imageRepository.findPaginateImagesStatusHidden(pageable);
    }

    @Override
    public boolean checkImageName(String imageName, int locationId) {
        Image image = imageRepository.findByImageName(imageName,locationId);
        if (image==null)
        {
            return true;
        }else{
            return false;
        }
    }
}
