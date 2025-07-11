package org.dci.studentmanagementapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {

    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @Positive
    private Integer age;
    @NotBlank
    private String major;
}
