package main.java.com.streetone.model;

public class InputSubscriptionData {

    public String firstName;
    public String lastName;
    public String email;
    public String subscriptionID;
    public String subscriptionAgreement;
    public String unsubscriptionAgreement;

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

    public String getSubscriptionAgreement() {
        return subscriptionAgreement;
    }

    public void setSubscriptionAgreement(String subscriptionAgreement) {
        this.subscriptionAgreement = subscriptionAgreement;
    }

    public String getUnsubscriptionAgreement() {
        return unsubscriptionAgreement;
    }

    public void setUnsubscriptionAgreement(String unsubscriptionAgreement) {
        this.unsubscriptionAgreement = unsubscriptionAgreement;
    }

    @Override
    public String toString() {
        return "firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", subscriptionID="
                + subscriptionID;
    }

}
