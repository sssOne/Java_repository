package main.java.com.streetone.controller;

import main.java.com.streetone.model.MailDTO;
import main.java.com.streetone.model.ResultStatus;

/**
 * The Interface IEmailController.
 * 
 * @author Nilay
 */
public interface IEmailController {

    /**
     * Send mail method.
     *
     * @param mailDTO the mail dto
     * @param emailType the email type
     * @return the result status
     */
    ResultStatus sendMailMethod(MailDTO mailDTO, String emailType);
}
