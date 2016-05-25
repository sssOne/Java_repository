package main.java.com.streetone.controller.impl;

import main.java.com.streetone.controller.IEmailController;
import main.java.com.streetone.email.EmailServiceImpl;
import main.java.com.streetone.model.MailContext;
import main.java.com.streetone.model.MailDTO;
import main.java.com.streetone.model.ResultStatus;
import main.java.com.streetone.model.User;
import main.java.com.streetone.util.SendMail;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The Class EmailControllerImpl.
 * 
 * @author Nilay
 */
public class EmailControllerImpl implements IEmailController {

    /** The Constant logger. */
    private static final Logger logger = Logger.getLogger(EmailServiceImpl.class);

    @Override
    public ResultStatus sendMailMethod(MailDTO mailDTO, String emailType) {
        System.out.println(emailType);
        MailContext context = null;
        User returnUser = new User();
        ResultStatus resultStatus = new ResultStatus();
        try {
            switch (emailType) {
            case "register":
                context = createRegisterMailContext(mailDTO);
                break;
            case "auth":
                context = createAuthMailContext(mailDTO);
                break;
            case "forgetpwd":
                context = createForgotPasswordBody(mailDTO);
                break;
            case "subscription":
                context = createSubscriptionBody(mailDTO);
                break;
            case "unsubscription":
                context = createUnSubscribingBody(mailDTO);
                break;
            case "transfer":
                context = createTransactionDetailBody(mailDTO);
                break;
            case "rebalance":
                context = createRebalanceBody(mailDTO);
                break;
            default:
                break;
            }

            SendMail.Sendmail(context);
            resultStatus.setStatus(true);

            if (mailDTO.getEmail() != null) {
                returnUser.setEmail(mailDTO.getEmail());
                if (mailDTO.getFirstName() != null) {
                    returnUser.setFirstName(mailDTO.getFirstName());
                }
                if (mailDTO.getLastName() != null) {
                    returnUser.setLastName(mailDTO.getLastName());
                }
            } else {
                returnUser.setEmail(mailDTO.getEmail());
                returnUser.setFirstName(mailDTO.getFirstName());
                returnUser.setLastName(mailDTO.getLastName());
            }
            ObjectMapper mapper = new ObjectMapper();
            resultStatus.setData(mapper.writeValueAsString(returnUser));
        } catch (Exception e) {
            resultStatus.setStatus(false);
            resultStatus.setData(e.getMessage());
            return resultStatus;
        }
        return resultStatus;
    }

    /**
     * Creates the register mail context.
     *
     * @param mailDTO the mail dto
     * @return the mail context
     * @throws Exception
     */
    private MailContext createRegisterMailContext(MailDTO mailDTO) throws Exception {

        if (mailDTO.getEmail() == null || mailDTO.getEmail() == "" || mailDTO.getEmail().isEmpty()) {
            throw new Exception("Email ID required.");
        }
        MailContext mailContext = new MailContext();

        StringBuilder stringbuilderObject = new StringBuilder();
        stringbuilderObject.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
        stringbuilderObject.append("<html><div>Greetings " + mailDTO.getEmail() + ", </div>");
        stringbuilderObject.append("<div> Now you are registered to our site with " + mailDTO.getEmail() + ". </div>");
        stringbuilderObject.append("<div>Thanks for registering with us again.</div>");
        stringbuilderObject.append("Regards, <br>XXXX</html>");
        mailContext.setSubject("Thank you for Registeration!!");
        mailContext.setBody(stringbuilderObject.toString());
        mailContext.setToAddress(mailDTO.getEmail());

        return mailContext;
    }

    /**
     * Creates the auth mail context.
     *
     * @param mailDTO the mail dto
     * @return the mail context
     */
    private MailContext createAuthMailContext(MailDTO mailDTO) {
        MailContext mailContext = new MailContext();

        StringBuilder stringbuilderObject = new StringBuilder();
        stringbuilderObject.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
        stringbuilderObject.append("<html><div>Greetings, </div>");
        stringbuilderObject.append("<div>Someone tried to log into your account. Please enter this,"
                + mailDTO.getCode() + " authentication code to verify its you who is requesting.</div>");
        stringbuilderObject.append("Regards, <br>XXXX</html>");
        mailContext.setSubject("Auth Verification!!");
        mailContext.setBody(stringbuilderObject.toString());
        mailContext.setToAddress(mailDTO.getEmail());

        return mailContext;
    }

