package com.example.Course.controller;


import com.example.Course.Model.Course;
import com.example.Course.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("course", new Course());
        return "create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("course") Course newCourse, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "create";
        }
        courseService.add(newCourse);
        return "redirect:/course/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        Course course = courseService.getCourseById(id);
        if (course != null) {
            model.addAttribute("course", course);
            return "edit";
        } else {
            return "redirect:/course/list";
        }
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("course") Course updatedCourse, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        courseService.update(updatedCourse);
        return "redirect:/course/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        courseService.delete(id);
        return "redirect:/course/list";

    }

    @GetMapping("/search")
    public String search(@RequestParam("keyword") String keyword, Model model) {
        List<Course> courses = courseService.searchCourses(keyword);
        model.addAttribute("courses", courses);
        return "list";
    }
}

