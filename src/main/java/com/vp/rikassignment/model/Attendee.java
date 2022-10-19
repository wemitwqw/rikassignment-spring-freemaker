package com.vp.rikassignment.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
//    @NotNull
    @Enumerated(EnumType.STRING)
    private Payment payment;
//    @NotNull
    @JsonProperty
    private boolean isPerson;
    private String description;
}



