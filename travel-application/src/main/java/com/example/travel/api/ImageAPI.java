package com.example.travel.api;

import com.example.travel.jpa.Image;
import com.example.travel.jpa.Location;
import com.example.travel.repository.ImageRepository;
import com.example.travel.repository.LocationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/images")
public class ImageAPI {
    private final LocationRepository locationRepository;
    private final ImageRepository imageRepository;

    public ImageAPI(LocationRepository locationRepository, ImageRepository imageRepository) {
        this.locationRepository = locationRepository;
        this.imageRepository = imageRepository;
    }


    @GetMapping //read data
    public ResponseEntity<Page<Image>> getAll(Pageable pageable) {
        return ResponseEntity.ok(imageRepository.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Image> getById(@PathVariable int imageId) {

        Optional<Image> optionalImage = imageRepository.findById(imageId);

        if (!optionalImage.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(optionalImage.get());
    }

    @PostMapping
    public ResponseEntity<Image> createImage(@Valid @RequestBody Image image) {
        Optional<Location> optionalLocation = locationRepository.findById(image.getLocation().getLocationId());
        if (!optionalLocation.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        image.setLocation(optionalLocation.get());
        Image imageSaved = imageRepository.save(image);

        URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(imageSaved.getImageId())
            .toUri();

        return ResponseEntity.created(location).body(imageSaved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Image> updateImage(@PathVariable int imageId,
                                                 @Valid @RequestBody Image image) {
        Optional<Location> optionalLocation = locationRepository.findById(image.getLocation().getLocationId());
        if (!optionalLocation.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        Optional<Image> optionalImage = imageRepository.findById(imageId);
        if (!optionalImage.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        image.setLocation(optionalLocation.get());
        image.setImageId(optionalImage.get().getImageId());
        imageRepository.save(image);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Image> deleteImage(@PathVariable int imageId,
                                                 @Valid @RequestBody Image image){
        Optional<Image> optionalImage= imageRepository.findById(imageId);

        if(!optionalImage.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        imageRepository.delete(optionalImage.get());
        return ResponseEntity.noContent().build();
    }
}
