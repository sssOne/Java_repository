package main.java.com.streetone.email;

import main.java.com.streetone.model.InputSubscriptionData;
import main.java.com.streetone.model.ResultStatus;
import main.java.com.streetone.model.User;

/**
 * The Interface IEmail.
 * 
 * @author NIRAJ
 * 
 */

public interface IEmailService {

    /**
     * Send registration email.
     *
     * @param user the user
     * @param inputSubscriptionData the input subscription data
     * @param type the type
     * @return the response
     */
    ResultStatus sendMail(User user, InputSubscriptionData inputSubscriptionData, String type);

}
