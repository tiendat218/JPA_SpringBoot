//package com.example.travel.controller;
//
//import com.example.travel.jpa.User;
//import com.example.travel.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import javax.validation.Valid;
//
//@Controller
//@RequestMapping(path = "/register")
//public class UserRegistrationController {
//    @Autowired
//    private UserService userService;
//    @RequestMapping(path = "")
//    public String showRegister(Model model)
//    {
//        User user = new User();
//        model.addAttribute("userNew",user);
//        return "admin/user/register";
//    }
//
//    @RequestMapping(path = "registerAdmin",method = RequestMethod.POST)
//    public String saveRegister(@Valid @ModelAttribute("userNew")User user, BindingResult result, Model model)
//    {
//        if (result.hasErrors())
//        {
//            model.addAttribute("userNew",user);
//            return "admin/user/register";
//        }
//        boolean validateMail = checkEmail(user);
//        if (validateMail==false)
//        {
//            return "redirect:/register?error=Email already exists";
//        }
//        boolean bl = userService.saveUser2(user);
//        if (bl)
//        {
//            return "redirect:/register?success=register success";
//        }
//        return "redirect:/register?error";
//    }
//
//
//    public boolean checkEmail(User user)
//    {
//        User userEmail = userService.checkUserName(user.getUserName());
//        if (userEmail==null)
//        {
//            return true;
//        }else{
//            return false;
//        }
//    }
//}
