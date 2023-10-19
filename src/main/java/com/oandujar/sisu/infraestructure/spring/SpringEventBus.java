package com.oandujar.sisu.infraestructure.spring;

import com.oandujar.sisu.domain.shared.domaineventbus.DomainEvent;
import com.oandujar.sisu.domain.shared.domaineventbus.DomainEventBus;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
@Primary
public class SpringEventBus implements DomainEventBus {

    public void publish(DomainEvent event) {
        System.out.printf("%s %s %s%n", event.getClass().getName(), event.getId().getValue(), event.getDate().format(DateTimeFormatter.ISO_DATE_TIME));
    }
}