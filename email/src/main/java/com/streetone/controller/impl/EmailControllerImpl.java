package main.java.com.streetone.controller.impl;

import java.util.ArrayList;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Variant;

import main.java.com.streetone.controller.IEmailController;
import main.java.com.streetone.email.EmailServiceImpl;
import main.java.com.streetone.email.IEmailService;
import main.java.com.streetone.model.InputSubscriptionData;
import main.java.com.streetone.model.ResultStatus;
import main.java.com.streetone.model.User;

import org.apache.log4j.Logger;

/**
 * The Class EmailControllerImpl.
 * 
 * @author NIRAJ
 */
@Path("/email/")
@Produces(MediaType.APPLICATION_JSON)
public class EmailControllerImpl implements IEmailController {

    /** The Constant logger. */
    private static final Logger logger = Logger.getLogger(EmailServiceImpl.class);

    /** The email. */
    IEmailService email = new EmailServiceImpl();

    public Response doRegistration(User user) {
        ResultStatus resultStatus = email.sendMail(user, null, "register");
        logger.info("HERE" + resultStatus);
        return Response.ok(resultStatus).build();
    }

    public Response userAuthentication(User user) {
        logger.info("user authentication service");
        ResultStatus resultStatus = null;
        if (user.getEmail().trim().equals("") || user.getEmail() == null) {
            return Response.notAcceptable(new ArrayList<Variant>()).build();
        } else {
            resultStatus = email.sendMail(user, null, "auth");
            logger.info("" + resultStatus);
            return Response.ok(resultStatus).build();
        }
    }

    public Response forgotPassword(User user) {
        logger.info("forgotPassword service");
        ResultStatus resultStatus = null;
        if (user.getEmail().trim().equals("") || user.getEmail() == null) {
            return Response.notAcceptable(new ArrayList<Variant>()).build();
        } else {
            resultStatus = email.sendMail(user, null, "forgetpwd");
            logger.info("" + resultStatus);
            return Response.ok(resultStatus).build();
        }

    }

    public Response sendSubscriptionEmail(InputSubscriptionData inputSubscriptionData) {
        logger.info("send Subscription Email");
        ResultStatus resultStatus = email.sendMail(null, inputSubscriptionData, "subscription");
        System.out.println("" + resultStatus);
        return Response.ok(resultStatus).build();
    }

    public Response unsubscribe(InputSubscriptionData inputSubscriptionData) {
        logger.info("user authentication service");
        ResultStatus resultStatus = email.sendMail(null, inputSubscriptionData, "unsubscription");
        logger.info("" + resultStatus);
        return Response.ok(resultStatus).build();
    }

    public Response rebalance(User user) {
        logger.info("rebalance service");
        ResultStatus resultStatus = email.sendMail(user, null, "rebalance");
        logger.info("" + resultStatus);
        return Response.ok(resultStatus).build();
    }

    public Response transferConfirmation(User user) {
        logger.info("transfer Confirmation service");
        ResultStatus resultStatus = email.sendMail(user, null, "transfer");
        logger.info("" + resultStatus);
        return Response.ok(resultStatus).build();
    }

}
