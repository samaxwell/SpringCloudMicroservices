package com.sean.controllers;

import com.netflix.discovery.shared.Application;
import com.netflix.discovery.shared.Applications;
import com.netflix.eureka.registry.PeerAwareInstanceRegistry;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/refresh")
@AllArgsConstructor
public class RefreshController {

    RestTemplate restTemplate;
    PeerAwareInstanceRegistry registry;

    @GetMapping
    public void refreshAllServiceInstances(@RequestParam("serviceName") String serviceName) {
        log.info("Refreshing all instances of {}", serviceName);

        Optional<Application> optional = Optional.ofNullable(registry.getApplication(serviceName));
        if ((optional.isPresent())) {

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            optional.get().getInstances().parallelStream().forEach(instance -> {
                log.info("\t- {} [{}]\n", instance.getAppName(), instance.getInstanceId());
                restTemplate.postForLocation(
                        instance.getHomePageUrl() + "actuator/refresh",
                        new HttpEntity(null, headers));
            });
        }
        else {
            printAllApps();
        }
    }

    /*  Print all instances of all registered apps */
    private void printAllApps() {
        System.out.printf("Looks like you tried to refresh with an invalid app name. Try one of the following:\n\n");
        Applications apps = registry.getApplications();
        apps.getRegisteredApplications().forEach(registeredApp -> {
            System.out.printf("\t%s\n", registeredApp.getName());
            registeredApp.getInstances().forEach(instance -> {
                System.out.printf("\t\t -- %s\n", instance.getInstanceId());
            });
        });
    }

}
