package com.example.travel.controller;

import com.example.travel.jpa.Location;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(path = "/admin/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @InitBinder
    public void InitBinder(WebDataBinder data)
    {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        data.registerCustomEditor(Date.class, new CustomDateEditor(s, true));
    }

    @RequestMapping("")
    public String getLocation(Model model)
    {
        Location location = new Location();
        return findPaginated(1,model,location);
    }


    @RequestMapping("show")
    public String getLocationsShow(Model model)
    {
        Location location = new Location();
        return findPagShow(1,model, location);
    }

    @RequestMapping("hidden")
    public String getLocationHidden(Model model)
    {
        Location location = new Location();
        return findPagHidden(1,model, location);
    }

    @RequestMapping("/insertLocation")
    public String insertLocation(Model model)
    {
        Location location = new Location();
        model.addAttribute("newLocation",location);
        return "admin/location/insertLocation";
    }
    @RequestMapping(path = "/saveLocation",method = RequestMethod.POST)
    public String saveCustomer(@ModelAttribute("newLocation")@Valid Location location, BindingResult result, Model model)
    {
        if (result.hasErrors())
        {
            return findPaginated(1,model,location);
        }
        boolean checkLocationName = locationService.checkLocationName(location.getLocationName());
        if (checkLocationName==false)
        {
            return "redirect:/admin/location?errorlocationname=Location Name is existed";
        }

        boolean bl = locationService.saveLocation(location);
        if (bl)
        {
            return "redirect:/admin/locations/";
        }
        return "redirect:/admin/location?error=Add New Location error";

    }

    @RequestMapping(path = "/editLocation")
    public String editLocation(@RequestParam("locationId")Integer locationId, Model model)
    {
        Location location = locationService.getLocationById(locationId);
        model.addAttribute("editLocation",location);
        return "admin/location/editLocation";
    }

    @RequestMapping(path = "/updateLocation",method = RequestMethod.POST)
    public String updateLocation(@ModelAttribute("editLocation")Location location)
    {
        boolean checkLocationName = checkLocationName(location.getLocationName(),location.getLocationId());
        if (checkLocationName==false)
        {
            return "redirect:/admin/location/editLocation?id="+location.getLocationId()+"&&errorlocationname=Location Name is existed";
        }
        boolean bl = locationService.updateLocation(location);
        if (bl)
        {
            return "redirect:/admin/locations/";
        }
        return "redirect:/admin/location?error=Update Location error";

    }

    @RequestMapping(value = "/detailLocation")
    public String detailLocationById(@RequestParam("locationId")Integer locationId,Model model)
    {
        Location location = locationService.getLocationById(locationId);
        model.addAttribute("detailLocation",location);
        return "admin/location/detailLocation";
    }

    @RequestMapping(path = "/deleteLocation")
    public String deleteLocation(@RequestParam("locationId")Integer locationId)
    {
        boolean bl = locationService.deleteLocation(locationId);
        if (bl)
        {
            return "redirect:/admin/locations/";
        }
        return "redirect:admin/location?error=Delete Location error";
    }

    @RequestMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo")int pageNo, Model model, Location location)
    {
        int pageSize = 10;
        Page<Location> page = locationService.findPaginated(pageNo,pageSize);
        List<Location> locations = page.getContent();
        model.addAttribute("currentPage",pageNo);
        model.addAttribute("totalPages",page.getTotalPages());
        model.addAttribute("totalItems",page.getTotalElements());
        model.addAttribute("newLocation", location);
        model.addAttribute("locations",locations);
        return "admin/location/listLocations";
    }

    @RequestMapping("/pageShow/{pageNo}")
    public String findPagShow(@PathVariable(value = "pageNo")int pageNo, Model model,  Location location)
    {
        int pageSize = 10;
        Page<Location> page = locationService.findPaginated(pageNo,pageSize);
        List<Location> locations = page.getContent();
        model.addAttribute("currentPage",pageNo);
        model.addAttribute("totalPages",page.getTotalPages());
        model.addAttribute("totalItems",page.getTotalElements());
        model.addAttribute("newLocation", location);
        model.addAttribute("locations",locations);
        return "admin/location/listLocations";
    }
    @RequestMapping("/pageHidden/{pageNo}")
    public String findPagHidden(@PathVariable(value = "pageNo")int pageNo, Model model,Location location)
    {
        int pageSize = 10;
        Page<Location> page = locationService.findPaginated(pageNo,pageSize);
        List<Location> locations = page.getContent();
        model.addAttribute("currentPage",pageNo);
        model.addAttribute("totalPages",page.getTotalPages());
        model.addAttribute("totalItems",page.getTotalElements());
        model.addAttribute("newLocation", location);
        model.addAttribute("locations",locations);
        return "admin/location/listLocations";
    }
    public boolean checkLocationName(String locationName, int locationId)
    {
        Location location = locationService.getLocationById(locationId);
        boolean checkCustomerName = locationService.checkLocationName(locationName);
        if (checkCustomerName==false)
        {
            if (locationName.equals(location.getLocationName()))
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
