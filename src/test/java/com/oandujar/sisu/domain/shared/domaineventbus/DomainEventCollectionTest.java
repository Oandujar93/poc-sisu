package com.oandujar.sisu.domain.shared.domaineventbus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class DomainEventCollectionTest {

    private DomainEventCollection domainEventCollection;

    @Mock
    private DomainEvent domainEvent;

    @BeforeEach
    void setUp() {
        domainEventCollection = new DomainEventCollection();
    }

    @Test
    void getAll() {
        List<DomainEvent> domainEvents = domainEventCollection.getAll();
        assertNotNull(domainEvents);
    }

    @Test
    void add() {
        domainEventCollection.add(domainEvent);
        List<DomainEvent> domainEvents = domainEventCollection.getAll();
        assertNotNull(domainEvents);
        assertEquals(1, domainEvents.size());
    }

    @Test
    void clear() {
        domainEventCollection.clear();
        List<DomainEvent> domainEvents = domainEventCollection.getAll();
        assertNotNull(domainEvents);
        assertEquals(0, domainEvents.size());
    }

}