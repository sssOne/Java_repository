package main.java.com.streetone.email;

import main.java.com.streetone.model.InputSubscriptionData;
import main.java.com.streetone.model.MailContext;
import main.java.com.streetone.model.ResultStatus;
import main.java.com.streetone.model.User;
import main.java.com.streetone.util.SendMail;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The Class Email.
 * 
 * @author NIRAJ
 * 
 */
public class EmailServiceImpl implements IEmailService {

    public ResultStatus sendMail(User user, InputSubscriptionData inputSubscriptionData, String type) {
        System.out.println(type);
        MailContext context = null;
        User returnUser = new User();
        ResultStatus resultStatus = new ResultStatus();
        switch (type) {
        case "register":
            context = createRegisterMailContext(user);
            break;
        case "auth":
            context = createAuthMailContext(user);
            break;
        case "forgetpwd":
            context = createForgotPasswordBody(user);
            break;
        case "subscription":
            context = createSubscriptionBody(inputSubscriptionData);
            break;
        case "unsubscription":
            context = createUnSubscribingBody(inputSubscriptionData);
            break;
        case "transfer":
            context = createTransactionDetailBody(user);
            break;
        case "rebalance":
            context = createRebalanceBody(user);
            break;
        default:
            break;
        }

        try {
            SendMail.Sendmail(context);
            resultStatus.setStatus(true);

            if (user != null) {
                returnUser.setEmail(user.getEmail());
                if (user.getFirstName() != null) {
                    returnUser.setFirstName(user.getFirstName());
                }
                if (user.getLastName() != null) {
                    returnUser.setLastName(user.getLastName());
                }
            } else {
                returnUser.setEmail(inputSubscriptionData.getEmail());
                returnUser.setFirstName(inputSubscriptionData.getFirstName());
                returnUser.setLastName(inputSubscriptionData.getLastName());
            }
            ObjectMapper mapper = new ObjectMapper();
            resultStatus.setData(mapper.writeValueAsString(returnUser));
        } catch (Exception e) {
            resultStatus.setStatus(false);
            resultStatus.setData(null);
            return resultStatus;
        }
        return resultStatus;
    }

    private MailContext createRegisterMailContext(User user) {
        MailContext mailContext = new MailContext();

        StringBuilder stringbuilderObject = new StringBuilder();
        stringbuilderObject.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
        stringbuilderObject.append("<html><div>Greetings " + user.getFirstName() + " " + user.getLastName()
                + ", </div>");
        stringbuilderObject.append("<div> Now you are registered to our site with " + user.getEmail() + ". </div>");
        stringbuilderObject.append("<div>Thanks for registering with us again.</div>");
        stringbuilderObject.append("Regards, <br>XXXX</html>");
        mailContext.setSubject("Thank you for Registeration!!");
        mailContext.setBody(stringbuilderObject.toString());
        mailContext.setToAddress(user.getEmail());

        return mailContext;
    }

    private MailContext createAuthMailContext(User userData) {
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

    private MailContext createRebalanceBody(User user) {
        MailContext mailContext = new MailContext();

        StringBuilder stringbuilderObject = new StringBuilder();
        stringbuilderObject.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
        stringbuilderObject.append("<html><div>Greetings " + user.getFirstName() + " " + user.getLastName()
                + ", </div>");
        stringbuilderObject.append("<div>Your reblance ID is " + user.getRebalanceID() + ".</div>");
        stringbuilderObject.append("Regards, <br>XXXX</html>");
        mailContext.setSubject("Account Rebalanced");
        mailContext.setBody(stringbuilderObject.toString());
        mailContext.setToAddress(user.getEmail());

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
