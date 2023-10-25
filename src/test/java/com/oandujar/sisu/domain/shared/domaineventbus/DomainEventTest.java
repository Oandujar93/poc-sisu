package com.oandujar.sisu.domain.shared.domaineventbus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DomainEventTest {

    @InjectMocks
    private DomainEvent domainEvent;

    @Mock
    private Map<String, Object> data;

    @Test
    void getId() {
        DomainEventId domainEventId = domainEvent.getId();
        assertNotNull(domainEventId);
    }

    @Test
    void getDate() {
        LocalDateTime localDateTime = domainEvent.getDate();
        assertNotNull(localDateTime);
    }

    @Test
    void getData() {
        Map<String, Object> map = domainEvent.getData();
        assertNotNull(map);
    }
}