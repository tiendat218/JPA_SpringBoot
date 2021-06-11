package com.example.springbootservice.controller;


import com.example.springbootservice.jpa.Employee;
import com.example.springbootservice.service.EmployeeService;
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
@RequestMapping(path = "/admin/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;


    @InitBinder
    public void InitBinder(WebDataBinder data)
    {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        data.registerCustomEditor(Date.class, new CustomDateEditor(s, true));
    }

    @RequestMapping("")
    public String getEmployees(Model model)
    {
        Employee employee = new Employee();
        return findPaginatedEmp(1,model,employee);
    }

    @RequestMapping(path = "/saveEmployee",method = RequestMethod.POST)
    public String saveLibrary(@ModelAttribute("employeeNew")@Valid Employee employee, BindingResult result, Model model)
    {
        if (result.hasErrors())
        {
            return findPaginatedEmp(1,model,employee);
        }

        boolean bl = employeeService.saveEmployee(employee);
        if (bl)
        {
            return "redirect:/admin/employee/";
        }
        return "redirect:/admin/employee?error=Add New Employee error";
    }

    @RequestMapping(path = "/editEmployee")
    public String editEmployee(@RequestParam("id")Integer id, Model model)
    {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("editEmployee",employee);
        return "admin/employee/editEmployee";
    }

    @RequestMapping(path = "/updateEmployee",method = RequestMethod.POST)
    public String updateEmployee(@ModelAttribute("editEmployee")Employee employee)
    {
        boolean bl = employeeService.updateEmployee(employee);
        if (bl)
        {
            return "redirect:/admin/employee/";
        }
        return "redirect:/admin/employee?error=Update Employee error";
    }

    @RequestMapping(path = "/deleteEmployee")
    public String deleteEmployee(@RequestParam("id")Integer id)
    {
        boolean bl = employeeService.deleteEmployee(id);
        if (bl)
        {
            return "redirect:/admin/employee/";
        }
        return "redirect:admin/employee?error=Delete Employee error";
    }

    @RequestMapping("/page/{pageNo}")
    public String findPaginatedEmp(@PathVariable(value = "pageNo")int pageNo, Model model, Employee employee)
    {
        int pageSize = 10;
        Page<Employee> page = employeeService.findPaginatedEmployee(pageNo,pageSize);
        List<Employee> employees = page.getContent();
        model.addAttribute("currentPage",pageNo);
        model.addAttribute("totalPages",page.getTotalPages());
        model.addAttribute("totalItems",page.getTotalElements());
        model.addAttribute("employeeNew", employee);
        model.addAttribute("employees",employees);
        return "admin/employee/listEmployees";
    }
}
