package com.karol.mas.controller;

import com.karol.mas.entity.Sztuka;
import com.karol.mas.entity.WyposazenieTeatru;
import com.karol.mas.service.RekwizytService;
import com.karol.mas.service.SztukaService;
import com.karol.mas.service.WyposazenieTeatruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("/organizer")
public class OrganizerController {

    @Autowired
    WyposazenieTeatruService wyposazenieTeatruService;
    @Autowired
    RekwizytService rekwizytService;
    @Autowired
    SztukaService sztukaService;

    @GetMapping("/getWyposazenie")
    public String getWyposazenie(Model model)
    {
        Collection<WyposazenieTeatru> wyposazenieTeatru = wyposazenieTeatruService.getAllWyposazenie();
        model.addAttribute("items", wyposazenieTeatru);
        return "theater_equipment";
    }

    @PostMapping("/insertWyposazenie")
    @Transactional
    public RedirectView insertWyposazenie(@RequestBody WyposazenieTeatru wyposazenieTeatru)
    {
        wyposazenieTeatruService.addWyposazenieTeatru(wyposazenieTeatru);
        return new RedirectView("redirect:/organizer/getWyposazenie");
    }

    @PostMapping("/editWyposazenie")
    @Transactional
    public String editWyposazenie()
    {
        return "redirect:/organizer/getWyposazenie";
    }

    @PostMapping("/deleteWyposazenie")
    @Transactional
    public String deleteWyposazenie(@RequestBody WyposazenieTeatru wyposazenieTeatru)
    {
        System.out.println("XDDD");
        System.out.println(wyposazenieTeatru);
        System.out.println(wyposazenieTeatru.getID_Wyposazenie());
        wyposazenieTeatruService.deleteWyposazenieTeatru(wyposazenieTeatru.getID_Wyposazenie());
        return "redirect:/organizer/getWyposazenie";
    }
    @PostMapping("/addRekwizyt")
    @Transactional
    public String addRekwizyt()
    {
        System.out.println();
        return "";
    }

    @GetMapping("/getRekwizyt")
    public String getRekwizyty(Model model)
    {
        model.addAttribute("rekwizyty", rekwizytService.getAllRekwizyty());
        return "play_props.html";
    }

    @GetMapping("/getSztuka")
    public String getSztuki(Model model)
    {
        model.addAttribute("sztuki", sztukaService.getAllSztuki());
        return "theater_play";
    }

    @PostMapping("/addSztuka")
    public RedirectView addSztuka(@RequestBody Sztuka sztuka)
    {
        sztukaService.addSztuka(sztuka);
        return new RedirectView("redirect:/oragnizer/getSztuka");
    }

    @PostMapping("/deleteSztuka")
    public RedirectView deleteSztula(@RequestBody Map<String, Object> map)
    {
        sztukaService.deleteSztuka(Long.parseLong((String) map.get("ID_Sztuka")));
        return new RedirectView("redirect:/organizer/getSztuka");
    }

    @PostMapping("/editRequest")
    public RedirectView editRequest(@RequestBody Sztuka sztuka)
    {
        return new RedirectView("redirect:/organizer/editSztuka/"+sztuka.getID_Sztuka());
    }

    @GetMapping("/editSztuka/{id}")
    public RedirectView editSztuka(Model model, @PathVariable Long id)
    {
        model.addAttribute(rekwizytService.getAllRekwizyty());
        return new RedirectView("redirect:/oragnizer/editSztuka");
    }
}
