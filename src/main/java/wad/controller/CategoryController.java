/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wad.domain.Category;
import wad.domain.News;
import wad.domain.Writer;
import org.springframework.ui.Model;
import wad.repository.CategoryRepository;
import wad.repository.NewsRepository;
import wad.repository.WriterRepository;

/**
 *
 * @author mmohamud
 */
@Controller
@Transactional
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping("/addCategory")
    public String addCategory(@RequestParam String nimi, Model model) {
        nimi.toLowerCase();
        nimi.trim();
        ArrayList<String> errors = new ArrayList();
        Boolean apu = false;
        for (Category category : categoryRepository.findAll()) {
            if (category.getNimi().equals(nimi)){
            apu = true;
            }
            errors.add("Kategoria on jo olemassa!");
            model.addAttribute("error", errors);
        }
        if (apu == false) {
            Category category = new Category();
            category.setNimi(nimi);
            categoryRepository.save(category);
        }
        return "redirect:/";
    }
}