    /**
     * Creates the forgot password body.
     *
     * @param mailDTO the mail dto
     * @return the mail context
     * @throws Exception 
     */
    private MailContext createForgotPasswordBody(MailDTO mailDTO) throws Exception {
        if (mailDTO.getEmail() == null || mailDTO.getEmail() == "" || mailDTO.getEmail().isEmpty()) {
            throw new Exception("Email ID required.");
        }
        MailContext mailContext = new MailContext();
        StringBuilder stringbuilderObject = new StringBuilder();
        stringbuilderObject.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
        stringbuilderObject.append("<html><div>Greetings " + mailDTO.getEmail()
                + ", </div>");
        stringbuilderObject.append("<div>Please follow the following instructions to retain your password.</div>");
        stringbuilderObject.append("Regards, <br>XXXX</html>");
        mailContext.setSubject("Retain Password instruction!!");
        mailContext.setBody(stringbuilderObject.toString());
        mailContext.setToAddress(mailDTO.getEmail());

        return mailContext;
    }

    /**
     * Creates the transaction detail body.
     *
     * @param mailDTO the mail dto
     * @return the mail context
     */
    private MailContext createTransactionDetailBody(MailDTO mailDTO) {
        MailContext mailContext = new MailContext();

        StringBuilder stringbuilderObject = new StringBuilder();
        stringbuilderObject.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
        stringbuilderObject.append("<html><div>Greetings, </div>");
        stringbuilderObject.append("<div>To Confirm your transaction, please use the following code: "
                + mailDTO.getCode() + "</div>");
        stringbuilderObject.append("Regards, <br>XXXX</html>");
        mailContext.setSubject("Transaction Confirmation");
        mailContext.setBody(stringbuilderObject.toString());
        mailContext.setToAddress(mailDTO.getEmail());

        return mailContext;
    }

    /**
     * Creates the rebalance body.
     *
     * @param mailDTO the mail dto
     * @return the mail context
     */
    private MailContext createRebalanceBody(MailDTO mailDTO) {
        MailContext mailContext = new MailContext();

        StringBuilder stringbuilderObject = new StringBuilder();
        stringbuilderObject.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
        stringbuilderObject.append("<html><div>Greetings " + mailDTO.getFirstName() + " " + mailDTO.getLastName()
                + ", </div>");
        stringbuilderObject.append("<div>Your reblance ID is " + mailDTO.getRebalanceID() + ".</div>");
        stringbuilderObject.append("Regards, <br>XXXX</html>");
        mailContext.setSubject("Account Rebalanced");
        mailContext.setBody(stringbuilderObject.toString());
        mailContext.setToAddress(mailDTO.getEmail());

        return mailContext;
    }

    /**
     * Creates the subscription body.
     *
     * @param mailDTO the mail dto
     * @return the mail context
     */
    private MailContext createSubscriptionBody(MailDTO mailDTO) {
        MailContext mailContext = new MailContext();

        StringBuilder stringbuilderObject = new StringBuilder();
        stringbuilderObject.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
        stringbuilderObject.append("<html><div>Greetings " + mailDTO.getFirstName() + " " + mailDTO.getLastName()
                + ", </div>");
        stringbuilderObject.append("<div>Thanks for subscribing to us. Your sucripition ID is "
                + mailDTO.getSubscriptionID() + ".</div>");
        stringbuilderObject.append("Regards, <br>XXXX</html>");
        mailContext.setSubject("Subscription Alert!!");
        mailContext.setBody(stringbuilderObject.toString());
        mailContext.setToAddress(mailDTO.getEmail());

        return mailContext;
    }

    /**
     * Creates the un subscribing body.
     *
     * @param mailDTO the mail dto
     * @return the mail context
     */
    private MailContext createUnSubscribingBody(MailDTO mailDTO) {
        MailContext mailContext = new MailContext();

        StringBuilder stringbuilderObject = new StringBuilder();
        stringbuilderObject.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
        stringbuilderObject.append("<html><div>Dear " + mailDTO.getFirstName() + " " + mailDTO.getLastName()
                + ", </div>");
        stringbuilderObject.append("<div>Your Unsubscribing Agreement is:</div> ");
        stringbuilderObject.append("<div>" + mailDTO.getUnsubscriptionAgreement() + ".</div>");
        stringbuilderObject.append("Regards, <br>XXXX</html>");
        mailContext.setSubject("Unsubscribing Agreement");
        mailContext.setBody(stringbuilderObject.toString());
        mailContext.setToAddress(mailDTO.getEmail());
        return mailContext;
    }

}
