package com.tevcode.devtracker.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    private String title;
    private String description;


    @NotNull(message = "Status is required")
    @Enumerated(EnumType.STRING)
    private Status status;

    @NotNull(message = "Type is required")
    @Enumerated(EnumType.STRING)
    private TaskType type;


    @NotNull(message = "Priority is required")
    @Enumerated(EnumType.STRING)
    private Priority priority;

    private LocalDateTime createdAt;
}
