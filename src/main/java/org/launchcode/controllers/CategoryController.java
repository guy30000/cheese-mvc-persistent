package org.launchcode.controllers;

import org.launchcode.models.Category;
import org.launchcode.models.data.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("category")
public class CategoryController {

    //AUtowired is a connector to the database
    @Autowired
    private CategoryDao categoryDao;


    //Calls Catagory
    @RequestMapping(value = "")
    public String index(Model model){
        model.addAttribute("categories", categoryDao.findAll());
        model.addAttribute("title", "Categories");

        return "category/index";
    }
    //Pulls the add fucntion from Catagory
    //Bill Now, these are different. Diaplay Add Categorty Form
    @RequestMapping(value="add", method = RequestMethod.GET)
    public String displayAddCategoryForm(Model model) {
        model.addAttribute("title", "Add Category");
        model.addAttribute(new Category());
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        return "category/add";
    }

    @RequestMapping(value="add", method = RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute @Valid Category newCategory, Errors errors, Model model){
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Category");
            System.out.println("YYYYYYYYYYYYYYYYYYYYYYYY");
            return "category/add";
        }

        categoryDao.save(newCategory);
        return "redirect:";
    }

}