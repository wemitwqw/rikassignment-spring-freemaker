package com.vp.rikassignment.controller;

import com.vp.rikassignment.model.Event;
import com.vp.rikassignment.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;


@Controller
public class Index {

    @Autowired
    EventRepository eventRepository;

    @GetMapping("/")
    public String HomePage(Model model){
        Iterable<Event> events = eventRepository.findAll();
//        for (Event event : events) {
//            System.out.println(event.getDate());
//        }
        model.addAttribute("events", events);
        return "index";
    }

    @GetMapping("/event")
    public String EventPage(){
        return "eventAdd";
    }

    @GetMapping("/event/{eventID}")
    public String EventEditPage(@PathVariable String eventID, Model model){
        Event event = eventRepository.findById(eventID).get();
        model.addAttribute("event", event);
        return "event";
    }

    @PostMapping("event/add")
    public String EventSave(
            @RequestParam String name,
            @RequestParam String date,
            @RequestParam String time,
            @RequestParam String place,
            @RequestParam String desc,
            Event event
//            @RequestParam Map<String, String> form

    ){
//        LocalDate parsedDate = LocalDate.parse(date);

        event.setName(name);
        event.setDate(date);
        event.setTime(time);
        event.setPlace(place);
        event.setDescription(desc);

        eventRepository.save(event);

//        for (String key : form.keySet()) {
//            System.out.println(key);
//        }
//        System.out.println(name);
//        System.out.println(time);
//       form.toString()
        return "redirect:/event";
    }
}

