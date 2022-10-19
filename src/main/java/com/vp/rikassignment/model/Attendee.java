package com.vp.rikassignment.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Attendee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;
    @NotBlank
    private String name;
    @NotBlank
    @JsonProperty
    private boolean isPerson;
}



