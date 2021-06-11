package com.example.emi_application.controller;

import com.example.emi_application.model.Customer;
import com.example.emi_application.model.Emi;
import com.example.emi_application.service.CustomerService;
import com.example.emi_application.service.EmiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(path = "emi")
public class EmiController {
    @Autowired
    private EmiService emiService;

    @Autowired
    private CustomerService customerService;

    @InitBinder
    public void InitBinder(WebDataBinder data)
    {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        data.registerCustomEditor(Date.class, new CustomDateEditor(s, true));
    }

    @RequestMapping(path = "/")
    public String insertEmi(Model model)
    {
        Emi emi = new Emi();
        List<Customer> listCust = customerService.getAllCustomer();
        model.addAttribute("emiNew",emi);
        model.addAttribute("listCust",listCust);
        return "insertEmi";
    }
    @RequestMapping(path = "saveEmi",method = RequestMethod.POST)
    public String saveEmi(@ModelAttribute("emiNew")Emi emi)
    {
        boolean bl = emiService.saveEmi(emi);
        if (bl)
        {
            return "redirect:/?success=insert success\"";
        }
        return "redirect:/emi?error=insert failed";
    }

    @RequestMapping(path = "/detail")
    public String detailEmi(@RequestParam("id")Long id, Model model)
    {
        return "";
    }
}
