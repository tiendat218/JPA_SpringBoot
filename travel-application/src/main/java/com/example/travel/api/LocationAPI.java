package com.example.travel.api;

import com.example.travel.jpa.Customer;
import com.example.travel.jpa.Location;
import com.example.travel.repository.CommentRepository;
import com.example.travel.repository.CustomerRepository;
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
@RequestMapping("api/v1/locations")
public class LocationAPI {
    private final CommentRepository commentRepository;
    private final LocationRepository locationRepository;

    public LocationAPI(CommentRepository commentRepository, LocationRepository locationRepository) {
        this.commentRepository = commentRepository;
        this.locationRepository = locationRepository;
    }

    @GetMapping //read data
    public ResponseEntity<Page<Location>> getAll(Pageable pageable) {
        return ResponseEntity.ok(locationRepository.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Location> getById(@PathVariable int locationId){
        Optional<Location> optionalLocation= locationRepository.findById(locationId);

        if(!optionalLocation.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(optionalLocation.get());
    }

    @PostMapping
    public ResponseEntity<Location> insertLocation(@Valid @RequestBody Location locationNew){
        Location locationSaved = locationRepository.save(locationNew);

        URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(locationSaved.getLocationId())
            .toUri();

        return ResponseEntity.created(location).body(locationSaved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Location> updateLocation(@PathVariable int locationId,
                                                   @Valid @RequestBody Location location){
        Optional<Location> optionalLocation= locationRepository.findById(locationId);

        if(!optionalLocation.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        location.setLocationId(optionalLocation.get().getLocationId());
        locationRepository.save(location);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Location> deleteLocation(@PathVariable int locationId){
        Optional<Location> optionalLocation= locationRepository.findById(locationId);

        if(!optionalLocation.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        locationRepository.delete(optionalLocation.get());
        return ResponseEntity.noContent().build();
    }
}
