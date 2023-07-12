package com.spring.dashboard.repository;

import com.spring.dashboard.entity.ServiceResponseTime;
import lombok.extern.java.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceResponseTimeRepository extends JpaRepository<ServiceResponseTime, Long> {
}
