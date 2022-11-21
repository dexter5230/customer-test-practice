package com.amigoscode.testing.customer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository underTest;

    public CustomerRepositoryTest(CustomerRepository customerRepository) {
        this.underTest = customerRepository;
    }

    @Test
    void itShouldSelectCustomerByPhoneNumber() {
        //Given
        Customer customer = new Customer(UUID.randomUUID(), "Dexter","+61403562122");
        //When
        underTest.save(customer);
        //Then
        Optional<Customer> optionalCustomer = underTest.findById(customer.getId());
        assertThat(optionalCustomer).isPresent();
    }
}