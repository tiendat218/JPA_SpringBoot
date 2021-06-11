package com.example.travel.controller;


import com.example.travel.jpa.Comment;
import com.example.travel.jpa.Customer;
import com.example.travel.jpa.Location;
import com.example.travel.service.CommentService;
import com.example.travel.service.CustomerService;
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
@RequestMapping(path = "/admin/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private CustomerService customerService;

    @InitBinder
    public void InitBinder(WebDataBinder data) {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        data.registerCustomEditor(Date.class, new CustomDateEditor(s, true));
    }

    @RequestMapping("")
    public String getComments(Model model) {
        Comment comment = new Comment();
        return findPaginated(1, model, comment);
    }

    @RequestMapping("show")
    public String getCommentShow(Model model) {
        Comment comment = new Comment();
        return findPagShow(1, model, comment);
    }

    @RequestMapping("hidden")
    public String getCommentHidden(Model model) {
        Comment comment = new Comment();
        return findPagHidden(1, model, comment);
    }

    @RequestMapping("/insertComment")
    public String insertComment(Model model)
    {
        Comment comment = new Comment();
        List<Location> locations = locationService.getLocationsByStatus(1);
        List<Customer> customers = customerService.getCustomersByStatus(1);
        model.addAttribute("newComment",comment);
        model.addAttribute("locations",locations);
        model.addAttribute("customers",customers);
        return "admin/comment/insertComment";
    }

    @RequestMapping(value = "/saveComment",method = RequestMethod.POST)
    public String saveComment(@ModelAttribute("newComment")@Valid Comment comment, BindingResult result,Model model)throws IOException
    {
        if (result.hasErrors())
        {
            List<Location> locations = locationService.listLocations();
            List<Customer> customers = customerService.listCustomers();
            model.addAttribute("locations",locations);
            model.addAttribute("customers",customers);
            model.addAttribute("newComment",comment);
            return "admin/comment/insertComment";
        }
        boolean checkCommentName = commentService.checkCommentName(comment.getCommentName(),comment.getLocation().getLocationId(), comment.getCustomer().getCustomerId());
        if (checkCommentName==false)
        {
            return "redirect:/admin/comment/insertComment?errorcommentname=Comment Name is existed";
        }

        boolean bl = commentService.saveComment(comment);
        if(bl)
        {
            return "redirect:/admin/comments/";
        }
        return "redirect:/admin/comment?error=Add New Comment error";
    }

    @RequestMapping(value = "/editComment")
    public String editComment(@RequestParam("commentId")Integer commentId,Model model)
    {
        Comment comment = commentService.getCommentById(commentId);
        List<Location> locations = locationService.getLocationsByStatus(1);
        List<Customer> customers = customerService.getCustomersByStatus(1);
        model.addAttribute("editComment",comment);
        model.addAttribute("locations",locations);
        model.addAttribute("customers",customers);
        return "admin/comment/editComment";
    }

    @RequestMapping(path = "/updateComment", method = RequestMethod.POST)
    public String updateComment(@ModelAttribute("editComment") Comment comment) {
        boolean checkCommentName = checkCommentName(comment.getCommentName(), comment.getCommentId(), comment.getLocation().getLocationId(), comment.getCustomer().getCustomerId());
        if (checkCommentName == false) {
            return "redirect:/admin/comment/editComment?id=" + comment.getCommentId() + "&&errorcommentname=Comment Name is existed";
        }
        boolean bl = commentService.updateComment(comment);
        if (bl) {
            return "redirect:/admin/comments/";
        }
        return "redirect:/admin/comment?error=Update Comment Error";

    }

    @RequestMapping(value = "/detailComment")
    public String detailCommentById(@RequestParam("commentId")Integer commentId,Model model)
    {
        Comment comment = commentService.getCommentById(commentId);
        model.addAttribute("detailComment",comment);
        return "admin/comment/detailComment";
    }

    @RequestMapping(path = "/deleteComment")
    public String deleteComment(@RequestParam("commentId") Integer commentId) {
        boolean bl = commentService.deleteComment(commentId);
        if (bl) {
            return "redirect:/admin/comment/";
        }
        return "redirect:admin/comment?error=Delete Comment Error";
    }


    @RequestMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model, Comment comment) {
        int pageSize = 10;
        List<Location> locations = locationService.listLocations();
        List<Customer> customers = customerService.listCustomers();
        Page<Comment> page = commentService.findPaginated(pageNo, pageSize);
        List<Comment> comments = page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("commentNew", comment);
        model.addAttribute("comments", comments);
        model.addAttribute("locations",locations);
        model.addAttribute("customers",customers);
        return "admin/comment/listComments";
    }

    @RequestMapping("/pageShow/{pageNo}")
    public String findPagShow(@PathVariable(value = "pageNo") int pageNo, Model model, Comment comment) {
        int pageSize = 10;
        Page<Comment> page = commentService.findPaginatedShow(pageNo, pageSize);
        List<Location> locations = locationService.listLocations();
        List<Customer> customers = customerService.listCustomers();
        List<Comment> comments = page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("commentNew", comment);
        model.addAttribute("comments", comments);
        model.addAttribute("locations",locations);
        model.addAttribute("customers",customers);
        return "admin/comment/listComments";
    }

    @RequestMapping("/pageHidden/{pageNo}")
    public String findPagHidden(@PathVariable(value = "pageNo") int pageNo, Model model, Comment comment) {
        int pageSize = 10;
        Page<Comment> page = commentService.findPaginatedHidden(pageNo, pageSize);
        List<Location> locations = locationService.listLocations();
        List<Customer> customers = customerService.listCustomers();
        List<Comment> comments = page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("commentNew", comment);
        model.addAttribute("comments", comments);
        model.addAttribute("locations",locations);
        model.addAttribute("customers",customers);
        return "admin/comment/listComments";
    }

    public boolean checkCommentName(String commentName, int commentId, int locationId, int customerId) {
        Comment comment = commentService.getCommentById(commentId);
        boolean checkCommentName = commentService.checkCommentName(commentName,locationId, customerId);
        if (checkCommentName==false)
        {
            if (commentName.equals(comment.getCommentName()) && comment.getLocation().getLocationId()==locationId && comment.getCustomer().getCustomerId()==customerId)
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
