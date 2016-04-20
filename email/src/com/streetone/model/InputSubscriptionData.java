package com.streetone.model;

public class InputSubscriptionData {
    //
    // input will contain the details for sending a subscription email.
    // .
    // - first name .
    // - last name
    // - email address.
    // - fields associated with subscription contract
    //
    // this method should call a controller class SubscriptionEmail
    //
    // response will be a json object.

    public String firstName;
    public String lastName;
    public String email;
    public String subscriptionID;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubscriptionID() {
        return subscriptionID;
    }

    public void setSubscriptionID(String subscriptionID) {
        this.subscriptionID = subscriptionID;
    }

    @Override
    public String toString() {
        return "firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", subscriptionID="
                + subscriptionID;
    }

}
