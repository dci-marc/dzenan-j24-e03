package org.dci.studentmanagementapi.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record StudentDTO(
        @NotBlank(message = "First name cannot be blank.")
        String firstName,
        @NotBlank(message = "Last name cannot be blank.")
        String lastName,
        @Positive
        Integer age,
        String major
) {
}
