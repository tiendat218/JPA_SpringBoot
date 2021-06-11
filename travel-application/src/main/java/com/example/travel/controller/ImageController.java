package com.example.travel.controller;

import com.example.travel.jpa.Image;
import com.example.travel.jpa.Location;
import com.example.travel.service.ImageService;
import com.example.travel.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(path = "/admin/images")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @Autowired
    private LocationService locationService;

    @InitBinder
    public void InitBinder(WebDataBinder data) {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        data.registerCustomEditor(Date.class, new CustomDateEditor(s, true));
    }

    @RequestMapping("")
    public String getImage(Model model) {
        Image image = new Image();
        return findPaginated(1, model, image);
    }

    @RequestMapping("show")
    public String getImageShow(Model model) {
        Image image = new Image();
        return findPagShow(1, model, image);
    }

    @RequestMapping("hidden")
    public String getImageHidden(Model model) {
        Image image = new Image();
        return findPagHidden(1, model, image);
    }

    @RequestMapping("/insertImage")
    public String insertImage(Model model)
    {
        Image image = new Image();
        List<Location> locations = locationService.getLocationsByStatus(1);
        model.addAttribute("newImage",image);
        model.addAttribute("locations",locations);
        return "admin/image/insertImage";
    }

    @RequestMapping(value = "/saveImage",method = RequestMethod.POST)
    public String saveComment(@ModelAttribute("newImage")@Valid Image image, BindingResult result, Model model)throws IOException
    {
        if (result.hasErrors())
        {
            List<Location> locations = locationService.listLocations();
            model.addAttribute("locations",locations);
            model.addAttribute("newImage",image);
            return "admin/image/insertImage";
        }
        boolean checkImageName = imageService.checkImageName(image.getImageName(),image.getLocation().getLocationId());
        if (checkImageName==false)
        {
            return "redirect:/admin/image/insertImage?errorimagename=Image Name is existed";
        }

        boolean bl = imageService.saveImage(image);
        if(bl)
        {
            return "redirect:/admin/images/";
        }
        return "redirect:/admin/image?error=Add New Image error";
    }

    @RequestMapping(value = "/editImage")
    public String editImage(@RequestParam("imageId")Integer imageId, Model model)
    {
        Image image = imageService.getImageById(imageId);
        List<Location> locations = locationService.getLocationsByStatus(1);
        model.addAttribute("editImage",image);
        model.addAttribute("locations",locations);
        return "admin/image/editImage";
    }

    @RequestMapping(path = "/updateImage", method = RequestMethod.POST)
    public String updateComment(@ModelAttribute("editImage") Image image) {
        boolean checkImageName = checkImageName(image.getImageName(), image.getImageId(), image.getLocation().getLocationId());
        if (checkImageName == false) {
            return "redirect:/admin/image/editImage?id=" + image.getImageId() + "&&errorimagename=Image Name is existed";
        }
        boolean bl = imageService.updateImage(image);
        if (bl) {
            return "redirect:/admin/images/";
        }
        return "redirect:/admin/image?error=Update Image Error";

    }

    @RequestMapping(value = "/detailImage")
    public String detailImageById(@RequestParam("imageId")Integer imageId,Model model)
    {
        Image image = imageService.getImageById(imageId);
        model.addAttribute("detailImage",image);
        return "admin/image/detailImage";
    }

    @RequestMapping(path = "/deleteImage")
    public String deleteImage(@RequestParam("imageId") Integer imageId) {
        boolean bl = imageService.deleteImage(imageId);
        if (bl) {
            return "redirect:/admin/images/";
        }
        return "redirect:admin/image?error=Delete Images Error";
    }


    @RequestMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model, Image image) {
        int pageSize = 10;
        List<Location> locations = locationService.listLocations();
        Page<Image> page = imageService.findPaginated(pageNo, pageSize);
        List<Image> images = page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("newImage", image);
        model.addAttribute("locations",locations);
        model.addAttribute("images",images);
        return "admin/image/listImages";
    }

    @RequestMapping("/pageShow/{pageNo}")
    public String findPagShow(@PathVariable(value = "pageNo") int pageNo, Model model, Image image) {
        int pageSize = 10;
        List<Location> locations = locationService.listLocations();
        Page<Image> page = imageService.findPaginatedShow(pageNo, pageSize);
        List<Image> images = page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("newImage", image);
        model.addAttribute("locations",locations);
        model.addAttribute("images",images);
        return "admin/image/listImages";
    }

    @RequestMapping("/pageHidden/{pageNo}")
    public String findPagHidden(@PathVariable(value = "pageNo") int pageNo, Model model, Image image) {
        int pageSize = 10;
        List<Location> locations = locationService.listLocations();
        Page<Image> page = imageService.findPaginatedHidden(pageNo, pageSize);
        List<Image> images = page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("newImage", image);
        model.addAttribute("locations",locations);
        model.addAttribute("images",images);
        return "admin/image/listImages";
    }

    public boolean checkImageName(String imageName, int imageId, int locationId) {
        Image image = imageService.getImageById(imageId);
        boolean checkImageName = imageService.checkImageName(imageName,locationId);
        if (checkImageName==false)
        {
            if (imageName.equals(image.getImageName()) && image.getLocation().getLocationId()==locationId)
            {
                return true;
            }
            else {
                return false;
            }
        }
        return true;
    }

}
