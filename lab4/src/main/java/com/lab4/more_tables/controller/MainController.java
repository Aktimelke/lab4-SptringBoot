package com.lab4.more_tables.controller;

import com.lab4.more_tables.model.Phone;
import com.lab4.more_tables.model.Tv;
import com.lab4.more_tables.service.PhoneService;
import com.lab4.more_tables.service.TvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MainController {
    private final PhoneService phoneService;

    private final TvService tvService;

    @Autowired
    public MainController(PhoneService phoneService, TvService tvService){
        this.phoneService=phoneService;
        this.tvService=tvService;
    }

    @GetMapping("/")
    public String showMainPage(){
        return"index2";
    }
    @GetMapping("/phones")
    public String findAll(Model model){
        List<Phone> phone = phoneService.findAll();
        model.addAttribute("phone",phone);
        return "Phones";
    }
    @GetMapping("/phone-create")
    public String createForm(Phone phone) {
        return "phone-create";
    }

    @PostMapping("/phone-create")
    public String createInfo(Phone phone) {
        phoneService.savePhone(phone);
        return "redirect:/phones";
    }

    @GetMapping("phone-delete/{id}")
    public String deletePhone(@PathVariable("id") Long id) {
        phoneService.deleteById(id);
        return "redirect:/phones";
    }

    @GetMapping("phone-update/{id}")
    public String PhoneUpdateForm(@PathVariable("id") Long id, Model model) {
        Phone phone = phoneService.findById(id);
        model.addAttribute("phone", phone);
        return "phone-update";
    }

    @PostMapping("/phone-update")
    public String infoUpdate(Phone phone) {
       phoneService.savePhone(phone);
        return "redirect:/phones";
    }


    @GetMapping("/tvs")
    public String findAll2(Model model){
        List<Tv> tv = tvService.findAll();
        model.addAttribute("tv",tv);
        return "Tvs";
    }
    @GetMapping("/tv-create")
    public String createForm2(Tv tv) {
        return "tv-create";
    }

    @PostMapping("/tv-create")
    public String createInfo2(Tv tv) {
        tvService.saveTv(tv);
        return "redirect:/tvs";
    }

    @GetMapping("tv-delete/{id}")
    public String deleteTv(@PathVariable("id") Long id) {
        tvService.deleteById(id);
        return "redirect:/tvs";
    }

    @GetMapping("tv-update/{id}")
    public String TvUpdateForm(@PathVariable("id") Long id, Model model) {
        Tv tv = tvService.findById(id);
        model.addAttribute("tv", tv);
        return "tv-update";
    }

    @PostMapping("/tv-update")
    public String infoUpdate2(Tv tv) {
        tvService.saveTv(tv);
        return "redirect:/tvs";
    }
}
