package com.streetone.email;

import javax.jws.WebService;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.streetone.model.InputSubscriptionData;
import com.streetone.model.RebalanceData;
import com.streetone.model.Register;
import com.streetone.model.User;

/**
 * The Interface IEmail.
 * 
 * @author Shalaka Nayal
 */
@Path("/")
@WebService(name = "emailService")
public interface IEmail {

    /**
     * Send registration email.
     *
     * @param register the register
     * @return the response
     */
    Response sendRegistrationEmail(Register register);

    /**
     * Send subscription email.
     *
     * @param inputSubscriptionData the input subscription data
     * @return the response
     */
    Response sendSubscriptionEmail(InputSubscriptionData inputSubscriptionData);

    /**
     * User authentication.
     *
     * @param user the user
     * @return the response
     */
    Response userAuthentication(User user);

    /**
     * Unsubscribe.
     *
     * @param inputSubscriptionData the input subscription data
     * @return the response
     */
    Response unsubscribe(InputSubscriptionData inputSubscriptionData);

    /**
     * Forgot password.
     *
     * @param user the user
     * @return the response
     */
    Response forgotPassword(User user);

    /**
     * Rebalance.
     *
     * @param rebalanceData the rebalance data
     * @return the response
     */
    Response rebalance(RebalanceData rebalanceData);

    /**
     * Transfer confirmation.
     *
     * @param user the user
     * @return the response
     */
    Response transferConfirmation(User user);
}
