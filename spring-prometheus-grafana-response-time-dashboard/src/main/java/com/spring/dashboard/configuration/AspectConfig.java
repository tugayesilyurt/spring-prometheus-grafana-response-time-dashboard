package com.spring.dashboard.configuration;

import com.spring.dashboard.entity.ServiceResponseTime;
import com.spring.dashboard.repository.ServiceResponseTimeRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

    @Aspect
    @Component
    @Slf4j
    @RequiredArgsConstructor
    public class AspectConfig {

        private final ServiceResponseTimeRepository serviceResponseTimeRepository;

        @Around("execution(* com.spring.dashboard.controller.DashboardController.*(..))")
        public Object calculateResponseTime(ProceedingJoinPoint joinPoint) throws Throwable {

            final HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();

            Object result = joinPoint.proceed();

            stopWatch.stop();
            long elapsedTime = stopWatch.getTotalTimeMillis();

            log.info("Method: {} - Response Time: {} ms", httpServletRequest.getRequestURI(), elapsedTime);

            serviceResponseTimeRepository.save(ServiceResponseTime.builder().variableName(httpServletRequest.getRequestURI()).variableValue(stopWatch.getTotalTimeSeconds()).build());

            return result;
        }
}

