package com.streetone.model;

public class RebalanceData {
    public String firstName;
    public String lastName;
    public String email;
    public String rebalanceID;

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

    public String getRebalanceID() {
        return rebalanceID;
    }

    public void setRebalanceID(String rebalanceID) {
        this.rebalanceID = rebalanceID;
    }

    @Override
    public String toString() {
        return "RebalanceData [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
                + ", rebalanceID=" + rebalanceID + "]";
    }
}
