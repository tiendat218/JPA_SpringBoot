package com.example.travel.jpa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@EqualsAndHashCode(exclude = {"location"})
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int imageId;

    @NotNull
    private String imageName;

    private String imageURL;

    @Min(value = 1,message = "Please chose a status")
    private int status;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "locationId")
    @JsonIgnoreProperties("images")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Location location;


    public Image() {
    }

    public Image(int imageId, @NotNull String imageName, String imageURL, @Min(value = 1, message = "Please chose a status") int status, Location location) {
        this.imageId = imageId;
        this.imageName = imageName;
        this.imageURL = imageURL;
        this.status = status;
        this.location = location;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
