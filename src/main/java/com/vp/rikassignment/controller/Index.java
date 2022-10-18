package com.vp.rikassignment.controller;

import com.vp.rikassignment.model.Event;
import com.vp.rikassignment.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;


@Controller
public class Index {

    @Autowired
    EventRepository eventRepository;

    @GetMapping("/")
    public String HomePage(Model model){
        Iterable<Event> events = eventRepository.findAll();
        model.addAttribute("events", events);
//        model.put("events", events);
        System.out.println(events);
        return "index";
    }
}

