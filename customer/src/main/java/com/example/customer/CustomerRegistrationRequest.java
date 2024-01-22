package com.example.customer;

/**
 * @author Choco Lee
 */
public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {

}
