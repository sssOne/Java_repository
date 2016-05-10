package main.java.com.streetone.model;

public class MailDTO {
    public String email;
    public String firstName;
    public String lastName;
    public String code;
    public String phoneNo;
    public String rebalanceID;

    // inputsubscription
    public String subscriptionID;
    public String subscriptionAgreement;
    public String unsubscriptionAgreement;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getRebalanceID() {
        return rebalanceID;
    }

    public void setRebalanceID(String rebalanceID) {
        this.rebalanceID = rebalanceID;
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
        return "MailDTO [email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", code=" + code
                + ", phoneNo=" + phoneNo + ", rebalanceID=" + rebalanceID + ", subscriptionID=" + subscriptionID
                + ", subscriptionAgreement=" + subscriptionAgreement + ", unsubscriptionAgreement="
                + unsubscriptionAgreement + "]";
    }

}
