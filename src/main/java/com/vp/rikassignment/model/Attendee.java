package com.vp.rikassignment.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Attendee {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    private String businessName;
    private String firstName;
    private String lastName;
    @NotBlank
    private String code;
    @Enumerated(EnumType.STRING)
    private Payment payment;
    @JsonProperty
    private boolean isPerson;
    private String description;
}



