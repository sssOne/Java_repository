package main.java.com.streetone.controller;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import main.java.com.streetone.model.InputSubscriptionData;
import main.java.com.streetone.model.User;

/**
 * The Interface IEmailController.
 * 
 * @author NIRAJ
 */
@Path("/")
@WebService(name = "emailService")
public interface IEmailController {

    /**
     * Send registration email.
     * 
     * @param user the user
     * @return the response
     */
    @POST
    @Path("/register/")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    Response doRegistration(User user);

    /**
     * Send subscription email.
     * 
     * @param inputSubscriptionData the input subscription data
     * @return the response
     */

    @POST
    @Path("/subscribe/")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    Response sendSubscriptionEmail(InputSubscriptionData inputSubscriptionData);

    /**
     * User authentication.
     * 
     * @param user the user
     * @return the response
     */

    @POST
    @Path("/userAuthentication/")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    Response userAuthentication(User user);

    /**
     * Unsubscribe.
     * 
     * @param inputSubscriptionData the input subscription data
     * @return the response
     */
    @POST
    @Path("/unsubscribe/")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    Response unsubscribe(InputSubscriptionData inputSubscriptionData);

    /**
     * Forgot password.
     * 
     * @param user the user
     * @return the response
     */
    @POST
    @Path("/forgotPassword/")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    Response forgotPassword(User user);

    /**
     * Rebalance.
     * 
     * @param user the user
     * @return the response
     */
    @POST
    @Path("/rebalance/")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    Response rebalance(User user);

    /**
     * Transfer confirmation.
     * 
     * @param user the user
     * @return the response
     */
    @POST
    @Path("/dotransfer/")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    Response transferConfirmation(User user);
}
