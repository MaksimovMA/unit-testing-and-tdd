package com.acme.banking.dbo.domain;

import com.acme.banking.dbo.domain.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.omg.CORBA.portable.ApplicationException;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class SavingAccountTest {

    @Test
    void getAmount() {
    }

    @Test
    void getId() {
    }

    @Test
    @DisplayName("Test saving account")
    void shouldNotSaveClientAfterSaving() {
        final int clientId = 1;
        final int dummySavingAccountId = 0;
        final String dummyClientName = "Elon Musk";
        final double dummyAmount = 2.2;

       Client client = new Client(clientId,dummyClientName);
       assertThrows(IllegalArgumentException.class, () -> new SavingAccount(dummySavingAccountId,client,dummyAmount));
    }

    @Test
    void shouldNotCreateClientWhenIdClientIsNull() {
        final int clientId = 0;
        final String clientName = "Elon Musk";

        assertThrows(IllegalArgumentException.class, () -> new Client(clientId,clientName));
    }
}