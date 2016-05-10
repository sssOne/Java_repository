package main.java.com.streetone.email;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import main.java.com.streetone.controller.IEmailController;
import main.java.com.streetone.controller.impl.EmailControllerImpl;
import main.java.com.streetone.model.MailDTO;
import main.java.com.streetone.model.ResultStatus;

import org.apache.log4j.Logger;

/**
 * The Class EmailServiceImpl.
 * 
 * @author Nilay
 */
@Path("/email/")
@Produces(MediaType.APPLICATION_JSON)
public class EmailServiceImpl implements IEmailService {

    /** The Constant logger. */
    private static final Logger logger = Logger.getLogger(EmailServiceImpl.class);

    /** The email. */
    IEmailController email = new EmailControllerImpl();

    @Override
    public Response sendMail(MailDTO mailDTO, String emailType) {
        System.out.println("sendMail service invoked");
        ResultStatus resultStatus = email.sendMailMethod(mailDTO, emailType);
        logger.info("" + resultStatus);
        return Response.ok(resultStatus).build();
    }

}
