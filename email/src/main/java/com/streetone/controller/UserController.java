package com.streetone.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.streetone.model.InputSubscriptionData;
import com.streetone.model.MailContext;
import com.streetone.model.RebalanceData;
import com.streetone.model.Register;
import com.streetone.model.ResultStatus;
import com.streetone.model.User;
import com.streetone.util.SendMail;

public class UserController {

    public ResultStatus sendRegisterationMail(Register register) {

        // prepare MailContext first
        MailContext context = createMailContext(register);
        try {
            SendMail.Sendmail(context);

            ResultStatus resultStatus = new ResultStatus();
            resultStatus.setStatus(true);

            User user = new User();
            user.setEmail(register.getEmail());
            user.setFirstName(register.getFirstName());
            user.setLastName(register.getLastName());

            ObjectMapper mapper = new ObjectMapper();
            resultStatus.setData(mapper.writeValueAsString(user));
            return resultStatus;
        } catch (Exception e) {

            ResultStatus resultStatus = new ResultStatus();
            resultStatus.setStatus(false);
            resultStatus.setData(null);
            return resultStatus;
        }
    }

    public ResultStatus sendAuthVerificationMail(User userData) {
        // prepare MailContext first
        MailContext context = createMailContext(userData);
        try {
            SendMail.Sendmail(context);

            ResultStatus resultStatus = new ResultStatus();
            resultStatus.setStatus(true);

            User user = new User();
            user.setEmail(userData.getEmail());

            ObjectMapper mapper = new ObjectMapper();
            resultStatus.setData(mapper.writeValueAsString(user));
            return resultStatus;
        } catch (Exception e) {

            ResultStatus resultStatus = new ResultStatus();
            resultStatus.setStatus(false);
            resultStatus.setData(null);
            return resultStatus;
        }
    }

    public ResultStatus sendForgotPasswordMail(User userData) {
        // prepare MailContext first
        MailContext context = createForgotPasswordBody(userData);
        try {
            SendMail.Sendmail(context);

            ResultStatus resultStatus = new ResultStatus();
            resultStatus.setStatus(true);

            User user = new User();
            user.setEmail(userData.getEmail());
            user.setFirstName(userData.getFirstName());
            user.setLastName(userData.getLastName());

            ObjectMapper mapper = new ObjectMapper();
            resultStatus.setData(mapper.writeValueAsString(user));
            return resultStatus;
        } catch (Exception e) {

            ResultStatus resultStatus = new ResultStatus();
            resultStatus.setStatus(false);
            resultStatus.setData(null);
            return resultStatus;
        }
    }

    public ResultStatus transferConfirmation(User userData) {
        // prepare MailContext first
        MailContext context = createTransactionDetailBody(userData);
        try {
            SendMail.Sendmail(context);

            ResultStatus resultStatus = new ResultStatus();
            resultStatus.setStatus(true);

            User user = new User();
            user.setEmail(userData.getEmail());
            user.setFirstName(userData.getFirstName());
            user.setLastName(userData.getLastName());

            ObjectMapper mapper = new ObjectMapper();
            resultStatus.setData(mapper.writeValueAsString(user));
            return resultStatus;
        } catch (Exception e) {

            ResultStatus resultStatus = new ResultStatus();
            resultStatus.setStatus(false);
            resultStatus.setData(null);
            return resultStatus;
        }
    }

    public ResultStatus rebalanceMail(RebalanceData rebalanceData) {
        // prepare MailContext first
        MailContext context = createRebalanceBody(rebalanceData);
        try {
            SendMail.Sendmail(context);

            ResultStatus resultStatus = new ResultStatus();
            resultStatus.setStatus(true);

            User user = new User();
            user.setEmail(rebalanceData.getEmail());
            user.setFirstName(rebalanceData.getFirstName());
            user.setLastName(rebalanceData.getLastName());

            ObjectMapper mapper = new ObjectMapper();
            resultStatus.setData(mapper.writeValueAsString(user));
            return resultStatus;
        } catch (Exception e) {

            ResultStatus resultStatus = new ResultStatus();
            resultStatus.setStatus(false);
            resultStatus.setData(null);
            return resultStatus;
        }
    }

    public ResultStatus sendSubscriptionMail(InputSubscriptionData inputSubscriptionData) {

        // prepare MailContext first
        MailContext context = createSubscriptionBody(inputSubscriptionData);
        try {
            SendMail.Sendmail(context);

            ResultStatus resultStatus = new ResultStatus();
            resultStatus.setStatus(true);

            User user = new User();
            user.setEmail(inputSubscriptionData.getEmail());
            user.setFirstName(inputSubscriptionData.getFirstName());
            user.setLastName(inputSubscriptionData.getLastName());

            ObjectMapper mapper = new ObjectMapper();
            resultStatus.setData(mapper.writeValueAsString(user));
            return resultStatus;
        } catch (Exception e) {

            ResultStatus resultStatus = new ResultStatus();
            resultStatus.setStatus(false);
            resultStatus.setData(null);
            return resultStatus;
        }
    }

    public ResultStatus unsubscriptionMail(InputSubscriptionData inputSubscriptionData) {
        // prepare Mail Body first
        MailContext context = createUnSubscribingBody(inputSubscriptionData);
        try {
            SendMail.Sendmail(context);

            ResultStatus resultStatus = new ResultStatus();
            resultStatus.setStatus(true);

            User user = new User();
            user.setEmail(inputSubscriptionData.getEmail());
            user.setFirstName(inputSubscriptionData.getFirstName());
            user.setLastName(inputSubscriptionData.getLastName());

            ObjectMapper mapper = new ObjectMapper();
            resultStatus.setData(mapper.writeValueAsString(user));
            return resultStatus;
        } catch (Exception e) {

            ResultStatus resultStatus = new ResultStatus();
            resultStatus.setStatus(false);
            resultStatus.setData(null);
            return resultStatus;
        }
    }

