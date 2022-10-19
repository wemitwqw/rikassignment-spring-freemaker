package com.vp.rikassignment.controller;

import com.vp.rikassignment.model.Event;
import com.vp.rikassignment.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;


@Controller
public class Index {

    @Autowired
    EventRepository eventRepository;

    @GetMapping("/")
    public String HomePage(Model model){
        Iterable<Event> events = eventRepository.findAll();
        model.addAttribute("events", events);
        return "index";
    }

    @GetMapping("/event")
    public String EventPage(){
        return "event";
    }

    @GetMapping("/event/{eventID}")
    public String EventEditPage(@PathVariable String eventID, Model model){
//        Optional<Event> event = eventRepository.findById(id);
//        eventID = Integer.parseInt(eventID);
        Event event = eventRepository.findById(eventID).get();
        model.addAttribute("event", event);
        return "event";
    }

    @PostMapping("event/add")
    public String EventAdd(Model model){
        return "event";
    }
}

