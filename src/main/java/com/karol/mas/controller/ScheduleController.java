package com.karol.mas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class ScheduleController {

//    @Autowired
//    private JpaWyposazenieTeatruDao wyposazenieTeatru;

    @Autowired
    JdbcTemplate jdbcTemplate;
    @GetMapping("/")
    public String helloPage()
    {
        //return "experimental2";
        return "hello";
    }
    @GetMapping("/schedule")
    public String schedulePage(Model model)
    {
        return "schedule";
    }

    @GetMapping("/news")
    public String newsPage()
    {
        return "hello";
    }

    @GetMapping("/layout")
    public String x()
    {
        return "layout";
    }

    @GetMapping("/add_theaterPlay")
    public String addTheaterPlayGET()
    {
        return "add_theaterPlay";
    }
    @PostMapping("/add_theaterPlay")
    public String addTheaterPlayPOST(@RequestParam("name") String name, @RequestParam("description") String description)
    {
        //
        //jdbcTemplate.update("INSERT INTO TheaterPlay (play_name, play_description) VALUES (?, ?)", name, description);
        return "layout";
    }

    @GetMapping("/magazine/items")
    public String showItems(Model model)
    {
        System.out.println("XD");
        //List<WyposazenieTeatru> lista =
//        List<WyposazenieTeatru> items = wyposazenieTeatru.getAllWyposazenieTeatru();
//        System.out.println(items);
//        model.addAttribute("wyposazenie", items);
        return "items";
    }
    @PostMapping("/magazine/post_items")
    public String postItems()
    {
        //jdbcTemplate.execute("INSERT INTO WyposazenieTeatru (identyfikator_magazynowy, nazwa, opis) values ()");
        return "items";
    }

    @PostMapping("/post_theaterPlay")
    public String postTheaterPlay(@RequestParam("name") String name, @RequestParam("description") String description)
    {
        //jdbcTemplate.execute("INSERT INTO TheaterPlay");
        return "layout";
    }

    @PostMapping("/submit")
    public String experimental(@RequestBody List<String> params)
    {

        //params.stream().map(x -> jdbcTemplate.update("INSERT INTO "));
        return "layout";
    }
}
