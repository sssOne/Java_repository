package main.java.com.streetone.email;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import main.java.com.streetone.model.MailDTO;

/**
 * The Interface IEmailService.
 * 
 * @author Nilay
 */
@Path("/")
@WebService(name = "emailService")
public interface IEmailService {

    /**
     * Send mail.
     *
     * @param mailDTO the mail dto
     * @param emailType the email type
     * @return the response
     */
    @POST
    @Path("/domail/")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    Response sendMail(MailDTO mailDTO, @QueryParam("emailType") String emailType);

}
