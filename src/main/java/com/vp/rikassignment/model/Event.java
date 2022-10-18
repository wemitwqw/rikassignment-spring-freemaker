package com.vp.rikassignment.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;
    @NotBlank
    private String name;
    @NotBlank
    private String date;
    @NotBlank
    private String time;
    @ElementCollection
    private List<Integer> attendees;
}



