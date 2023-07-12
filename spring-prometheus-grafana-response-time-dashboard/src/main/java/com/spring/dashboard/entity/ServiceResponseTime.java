package com.spring.dashboard.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Entity
@Table(name = "service_response_time",indexes = {@Index(name = "restimeidx",columnList = "created_date",unique = false)})
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceResponseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "variable_name")
    private String variableName;

    @Column(name = "variable_value")
    private Double variableValue;

    @PrePersist
    private void prePersist() {
        createdDate = LocalDateTime.now();
    }

}
