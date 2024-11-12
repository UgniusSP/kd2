package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private boolean doesWorkOnMonday;
    private boolean doesWorkOnTuesday;
    private boolean doesWorkOnWednesday;
    private boolean doesWorkOnThursday;
    private boolean doesWorkOnFriday;
    private boolean doesWorkOnSaturday;
    private boolean doesWorkOnSunday;


}
