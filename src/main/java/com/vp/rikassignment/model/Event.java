package com.vp.rikassignment.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    @NotBlank
    private String name;
    @NotBlank
    private String place;
    @NotBlank
    private String date;
    @NotBlank
    private String time;
    //    @ElementCollection
    private String description;
    @Getter
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Attendee> attendees;
}



