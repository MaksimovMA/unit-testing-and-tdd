package com.acme.banking.dbo.domain;

import com.acme.banking.dbo.domain.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.omg.CORBA.portable.ApplicationException;


import static java.time.Duration.ofMillis;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class SavingAccountTest {

    @Test
    void shouldCreateClientWhenParamsValid() {
        final int clientId = 1;
        final String dummyClientName = "Test Name";

        assertDoesNotThrow(() -> new Client(clientId, dummyClientName));
    }

    @Test
    @DisplayName("Test saving account")
    void shouldNotSaveClientWhenSavingAccountZero() {
        final int clientId = 1;
        final int dummySavingAccountId = 0;
        final String dummyClientName = "Test Name";
        final double dummyAmount = 2.2;

        Client client = new Client(clientId, dummyClientName);
        assertThrows(IllegalArgumentException.class, () -> new SavingAccount(dummySavingAccountId, client, dummyAmount));
    }

    @Test
    @DisplayName("Test saving account")
    void shouldNotSaveClientWhenAmountZero() {
        final int clientId = 1;
        final int dummySavingAccountId = 0;
        final String dummyClientName = "Test Name";
        final double dummyAmount = 0.0;

        Client client = new Client(clientId, dummyClientName);
        assertThrows(IllegalArgumentException.class, () -> new SavingAccount(dummySavingAccountId, client, dummyAmount));
    }

    @Test
    void shouldNotCreateClientWhenIdClientIsZero() {
        final int clientId = 0;
        final String clientName = "Test Name";

        assertThrows(IllegalArgumentException.class, () -> new Client(clientId, clientName));
    }

    @Test
    void shouldNotCreateClientWhenClientNAmeIsNull() {
        final int clientId = 1;
        final String clientName = null;

        assertThrows(IllegalArgumentException.class, () -> new Client(clientId, clientName));
    }

    @Test
    void getAmount() {
    }

    @Test
    void getId() {
    }
}