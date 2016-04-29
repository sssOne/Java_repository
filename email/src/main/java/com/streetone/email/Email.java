package com.streetone.email;

/*
 * email rest service.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 *
 *  
 * 
 *
 *  
 * 
 *
 *  
 */

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Variant;

import org.apache.log4j.Logger;

import com.streetone.controller.AuthenticationEmail;
import com.streetone.controller.ForgotPasswordEmail;
import com.streetone.controller.RebalanceEmail;
import com.streetone.controller.RegistrationEmail;
import com.streetone.controller.SubscriptionEmail;
import com.streetone.controller.TransferEmail;
// model classes go here
import com.streetone.model.InputSubscriptionData;
import com.streetone.model.RebalanceData;
import com.streetone.model.Register;
import com.streetone.model.ResultStatus;
import com.streetone.model.User;

/**
 * The Class Email.
 * 
 * @author Shalaka Nayal
 */
@Path("/email/")
@Produces(MediaType.APPLICATION_JSON)
public class Email implements IEmail {

    private static final Logger logger = Logger.getLogger(Email.class);

    /*
     * (non-Javadoc)
     * 
     * @see com.streetone.email.IEmail#sendRegistrationEmail(com.streetone.model.Register)
     */
    @POST
    @Path("/register/")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response sendRegistrationEmail(Register register) {

        ResultStatus resultStatus = new RegistrationEmail().sendRegisterationMail(register);
        logger.info("" + resultStatus);
        return Response.ok(resultStatus).build();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.streetone.email.IEmail#userAuthentication(com.streetone.model.User)
     */
    @POST
    @Path("/userAuthentication/")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response userAuthentication(User user) {
        logger.info("user authentication service");
        ResultStatus resultStatus = null;
        if (user.getEmail().trim().equals("") || user.getEmail() == null) {
            return Response.notAcceptable(new ArrayList<Variant>()).build();
        } else {
            resultStatus = new AuthenticationEmail().sendAuthVerificationMail(user);
            logger.info("" + resultStatus);
            return Response.ok(resultStatus).build();
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.streetone.email.IEmail#forgotPassword(com.streetone.model.User)
     */
    @POST
    @Path("/forgotPassword/")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response forgotPassword(User user) {
        logger.info("forgotPassword service");
        ResultStatus resultStatus = null;
        if (user.getEmail().trim().equals("") || user.getEmail() == null) {
            return Response.notAcceptable(new ArrayList<Variant>()).build();
        } else {
            resultStatus = new ForgotPasswordEmail().sendForgotPasswordMail(user);
            logger.info("" + resultStatus);
            return Response.ok(resultStatus).build();
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.streetone.email.IEmail#sendSubscriptionEmail(com.streetone.model.InputSubscriptionData)
     */
    @POST
    @Path("/subscribe/")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response sendSubscriptionEmail(InputSubscriptionData inputSubscriptionData) {

        logger.info("send Subscription Email");

        ResultStatus resultStatus = new SubscriptionEmail().sendSubscriptionMail(inputSubscriptionData);
        System.out.println("" + resultStatus);
        return Response.ok(resultStatus).build();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.streetone.email.IEmail#unsubscribe(com.streetone.model.InputSubscriptionData)
     */
    @POST
    @Path("/userAuthentication/")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response unsubscribe(InputSubscriptionData inputSubscriptionData) {
        logger.info("user authentication service");
        ResultStatus resultStatus = new SubscriptionEmail().unsubscriptionMail(inputSubscriptionData);
        logger.info("" + resultStatus);
        return Response.ok(resultStatus).build();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.streetone.email.IEmail#rebalance(com.streetone.model.RebalanceData)
     */
    @POST
    @Path("/rebalance/")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response rebalance(RebalanceData rebalanceData) {
        logger.info("rebalance service");
        ResultStatus resultStatus = new RebalanceEmail().rebalanceMail(rebalanceData);
        logger.info("" + resultStatus);
        return Response.ok(resultStatus).build();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.streetone.email.IEmail#transferConfirmation(com.streetone.model.User)
     */
    @POST
    @Path("/userAuthentication/")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response transferConfirmation(User user) {
        logger.info("transfer Confirmation service");
        ResultStatus resultStatus = new TransferEmail().transferConfirmation(user);
        logger.info("" + resultStatus);
        return Response.ok(resultStatus).build();
    }
}
