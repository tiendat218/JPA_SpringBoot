package com.example.travel.controller;

import com.example.travel.jpa.Customer;
import com.example.travel.service.CustomerService;
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
@RequestMapping(path = "/admin/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @InitBinder
    public void InitBinder(WebDataBinder data)
    {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        data.registerCustomEditor(Date.class, new CustomDateEditor(s, true));
    }

    @RequestMapping("")
    public String getCustomer(Model model)
    {
        Customer customer = new Customer();
        return findPaginatedCus(1,model,customer);
    }


    @RequestMapping("show")
    public String getCustomersShow(Model model)
    {
        Customer customer = new Customer();
        return findPagCusShow(1,model, customer);
    }

    @RequestMapping("hidden")
    public String getCustomersHidden(Model model)
    {
        Customer customer = new Customer();
        return findPagCusHidden(1,model, customer);
    }

    @RequestMapping("/insertCustomer")
    public String insertCustomer(Model model)
    {
        Customer customer = new Customer();
        model.addAttribute("newCustomer",customer);
        return "admin/customer/insertCustomer";
    }
    @RequestMapping(path = "/saveCustomer",method = RequestMethod.POST)
    public String saveCustomer(@ModelAttribute("newCustomer")@Valid Customer customer, BindingResult result, Model model)
    {
        if (result.hasErrors())
        {
            return findPaginatedCus(1,model,customer);
        }
        boolean checkCustomerName = customerService.checkCustomerName(customer.getCustomerName());
        if (checkCustomerName==false)
        {
            return "redirect:/admin/customer?errorcustomername=Customer Name is existed";
        }

        boolean bl = customerService.saveCustomer(customer);
        if (bl)
        {
            return "redirect:/admin/customers/";
        }
        return "redirect:/admin/customer?error=Add New Customer error";

    }

    @RequestMapping(path = "/editCustomer")
    public String editCustomer(@RequestParam("customerId")Integer customerId, Model model)
    {
        Customer customer = customerService.getCustomerById(customerId);
        model.addAttribute("editCustomer",customer);
        return "admin/customer/editCustomer";
    }

    @RequestMapping(path = "/updateCustomer",method = RequestMethod.POST)
    public String updateCustomer(@ModelAttribute("editCustomer")Customer customer)
    {
        boolean checkCustomerName = checkCustomerName(customer.getCustomerName(),customer.getCustomerId());
        if (checkCustomerName==false)
        {
            return "redirect:/admin/customer/editCustomer?id="+customer.getCustomerId()+"&&errorcustomername=Customer Name is existed";
        }
        boolean bl = customerService.updateCustomer(customer);
        if (bl)
        {
            return "redirect:/admin/customers/";
        }
        return "redirect:/admin/customer?error=Update Customer error";

    }

    @RequestMapping(value = "/detailCustomer")
    public String detailCustomerById(@RequestParam("customerId")Integer customerId,Model model)
    {
        Customer customer = customerService.getCustomerById(customerId);
        model.addAttribute("detailCustomer",customer);
        return "admin/customer/detailCustomer";
    }

    @RequestMapping(path = "/deleteCustomer")
    public String deleteCustomer(@RequestParam("customerId")Integer customerId)
    {
        boolean bl = customerService.deleteCustomer(customerId);
        if (bl)
        {
            return "redirect:/admin/customers/";
        }
        return "redirect:admin/customer?error=Delete Customer error";
    }

    @RequestMapping("/page/{pageNo}")
    public String findPaginatedCus(@PathVariable(value = "pageNo")int pageNo, Model model, Customer customer)
    {
        int pageSize = 10;
        Page<Customer> page = customerService.findPaginated(pageNo,pageSize);
        List<Customer> customers = page.getContent();
        model.addAttribute("currentPage",pageNo);
        model.addAttribute("totalPages",page.getTotalPages());
        model.addAttribute("totalItems",page.getTotalElements());
        model.addAttribute("newCustomer", customer);
        model.addAttribute("customers",customers);
        return "admin/customer/listCustomers";
    }

    @RequestMapping("/pageShow/{pageNo}")
    public String findPagCusShow(@PathVariable(value = "pageNo")int pageNo, Model model,  Customer customer)
    {
        int pageSize = 10;
        Page<Customer> page = customerService.findPaginatedShow(pageNo,pageSize);
        List<Customer> customers = page.getContent();
        model.addAttribute("currentPage",pageNo);
        model.addAttribute("totalPages",page.getTotalPages());
        model.addAttribute("totalItems",page.getTotalElements());
        model.addAttribute("newCustomer", customer);
        model.addAttribute("customers",customers);
        return "admin/customer/listCustomers";
    }
    @RequestMapping("/pageHidden/{pageNo}")
    public String findPagCusHidden(@PathVariable(value = "pageNo")int pageNo, Model model,Customer customer)
    {
        int pageSize = 10;
        Page<Customer> page = customerService.findPaginatedHidden(pageNo,pageSize);
        List<Customer> customers = page.getContent();
        model.addAttribute("currentPage",pageNo);
        model.addAttribute("totalPages",page.getTotalPages());
        model.addAttribute("totalItems",page.getTotalElements());
        model.addAttribute("newCustomer", customer);
        model.addAttribute("customers",customers);
        return "admin/customer/listCustomers";
    }
    public boolean checkCustomerName(String customerName, int customerId)
    {
        Customer customer = customerService.getCustomerById(customerId);
        boolean checkCustomerName = customerService.checkCustomerName(customerName);
        if (checkCustomerName==false)
        {
            if (customerName.equals(customer.getCustomerName()))
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
