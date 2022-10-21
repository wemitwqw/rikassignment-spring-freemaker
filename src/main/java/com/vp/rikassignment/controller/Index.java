package com.vp.rikassignment.controller;

import com.vp.rikassignment.model.Attendee;
import com.vp.rikassignment.model.Event;
import com.vp.rikassignment.model.Payment;
import com.vp.rikassignment.repository.AttendeeRepository;
import com.vp.rikassignment.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@Controller
public class Index {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    AttendeeRepository attendeeRepository;

    @GetMapping("/")
    public String HomePage(Model model){
        Iterable<Event> events = eventRepository.findAll();
        model.addAttribute("events", events);
        return "index";
    }

    @GetMapping("/event")
    public String EventPage(){
        return "eventAdd";
    }

    @PostMapping("/event/add")
    public String EventSave(
            @RequestParam String name,
            @RequestParam String date,
            @RequestParam String time,
            @RequestParam String place,
            @RequestParam String desc,
            Event event
//            @RequestParam Map<String, String> form

    ){
        event.setName(name);
        event.setDate(date);
        event.setTime(time);
        event.setPlace(place);
        event.setDescription(desc);

        eventRepository.save(event);
        return "redirect:/event";
    }

    @GetMapping("/event/{eventID}")
    public String EventEditPage(@PathVariable String eventID, Model model){
        Event event = eventRepository.findById(eventID).get();
        model.addAttribute("event", event);
        return "event";
    }

    @GetMapping("/event/del/{eventID}")
    public String EventDelete(@PathVariable String eventID){
        Event event = eventRepository.findById(eventID).get();
        for (Attendee att : event.getAttendees()){
            attendeeRepository.deleteById(att.getId());
        }
        eventRepository.deleteById(eventID);
        return "redirect:/";
    }

    @GetMapping("/attendee/{attendeeID}")
    public String Attendee(@PathVariable String attendeeID, Model model){
        Attendee attendee = attendeeRepository.findById(attendeeID).get();
        model.addAttribute("attendee", attendee);
        return "attendee";
    }

    @PostMapping("/attendee/{attendeeID}")
    public String Attendee(
            @PathVariable String attendeeID,
            @RequestParam Optional<String> name,
            @RequestParam Optional<String> firstname,
            @RequestParam Optional<String> lastname,
            @RequestParam String code,
            @RequestParam String payment,
            @RequestParam String desc
    ) {
        Attendee att = attendeeRepository.findById(attendeeID).get();
        if (att.isPerson()) {
            att.setFirstName(firstname.get());
            att.setLastName(lastname.get());
        } else {
            att.setBusinessName(name.get());
        }
        att.setCode(code);
        if(Objects.equals(payment, "Sularaha")){
            att.setPayment(Payment.CASH);
        } else {
            att.setPayment(Payment.TRANSFER);
        }
        att.setDescription(desc);
        attendeeRepository.save(att);
        return "redirect:/attendee/"+attendeeID;
    }

    @PostMapping("/attendee/add/{eventID}")
    public String AddAttendee(
            @PathVariable String eventID,
            @RequestParam String selector,
            @RequestParam String name,
            @RequestParam String firstname,
            @RequestParam String lastname,
            @RequestParam String code,
            @RequestParam String payment,
            @RequestParam String desc
    ){
        Attendee attendee = new Attendee();
        if (Objects.equals(selector, "option1")){
            attendee.setFirstName(firstname);
            attendee.setLastName(lastname);
            attendee.setPerson(true);
        } else {
            attendee.setBusinessName(name);
            attendee.setPerson(false);
        }
        attendee.setCode(code);
        if(Objects.equals(payment, "Sularaha")){
            attendee.setPayment(Payment.CASH);
        } else {
            attendee.setPayment(Payment.TRANSFER);
        }
        attendee.setDescription(desc);

        Event event = eventRepository.findById(eventID).get();
        List<Attendee> attendeesList = event.getAttendees();
        attendeesList.add(attendee);
        event.setAttendees(attendeesList);
        eventRepository.save(event);

        return "redirect:/event/"+eventID;
    }

    @GetMapping("/attendee/del/{eventID}/{attendeeID}")
    public String removeAttendeeFromEvent(
            @PathVariable String eventID,
            @PathVariable String attendeeID
    ){
        Attendee att = attendeeRepository.findById(attendeeID).get();
        Event event = eventRepository.findById(eventID).get();
        event.getAttendees().remove(att);
        eventRepository.save(event);

        return "redirect:/"+eventID;
    }

}