    private MailContext createMailContext(Register register) {
        MailContext mailContext = new MailContext();

        StringBuilder stringbuilderObject = new StringBuilder();
        stringbuilderObject.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
        stringbuilderObject.append("<html><div>Greetings " + register.getFirstName() + " " + register.getLastName()
                + ", </div>");
        stringbuilderObject.append("<div> Now you are registered to our site with " + register.getEmail() + ". </div>");
        stringbuilderObject.append("<div>Thanks for registering with us again.</div>");
        stringbuilderObject.append("Regards, <br>XXXX</html>");
        mailContext.setSubject("Thank you for Registeration!!");
        mailContext.setBody(stringbuilderObject.toString());
        mailContext.setToAddress(register.getEmail());

        return mailContext;
    }

    private MailContext createMailContext(User userData) {
        MailContext mailContext = new MailContext();

        StringBuilder stringbuilderObject = new StringBuilder();
        stringbuilderObject.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
        stringbuilderObject.append("<html><div>Greetings, </div>");
        stringbuilderObject.append("<div>Someone tried to log into your account. Please enter this,"
                + userData.getCode() + " authentication code to verify its you who is requesting.</div>");
        stringbuilderObject.append("Regards, <br>XXXX</html>");
        mailContext.setSubject("Auth Verification!!");
        mailContext.setBody(stringbuilderObject.toString());
        mailContext.setToAddress(userData.getEmail());

        return mailContext;
    }

    private MailContext createForgotPasswordBody(User userData) {
        MailContext mailContext = new MailContext();
        StringBuilder stringbuilderObject = new StringBuilder();
        stringbuilderObject.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
        stringbuilderObject.append("<html><div>Greetings " + userData.getFirstName() + " " + userData.getLastName()
                + ", </div>");
        stringbuilderObject.append("<div>Please follow the following instructions to retain your password.</div>");
        stringbuilderObject.append("Regards, <br>XXXX</html>");
        mailContext.setSubject("Retain Password instruction!!");
        mailContext.setBody(stringbuilderObject.toString());
        mailContext.setToAddress(userData.getEmail());

        return mailContext;
    }

    private MailContext createTransactionDetailBody(User userData) {
        MailContext mailContext = new MailContext();

        StringBuilder stringbuilderObject = new StringBuilder();
        stringbuilderObject.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
        stringbuilderObject.append("<html><div>Greetings, </div>");
        stringbuilderObject.append("<div>To Confirm your transaction, please use the following code: "
                + userData.getCode() + "</div>");
        stringbuilderObject.append("Regards, <br>XXXX</html>");
        mailContext.setSubject("Transaction Confirmation");
        mailContext.setBody(stringbuilderObject.toString());
        mailContext.setToAddress(userData.getEmail());

        return mailContext;
    }

    private MailContext createRebalanceBody(RebalanceData rebalanceData) {
        MailContext mailContext = new MailContext();

        StringBuilder stringbuilderObject = new StringBuilder();
        stringbuilderObject.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
        stringbuilderObject.append("<html><div>Greetings " + rebalanceData.getFirstName() + " "
                + rebalanceData.getLastName() + ", </div>");
        stringbuilderObject.append("<div>Your reblance ID is " + rebalanceData.getRebalanceID() + ".</div>");
        stringbuilderObject.append("Regards, <br>XXXX</html>");
        mailContext.setSubject("Account Rebalanced");
        mailContext.setBody(stringbuilderObject.toString());
        mailContext.setToAddress(rebalanceData.getEmail());

        return mailContext;
    }

    private MailContext createSubscriptionBody(InputSubscriptionData inputSubscriptionData) {
        MailContext mailContext = new MailContext();

        StringBuilder stringbuilderObject = new StringBuilder();
        stringbuilderObject.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
        stringbuilderObject.append("<html><div>Greetings " + inputSubscriptionData.getFirstName() + " "
                + inputSubscriptionData.getLastName() + ", </div>");
        stringbuilderObject.append("<div>Thanks for subscribing to us. Your sucripition ID is "
                + inputSubscriptionData.getSubscriptionID() + ".</div>");
        stringbuilderObject.append("Regards, <br>XXXX</html>");
        mailContext.setSubject("Subscription Alert!!");
        mailContext.setBody(stringbuilderObject.toString());
        mailContext.setToAddress(inputSubscriptionData.getEmail());

        return mailContext;
    }

    private MailContext createUnSubscribingBody(InputSubscriptionData inputSubscriptionData) {
        MailContext mailContext = new MailContext();

        StringBuilder stringbuilderObject = new StringBuilder();
        stringbuilderObject.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
        stringbuilderObject.append("<html><div>Dear " + inputSubscriptionData.getFirstName() + " "
                + inputSubscriptionData.getLastName() + ", </div>");
        stringbuilderObject.append("<div>Your Unsubscribing Agreement is:</div> ");
        stringbuilderObject.append("<div>" + inputSubscriptionData.getUnsubscriptionAgreement() + ".</div>");
        stringbuilderObject.append("Regards, <br>XXXX</html>");
        mailContext.setSubject("Unsubscribing Agreement");
        mailContext.setBody(stringbuilderObject.toString());
        mailContext.setToAddress(inputSubscriptionData.getEmail());

        return mailContext;
    }
}
